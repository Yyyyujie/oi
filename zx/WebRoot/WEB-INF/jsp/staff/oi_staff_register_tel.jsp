<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8"/>
<meta http-equiv="x-ua-compatible" content="IE=Edge,chrome=1"/>
  <meta name="apple-mobile-web-app-capable" content="yes"/>
  <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
  <title>OI - 申请入驻</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/allReset.css"/> 
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/sf_register.css"/>
  <script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>
  <script>
  	document.addEventListener("touchmove", function(e) {
  		e.preventDefault();
  	})
  </script>
</head>
<body>
	<!--账号密码注册-->
	<div class="sf_reg_container">
		<!--公司logo-->
		<div class="sf_logo_1">
			<img src="<c:if test='${requestScope.img!=null}'>${requestScope.img}</c:if>" alt="" />
		</div>
		<form class="oi_form_reg_box" id="oi_form_reg_con_3"
			action="${pageContext.request.contextPath }/Newstaff/regstaff" method="post">
			<!--输入表单组合-->
			<div class="oi_form_reg">
			<input type="hidden" name=reg_id value="<c:if test='${requestScope.reg_id!=null}'>${requestScope.reg_id}</c:if>">
				<!--手机号-->
				<div class="form_input oi_tel clearfix">
					<input in-tp="uname" type="text" placeholder="请输入用户姓名" name="realname" required />
					<span class="errorTips"></span>
				</div>
				<!--验证码-->
				<div class="form_input clearfix">
					<input in-tp="tel" id="telReg" type="tel" placeholder="请输入手机号码" name="phone"
						required /> <span class="errorTips"></span>
				</div>
			</div>
			<button type="button" class="sf_submit_button">申请入驻</button>
		</form>
	</div>
	<!--账号密码注册 结束-->
	<script src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath }/statics/js/oi_regist.js"></script>
</body>
</html>