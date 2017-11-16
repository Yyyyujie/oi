<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
    <script src="${pageContext.request.contextPath }/statics/js/oi_staff_allpage.js"></script>