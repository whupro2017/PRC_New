jQuery(function($) {
	var grid_selector = "#case_table";
	var jq = jQuery.noConflict();
	var case_from;
	var case_to;
	var case_keyword;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}

	$('#CaseQueryByKeywordBotton')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						case_keyword = $('#case_keyword').val();
						case_from = $('#case_from').val();
						case_to = $('#case_to').val();
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/CaseQueryController/getAllCaseByKeyword?beginTime='
													+ case_from
													+ '&endTime='
													+ case_to
													+ '&keyword='
													+ case_keyword,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',
		
		height : 200,
		colNames : [ '案件编号', '案件时间', '案件地点', '案件描述' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 35,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_time',
			index : 'case_time',
			width : 40,
			editable : false
		}, {
			name : 'case_location',
			index : 'case_location',
			width : 80,
			sortable : false,
			editable : false
		}, {
			name : 'case_desc',
			index : 'case_desc',
			width : 50,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		multiselect : true,
		multiboxonly : true,
		beforeSelectRow: function()
	    {
	        jQuery(grid_selector).jqGrid('resetSelection');
	        return(true);
	    },
		
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},

		onSelectRow : function(id) {
			var selecs = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
			var rowid = $(grid_selector).getGridParam("selrow");
			var rowData = $(grid_selector).getRowData(rowid);
			var cid = rowData.case_id;
			document.getElementById('c_id').value = cid;
		},

		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_all";
	var jq = jQuery.noConflict();
	var from;
	var to;
	var pro;
	var city;
	var dis;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}

	console.log(from + "," + to + "," + pro + "," + city + "," + dis);
	$('#CaseInqueryBotton')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						from = $('#from').val();
						to = $('#to').val();
						pro = $('#prov').val();
						city = $('#city').val();
						dis = $('#dis').val();

						console.log(from + "," + to + "," + pro + "," + city
								+ "," + dis);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/CaseQueryController/getAllCase?beginTime='
													+ from
													+ '&endTime='
													+ to
													+ '&pro='
													+ pro
													+ '&city='
													+ city + '&dis=' + dis,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',
		multiselect: false,
		multiboxonly:false,
		beforeSelectRow: beforeSelectRow,

		height : 320,
		colNames : [ '案件编号', '案件时间', '案件地点', '案件描述' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 35,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_time',
			index : 'case_time',
			width : 40,
			editable : false
		}, {
			name : 'case_location',
			index : 'case_location',
			width : 80,
			sortable : false,
			editable : false
		}, {
			name : 'case_desc',
			index : 'case_desc',
			width : 50,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},

		onSelectRow : function(id) {
			var selecs = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
			var rowid = $(grid_selector).getGridParam("selrow");
			var rowData = $(grid_selector).getRowData(rowid);
			var cid = rowData.case_id;
			document.getElementById('check_id').value = cid;
		},

		autowidth : true
	});
});

/*function showimage(image) {
	var bytes=image;
	var image_url = arrayBufferToBase64(bytes);//转换字符串
    console.log("url为： "+image_url);
	window
			.open(
					"showimage.jsp",
					"showimage",
					"height=500, width=600, top=200, left=300,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
}*/

function modify(obj){
    //obj带的是参数rows.id
    alert(obj);
}

