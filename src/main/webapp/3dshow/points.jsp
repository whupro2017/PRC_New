<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<script src="../3dshow/libs/three.js"></script>
	<script src="../3dshow/libs/OrbitControls.js"></script>
	<script src="../3dshow/libs/PLYLoader.js"></script>
	<script src="../3dshow/libs/Detector.js"></script>
	<script src="../3dshow/libs/stats.min.js"></script>

	<div>
		<script type="text/javascript">
			var container, stats;
			var camera, scene, renderer, particles, geometry, material, i, h, color, sprite, size;
			var mouseX = 0, mouseY = 0;

			var width = window.innerWidth;
			var height = 1000;
			console.log("#####width:"+width+"  height:"+height);
			
			var windowHalfX = width / 2;
			var windowHalfY = height / 2;
						
			jQuery(function($) {
				$('#ShowPoints').on('click', function() {
					var minx = $(".minx").val();
					var miny = $(".miny").val();
					var minz = $(".minz").val();
					var maxx = $(".maxx").val();
					var maxy = $(".maxy").val();
					var maxz = $(".maxz").val();
					var cenx = $(".cenx").val();
					var ceny = $(".ceny").val();
					var cenz = $(".cenz").val();
					var level = $("#level").val();
				
					console.log("##############show points input"+minx+","+miny+","+minz+","+maxx+","+maxy+","+maxz+","+level);
									    	
					$.ajax({
						async: false,
						cache: false,
						type: 'POST',
						datatype: 'json',
						url:'/pro/PointsController/getAllPoints?minx=' + minx + '&miny=' + miny +  '&minz=' + minz 
							+ '&maxx=' + maxx + '&maxy=' + maxy + '&maxz=' + maxz
							+ '&level=' + level,
						error: function(){
							alert("失败");
						},
						success: function(data){
							console.log("data count:"+data.length);
							console.log("the first test:"+data[0]);
					    	
							geometry = new THREE.Geometry();
							for (var i = 0; i < data.length; i++) {
								var row = data[i];
						        var totalPoints = row.length / (DATA_LENGTH);
						        for (var i = 0; i < totalPoints; i++) {
						            var offset = DATA_LENGTH * i;
						            ByteBuffer buf = ByteBuffer.wrap(binary, offset + 0 * FLOAT_LENGTH, FLOAT_LENGTH);
						            var x = buf.getFloat();
						            buf = ByteBuffer.wrap(binary, offset + 1 * FLOAT_LENGTH, FLOAT_LENGTH);
						            var y = buf.getFloat();
						            buf = ByteBuffer.wrap(binary, offset + 2 * FLOAT_LENGTH, FLOAT_LENGTH);
						            var z = buf.getFloat();
									vertex.x = x;
									vertex.y = y;
									vertex.z = z;
									geometry.vertices.push(vertex);
						        }
							/* for (var i = 0; i < data.length; i++) {
								var row = data[i];
								if (row.length) {
									var point = row.split(';');
									for(var j = 0; j < point.length; j++){
										var pp = point[j].split(',');
										// arr[i] = parseFloat(data[0]);
										var vertex = new THREE.Vector3();
										vertex.x = parseFloat(pp[0]);
										vertex.y = parseFloat(pp[1]);
										vertex.z = parseFloat(pp[2]);
										geometry.vertices.push(vertex);
									}
								}*/
							}
							init(cenx, ceny, cenz);
							animate();
						}
					})
				});
			});
									    
			function init(x, y, z) {
				container = document.createElement( 'div' );
				document.body.appendChild( container );

				camera = new THREE.PerspectiveCamera( 55, width / height, 2, 2000 );
		        camera.position.z=200;

				scene = new THREE.Scene();
				scene.fog = new THREE.FogExp2( 0x000000, 0.001 );
				//light = new THREE.PointLight(0xffffff);
		        //light.position.set(windowHalfX,windowHalfY,200);
		        //scene.add(light);
		        //scene.add(new THREE.AmbientLight(0x333333));
		        
		        //camera.lookAt(scene.position);

				material = new THREE.PointsMaterial({
					size: 2,
					// map: sprite,
					sizeAttenuation: false,
					alphaTest: 0.5,
					transparent: true
				});
								
				var particles = new THREE.Points(geometry, material);
				particles.position.x -= parseFloat(x);
				particles.position.y -= parseFloat(y);
				particles.position.z -= parseFloat(z);
				scene.add(particles);
				
				renderer = new THREE.WebGLRenderer();
				renderer.setPixelRatio( window.devicePixelRatio );
				renderer.setSize(width / 2, height / 2);
				container.appendChild( renderer.domElement );

				stats = new Stats();
				container.appendChild( stats.dom );
								        	
				var controls = new THREE.OrbitControls(camera);
				controls.addEventListener('change', renderer);
				window.addEventListener( 'resize', onWindowResize, false );
			}

			function onWindowResize() {

				windowHalfX = width / 2;
				windowHalfY = height / 2;

				camera.aspect = width / height;
				camera.updateProjectionMatrix();

				renderer.setSize(width, height);

			}

			function onDocumentMouseMove( event ) {

				mouseX = event.clientX - windowHalfX;
				mouseY = event.clientY - windowHalfY;

			}

			function onDocumentTouchStart( event ) {

				if ( event.touches.length == 1 ) {

					event.preventDefault();

					mouseX = event.touches[ 0 ].pageX - windowHalfX;
					mouseY = event.touches[ 0 ].pageY - windowHalfY;

				}
			}

			function onDocumentTouchMove( event ) {

				if ( event.touches.length == 1 ) {

					event.preventDefault();

					mouseX = event.touches[ 0 ].pageX - windowHalfX;
					mouseY = event.touches[ 0 ].pageY - windowHalfY;

				}

			}

			function animate() {

				requestAnimationFrame( animate );

				render();
				stats.update();

			}

			function render() {
				renderer.render( scene, camera );
			}
		</script>
	</div>

</body>
</html>