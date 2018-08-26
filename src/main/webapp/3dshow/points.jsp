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
			var step_level = 1.15;
			var judge_num = 125;
			var container, camera, scene, renderer;
			var particles, geometry;

			var judge_arr = new Array(judge_num);
			var geometrypoint, materialpoint;

			var vec_judge;
			var material, i, h, color, sprite, size;
			var mesh_f, loader, mtlloader;
			var axisHelper;
			var judge_01 = 1, obj_01 = 0;

			var width = 950, height = 850;
			
			var dis_ori, dis_now, dis_step, dis_step_new;
			var min_level = 10,  max_level = 17;			
			
			var minx, miny,  maxz,maxx, maxy,minz, cenx, ceny, cenz, level;
			var old_cx, old_cy, old_cz,new_cx, new_cy, new_cz,true_cx, true_cy, true_cz;
	        var new_minx, new_miny, new_maxz,new_maxz,new_maxy,new_minz;	
	        var len_x, len_y,len_z;
			var sceneLock = false;
	        var event_flag = true, event_flag1 = true;

	        var old_camex = 0, old_camey = 0, old_camez = 500;
	        var old_jx = 0, old_jy = 0, old_jz = 0;
	        var new_jx = 0, new_jy = 0, new_jz = 0;
	        var mouse_down = true;

	        initScence();   						
						
			jQuery(function($) {
				$('#ShowPoints').on('click', function() {
					minx = $(".minx").val(); maxx = $(".maxx").val();
					miny = $(".miny").val(); maxy = $(".maxy").val();
					minz = $(".minz").val(); maxz = $(".maxz").val();
														
					cenx = $(".cenx").val(); ceny = $(".ceny").val();					
					cenz = $(".cenz").val(); level = $("#level").val();					

					len_x = Math.abs(maxx - minx);
					len_y = Math.abs(maxy - miny);
					len_z = Math.abs(maxz - minz);										
					// console.log("##############show points input"+minx+","+miny+","+minz+","+maxx+","+maxy+","+maxz+","+level);
									    	
					$.ajax({
						async: false,
						cache: false,
						type: 'POST',
						datatype: 'json',
						url:'/pro/PointsController/getAllColorPoints?minx=' + minx + '&miny=' + miny 
							+ '&minz=' + minz + '&maxx=' + maxx + '&maxy=' + maxy + '&maxz=' + maxz
							+ '&level=' + level + '&maxLevel=' + max_level,
						error: function(){
							alert("失败");
						},
						success: function(data){
							console.log("data count:" + data.length);
							// console.log("the first test:"+data[0].x+"|"+data[0].y+"|"+data[0].z);
					    	
							geometry = new THREE.Geometry();         				
							vec_judge = new Array();							
							var x = 0, y = 0, z = 0;

							for(var i=0; i<judge_num;i++){
								var row = data[i];
								judge_arr[i].position.x = data[i].x-cenx;
								judge_arr[i].position.y = data[i].y-ceny;
								judge_arr[i].position.z = data[i].z-cenz;

								var vertex = new THREE.Vector3(data[i].x-cenx, data[i].y-ceny, data[i].z-cenz);
								x+=data[i].x-cenx; y+=data[i].y-ceny; z+=data[i].z-cenz;			
								vec_judge.push(vertex);
							}
							
							old_cx = x/judge_num; old_cy = y/judge_num; old_cz = z/judge_num;
							new_cx = old_cx; new_cy = old_cy; new_cz = old_cz;						
							true_cx = old_cx; true_cy = old_cy; true_cz = old_cz;																			
							for (var i = judge_num-1; i < data.length; i++) {
								var row = data[i];
								var vertex = new THREE.Vector3(data[i].x, data[i].y, data[i].z);
								var color = new THREE.Color(data[i].r/255, data[i].g/255, data[i].b/255);
								geometry.vertices.push(vertex);
								geometry.colors.push(color);
							}					
							addPoint(cenx, ceny, cenz,level);	
							event_flag1 = true;	
							event_flag = true;					
						}
					})
				});
				
				$('#ShowObj').on('click', function() {
					obj_01 = 1;
					show_obj();					
				});
				
				$('#HideObj').on('click', function() {
					obj_01 = 0;
					remove_obj();
				});				

				$('#Clear').on('click', function() {
					clearScence();				
				});

				$('#showlayout').on('click', function() {
					judge_01 = 1;
					show_layout();				
				});

				$('#deletelayout').on('click', function() {
					judge_01 = 0;
					remove_layout();				
				});

				$('#lockPoints').on('click', function() {
					sceneLock = !sceneLock;
					alert("Lock: " + sceneLock);
					document.getElementById('lockPoints').value = sceneLock;
				});
			});
				
			function initScence() {
				container = document.createElement( 'div' );
				document.body.appendChild( container );
				//scene
		        scene = new THREE.Scene();
                light = new THREE.PointLight(0xffffff);
                light.position.set(300, 400, 200);
                scene.add(light);
                scene.add(new THREE.AmbientLight(0x333333));
				//camera              
                camera = new THREE.PerspectiveCamera(40, width / height, 0.1, 20000);
                camera.position.set(0, 0, 500);
                camera.lookAt(0, 0, 1);            		
           		//init judge box		
           		var size = 5; 
				geometrypoint = new THREE.BoxGeometry(size,size,size);
				materialpoint = new THREE.MeshLambertMaterial({
	                color:0xff0000
	            });					
	            for(var i=0; i<judge_num;i++){
					judge_arr[i] = new THREE.Mesh(geometrypoint,materialpoint);
					judge_arr[i].name = i;
				}
                
				renderer = new THREE.WebGLRenderer();
				renderer.setPixelRatio( window.devicePixelRatio );
				renderer.setSize(width, height);
				container.appendChild( renderer.domElement );
						
				dis_ori = Math.pow((camera.position.x*camera.position.x +
		                camera.position.y*camera.position.y +
		                camera.position.z*camera.position.z) , 1/2);	
		        dis_step = dis_ori / 8;			
				
				var controls = new THREE.OrbitControls(camera);
				controls.addEventListener('change', renderer);
				document.addEventListener( 'mouseup', onDocumentMouseUp, false );
				// document.addEventListener( 'mousedown', onDocumentMouseDown, false );
				// document.addEventListener( 'mousemove', onDocumentMouseOver, false );
				window.addEventListener('wheel', onDocumentMouseWheel, true);
			}

			function clearScence(){
				scene.remove(particles);
				scene.remove(mesh_f);
				scene.remove(axisHelper)

				for(var i=0;i<judge_arr.length;i++){
					scene.remove(judge_arr[i]);
				}
				//animate();
			}

			function addPoint(x,y,z,level){
				//axisHelper
				var lenaxis = Math.max(len_x,len_y);
				lenaxis = Math.max(lenaxis,len_z);
		        axisHelper =new THREE.AxisHelper(lenaxis);
				axisHelper.position.x = minx-cenx;
				axisHelper.position.y = miny-ceny;
				axisHelper.position.z = minz-cenz;
				
				// point:
				material = new THREE.PointsMaterial({
					size: 5, sizeAttenuation: false,
					vertexColors: THREE.VertexColors,					
					alphaTest: 0.5,transparent: true
				});												
				particles = new THREE.Points(geometry, material);
				particles.position.x -= parseFloat(x);
				particles.position.y -= parseFloat(y);
				particles.position.z -= parseFloat(z);
				scene.add(particles);
				// judge box 
				if(judge_01==1){
					scene.add(axisHelper);
					for(var i=0;i<judge_arr.length;i++){
						scene.add(judge_arr[i]);
					}
				}
				// obj
				var level_o = level;
				if(level<13)
					level_o = 13;
				else if (level > 15)
					level_o = 15;	
				var pathf = '../3dshow/doc/';
	            var pathm = 'house.mtl';
	            var path = 'steps-' + level_o + '.obj';
	            
	            if(obj_01=1){
	            	 load_obj(pathf,pathm,path, 1,0,x,y,z);
	            }else{
	            	 scene.remove(mesh_f);
	            }
	           
	            render();
	            animate();
			}

			function show_obj(){
	            scene.add(mesh_f);
	            //animate();
	        }

			function remove_obj(){
	            scene.remove(mesh_f);
	            //animate();
	        }

	        function show_layout(){
				scene.add(axisHelper)
				for(var i=0;i<judge_arr.length;i++){
					scene.add(judge_arr[i]);
				}
				//animate();
	        }

	        function remove_layout(){
				scene.remove(axisHelper);
				for(var i=0;i<judge_arr.length;i++){
					scene.remove(judge_arr[i]);
				}
				//animate();
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
				var mx = camera.position.x - new_jx;
				var my = camera.position.y - new_jy;
				var mz = camera.position.z - new_jz;
	            dis_now = Math.pow((mx * mx + my * my + mz * mz) , 1/2);
	        }
			
			function update_level(){
	            juli();	           
	            var le = document.getElementById('level').value;	            
	            dis_step_new = dis_step * (1 - 0.05*(le-10));
	            var K = (dis_ori-dis_now) / dis_step_new ;
	            document.getElementById('me1').value= "距离： " + " dis_ori: " + dis_ori + " dis_now: " + dis_now  + " step: " + dis_step_new + " K: " + K
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

	                // update the size of judege box
	                var size = 10 - 0.5 * level ;
					geometrypoint = new THREE.BoxGeometry(size,size,size);					
		            for(var i=0; i<judge_num;i++){
		            	scene.remove(judge_arr[i]);
						judge_arr[i] = new THREE.Mesh(geometrypoint,materialpoint);
						judge_arr[i].name = i;
					}
		            if (!sceneLock) {
		                clearScence();
						jQuery(function($) {
							$('#ShowPoints').trigger('click');
							console.log("button click")						
						});
	            	}		
	            } else {
	            	event_flag = true;	
	            }
	        }
			
			function updateText(){
				new_minx = parseFloat(old_cx) - parseFloat(len_x/2) + parseFloat(cenx);
				new_miny = parseFloat(old_cy) - parseFloat(len_y/2) + parseFloat(ceny);
				//new_minz = parseFloat(old_cz) - parseFloat(len_z/2) + parseFloat(cenz);
				// new_minz = parseFloat(old_cz);
				
				new_maxx = parseFloat(old_cx) + parseFloat(len_x/2) + parseFloat(cenx);
				new_maxy = parseFloat(old_cy) + parseFloat(len_y/2) + parseFloat(ceny);
				new_maxz = parseFloat(old_cz) + parseFloat(len_z/2) + parseFloat(cenz);
				
	            document.getElementById('minx').value=new_minx ;
	            document.getElementById('miny').value=new_miny ;
	            document.getElementById('maxz').value=new_maxz ;
	            
	            document.getElementById('maxx').value=new_maxx ;
	            document.getElementById('maxy').value=new_maxy ;
	            // document.getElementById('minz').value=new_minz ;
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

	            document.getElementById('me1').value= "距离： " + " dis_ori: " + dis_ori + " dis_now: " + dis_now  + " step: " + dis_step
	            + "\n" + "视野中点的数量:" +count +" of " +  judge_num ;

	            if(!sceneLock && count < judge_num*0.3){
		            compute_centor(vector_in_view);		            
					old_cx = true_cx; old_cy = true_cy; old_cz = true_cz;
					updateText();		            
		            clearScence();
		            jQuery(function($) {
						$('#ShowPoints').trigger('click');
						console.log("button click")						
					});
	            }else{
	            	event_flag1 = true;		
	            }	            	            
			}
						

			function onDocumentMouseWheel(e) {
				e.preventDefault();	
				console.log(event_flag + ";" + event_flag1)
				if(event_flag){
					event_flag = false;
					update_level();	  	
				}					        
	        }

	        function onDocumentMouseUp( event ) {
	        	
	        	//document.getElementById('me3').value= old_jx + "\t" + old_jy + "\t" + old_jz + "\t";
	        	//mouse_down = false;

	        	event.preventDefault();	 
	        	// test mouseX and mouseY
        	 	//document.getElementById('me3').value=event.clientX + ";" + event.clientY;
        	 	var vector = new THREE.Vector3();
	            vector.set(
	                ( (event.clientX-190)/ width) * 2 - 1,
	                -( (event.clientY-107)/ height ) * 2 + 1,
	                0.5);
	            vector.unproject(camera);
	            var raycaster = new THREE.Raycaster(camera.position, vector.sub(camera.position).normalize());
	            var intersects = raycaster.intersectObjects(scene.children,true);
	            if (intersects.length > 0) {
	            	document.getElementById('me2').value= "click the " + intersects[0].object.name + "\n x: "
	            	+( parseFloat(intersects[0].object.position.x) +  parseFloat(cenx) ) + " ; y: "
	            	+( parseFloat(intersects[0].object.position.y) +  parseFloat(ceny) ) + " ; z: "
	            	+( parseFloat(intersects[0].object.position.z) +  parseFloat(cenz) )
		        }

	            if(event_flag1){
	            	event_flag1 = false;
	            	CountInAndPrint();
	            }
        	}
			
			// function onDocumentMouseDown(e){
			// 	e.preventDefault();	
			// 	mouse_down = true;
			// }

			// function onDocumentMouseOver(e){
			// 	e.preventDefault();	
			// 	if(mouse_down){
	  //       		new_jx = old_jx + camera.position.x -  old_camex;
	  //       		new_jy = old_jy + camera.position.y -  old_camey;
	  //       		new_jz = old_jz + camera.position.z -  old_camez;
		 //        	old_jx = new_jx; old_jy = new_jy; old_jz = new_jz;
		 //        	old_camex = camera.position.x ;
		 //        	old_camey = camera.position.y ;
		 //        	old_camez = camera.position.z ;
			// 	}
			// }

			function animate() {
				requestAnimationFrame( animate );
				render();
			}

			function render() {
				renderer.render( scene, camera);
			}
		</script>
	</div>

</body>
</html>