<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8"/>
  <meta http-equiv="x-ua-compatible" content="IE=Edge,chrome=1"/>
  <meta name="apple-mobile-web-app-capable" content="yes"/>
  <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
  <title>OI - ${companyStaffer.company_name}</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/allReset.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/sf_header.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/sf_task_center.css"/>
 
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/css/font-awesome.min.css">
 
 <style type="text/css">
.star-rating {
  font-family: 'FontAwesome';
  margin: -6px 0 10px 0 ;
}
.star-rating > fieldset {
  border: none;
  display: inline-block;
}
.star-rating > fieldset:not(:checked) > input {
  position: absolute;
  top: -9999px;
  clip: rect(0, 0, 0, 0);
}
.star-rating > fieldset:not(:checked) > label {
  float: right;
  width: 1em;
  padding: 0 .05em;
  overflow: hidden;
  white-space: nowrap;
  cursor: pointer;
  font-size: 200%;
  color: #13a3ff;
}
.star-rating > fieldset:not(:checked) > label:before {
  content: '\f006  ';
}
.star-rating > fieldset:not(:checked) > label:hover,
.star-rating > fieldset:not(:checked) > label:hover ~ label {
  color: #13a3ff;
  text-shadow: 0 0 3px #13a3ff;
}
.star-rating > fieldset:not(:checked) > label:hover:before,
.star-rating > fieldset:not(:checked) > label:hover ~ label:before {
  content: '\f005  ';
}
.star-rating > fieldset > input:checked ~ label:before {
  content: '\f005  ';
}
.star-rating > fieldset > label:active {
  position: relative;
  top: 2px;
}
</style>
 
  <script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>
  <script>
   /*  document.addEventListener("touchmove", function (e) {
      e.preventDefault();
    }) */
  </script>
  
