
var path=window.location.href;
var lastPath=path.substring(0, path.lastIndexOf("/"));
var rootPath=lastPath.substring(0, lastPath.lastIndexOf("/"));
var rootPath2=rootPath.substring(0, lastPath.lastIndexOf("/"));
jQuery(function() {
	
	
	/*企业列表*/
	$('#oi_admin_enter_list').bootstrapTable({
		url : "Admin/getcompanylist.do",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		cache : false,
		iconSize : 'outline',
		pageList : "[3, 10, 25, ALL]",
		toolbar : '#exampleTableEventsToolbar',
		pagination : true, //启动分页
		sidePagination : "client", //服务端分页 client 客户端分录页
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [ //oi_type - 模块类型：例如企业列表模块
			{
				field : "company_id",
				title : "",
				visible : false
			},
			{
				field : "number",
				title : "序",
				formatter : function(value, row, index) {
					return index + 1;
				}
			},
			{
				field : "user_name",
				title : "管理员"
			},
			{
				field : "pro_name",
				title : "所属省"
			},
			{
				field : "city_name",
				title : "所属市"
			},
			{
				field : "area_name",
				title : "所属区"
			},
			{
				field : "address",
				title : "地址"
			},
			{
				field : "company_name",
				title : "名称"
			},
			{
				field : "type_name",
				title : "类型"
			},
			{
				field : "company_num",
				title : "人数"
			},
			{
				field : "corporate_rep",
				title : "法人"
			},
			{
				field : "phone",
				title : "电话"
			},
			{
				field : "license_id",
				title : "信用代码"
			},
			{
				field : "license_img",
				title : "营业执照",
				events : operateEvents,
				formatter : showButton
			},
			{
				field : "audit",
				title : "审核",
				formatter : checkEnter
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction2
			}
		]
	});
	/*企业审核表*/
	$('#oiEnterCheck').bootstrapTable({
		url : "Admin/getcheckcompanylist.do",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		cache : false,
		iconSize : 'outline',
		pageList : "[3, 10, 25, ALL]",
		toolbar : '#exampleTableEventsToolbar',
		pagination : true, //启动分页
		sidePagination : "client", //服务端分页 client 客户端分录页
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "oi_company",
				title : "",
				visible : false
			},
			{
				field : "number",
				title : "序",
				formatter : function(value, row, index) {
					return index + 1;
				}
			},
			{
				field : "license_id",
				title : "信用代码"
			},
			{
				field : "user_name",
				title : "管理员"
			},
			{
				field : "phone",
				title : "手机"
			},
			{
				field : "audit",
				title : "审核"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : checkAlow
			}
		]
	});
	/*管理员管理表*/
	$('#oi_admin_mng_table').bootstrapTable({
		url : "Admin/getadminlist.do",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		cache : false,
		iconSize : 'outline',
		pageList : "[3, 10, 25, ALL]",
		toolbar : '#exampleTableEventsToolbar',
		pagination : true, //启动分页
		sidePagination : "client", //服务端分页 client 客户端分录页
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "admin_id",
				title : "",
				visible : false
			},
			{
				field : "user_name",
				title : "用户名"
			},
			{
				field : "email",
				title : "邮箱"
			},
			{
				field : "phone",
				title : "手机"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction3
			}
		]
	});
	/*平台：角色管理*/
	$('#oi_admin_character_table').bootstrapTable({
		url : "Admin/getrolelist.do",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		cache : false,
		iconSize : 'outline',
		pageList : "[3, 10, 25, ALL]",
		toolbar : '#exampleTableEventsToolbar',
		pagination : true, //启动分页
		sidePagination : "client", //服务端分页 client 客户端分录页
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "o_r_id",
				title : "",
				visible : false
			},
			{
				field : "name",
				title : "角色用户名"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunction4
			}
		]
	});
	/*平台  平台新闻*/
	$('#oi_enter_news_02').bootstrapTable({
		url :rootPath+"/Admin/getOiNews",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		cache : false,
		iconSize : 'outline',
		pageList : "[3, 10, 25, ALL]",
		toolbar : '#exampleTableEventsToolbar',
		pagination : true, //启动分页
		sidePagination : "client",
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "new_id",
				title : "",
				visible : false
			},
			{
				field : "title",
				title : "标题"
			},
			{
				field : "author",
				title : "发布人"
			},
			{
				field : "type",
				title : "类型"
			},
			{
				field : "content",
				title : "内容",
				visible : false
			},
			{
				field : "status",
				title : "状态",
				formatter :	checkNews
			},
			{
				field : "create_time",
				title : "时间"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunctionnew1
			}
		]
	});
	/*平台  平台新闻类型*/
	$('#oi_enter_news_Type').bootstrapTable({
		url :rootPath+"/Admin/getOiNewsType",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		cache : false,
		iconSize : 'outline',
		pageList : "[3, 10, 25, ALL]",
		toolbar : '#exampleTableEventsToolbar',
		pagination : true, //启动分页
		sidePagination : "client",
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "news_type_id",
				title : "",
				visible : false
			},
			{
				field : "news_type",
				title : "类型名称"
			},
			{
				field : "news_type_remarks",
				title : "类型备注"
			},
			{
				field : "news_logo",
				title : "logo"
			},
			{
				field : "create_time",
				title : "创建时间"
			},			
			{
				field : "status",
				title : "状态",
				formatter :	checkNews
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunctionnewType
			}
		]
	});
	
	
	/*
	 * 企业版：
	 *   微信模板：
	 * */
	/*管理员管理表*/
	$('#oi_enter_mng_table').bootstrapTable({
		url : rootPath+"/Newcompany/getAdmin",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "admin_id",
				title : "",
				visible : false
			},
			{
				field : "username",
				title : "用户名",
			},
			{
				field : "email",
				title : "邮箱",
			},
			{
				field : "phone",
				title : "手机"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunctionadmin
			}
		]
	});
	//角色管理
	$('#oi_enter_character_table').bootstrapTable({
		url : rootPath+"/Newcompany/getCompanyRole",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "user_id",
				title : "",
				visible : false
			},
			{
				field : "title",
				title : "角色用户名",
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunctionrole
			}
		]
	});
	/*微信模板*/
	$('#oi_enter_weList').bootstrapTable({
		url : rootPath+"/Newcompany/getWechat",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "tmpl_id",
				title : "",
				visible : false
			},
			{
				field : "type",
				title : "类型",
			},
			{
				field : "title",
				title : "标题",
			},
			{
				field : "serial",
				title : "编号"
			},
			{
				field : "template_id",
				title : "模板ID"
			},
			{
				field : "o",
				title : "排序"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunctionwx
			}
		]
	});
	/*企业宣传*/
	$('#oi_enter_publicity').bootstrapTable({
		url : rootPath+"/Newcompany/getCompanyPropaganda",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "p_id",
				title : "",
				visible : false
			},
			{
				field : "p_title",
				title : "标题",
			},
			{
				field : "create_time",
				title : "开始日期"
			},
			{
				field : "end_time",
				title : "结束日期"
			},
			{
				field : "pubStatus",
				title : "状态",
				formatter : checkNews
			},
			{
				field : "o",
				title : "排序"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunctionxc
			}
		]
	});
	/*企业管理:职系管理*/
	$('#oi_enter_grade').bootstrapTable({
		url : rootPath+"/Newcompany/getCompanyPost",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "post_id",
				title : "",
				visible : false
			},
			{
				field : "post_remark",
				title : "职系说明",
			},
			{
				field : "post_name",
				title : "职系名称"
			},
			{
				field : "o",
				title : "职系排序"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunctionpost
			}
		]
	});
	/*企业管理:员工管理*/
	$('#oi_enter_staffMng').bootstrapTable({
		url : rootPath+"/Newcompany/getCompanyStaffer",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "user_id",
				title : "",
				visible : false
			},
			{
				field : "number",
				title : "序号",
				formatter : function(value, row, index) {
					return index + 1;
				}
			},
			{
				field : "realname",
				title : "员工名称"
			},
			{
				field : "phone",
				title : "员工电话"
			},
			{
				field : "",
				title : "查看",
				events : operateEvents,
				formatter : checkShow
			},
			{
				field : "audit",
				title : "审核",
				formatter : checkStaff
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunctionstaff
			}
		]
	});
	/*职级管理*/
	$('#oi_enter_rank').bootstrapTable({
		url : rootPath+"/Newcompany/getCompanyPostLevel",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		iconSize : 'outline',
		toolbar : '#exampleTableEventsToolbar',
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "post_le_id",
				title : "",
				visible : false
			},
			{
				field : "post_name",
				title : "所属职系"
			},
			{
				field : "level_name",
				title : "职级名称"
			},
			{
				field : "level",
				title : "级别"
			},
			{
				field : "remark",
				title : "职级说明"
			},
			{
				field : "o",
				title : "排序"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunctionlevel
			}
		]
	});
	/*企业新闻*/
	$('#oi_enter_news_01').bootstrapTable({
		url :rootPath+"/Newcompany/getCompanyNews",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		cache : false,
		iconSize : 'outline',
		pageList : "[3, 10, 25, ALL]",
		toolbar : '#exampleTableEventsToolbar',
		pagination : true, //启动分页
		sidePagination : "client",
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "new_id",
				title : "",
				visible : false
			},
			{
				field : "title",
				title : "标题"
			},
			{
				field : "author",
				title : "发布人"
			},
			{
				field : "type",
				title : "类型"
			},
			{
				field : "content",
				title : "内容",
				visible : false
			},
			{
				field : "status",
				title : "状态",
				formatter :	checkNews
			},
			{
				field : "create_time",
				title : "时间"
			},
			{
				field : "button",
				title : "操作",
				events : operateEvents,
				formatter : addFunctionnew
			}
		]
	});
	
	/*企业查看平台新闻*/
	$('#oi_enter_news_OI').bootstrapTable({
		url :rootPath+"/Newcompany/getCompanyOINews",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		cache : false,
		iconSize : 'outline',
		pageList : "[3, 10, 25, ALL]",
		toolbar : '#exampleTableEventsToolbar',
		pagination : true, //启动分页
		sidePagination : "client",
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "new_id",
				title : "",
				visible : false
			},
			{
				field : "title",
				title : "标题"
			},
			{
				field : "author",
				title : "发布人"
			},
			{
				field : "type",
				title : "类型"
			},
			{
				field : "content",
				title : "内容",
				visible : false
			},
			{
				field : "status",
				title : "状态",
				formatter :	checkNews
			},
			{
				field : "create_time",
				title : "时间"
			}
		]
	});
	/* 企业任务中心*/
	$('#oi_enter_task').bootstrapTable({
		url :rootPath+"/Newcompany/getCompanyTask",
		search : true, //搜索框
		pagination : true, //分页
		showRefresh : true, //刷新按钮
		showToggle : true, //切换视图
		showColumns : true, //
		cache : false,
		iconSize : 'outline',
		pageList : "[3, 10, 25, ALL]",
		toolbar : '#exampleTableEventsToolbar',
		pagination : true, //启动分页
		sidePagination : "client",
		icons : {
			refresh : 'glyphicon-repeat',
			toggle : 'glyphicon-list-alt'
		},
		columns : [
			{
				field : "task_id",
				title : "序号"
			},
			{
				field : "task_title",
				title : "任务标题"
			},
			{
				field : "task_content",
				title : "任务内容"
			},
			{
				field : "userName",
				title : "发布人"
			},
			{
				field : "toName",
				title : "接收人"
			},
			{
				field : "task_start_time",
				title : "开始时间"
			},
			{
				field : "task_end_time",
				title : "结束时间"
			},
			{
				field : "task_complete_time",
				title : "完成时间"
			},
			{
				field : "task_progress",
				title : "任务进度",
				formatter :checkProgress
			},
			{
				field : "task_status",
				title : "任务状态",
				formatter :	checkTask
			},
			{
				field : "task_urgent",
				title : "是否紧急",
				formatter :checkUrgency
			},
			{
				field : "task_important",
				title : "是否重要",
				formatter :checkimportance
			}
			
		]
	});
});
/*监听添加/删除按钮*/
addDelete();
function layerContent(title, template) {
	parent.layer.open({
		type : 2,
		title : title,
		shadeClose : true,
		shade : false,
		maxmin: true, //开启最大化最小化按钮
		area : [ '950px', '550px' ],
		content : template
	});
}
function addDelete() {
	$("#exampleTableEventsToolbar").on("click", "button", function() {
		var _self = $(this);
		if (_self.hasClass("table_tool_add")) { //如果为添加按钮
			var tableType = _self.attr("data-target"); //表格种类
			switch (tableType) {
			case "oi_enter_news_02": //平台：企业新闻
				layerContent("企业新闻", "Admin/oi_enter_oiNews_eidt.html?dataType=" + tableType);
				break;
			case "oi_enter_news_Type": //平台：企业新闻类型
				layerContent("企业新闻类型", "Admin/insertOiNewsType.html?dataType=" + tableType);
				break;
			case "oi_admin_mng_table": //平台：管理员表
				layerContent("管理员表", "Admin/oi_admin_mng_edite.html?type=add&dataType=" + tableType);
				break;
			case "oi_admin_enter_list": //平台：企业列表
				layerContent("企业列表", "Admin/oi_admin_enter_edite.html?dataType=" + tableType);
				break;
			case "oi_admin_character_table": //平台：角色管理
				layerContent("角色管理", "Admin/oi_admin_chara_add.html?dataType=" + tableType);
				break;
			case "oi_enter_weList": //企业：微信模板管理
				layerContent("微信模板", "../weChatTpl/insert.html?dataType=" + tableType);
				break;
			case "oi_enter_publicity": //企业：企业宣传
				layerContent("企业宣传", "../propaganda/insert.html?dataType=" + tableType);
				break;
			case "oi_enter_grade": //企业：职系管理
				layerContent("职系管理", "../post/insert.html?dataType=" + tableType);
				break;
			case "oi_enter_rank": //企业：职级管理
				layerContent("职级管理", "../postLevel/insert.html?dataType=" + tableType);
				break;
			case "oi_enter_news_01": //企业：企业新闻
				layerContent("企业新闻", "../news/insert.html?dataType=" + tableType);
				break;
			case "oi_enter_mng_table": //企业：管理设置
				layerContent("管理设置", "../admin/insert.html?dataType=" + tableType);
				break;
			case "oi_enter_character_table": //企业：角色设置
				layerContent("角色设置", "../role/insert.html?dataType=" + tableType);
				break;
			}
		} else if (_self.hasClass("table_tool_delete")) {
			var dataTarget = _self.attr("data-target");
			var $table = $('#' + dataTarget + '');
			var columnList = $table.bootstrapTable('getAllSelections');
			if (columnList.length <= 0) {
				layer.msg("没有选中的对象");
			} else {
				layer.confirm("确定删除吗？", function() {
					layer.closeAll();
					var arr = [];
					for (var i = 0; i < columnList.length; i++) {
						var obj = columnList[i];
						arr.push({
							"oi_type_id" : obj.oi_type_id
						});
					}
					//console.log(arr);
					$.ajax({
						type : 'post',
						url : '',
						dataType : 'json',
						data : JSON.stringify(arr),
						success : function(msg) {
							window.location.href = "";
						},
						error : function() {
							alert("删除失败,请检查网络连接");
						}
					})
				})
			}
		}
	})
}
function addFunctionwx(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDeletewx" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function addFunctionadmin(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDeleteadmin" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function addFunctionrole(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDeleterole" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function addFunctionpost(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDeletepost" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function addFunctionlevel(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDeletelevel" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function addFunctionstaff(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDeletestaff" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function addFunctionnew(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDeletenew" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function addFunctionnew1(value, row, index) { //添加操作组按钮
	return [
			'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
			'<button id="TableDeletenew02" class="btn btn-danger btn-sm" type="button">删除</button>'
		].join('');
}
function addFunctionnewType(value, row, index) { //添加操作组按钮
	return [
			'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
			'<button id="TableDeletenewType" class="btn btn-danger btn-sm" type="button">删除</button>'
		].join('');
}
function addFunctionxc(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDeletexc" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}


function addFunction(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDelete" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function addFunction2(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDelete2" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function addFunction3(value, row, index) { //平台管理员删除摁扭
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDelete3" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function addFunction4(value, row, index) { //添加操作组按钮
	return [
		'<button id="TableEditor" class="btn btn-warning btn-sm" type="button">编辑</button>&nbsp;&nbsp;',
		'<button id="TableDelete4" class="btn btn-danger btn-sm" type="button">删除</button>'
	].join('');
}
function checkAlow(value, row, index) { //审核操作组按钮
	return [
		'<button id="allowBtn" class="btn btn-warning btn-sm" type="button">通过</button>&nbsp;&nbsp;',
		'<button id="refuseBtn" class="btn btn-danger btn-sm" type="button">拒绝</button>'
	].join('');
}
function showButton(value, row, index) {
	//查看按钮
	return [
		'<button id="showButton" class="btn btn-info btn-block">查看</button>'
	].join('');
}
//平台端审核
function checkEnter(value, row, index) {
	//查看按钮
	if (row.audit == 0) {
		return [
			'<span id="showButton" class="btn btn-warning btn-block">未审核</span>'
		].join('');
	} else if (row.audit == 1) {
		return [
			'<span id="showButton" class="btn btn-success btn-block">已审核</span>'
		].join('');
	} else if (row.audit == 2) {
		return [
			'<span id="showButton" class="btn btn-danger btn-block">未通过</span>'
		].join('');
	}
};

//企业端员工信息审核
function checkStaff(value, row, index) {
	//查看按钮
	if (row.audit == 0) {
		return [
			'<span id="showButton" class="btn btn-info btn-block">待审核</span>'
		].join('');
	} else if (row.audit == 1) {
		return [
			'<span id="showButton" class="btn btn-success btn-block">已审核</span>'
		].join('');
	} else if (row.audit == 2) {
		return [
			'<span id="showButton" class="btn btn-warning btn-block">待实名</span>'
		].join('');
	}
	else if (row.audit == -1) {
		return [
			'<span id="showButton" class="btn btn-danger btn-block">已拒绝</span>'
		].join('');
	}
}
//企业端任务状态
function checkTask(value, row, index) {
	//查看按钮
	if (row.task_status == 1) {
		return [
			'<span id="showButton" class="btn btn-warning btn-block">已取消</span>'
		].join('');
	} else if (row.task_status == 2) {
		return [
			'<span id="showButton" class="btn btn-success btn-block">已完成</span>'
		].join('');
	}else if (row.task_status == 3) {
		return [
			'<span id="showButton" class="btn btn-danger btn-block">已退回</span>'
		].join('');
	}else if (row.task_status == 4) {
		return [
			'<span id="showButton" class="btn btn-primary btn-block">进行中</span>'
		].join('');
	}else if (row.task_status == 5) {
		return [
			'<span id="showButton" class="btn btn-warning btn-block">待接收</span>'
		].join('');
	}else if (row.task_status == 6) {
		return [
				'<span id="showButton" class="btn btn-info btn-block">待评价</span>'
			].join('');
		}
}
//企业端任务进度
function checkProgress(value, row, index) {
	//查看按钮
	if (row.task_progress == 0  ) {
		return [
			'<span id="showButton" class="btn btn-warning btn-block">未开始</span>'
		].join('');
	}else if (row.task_progress>0 && row.task_progress < 100) {
		return [
				'<span id="showButton" class="btn btn-info btn-block">'+row.task_progress+'%</span>'
			].join('');
	}else if (row.task_progress == 100) {
		return [
			'<span id="showButton" class="btn btn-success btn-block">已完成</span>'
		].join('');
	}
}
//企业端任务进度
function checkUrgency(value, row, index) {
	//查看按钮
	if (row.task_urgent !=1) {
		return [
			'<span id="showButton" class="btn btn-info btn-block">普通</span>'
		].join('');
	}else if (row.task_urgent == 1) {
		return [
			'<span id="showButton" class="btn btn-danger btn-block">紧急</span>'
		].join('');
	}
}
//企业端任务进度
function checkimportance(value, row, index) {
	//查看按钮
	if (row.task_important !=1) {
		return [
			'<span id="showButton" class="btn btn-info btn-block">普通</span>'
		].join('');
	}else if (row.task_important == 1) {
		return [
			'<span id="showButton" class="btn btn-danger btn-block">重要</span>'
		].join('');
	}
}
//企业端新闻审核
function checkNews(value, row, index) {
	//查看按钮
	if (row.status == 0) {
		return [
			'<span id="showButton" class="btn btn-danger btn-block">已停用</span>'
		].join('');
	} else if (row.status == 1) {
		return [
			'<span id="showButton" class="btn btn-success btn-block">已启用</span>'
		].join('');
	} 
}
//企业端角色管理
function checkRole(value, row, index) {
	//查看按钮
	if (row.title == 1) {
		return [
			'超级管理员'
		].join('');
	} else if (row.title == 2) {
		return [
			'测试角色'
		].join('');
	} 
}
//查看员工信息
function checkShow(value, row, index) {
	return [
			'<span id="stuff_show_btn" class="btn btn-warning btn-block">查看</span>'
		].join('');
}
window.operateEvents = {
	"click #stuff_show_btn" : function(e, value, row, index) {
		var staff_id=row.user_id;
		layerContent("员工基本信息", rootPath+"/staffer/getStafferByID.html?id="+staff_id);
	},
	"click #allowBtn" : function(e, value, row, index) {
		var self = $(this);
		parent.layer.msg("确定要通过吗？", {
			time : 0, //不自动关闭
			btn : [ '确定', '取消' ],
			yes : function() {
				parent.layer.closeAll();
				$.ajax({
					type : "POST",
					data : {
						company_id : row.company_id,
						type : "pass"
					},
					url : "Admin/checkcompany.do",
					success : function(msg) {
						self.parent().parent().remove();
					},
					error : function(msg) {
						parent.alert("修改失败，请检查网络！")
					}
				})
			}
		})
	},
	"click #refuseBtn" : function(e, value, row, index) {
		var self = $(this);
		parent.layer.msg("确定要拒绝吗？", {
			time : 0, //不自动关闭
			btn : [ '确定', '取消' ],
			yes : function() {
				parent.layer.closeAll();
				$.ajax({
					type : "POST",
					data : {
						company_id : row.company_id,
						type : "return"
					},
					url : "Admin/checkcompany.do",
					success : function(msg) {
						self.parent().parent().remove();
					},
					error : function(msg) {
						parent.alert("修改失败，请检查网络！")
					}
				})
			}
		})
	},
	
	"click #TableEditor" : function(e, value, row, index) {
		//编辑按钮事件
		var tableType = row.oi_type;
		var companyId = row.company_id;
		var adminId = row.admin_id;
		var roleId = row.o_r_id;
		var tableTypeid = row.oi_type_id;
		var user_id = row.user_id;
		var tmpl_id=row.tmpl_id;
		var p_id=row.p_id;
		var post_id=row.post_id;
		var post_le_id=row.post_le_id;
		var new_id=row.new_id;
		var news_type_id=row.news_type_id;

		var self = $(this);
		var companyList = self.parent().parent().parent().parent().attr("id");
		//console.log(companyList);
		switch (tableType || companyList) {
		case "ad_enter_list": //企业列表
			layerContent("企业信息", "Admin/oi_admin_enter_edite.html?companyId=" + companyId);
			break;
		case "oi_admin_enter_list": // 平台版：企业信息列表 ——需要共存，请误删除
			layerContent("企业信息", "Admin/oi_admin_enter_edite.html?companyId=" + companyId);
			break;
		case "oi_admin_mng_table": //管理员列表
			layerContent("管理员编辑", "Admin/oi_admin_mng_edite.html?adminId=" + adminId);
			break;
		case "oi_admin_character_table": //角色管理
			layerContent("角色编辑", "Admin/oi_admin_chara_edite.html?roleId=" + roleId);
			break;
		case "oi_enter_publicity": //企业宣传
			layerContent("企业宣传", "../propaganda/update.html?dataType=" + tableType + "&id=" + p_id);
			break;
		case "oi_enter_grade": //职系管理
			layerContent("职系管理", "../post/update.html?dataType=" + tableType + "&id=" + post_id);
			break;
		case "oi_enter_rank": //职级管理
			layerContent("职级管理", "../postLevel/update.html?dataType=" + tableType + "&id=" + post_le_id);
			break;
		case "oi_enter_staffMng": //员工管理
			layerContent("员工管理", "../staffer/update.html?dataType=" + tableType + "&id=" + user_id);
			break;
		case "oi_enter_news_01": //企业新闻
			layerContent("企业新闻", "../news/update.html?dataType=" + tableType + "&id=" + new_id);
			break;
		case "oi_enter_mng_table": //企业：管理员
			layerContent("管理设置", "../admin/update.html?dataType=" + tableType + "&id=" + adminId);
			break;
		case "oi_enter_character_table": //企业：角色管理
			layerContent("角色设置", "../role/update.html?dataType=" + tableType + "&id=" + user_id);
			break;
		case "oi_enter_weList": //企业：微信模板管理
			layerContent("微信模板", "../weChatTpl/update.html?dataType=" + tableType + "&id=" + tmpl_id);
			break;
		case "oi_enter_news_02": //平台：企业新闻
			layerContent("企业新闻", "Admin/oi_enter_oiNews_Update.html?dataType=" + tableType + "&id=" + new_id);
			break;
		case "oi_enter_news_Type": //平台：企业新闻类型
			layerContent("企业新闻类型", "Admin/UpdateOiNewsType.html?dataType=" + tableType + "&id=" + news_type_id);
			break;
		}
	},
	"click #TableDelete" : function(e, value, row, index) {
		//删除按钮事件
		var dataTypeid = row.oi_type_id, //获取当前行的ID
			_self = $(this);
		var type = row.oi_type;
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : '../deleteInfo/delete.do',
				data : {
					id : dataTypeid,
					dataType : type
				},
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			})
		});
	},
	"click #TableDelete2" : function(e, value, row, index) {
		//删除按钮事件  第二个
		var rowid = row.company_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : 'removecompany.do/' + rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			})
		});
	},
	"click #TableDelete3" : function(e, value, row, index) {
		//删除按钮事件  第三个
		var rowid = row.admin_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : 'Admin/removeadmin.do/' + rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			})
		});
	},
	"click #TableDelete4" : function(e, value, row, index) {
		//删除按钮事件  第4个
		//console.log(row);
		var rowid = row.o_r_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : 'Admin/removerole.do/' + rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			})
		});
	},
	"click #TableDeletewx" : function(e, value, row, index) {//微信
		//console.log(row);
		var rowid = row.tmpl_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : rootPath2+'/deleteInfo/delete.do',
				data:'dataType=oi_enter_weList&id='+rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			})
		});
	},
	"click #TableDeletexc" : function(e, value, row, index) {//企业宣传
		//console.log(row);
		var rowid = row.p_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : rootPath2+'/deleteInfo/delete.do',
				data:'dataType=oi_enter_publicity&id='+rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			})
		});
	},
	"click #TableDeletepost" : function(e, value, row, index) {//职系
		//console.log(row);
		var rowid = row.post_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : rootPath2+'/deleteInfo/delete.do',
				data:'dataType=oi_enter_grade&id='+rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			})
		});
	},
	"click #TableDeletelevel" : function(e, value, row, index) {//职级
		//console.log(row);
		var rowid = row.post_le_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : rootPath2+'/deleteInfo/delete.do',
				data:'dataType=oi_enter_rank&id='+rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			})
		});
	},
	"click #TableDeletestaff" : function(e, value, row, index) {
		//删除按钮事件  第4个
		//console.log(row);
		var rowid = row.user_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : rootPath2+'/deleteInfo/delete.do',
				data:'dataType=oi_enter_staffMng&id='+rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			})
		});
	},
	
	"click #TableDeletenew" : function(e, value, row, index) {
		console.log(row);
		var rowid = row.new_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : rootPath2+'/deleteInfo/delete.do',
				data:'dataType=oi_enter_news_01&id='+rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			});
		});
	},
	//删除平台新闻
	"click #TableDeletenew02" : function(e, value, row, index) {
		console.log(row);
		var rowid = row.new_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : rootPath2+'/company/deleteInfo/delete.do',
				data:'dataType=oi_enter_news_02&id='+rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			});
		});
	},
	//删除平台新闻类型
	"click #TableDeletenewType" : function(e, value, row, index) {
		console.log(row);
		var rowid = row.news_type_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : rootPath2+'/Admin/deleteNewsType.do',
				data:'dataType=oi_enter_news_Type&id='+rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			});
		});
	},
	"click #TableDeleteadmin" : function(e, value, row, index) {
		//console.log(row);
		var rowid = row.admin_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : rootPath2+'/deleteInfo/delete.do',
				data:'dataType=oi_enter_mng_table&id='+rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			})
		});
	},
	"click #TableDeleterole" : function(e, value, row, index) {
		//console.log(row);
		var rowid = row.user_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : rootPath2+'/deleteInfo/delete.do',
				data:'dataType=oi_enter_character_table&id='+rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			})
		});
	},
	"click #showButton" : function(e, value, row, index) { //查看按钮
		//查看企业营业执照
		var imgSRC = row.license_img;
		parent.layer.open({
			type : 1,
			title : "营业执照",
			shadeClose : false,
			shade : false,
			maxmin : true,
			area : [ '600px', '600px' ],
			content : '<div class="col-sm-12"><img style="display:block;width:100%;height:auto;" src=" ' + imgSRC + '"></div>'
		})
	},
	"click #1" : function(e, value, row, index) {
		console.log(row);
		var rowid = row.new_id, //获取当前行的ID
			_self = $(this);
		layer.confirm("确定删除吗？", function() {
			layer.closeAll();
			$.ajax({
				type : 'post',
				url : rootPath2+'/deleteInfo/delete.do',
				data:'dataType=oi_enter_news_01&id='+rowid,
				success : function(msg) {
					if (msg.code == 100) {
						_self.parent().parent().remove();
						window.location.href = "";
					}
				},
				error : function() {
					alert("删除失败，检查网络");
				}
			});
		});
	}
};