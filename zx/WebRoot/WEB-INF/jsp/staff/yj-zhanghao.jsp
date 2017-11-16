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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-zhanghao.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/iconfont.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/header.css">
    <script src="${pageContext.request.contextPath }/statics/js/jQuery.js"></script>
    <script src="${pageContext.request.contextPath }/statics/js/jquery.validate.js"></script>
    <style>
        a{
            text-decoration: none;
            color: #000;
        }
    </style>
</head>
<body>
    <div class="headerr">
        <div class="header-zhe">
            <i class="iconfont icon-fanhui back"></i>
            <span>账号与安全</span>
        </div>
    </div>
    <main>
        <ul>
            <a href=" ${pageContext.request.contextPath }/staff/yj-edit.html"><li>
                <span>手机号</span>
            
                <span>${conCompanyStaffer.phone}</span>
            </li>
            </a>
            <a href="${pageContext.request.contextPath }/staff/yj-editem.html"> <li>
                <span>邮箱号</span>
                
                <span>${conCompanyStaffer.email}</span>
            </li>
            </a>
             <a href="yj-setold.html"> <li>
                <span>设置密码</span>
            </li>
            </a>
        </ul>
    </main>

</body>
<script>
  $(".back").click(function () {
      location.href="${pageContext.request.contextPath }/staff/yj-member.html";
    })

</script>
</html>
