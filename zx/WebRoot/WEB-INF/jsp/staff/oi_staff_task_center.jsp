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
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<title>OI - ${companyStaffer.company_name}</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/allReset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/sf_header.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/sf_task_center.css" />
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/aui.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/oi_alert.css" />
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/aui-list-swipe.css" />
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/mui.min.css" />
	   <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-footer-header.css">
<script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>
<!--  <style>
    .scroll_bottom_refresh{
      position:relative;
      display:flex;
      align-items:center;
      justify-content:center;
      width:100%;
      height:1.333rem; /*关键参数*/
      overflow:hidden;
      font-size:0.427rem;
    }
    .sf_reg_container{
      transform:translate3d(0,-1.333rem,0); /*关键参数*/
    }
  </style> -->
  <style>
  	body,html{
  	background:#fff;
  	height:100%;
  	width:100%}
  	.mui-table-view:before,.mui-table-view:after{
	background-color:unset;
}
input[type=search]{
margin-bottom:0;
    background-color: unset;
    height: 0.9rem;
}
button{
padding:0}
.mui-pull-caption{
font-size:0.35rem;
}
.load{
text-align:center;
font-size:0.35rem;
color:#777;
}
.__tsk_list{
transform-style: preserve-3d;
position:absolute;
}
.aui-list-view-cell{
padding:0 0.146667rem;
overflow: unset;
}
.aui-list-view-cell:last-child:after,.aui-list-view-cell:after{
border-bottom:0
}
.lisCon button,.lisCon .__tsk_btn_bg_df,.lisCon .__tsk_btn_bg_bl{
	z-index:9999999;
}
.aui-swipe-right-btn{
right:-0.05rem;
}

.__tsk_btn_bg_bl{
    color: #fff!important;
    background: #13a3ff!important;
    border: 0 none!important;
    width: 1.146667rem!important;
    height: 0.533333rem!important;
    border-radius: 0.262133rem!important;
    line-height: 0.533333rem!important;
    font-size: 0.32rem!important;
    text-align: center!important;
}
.li-msg{
	background: url(${pageContext.request.contextPath }/statics/images/footer/msg.png) no-repeat;
	background-size: contain;
    background-position: center;
}
.li-task{
background: url(${pageContext.request.contextPath }/statics/images/footer/task_on.png) no-repeat;
	background-size: contain;
    background-position: center;
}
/* .mui-pull-top-pocket{
height:0.666667rem;
}
.mui-pull-caption{
line-height:1;
} */
.mui-pull-bottom-pocket{
height:56px;}
input[type=search]{
	text-align:unset;
}
  </style>
</head>
<body>
<!--页面顶部-->
		<header class="sf_header_bar clearfix">
			<!--   <a class="__back_btn" href="javascript:window.history.go(-1);"
       style="background-image:url(statics/images/icons/back.png);"></a> -->
			<span class="header_bar_title">任务</span>
		</header>
	<!--任务中心-->
	<div class="sf_reg_container" id="pull_down_container">
	<!--下拉滚动部分-->
<!-- 	  <div class="scroll_bottom_refresh">s
	    <div class="scroll_bottom_inner">加载更多···</div>
	  </div> -->
	  <!--下拉滚动部分结束-->
		<input type="hidden" value="${companyStaffer.user_id}" class="userId">
		<!--搜索框-->
	
		<div class="sf_search_container">
			<form action="#" id="__search_forms">
				<!--搜索表单-->
				<input search-type="received" type="search" id="__sf_button_1"
					placeholder="输入任务标题即可搜索" />
				<!--语音按钮-->
				<!--<span class="__search_voice" style="background-image:url(statics/images/icons/voice_01.png);"></span>-->
			<div class="ss"></div>	
			</form>
		</div>

		<div class="sort">
			<li class="all">全部 (<span>0</span>)
			</li>
			<li class="task_create_time">发布时间
				<div class="rank">
					<span></span> <span></span>
				</div>
			</li>
			<li class="task_urgent">紧迫度
				<div class="rank">
					<span></span> <span></span>
				</div>
			</li>
			<li class="task_important">重要性
				<div class="rank">
					<span></span> <span></span>
				</div>
			</li>
	
</div>
		<!--任务列表-->
		<!--我接收的任务-->
		<div id="__tsk_received" class="__tsk_container"
			style="display:none;>
    <ul data-check="isFull">
			</ul>
		</div>
		<!--我发布的任务-->
		<div id="pullrefresh" class="__tsk_container" data-has="true">
		<div class="mui-scroll">
			<ul data-check="isFull" class="mui-table-view mui-table-view-chevron lisCon">
			</ul>
		</div>
		</div>
		<!--任务列表 结束-->
	</div>
	<!--页面底部-->
		<!-- <div id="footer_def" ft-type="task"></div> -->
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
	<!--遮罩层 确认遮罩层-->
	<div class="_shade_box _alert_box" style="display: none;"></div>
	<!--遮罩层-->
	<!--任务中心 结束-->
	<script
		src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/common/oi_tsk_list_get.js"></script>
	<%-- <script
		src="${pageContext.request.contextPath }/statics/js/common/kScroll.js"></script> --%>
	<script
		src="${pageContext.request.contextPath }/statics/js/oi_task_tab_get.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/oi_tsk_search_get.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/common/footer.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/oi_alert.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/oi_tsk_center.js"></script>
