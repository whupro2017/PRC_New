
var jq = jQuery.noConflict();

function dataURLtoBlob(dataurl) { 
	var arr = dataurl.split(','), mime = arr[0].match(/:(.*?);/)[1], 
	      bstr = atob(arr[1]), n = bstr.length, u8arr = new Uint8Array(n);
	while(n--){ 
		u8arr[n] = bstr.charCodeAt(n);
		} 
	return new Blob([u8arr], {type:mime}); 
}

function compress() { 
	var canvas, ctx, img64,myimage;
     canvas=document.getElementById('myCanvas');
	 myimage = document.getElementById('image');
     var scale=myimage.height/myimage.width;
	canvas.width =3200; 
	canvas.height =parseInt(canvas.width * scale);
	console.log("图片长为："+canvas.height+"宽为："+canvas.width+"长宽比为："+scale);
	ctx = canvas.getContext("2d"); 
	ctx.drawImage(myimage, 0, 0, canvas.width,canvas.height); 
	img64 = canvas.toDataURL("image/jpeg", 0.3); 
	return img64; // 压缩后的base64串 }
}

function inqluru() {
	console.log("到28行  ");
	var id = jq('#c_id').val();
	var type = jq('#c_type').val();
	var manager = jq('#c_manager').val();
	var remark = jq('#c_remark').val();
	var case_image = jq('#case_image').val();
	var create_date = jq('#create_date').val();
	var final_image;
	console.log("到263行  原图大小："+case_image.length);
	if (case_image.length>1800000){
		final_image=compress();
	}
	else{
		final_image=case_image;
	}
	document.getElementById('image11').src =final_image ;
	if (id == "" || manager == "" || remark == ""|| case_image == "") {
		alert("请填写完整");
	} else {
		//var blob = dataURLtoBlob(case_image); 
		var fileObj = document.getElementById("c_image").files[0]; 
		var fd = new FormData(); 
		fd.append("file", fileObj);
		var xhr = new XMLHttpRequest(); 
		xhr.open('POST', '/pro/TestCaseQueryController/StoreRawImage',true); 
		xhr.send(fd);
		jq.ajax({
			url : '/pro/TestCaseQueryController/IdIsExsit?id=' + id,
			type : 'POST',
			data : "{}",
			dataType : 'json',
			success : function(data) {
				console.log("到59行 "+data);
				var jsonLength = 0;
				for ( var item in data) {
					jsonLength++;
				}
				if (jsonLength > 0) {
					alert("案件编号:" + id + " 已经存在,请重新输入");
				} else {console.log("到287行  压缩图片大小："+final_image.length);
						jq.ajax({
										url : '/pro/TestCaseQueryController/InsertCase?id=' + id
												+ '&type=' + type + '&manager=' + manager
												+  '&remark=' + remark +  '&case_image=' + final_image +  '&create_date=' + create_date,
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


function material_dna_luru() {
	var id = jq('#c_id').val();
	var type = jq('#c_type').val();
	var manager = jq('#c_manager').val();
	var remark = jq('#c_remark').val();
	var case_image = jq('#case_image').val();
	var create_date = jq('#create_date').val();
	console.log("創建時間"+create_date);
	if (id == "" || manager == "" || remark == ""|| case_image == "") {
		alert("请填写完整");
	} else {
		jq.ajax({
			url : '/pro/MaterialDnaQueryController/IdIsExsit?id=' + id,
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
										url : '/pro/MaterialDnaQueryController/InsertCase?id=' + id
												+ '&type=' + type + '&manager=' + manager
												+  '&remark=' + remark +  '&case_image=' + case_image +  '&create_date=' + create_date,
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

function material_footmark_luru() {
	var id = jq('#c_id').val();
	var type = jq('#c_type').val();
	var manager = jq('#c_manager').val();
	var remark = jq('#c_remark').val();
	var case_image = jq('#case_image').val();
	var create_date = jq('#create_date').val();
	console.log("創建時間"+create_date);
	if (id == "" || manager == "" || remark == ""|| case_image == "") {
		alert("请填写完整");
	} else {
		jq.ajax({
			url : '/pro/MaterialFootmarkQueryController/IdIsExsit?id=' + id,
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
										url : '/pro/MaterialFootmarkQueryController/InsertCase?id=' + id
												+ '&type=' + type + '&manager=' + manager
												+  '&remark=' + remark +  '&case_image=' + case_image +  '&create_date=' + create_date,
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

function material_fingerprint_luru() {
	var id = jq('#c_id').val();
	var type = jq('#c_type').val();
	var manager = jq('#c_manager').val();
	var remark = jq('#c_remark').val();
	var case_image = jq('#case_image').val();
	var create_date = jq('#create_date').val();
	console.log("創建時間"+create_date);
	if (id == "" || manager == "" || remark == ""|| case_image == "") {
		alert("请填写完整");
	} else {
		jq.ajax({
			url : '/pro/MaterialFingerprintQueryController/IdIsExsit?id=' + id,
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
										url : '/pro/MaterialFingerprintQueryController/InsertCase?id=' + id
												+ '&type=' + type + '&manager=' + manager
												+  '&remark=' + remark +  '&case_image=' + case_image +  '&create_date=' + create_date,
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

function material_abstract_luru() {
	var id = jq('#c_id').val();
	var type = jq('#c_type').val();
	var manager = jq('#c_manager').val();
	var remark = jq('#c_remark').val();
	var case_image = jq('#case_image').val();
	var create_date = jq('#create_date').val();
	console.log("創建時間"+create_date);
	if (id == "" || manager == "" || remark == ""|| case_image == "") {
		alert("请填写完整");
	} else {
		jq.ajax({
			url : '/pro/MaterialAbstractQueryController/IdIsExsit?id=' + id,
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
										url : '/pro/MaterialAbstractQueryController/InsertCase?id=' + id
												+ '&type=' + type + '&manager=' + manager
												+  '&remark=' + remark +  '&case_image=' + case_image +  '&create_date=' + create_date,
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

function material_evidence_luru() {
	var id = jq('#c_id').val();
	var type = jq('#c_type').val();
	var manager = jq('#c_manager').val();
	var remark = jq('#c_remark').val();
	var case_image = jq('#case_image').val();
	var create_date = jq('#create_date').val();
	console.log("創建時間"+create_date);
	if (id == "" || manager == "" || remark == ""|| case_image == "") {
		alert("请填写完整");
	} else {
		jq.ajax({
			url : '/pro/MaterialEvidenceQueryController/IdIsExsit?id=' + id,
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
										url : '/pro/MaterialEvidenceQueryController/InsertCase?id=' + id
												+ '&type=' + type + '&manager=' + manager
												+  '&remark=' + remark +  '&case_image=' + case_image +  '&create_date=' + create_date,
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
			document.getElementById('level').value = data.maxlevel - 3;
			document.getElementById('minlevel').value = data.maxlevel - 3;
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
