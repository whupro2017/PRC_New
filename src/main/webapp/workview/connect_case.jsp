<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>关联案件</title>

	<!-- basic styles -->
	<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
	<script src="../js/jQuery/jquery-2.1.4.min.js"></script>
	<script src="http://i.gtimg.cn/qzone/biz/gdt/lib/jquery/jquery-2.1.4.js?max_age=31536000"></script>
	<!-- page content -->
	<link rel="stylesheet" href="../assets/css/jquery-ui-1.10.3.full.min.css" />
	<link rel="stylesheet" href="../assets/css/ui.jqgrid.css" />
	<!-- ace styles -->
	<!--  <link rel="stylesheet" href="../assets/css/ace.min.css" />-->
	
    <link rel="stylesheet" href="../assets/css/ace.min.css" />
	<link rel="stylesheet" href="../assets/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="../assets/css/ace-skins.min.css" />
	<link href="../css/bootstrap/bootstrap-datepicker.css" rel="stylesheet">
	<link href="../css/bootstrap/bootstrap-datepicker3.css" rel="stylesheet">
	<link href="../css/bootstrap/css/bootstrap-table.css" rel="stylesheet">
	<link rel="stylesheet" href="../zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script src="../js/jQuery/jquery-2.1.4.min.js" type="text/javascript"></script>
	<script src="../assets/js/ace-extra.min.js" type="text/javascript"></script>
	<script src="../js/datapicker/bootstrap-datepicker.js" type="text/javascript"></script>
	<script src="../js/datapicker/bootstrap-datepicker.zh-CN.js" type="text/javascript"></script>
	<script src="../js/bootstrap/bootstrap3.2.js"></script>
	<script src="../js/bootstraptable/bootstrap-table.js"></script>
	<script src="../js/queryjs/queryjs.js" type="text/javascript"></script>
	
	<!-- jqGrid -->
	<script src="../assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../assets/js/typeahead-bs2.min.js" type="text/javascript"></script>
	<script src="../assets/js/jqGrid/jquery.jqGrid.min.js" type="text/javascript"></script>
	<script src="../assets/js/jqGrid/i18n/grid.locale-en.js" type="text/javascript"></script>
	
	<script type="text/javascript" src="../js/queryjs/queryjs.js"></script>
    <script type="text/javascript"  src="../js/queryjs/query_table.js"></script>
</head>


<body onload="get_id()" >

<script type="text/javascript">
    function get_id() {
        if (window.opener != null && !window.opener.closed) {
        	var element_id = window.opener.document.getElementById("check_id").value;//获取父窗口中元素，此处获得要素编号
            document.getElementById('e_id').value = element_id;
            var type_id = window.opener.document.getElementById("type_id").value;//获取父窗口中元素，此处获得类型编号
            document.getElementById('t_id').value = type_id;
        }
    }
</script>


	<div style="background-color: transparent; float: top;padding-top: 5px">
		<table style="background-color: transparent;">
			<tr>
				<td style="padding-left: 5px">案件关键字：</td>
				<td style="padding-left: 4px">
				     <textarea id="case_keyword" rows="1" cols="37"></textarea>
				</td>
				<td style="padding-left: 20px">查询时间：</td>
				<td style="padding-left: 20px">
							<input type="text" 	style="height: 25px; width: 105px;" id="case_from" class="date" placeholder="开始时间">
						    <input type="text"    style="height: 25px; width: 105px;" id="case_to" class="date" placeholder="结束时间">
					        <button id="CaseQueryByKeywordBotton" style="height: 25px; width: 65px">查询</button>
				</td>
			</tr>
		</table>
	   </div>

	<div style="padding-top: 3px">
		<table id="case_table"></table>
	</div>
		<div  class="div-inline" style="background-color:transparent;padding-left:10px; float:left;">
			<table style="background-color:transparent;">	
			
				<tr>
					<td style="padding-left:5px;padding-top:10px">要素编号：</td>
					<td style="padding-left:4px;padding-top:10px">
					<input id="e_id"  style="width:163px;height:25px;" disabled="disabled" ></input>
					</td>					
				</tr>
				
				<tr>
					<td style="padding-left:5px;padding-top:10px">要素类型：</td>
					<td style="padding-left:4px;padding-top:10px">
					<input id="t_id"  style="width:163px;height:25px;" disabled="disabled" ></input>
					</td>					
				</tr>
				
			    <tr>
					<td style="padding-left:5px;padding-top:10px">案件编号：</td>
					<td style="padding-left:4px;padding-top:10px">
					<input id="c_id"  style="width:163px;height:25px;" disabled="disabled" ></input>
					</td>					
				</tr>
				
				<tr>
					<td style="padding-left:5px;padding-top:10px">操作人员：</td>
					<td style="padding-left:4px;padding-top:10px">
					<input id="admin"  style="width:163px;height:25px;" ></input>
					</td>					
				</tr>
			</table>
		</div>

	<div style="background-color: transparent; float:top;padding-top: 300px" align="center">
		<button id="add" style= "height:25px;width:65px" onClick="new_connection()">关联</button>				
		<button id="close" style= "height:25px;width:65px" onClick="window.close()">取消</button>	
	</div>
	
	
</body>
</html>

