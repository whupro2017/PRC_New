<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>points</title>
</head>

<body>
	<script src="../3dshow/libs/three.js"></script>
	<script src="../3dshow/libs/OrbitControls.js"></script>
	<script src="../3dshow/libs/PLYLoader.js"></script>
	<script src="../3dshow/libs/Detector.js"></script>
	<script src="../3dshow/libs/OBJLoader.js"></script>
	<script src="../3dshow/libs/MTLLoader.js"></script>

	<div>
		<script type="text/javascript">
			var count_max = 50000;
			var step_level = 1.1;
			var judge_num = 512;
			var container, camera, scene, renderer;
			var particles,particles_judge, particles_minmax;
			var geometry, geometry_judge, geometry_minmax;
			var vec_judge;
			var material, i, h, color, sprite, size;
			var mesh_f, loader, mtlloader;
			
			var width = window.innerWidth;
			var height = 900;
			
			var windowHalfX = width / 2;
			var windowHalfY = height / 2;
			
			var dis_ori, dis_now, dis_step;
			var min_level = 10; max_level = 17;			
			
			var minx, miny,  maxz,maxx, maxy,minz, cenx, ceny, cenz, level;
			var old_cx, old_cy, old_cz,new_cx, new_cy, new_cz,true_cx, true_cy, true_cz;
	        var new_minx, new_miny, new_maxz,new_maxz,new_maxy,new_minz;	
	        var len_x, len_y,len_z;

			var geo_old, geo_new, geo_true;
	        var par_old, par_new, par_true;

	        initScence();   						
						
			jQuery(function($) {
				$('#ShowPoints').on('click', function() {
					minx = $(".minx").val();
					miny = $(".miny").val();
					minz = $(".minz").val();
					maxx = $(".maxx").val();
					maxy = $(".maxy").val();
					maxz = $(".maxz").val();
					cenx = $(".cenx").val();
					ceny = $(".ceny").val();
					cenz = $(".cenz").val();
					level = $("#level").val();

					len_x = Math.abs(maxx - minx);
					len_y = Math.abs(maxy - miny);
					len_z = Math.abs(maxz - minz);					

					var count_point = 0;
					
					console.log("##############show points input"+minx+","+miny+","+minz+","+maxx+","+maxy+","+maxz+","+level);
									    	
					$.ajax({
						async: false,
						cache: false,
						type: 'POST',
						datatype: 'json',
						url:'/pro/PointsController/getAllColorPoints?minx=' + minx + '&miny=' + miny +  '&minz=' + minz 
							+ '&maxx=' + maxx + '&maxy=' + maxy + '&maxz=' + maxz
							+ '&level=' + level,
						error: function(){
							alert("失败");
						},
						success: function(data){
							console.log("data count:" + data.length);
							console.log("the first test:"+data[0].x+"|"+data[0].y+"|"+data[0].z);
					    	
							geometry = new THREE.Geometry();
							geometry_minmax = new THREE.Geometry();
							geometry_judge = new THREE.Geometry();

							var vertex1 = new THREE.Vector3(minx-cenx, miny-ceny, maxz-cenz);
							geometry_minmax.vertices.push(vertex1);
							geometry_minmax.colors.push(new THREE.Color(255/255, 0/255, 0/255));
							vertex1 = new THREE.Vector3(maxx-cenx, maxy-ceny, minz-cenz);
							geometry_minmax.vertices.push(vertex1);
							geometry_minmax.colors.push(new THREE.Color(255/255, 0/255, 0/255));

							vec_judge = new Array();							
							var color_judge = new THREE.Color(0/255, 255/255, 0/255);
							var x = 0, y = 0, z = 0;
							for(var i=0; i<judge_num;i++){
								var row = data[i];
								var vertex = new THREE.Vector3(data[i].x-cenx, data[i].y-ceny, data[i].z-cenz);
								x+=data[i].x-cenx; y+=data[i].y-ceny; z+=data[i].z-cenz;			
								vec_judge.push(vertex);
								geometry_judge.vertices.push(vertex);
								geometry_judge.colors.push(color_judge);
							}
							old_cx = x/judge_num; old_cy = y/judge_num; old_cz = z/judge_num;
							new_cx = old_cx; new_cy = old_cy; new_cz = old_cz;						
							true_cx = old_cx; true_cy = old_cy; true_cz = old_cz;																			
							for (var i = judge_num-1; i < data.length; i++) {
								count_point ++;
								if(count_point > count_max){
									break;
								}
								var row = data[i];
								var vertex = new THREE.Vector3(data[i].x, data[i].y, data[i].z);
								var color = new THREE.Color(data[i].r/255, data[i].g/255, data[i].b/255);
								geometry.vertices.push(vertex);
								geometry.colors.push(color);
							}					
							addPoint(cenx, ceny, cenz,level);
						}
					})
				});
				
				$('#ShowObj').on('click', function() {
					show_obj();					
				});
				
				$('#HideObj').on('click', function() {
					remove_obj();
				});				

				$('#Clear').on('click', function() {
					clearScence();				
				});

				$('#showlayout').on('click', function() {
					show_layout();				
				});

				$('#deletelayout').on('click', function() {
					remove_layout();				
				});
				
			});
				
			function initScence() {
				container = document.createElement( 'div' );
				document.body.appendChild( container );
				
		        scene = new THREE.Scene();//场景
                light = new THREE.PointLight(0xffffff);
                light.position.set(300, 400, 200);
                scene.add(light);
                scene.add(new THREE.AmbientLight(0x333333));
               
                camera = new THREE.PerspectiveCamera(40, width / height, 0.1, 20000);//相机
                camera.position.set(0, 0, 500);
                camera.lookAt(0, 0, 1);               				
									            
				renderer = new THREE.WebGLRenderer();
				renderer.setPixelRatio( window.devicePixelRatio );
				renderer.setSize(width / 2, height / 2);
				container.appendChild( renderer.domElement );
						
				dis_ori = Math.pow((camera.position.x*camera.position.x +
		                camera.position.y*camera.position.y +
		                camera.position.z*camera.position.z) , 1/2);	
		        dis_step = dis_ori / 8;			
				
				var controls = new THREE.OrbitControls(camera);
				controls.addEventListener('change', renderer);
				document.addEventListener( 'mouseup', onDocumentMouseUp, false );
				// window.addEventListener( 'resize', onWindowResize, false );
				window.addEventListener('wheel', onDocumentMouseWheel, true);
				animate();
			}

			function clearScence(){
				scene.remove(particles);
				scene.remove(particles_judge);
				scene.remove(particles_minmax);
				scene.remove(mesh_f);
				// scene.remove(par_true);
				// scene.remove(par_old);
				// scene.remove(par_new);
				render();
				animate();
			}

			function addPoint(x,y,z,level){
				// point:
				material = new THREE.PointsMaterial({
					size: 3,
					vertexColors: THREE.VertexColors,
					sizeAttenuation: false,
					alphaTest: 0.5,
					transparent: true
				});												
				particles = new THREE.Points(geometry, material);
				particles.position.x -= parseFloat(x);
				particles.position.y -= parseFloat(y);
				particles.position.z -= parseFloat(z);
				scene.add(particles);

				// judge:
				var material_judge = new THREE.PointsMaterial({
					size: 1,
					vertexColors: THREE.VertexColors,
					sizeAttenuation: false,
					alphaTest: 0.5,
					transparent: true
				});
				particles_judge = new THREE.Points(geometry_judge, material_judge);
				scene.add(particles_judge);

				//bound
				var material_minmax = new THREE.PointsMaterial({
					size: 5,
					vertexColors: THREE.VertexColors,
					sizeAttenuation: false,
					alphaTest: 0.5,
					transparent: true
				});								
				particles_minmax = new THREE.Points(geometry_minmax, material_minmax);
				scene.add(particles_minmax);

				// obj
				var level_o = level;
				if(level<13)
					level_o = 13;
				else if (level > 15)
					level_o = 15;	
				var pathf = '../3dshow/doc/';
	            var pathm = 'house.mtl';
	            var path = 'steps-' + level_o + '.obj';
	            load_obj(pathf,pathm,path, 1,0,x,y,z);
	            render();
	            animate();
			}

			function show_obj(){
	            scene.add(mesh_f);
	            animate();
	        }

			function remove_obj(){
	            scene.remove(mesh_f);
	            animate();
	        }

	        function show_layout(){
				scene.add(particles_judge);
				scene.add(particles_minmax);
				animate();
	        }

	        function remove_layout(){
	        	scene.remove(particles_judge);
				scene.remove(particles_minmax);
				animate();
	        }

			function load_obj(pathf,pathm,path1, size, rotation,x,y,z) {
	            mtlloader = new THREE.MTLLoader();
	            mtlloader.setPath(pathf);
	            mtlloader.load(pathm, function () {
	                loader = new THREE.OBJLoader();
	                loader.setPath(pathf);
	                loader.load(path1, function (Object) {
	                    Object.scale.set(size, size, size);
	                    Object.rotation.x = THREE.Math.degToRad(rotation);
	                    mesh_f = Object;
	                    mesh_f.position.x -= x;
	                    mesh_f.position.y -= y;
	                    mesh_f.position.z -= z;
	                    mesh_f.value = pathm;
	                })
	            });
	        }	

			function juli(){
	            dis_now = Math.pow((camera.position.x*camera.position.x +
	                camera.position.y*camera.position.y +
	                camera.position.z*camera.position.z) , 1/2);
	        }
			
			function update_level(){
	            juli();
	            var le = document.getElementById('level').value;	            
	            var K = (dis_ori-dis_now) / dis_step ;
	            level = 10 + Math.floor(K);
	            if(level > 17)
	            		level = 17;
	            		else if(level < 10)
	            			level = 10

	            if(le != level){	            		            	
	                if(le < level){
	                	len_x = len_x/step_level;
	                	len_y = len_y/step_level;
	                	len_z = len_z/step_level;	                	
	                }else{
	                	len_x = len_x*step_level;
	                	len_y = len_y*step_level;
	                	len_z = len_z*step_level;	
	                }

	                updateText();
	                document.getElementById('level').value=level;

	                le = level;
	                clearScence();
					jQuery(function($) {
						$('#ShowPoints').trigger('click');
						console.log("button click")						
					});
					
	            }
	        }
			
			function updateText(){
				new_minx = parseFloat(old_cx) - parseFloat(len_x/2) + parseFloat(cenx);
				new_miny = parseFloat(old_cy) - parseFloat(len_y/2) + parseFloat(ceny);
				new_minz = parseFloat(old_cz) - parseFloat(len_z/2) + parseFloat(cenz);
				new_maxx = parseFloat(old_cx) + parseFloat(len_x/2) + parseFloat(cenx);
				new_maxy = parseFloat(old_cy) + parseFloat(len_y/2) + parseFloat(ceny);
				new_maxz = parseFloat(old_cz) + parseFloat(len_z/2) + parseFloat(cenz);
				
	            document.getElementById('minx').value=new_minx ;
	            document.getElementById('miny').value=new_miny ;
	            document.getElementById('maxz').value=new_maxz ;	            
	            document.getElementById('maxx').value=new_maxx ;
	            document.getElementById('maxy').value=new_maxy ;
	            document.getElementById('minz').value=new_minz ;
			}

			function isInView(vector){
	            //check if within camera's view:
	            camera.updateMatrix(); // make sure camera's local matrix is updated
	            camera.updateMatrixWorld(); // make sure camera's world matrix is updated
	            camera.matrixWorldInverse.getInverse( camera.matrixWorld );
	            var frustum = new THREE.Frustum();
	            frustum.setFromMatrix( new THREE.Matrix4().multiplyMatrices( camera.projectionMatrix, camera.matrixWorldInverse ) );
	            if(frustum.containsPoint(vector)) {
	                return true;
	            } else {
	                return false;
	            }
	        }
			
			function compute_centor(vec_array){
	            var x = 0, y=0, z=0;
	            var len = vec_array.length;
	            for(var j = 0; j < len ;j++){
	                x += vec_array[j].x;	y += vec_array[j].y;	z += vec_array[j].z;
	            }
	            new_cx = x/(len);	new_cy = y/(len);	new_cz = z/(len);
	            true_cx = new_cx * 2 - old_cx;
	            true_cy = new_cy * 2 - old_cy;
	            true_cz = new_cz * 2 - old_cz;
	        }

			function CountInAndPrint(){
				var count = 0;
				vector_in_view = new Array()
	            for(var j=0;j<judge_num;j++){
	                if( isInView(vec_judge[j]) ){
	                    vector_in_view.push(vec_judge[j]);	count += 1;
	                }
	            }
	            //alert("视野中点的数量:" +count +" of " +  num);
	            compute_centor(vector_in_view);
	            //alert("原来中心点的位置：" + old_cx + ";" + old_cy + ";" + old_cz);
	            //alert("新的中心点的位置：" + new_cx + ";" + new_cy + ";" + new_cz);
	            //alert("校正中心点的位置：" + true_cx + ";" + true_cy + ";" + true_cz);

	            var j_x = Math.abs(true_cx - old_cx),	j_y = Math.abs(true_cy - old_cy),	j_z =Math.abs(true_cy - old_cy);
	            if(j_x>0 || j_y>0 || j_z>0){
	            	alert("矫正：" + j_x + ";" + j_y + ";" + j_z)

		            var material1 = new THREE.PointsMaterial({
		                size: 10,
		                vertexColors: THREE.VertexColors,
		                sizeAttenuation: false,
		                alphaTest: 0.5,
		                transparent: true
		            });
		            var vec = new THREE.Vector3(old_cx,old_cy,old_cz)
		            geo_old = new THREE.Geometry();
		            geo_old.vertices.push(vec);
		            geo_old.colors.push(new THREE.Color(255/255, 255/255, 0/255)); //yellow
		            par_old = new THREE.Points(geo_old, material1);
		            scene.add(par_old);

		            vec = new THREE.Vector3(new_cx,new_cy,new_cz)
		            geo_new = new THREE.Geometry();
		            geo_new.vertices.push(vec);
		            geo_new.colors.push(new THREE.Color(0/255, 255/255, 0/255)); // green
		            par_new = new THREE.Points(geo_new, material1);
		            scene.add(par_new);

		            vec = new THREE.Vector3(true_cx,true_cy,true_cz)
		            geo_true = new THREE.Geometry();
		            geo_true.vertices.push(vec);
		            geo_true.colors.push(new THREE.Color(255/255, 0/255, 0/255)); //red
		            par_true = new THREE.Points(geo_true, material1);
		            scene.add(par_true);

					old_cx = true_cx; old_cy = true_cy; old_cz = true_cz;
					updateText();		            
		            clearScence();
		            jQuery(function($) {
						$('#ShowPoints').trigger('click');
						console.log("button click")						
					});
	            }	            	            
			}

			function onWindowResize() {
				windowHalfX = width / 2;
				windowHalfY = height / 2;
				camera.aspect = width / height;
				camera.updateProjectionMatrix();
				renderer.setSize(width, height);
			}
						

			function onDocumentMouseWheel(e) {
				e.preventDefault();				
				update_level();				
	            animate();            
	        }

	        function onDocumentMouseUp( event ) {
	        	event.preventDefault();
	        	CountInAndPrint();	        	
	            
        	}
			
			function animate() {
				requestAnimationFrame( animate );
				render();
			}

			function render() {
				renderer.render( scene, camera );
			}
		</script>
	</div>

</body>
</html>