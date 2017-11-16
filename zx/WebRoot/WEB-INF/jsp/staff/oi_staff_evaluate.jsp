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
  <meta name="apple-mobile-web-app-capable" content="yes"/>
  <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <title>OI - ${companyStaffer.company_name}</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/allReset.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/sf_header.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/sf_task_center.css"/>
  <script src="js/flexible.js"></script>
  <script>
  /*   document.addEventListener("touchmove", function (e) {
      e.preventDefault();
    }) */
  </script>
</head>
<body>
<!--任务中心-->
<div class="sf_reg_container" id="_taskDetailsContainer">
  <!--页面顶部-->
  <header class="sf_header_bar clearfix">
    <a class="__back_btn" href="javascript:window.history.go(-1);"
       style="background-image:url(images/icons/back.png);"></a>
    <span class="header_bar_title">评价</span>
  </header>
  <form action="oi_staff_task_center.html" method="post">
  <!--任务详情-->
  <div class="_tsk_detail_container clearfix">
    <div class="_tsk_dt_left">
      <!--头像部分-->
      <div class="__tsk_list_header _list_header">
        <div class="__list_header_inner" style="background-image:url(images/header/header_01.jpg);">
        </div>
      </div>
      <!--头像部分 结束-->
      <!--任务标题-->
      <div class="_task_title">
        <div class="_t_name">张宇</div>
        <div class="_eva_aim">下一期晋升目标：人事主管</div>
        <div class="_eva_bran_type clearfix">
          <em class="_icon _icon_branch"></em>
          <span class="_icon_text">人资部</span>
          <em class="_icon _icon_class"></em>
          <span class="_icon_text">员工</span>
        </div>
      </div>
      <!--任务标题 结束-->
    </div>
    <!--员工评级-->
    <div class="_task_ev_grade">
      <div class="_t_ev_grd clearfix">
        <!--评分数目-->
        <div class="_e_grd_num">4.62</div>
        <!--右侧文字-->
        <div class="_e_grd_txt">
          <div class="t1">mark</div>
          <div class="t2">工作质量</div>
        </div>
      </div>
      <!--中间阴影部分-->
      <div class="_t_ev_mid_sd"></div>
      <div class="_t_ev_grd">
        <!--评分数目-->
        <div class="_e_grd_num">4.62</div>
        <!--右侧文字-->
        <div class="_e_grd_txt">
          <div class="t1">mark</div>
          <div class="t2">工作效率</div>
        </div>
      </div>
    </div>
    <!--员工星评-->
    <div class="_task_ev_eva">
      <!--质量-->
      <input type="hidden" id="_ev_qua"/>
      <!--效率-->
      <input type="hidden" id="_ev_effc"/>
      <!--质量评价-->
      <div class="_ev_eva _ev_qua">
        <div class="_e_t">质量</div>
        <ul data-eva="qua" class="_e_star">
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
        </ul>
      </div>
      <!--效率评价-->
      <div class="_ev_eva _ev_effc">
        <div class="_e_t">效率</div>
        <ul data-eva="effc" class="_e_star">
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
        </ul>
      </div>
    </div>
  </div>
  <!--任务描述-->
  <div class="_tsk_desc">
    <input type="text" placeholder="对此次任务说点什么?"/>
  </div>
  <button type="submit" class="_tsk_desc_btn">提交</button>
  <!--任务描述 结束-->
  </form>
  <!--页面底部-->
  <footer class="sf_footer_bar clearfix">
    <ul>
      <li>
        <a href="#">
          <div class="_ft_icon _msg"></div>
          <div class="_ft_text">消息</div>
        </a>
      </li>
      <li class="_tap_on">
        <a href="oi_staff_task_center.html">
          <div class="_ft_icon _task"></div>
          <div class="_ft_text">任务</div>
        </a>
      </li>
      <!--发布按钮-->
      <li class="_release_btn">
        <a href="oi_staff_task_release.html"></a>
      </li>
      <li>
        <a href="oi_staff_data_center.html">
          <div class="_ft_icon _data"></div>
          <div class="_ft_text">统计</div>
        </a>
      </li>
      <li class="_last">
        <a href="#">
          <div class="_ft_icon _per"></div>
          <div class="_ft_text">我</div>
        </a>
      </li>
    </ul>
  </footer>
</div>
<!--任务中心 结束-->
<script src="${pageContext.request.contextPath}/statics/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/_sf_ev_st.js"></script>
</body>
</html>