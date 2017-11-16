<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"taskreceive
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <title>OI - ${companyStaffer.company_name}</title>
     <script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>

  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/allReset.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/iconfont.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-index.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/mui.min.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-footer-header.css">
<style>
    p{
        margin: 0;
        padding: 0;
    }
    input[type=search]{
        background: unset;
        margin-bottom:0;
        text-align:unset;
    }
    .mui-scroll{
        width:unset;
        position:unset;
    }
    .mui-table-view:after,.mui-table-view:before{
        background: unset;
    }
    .mui-pull-caption{
    font-size:0.35rem;}
    ::-webkit-input-placeholder { /* WebKit browsers */
    color:    #bebebe;
    font-family: 'Helvetica Neue',Helvetica,sans-serif;
}
.mui-pull-top-pocket{
height: 0.666667rem;
}
.mui-spinner{
width: 0.32rem;
    height: 0.32rem;
}
.mui-pull{
bottom:0}
</style>
<body>
<!--头部开始-->
    <header>
        <a href=""></a>
        <span class="header-title">消息</span>
    </header>
<!--头部结束-->
<!--main-->
<main>
    <!--搜索框-->
    <div class="msg-searchBox" >
        <input type="search" placeholder="输入关键字搜索" class="key">
        <div class="ss"></div>
    </div>
    <!--搜做结束-->
    <!--公告开始-->
    <div class="main" id="pullrefresh">
        <div class="mui-scroll">
        <ul class="li-content active1 mui-table-view mui-table-view-chevron">

        </ul>
        </div>
    </div>
    <!--公告结束-->
</main>
<!--main结束-->
<!--底部开始-->
 <footer>
        <ul>
            <li>
                <a href="yj-index.html" class="li-a li-msg">         
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
<!--底部结束-->
</body>
  <script src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
  <script src="${pageContext.request.contextPath }/statics/js/mui.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/dateFromt.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/index.js"></script>
<script type="text/javascript">
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
					getLis();
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
					getLis();
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