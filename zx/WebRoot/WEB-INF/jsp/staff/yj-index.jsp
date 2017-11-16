<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>OI - ${companyStaffer.company_name}</title>
<script src="${pageContext.request.contextPath }/statics/js/rem.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/iconfont.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-index.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/footer.css">
<!--<link rel="stylesheet" href="css/mui.css">-->
<style>
p {
	margin: 0;
	padding: 0;
}

footer a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="headerr">
		<div class="header-zhe">
			<!--<i class="iconfont icon-fanhui back"></i>-->
			<span>消息中心</span>
		</div>
	</div>
	<div class="tab">
		<div class="tab-main">
			<ul>
				<li class="active">企业公告</li>
				<li>晋升进度</li>
			</ul>
		</div>
	</div>
	<div class="main">
		<ul class="qy active1">
			<a href="yj-index-con.html">
				<li class="gg">
					<div class="left">
						<div class="tx">
							<div class="img">
								<img src="img/person.jpg" alt=""
									style="width: 100%;height: 100%;">
							</div>
						</div>
						<i class="shu"></i>
					</div>
					<div class="right">
						<p>新明日集团成立五周年</p>

						<p>
							热烈祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺热烈祝贺</p>

						<p>
							<span class="iconfont icon-shijian time">&nbsp<span
								class="zi">2017.9.15</span></span><span
								class="iconfont icon-liulan look">&nbsp<span class="zi">123</span></span>
						</p>
					</div>
					<div class="new">new</div>
			</li>
			</a>
		</ul>
		<ul class="js">
			<a href="yj-jinsheng.html">
				<li class="gg">
					<div class="left">
						<div class="tx">
							<div class="img">
								<img src="img/person.jpg" alt=""
									style="width: 100%;height: 100%;">
							</div>
						</div>
						<i class="shu"></i>
					</div>
					<div class="right">
						<p>张宇</p>

						<div class="progress"
							style="height: 0.06rem;background: none;border: 0.01rem solid #13a3ff;margin: 0.08rem 0;">
							<div class="progress-bar" role="progressbar" aria-valuenow="60"
								aria-valuemin="0" aria-valuemax="100"
								style="width: 60%; background: -webkit-linear-gradient(left,#13a3ff,#13f0ff)">
								60%</div>
						</div>
						<div class="biaoshi">5</div>
						<p class="mb">目标：经理</p>

						<p>
							<span class="iconfont icon-bumen time">&nbsp&nbsp<span
								class="zi">2017.9.15</span></span><span
								class="iconfont icon-zhiwei look">&nbsp<span class="zi">123</span></span>
						</p>
					</div> <!--<div class="new">new</div>-->
			</li>
			</a>
		</ul>
	</div>

	<div class="footer">
		<ul>
			<a href="${pageContext.request.contextPath }/Newstaff/yj-index.html">
				<li class="active2">
					<div class="f-tu">
						<i class="iconfont icon-xiaoxi active"></i>

						<p class="active">消息</p>
					</div> <em></em>
			</li>
			</a>
			<a href="${pageContext.request.contextPath }/Newstaff/oi_staff_task_center.html">
				<li>
					<div class="f-tu">
						<i class="iconfont icon-renwu"></i>

						<p>任务</p>
					</div> <em></em>
			</li>
			</a>
			<a href="${pageContext.request.contextPath }/Newstaff/oi_staff_task_release.html">
				<li>
					<div class="f-tu">
						<!-- <i class="iconfont icon-app-tongji"></i>-->
						<div class="fabu" style="bottom: -0.5rem;">
							<div class="ic"></div>
						</div>
					</div> <!--<p>消息</p>--> <em></em>
			</li>
			</a>
			<a href="${pageContext.request.contextPath }/Newstaff/oi_staff_data_center.html">
				<li>
					<div class="f-tu">
						<i class="iconfont icon-app-tongji"></i>
						<p>统计</p>
					</div> <em></em>
			</li>
			</a>
			<a href="${pageContext.request.contextPath }/Newstaff/yj-member.html">
				<li>
					<div class="f-tu">
						<i class="iconfont icon-artboard83"></i>
						<p>我</p>
					</div>

			</li>
			</a>
		</ul>
	</div>
</body>
<script src="${pageContext.request.contextPath }/statics/js/index.js"></script>
</html>