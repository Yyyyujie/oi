<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-mingp.css">
    <script src="${pageContext.request.contextPath }/statics/js/jQuery.js"></script>
</head>
<body>
<div class="headerr">
    <div class="header-zhe">
        <i class="iconfont icon-fanhui back"></i>
        <span>我的名片</span>
    </div>
</div>
<div class="main">
    <div class="message">
        <div class="tx">
             <div class="img">
      <c:if test="${companyStaffer.face !=null && companyStaffer.face!='' }">
		<img src="http://oi.sxfs0351.com/${companyStaffer.face}" alt="" style="width: 100%;height: 100%;">
	 </c:if>
	<c:if test="${companyStaffer.face==null || companyStaffer.face=='' }">
	   <img src="${companyStaffer.header}" alt="" style="width: 100%;height: 100%;">
	</c:if>
  
    </div>
        </div>
        <div class="tx1">
            <p>${conCompanyStaffer.realname}</p>
            <p>${conCompanyStaffer.dept_name}</p>
        </div>
    </div>
		<div class="er">
        <img src="http://www.sxfs0351.com/statics/images/CreQcode/${conCompanyStaffer.user_id}.jpg" alt="" style="width: 100%;height: 100%;">
    </div>
    <p class="tishi">扫一扫上方二维码 添加到通讯录</p>
</div>

</body>
 <script>
    $(".back").click(function () {
      location.href="${pageContext.request.contextPath }/staff/yj-member.html";
    })
    
 
</script> 
</html>