</head>
<body>
<!--任务中心-->
<div class="sf_reg_container" id="_taskDetailsContainer">
  <!--页面顶部-->
  <header class="sf_header_bar clearfix">
    <a class="__back_btn" href="${pageContext.request.contextPath }/Newstaff/oi_staff_task_center.html"
       style="background-image:url(statics/images/icons/back.png);"></a>
    <span class="header_bar_title">评价</span>
  </header>
  <form action="${pageContext.request.contextPath }/Newstaff/submitcomment" method="post" id="as">
  <!--任务详情-->
  <div class="_tsk_detail_container clearfix">
    <div class="_tsk_dt_left">
     					<!--头像部分-->
				<div class="__tsk_list_header _list_header">
					<c:if test="${receiver.face !=null && receiver.face!='' }">
						<div class="__list_header_inner"
							style="background-image:url(http://oi.sxfs0351.com/${fn:replace(receiver.face,'\\','/')});"></div>
					</c:if>
					<c:if test="${receiver.face==null || receiver.face=='' }">
						<div class="__list_header_inner"
							style="background-image:url(${receiver.header});"></div>
					</c:if>
				</div>
				<!--头像部分 结束-->
      <!--任务标题-->
      <div class="_task_title">
        <div class="_t_name">${receiver.realname}</div>
        <div class="_eva_aim">下一期晋升目标：${level.level_name }</div>
        <div class="_eva_bran_type clearfix">
          <em class="_icon _icon_branch"></em>
          <span class="_icon_text">${companyStaffer.dept_name }</span>
          <em class="_icon _icon_class"></em>
          <span class="_icon_text">${companyStaffer.post_name }</span>
        </div>
      </div>
      <!--任务标题 结束-->
    </div>
    <!--员工评级-->
    <div class="_task_ev_grade">
      <div class="_t_ev_grd clearfix">
        <!--评分数目-->
        <div class="_e_grd_num">${queryData1 }</div>
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
        <div class="_e_grd_num">${queryData2 }</div>
        <!--右侧文字-->
        <div class="_e_grd_txt">
          <div class="t1">mark</div>
          <div class="t2">工作效率</div>
        </div>
      </div>
    </div>
    <!--员工星评-->
    <div class="_task_ev_eva">
      <input type="hidden"  name="task_id" value="${task_id}"/>
 
      <!--质量评价-->
      <div class="_ev_eva _ev_effc">
        <div class="_e_t">质量能力</div>
		<div class="star-rating">
			<fieldset>
				<input type="radio" id="star1.5" name="task_quality" value="5" /><label for="star1.5" >5 stars</label>
				<input type="radio" id="star1.4" name="task_quality" value="4" /><label for="star1.4" >4 stars</label>
				<input type="radio" id="star1.3" name="task_quality" value="3" /><label for="star1.3" >3 stars</label>
				<input type="radio" id="star1.2" name="task_quality" value="2" /><label for="star1.2" >2 stars</label>
				<input type="radio" id="star1.1" name="task_quality" value="1" /><label for="star1.1" >1 stars</label>
			</fieldset>
		</div>
      </div>
	      <!--效率评价-->
      <div class="_ev_eva _ev_effc">
        <div class="_e_t">效率能力</div>
		<div class="star-rating">
			<fieldset>
				<input type="radio" id="star2.5" name="task_efficiency" value="5" /><label for="star2.5" >5 stars</label>
				<input type="radio" id="star2.4" name="task_efficiency" value="4" /><label for="star2.4" >4 stars</label>
				<input type="radio" id="star2.3" name="task_efficiency" value="3" /><label for="star2.3" >3 stars</label>
				<input type="radio" id="star2.2" name="task_efficiency" value="2" /><label for="star2.2" >2 stars</label>
				<input type="radio" id="star2.1" name="task_efficiency" value="1" /><label for="star2.1" >1 stars</label>
			</fieldset>
		</div>
      </div>
            <!--沟通评价-->
      <div class="_ev_eva _ev_effc">
        <div class="_e_t">沟通能力</div>
		<div class="star-rating">
			<fieldset>
				<input type="radio" id="star3.5" name="task_communion_rec" value="5" /><label for="star3.5" >5 stars</label>
				<input type="radio" id="star3.4" name="task_communion_rec" value="4" /><label for="star3.4" >4 stars</label>
				<input type="radio" id="star3.3" name="task_communion_rec" value="3" /><label for="star3.3" >3 stars</label>
				<input type="radio" id="star3.2" name="task_communion_rec" value="2" /><label for="star3.2" >2 stars</label>
				<input type="radio" id="star3.1" name="task_communion_rec" value="1" /><label for="star3.1" >1 stars</label>
			</fieldset>
		</div>
      </div>
            <!--学习评价-->
      <div class="_ev_eva _ev_effc">
        <div class="_e_t">学习能力</div>
		<div class="star-rating">
			<fieldset>
				<input type="radio" id="star4.5" name="task_study" value="5" /><label for="star4.5" >5 stars</label>
				<input type="radio" id="star4.4" name="task_study" value="4" /><label for="star4.4" >4 stars</label>
				<input type="radio" id="star4.3" name="task_study" value="3" /><label for="star4.3" >3 stars</label>
				<input type="radio" id="star4.2" name="task_study" value="2" /><label for="star4.2" >2 stars</label>
				<input type="radio" id="star4.1" name="task_study" value="1" /><label for="star4.1" >1 stars</label>
			</fieldset>
		</div>
      </div>
            <!--创新评价-->
      <div class="_ev_eva _ev_effc">
        <div class="_e_t">创新能力</div>
		<div class="star-rating">
			<fieldset>
				<input type="radio" id="star5.5" name="task_innovate" value="5" /><label for="star5.5" >5 stars</label>
				<input type="radio" id="star5.4" name="task_innovate" value="4" /><label for="star5.4" >4 stars</label>
				<input type="radio" id="star5.3" name="task_innovate" value="3" /><label for="star5.3" >3 stars</label>
				<input type="radio" id="star5.2" name="task_innovate" value="2" /><label for="star5.2" >2 stars</label>
				<input type="radio" id="star5.1" name="task_innovate" value="1" /><label for="star5.1" >1 stars</label>
			</fieldset>
		</div>
      </div>
    </div>
    
  </div>
  <!--任务描述-->
  <div class="_tsk_desc">
    <input type="text" placeholder="对此次任务说点什么?" name="task_evaluate"/>
  </div>
  <button type="submit" class="_tsk_desc_btn">提交</button>
  <!--任务描述 结束-->
  </form>
  <!--页面底部-->
  <div id="footer_def" ft-type="task"></div>
</div>
<!--任务中心 结束-->
<script src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/common/footer.js"></script>
</body>

</html>