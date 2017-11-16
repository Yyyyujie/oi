<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>OI - ${companyStaffer.company_name}</title>
    <script src="${pageContext.request.contextPath }/statics/js/rem.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/iconfont.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-edit-pass.css">
</head>
<body>
    <div class="headerr">
        <div class="header-zhe">
            <i class="iconfont icon-fanhui back"></i>
            <span>设置密码</span>
        </div>
    </div>
    <form action="">
        <div class="passcon">
            <input type="password" placeholder="请输入旧密码">
            <input type="password" placeholder="6-18位英文、数字组合">
            <input type="password" placeholder="请再次输入新密码">
         </div>
    </form>
    <p class="forget"><a href="">忘记密码</a></p>
</body>
</html>