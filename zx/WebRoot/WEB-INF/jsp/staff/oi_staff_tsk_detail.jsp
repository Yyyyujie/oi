<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=Edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
  <title>OI - ${companyStaffer.company_name}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/weui.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/jquery-weui.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tsk_mobile.css" />
</head>
<body>
	<div class="stuff_container">
	 <input type="hidden" name="task_id" id="task_id" value="${companyTask.task_id}">
		<form id="task_release_container">
			<!--任务级别单选部分：是否紧急-->
			<div class="weui-cells__title">任务标题</div>
			<div class="weui-cells weui-cells_form">
				<!--标题填写-->
				<div class="weui-cell">
					<div class="weui-cell__bd">
						<input class="weui-input" type="number" placeholder="${companyTask.task_title}"
							disabled>
					</div>
				</div>
				<!--标题填写结束-->
			</div>
			<!--发布截止时间-->
			<div class="weui-panel weui-panel_access">
				<div class="weui-panel__bd">
					<a href="javascript:void(0);"
						class="weui-media-box weui-media-box_appmsg">
						<div class="weui-media-box__hd"></div>
						<div class="weui-media-box__bd">
							<h4 class="weui-media-box__title">
								<small>发布时间：${task_start_time}</small>
							</h4>
							<h4 class="weui-media-box__title">
								<small>截止时间：${task_end_time}</small>
							</h4>
						</div>
					</a>
				</div>
			</div>
			<!--发布截止时间结束-->
			<!--任务详情-->
			<div class="weui-cells__title">任务详情</div>
			<div class="weui-cells weui-cells_form">
				<div class="weui-cell">
					<div class="weui-cell__bd">
						<textarea class="weui-textarea" name="" placeholder="${companyTask.task_content}"
							rows="3" disabled></textarea>
					</div>
				</div>
			</div>
			<!--任务详情结束-->
			<!--任务进度-->
			<div class="weui-cells__title">任务进度</div>
			<div class="weui-slider-box" id="slider1">
				<div class="weui-slider">
					<div id="sliderInner" class="weui-slider__inner">
						<div id="sliderTrack" style="width: ${companyTask.task_progress}%;"
							class="weui-slider__track"></div>
						<div id="sliderHandler" style="left: ${companyTask.task_progress}%;"
							class="weui-slider__handler"></div>
					</div>
				</div>
				<div id="sliderValue" class="weui-slider-box__value">${companyTask.task_progress}</div>
			</div>
			<!--任务进度结束-->
			<!--任务日志-->
			<div class="weui-cells__title">任务日志</div>
			<div class="weui-cells">
				<div class="weui-cell">
					<div class="weui-cell__ft" id="weui-cell__ft"><!-- <small>2011-11-11 9:30 任务进度60%</small> --></div>
				</div>
			</div>
			<!--任务日志结束-->
		</form>
	</div>
	<!--页面底部导航-->
	<div class="staff_bottom_fixed">
		<div class="weui-tab">
			<div class="weui-tabbar">
				<a href="${pageContext.request.contextPath }/staff/oi_staff_msg.html"
					class="weui-tabbar__item weui-bar__item--on"> <span
					class="weui-badge"
					style="position: absolute;top: -.4em;right: 1em;" id="newsCount"></span>
					<div class="weui-tabbar__icon">
						<img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_dialog.png" alt="">
					</div>
					<p class="weui-tabbar__label">消息</p>
				</a> <a href="${pageContext.request.contextPath }/staff/oi_staff_task_center.html" class="weui-tabbar__item">
					<div class="weui-tabbar__icon">
						<img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_datetime.png" alt="">
					</div>
					<p class="weui-tabbar__label">任务</p>
				</a> <a href="${pageContext.request.contextPath }/staff/oi_staff_publish.html" class="weui-tabbar__item">
					<div class="weui-tabbar__icon">
						<img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_button.png" alt="">
					</div>
					<p class="weui-tabbar__label">发布</p>
				</a> <a href="${pageContext.request.contextPath }/staff/oi_staff_data_center.html" class="weui-tabbar__item">
					<div class="weui-tabbar__icon">
						<img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_article.png" alt="">
					</div>
					<p class="weui-tabbar__label">统计</p>
				</a> <a href="${pageContext.request.contextPath }/staff/oi_staff_info.html" class="weui-tabbar__item">
					<div class="weui-tabbar__icon">
						<img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_cell.png" alt="">
					</div>
					<p class="weui-tabbar__label">我</p>
				</a>
			</div>
		</div>
	</div>
	<!--页面底部导航结束-->
	<script src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath }/statics/js/jquery-weui.min.js"></script>
	<script src="${pageContext.request.contextPath }/statics/js/task_log.js"></script>
	<script src="${pageContext.request.contextPath }/statics/js/oi_staff_allpage.js"></script>
	<script>
		$(function(){
		
		})
	</script>
</body>
</html>
