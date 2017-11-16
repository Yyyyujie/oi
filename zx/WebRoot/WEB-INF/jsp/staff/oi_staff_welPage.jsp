<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
  <meta http-equiv="x-ua-compatible" content="IE=Edge.chrome=1"/>
  <meta content="yes" name="apple-mobile-web-app-capable">
  <meta content="black" name="apple-mobile-web-app-status-bar-style">
  <meta content="telephone=no" name="format-detection">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/swiper.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/__well_page.css"/>
  <title>欢迎</title>
  <style>
  a {
  -webkit-tap-highlight-color: rgba(0,0,0,0);
}
  </style>
</head>
<body>
<div class="swiper-container">
  <!--壁纸滚动容器-->
  <div class="swiper-wrapper" id="oiWellContainer"></div>
  <!--壁纸滚动容器 结束-->
</div>

<script src="${pageContext.request.contextPath }/statics/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/swiper.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/oi_staff_well.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/oiStaff.service.js"></script>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		/*参数列表
		* @index:第几个页面有文字 -从1开始
		* @option(object){
		*   style:自定义的自提样式,
		*   url:欢迎页面数据接口
		* }
		* @flag:{
		*   fl:控制是否全部页面都显示文字 true-所有页面都显示 false - 只显示在index指定的页面
		*   index:当fl为false的时候启用，决定文字在哪一页显示 index从1开始是第一页
		*   url:按钮跳转的地址
		* }
		* */
		oiService({
			style : "top:50%;margin-top:100px;", //自定义文字样式
			url : "${pageContext.request.contextPath }/Newstaff/getcompanypic" //欢迎页面数据接口
		}, {
			fl : false,
			index : 1,
			url : "${pageContext.request.contextPath }/Newstaff/yj-index.html" //跳转至首页
		});
	});
	setTimeout(function(){
			 location.href="${pageContext.request.contextPath }/Newstaff/yj-index.html"
			},3000);

</script>
</body>
</html>