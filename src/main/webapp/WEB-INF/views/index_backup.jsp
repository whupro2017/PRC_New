<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>work view</title>
	<!-- 三级联动 -->	
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<script src="js/city/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="js/city/bootstrap.min.js"></script>
	<script src="js/city/distpicker.data.js"></script>
	<script src="js/city/distpicker.js"></script>
	<script src="js/city/main.js"></script>
	
		<!-- 时间选择 -->
	<script src="js/datapicker/bootstrap-datepicker.js" type="text/javascript"></script>
	<script src="js/datapicker/bootstrap-datepicker.zh-CN.js" type="text/javascript"></script>	
	<link href="css/bootstrap/bootstrap-datepicker.css" rel="stylesheet">
	<link href="css/bootstrap/bootstrap-datepicker3.css" rel="stylesheet">

	<script type="text/javascript">
	    $(function () {
	        $(".from").datepicker({
	            language: "zh-CN",
	            autoclose: true,//选中之后自动隐藏日期选择框
	            clearBtn: true,//清除按钮
	            todayBtn: true,//今日按钮
	            format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
	        });
	    });
	    
	    $(function () {
	        $(".to").datepicker({
	            language: "zh-CN",
	            autoclose: true,//选中之后自动隐藏日期选择框
	            clearBtn: true,//清除按钮
	            todayBtn: true,//今日按钮
	            format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
	        });
	    });
	    
	</script>
	
	<link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">	 	
    <link href="/pro/css/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />  
 	<link href="/pro/css/AdminLTE-test.css" rel="stylesheet" type="text/css" />  
    
	<script src="/pro/js/jQuery/jquery-2.1.4.min.js"></script>
	<script src="/pro/js/highCharts/highcharts.js"></script>
	<script src="/pro/js/highCharts/themes/grid.js"></script>
	<script src="/pro/js/highCharts/modules/exporting.src.js"></script>

	<!--左侧导航栏  -->
	<script type="text/javascript" src="/pro/js/bootstrap/bootstrap-treeview.min.js"></script>
    <script src="/pro/js/modules/left/work.js"></script> 
  </head>
  <body>
	<div class="wrapper row-offcanvas row-offcanvas-left" style="">	
    	<!-- Left side column. contains the logo and sidebar -->
		<div class="left-side sidebar-offcanvas" style="background-color : transparent; border-right:1px solid #000"> <!-- style="background:url(/project290/images/modules/index/main_left.jpg)" --> 
        <!-- sidebar: style can be found in sidebar.less --> 

            	<div style="background-color :ADD8E7;" align="center">
            		<text rows="1" cols="20" size="2"> 案件类别  </text>
            	</div>

           	    <div class="nav-tabs-custom"  style="background-color : transparent ;"><%--style="background:url(../img/left_03.jpg)" --%><!-- Tabs within a box -->
	                <div class="tab-content no-padding" style="background-color:transparent;"><!-- style="background:rgb(99, 178, 234)" -->
	                	<!-- Morris chart - Sales -->
	                	<div class="chart tab-pane active" id="sales-chart" style="position: relative; padding-top:0px;background-color : transparent;"><!-- height:1000px; background-color:pink; -->
	                    	<!-- sidebar menu: : style can be found in sidebar.less -->
	                   		<div id="StadiaName" style="background-color:transparent;"><!--  style="background:url(/project290/images/modules/index/main_left.jpg)" -->
							</div>           
	                 	</div>
	                </div>
                </div><!-- /.nav-tabs-custom -->	

        </div>
        
        <div class="right-side sidebar-offcanvas"  style="background-color:transparent;"> <!-- style="background:url(/project290/images/modules/index/main_left.jpg)" --> 
        	
		 	<div class="text" style="background-color:ADD8E6;" align="center"><%-- style="background:url(../img/left_03.jpg)" --%>
            	<text rows="1" cols="20" size="2" > 查询结果及展示  </text>
		 	</div>
		 	
		 	<div class="show" style="background-color:transparent;" align="center">
				<div style="width:50%;height:100% ;background-color:transparent;float:left;border-right:1px solid #000">
					<div id="leftDiv" style="width: 100%; float: left;"></div>	            	
			 	</div>	
		 
				<div style="margin: 0 auto;">
					<div id="left2Div" style="width: 100%; float: right;">
						
						
					</div>				
				</div>
			</div>
			

        </div>
        
	</div>

</body>
</html>
