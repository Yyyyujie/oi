<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<title>OI - ${companyStaffer.company_name}</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/aui-dev.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/allReset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/sf_header.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/jquery-weui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/mui/mui.picker.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/mui/mui.poppicker.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/sf_task_release.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/oi_alert.css" />
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/yj-footer-header.css" />
<script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>
<style>
.aui-card{
	margin:0;
}
._t_form_group._switch {
	border: 0 none;
	width: 28%;
	float:left;
	margin-right:30px;
}
.aui-switch:checked:before{
	left:0.417333rem;
}
.aui-switch:before{
    width:0.50533rem;
    height:0.50533rem;
    border-radius:50%;
    top: -1px;
}
._t_form_group._switch .aui-switch {
	width: 0.96rem;
    height: 0.53333rem;
	margin: 0;
	border:1px solid #dddddd;
	border-radius:0.346667rem;
}
.aui-switch-title{
	font-size:0.3466667rem;
	line-height:0.3466667rem;
}
.aui-list-view-cell {
	padding: 0.2666667rem;
	display: flex;
	align-items: center;
	justify-content: space-between;
	display: -webkit-flex;
	-webkit-align-items: center;
	-webkit-justify-content: space-between;
	display: flex;
}

.aui-card:after {
	border: 0 none;
}
.li-msg{
	background: url(${pageContext.request.contextPath }/statics/images/footer/msg.png) no-repeat;
	background-size: contain;
    background-position: center;
}


