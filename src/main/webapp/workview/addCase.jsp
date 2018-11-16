<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>录入案件</title>
	<!-- basic styles -->
	<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
	<script src="../js/jQuery/jquery-2.1.4.min.js"></script>
	<!-- page content -->
	<!-- 时间选择 -->
	<script src="../js/datapicker/bootstrap-datepicker.js" type="text/javascript"></script>
	<script src="../js/datapicker/bootstrap-datepicker.zh-CN.js" type="text/javascript"></script>	
	<link href="../css/bootstrap/bootstrap-datepicker.css" rel="stylesheet">
	<link href="../css/bootstrap/bootstrap-datepicker3.css" rel="stylesheet">

	<script type="text/javascript">
		var jq = jQuery.noConflict();
	    jq(function () {
	        jq(".date").datepicker({
	            language: "zh-CN",
	            autoclose: true,//选中之后自动隐藏日期选择框
	            clearBtn: true,//清除按钮
	            format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
	        });
	    });	    
	</script>
	
	<!-- 三级联动 -->	
	<script src="../js/city/bootstrap.min.js"></script>
	<script src="../js/city/distpicker.data_1.js"></script>
	<script src="../js/city/distpicker_1.js"></script>
	
	<script type="text/javascript" src="../js/queryjs/queryjs.js"></script>
	
</head>

<body>
	<div style="background-color:transparent;padding-left:10px; float:top;">
		<table style="background-color:transparent;">	
		
			<tr>
				<td style="padding-left:5px;padding-top:10px">案件编号：</td>
				<td style="padding-left:4px;padding-top:10px">
				<textarea id="c_id" rows="1" cols="8"></textarea>
				</td>					
			</tr>
			
			<tr>
				<td style="padding-left:5px;padding-top:10px">发生时间：</td>
				<td style="padding-left:4px;padding-top:10px">
				<input type="text" style= "height:25px;width:76px;" id=".date" class="date" placeholder="时间">									
				</td>					
			</tr>
				
			<tr>
				<td style="padding-left:5px;padding-top:10px">案件地区：</td>
				<td style="padding-left:4px;padding-top:10px"  >
					<div data-toggle="distpicker">
					<select id="prov" style= "height:25px;width:76px;" class="prov"></select>
					<select id="city" style= "height:25px;width:125px;" class="city"></select>
					<select id="dis" style= "height:25px;width:76px;" class="district"></select>
					</div>
				</td>						
			</tr>
			<tr >
				<td style="padding-left:5px;padding-top:10px">案件类型：</td>
				<td style="padding-left:5px;padding-top:10px">
					<select id="s_type" style= "height:25px;width:76px;">
					  <option value ="放火">放火</option>
					  <option value ="爆炸">爆炸</option>
					  <option value="抢盗">抢盗</option>
					  <option value="碰撞">碰撞</option>
					</select>
				</td>					
			</tr>
			
			<tr >
				<td style="padding-left:5px;padding-top:10px">案件描述：</td>
				<td style="padding-left:5px;padding-top:10px">
					<textarea id="c_des" rows="1" cols="40"></textarea>
				</td>					
			</tr>						
		</table>
	</div>
	
	
	<div style="padding-top:20px" align="center">
		<button id="add" style= "height:25px;width:65px" onClick="luru()">录入</button>				
		<button id="close" style= "height:25px;width:65px" onClick="window.close()">取消</button>	
	</div>
</body>
</html>
