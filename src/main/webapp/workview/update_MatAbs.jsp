<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新要素信息</title>

	<!-- basic styles -->
	<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
	<script src="../js/jQuery/jquery-2.1.4.min.js"></script>
	<script src="http://i.gtimg.cn/qzone/biz/gdt/lib/jquery/jquery-2.1.4.js?max_age=31536000"></script>
	<!-- ace styles -->
	<!--  <link rel="stylesheet" href="../assets/css/ace.min.css" />-->
	<link href="../css/bootstrap/bootstrap-datepicker.css" rel="stylesheet">
	<link href="../css/bootstrap/bootstrap-datepicker3.css" rel="stylesheet">
	<link href="../css/bootstrap/css/bootstrap-table.css" rel="stylesheet">
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

<body  onload="get_id()">

<script>
    var image =document.getElementById('image');
    function selectImage(file) {
    	var element_image=document.getElementById('element_image');
        if (!file.files || !file.files[0]) {
            return;
        }
        var reader = new FileReader();
        reader.readAsDataURL(file.files[0]);
        reader.onload = function (evt) {
        	document.getElementById('image').src=evt.target.result;
            element_image.value=evt.target.result;
        }
    }
    
	jQuery(function($) {
		$(".date").datepicker({
			language : "zh-CN",
			autoclose : true,//选中之后自动隐藏日期选择框
			clearBtn : true,//清除按钮
			format : "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
		});
	});
	
    function get_id() {
        if (window.opener != null && !window.opener.closed) {
        	var rowdata=window.opener.document.getElementById("rowdata").value;
        	var json=JSON.parse(rowdata)
            document.getElementById('e_id').value =json.element_id;
            document.getElementById('e_manager').value =json.element_manager;
            document.getElementById('create_date').value =json.create_date;
            document.getElementById('e_remark').value =json.element_remark;
            document.getElementById('image').src =json.element_image;
            document.getElementById('element_image').value =json.element_image;
            document.getElementById('localname').value =json.localname;
        }
    }
</script>


     <div  style="background-color:transparent;padding-top:10px; float:top;" >
		<div  class="div-inline" style="background-color:transparent;padding-left:10px; float:left;">
			<table style="background-color:transparent;">	
			
				<tr>
					<td style="padding-left:5px;padding-top:10px">要素编号：</td>
					<td style="padding-left:4px;padding-top:10px">
					<input id="e_id"  style="width:185px;height:25px;" disabled="disabled" ></input>
					</td>					
				</tr>
				<tr >
					<td style="padding-left:5px;padding-top:10px">负责人：</td>
					<td style="padding-left:5px;padding-top:10px">
						<input id="e_manager" style= "height:25px;width:185px;"></input>
					</td>					
				</tr>
				
				<tr>
					<td style="padding-left:5px;padding-top:10px">录入日期：</td>
					<td style="padding-left:4px;padding-top:10px">
					<input type="text" style= "height:25px;width:185px;"id="create_date" class="date"  value=<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%> >									
					</td>					
				</tr>
				
				<tr >
					<td style="padding-left:5px;padding-top:10px">要素备注：</td>
					<td style="padding-left:5px;padding-top:10px">
						<textarea id="e_remark" rows="1" cols="20"></textarea>
					</td>					
				</tr>	
				
				<tr >
					<td style="padding-left:5px;padding-top:10px">要素图片：</td>
					<td style="padding-left:5px;padding-top:10px">
	                            <input type="file"  id="e_image"  class="file-btn" onchange="selectImage(this)"/>
					</td>	
				</tr> 
			</table>
			
			<textarea style="display:none"  id="element_image" rows="1" cols="40" ></textarea>
			<textarea style="display:none"  id="localname" rows="1" cols="40" ></textarea>
		</div>
		
		
		<div class="div-inline" style="background-color:transparent;padding-left:10px; padding-top: 10px;float:left;">
				<img id="image" src=""   height=200  alt="请选择图片"  />
		</div>
		<div class="div-inline" style="background-color:transparent;padding-left:10px; padding-top: 10px;float:left;">
				<canvas id="myCanvas" ></canvas>
		</div>
	</div>

	<div style="background-color: transparent; float:top;padding-top: 300px" align="center">
		<button id="add" style= "height:25px;width:65px" onClick="material_abstract_update()">更新</button>				
		<button id="close" style= "height:25px;width:65px" onClick="window.close()">取消</button>	
	</div>
	
	
</body>
</html>

