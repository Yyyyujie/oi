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
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath }/statics/images/apple-touch-icon.png"/>
    <link rel="apple-touch-startup-image" href="${pageContext.request.contextPath }/statics/images/apple-touch-startup-image-320x460.png"/>
     <title>OI - ${companyStaffer.company_name}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/weui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/jquery-weui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tsk_mobile.css"/>
  </head>
  
  <body>
    <div class="stuff_container">
        <!--个人信息图文组合-->
        <div class="weui-panel weui-panel_access">
            <div class="weui-panel__bd">
                <a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg">
                    <!--员工头像-->
                    <div class="weui-media-box__hd">
                        <img class="weui-media-box__thumb" src="${pageContext.request.contextPath }/statics/images/1.jpg">
                    </div>
                    <!--员工头像 结束-->
                    <!--员工信息-->
                    <div class="weui-media-box__bd">
                        <!--员工姓名-->
                        <h4 class="weui-media-box__title">${conCompanyStaffer.realname}</h4>
                        <!--员工姓名结束-->
                        <!--员工信息详细-->
                        <p class="weui-media-box__desc">
                            <h6>你与${conCompanyStaffer.company_name}共同奋斗<strong>${longtime}</strong>天</h6>
                            <h6>${conCompanyStaffer.dept_name}[${conCompanyStaffer.post_name}][${conCompanyStaffer.level_name}]</h6>
                        </p>
                        <!--员工两项评分-->
                        <ul class="weui-media-box__info">
                            <li class="weui-media-box__info__meta">质量：${conCompanyStaffer.qualityavg}分</li>
                            <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">效率：${conCompanyStaffer.efficiencyavg}分</li>
                        </ul>
                        <!--员工两项评分结束-->
                        <!--员工信息详细结束-->
                    </div>
                    <!--员工信息 结束-->
                </a>
            </div>
        </div>
        <!--个人信息图文组合 结束-->
        <!--个人信息其他功能-->
        <div id="staff_info_other">
            <div class="weui-cells">
                <a class="weui-cell weui-cell_access" href="${pageContext.request.contextPath }/staff/oi_staff_busCard.html">
                    <div class="weui-cell__hd"><img src="">icons-</div>
                    <div class="weui-cell__bd">
                        <p>我的名片</p>
                    </div>
                    <div class="weui-cell__ft"></div>
                </a>
                <a class="weui-cell weui-cell_access" href="${pageContext.request.contextPath }/staff/oi_staff_contact.html">
                    <div class="weui-cell__hd"><img src="">icons-</div>
                    <div class="weui-cell__bd">
                        <p>通讯录</p>
                    </div>
                    <div class="weui-cell__ft"></div>
                </a>
                <a class="weui-cell weui-cell_access" id="sf_clk_changeMail" href="javascript:;">
                    <div class="weui-cell__hd"><img src="">icons-</div>
                    <div class="weui-cell__bd">
                        <p>邮箱地址</p>
                    </div>
                    <div class="weui-cell__ft">${conCompanyStaffer.email}</div>
                </a>
                <a class="weui-cell weui-cell_access" id="sf_clk_changeTel" href="javascript:;">
                    <div class="weui-cell__hd"><img src="">icons-</div>
                    <div class="weui-cell__bd">
                        <p>手机号码</p>
                    </div>
                    <div class="weui-cell__ft tel">${conCompanyStaffer.phone}</div>
                </a>
                <a class="weui-cell weui-cell_access" id="sf_clk_changePswd" href="javascript:;">
                    <div class="weui-cell__hd"><img src="">icons-</div>
                    <div class="weui-cell__bd">
                        <p>修改密码</p>
                    </div>
                    <div class="weui-cell__ft"></div>
                </a>
                <a class="weui-cell weui-cell_access" href="${pageContext.request.contextPath }/staffLogin/oi_staff_login.html">
                    <div class="weui-cell__hd"><img src="">icons-</div>
                    <div class="weui-cell__bd">
                        <p>退出登录</p>
                    </div>
                    <div class="weui-cell__ft"></div>
                </a>
            </div>
        </div>
        <!--个人信息其他功能结束-->
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
    <script src="${pageContext.request.contextPath }/statics/js/oi_m_sf.js"></script>
    <script src="${pageContext.request.contextPath }/statics/js/oi_staff_allpage.js"></script>
    <script>
        jQuery(function(){
            /*doSomethings*/
        })
    </script>
  </body>
</html>
