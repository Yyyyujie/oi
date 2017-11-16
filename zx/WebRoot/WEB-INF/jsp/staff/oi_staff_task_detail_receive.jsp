<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
  <title>OI - ${companyStaffer.company_name}</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/allReset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/sf_header.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/sf_task_center.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/oi_alert.css" />
<script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>

<script>
	document.addEventListener("touchmove", function(e) {
		e.preventDefault();
	})
</script>
</head>
<body>
	<!--任务中心-->
	<div class="sf_reg_container" id="_taskDetailsContainer">
		<!--页面顶部-->
		<header class="sf_header_bar clearfix">
			<a class="__back_btn" href="${pageContext.request.contextPath }/Newstaff/oi_staff_task_center.html"
				style="background-image:url(statics/images/icons/back.png);"></a> <span
				class="header_bar_title">任务详情</span>
		</header>
		<!--任务详情-->
		<div class="_tsk_detail_container clearfix">
			<div class="_tsk_dt_left">
					<!--头像部分-->
				<div class="__tsk_list_header _list_header">
					<c:if test="${information.receiver.face !=null && information.receiver.face!='' && information.receiver.face!=receiver.face}">
						<div class="__list_header_inner"
							style="background-image:url(http://oi.sxfs0351.com/${information.receiver.face});"></div>
					</c:if>
					<c:if test="${information.receiver.face==null || information.receiver.face=='' || information.receiver.face==receiver.face}">
						<div class="__list_header_inner"
							style="background-image:url(${information.receiver.header});"></div>
					</c:if>
				</div>
				<!--头像部分 结束-->
				<!--任务标题-->
				<div class="_task_title">
					<div class="_t_name">${information.receiver.realname}</div>
					<div class="_t_title">${information.companyTask.task_title}</div>
					<div class="_t_content">${information.companyTask.task_content}</div>
				</div>
				<!--任务标题 结束-->
			</div>
		<div class="_tsk_dt_right">
				<span class="_icon _icon_cale"></span> 
				<span class="_t_cale">
				<c:if test="${information.surplusdays<0}">已过期</c:if>
					<c:if test="${information.surplusdays>=0}">剩余${information.surplusdays}天</c:if></span>
			</div>

		</div>
		<form id="accept">

			<!--任务描述-->
			<div class="_tsk_desc">
				<input type="hidden" name="task_id"
					value="${information.companyTask.task_id }"> <input
					type="hidden" name="status" value="4">
			</div>
			<div class="_tsk_progress"></div>
			<div class="_tsk_pic_container" id="__release_pic_list">
				<ul class="clearfix">
					<c:if test="${information.taskimgs!= null }">
						<c:forEach var="imgs" items="${information.taskimgs }">
							<li
								style="background-image:url(${fn:replace(imgs.img_url,'\\','/')});"></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
			<button type="button" class="_tsk_desc_btn" id="acceptbtn">接受</button>
			<!--任务描述 结束-->
		</form>
		<!--任务图片预览遮罩层-->
		<div class="_shade_box _pic_preview" id="_pic_preview"
			style="display: none;"></div>
		<!--页面底部-->

	</div>
	<!--任务中心 结束-->
	<script
		src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/common/footer.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/oi_tsk_pic_preview.js"></script>
	<script>
		$(function() {
			picView.init();
			$("#acceptbtn").click(function() {
				var params = $("#accept").serialize();
				params = decodeURIComponent(params, true);
				$.ajax({
					url : "${pageContext.request.contextPath}/Newstaff/updateTaskState",
					type : "POST",
					data : params,
					dataType:"json",
					success : function(result) {
						console.log(result);
						if (result.code == 100) {
							window.location.href = "Newstaff/oi_staff_task_center.html";
						} else {
							alert("接受失败");
						}
					}
				});
			});
		})
	</script>

</body>
</html>