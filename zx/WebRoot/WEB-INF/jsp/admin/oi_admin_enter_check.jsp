<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>企业审核</title>
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
<link
	href="${pageContext.request.contextPath}/statics/css/plugins/bootstrap-table/bootstrap-table.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/statics/css/animate.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/statics/css/style.css?v=4.1.0"
	rel="stylesheet">
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<h5>企业审核</h5>
				<div class="ibox-tools">
					<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
					</a> <a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
						class="fa fa-wrench"></i>
					</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#">选项1</a></li>
						<li><a href="#">选项2</a></li>
					</ul>
					<a class="close-link"> <i class="fa fa-times"></i>
					</a>
				</div>
			</div>
			<div class="ibox-content">
				<div class="row row-lg">
					<div class="col-sm-12">
						<div class="example-wrap">
							<div class="example">
								<table id="oiEnterCheck" data-height="400"
									data-url="data/table_base.json" data-mobile-responsive="true">
									<thead>
										<tr>
											<th data-align="center" data-field="oi_type">表格种类</th>
											<th data-align="center" data-field="oi_type_id">ID</th>
											<th data-align="center" data-field="number">序</th>
											<th data-align="center" data-field="creditCode">统一社会信用代码</th>
											<th data-align="center" data-field="manager">管理员</th>
											<th data-align="center" data-field="phone">手机</th>
											<th data-align="center" data-field="audit">审核</th>
											<th data-align="center" data-width="10%" data-field="button">操作</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
						<!-- End Example Events -->
					</div>
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
	<!-- Bootstrap table -->
	<script
		src="${pageContext.request.contextPath}/statics/js/plugins/bootstrap-table/bootstrap-table.js"></script>
	<script
		src="${pageContext.request.contextPath}/statics/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/statics/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
	<!-- Peity -->
	<script
		src="${pageContext.request.contextPath}/statics/js/plugins/layer/layer.js"></script>
	<script
		src="${pageContext.request.contextPath}/statics/js/demo/oi_admin_table.js"></script>
</body>
</html>
