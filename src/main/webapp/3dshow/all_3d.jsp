<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<script src="js/jQuery/jquery-2.1.4.min.js"></script>
	<script src="js/queryjs/queryjs.js" type="text/javascript"></script>
	<script src="../3dshow/libs/three.js"></script>
   <script src="../3dshow/libs/OBJLoader.js"></script>
   <script src="../3dshow/libs/MTLLoader.js"></script>
   <script src="../3dshow/libs/OrbitControls.js"></script>
   <script src="../3dshow/libs/RequestAnimationFrame.js"></script>
   <script src="../3dshow/libs/Detector.js"></script>  
  
<body>
	<div align="center">
		<script type="text/javascript">		
			var scene;
	        var loader;
	        var light;
	        var camera;
	        var renderer;
	        var controls;
	        var geometry;
	        var mesh_box1;
	        var mesh_c2;
	        var meshdog;
	        var meshhouse;
	        var run1 = null;
	        
	        var dis_ori;
	        var dis_now;
	        
	      //  var show = $('#correlation');
	
	        init();
	        animate();
	        
	        function show_dog(){
	        	scene.add(meshdog);
	        }	        
	        function delete_dog(){
	        	scene.remove(meshdog);
	        }
	        function show_box1(){
	        	scene.add(mesh_box1);
	        }	        
	        function delete_box1(){
	        	scene.remove(mesh_box1);
	        }
	        function show_c2(){
	        	scene.add(mesh_c2);
	        }	        
	        function delete_c2(){
	        	scene.remove(mesh_c2);
	        }
	        function show_house(){
	        	scene.add(meshhouse);
	        }	        
	        function delete_house(){
	        	scene.remove(meshhouse);
	        }
	        
	        function showrun(){
	        	run1 = true;
	            //animate();
	        }
	        function stoprun(){
	        	run1 = false;
	            //animate();
	        }
	        
	        function acc(){
	        	run1 = true;
	        	animate();
	        }
	        
			function init(){
				scene = new THREE.Scene();
				//3d
				geometry = new THREE.BoxGeometry(10,10,10);
	            var material = new THREE.MeshLambertMaterial({
	                color:0xff0000
	            });
	            mesh_box1 = new THREE.Mesh(geometry,material);
	            mesh_box1.position.x = -60;
	            mesh_box1.position.y = -20;
	            mesh_box1.position.z = 0;
	            mesh_box1.name = 'box1';
	           // scene.add(mesh_box1);
	            
				//texture
	            var manager = new THREE.LoadingManager();
	            manager.onProgress = function ( item, loaded, total ) {
	                console.log( item, loaded, total );
	            };
	            var texture = new THREE.Texture();
	            var loader = new THREE.ImageLoader(manager);
	            loader.load( '../3dshow/doc/small/house.jpg', function ( image ) {
	                texture.image = image;
	                texture.needsUpdate = true;
	            } );
				 // OBJ
				 var mtl = new THREE.MTLLoader();
		            mtl.setPath('../3dshow/doc/');
		            mtl.load('dog.mtl',function(mater){
		                mater.preload();		                
		                loader = new THREE.OBJLoader();
		                loader.setMaterials(mater);
		                loader.setPath('../3dshow/doc/');
		                loader.load('dog.obj',function (dogObject) {
		                	dogObject.scale.set(0.008,0.008,0.008);
		                	dogObject.rotation.y = THREE.Math.degToRad( -15 );
				            dogObject.position.y=-20;
				            dogObject.position.x=60;
				            dogObject.position.z=26;
				            meshdog = dogObject;
				          //  scene.add(meshdog);
		                });
		            });         
		        // house
		            mtl = new THREE.MTLLoader();
		            mtl.setPath('../3dshow/doc/small/');
		            mtl.load('house_big.mtl',function(mater){
		                loader = new THREE.OBJLoader();
		                loader.setPath('../3dshow/doc/small/');
		                loader.load('house_big_1.obj',function (hObject) {
		                	hObject.children[0].geometry.computeBoundingBox();
		                	hObject.rotation.x = THREE.Math.degToRad( -90 );
		                	hObject.children[0].geometry.center();
		                	hObject.scale.set(0.7,0.7,0.7);
		                	hObject.position.y=10;
				            mesh_c2= hObject;
				           // scene.add(mesh_c2);
		                });
		            }); 
		            
		            mtl = new THREE.MTLLoader();
		            mtl.setPath('../3dshow/doc/small/');
		            mtl.load('house.mtl',function(mater){
		                mater.preload();
		                loader = new THREE.OBJLoader();
		                loader.setMaterials(mater);
		                loader.setPath('../3dshow/doc/small/');
		                loader.load('house.obj',function (hObject1) {
		                	hObject1.traverse( function ( child ) {
                                if ( child instanceof THREE.Mesh ) {
                                    child.material.map = texture;
                                }
                    		} );
		                	hObject1.rotation.y = THREE.Math.degToRad( -15 );
		                	hObject1.scale.set(0.015,0.015,0.015);
				        	hObject1.position.y=-20;
				        	hObject1.position.x=60;
				        	hObject1.position.z=30;
				        	meshhouse = hObject1;
				            //scene.add(meshhouse);
		                });
		            }); 
		            		            
		        // Skybox
		        //scene.background = new THREE.CubeTextureLoader()
		        //   .setPath( '../3dshow/pisa/' )
		        //    .load( [ 'px.png', 'nx.png', 'py.png', 'ny.png', 'pz.png', 'nz.png' ] );
		        
		        light = new THREE.PointLight(0xffffff);
		        light.position.set(300,400,200);
		        scene.add(light);
		        scene.add(new THREE.AmbientLight(0x333333));
		
		        camera = new THREE.PerspectiveCamera(40,800/600,1,2000);
		        camera.position.set(300,400,200);
		        camera.lookAt(scene.position);
		
		        renderer = new THREE.WebGLRenderer();
		        renderer.setSize(586,450);
		        document.body.appendChild(renderer.domElement);
		        
		        controls = new THREE.OrbitControls(camera);
		        controls.addEventListener('change',render);
		        document.addEventListener('mouseup',onDocumentMouseUP,false );
		        
		        // dis:
		        var x = mesh_box1.position.x - camera.position.x;
	            var y = mesh_box1.position.y - camera.position.y;
	            var z = mesh_box1.position.z - camera.position.z;
	            dis_ori = Math.pow((x*x + y*y + z*z) , 1/3);
			}
	        
			function juli(){
	            var x = mesh_box1.position.x - camera.position.x;
	            var y = mesh_box1.position.y - camera.position.y;
	            var z = mesh_box1.position.z - camera.position.z;
	            dis_now = Math.pow((x*x + y*y + z*z) , 1/3);
	        }
			
	        function render(){
	            renderer.render(scene,camera);
	        }
	
	        function animate(){
	            requestAnimationFrame(animate);	 
	            if(run1==true){
	            	//mesh_box1.rotation.x+=0.0001;
	 	           // mesh_box1.rotation.y+=0.0001;
	 	           // mesh_box1.position.x -=0.004;
	 	            
	 	            window.arg = (window.arg || 0) + 0.006;
	 	            meshdog.position.y = -20 +(1 * Math.cos(window.arg));
	 	            meshdog.position.x -=0.04;
	            }
	           
	            juli();
	            var le = document.getElementById('e-correlation').value;
	            var K = dis_now / dis_ori;
	            if(le != Math.floor(K)){
	                level = Math.floor(K);
	                document.getElementById('e-correlation').value=level;
	            }	            
	            render();
	        }
	        
	        function onDocumentMouseUP( event ) {        
	            event.preventDefault();
	            var vector = new THREE.Vector3();//三维坐标对象
	            vector.set(
	                ( (event.clientX-690)/ 586) * 2 - 1,
	                -( (event.clientY-98)/ 450 ) * 2 + 1,
	                0.5);
	            vector.unproject(camera);
	            var raycaster = new THREE.Raycaster(camera.position, vector.sub(camera.position).normalize());
	            var intersects = raycaster.intersectObjects(scene.children,true);
	            if (intersects.length > 0) {
	               // alert("this is " + intersects[0].object.name);
	                document.getElementById('correlation').value= "click the " + intersects[0].object.name + "\n";	                
	                //document.getElementById('correlation').value=  
		        	//	document.getElementById('correlation').value + "\n"
		        	//	+ event.clientX + "," + event.clientY + "->" 
		        	//	+ (event.clientX-690) + "," + (event.clientY-98);
		        	}
	        }
	        
	    </script>
   </div>
</body>
</html>