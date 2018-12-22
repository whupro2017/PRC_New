<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet"
	href="../assets/css/jquery-ui-1.10.3.full.min.css" />
<link rel="stylesheet" href="../assets/css/datepicker.css" />
<link rel="stylesheet" href="../assets/css/ui.jqgrid.css" />
<!-- ace styles -->
<link rel="stylesheet" href="../assets/css/ace.min.css" />
<link rel="stylesheet" href="../assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="../assets/css/ace-skins.min.css" />
<link href="../css/bootstrap/bootstrap-datepicker.css" rel="stylesheet">
<link href="../css/bootstrap/bootstrap-datepicker3.css" rel="stylesheet">
<link href="../css/bootstrap/css/bootstrap-table.css" rel="stylesheet">
<link rel="stylesheet" href="../zTree/css/zTreeStyle/zTreeStyle.css"
	type="text/css">

<script src="../js/jQuery/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="../assets/js/ace-extra.min.js" type="text/javascript"></script>
<script src="../js/datapicker/bootstrap-datepicker.js"
	type="text/javascript"></script>
<script src="../js/datapicker/bootstrap-datepicker.zh-CN.js"
	type="text/javascript"></script>
<script src="../js/bootstrap/bootstrap3.2.js"></script>
<script src="../js/bootstraptable/bootstrap-table.js"></script>
<script src="../js/queryjs/queryjs.js" type="text/javascript"></script>
<!-- 三级联动 -->
<script src="../js/city/bootstrap.min.js" type="text/javascript"></script>
<script src="../js/city/distpicker.data.js" type="text/javascript"></script>
<script src="../js/city/distpicker.js" type="text/javascript"></script>
<!-- jqGrid -->
<script src="../assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../assets/js/typeahead-bs2.min.js" type="text/javascript"></script>

<script src="../assets/js/jqGrid/jquery.jqGrid.min.js"
	type="text/javascript"></script>
<script src="../assets/js/jqGrid/i18n/grid.locale-en.js"
	type="text/javascript"></script>
<script src="../js/queryjs/query_table.js" type="text/javascript"></script>
<!-- ace scripts -->
<script src="../assets/js/ace.min.js" type="text/javascript"></script>
<script src="../zTree/js/jquery.ztree.core.js" type="text/javascript"></script>
<script src="../zTree/js/jquery.ztree.excheck.js" type="text/javascript"></script>

</head>

<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <img src="./logo.png" /><text vertical-align:middle;>案事件现场勘验综合展示系统</text>
					</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

				<ul class="nav nav-list">
					<li><a href="../indexCtrl"> <i class="icon-dashboard"></i>
							<span class="menu-text"> 首页 </span>
					</a></li>

					<li><a href="all_index.jsp"> <i class="icon-th"></i> <span
							class="menu-text"> 全部案件 </span>
					</a></li>

					<li><a href="burn_index.jsp"> <i class="icon-fire"></i> <span
							class="menu-text"> 放火 </span>
					</a></li>

					<li><a href="bom_index.jsp"> <i class="icon-certificate"></i>
							<span class="menu-text"> 爆炸 </span>
					</a></li>

					<li><a href="kill_index.jsp"> <i class="icon-jpy"></i> <span
							class="menu-text"> 抢盗 </span>
					</a></li>

					<li><a href="collision_index.jsp"> <i class="icon-tint"></i> <span
							class="menu-text"> 碰撞 </span>
					</a></li>

					<li class="active"><a href="points.jsp"> <i class="icon-spinner"></i> <span
							class="menu-text"> 点云展示 </span>
					</a></li>

					<li><a href="colorpoints.jsp"> <i
							class="icon-star"></i> <span class="menu-text"> color点云展示
						</span>
					</a></li>

				</ul>
				<!-- /.nav-list -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
						try{ace.settings.check('sidebar')}catch(e){}
					</script>
			</div>

			<div class="main-content">
				<div class="page-content" style="height: 100%">
					<div style="height: 10%; width: 100%; float: top;">
						<div style="background-color: transparent;">
							<table style="background-color: transparent;">
								<tr>
									<td class="tdTwo" rowspan="2" style="padding-left: 0px;">
										<button id="ShowObj" style="height: 30px; width: 80px">显示OBJ</button>
									</td>
									<td class="tdTwo" rowspan="2" style="padding-left: 4px;">
										<button id="HideObj" style="height: 30px; width: 80px">隐藏OBJ</button>
									</td>
									<td style="padding-left: 5px">leftbottom</td>
									<td style="padding-left: 4px"><input type="text"
										style="height: 20px; width: 90px;" id="minx" class="minx"
										placeholder="x" value="610970.9"> <input type="text"
										style="height: 20px; width: 90px;" id="miny" class="miny"
										placeholder="y" value="104542.53"> <input type="text"
										style="height: 20px; width: 90px;" id="maxz" class="maxz"
										placeholder="z" value="90.195"></td>
									<td style="padding-left: 5px">righttop</td>
									<td style="padding-left: 4px"><input type="text"
										style="height: 20px; width: 90px;" id="maxx" class="maxx"
										placeholder="x" value="611297.9"> <input type="text"
										style="height: 20px; width: 90px;" id="maxy" class="maxy"
										placeholder="y" value="104868.46"> <input type="text"
										style="height: 20px; width: 90px;" id="minz" class="minz"										
										placeholder="z" value="10.841"></td>
									<td style="padding-left: 5px">center</td>
									<td style="padding-left: 4px"><input type="text"
										style="height: 20px; width: 90px;" id="cenx" class="cenx"
										placeholder="x" value="611150"> <input type="text"
										style="height: 20px; width: 90px;" id="ceny" class="ceny"
										placeholder="y" value="104710"> <input type="text"
										style="height: 20px; width: 90px;" id="cenz" class="cenz"
										placeholder="z" value="60"></td>
									<td style="padding-left: 5px">level</td>
									<td style="padding-left: 4px">
										<input type="text" style="height: 30px; width: 50px;" id="level" value="10">
									</td>
									<td class="tdTwo" rowspan="2" style="padding-left: 4px;">
										<button id="ShowPoints" style="height: 30px; width: 50px">显示</button>
									</td>
									
									<td class="tdTwo" rowspan="2" style="padding-left: 4px;">
										<button id="Clear" style="height: 30px; width: 50px">清空</button>
									</td>
									
									<td class="tdTwo" rowspan="2" style="padding-left: 4px;">
										<button id="showlayout" style="height: 30px; width: 70px">显示网格</button>
									</td>
									
									<td class="tdTwo" rowspan="2" style="padding-left: 4px;">
										<button id="deletelayout" style="height: 30px; width: 70px">隐藏网格</button>
									</td>
									
								</tr>
							</table>
						</div>
					</div>
					<!-- part of right -->
					<div id="pointsShow"
						style="height: 90%; width: 100%; float: bottom">
						<div id="pointsDIV" align="center">
							<%@include file="../3dshow/points.jsp"%>
						</div>
						<div id="point_left" align="center">
							hhhh
						</div>
					</div>
				</div>
				<!-- /page-content -->
			</div>
			<!-- /.main-content -->
		</div>
		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->
</body>
</html>