<%-- 	<script
		src="${pageContext.request.contextPath }/statics/js/common/scroll_bottom.js"></script> --%>
		<script
		src="${pageContext.request.contextPath }/statics/js/mui.min.js"></script>
		<script
		src="${pageContext.request.contextPath }/statics/js/common/aui-list-swipe.js"></script>
	<script>
	
		$(function() {
		
		mui('body').on('tap','a',function(){document.location.href=this.href;});  
$(".ss").click(function(){
				$("#__search_forms").submit();
			})
			var statusBox = $("#swiper-container");
			/*搜索框submit阻止*/
			getSearch({ //获取搜索之后的内容
				url_1 : "${pageContext.request.contextPath }/Newstaff/getTask", //接收
				lmt : 10,
				level : 1
			});
			//任务按钮操作
			tsk_center_btns({
				url : "${pageContext.request.contextPath }/Newstaff/updateTaskState" //接口地址
			});
		
		});
/* 		var startX;
		$("#__tsk_released").on("touchstart",".liBox",function(e){
			var that=$(this);
		startX=e.originalEvent.targetTouches[0].pageX;
			console.log(startX)
			console.log(e)
		that.on("touchmove",function(e){
	console.log(e)
			var moveX=e.originalEvent.changedTouches[0].clientX;
			var cha=startX-moveX;
			if(cha>0){
			
				that.siblings(".operate").animate({right:'0rem'});
			}else{
			$(this).siblings(".operate").animate({right:'-4rem'});
			}
		})
		
		})
		$("#__tsk_released").on("touchend",".liBox",function(e){
			var endX=e.originalEvent.changedTouches[0].pageX;
			var chaa=endX-startX;
				if(chaa>=0){
				$(this).siblings(".operate").animate({right:'-4rem'});
			} 
		}) */
	var keyWord = $("#__sf_button_1").val();
	
		var flage = false;
		$(".sort li").click(function() {
			var keyWord = $("#__sf_button_1").val();
			$(".lisCon").empty();
					html_rels="";
					$(".lisCon").append("<p class='load'>加载中...</p>")
			if ($(this).hasClass("all")) {
				location.reload() ;
			}
			$("#__tsk_received ul").empty();
			var orderType = $(this).attr("class");
			if (flage == false) {
				ord = "asc";
			} else {
				ord = "desc";
			}
			if(orderType=="all"){
			getLis({limit:10,search:keyWord})
			}else{
			pager=1;
			getLis({limit:10,search:keyWord,sequencing:orderType,order:ord})
			}
	
			if (flage == false) {
				$(".sort li").css("color", "#bebebe")
				$(".sort li").children(".rank").children("span").removeClass();
				$(this).css("color", "#4a4a4a");
				$(this).children(".rank").children("span").eq(0).addClass("active");
				$(this).children(".rank").children("span").eq(1).addClass("active3");
				console.log(flage)
				console.log(orderType);
				flage = true;
			} else if (flage == true) {
				$(".sort li").css("color", "#bebebe");
				$(this).css("color", "#4a4a4a");
				$(".sort li").children(".rank").children("span").removeClass();
				$(this).children(".rank").children("span").eq(0).addClass("active1");
				$(this).children(".rank").children("span").eq(1).addClass("active2");
				flage = false;
			}
			;
	
		})
	</script>
	<script type="text/javascript">
	apiready = function(){
	    api.parseTapmode();
	}
	// 初始化
	var swipe = new ListSwipe();
	function showMsg(el){
		if(!el.classList.contains("aui-swipe-selected")){
			api.alert({
			    title: '提示消息',
			    msg: '正常点击操作'
			});
		}
	}
/* 	// 添加tap点击事件
                var ListActions = $api.domAll('.aui-swipe-right-btn');
                 for (var i = 0; i < ListActions.length; i++) {
                     $api.addEvt(ListActions[i], 'tap', function(){
                        var ItemId = this.id;
                        alert(ItemId)
                     });
                 } */
</script>
	<script type="text/javascript">
	var pager;
	mui.init({
				pullRefresh: {
					container: '#pullrefresh',
					down: {
						callback: pulldownRefresh
					},
					up: {
						contentrefresh: '正在加载...',
						callback: pullupRefresh
					}
				}
			});
			/**
			 * 下拉刷新具体业务实现
			 */
			function pulldownRefresh() {
				setTimeout(function() {
					var table = document.body.querySelector('.mui-table-view');
					$(".lisCon").empty();
					var keyWord = $("#__sf_button_1").val();
					html_rels="";
				    pager=0;
				    console.log(keyWord)
				    $(".mui-pull-bottom-pocket").css("visibility","hidden");
					getLis({pager:++pager,limit:10,search:keyWord});
					//mui('#pullrefresh').pullRefresh().endPulldownToRefresh(); //refresh completed
				}, 1500);
			}
			var count = 0;
			/**
			 * 上拉加载具体业务实现
			 */
			function pullupRefresh() {
				setTimeout(function() {
					mui('#pullrefresh').pullRefresh().endPullupToRefresh((false)); //参数为true代表没有更多数据了。
					var table = document.body.querySelector('.mui-table-view');
					var keyWord = $("#__sf_button_1").val();
					getLis({url:"${pageContext.request.contextPath }/Newstaff/getTask",pager:++pager,limit:10,search:keyWord});
				}, 1500);
			}
			if (mui.os.plus) {
				mui.plusReady(function() {
					setTimeout(function() {
						mui('#pullrefresh').pullRefresh().pullupLoading();
					}, 1000);
				});
			} else {
		
				mui.ready(function() {
					mui('#pullrefresh').pullRefresh().pullupLoading();
				});
			}
</script>
</body>
</html>