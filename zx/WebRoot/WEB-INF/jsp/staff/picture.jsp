<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>




<!DOCTYPE html>
<html>

<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


  <title>OI - ${companyStaffer.company_name}</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link rel="shortcut icon" href="favicon.ico">
<link
	href="${pageContext.request.contextPath }/statics/hplus/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/hplus/css/plugins/webuploader/webuploader.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/hplus/css/demo/webuploader-demo.css">
<link
	href="${pageContext.request.contextPath }/statics/hplus/css/style.css?v=4.1.0"
	rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeIn">

		<div id="uploader" class="wu-example">
			<div class="queueList">
				<div id="dndArea" class="placeholder">
					<div id="filePicker"></div>
				</div>
			</div>
			<div class="statusBar" style="display:none;">
				<div class="progress">
					<span class="text">0%</span> <span class="percentage"></span>
				</div>
				<div class="info"></div>
				<div class="btns">
					<div id="filePicker2"></div>
					<div class="uploadBtn">开始上传</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script
		src="${pageContext.request.contextPath }/statics/hplus/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath }/statics/hplus/js/bootstrap.min.js?v=3.3.6"></script>
	<!-- Web Uploader -->
	<script type="text/javascript">
		// 添加全局站点信息
		var BASE_URL = '${pageContext.request.contextPath }/statics/hplus/js/plugins/webuploader';
	</script>
	<script
		src="${pageContext.request.contextPath }/statics/hplus/js/plugins/webuploader/webuploader.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/statics/hplus/js/demo/webuploader-demo.js"></script>

	<!--统计代码，可删除-->

</body>

</html>