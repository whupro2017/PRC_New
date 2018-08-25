<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
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
<script src="../js/queryjs/ztree.js" type="text/javascript"></script>

<script type="text/javascript">
	jQuery(function($) {
		$(".from").datepicker({
			language : "zh-CN",
			autoclose : true,//选中之后自动隐藏日期选择框
			clearBtn : true,//清除按钮
			format : "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
		});
	});

	jQuery(function($) {
		$(".to").datepicker({
			language : "zh-CN",
			autoclose : true,//选中之后自动隐藏日期选择框
			clearBtn : true,//清除按钮
			format : "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
		});
	});
</script>
</head>


<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <img src="./logo.png" /> <textvertical-align:middle;>案事件现场勘验综合展示系统</text></a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="nav nav-list">
					<li><a href="welcom.jsp"> <i class="icon-dashboard"></i> <span
							class="menu-text"> 首页 </span>
					</a></li>

					<li><a href="all_index.jsp"> <i class="icon-th"></i> <span
							class="menu-text"> 案件管理 </span>
					</a></li>

					<li><a href="reconstruct.jsp"> <i class="icon-cloud"></i>
							<span class="menu-text"> 场景管理 </span>
					</a></li>

					<li><a href="element.jsp"> <i class="icon-eye-open"></i> <span
							class="menu-text"> 素材管理 </span>
					</a></li>

					<li class="active"><a href="burn_index.jsp"> <i
							class="icon-fire"></i> <span class="menu-text"> 放火 </span>
					</a></li>

					<li><a href="bom_index.jsp"> <i class="icon-certificate"></i>
							<span class="menu-text"> 爆炸 </span>
					</a></li>

					<li><a href="grab_index.jsp"> <i class="icon-jpy"></i> <span
							class="menu-text"> 抢盗 </span>
					</a></li>

					<li><a href="kill_index.jsp"> <i class="icon-tint"></i> <span
							class="menu-text"> 碰撞 </span>
					</a></li>

					<li><a href="points.jsp"> <i class="icon-spinner"></i> <span
							class="menu-text"> 点云展示 </span>
					</a></li>

					<!-- li>
							<a href="colorpoints.jsp">
								<i class="icon-star"></i>
								<span class="menu-text"> color点云展示 </span>
							</a>
						</li-->

				</ul>
				<!-- /.nav-list -->
				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar')
					} catch (e) {
					}
				</script>
			</div>

			<div class="main-content">
				<div class="page-content">
					<div style="width: 45%; float: left;">
						<div class="tab1"
							style="height: 60%; border: solid 1px; float: top; overflow: auto">
							<ul id="myTab" class="nav nav-tabs">
								<li class="active"><a href="#home" data-toggle="tab">
										案例查询 </a></li>
								<li><a href="#material" data-toggle="tab">案例素材</a></li>
								<li><a href="#trail" data-toggle="tab">移动轨迹</a></li>
							</ul>

							<div id="myTabContent" class="tab-content">
								<div class="tab-pane fade in active" id="home">
									<div style="background-color: transparent; float: top;">
										<table style="background-color: transparent;">
											<tr>
												<td style="padding-left: 35px">查询地区：</td>
												<td style="padding-left: 4px">
													<div data-toggle="distpicker">
														<select id="prov" style="height: 25px; width: 76px;"
															class="prov"></select> <select id="city"
															style="height: 25px; width: 125px;" class="city"></select>
														<select id="dis" style="height: 25px; width: 76px;"
															class="district"></select>
													</div>
												</td>

											</tr>
											<tr>
												<td style="padding-left: 35px">查询时间：</td>
												<td style="padding-left: 4px"><input type="text"
													style="height: 25px; width: 105px;" id="from" class="from"
													placeholder="开始时间"> <input type="text"
													style="height: 25px; width: 105px;" id="to" class="to"
													placeholder="结束时间">
													<button id="CaseBurn" style="height: 25px; width: 65px">查询</button>
												</td>
											</tr>
										</table>
									</div>
									<div style="padding-top: 3px">
										<table id="table_burn"></table>
									</div>
								</div>

								<div class="tab-pane fade" id="material">
									<button id="material_load" style="height: 25px; width: 65px"
										onClick="load_m()">Load</button>
									<div class="zTreeDemoBackground left">
										<ul id="treeDemo" class="ztree"></ul>
									</div>
								</div>

								<div class="tab-pane fade" id="trail">
									<button id="trail_load" style="height: 25px; width: 65px"
										onClick="load_t()">Load</button>
									<p>
										<textarea id="trail_show_all" rows="10" cols="40">此处显示</textarea>
									</p>
								</div>
							</div>
						</div>
						<div class="tab2" style="float: bottom;">
							<div style="float: bottom;">
								<div class="tab2.3"
									style="width: 50%; float: left; border-left: solid 1px; border-right: solid 1px"
									align="center">
									<text>关联信息</text>
									<p>
										<textarea id="correlation" rows="18" cols="45"></textarea>
									</p>
								</div>
								<div class="tab2.4"
									style="width: 50%; float: right; border-right: solid 1px;"
									align="center">
									<text>外联信息</text>
									<p>
										<textarea id="e-correlation" rows="18" cols="45"></textarea>
									</p>
								</div>
							</div>
							<div style="float: bottom;">
								<div class="tab2.1"
									style="width: 50%; float: left; border-left: solid 1px; border-right: solid 1px"
									align="center">
									<div id="myTabContent" class="tab-content">
										<div style="background-color: transparent; float: top;">
											<div>
												<table style="background-color: transparent;">
													<tr>
														<td style="padding-right: 25px">原始点云</td>
														<td>
															<button id="searchPC" style="height: 25px; width: 75px">匹配搜索</button>
															<button id="assignPC" style="height: 25px; width: 75px">绑定点云</button>
															<button id="clearPC" style="height: 25px; width: 75px">清空绑定</button>
														</td>
													</tr>
												</table>
											</div>
											<div>
												<table style="background-color: transparent;">
													<tr>
														<td style="padding-right: 20px">空间位置：</td>
														<td style="padding-left: 4px" data-toggle="distpicker">
															<input type="text" style="height: 25px; width: 105px;"
															id="pointlat" placeholder="中心经度"> <input
															type="text" style="height: 25px; width: 105px;"
															id="pointlon" placeholder="中心纬度">
														</td>
													</tr>
												</table>
											</div>
											<div>
												<table style="background-color: transparent;">
													<tr>
														<td style="padding-right: 20px">录入时间：</td>
														<td style="padding-left: 4px" data-toggle="distpicker">
															<input type="text" style="height: 25px; width: 105px;"
															id="pointfrom" class="from" placeholder="开始时间"> <input
															type="text" style="height: 25px; width: 105px;"
															id="pointto" class="to" placeholder="结束时间">
														</td>
													</tr>
												</table>
											</div>
											<div style="padding-top: 3px">
												<table id="table_pointinfo"></table>
											</div>
										</div>
									</div>
								</div>
								<div class="tab2.2"
									style="width: 50%; float: right; border-right: solid 1px;"
									align="center">
									<div id="myTabContent" class="tab-content">
										<div style="background-color: transparent; float: top;">
											<div>
												<table style="background-color: transparent;">
													<tr>
														<td style="padding-right: 20px">场景模型</td>
														<td>
															<button id="searchModel"
																style="height: 25px; width: 75px">匹配搜索</button>
															<button id="assignModel"
																style="height: 25px; width: 75px">绑定模型</button>
															<button id="clearModel" style="height: 25px; width: 75px">清空绑定</button>
														</td>
													</tr>
												</table>
											</div>
											<div>
												<table style="background-color: transparent;">
													<tr>
														<td style="padding-right: 20px">空间位置：</td>
														<td style="padding-left: 4px" data-toggle="distpicker">
															<input type="text" style="height: 25px; width: 105px;"
															id="modellat" placeholder="中心经度"> <input
															type="text" style="height: 25px; width: 105px;"
															id="modellon" placeholder="中心纬度">
														</td>
													</tr>
												</table>
											</div>
											<div>
												<table style="background-color: transparent;">
													<tr>
														<td style="padding-right: 20px">录入时间：</td>
														<td style="padding-left: 4px"><input type="text"
															style="height: 25px; width: 105px;" id="modelfrom"
															class="from" placeholder="开始时间"> <input
															type="text" style="height: 25px; width: 105px;"
															id="modelto" class="to" placeholder="结束时间"></td>
													</tr>
												</table>
											</div>
											<div style="padding-top: 3px">
												<table id="table_modelinfo"></table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- div align="center"
						style="float: top; padding-top: 1px border-top:solid 1px; border-left: solid 1px; border-right: solid 1px; border-bottom: solid 1px">
						<table style="background-color: transparent;">
							<tr>
								<td>
									<button id="Showpant" onclick="showplant()"
										style="height: 30px; width: 60px">初始化</button>
									<button id="ShowPoints" style="height: 30px; width: 45px">素材</button>
									<button id="ShowObj" style="height: 30px; width: 45px">模型</button>
									<button id="HideObj" style="height: 30px; width: 45px">去除</button>
									<button id="Clear" style="height: 30px; width: 45px">清空</button>
									<button id="showlayout" style="height: 30px; width: 45px">网格</button>
									<button id="deletelayout" style="height: 30px; width: 45px">隐藏</button>
									<button id="lockPoints" style="height: 30px; width: 45px">锁定</button>
									<button id="showBotton1" onclick="show3d()"
										style="height: 30px; width: 45px">素材</button>
									<button id="showBotton2" onclick="showrun()"
										style="height: 30px; width: 45px">展示</button>
									<button id="showBotton3" onclick="acc()"
										style="height: 30px; width: 45px">加速</button>
									<button id="showBotton4" onclick="stoprun()"
										style="height: 30px; width: 45px">停止</button>
								</td>
							</tr>
						</table>
					</div-->
					<!-- div align="left">
						<button id="showBotton1" onclick="show3d()">素材</button>
						<button id="showBotton2" onclick="showrun()">展示</button>
						<button id="showBotton3" onclick="acc()">加速</button>
						<button id="showBotton4" onclick="stoprun()">停止</button>
					</div-->
					<div align="center">
						<button id="showBotton1" onclick="show3d()"
							style="height: 30px; width: 60px">初始化</button>
						<button id="showBotton2" onclick="showrun()"
							style="height: 30px; width: 45px">展示</button>
						<button id="showBotton3" onclick="acc()"
							style="height: 30px; width: 45px">加速</button>
						<button id="showBotton4" onclick="stoprun()"
							style="height: 30px; width: 45px">停止</button>
						<button id="init" onclick="showall()"
							style="height: 30px; width: 60px">初始化</button>
						<button id="ShowPoints" style="height: 30px; width: 45px">素材</button>
						<button id="ShowObj" style="height: 30px; width: 45px">模型</button>
						<button id="HideObj" style="height: 30px; width: 45px">去除</button>
						<button id="Clear" style="height: 30px; width: 45px">清空</button>
						<button id="showlayout" style="height: 30px; width: 45px">网格</button>
						<button id="deletelayout" style="height: 30px; width: 45px">隐藏</button>
						<button id="lockPoints" style="height: 30px; width: 45px">锁定</button>
					</div>
					<div>
						<input type="text" style="height: 20px; width: 40px;" id="sceneid"
							class="sceneid" value="-1"> <input type="text"
							style="height: 20px; width: 80px;" id="minx" class="minx"
							placeholder="x" value="610970.9"> <input type="text"
							style="height: 20px; width: 80px;" id="miny" class="miny"
							placeholder="y" value="104542.53"> <input type="text"
							style="height: 20px; width: 80px;" id="maxz" class="maxz"
							placeholder="z" value="90.195"> <input type="text"
							style="height: 20px; width: 80px;" id="maxx" class="maxx"
							placeholder="x" value="611297.9"> <input type="text"
							style="height: 20px; width: 80px;" id="maxy" class="maxy"
							placeholder="y" value="104868.46"> <input type="text"
							style="height: 20px; width: 80px;" id="minz" class="minz"
							placeholder="z" value="10.841"> <input type="text"
							style="height: 20px; width: 80px;" id="cenx" class="cenx"
							placeholder="x" value="611150"> <input type="text"
							style="height: 20px; width: 80px;" id="ceny" class="ceny"
							placeholder="y" value="104710"> <input type="text"
							style="height: 20px; width: 80px;" id="cenz" class="cenz"
							placeholder="z" value="60"> <input type="text"
							style="height: 20px; width: 30px;" id="level" value="10">
						<input type="text" style="height: 20px; width: 30px;" id="locked"
							value="0"> <input type="text"
							style="height: 20px; width: 30px;" id="invalid" value="0">
					</div>
					<div style="width: 55%; float: right">
						<div id="3dshow"></div>
					</div>
					<!-- part of right -->

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