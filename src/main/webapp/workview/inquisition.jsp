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
		$(".date").datepicker({
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
				<a href="#" class="navbar-brand"> <img src="./logo.png" /> <text
						style="vertical-align:middle;">案事件现场勘验综合展示系统</text>
				</a>
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
							class="menu-text"> 模型管理 </span>
					</a></li>

					<li class="active"><a href="inquisition.jsp"> <i
							class="icon-hand-up"></i> <span class="menu-text"> 要素管理 </span>
					</a></li>

					<li><a href="burn_index.jsp"> <i class="icon-fire"></i> <span
							class="menu-text"> 放火案件 </span>
					</a></li>

					<li><a href="bom_index.jsp"> <i class="icon-certificate"></i>
							<span class="menu-text"> 爆炸案件</span>
					</a></li>

					<li><a href="grab_index.jsp"> <i class="icon-jpy"></i> <span
							class="menu-text"> 抢盗案件 </span>
					</a></li>

					<li><a href="kill_index.jsp"> <i class="icon-tint"></i> <span
							class="menu-text"> 碰撞案件</span>
					</a></li>

					<!-- li>
							<a href="points.jsp">
								<i class="icon-spinner"></i>
								<span class="menu-text"> 点云展示 </span>
							</a>
						</li>
						
						<li>
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
								<li class="active"><a href="#case_inquisition" data-toggle="tab">
										案例查询 </a></li>
								<li><a href="#abstract" data-toggle="tab"> 提取信息 </a></li>
								<li><a href="#evidence" data-toggle="tab"> 物证信息 </a></li>
								<li><a href="#home" data-toggle="tab"> 主体信息 </a></li>
								<li><a href="#home" data-toggle="tab"> 并案信息 </a></li>
								<li><a href="#home" data-toggle="tab"> 嫌疑人信息 </a></li>
								<li><a href="#fingerprint" data-toggle="tab"> 指纹数据 </a></li>
								<li><a href="#footmark" data-toggle="tab"> 足迹 </a></li>
								<li><a href="#kancha" data-toggle="tab"> 法庭科学</a></li>
								<li><a href="#dna" data-toggle="tab"> DNA </a></li>
								<!-- li><a href="#material" data-toggle="tab">案例素材</a></li>
								<li><a href="#trail" data-toggle="tab">移动轨迹</a></li-->
							</ul>

							<div id="myTabContent" class="tab-content">
							    <div class="tab-pane fade in active" id="case_inquisition">
									<div style="background-color: transparent; float: top;">
										<table style="background-color: transparent;">
											<tr>
												<td style="padding-left: 5px">查询关键字：</td>
												<td style="padding-left: 4px">
												     <textarea id="key_word" rows="1" cols="37"></textarea>
												</td>
												<td class="tdTwo" rowspan="2" style="padding-left: 15px;">
													<button id="AddCase"
														style="height: 30px; width: 60px; background-color: #0099ff"
														onclick="diag()">录入</button>
												</td>
											</tr>
											<tr>
												<td style="padding-left: 5px">查询时间：</td>
												<td style="padding-left: 4px">
															<input type="text" 	style="height: 25px; width: 105px;" id="begin_date" class="date" placeholder="开始时间">
														    <input type="text"    style="height: 25px; width: 105px;" id="end_date" class="date" placeholder="结束时间">
													        <button id="CaseInquisitionBotton" style="height: 25px; width: 65px">查询</button>
												</td>
											</tr>
										</table>
									   </div>
									<div style="padding-top: 3px">
										<table id="table_inquisition"></table>
									</div>
								</div>
								
								<div class="tab-pane fade " id="abstract"   >
									<div style="background-color: transparent; float: top;">
										<table style="background-color: transparent;">
											<tr>
												<td style="padding-left: 5px">查询关键字：</td>
												<td style="padding-left: 4px">
												     <textarea id="abstract_keyword" rows="1" cols="37"></textarea>
												</td>
												<td class="tdTwo" rowspan="2" style="padding-left: 15px;">
													<button id="AddCase"
														style="height: 30px; width: 60px; background-color: #0099ff"
														onclick="abs()">录入</button>
												</td>
											</tr>
											<tr>
												<td style="padding-left: 5px">查询时间：</td>
												<td style="padding-left: 4px">
															<input type="text" 	style="height: 25px; width: 105px;" id="abstract_from" class="date" placeholder="开始时间">
														    <input type="text"    style="height: 25px; width: 105px;" id="abstract_to" class="date" placeholder="结束时间">
													        <button id="MaterialAbstractBotton" style="height: 25px; width: 65px">查询</button>
												</td>
											</tr>
										</table>
									   </div>
									<div style=" width:45%;padding-top: 3px">
										<table id="table_abstract"></table>
									</div>
								</div>
								
								<div class="tab-pane fade " id="evidence"   >
									<div style="background-color: transparent; float: top;">
										<table style="background-color: transparent;">
											<tr>
												<td style="padding-left: 5px">查询关键字：</td>
												<td style="padding-left: 4px">
												     <textarea id="evidence_keyword" rows="1" cols="37"></textarea>
												</td>
												<td class="tdTwo" rowspan="2" style="padding-left: 15px;">
													<button id="AddCase"
														style="height: 30px; width: 60px; background-color: #0099ff"
														onclick="evi()">录入</button>
												</td>
											</tr>
											<tr>
												<td style="padding-left: 5px">查询时间：</td>
												<td style="padding-left: 4px">
															<input type="text" 	style="height: 25px; width: 105px;" id="evidence_from" class="date" placeholder="开始时间">
														    <input type="text"    style="height: 25px; width: 105px;" id="evidence_to" class="date" placeholder="结束时间">
													        <button id="MaterialEvidenceBotton" style="height: 25px; width: 65px">查询</button>
												</td>
											</tr>
										</table>
									   </div>
									<div style=" width:45%;padding-top: 3px">
										<table id="table_evidence"></table>
									</div>
								</div>
								
								<div class="tab-pane fade " id="fingerprint"   >
									<div style="background-color: transparent; float: top;">
										<table style="background-color: transparent;">
											<tr>
												<td style="padding-left: 5px">查询关键字：</td>
												<td style="padding-left: 4px">
												     <textarea id="fingerprint_keyword" rows="1" cols="37"></textarea>
												</td>
												<td class="tdTwo" rowspan="2" style="padding-left: 15px;">
													<button id="AddCase"
														style="height: 30px; width: 60px; background-color: #0099ff"
														onclick="finger()">录入</button>
												</td>
											</tr>
											<tr>
												<td style="padding-left: 5px">查询时间：</td>
												<td style="padding-left: 4px">
															<input type="text" 	style="height: 25px; width: 105px;" id="fingerprint_from" class="date" placeholder="开始时间">
														    <input type="text"    style="height: 25px; width: 105px;" id="fingerprintto" class="date" placeholder="结束时间">
													        <button id="MaterialFingerprintBotton" style="height: 25px; width: 65px">查询</button>
												</td>
											</tr>
										</table>
									   </div>
									<div style=" width:45%;padding-top: 3px">
										<table id="table_fingerprint"></table>
									</div>
								</div>
								
								<div class="tab-pane fade " id="footmark"   >
									<div style="background-color: transparent; float: top;">
										<table style="background-color: transparent;">
											<tr>
												<td style="padding-left: 5px">查询关键字：</td>
												<td style="padding-left: 4px">
												     <textarea id="footmark_keyword" rows="1" cols="37"></textarea>
												</td>
												<td class="tdTwo" rowspan="2" style="padding-left: 15px;">
													<button id="AddCase"
														style="height: 30px; width: 60px; background-color: #0099ff"
														onclick="foot()">录入</button>
												</td>
											</tr>
											<tr>
												<td style="padding-left: 5px">查询时间：</td>
												<td style="padding-left: 4px">
															<input type="text" 	style="height: 25px; width: 105px;" id="footmark_from" class="date" placeholder="开始时间">
														    <input type="text"    style="height: 25px; width: 105px;" id="footmark_to" class="date" placeholder="结束时间">
													        <button id="MaterialFootmarkBotton" style="height: 25px; width: 65px">查询</button>
												</td>
											</tr>
										</table>
									   </div>
									<div style=" width:45%;padding-top: 3px">
										<table id="table_footmark"></table>
									</div>
								</div>
								
								<div class="tab-pane fade " id="dna"   >
									<div style="background-color: transparent; float: top;">
										<table style="background-color: transparent;">
											<tr>
												<td style="padding-left: 5px">查询关键字：</td>
												<td style="padding-left: 4px">
												     <textarea id="dna_keyword" rows="1" cols="37"></textarea>
												</td>
												<td class="tdTwo" rowspan="2" style="padding-left: 15px;">
													<button id="AddCase"
														style="height: 30px; width: 60px; background-color: #0099ff"
														onclick="dna()">录入</button>
												</td>
											</tr>
											<tr>
												<td style="padding-left: 5px">查询时间：</td>
												<td style="padding-left: 4px">
															<input type="text" 	style="height: 25px; width: 105px;" id="dna_from" class="date" placeholder="开始时间">
														    <input type="text"    style="height: 25px; width: 105px;" id="dna_to" class="date" placeholder="结束时间">
													        <button id="MaterialDnaBotton" style="height: 25px; width: 65px">查询</button>
												</td>
											</tr>
										</table>
									   </div>
									<div style=" width:45%;padding-top: 3px">
										<table id="table_dna"></table>
									</div>
								</div>
								
								<div class="tab-pane fade" id="home">
									<div style="background-color: transparent; float: top;">
										<table style="background-color: transparent;">
											<tr>
												<td style="padding-left: 5px">查询地区：</td>
												<td style="padding-left: 4px">
													<div data-toggle="distpicker">
														<select id="prov" style="height: 25px; width: 76px;"
															class="prov"></select> <select id="city"
															style="height: 25px; width: 125px;" class="city"></select>
														<select id="dis" style="height: 25px; width: 76px;"
															class="district"></select>
													</div>
												</td>
												<td class="tdTwo" rowspan="2" style="padding-left: 15px;">
													<button id="AddCase"
														style="height: 30px; width: 60px; background-color: #0099ff"
														onclick="diag()">录入</button>
												</td>
											</tr>
											<tr>
												<td style="padding-left: 5px">查询时间：</td>
												<td style="padding-left: 4px"><input type="text"
													style="height: 25px; width: 105px;" id="from" class="date"
													placeholder="开始时间"> <input type="text"
													style="height: 25px; width: 105px;" id="to" class="date"
													placeholder="结束时间">
													<button id="CaseInqueryBotton"
														style="height: 25px; width: 65px">查询</button></td>
											</tr>
										</table>
									</div>
									  <div style="padding-top: 3px">
										<table id="table_all"></table>
									</div>
								</div>

								<div class="tab-pane fade" id="kancha">
									<div style="background-color: transparent; float: top;">
										<table style="background-color: transparent;">
											<tr>
												<td style="padding-left: 5px">查询地区：</td>
												<td style="padding-left: 4px">
													<div data-toggle="distpicker">
														<select id="prov" style="height: 25px; width: 76px;"
															class="prov"></select> <select id="city"
															style="height: 25px; width: 125px;" class="city"></select>
														<select id="dis" style="height: 25px; width: 76px;"
															class="district"></select>
													</div>
												</td>
												<td class="tdTwo" rowspan="2" style="padding-left: 15px;">
													<button id="AddCase"
														style="height: 30px; width: 60px; background-color: #0099ff"
														onclick="diag()">录入</button>
												</td>
											</tr>
											<tr>
												<td style="padding-left: 5px">查询时间：</td>
												<td style="padding-left: 4px"><input type="text"
													style="height: 25px; width: 105px;" id="from" class="from"
													placeholder="开始时间"> <input type="text"
													style="height: 25px; width: 105px;" id="to" class="to"
													placeholder="结束时间">
													<button id="CaseInqueryBotton"
														style="height: 25px; width: 65px">查询</button></td>
											</tr>
										</table>
									</div>

									<div style="padding-top: 3px">
										<table id="table_all"></table>
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
							<div align="center"
								style="float: top; padding-top: 1px border-top:solid 1px; border-left: solid 1px; border-right: solid 1px; border-bottom: solid 1px">
								<text>展示案件 ：</text>
								<input style="height: 25px; width: 55px;" type="text"
									id="check_id" disabled="true" />
							</div>
							<div style="float: bottom;">
								<div class="tab2.1"
									style="width: 50%; float: left; border-left: solid 1px; border-right: solid 1px"
									align="center">
									<text>关联信息:</text>
									<p>
										<textarea id="correlation" rows="20" cols="27"></textarea>
									</p>

								</div>
								<div class="tab2.2"
									style="width: 50%; float: right; border-right: solid 1px;"
									align="center">
									<text>外联信息:</text>
									<p>
										<textarea id="e-correlation" rows="20" cols="27"></textarea>
									</p>
								</div>
							</div>

						</div>

					</div>

					<div style="width: 55%; float: right">
						<div align="center">
							<button id="showBotton1" onclick="show3d()">素材展示</button>
							<button id="showBotton2" onclick="showrun()">动态展示</button>
							<button id="showBotton3" onclick="acc()">加速</button>
							<button id="showBotton4" onclick="stoprun()">停止</button>
						</div>

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
		<img id="case_image"  src= ""    hidden="true"  width="220px" title="案件图片"  />
		
		
	</div>
	<!-- /.main-container -->
	


	<script type="text/javascript">
		function diag() {
			window
					.open(
							"inq_addCase.jsp",
							"inq_addCase",
							"height=700, width=1000, top=200, left=300,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
		}
		function abs() {
			window
					.open(
							"add_materialabstract.jsp",
							"add_materialabstract",
							"height=700, width=1000, top=200, left=300,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
		}
		
		function evi() {
			window
					.open(
							"add_materialevidence.jsp",
							"add_materialevidence",
							"height=700, width=1000, top=200, left=300,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
		}
		
		function finger() {
			window
					.open(
							"add_materialfingerprint.jsp",
							"add_materialfingerprint",
							"height=700, width=1000, top=200, left=300,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
		}
		
		function foot() {
			window
					.open(
							"add_materialfootmark.jsp",
							"add_materialfootmark",
							"height=700, width=1000, top=200, left=300,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
		}
		
		function dna() {
			window
					.open(
							"add_materialdna.jsp",
							"add_materialevidedna",
							"height=700, width=1000, top=200, left=300,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
		}
		
		function showimage(image) {
			/*var newwin=window.open();                                           
			myimg=newwin.document.createElement("img");
			myimg.src=image;
			newwin.document.body.appendChild(myimg);*/
			document.getElementById("case_image").src=image;
			window
					.open(
							"showimage.jsp",
							"showimage",
							"height=700, width=1200, top=200, left=300,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
		}
	</script>
</body>
</html>