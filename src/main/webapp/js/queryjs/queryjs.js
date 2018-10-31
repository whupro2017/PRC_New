/**
 * 
 */
var jq = jQuery.noConflict();

function luru() {
	var id = jq('#c_id').val();
	var time = jq(".date").val();
	var pro = jq('#prov').val();
	var city = jq('#city').val();
	var dis = jq('#dis').val();
	var type = jq('#s_type').val();
	var des = jq('#c_des').val();
	if (id == "" || time == "" || des == "") {
		alert("请填写完整");
	} else {
		jq.ajax({
			url : '/pro/CaseQueryController/IdIsExsit?id=' + id,
			type : 'POST',
			data : "{}",
			dataType : 'json',
			success : function(data) {
				console.log(data);
				var jsonLength = 0;
				for ( var item in data) {
					jsonLength++;
				}
				if (jsonLength > 0) {
					alert("案件编号:" + id + " 已经存在,请重新输入");
				} else {
					jq.ajax({
						url : '/pro/CaseQueryController/InsertCase?id=' + id
								+ '&beginTime=' + time + '&pro=' + pro
								+ '&city=' + city + '&dis=' + dis + '&des='
								+ des + '&type=' + type,
						type : 'POST',
						success : function() {
							alert("录入成功");
							window.close();
						},
						error : function() {
							console.log("录入失败");
						}
					});
				}
			},
			error : function() {
				console.log("获取失败");
			}
		});
	}
}

function load_m() {
	var id = jq('#check_id').val();
	if (id == "") {
		alert("请先勾选要查看的案件");
	} else {
		alert("load 案件 " + id + " 的素材");
	}
}

function load_t() {
	var id = jq('#check_id').val();
	if (id == "") {
		alert("请先勾选要查看的案件");
	} else {
		alert("load 案件 " + id + " 的移动轨迹");
	}
}

function loadmeta() {
	var id = jq('#sceneid').val();
	jq.ajax({
		async : false,
		cache : false,
		type : 'POST',
		datatype : 'json',
		url : '/pro/PointInfoQueryController/getPointInfoById?id=' + id,
		datatype : "json",
		mtype : 'POST',
		success : function(data) {
			console.log("data count:" + data.id + "," + data.minx + ","
					+ data.max + "," + data.mdnx + "," + data.minlevel + ","
					+ data.maxlevel);
			document.getElementById('minx').value = data.minx;
			document.getElementById('miny').value = data.miny;
			document.getElementById('minz').value = data.minz;
			document.getElementById('maxx').value = data.maxx;
			document.getElementById('maxy').value = data.maxy;
			document.getElementById('maxz').value = data.maxz;
			document.getElementById('cenx').value = data.mdnx;
			document.getElementById('ceny').value = data.mdny;
			document.getElementById('cenz').value = data.mdnz;
			document.getElementById('level').value = data.minlevel;
			document.getElementById('minlevel').value = data.minlevel;
			document.getElementById('maxlevel').value = data.maxlevel;
		}
	})
}

function show3d() {
	jq("#3dshow").load("/pro/3dshow/all_3d.jsp");
	jq("#showBotton1").attr("disabled", true);
}

function showall() {
	jq("#3dshow").load("/pro/3dshow/burndisplay.jsp");
	jq("#init").attr("disabled", true);
}

function showplant() {
	jq("#plantshow").load("/pro/3dshow/points.jsp");
	jq("#Showpant").attr("disabled", true);
}
