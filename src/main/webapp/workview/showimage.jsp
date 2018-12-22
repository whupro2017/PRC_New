<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示图片</title>
	<!-- basic styles -->
	<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
	<script src="../js/jQuery/jquery-2.1.4.min.js"></script>

<body onload="get_url()" >

<div id="mouse">鼠标离开图片</div>

<div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
		<div id="innerdiv" style="position:absolute;">
		        <img id="bigimg" style="border:5px solid #fff;" src="" />
		</div>
</div>

<!--canvas id="myCanvas" width="200" height="100"
style="border:1px solid #000000;">
</canvas-->


<p   style="text-align:center;  padding:100px ;height:100px ;line-height:100px;">
<img id="element_image"  src=""   onMouseMove="move()" onMouseOut="out()"  height="600px"  title="点击放大"  class="pimg" onmousewheel="return bbimg(this)" />		
</p>				
</body>

<script>   <!-- 计算图片上鼠标坐标 -->
    function move(){
        var img=document.getElementById("element_image");
        document.getElementById("mouse").innerHTML="x : " +(window.event.clientX-element_image.offsetLeft)+ ", y : " +(window.event.clientY-element_image.offsetTop);
    }
    function out(){
        document.getElementById("mouse").innerHTML="鼠标离开图片"
    }
    
      
</script>

<script >   <!-- 从父窗口获取图片URL -->
    function get_url() {
        if (window.opener != null && !window.opener.closed) {
        	console.log("图片长度")
            var image_url = window.opener.document.getElementById("element_image").src;//获取父窗口中元素，也可以获取父窗体中的值
            console.log("图片url："+image_url );
            document.getElementById('element_image').src = image_url;
            /*var canvas, ctx, img64; 
            canvas = document.getElementById('myCanvas'); 
            ctx = canvas.getContext("2d"); 
            ctx.drawImage(image_url, 0, 0);*/
        }
    }
</script>

<script >   <!-- 滚轮放大图片 -->
function bbimg(o){
var zoom=parseInt(o.style.zoom, 10)||100;
zoom+=event.wheelDelta/10;
if (zoom>0) o.style.zoom=zoom+'%';
return false;
}
</script>

<script>    <!-- 点击图片弹出大图 -->
    $(function(){  
        $(".pimg").click(function(){  
            var _this = $(this);//将当前的pimg元素作为_this传入函数  
            imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);  
        });  
    });  

    function imgShow(outerdiv, innerdiv, bigimg, _this){  
        var src = _this.attr("src");//获取当前点击的pimg元素中的src属性  
        $(bigimg).attr("src", src);//设置#bigimg元素的src属性  
      
            /*获取当前点击图片的真实大小，并显示弹出层及大图*/  
        $("<img/>").attr("src", src).load(function(){  
            var windowW = $(window).width();//获取当前窗口宽度  
            var windowH = $(window).height();//获取当前窗口高度  
            var realWidth = this.width;//获取图片真实宽度  
            var realHeight = this.height;//获取图片真实高度  
            var imgWidth, imgHeight;  
            var scale = 0.9;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放  
              
            if(realHeight>windowH*scale) {//判断图片高度  
                imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放  
                imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度  
                if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度  
                    imgWidth = windowW*scale;//再对宽度进行缩放  
                }  
            } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度  
                imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放  
                            imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度  
            } else {//如果图片真实高度和宽度都符合要求，高宽不变  
            	imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放  
                imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度  
            }  
                    $(bigimg).css("width",imgWidth);//以最终的宽度对图片缩放  
              
            var w = (windowW-imgWidth)/2;//计算图片与窗口左边距  
            var h = (windowH-imgHeight)/2;//计算图片与窗口上边距  
            $(innerdiv).css({"top":h, "left":w});//设置#innerdiv的top和left属性  
            $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg  
        });  
          
        $(outerdiv).click(function(){//再次点击淡出消失弹出层  
            $(this).fadeOut("fast");  
        });  
    }  
</script>

</html>

