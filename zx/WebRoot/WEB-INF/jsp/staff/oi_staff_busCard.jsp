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
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png"/>
    <link rel="apple-touch-startup-image" href="images/apple-touch-startup-image-320x460.png"/>
   <title>OI - ${companyStaffer.company_name}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/weui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/jquery-weui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tsk_mobile.css"/>
  </head>
  
  <body id="stuff_info_busCard">
   	<div class="stuff_container">
        <!--个人信息展示-->
        <div class="stuff_box_1">
            <!--头像名称以及其他-->
            <div class="stuff_title_01">
                <!--头像-->
                <div class="sf_head_icon" style="background-image:url(${pageContext.request.contextPath }/statics/images/1.jpg);"></div>
                <!--名称相关-->
                <div class="sf_head_title">
                    <h4>jQuery</h4>
                    <h5><small>董事会</small></h5>
                </div>
                <!--个人二维码-->
            </div>
            <div class="sf_arCodeIcon" style="background-image:url(${pageContext.request.contextPath }/statics/images/arCode.png);"></div>
            <div class="weui-footer">
                <p class="weui-footer__links">
                    <a href="javascript:void(0);" class="weui-footer__link">知行管理</a>
                </p>
                <p class="weui-footer__text">扫一扫上面的二维码添加我好友</p>
            </div>
        </div>
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
    <script src="${pageContext.request.contextPath }/statics/js/oi_staff_allpage.js"></script>
    
    <script>
        jQuery(function(){
            /*doSomethings*/
        })
    </script>
  </body>
</html>
