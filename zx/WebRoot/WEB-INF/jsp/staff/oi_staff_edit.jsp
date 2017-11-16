<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
   	<meta charset="utf-8"/>
    <meta http-equiv="x-ua-compatible" content="IE=Edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
     <title>OI - ${companyStaffer.company_name}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/weui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/jquery-weui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tsk_mobile.css"/>

  </head>
  
  <body>
    <div class="stuff_container">
    
        <form id="task_release_container" action="staff/updateTaskProgress.html" method="post">
        <input type="hidden" name="task_id" id="task_id" value="${companyTask.task_id}">
            <!--任务级别单选部分：是否紧急-->
            <div class="weui-cells__title">任务标题</div>
            <div class="weui-cells weui-cells_form">
                <!--标题填写-->
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="number"  placeholder="${companyTask.task_title}" disabled>
                    </div>
                </div>
                <!--标题填写结束-->
            </div>
            <!--任务状态:重要，紧急-->
            <div class="weui-cells">
                <div class="weui-cell">
                    <div class="weui-cell__hd"><img src=""></div>
                    <div class="weui-cell__bd">
                        <p>任务紧急</p>
                    </div>
                    <c:if test="${companyTask.task_urgent==1}">
                    	<div class="weui-cell__ft">一般</div>
                    </c:if>
                    <c:if test="${companyTask.task_urgent==2}">
                    	<div class="weui-cell__ft">紧急</div>
                    </c:if>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__hd"><img src=""></div>
                    <div class="weui-cell__bd">
                        <p>任务重要</p>
                    </div>
                    <c:if test="${companyTask.task_important==1}">
                    	<div class="weui-cell__ft">一般</div>
                    </c:if>
                   	<c:if test="${companyTask.task_important==2}">
                    	<div class="weui-cell__ft">重要</div>
                    </c:if>
                </div>
            </div>
            <!--任务状态:重要，紧急结束-->
            <!--发布截止时间-->
            <div class="weui-panel weui-panel_access">
                <div class="weui-panel__bd">
                    <a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg">
                        <div class="weui-media-box__hd">
                        </div>
                        <div class="weui-media-box__bd">
                            <h4 class="weui-media-box__title"><small>发布时间：${task_start_time}</small></h4>
                            <h4 class="weui-media-box__title"><small>截止时间：${task_end_time}</small></h4>
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
                        <textarea class="weui-textarea" name="" placeholder="${companyTask.task_content}" rows="3" disabled></textarea>
                    </div>
                </div>
            </div>
            <!--任务详情结束-->
            <!--任务进度-->
            <div class="weui-cells__title">任务进度</div>
            <div class="weui-cells">
                <div class="weui-slider-box weui-cell" id="oi_sf_tsk_progress">
                    <div class="weui-slider">
                        <div id="sliderInner" class="weui-slider__inner">
                            <div id="sliderTrack" style="width:${companyTask.task_progress}%;" class="weui-slider__track"></div>
                            <div id="sliderHandler" style="left:${companyTask.task_progress}%;" class="weui-slider__handler"></div>
                        </div>
                    </div>
                    <div id="sliderValue" class="weui-slider-box__value">${companyTask.task_progress}</div>
                </div>
            </div>
            <!--任务进度结束-->
            <!--任务日志-->
            <div class="weui-cells__title">任务日志</div>
            <div class="weui-cells">
            
            	<div class="weui-cell" id="weui-cell">
                   	<c:forEach var="staffTaskLog" items="${staffTaskLogs}">
						<div class="weui-cell__ft" id="weui-cell__ft"><%-- <small>${staffTaskLog.sub_time}任务进度${staffTaskLog.task_progress}%</small> --%></div>
					</c:forEach>
                </div>
            </div>
            <!--任务日志结束-->
            <!--任务留言-->
            <div class="weui-cells__title">任务留言</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea class="weui-textarea" name="nod_desc" placeholder="此处留下任务留言" rows="3"></textarea>
                        <div class="weui-textarea-counter"><span>0</span>/200</div>
                    </div>
                </div>
            </div>
            <!--任务留言结束-->
            <!--提交按钮-->
            <div class="form_submit_button">
                <a href="javascript:;" class="weui-btn weui-btn_primary" id="oi_quest_submit_btn">确认无误，提交</a>
            </div>
            <!--提交按钮结束-->
            <input type="hidden" id="task_progress" name="task_progress" >
        </form>
    </div>
    <!--页面底部导航-->
    <div class="staff_bottom_fixed">
        <div class="weui-tab">
            <div class="weui-tabbar">
                <a href="${pageContext.request.contextPath }/staff/oi_staff_msg.html" class="weui-tabbar__item weui-bar__item--on">
                    <span class="weui-badge" style="position: absolute;top: -.4em;right: 1em;" id="newsCount"></span>
                    <div class="weui-tabbar__icon">
                        <img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_dialog.png" alt="">
                    </div>
                    <p class="weui-tabbar__label">消息</p>
                </a>
                <a href="${pageContext.request.contextPath }/staff/oi_staff_task_center.html" class="weui-tabbar__item">
                    <div class="weui-tabbar__icon">
                        <img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_datetime.png" alt="">
                    </div>
                    <p class="weui-tabbar__label">任务</p>
                </a>
                <a href="${pageContext.request.contextPath }/staff/oi_staff_publish.html" class="weui-tabbar__item">
                    <div class="weui-tabbar__icon">
                        <img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_button.png" alt="">
                    </div>
                    <p class="weui-tabbar__label">发布</p>
                </a>
                <a href="${pageContext.request.contextPath }/staff/oi_staff_data_center.html" class="weui-tabbar__item">
                    <div class="weui-tabbar__icon">
                        <img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_article.png" alt="">
                    </div>
                    <p class="weui-tabbar__label">统计</p>
                </a>
                <a href="${pageContext.request.contextPath }/staff/oi_staff_info.html" class="weui-tabbar__item">
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
        jQuery(function(){
            $('#oi_sf_tsk_progress').slider(function (percent) {
                console.log(percent)
                $("#task_progress").val(percent);
            })
            
             $("#oi_quest_submit_btn").click(function(){
                $("#task_release_container").submit();
            })
        })
    </script>
  </body>
</html>
