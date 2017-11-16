<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<base href="<%=basePath%>">
<title>角色权限分配</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
<link rel="shortcut icon" href="favicon.ico">
<link
	href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/statics/css/font-awesome.css?v=4.4.0"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/statics/css/animate.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/statics/css/style.css?v=4.1.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/statics/js/plugins/zTree_v3/css/metroStyle/metroStyle.css" />
</head>
<body class="gray-bg">
	<div class="row wrapper wrapper-content animated fadeInRight">
		<div class="col-sm-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title clearfix">
					<button class="btn btn-link">角色权限分配</button>
					<div class="ibox-tools clearfix">
						<button class="btn btn-default" id="charSaveBtn">保存</button>
						<button class="btn btn-default" id="collapseBtn">折叠</button>
						<button class="btn btn-default" id="unfoldBtn">展开</button>
						<a style="color:#fff;" class="btn btn-info text-default"
							href="javascript:location.reload(true);" id="refreshBtn">刷新</a>
					</div>
				</div>
				<div class="ibox-content" style="min-height:1000px;">
					<!--树形图显示部分-->
					<div class="col-sm-offset-3 col-sm-6">
						<form class="form-horizontal" id="oi_ad_char_edite">
							<!--这是隐藏域-->
							<input type="hidden" name="o_r_id" id="or_id" value="${requestScope.roleId}" />
							<!--这是隐藏域 结束-->
							<!--用户名称-->
							<div class="form-group">
								<label class="col-sm-offset-2 col-sm-3 control-label">角色名称：</label>
								<div class="col-sm-5">
									<input id="char_Name_edit" type="text" class="form-control" name="name"
										placeholder="请输入角色名称" />
								</div>
							</div>
							<!--用户名称结束-->
							<!--用户名称-->
							<div class="form-group">
								<label class="col-sm-offset-2 col-sm-3 control-label">是否启用：</label>
								<div class="col-sm-5">
									<select id="char_status_edit" name="status" class="form-control">
										<option value="1">启用</option>
										<option value="2">停用</option>
									</select>
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--权限树形表-->
							<div class="form-group">
								<label class="col-sm-offset-1 col-sm-3 control-label">权限分配：</label>
								<div id="oi_admin_tree_char" class="col-sm-3 test ztree"></div>
							</div>
							<!--权限树形表 结束-->

						</form>
					</div>
					<!--树形图显示部分 结束-->
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script
		src="${pageContext.request.contextPath}/statics/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js?v=3.3.6"></script>
	<!-- 自定义js -->
	<script
		src="${pageContext.request.contextPath}/statics/js/content.js?v=1.0.0"></script>
	<script
		src="${pageContext.request.contextPath}/statics/js/plugins/zTree_v3/js/jquery.ztree.all.js"></script>
	<script
		src="${pageContext.request.contextPath}/statics/js/plugins/layer/layer.js"></script>
	<script
		src="${pageContext.request.contextPath}/statics/js/demo/oi_admin_enter_tree4.js"></script>

</body>
</html>