jQuery(function($) {
	var grid_selector = "#table_inquisition";
	var jq = jQuery.noConflict();
	var begin_date;
	var end_date;
	var key_word;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	$('#CaseInquisitionBotton')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						begin_date = $("#begin_date").val();
						end_date=$("#end_date").val(); 
						key_word=$("#key_word").val();
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/TestCaseQueryController/selectAllCase?begin_date='
												+begin_date
												+ '&end_date='
												+ end_date
												+ '&key_word='
												+key_word,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});
	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '案件类型', '案件负责人', '创建时间' , '案件备注', '图片流', '案件图片' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 30,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_type',
			index : 'case_type',
			width : 30,
			editable : false
		}, {
			name : 'case_manager',
			index : 'case_manager',
			width : 30,
			sortable : false,
			editable : false
		}, {
			name : 'create_date',
			index : 'create_date',
			width : 30,
			sortable : false,
			editable : false
		}, {
			name : 'case_remark',
			index : 'case_remark',
			width : 50,
			sortable : false,
			editable : false
		},{
			name : 'case_image',
			index : 'case_image',
			width : 30,
			sortable : false,
			editable : false,
			hidden : true
		},{ 
			lable:'operation',
			name: 'show_image',  
			width: 25, 
			align: 'center',
            formatter: function (value, grid, rows, state) {
                //var detail="<img  onclick='btn_detail(\""+ rowObject.clid + "\")'' title='详细信息' src='../../Content/Images/Icon16/application_view_detail.png' style='padding:0px 10px'>";
                return '<button id="add" style= "height:25px;width:65px;background:url(./tupian.png)" onClick="showimage(\''+rows.case_image+'\')">详情</button>';
            },
        }],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},

		onSelectRow : function(id) {
			var selecs = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
			var rowid = $(grid_selector).getGridParam("selrow");
			var rowData = $(grid_selector).getRowData(rowid);
			var cid = rowData.case_id;
			document.getElementById('check_id').value = cid;
		},

		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_abstract";
	var jq = jQuery.noConflict();
	var begin_date;
	var end_date;
	var key_word;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	$('#MaterialAbstractBotton')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						begin_date = $("#abstract_from").val();
						end_date=$("#abstract_to").val();
						key_word=$("#abstract_keyword").val();
						console.log("开始时间： "+begin_date+"截止时间： "+end_date+"关键字： "+key_word);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/MaterialAbstractQueryController/selectAllCase?begin_date='
												+begin_date
												+ '&end_date='
												+ end_date
												+ '&key_word='
												+key_word,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});
	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '提取信息1', '提取信息2', '提取信息3' , '提取信息4', '图片流', '提取图片' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 110,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_type',
			index : 'case_type',
			width : 110,
			editable : false
		}, {
			name : 'case_manager',
			index : 'case_manager',
			width : 110,
			sortable : false,
			editable : false
		}, {
			name : 'create_date',
			index : 'create_date',
			width : 110,
			sortable : false,
			editable : false
		}, {
			name : 'case_remark',
			index : 'case_remark',
			width : 180,
			sortable : false,
			editable : false
		},{
			name : 'case_image',
			index : 'case_image',
			width : 100,
			sortable : false,
			editable : false,
			hidden : true
		},{ 
			lable:'operation',
			name: 'show_image',  
			width: 90, 
			align: 'center',
            formatter: function (value, grid, rows, state) {
                //var detail="<img  onclick='btn_detail(\""+ rowObject.clid + "\")'' title='详细信息' src='../../Content/Images/Icon16/application_view_detail.png' style='padding:0px 10px'>";
                return '<button id="add" style= "height:25px;width:65px" onClick="showimage(\''+rows.case_image+'\')">详情</button>';
            },
        }],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},

		onSelectRow : function(id) {
			var selecs = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
			var rowid = $(grid_selector).getGridParam("selrow");
			var rowData = $(grid_selector).getRowData(rowid);
			var cid = rowData.case_id;
			document.getElementById('check_id').value = cid;
		},

		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_evidence";
	var jq = jQuery.noConflict();
	var begin_date;
	var end_date;
	var key_word;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	$('#MaterialEvidenceBotton')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						begin_date = $("#evidence_from").val();
						end_date=$("#evidence_to").val();
						key_word=$("#evidence_keyword").val();
						console.log("开始时间： "+begin_date+"截止时间： "+end_date+"关键字： "+key_word);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/MaterialEvidenceQueryController/selectAllCase?begin_date='
												+begin_date
												+ '&end_date='
												+ end_date
												+ '&key_word='
												+key_word,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});
	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '物证信息1', '物证信息2', '物证信息3' , '物证信息4', '图片流', '物证图片' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 110,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_type',
			index : 'case_type',
			width : 110,
			editable : false
		}, {
			name : 'case_manager',
			index : 'case_manager',
			width : 110,
			sortable : false,
			editable : false
		}, {
			name : 'create_date',
			index : 'create_date',
			width : 110,
			sortable : false,
			editable : false
		}, {
			name : 'case_remark',
			index : 'case_remark',
			width : 180,
			sortable : false,
			editable : false
		},{
			name : 'case_image',
			index : 'case_image',
			width : 100,
			sortable : false,
			editable : false,
			hidden : true
		},{ 
			lable:'operation',
			name: 'show_image',  
			width: 90, 
			align: 'center',
            formatter: function (value, grid, rows, state) {
                //var detail="<img  onclick='btn_detail(\""+ rowObject.clid + "\")'' title='详细信息' src='../../Content/Images/Icon16/application_view_detail.png' style='padding:0px 10px'>";
                return '<button id="add" style= "height:25px;width:65px" onClick="showimage(\''+rows.case_image+'\')">详情</button>';
            },
        }],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},

		onSelectRow : function(id) {
			var selecs = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
			var rowid = $(grid_selector).getGridParam("selrow");
			var rowData = $(grid_selector).getRowData(rowid);
			var cid = rowData.case_id;
			document.getElementById('check_id').value = cid;
		},

		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_fingerprint";
	var jq = jQuery.noConflict();
	var begin_date;
	var end_date;
	var key_word;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	$('#MaterialFingerprintBotton')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						begin_date = $("#fingerprint_from").val();
						end_date=$("#fingerprint_to").val();
						key_word=$("#fingerprint_keyword").val();
						console.log("开始时间： "+begin_date+"截止时间： "+end_date+"关键字： "+key_word);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/MaterialFingerprintQueryController/selectAllCase?begin_date='
												+begin_date
												+ '&end_date='
												+ end_date
												+ '&key_word='
												+key_word,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});
	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '指纹信息1', '指纹信息2', '指纹信息3' , '指纹信息4', '图片流', '指纹图片' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 110,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_type',
			index : 'case_type',
			width : 110,
			editable : false
		}, {
			name : 'case_manager',
			index : 'case_manager',
			width : 110,
			sortable : false,
			editable : false
		}, {
			name : 'create_date',
			index : 'create_date',
			width : 110,
			sortable : false,
			editable : false
		}, {
			name : 'case_remark',
			index : 'case_remark',
			width : 180,
			sortable : false,
			editable : false
		},{
			name : 'case_image',
			index : 'case_image',
			width : 100,
			sortable : false,
			editable : false,
			hidden : true
		},{ 
			lable:'operation',
			name: 'show_image',  
			width: 90, 
			align: 'center',
            formatter: function (value, grid, rows, state) {
                //var detail="<img  onclick='btn_detail(\""+ rowObject.clid + "\")'' title='详细信息' src='../../Content/Images/Icon16/application_view_detail.png' style='padding:0px 10px'>";
                return '<button id="add" style= "height:25px;width:65px" onClick="showimage(\''+rows.case_image+'\')">详情</button>';
            },
        }],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},

		onSelectRow : function(id) {
			var selecs = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
			var rowid = $(grid_selector).getGridParam("selrow");
			var rowData = $(grid_selector).getRowData(rowid);
			var cid = rowData.case_id;
			document.getElementById('check_id').value = cid;
		},

		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_footmark";
	var jq = jQuery.noConflict();
	var begin_date;
	var end_date;
	var key_word;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	$('#MaterialFootmarkBotton')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						begin_date = $("#footmark_from").val();
						end_date=$("#footmark_to").val();
						key_word=$("#footmark_keyword").val();
						console.log("开始时间： "+begin_date+"截止时间： "+end_date+"关键字： "+key_word);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/MaterialFootmarkQueryController/selectAllCase?begin_date='
												+begin_date
												+ '&end_date='
												+ end_date
												+ '&key_word='
												+key_word,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});
	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '足迹信息1', '足迹信息2', '足迹信息3' , '足迹信息4', '图片流', '足迹图片' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 110,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_type',
			index : 'case_type',
			width : 110,
			editable : false
		}, {
			name : 'case_manager',
			index : 'case_manager',
			width : 110,
			sortable : false,
			editable : false
		}, {
			name : 'create_date',
			index : 'create_date',
			width : 110,
			sortable : false,
			editable : false
		}, {
			name : 'case_remark',
			index : 'case_remark',
			width : 180,
			sortable : false,
			editable : false
		},{
			name : 'case_image',
			index : 'case_image',
			width : 100,
			sortable : false,
			editable : false,
			hidden : true
		},{ 
			lable:'operation',
			name: 'show_image',  
			width: 90, 
			align: 'center',
            formatter: function (value, grid, rows, state) {
                //var detail="<img  onclick='btn_detail(\""+ rowObject.clid + "\")'' title='详细信息' src='../../Content/Images/Icon16/application_view_detail.png' style='padding:0px 10px'>";
                return '<button id="add" style= "height:25px;width:65px" onClick="showimage(\''+rows.case_image+'\')">详情</button>';
            },
        }],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},

		onSelectRow : function(id) {
			var selecs = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
			var rowid = $(grid_selector).getGridParam("selrow");
			var rowData = $(grid_selector).getRowData(rowid);
			var cid = rowData.case_id;
			document.getElementById('check_id').value = cid;
		},

		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_dna";
	var jq = jQuery.noConflict();
	var begin_date;
	var end_date;
	var key_word;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	$('#MaterialDnaBotton')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						begin_date = $("#dna_from").val();
						end_date=$("#dna_to").val();
						key_word=$("#dna_keyword").val();
						console.log("开始时间： "+begin_date+"截止时间： "+end_date+"关键字： "+key_word);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/MaterialDnaQueryController/selectAllCase?begin_date='
												+begin_date
												+ '&end_date='
												+ end_date
												+ '&key_word='
												+key_word,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});
	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', 'DNA信息1', 'DNA信息2', 'DNA信息3' , 'DNA信息4', '图片流', 'DNA图片' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 110,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_type',
			index : 'case_type',
			width : 110,
			editable : false
		}, {
			name : 'case_manager',
			index : 'case_manager',
			width : 110,
			sortable : false,
			editable : false
		}, {
			name : 'create_date',
			index : 'create_date',
			width : 110,
			sortable : false,
			editable : false
		}, {
			name : 'case_remark',
			index : 'case_remark',
			width : 180,
			sortable : false,
			editable : false
		},{
			name : 'case_image',
			index : 'case_image',
			width : 100,
			sortable : false,
			editable : false,
			hidden : true
		},{ 
			lable:'operation',
			name: 'show_image',  
			width: 90, 
			align: 'center',
            formatter: function (value, grid, rows, state) {
                //var detail="<img  onclick='btn_detail(\""+ rowObject.clid + "\")'' title='详细信息' src='../../Content/Images/Icon16/application_view_detail.png' style='padding:0px 10px'>";
                return '<button id="add" style= "height:25px;width:65px" onClick="showimage(\''+rows.case_image+'\')">详情</button>';
            },
        }],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},

		onSelectRow : function(id) {
			var selecs = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
			var rowid = $(grid_selector).getGridParam("selrow");
			var rowData = $(grid_selector).getRowData(rowid);
			var cid = rowData.case_id;
			document.getElementById('check_id').value = cid;
		},

		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_burn";
	var jq = jQuery.noConflict();
	var from1;
	var to1;
	var pro1;
	var city1;
	var dis1;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	$('#CaseBurn')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						from1 = $(".from").val();
						to1 = $(".to").val();
						pro1 = $('#prov').val();
						city1 = $('#city').val();
						dis1 = $('#dis').val();
						console.log(from1 + "," + to1 + "," + pro1 + ","
								+ city1 + "," + dis1);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/CaseQueryController/getBurnCase?beginTime='
													+ from1
													+ '&endTime='
													+ to1
													+ '&pro='
													+ pro1
													+ '&city='
													+ city1 + '&dis=' + dis1,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '案件时间', '案件地点', '案件描述' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 35,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_time',
			index : 'case_time',
			width : 40,
			editable : false
		}, {
			name : 'case_location',
			index : 'case_location',
			width : 80,
			sortable : false,
			editable : false
		}, {
			name : 'case_desc',
			index : 'case_desc',
			width : 50,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},
		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_pointinfo";
	var jq = jQuery.noConflict();
	var from2;
	var to2;
	var centerx;
	var centery;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	$('#searchPC')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						console.log("#table_pointinfo");
						from2 = $("#pointfrom").val();
						to2 = $("#pointto").val();
						centerx = $('#pointlat').val();
						centery = $('#pointlon').val();
						if (from2.length == 0) {
							from2 = '2000-01-01';
						}
						if (to2.length == 0) {
							to2 = '2030-01-01';
						}
						console.log(from2 + "," + to2 + "," + centerx + ","
								+ centerx.length + "," + centery);
						if (centerx.length == 0 || centery.length == 0) {
							console.log("branch1");
							$(grid_selector)
									.jqGrid(
											'setGridParam',
											{
												url : '/pro/PointInfoQueryController/getPointTimeRangeInfo?begin='
														+ from2 + '&end=' + to2,
												datatype : "json",
												mtype : 'POST',
											}).trigger("reloadGrid"); // 重新载入
						} else {
							console.log("branch2");
							$(grid_selector)
									.jqGrid(
											'setGridParam',
											{
												url : '/pro/PointInfoQueryController/getPointInfo?begin='
														+ from2
														+ '&end='
														+ to2
														+ '&px='
														+ centerx
														+ '&py=' + centery,
												datatype : "json",
												mtype : 'POST',
											}).trigger("reloadGrid"); // 重新载入
						}
					});

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 200,
		colNames : [ '标识', '入库时间', '状态', '描述' ],
		colModel : [ {
			name : 'id',
			index : 'id',
			width : 30,
			sortable : false,
			editable : false
		}, {
			name : 'createTime',
			index : 'createTime',
			width : 80,
			sorttype : "string",
			editable : false
		}, {
			name : 'productstatus',
			index : 'productstatus',
			width : 30,
			editable : false,
			sorttype : "string"
		}, {
			name : 'comments',
			index : 'comments',
			width : 60,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},
		onSelectRow : function(id) {
			var selecs = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
			var rowid = $(grid_selector).getGridParam("selrow");
			var rowData = $(grid_selector).getRowData(rowid);
			var cid = rowData.id;
			console.log("sceneid " + cid);
			document.getElementById('sceneid').value = cid;
		},
		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_modelinfo";
	var jq = jQuery.noConflict();
	var from2;
	var to2;
	var centerx;
	var centery;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	$('#searchModel')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						console.log("#table_modelinfo");
						from2 = $("#modelfrom").val();
						to2 = $("#modelto").val();
						centerx = $('#modellat').val();
						centery = $('#modellon').val();
						if (from2.length == 0) {
							from2 = '2000-01-01';
						}
						if (to2.length == 0) {
							to2 = '2030-01-01';
						}
						console.log(from2 + "," + to2 + "," + centerx + ","
								+ centerx.length + "," + centery);
						if (centerx.length == 0 || centery.length == 0) {
							$(grid_selector)
									.jqGrid(
											'setGridParam',
											{
												url : '/pro/ModelInfoQueryController/getModelTimeRangeInfo?begin='
														+ from2 + '&end=' + to2,
												datatype : "json",
												mtype : 'POST',
											}).trigger("reloadGrid"); // 重新载入
						} else {
							$(grid_selector)
									.jqGrid(
											'setGridParam',
											{
												url : '/pro/ModelInfoQueryController/getModelInfo?begin='
														+ from2
														+ '&end='
														+ to2
														+ '&px='
														+ centerx
														+ '&py=' + centery,
												datatype : "json",
												mtype : 'POST',
											}).trigger("reloadGrid"); // 重新载入
						}
					});

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 200,
		colNames : [ '入库时间', '状态', '描述' ],
		colModel : [ {
			name : 'createTime',
			index : 'createTime',
			width : 80,
			sorttype : "string",
			editable : false
		}, {
			name : 'productstatus',
			index : 'productstatus',
			width : 40,
			editable : false,
			sorttype : "string"
		}, {
			name : 'comments',
			index : 'comments',
			width : 40,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},
		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_burn";
	var jq = jQuery.noConflict();
	var from1;
	var to1;
	var pro1;
	var city1;
	var dis1;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	$('#CaseBurn')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						from1 = $(".fromburn").val();
						to1 = $(".toburn").val();
						pro1 = $('#provburn').val();
						city1 = $('#cityburn').val();
						dis1 = $('#disburn').val();
						console.log(from1 + "," + to1 + "," + pro1 + ","
								+ city1 + "," + dis1);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/CaseQueryController/getBurnCase?beginTime='
													+ from1
													+ '&endTime='
													+ to1
													+ '&pro='
													+ pro1
													+ '&city='
													+ city1 + '&dis=' + dis1,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '案件时间', '案件地点', '案件描述' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 35,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_time',
			index : 'case_time',
			width : 40,
			editable : false,
			sorttype : "date"
		}, {
			name : 'case_location',
			index : 'case_location',
			width : 80,
			sortable : false,
			editable : false
		}, {
			name : 'case_desc',
			index : 'case_desc',
			width : 50,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},
		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_bom";
	var jq = jQuery.noConflict();
	var from;
	var to;
	var pro;
	var city;
	var dis;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	console.log(from + "," + to + "," + pro + "," + city + "," + dis);
	$('#CaseBom')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						from = $(".from").val();
						to = $(".to").val();
						pro = $('#prov').val();
						city = $('#city').val();
						dis = $('#dis').val();

						console.log(from + "," + to + "," + pro + "," + city
								+ "," + dis);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/CaseQueryController/getBomCase?beginTime='
													+ from
													+ '&endTime='
													+ to
													+ '&pro='
													+ pro
													+ '&city='
													+ city + '&dis=' + dis,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '案件时间', '案件地点', '案件描述' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 35,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_time',
			index : 'case_time',
			width : 40,
			editable : false,
			sorttype : "date"
		}, {
			name : 'case_location',
			index : 'case_location',
			width : 80,
			sortable : false,
			editable : false
		}, {
			name : 'case_desc',
			index : 'case_desc',
			width : 50,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},
		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_grab";
	var jq = jQuery.noConflict();
	var from;
	var to;
	var pro;
	var city;
	var dis;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	console.log(from + "," + to + "," + pro + "," + city + "," + dis);
	$('#CaseGrab')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						from = $(".from").val();
						to = $(".to").val();
						pro = $('#prov').val();
						city = $('#city').val();
						dis = $('#dis').val();

						console.log(from + "," + to + "," + pro + "," + city
								+ "," + dis);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/CaseQueryController/getGrabCase?beginTime='
													+ from
													+ '&endTime='
													+ to
													+ '&pro='
													+ pro
													+ '&city='
													+ city + '&dis=' + dis,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '案件时间', '案件地点', '案件描述' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 35,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_time',
			index : 'case_time',
			width : 40,
			editable : false,
			sorttype : "date"
		}, {
			name : 'case_location',
			index : 'case_location',
			width : 80,
			sortable : false,
			editable : false
		}, {
			name : 'case_desc',
			index : 'case_desc',
			width : 50,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},
		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_kill";
	var jq = jQuery.noConflict();
	var from;
	var to;
	var pro;
	var city;
	var dis;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	console.log(from + "," + to + "," + pro + "," + city + "," + dis);
	$('#CaseKill')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						from = $(".from").val();
						to = $(".to").val();
						pro = $('#prov').val();
						city = $('#city').val();
						dis = $('#dis').val();

						console.log(from + "," + to + "," + pro + "," + city
								+ "," + dis);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/CaseQueryController/getKillCase?beginTime='
													+ from
													+ '&endTime='
													+ to
													+ '&pro='
													+ pro
													+ '&city='
													+ city + '&dis=' + dis,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '案件时间', '案件地点', '案件描述' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 35,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_time',
			index : 'case_time',
			width : 40,
			editable : false,
			sorttype : "date"
		}, {
			name : 'case_location',
			index : 'case_location',
			width : 80,
			editable : false
		}, {
			name : 'case_desc',
			index : 'case_desc',
			width : 50,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},
		autowidth : true
	});
});

