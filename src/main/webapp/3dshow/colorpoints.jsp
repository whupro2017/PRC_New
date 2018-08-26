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
			var FLOAT_LENGTH = 4;
			var SHORT_LENGTH = 2;
			var DATA_LENGTH = FLOAT_LENGTH * 4 + SHORT_LENGTH * 3;
						
			jQuery(function($) {
				$('#ShowColorPoints').on('click', function() {
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
					var max_level = 17;
				
					console.log("##############show color points input"+minx+","+miny+","+minz+","+maxx+","+maxy+","+maxz+","+level);
									    	
					$.ajax({
						async: false,
						cache: false,
						type: 'POST',
						datatype: 'json',
						url:'/pro/PointsController/getAllColorPoints?minx=' + minx + '&miny=' + miny +  '&minz=' + minz 
							+ '&maxx=' + maxx + '&maxy=' + maxy + '&maxz=' + maxz
							+ '&level=' + level + '&maxLevel=' + max_level,
						error: function(){
							alert("失败");
						},
						success: function(data){
							console.log("data count:" + data.length);
							//console.log("the first test:"+data[0]);
							console.log("the first test:"+data[0].x+"|"+data[0].y+"|"+data[0].z+"|"+data[0].r+"|"+data[0].g+"|"+data[0].b);
					    	var date1 = new Date();
							geometry = new THREE.Geometry();
							for (var i = 0; i < data.length; i++) {
								var row = data[i];
								var vertex = new THREE.Vector3(data[i].x, data[i].y, data[i].z);
								var color = new THREE.Color(data[i].r/255, data[i].g/255, data[i].b/255);
								//if (row.length) {
									//var point = row.split(';');
									//for(var j = 0; j < point.length; j++){
										//var pp = point[j].split(',');
										//var pp = row.split(',');
										// arr[i] = parseFloat(data[0]);
										//var vertex = new THREE.Vector3(parseFloat(pp[0]),  parseFloat(pp[1]),  parseFloat(pp[2]));
										//var color = new THREE.Color(parseFloat(pp[3]) / 255, parseFloat(pp[4]) / 255, parseFloat(pp[5]) /255);
										//console.log("x: " + parseFloat(pp[0]) + "y: " + parseFloat(pp[1]) + "z: " + parseFloat(pp[2]), "r: " + parseFloat(pp[3]) / 255 + "g: " + parseFloat(pp[4]) / 255 + "b: " + parseFloat(pp[5]) / 255);
										geometry.vertices.push(vertex);
										geometry.colors.push(color);
									//}
								//}
							}
							var date2 = new Date();
							//for (var k = 0; k < data.length; k++) {
								/* var row = data[k];
						        var totalPoints = row.length / (DATA_LENGTH);
								console.log("item: " + k + " len: " + row.length + " count: " + totalPoints);
								var offset = 0;
					        	var start = offset + 0 * FLOAT_LENGTH + 8;
					        	var triBuff = row.slice(start, start + 3 * FLOAT_LENGTH);
					        	var triFloatBuff = new Float32Array(triBuff);
					        	console.log("x: " + triFloatBuff[0] + " y: " + triFloatBuff[1] + " z: " + triFloatBuff[2]); */
						        /* for (var i = 0; i < totalPoints; i++) {
						        	var offset = DATA_LENGTH * i;
						        	var start = offset + 0 * FLOAT_LENGTH;
						        	var triBuff = row.slice(offset, offset + 3 * FLOAT_LENGTH);
						        	var triFloatBuff = new Float32Array(triBuff);
						        	var vertex = new THREE.Vector3(triFloatBuff[0], triFloatBuff[1], triFloatBuff[2]);
						        	//console.log("x: " + triFloatBuff[0] + " y: " + triFloatBuff[1] + " z: " + triFloatBuff[2]);
						        	var intBuff = row.slice(offset + 4 * FLOAT_LENGTH, offset + 4 * FLOAT_LENGTH + 3 * SHORT_LENGTH);
						        	var triInt16Buff = new Int16Array(intBuff);
									var color = new THREE.Color(triInt16Buff[0], triInt16Buff[1], triInt16Buff[2]);
						        	//console.log("r: " + triInt16Buff[0] + " g: " + triInt16Buff[1] + " b: " + triInt16Buff[2]);
									geometry.vertices.push(vertex);
									geometry.colors.push(color);
						        } */
							//}
							init(cenx, ceny, cenz);
							var date3 = new Date();
							animate();
							var date4 = new Date();
							console.log("time1:"+(date2.getTime()-date1.getTime())+"time2:"+(date3.getTime()-date2.getTime())+"time3:"+(date4.getTime()-date3.getTime()))
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
					size: 4,
					// map: sprite,
					vertexColors: THREE.VertexColors,
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