</style>
</head>
<body>
	<!--任务中心-->
	<div class="sf_reg_container" id="_taskDetailsContainer">
		<!--页面顶部-->
		<header class="sf_header_bar clearfix">
			<!-- <a class="__back_btn"
			href="javascript:window.history.go(-1);"
			style="background-image:url(statics/images/icons/back.png);"></a> -->
			<span class="header_bar_title">OI发布</span>
		</header>
		<!--任务表单-->
		<input type="hidden" id="user_id" value="${companyStaffer.user_id}" />
		<form action="" id="_pub_tsk_form">
			<div class="_pub_task_form clearfix">
				<div class="_t_form_group">
					<input type="text" placeholder="请输入任务标题" name="task_title" required="required"/>
				</div>
				<div class="_t_form_group" id="_selQuestChar">
					<span class="_t_form_sel_checker" id="_t_form_sel_checker">请选择任务对象<span
						style="color: rgb(51, 51, 51);">${staff.realname }</span></span>
					<!--选择任务对象隐藏域-->
					<input type="hidden" name="to_user" id="sel_per"
						value="${staff.user_id }" required="required" />
				</div>
				<!-- <div class="_t_form_group" id="_selQuestType">
					<span class="_t_form_sel_type" id="_t_form_sel_type">请选择任务类型<span
						style="color: rgb(51, 51, 51);"></span></span>
					选择任务类型隐藏域
					<input type="hidden" name="staff_type" id="sel_type"
						required="required" />
				</div> -->
				<div class="
					_t_form_group" style="padding-left: 0.306667rem;">
					<input id="datePicker_1" placeholder="请选择开始日期"
						time-name="task_start_time"
						style="width: 50%; float: left; margin: 0.226667rem 0 0;">
					<input id="datePicker_2" placeholder="请选择截止日期"
						time-name="task_end_time"
						style="width: 50%; float: left; margin: 0.226667rem 0 0;">
					<input type="hidden" id="task_start_time" name="start_time">
					<input type="hidden" id="task_end_time" name="end_time"> <span
						class="middle"></span>
				</div>
				<!--<div class="_t_form_group">
				        <input id="datePicker_2" placeholder="请选择截止日期" time-name="task_end_time">
				        <input type="hidden" id="task_end_time"  name="end_time">
		      	</div>-->
				<div class="_t_form_group tArea">
					<textarea placeholder="任务描述" name="task_content"></textarea>
					<div class="pic_upBox">
						<ul class="_task_imgs clearfix" id="__release_pic_list">

						</ul>
						<div class="_task_uploader" id="filePicker"></div>
					</div>
					<input type="hidden" name="imgs" id="imgs_array"> <input
						type="hidden" id="url"
						value="${pageContext.request.contextPath }/Newstaff/upload.do">
				</div>
				<!--任务重要程度-->
				<!-- <div class="_task_level clearfix">
					<div data-target="sel_important" class="_t_level _lv_ur _default"></div>
					<div data-target="sel_urgency" class="_t_level _lv_im _default"></div>
					<input type="hidden" name="task_important" value="2" id="sel_important" /> 
					<input type="hidden" name="task_urgent" value="2" id="sel_urgency" />
				</div> -->
				<!-- 任务紧急开关 -->
				<div class="_t_form_group _switch">
					<div class="aui-content aui-card">
						<ul class="aui-list-view">
							<li class="aui-list-view-cell aui-switch-body">
								<div class="aui-switch-title">紧急</div> 
								<input type="checkbox" name="task_urgent" value="1" class="aui-switch aui-switch-danger aui-pull-right">
							</li>
						</ul>
					</div>
				</div>
				<!-- 任务重要开关 -->
				<div class="_t_form_group _switch">
					<div class="aui-content aui-card">
						<ul class="aui-list-view">
							<li class="aui-list-view-cell aui-switch-body">
								<div class="aui-switch-title">重要</div> 
								<input type="checkbox" name="task_important" value="1" class="aui-switch aui-switch-warning aui-pull-right">
							</li>
						</ul>
					</div>
				</div>
				<!--任务发布按钮-->
				<button type="submit" class="_pub_submit_btn" id="_pub_submit_btn">发布任务</button>
			</div>
		</form>
		<!--任务表单 结束-->
		<!--页面底部-->
		 <footer>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath }/Newstaff/yj-index.html" class="li-a li-msg">         
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/Newstaff/oi_staff_task_center.html" class="li-a li-task">
                </a>
            </li>
            <li >
                <a href="${pageContext.request.contextPath }/Newstaff/oi_staff_task_release.html" class="li-a li-release-on">

                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/staff/oi_staff_data_center.html" class="li-a li-data">
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/staff/yj-member.html" class="li-me">
                </a>
            </li>
        </ul>
    </footer>
	</div>
	<!--遮罩层-->
	<!--遮罩层 确认遮罩层-->
	<div class="_shade_box _alert_box" style="display: none;"></div>
	<!--任务图片预览遮罩层-->
	<div class="_shade_box _pic_preview" id="_pic_preview"
		style="display: none;"></div>
	<!--遮罩层 结束-->
	<!--任务中心 结束-->
	<script
		src="${pageContext.request.contextPath }/statics/js/touch_default.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/common/footer.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/jquery-weui.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/datePicker.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/webuploader.nolog.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/oi_alert.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/uploaderInit.js"></script>
	<!--mui插件加入-->
	<script
		src="${pageContext.request.contextPath }/statics/js/mui/mui.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/mui/mui.picker.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/mui/mui.poppicker.js"></script>
	<!--mui插件加入 结束-->
	<script
		src="${pageContext.request.contextPath }/statics/js/oi_task_release.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/oi_tsk_pic_preview.js"></script>
	<script>
		$(function() {
			/*表单提交部分*/
			var subBtn = $("#_pub_submit_btn"); //提交按钮
			$("#_pub_tsk_form").submit(
				function(e) {
					var boolean = checked();
					if (boolean == false) {
						return false;
					} else {
						var dataStr = $("#_pub_tsk_form").serialize();
						dataStr = decodeURIComponent(dataStr, true);
	
						e.preventDefault();
						//提交任务之后直接禁止提交
						subBtn.attr("disabled", true);
						$.ajax({
								type : "post",
								url : "${pageContext.request.contextPath }/Newstaff/publishtask",
								data : dataStr,
								dataType : "json",
								success : function(data) {
									if (data.code == 100) {
										var task_id = data.extend.taskid;
										kAlert(
											{
												title : "发布成功", //标题
												subtitle : "public success", //副标题
												btns : [ "确定", "查看任务" ], // 按钮名字
												taskUrl : "Newstaff/oi_staff_task_detail_pre.html?task_id="
													+ task_id //查看任务连接
											},
											function() {
												window.location.href = "Newstaff/oi_staff_task_center.html";
											})
									}
								},
								error : function() {
									//网络原因失败，则允许提交
									kAlert({
										title : "发布失败", //标题
										subtitle : "网络连接失败", //副标题
										btns : [ "确定" ] // 按钮名字
									}, function() {
										subBtn.attr("disabled",
											false);
									})
								}
							})
					}
				});
			/*新添加*/
			picView.init(); //  图片预览
			picView.del_pic({
				type : "offline"
			});
	
			/*选择发布任务对象*/
			fzySearch
				.showSel({
					selUrl : "${pageContext.request.contextPath }/Newstaff/getto_user"
				});
			/* 选择发布任务类型 */
			fzySearch
				.showType({
					selUrl : "${pageContext.request.contextPath }/Newstaff/gettasktype"
				});
	
			/*   $("select").change(function(){
			  	if($("select").val()!="请选择任务类型"){
			  		$("select").css("color","#000")
			  	}else{
			  		$("select").css("color","#d3d3d3")
			  	}
			  }) */
			function checked() {
				var _t_form_sel_checker = document.getElementById("_t_form_sel_checker").innerText; //获取任务对象
				//var _t_form_sel_type = document.getElementById("_t_form_sel_type").innerText; //获取任务类型
				var task_start_time = document.getElementById("task_start_time").value; //开始时间
				var task_start_date = Date.parse(new Date(task_start_time)) / 1000; //转成时间戳
				var task_end_time = document.getElementById("task_end_time").value; //结束时间
				var task_end_date = Date.parse(new Date(task_end_time)) / 1000; //转成时间戳
	
				var date = new Date();
				date.setSeconds(0);
				date = Date.parse(date) / 1000; //获取当前时间戳
	
				if (_t_form_sel_checker == "请选择任务对象") {
					kAlert({
						title : "提示", //标题
						subtitle : "请选择任务对象", //副标题
						btns : [ "关闭" ], // 按钮名字
					})
					return false;
				} /* else if (_t_form_sel_type == "请选择任务类型") {
					kAlert({
						title : "提示", //标题
						subtitle : "请选择任务类型", //副标题
						btns : [ "关闭" ], // 按钮名字
					})
					//alert("任务类型不能为空");
					return false;
				} */ else if (task_start_time == null || task_start_time == "") {
					//alert("开始时间不能为空");
					kAlert({
						title : "提示", //标题
						subtitle : "请选择开始时间", //副标题
						btns : [ "关闭" ], // 按钮名字
					})
					return false;
				} else if (task_start_date < date) {
					//alert("开始时间小于当前时间");
					kAlert({
						title : "提示", //标题
						subtitle : "开始时间不能小于当前时间", //副标题
						btns : [ "关闭" ], // 按钮名字
					})
					return false;
				} else if (task_end_time == null || task_end_time == "") {
					kAlert({
						title : "提示", //标题
						subtitle : "请选择结束时间", //副标题
						btns : [ "关闭" ], // 按钮名字
					})
					//alert("结束时间不能为空");
					return false;
				} else if (task_end_date <= task_start_date) {
					//alert("结束时间小于开始时间");
					kAlert({
						title : "提示", //标题
						subtitle : "结束时间不能小于开始时间", //副标题
						btns : [ "关闭" ], // 按钮名字
					})
					return false;
				} else {
					return true;
				}
			}
		});
	</script>
</body>
</html>