/*
 * jQuery(function($) {
	var grid_selector = "#grid-table";
	var jq = jQuery.noConflict();
	var from;
	var to;
	var pro;
	var city;
	var dis;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}

	console.log(from + "," + to + "," + pro + "," + city + "," + dis);
	$('#CaseInqueryBotton')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						from = $(".from").val();
						to = $(".to").val();
						pro = $('#prov').val();
						city = $('#city').val();
						dis = $('#dis').val();

						console.log(from + "," + to + "," + pro + "," + city
								+ "," + dis);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/CaseQueryController/getAllCase?beginTime='
													+ from
													+ '&endTime='
													+ to
													+ '&pro='
													+ pro
													+ '&city='
													+ city + '&dis=' + dis,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '案件时间', '案件地点', '案件描述' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 35,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_time',
			index : 'case_time',
			width : 40,
			editable : false
		}, {
			name : 'case_location',
			index : 'case_location',
			width : 80,
			sortable : false,
			editable : false
		}, {
			name : 'case_desc',
			index : 'case_desc',
			width : 50,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},

		onSelectRow : function(id) {
			var selecs = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
			var rowid = $(grid_selector).getGridParam("selrow");
			var rowData = $(grid_selector).getRowData(rowid);
			var cid = rowData.case_id;
			document.getElementById('check_id').value = cid;
		},

		autowidth : true
	});
});
*/

