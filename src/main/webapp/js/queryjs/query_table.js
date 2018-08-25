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

jQuery(function($) {
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
