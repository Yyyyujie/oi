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
  <base href="<%=basePath%>">
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
    	平台端登录
    </h3>
    <form id="login" onsubmit="return false">
      <div class="form-group">
        <input type="text" name="username" class="form-control uname" placeholder="用户名/手机/邮箱" required="用户名不能为空"/>
      </div>
      <div class="form-group">
        <input type="password" name="password" class="form-control pword m-b" placeholder="密码" required="密码不能为空"/>
      </div>
      <button type="submit" class="btn btn-success btn-block">登录</button>
    </form>
  </div>
</div>
</body>
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath }/statics/js/plugins/layer/layer.js"></script>
<script type="text/javascript">
  $(function () {
    $(".form-control").keydown(function () {
      $("#message").html("");
    });
  });
  $("#login").submit(function () {
    $.ajax({
      url: "${pageContext.request.contextPath}/Admin/AdminCheckLogin",
      data: decodeURIComponent($("#login").serialize(), true),
      type: "POST",
      dataType:"json",
      success: function (result) {
        if (result.code == 200) {
          layer.msg(result.extend.message);
        } else {
          layer.msg(result.extend.message);
          window.location.href = "${pageContext.request.contextPath}/Admin/AdminLogin.html";
        }
      }
    });
  })
</script>
</html>
