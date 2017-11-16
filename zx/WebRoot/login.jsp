<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <title>OI 后台管理中心 - 登录</title>
  <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/font-awesome.css?v=4.4.0" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/animate.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/style.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/login.css" rel="stylesheet">
  <!--[if lt IE 9]>
  <meta http-equiv="refresh" content="0;ie.html"/>
  <![endif]-->
  <script>
    if (window.top !== window.self) {
      window.top.location = window.location;
    }
  </script>
</head>
<body class="gray-bg">
<div class="middle-box text-center loginscreen  animated fadeInDown">
  <div>
    <div>
      <h1 class="logo-name">OI</h1>
    </div>
    <h3>
    	欢迎使用 OI系统<br><br>
    	企业端登录
    </h3>
    <form class="m-t" role="form" method="post" action="${pageContext.request.contextPath }/company/admin/dologin.html">
      <div class="form-group">
        <input type="phone" name="phone" class="form-control" placeholder="用户手机号" required="">
      </div>
      <div class="form-group">
        <input type="password" name="password" class="form-control" placeholder="密码" required="">
      </div>
      <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
      <p class="text-muted text-center">
        <a href="${pageContext.request.contextPath }/company/admin/updatePassword.html">
        <small>忘记密码了？</small>
      </a> | <a href="${pageContext.request.contextPath }/company/admin/register.html">注册一个新账号</a>
      </p>
    </form>
  </div>
</div>
</body>
</html>
