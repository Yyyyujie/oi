<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>OI - ${companyStaffer.company_name}</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/allReset.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/mui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/iconfont.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-footer-header.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/allReset.css"/>  
  <script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>
    <!--<link rel="stylesheet" href="css/mui.css">-->
    <style>
    a{
      text-decoration: none;
    }
    a:active{
     text-decoration: none;
    }
        p {
            margin: 0;
            padding: 0;
        }

        footer a {
            text-decoration: none;
        }
        .right{
            width: 4.5rem;
            padding-left:0;
            padding-right:0;
            margin-left:0.21rem;
        }
  .back{
      position: absolute;
    left: 0.32rem;
    top: 0;
    bottom: 0;
    margin: auto;
    line-height:  1.173333rem;
    color:#fff;
    }
     .mui-scroll{
        width:unset;
        position:unset;
    }
    main{
    bottom:0
    }
    .main{
        top: 0;
    bottom: 0rem;
    }
    .mui-table-view:before,.mui-table-view:after{
    background-color: unset;
    }
    .mui-spinner{
width: 0.24rem;
    height: 0.24rem;
}
   .mui-pull-caption{
    font-size:0.36rem;}
.iconfont{
font-size:unset;
}
    </style>
</head>
<body>
<header>
 <i class="iconfont icon-fanhui back"></i>
    <span class="header-title">员工晋级</span>
</header>
<div class="tab">
  
</div>
<main>
<div class="main" id="pullrefresh">
        <div class="mui-scroll">
        <ul class="li-content active1 mui-table-view mui-table-view-chevron">
				
        </ul>
        </div>
    </div>
</main>
</body>
<script src="${pageContext.request.contextPath }/statics/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/dateFromt.js"></script>
 <script src="${pageContext.request.contextPath }/statics/js/mui.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/yj-promotion.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/bootstrap.min.js"></script>

<script>
	$(".back").click(function(){
		location.href="${pageContext.request.contextPath }/staff/yj-member.html";
	})
	
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
					$(".li-content").empty();
				    pager=0;
					getLis()
					//mui('#pullrefresh').pullRefresh().endPulldownToRefresh(); //refresh completed
				}, 1000000);
			}
			var count = 0;
			/**
			 * 上拉加载具体业务实现
			 */
			function pullupRefresh() {
				setTimeout(function() {
					mui('#pullrefresh').pullRefresh().endPullupToRefresh((false)); //参数为true代表没有更多数据了。
					var table = document.body.querySelector('.mui-table-view');
					getLis()
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
</html>