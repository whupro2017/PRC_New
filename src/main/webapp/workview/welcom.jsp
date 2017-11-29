<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>案事件现场勘验综合展示系统</title>
		<!-- basic styles -->
		<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

		<!-- ace styles -->

		<link rel="stylesheet" href="../assets/css/ace.min.css" />
		<link rel="stylesheet" href="../assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="../assets/css/ace-skins.min.css" />

		<!-- ace settings handler -->
		<script src="../assets/js/ace-extra.min.js"></script>
		
		<script src="../js/jQuery/jquery-2.1.4.min.js"></script>
		<!-- page content -->
		<!-- 时间选择 -->
		<script src="../js/datapicker/bootstrap-datepicker.js" type="text/javascript"></script>
		<script src="../js/datapicker/bootstrap-datepicker.zh-CN.js" type="text/javascript"></script>	
		<link href="../css/bootstrap/bootstrap-datepicker.css" rel="stylesheet">
		<link href="../css/bootstrap/bootstrap-datepicker3.css" rel="stylesheet">
	
		<script type="text/javascript">
		    $(function () {
		        $(".from").datepicker({
		            language: "zh-CN",
		            autoclose: true,//选中之后自动隐藏日期选择框
		            clearBtn: true,//清除按钮
		            format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
		        });
		    });
		    
		    $(function () {
		        $(".to").datepicker({
		            language: "zh-CN",
		            autoclose: true,//选中之后自动隐藏日期选择框
		            clearBtn: true,//清除按钮
		            format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
		        });
		    });
		    
		</script>
		
		<link href="../css/bootstrap/css/bootstrap-table.css" rel="stylesheet">  
		<script src="../js/jQuery/jquery-2.1.4.min.js" type="text/javascript"></script>  
		<script src="../js/bootstrap/bootstrap3.2.js"></script>   
		<script src="../js/bootstraptable/bootstrap-table.js"></script>  
		<script src="../js/queryjs/queryjs.js" type="text/javascript"></script>
		
		<!-- 三级联动 -->	
		<script src="../js/city/bootstrap.min.js"></script>
		<script src="../js/city/distpicker.data.js"></script>
		<script src="../js/city/distpicker.js"></script>		
	</head>

	<body>
		<div class="navbar navbar-default" id="navbar" style="height:70px;">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand" >
							<img src="./logo.png"/>
							<text vertical-align:middle;>案事件现场勘验综合展示系统</text>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#" >
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<ul class="nav nav-list">
						<li class="active">
							<a href="welcom.jsp">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 首页 </span>
							</a>
						</li>

						<li >
							<a href="all_index.jsp">
								<i class="icon-th"></i>
								<span class="menu-text"> 全部案件 </span>
							</a>
						</li>
						
						<li>
							<a href="burn_index.jsp">
								<i class="icon-fire"></i>
								<span class="menu-text"> 放火 </span>
							</a>
						</li>

						<li>
							<a href="bom_index.jsp">
								<i class="icon-certificate"></i>
								<span class="menu-text"> 爆炸 </span>
							</a>
						</li>

						<li>
							<a href="grab_index.jsp">
								<i class="icon-jpy"></i>
								<span class="menu-text"> 抢盗 </span>
							</a>
						</li>
						
						<li>
							<a href="grab_index.jsp">
								<i class="icon-tint"></i>
								<span class="menu-text"> 碰撞 </span>
							</a>
						</li>
						
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar','collapsed')}catch(e){}
					</script>
				</div>

				<div class="main-content">
					<div class="page-content">
						<img src="./logo_bg.png"/>						
																	
					</div> <!-- /page-content -->
				</div><!-- /.main-content -->					
			</div><!-- /.main-container-inner -->

		</div><!-- /.main-container -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='../assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
		<script src="../assets/js/bootstrap.min.js"></script>
		<script src="../assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<script src="../assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="../assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="../assets/js/jquery.slimscroll.min.js"></script>
		<script src="../assets/js/jquery.easy-pie-chart.min.js"></script>
		<script src="../assets/js/jquery.sparkline.min.js"></script>
		<script src="../assets/js/flot/jquery.flot.min.js"></script>
		<script src="../assets/js/flot/jquery.flot.pie.min.js"></script>
		<script src="../assets/js/flot/jquery.flot.resize.min.js"></script>

		<!-- ace scripts -->

		<script src="../assets/js/ace-elements.min.js"></script>
		<script src="../assets/js/ace.min.js"></script>

	</body>
</html>

