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
  <title>OI - ${companyStaffer.company_name}</title>
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
			<img src="statics/images/other/chking.png" alt="" />
			<div class="chk_font_1">信息正在审核中</div>
			<div class="chk_font_2 chk_font_1">3个工作日后会通过审核 请耐心等待</div>
		</div>
		</div>
</body>
</html>