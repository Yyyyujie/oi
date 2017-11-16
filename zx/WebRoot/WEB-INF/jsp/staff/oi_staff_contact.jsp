<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
   	<div class="stuff_container" id="sfContractBox">
        <!--个人信息图文组合-->
        <div class="weui-panel weui-panel_access stuff_info_list" id="sf_tsk_backlog_4">
            <!--员工信息-->
            <!-- <div class="weui-panel__bd">
                <div class="weui-media-box weui-media-box_appmsg staff_info_box">
                    员工头像
                    <div class="weui-media-box__hd">
                        <img class="weui-media-box__thumb" src="">
                    </div>
                    员工头像 结束
                    员工信息
                    <div class="weui-media-box__bd">
                        员工姓名
                        <h4 class="weui-media-box__title"><span>员工甲 </span><small>董事会</small></h4>
                        员工姓名结束
                        员工信息详细
                        <p class="weui-media-box__desc">
                            <strong>13000000000</strong>
                        </p>
                        员工两项评分
                        <ul class="weui-media-box__info">
                            <li class="weui-media-box__info__meta">质量：5.00</li>
                            <li class="weui-media-box__info__meta">效率：4.99</li>
                            <li class="weui-media-box__info__meta font_strong"><a href="oi_staff_publish.html">发任务</a></li>
                        </ul>
                        员工两项评分结束
                    </div>
                    员工信息 结束
                </div>
            </div>
            员工信息结束
            员工信息
            <div class="weui-panel__bd">
                <div class="weui-media-box weui-media-box_appmsg staff_info_box">
                    员工头像
                    <div class="weui-media-box__hd">
                        <img class="weui-media-box__thumb" src="">
                    </div>
                    员工头像 结束
                    员工信息
                    <div class="weui-media-box__bd">
                        员工姓名
                        <h4 class="weui-media-box__title"><span>员工甲 </span><small>董事董事会会</small></h4>
                        员工姓名结束
                        员工信息详细
                        <p class="weui-media-box__desc">
                            <strong>13000000000</strong>
                        </p>
                        员工两项评分
                        <ul class="weui-media-box__info">
                            <li class="weui-media-box__info__meta">质量：5.00</li>
                            <li class="weui-media-box__info__meta">效率：4.99</li>
                            <li class="weui-media-box__info__meta font_strong"><a href="oi_staff_publish.html">发任务</a></li>
                        </ul>
                        员工两项评分结束
                    </div>
                    员工信息 结束
                </div>
            </div>
            员工信息结束
            员工信息
            <div class="weui-panel__bd">
                <div class="weui-media-box weui-media-box_appmsg staff_info_box">
                    员工头像
                    <div class="weui-media-box__hd">
                        <img class="weui-media-box__thumb" src="">
                    </div>
                    员工头像 结束
                    员工信息
                    <div class="weui-media-box__bd">
                        员工姓名
                        <h4 class="weui-media-box__title"><span>员工甲 </span><small>张三李四</small></h4>
                        员工姓名结束
                        员工信息详细
                        <p class="weui-media-box__desc">
                            <strong>13000000000</strong>
                        </p>
                        员工两项评分
                        <ul class="weui-media-box__info">
                            <li class="weui-media-box__info__meta">质量：5.00</li>
                            <li class="weui-media-box__info__meta">效率：4.99</li>
                            <li class="weui-media-box__info__meta font_strong"><a href="oi_staff_publish.html">发任务</a></li>
                        </ul>
                        员工两项评分结束
                    </div>
                    员工信息 结束
                </div>
            </div> -->
            <!--员工信息结束-->
        </div>
        <!--个人信息图文组合 结束-->
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
    <script src="${pageContext.request.contextPath }/statics/js/oi_sf_msg.js"></script>
    <script src="${pageContext.request.contextPath }/statics/js/oi_staff_allpage.js"></script>
    <script src="${pageContext.request.contextPath }/statics/js/oi_staff_contact.js"></script>
  </body>
</html>
