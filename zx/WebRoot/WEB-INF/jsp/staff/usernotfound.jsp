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
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=Edge,chrome=1" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/allReset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/oi_chk.css" />
<title>404</title>
<script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>
<script>
	document.addEventListener("touchmove", function(e) {
		e.preventDefault();
	})
</script>
</head>
<body>
	<div class="sf_container">
		<div class="chkImg">
			<img src="statics/images/other/usernotfound.png" alt="" />
		</div>
		</div>
</body>
</html>