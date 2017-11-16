<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
  <title>OI - ${companyStaffer.company_name}</title>
		<script src="${pageContext.request.contextPath }/statics/js/rem.js"></script>
		<link href="${pageContext.request.contextPath }/statics/css/mui.min.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath }/statics/css/iconfont.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath }/statics/css/list.css" rel="stylesheet"/>
		<script src="${pageContext.request.contextPath }/statics/js/jQuery.js"></script>
		
		<style>
			html,
			body {
				height: 100%;
				overflow: hidden;
			}
			.mui-bar {
				-webkit-box-shadow: none;
				box-shadow: none;
			}
			a{
				color:#000;
			}
			a:active{
			color:#000;
			}
			.back{
			line-height: 0.88rem;
    color: #fff;
        font-size: 0.26rem;}
		</style>
	</head>
	<body>
		<header class="mui-bar mui-bar-nav">
			<i class="iconfont icon-fanhui back"></i>
			<h1 class="mui-title">通讯录</h1>
		</header>
		<div class="mui-content">
			<div id='list' class="mui-indexed-list">
				<div class="mui-indexed-list-search mui-input-row mui-search">
					<input type="search" class="mui-input-clear mui-indexed-list-search-input" placeholder="请输入查找词">
				</div>
				    <!--  <div class="weui-panel weui-panel_access stuff_info_list" id="sf_tsk_backlog_4">-->
				<div class="mui-indexed-list-bar">
					<a>A</a>
					<a>B</a>
					<a>C</a>
					<a>D</a>
					<a>E</a>
					<a>F</a>
					<a>G</a>
					<a>H</a>
					<a>I</a>
					<a>J</a>
					<a>K</a>
					<a>L</a>
					<a>M</a>
					<a>N</a>
					<a>O</a>
					<a>P</a>
					<a>Q</a>
					<a>R</a>
					<a>S</a>
					<a>T</a>
					<a>U</a>
					<a>V</a>
					<a>W</a>
					<a>X</a>
					<a>Y</a>
					<a>Z</a>
				</div>
				<div class="mui-indexed-list-alert"></div>
				<div class="mui-indexed-list-inner" style="position: absolute;
    bottom: 1rem;
    top: 1rem;
    overflow-y: scroll;left:0;right:0 ">
					<div class="mui-indexed-list-empty-alert">没有数据</div>
					<ul class="mui-table-view"id="mui-table-view">
								
					</ul>
				</div>
			</div>

		<script src="${pageContext.request.contextPath }/statics/js/mui.min.js"></script>
		<script src="${pageContext.request.contextPath }/statics/js/list.js"></script>
		<script type="text/javascript" charset="utf-8">
		$(".back").click(function(){
		 location.href="${pageContext.request.contextPath }/staff/yj-member.html"
		});
			mui.init();
			mui.ready(function() {
				var header = document.querySelector('header.mui-bar');
				var list = document.getElementById('list');
				//calc hieght
				list.style.height = (document.body.offsetHeight - header.offsetHeight) + 'px';
				//create
				window.indexedList = new mui.IndexedList(list);
			});
			
			

			$(".mui-indexed-list-search").bind("input porpertychange", function () {
			    	var keyword=$(".mui-indexed-list-search-input").val();
			    	console.log(keyword);
			    	var name=$(".name");
			    	for(var i=0;i<name.length;i++){
			    	   /* if(name[i].indexOf(keyword)>0){
			    	        console.log(name[i])
						}*/


					}
                console.log(name)
			})


		</script>
		 <script src="${pageContext.request.contextPath }/statics/js/yj-tongxun.js"></script>
		
	</body>

</html>


