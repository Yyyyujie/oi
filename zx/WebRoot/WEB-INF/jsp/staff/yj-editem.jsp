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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-edit.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/iconfont.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/header.css">
    <script src="${pageContext.request.contextPath }/statics/js/jQuery.js"></script>
</head>
<body>
    <div class="headerr">
        <div class="header-zhe">
            <i class="iconfont icon-fanhui back"></i>
            <span>绑定邮箱号</span>
        </div>
    </div>
    <div class="phone">
        <div class="phone1" style="background:url(${pageContext.request.contextPath }/statics/img/yj-email.png);background-size: 100%;
    background-repeat: no-repeat;
    background-position: center;">
        </div>
    </div>
    <p class="call">你的邮箱地址：<span>${conCompanyStaffer.email}</span></p>
<div class="but">
    <a href="${pageContext.request.contextPath }/staff/yj-edit-email.html"> <div class="change">更换邮箱地址</div></a>
</div>
</body>
<script>
    $(".back").click(function () {
     location.href="${pageContext.request.contextPath }/staff/yj-zhanghao.html";
    })
</script>
</html>