jQuery(function($) {
	var grid_selector = "#table_burn";
	var jq = jQuery.noConflict();
	var from1;
	var to1;
	var pro1;
	var city1;
	var dis1;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	$('#CaseBurn')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						from1 = $(".fromburn").val();
						to1 = $(".toburn").val();
						pro1 = $('#provburn').val();
						city1 = $('#cityburn').val();
						dis1 = $('#disburn').val();
						console.log(from1 + "," + to1 + "," + pro1 + ","
								+ city1 + "," + dis1);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/CaseQueryController/getBurnCase?beginTime='
													+ from1
													+ '&endTime='
													+ to1
													+ '&pro='
													+ pro1
													+ '&city='
													+ city1 + '&dis=' + dis1,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '案件时间', '案件地点', '案件描述' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 35,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_time',
			index : 'case_time',
			width : 40,
			editable : false
		}, {
			name : 'case_location',
			index : 'case_location',
			width : 80,
			sortable : false,
			editable : false
		}, {
			name : 'case_desc',
			index : 'case_desc',
			width : 50,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},
		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_burn";
	var jq = jQuery.noConflict();
	var from1;
	var to1;
	var pro1;
	var city1;
	var dis1;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	$('#CaseBurn')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						from1 = $(".fromburn").val();
						to1 = $(".toburn").val();
						pro1 = $('#provburn').val();
						city1 = $('#cityburn').val();
						dis1 = $('#disburn').val();
						console.log(from1 + "," + to1 + "," + pro1 + ","
								+ city1 + "," + dis1);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/CaseQueryController/getBurnCase?beginTime='
													+ from1
													+ '&endTime='
													+ to1
													+ '&pro='
													+ pro1
													+ '&city='
													+ city1 + '&dis=' + dis1,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '案件时间', '案件地点', '案件描述' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 35,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_time',
			index : 'case_time',
			width : 40,
			editable : false,
			sorttype : "date"
		}, {
			name : 'case_location',
			index : 'case_location',
			width : 80,
			sortable : false,
			editable : false
		}, {
			name : 'case_desc',
			index : 'case_desc',
			width : 50,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},
		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_bom";
	var jq = jQuery.noConflict();
	var from;
	var to;
	var pro;
	var city;
	var dis;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	console.log(from + "," + to + "," + pro + "," + city + "," + dis);
	$('#CaseBom')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						from = $(".from").val();
						to = $(".to").val();
						pro = $('#prov').val();
						city = $('#city').val();
						dis = $('#dis').val();

						console.log(from + "," + to + "," + pro + "," + city
								+ "," + dis);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/CaseQueryController/getBomCase?beginTime='
													+ from
													+ '&endTime='
													+ to
													+ '&pro='
													+ pro
													+ '&city='
													+ city + '&dis=' + dis,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '案件时间', '案件地点', '案件描述' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 35,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_time',
			index : 'case_time',
			width : 40,
			editable : false,
			sorttype : "date"
		}, {
			name : 'case_location',
			index : 'case_location',
			width : 80,
			sortable : false,
			editable : false
		}, {
			name : 'case_desc',
			index : 'case_desc',
			width : 50,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},
		autowidth : true
	});
});

