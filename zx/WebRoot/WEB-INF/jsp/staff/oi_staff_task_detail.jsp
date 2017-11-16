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
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/allReset.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/sf_header.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/sf_task_center.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/oi_alert.css"/>
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
.sf_reg_container{
position: unset;
}
._tsk_pic_container{
	margin: 0 auto;
}
._tsk_desc_list ul{
	padding-top: 0.2rem;
    height: 2.2rem;
    overflow: hidden;
	}
	.more{
		text-align:center;
		color: #999;
    line-height: 1rem;
	}
</style>
    <script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>

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
		<!--任务进度-->
  <div class="_tsk_progress">
   
   
  </div>
  <!--任务进度 新版本 结束-->
  </div>
  <!--任务进度 结束-->
  <div class="_tsk_pic_container" id="__release_pic_list">
      <ul class="clearfix">
      <c:if test="${information.taskimgs!= null }">
  		<c:forEach var="imgs" items="${information.taskimgs }">
        <li style="background-image:url(http://oi.sxfs0351.com/${fn:replace(imgs.img_url,'\\','/')});"></li>
        </c:forEach>
  		</c:if>
      </ul>
    </div>

  <!--页面底部-->
  
  <!-- 接受开始 -->
  <c:if test="${information.companyTask.task_status==5}">
  	<input type="hidden" name="task_id" id="task_id" value="${information.companyTask.task_id }">
 	<button type="button" class="_tsk_desc_btn" id="acceptbtn">接受</button>
 	</c:if>
  <!-- 接受结束 -->
  <!-- 编辑开始 -->
  <c:if test="${information.companyTask.task_status==4}">
  <form action="${pageContext.request.contextPath }/Newstaff/submittask"	method="post">
<!--任务进度 - 新版本-->
    <div class="_tsk_progress">
      <!--进度条-->
      <div class="_tsk_pro_outer">
        <!--内部-->
        <!--进度条 - 此处修改style="width:${进度值}"-->
        <span class="_tsk_pro_inner" style="width:${information.companyTask.task_progress }%;"></span>
        <!--进度条 - 此处修改style="width:${进度值}"-->
      </div>
      <!--进度阶段按钮-->
      <ul id="_tsk_pro_state_group" class="_tsk_pro_state_group clearfix">
        <li pro-data="25" class="__state_btns">25%</li>
        <li pro-data="50" class="__state_btns">50%</li>
        <li pro-data="75" class="__state_btns">75%</li>
        <li pro-data="100" class="__state_btns __last">100%</li>
      </ul>
      <input type="hidden" id="tsk_progress" value="${information.companyTask.task_progress }" name="task_progress"/>
    </div>
    
    <!--任务进度 新版本 结束-->
			<!--任务描述-->
			<div class="_tsk_desc">
				<input type="hidden" name="task_id" 
					value="${information.companyTask.task_id }"> <input
					type="text" placeholder="任务完成进度描述" name="task_text" />
			</div>
			<button type="button" class="_tsk_desc_btn">提交</button>
			<!--任务描述 结束-->
			<div class="appraise">
      <div class="appraise-box">
        <h3>请评价发布者</h3>
        <!-- 领导评价-->
        <div class="_ev_eva _ev_effc">
          <div class="_e_t">领导能力</div>
          <div class="star-rating">
            <fieldset>
              <input type="radio" id="star2.5" name="task_leader" value="5" /><label for="star2.5" >5 stars</label>
              <input type="radio" id="star2.4" name="task_leader" value="4" /><label for="star2.4" >4 stars</label>
              <input type="radio" id="star2.3" name="task_leader" value="3" /><label for="star2.3" >3 stars</label>
              <input type="radio" id="star2.2" name="task_leader" value="2" /><label for="star2.2" >2 stars</label>
              <input type="radio" id="star2.1" name="task_leader" value="1" /><label for="star2.1" >1 stars</label>
            </fieldset>
          </div>
        </div>
        <!--沟通评价-->
        <div class="_ev_eva _ev_effc">
          <div class="_e_t">沟通能力</div>
          <div class="star-rating">
            <fieldset>
              <input type="radio" id="star3.5" name="task_communion_pub" value="5" /><label for="star3.5" >5 stars</label>
              <input type="radio" id="star3.4" name="task_communion_pub" value="4" /><label for="star3.4" >4 stars</label>
              <input type="radio" id="star3.3" name="task_communion_pub" value="3" /><label for="star3.3" >3 stars</label>
              <input type="radio" id="star3.2" name="task_communion_pub" value="2" /><label for="star3.2" >2 stars</label>
              <input type="radio" id="star3.1" name="task_communion_pub" value="1" /><label for="star3.1" >1 stars</label>
            </fieldset>
          </div>
        </div>
        <input type="hidden" value="" class="task">
        <input type="submit" value="提交" class="put">
      </div>

    </div>
			
		</form>
  </c:if>
  <div class="_tsk_desc_list">
			<ul>
				<c:if test="${information.progress!= null }">
				<input type="hidden" value="${fn:length(information.progress)}" id="list_num">
					<c:forEach var="progress" items="${information.progress}">
						<li class="_t_list">
							<div class="_d_title">已完成${progress.task_progress }%</div>
							<div class="_d_ct">${progress.task_text }</div>
						</li>
					</c:forEach>
				</c:if>
			</ul>
			<p class="more">点击查看更多>></p>
		</div>
  <!-- 编辑结束 -->

<!--任务图片预览遮罩层-->
<div class="_shade_box _pic_preview" id="_pic_preview" style="display: none;"></div>
<!--任务中心 结束-->
<script src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/common/footer.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/oi_tsk_pic_preview.js"></script>
<script type="text/javascript">
$(function(){
 picView.init();
  var listNum=$("#list_num").val();

 if(listNum<=1){
 	$(".more").hide();
 }
 $(".more").click(function(){
 if($(this).text()=="点击查看更多>>"){
 $("._tsk_desc_list ul").css("height","auto");
 $(this).text("点击收起");
 }else{
 $("._tsk_desc_list ul").css("height","2.2rem");
 $(this).text("点击查看更多>>");
 }
 	
 	
 })
 /* 接受开始 */
 			$("#acceptbtn").click(function() {
				var  task_id=$("#task_id").val();
				$.ajax({
					url : "${pageContext.request.contextPath}/Newstaff/updateTaskState",
					type : "POST",
					data : {"task_id":task_id,"status":4},
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
 /* 接受结束 */
 /* 编辑开始 */
     progresser.init();
    $("._tsk_desc_btn").click(function () {

       if($("#tsk_progress").val()=="100"){

          $(".appraise").show();
       }else{
           $("._tsk_desc_btn").attr("type","submit");
       }

    })
 /* 编辑结束 */
});
if (!progresser) {
    var progresser = {
      proContainer: $("#_tsk_pro_state_group"), /*选择进度按钮*/
      pro_hidden: $("#tsk_progress"),             //任务进度隐藏域
      pro_bar: $("._tsk_pro_inner"),
      init: function () {
        this.selPro();
      },
      selPro: function () {
        this.proContainer.on("click", ".__state_btns", function () {
          var s = $(this), pro_data = s.attr("pro-data");
          progresser.pro_hidden.val(pro_data);
          progresser.proShow(pro_data + "%");
        })
      },
      proShow: function (dw) {
        this.pro_bar.css("width", dw);
      }
    }
  }
</script>
</body>
</html>