jQuery(function($) {
	var grid_selector = "#table_grab";
	var jq = jQuery.noConflict();
	var from;
	var to;
	var pro;
	var city;
	var dis;
	function beforeSelectRow() {
		$(grid_selector).jqGrid('resetSelection');
		return (true);
	}
	console.log(from + "," + to + "," + pro + "," + city + "," + dis);
	$('#CaseGrab')
			.on(
					'click',
					function() { // 页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。
						from = $(".from").val();
						to = $(".to").val();
						pro = $('#prov').val();
						city = $('#city').val();
						dis = $('#dis').val();

						console.log(from + "," + to + "," + pro + "," + city
								+ "," + dis);
						$(grid_selector)
								.jqGrid(
										'setGridParam',
										{
											url : '/pro/CaseQueryController/getGrabCase?beginTime='
													+ from
													+ '&endTime='
													+ to
													+ '&pro='
													+ pro
													+ '&city='
													+ city + '&dis=' + dis,
											datatype : "json",
											mtype : 'POST',
										}).trigger("reloadGrid"); // 重新载入
					});

	jQuery(grid_selector).jqGrid({
		// direction: "rtl",
		datatype : "json",
		mtype : 'POST',

		height : 320,
		colNames : [ '案件编号', '案件时间', '案件地点', '案件描述' ],
		colModel : [ {
			name : 'case_id',
			index : 'case_id',
			width : 35,
			sorttype : "int",
			editable : false
		}, {
			name : 'case_time',
			index : 'case_time',
			width : 40,
			editable : false,
			sorttype : "date"
		}, {
			name : 'case_location',
			index : 'case_location',
			width : 80,
			sortable : false,
			editable : false
		}, {
			name : 'case_desc',
			index : 'case_desc',
			width : 50,
			sortable : false,
			editable : false
		} ],
		viewrecords : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		beforeSelectRow : beforeSelectRow,
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
			}, 0);
		},
		autowidth : true
	});
});
