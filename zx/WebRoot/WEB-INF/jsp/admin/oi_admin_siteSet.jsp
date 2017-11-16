<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<base href="<%=basePath%>">
<title>OI平台 - 站点设置</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
<link rel="shortcut icon" href="favicon.ico">
<link
	href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/statics/css/font-awesome.css?v=4.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/statics/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/statics/css/animate.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/statics/css/style.css?v=4.1.0"
	rel="stylesheet">
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>
							站点设置 <small>请确认所有选项填写无误</small>
						</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="dropdown-toggle" data-toggle="dropdown"
								href="form_basic.html#"> <i class="fa fa-wrench"></i>
							</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="form_basic.html#">选项1</a></li>
								<li><a href="form_basic.html#">选项2</a></li>
							</ul>
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<!--表单正文-->
					<div class="ibox-content">
						<form class="form-horizontal" id="Siteform">
							<input type="hidden" name="s_id">
							<!--网址-->
							<div class="form-group">
								<label class="col-sm-2 control-label">网址</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="请填写网址"
										name="s_URL" required="required">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--标题-->
							<div class="form-group">
								<label class="col-sm-2 control-label">标题</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="请填写标题"
										name="s_title" required="required">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--名称-->
							<div class="form-group">
								<label class="col-sm-2 control-label">名称</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="请填写名称"
										name="s_name" required="required">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--描述-->
							<div class="form-group">
								<label class="col-sm-2 control-label">描述</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="请填写描述"
										name="s_depict" required="required">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--关键字-->
							<div class="form-group">
								<label class="col-sm-2 control-label">关键字</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="请填写关键字"
										name="s_keywords" required="required">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--版本-->
							<div class="form-group">
								<label class="col-sm-2 control-label">版本</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="请填写版本"
										name="s_edition" required="required">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--备案-->
							<div class="form-group">
								<label class="col-sm-2 control-label">备案</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="请填写备案"
										name="s_record" required="required">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<div class="form-group row">
								<button type="submit"
									class="col-md-offset-5 col-md-2 btn btn-success">确认无误,提交</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script
		src="${pageContext.request.contextPath}/statics/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js?v=3.3.6"></script>
	<!-- 自定义js -->
	<script
		src="${pageContext.request.contextPath}/statics/js/content.js?v=1.0.0"></script>
	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath}/statics/js/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.i-checks').iCheck({
				checkboxClass : 'icheckbox_square-green',
				radioClass : 'iradio_square-green'
			});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			showsite();
		});
		$("#Siteform").submit(function() {
		var params=$("#Siteform").serialize();
			params = decodeURIComponent(params,true);
			$.ajax({
				url : "${pageContext.request.contextPath}/Admin/updatesite.do",
				type : "POST",
				data:params,
				dataType:"json",
				success : function(result) {
					//console.log(result);
					if (result.code == 200) {
						alert("修改失败");
					} else {
						showsite();
					}
				}
			});
		});
		function showsite() {
			$.ajax({
				url : "${pageContext.request.contextPath}/Admin/getsite.do",
				type : "GET",
				dataType:"json",
				success : function(result) {
					//console.log(result);
					if (result.code == 100) {
						var oiSite = result.extend.OiSite;
						$("input[name='s_id']").val(oiSite.s_id);
						$("input[name='s_URL']").val(oiSite.s_URL);
						$("input[name='s_depict']").val(oiSite.s_depict);
						$("input[name='s_edition']").val(oiSite.s_edition);
						$("input[name='s_keywords']").val(oiSite.s_keywords);
						$("input[name='s_name']").val(oiSite.s_name);
						$("input[name='s_record']").val(oiSite.s_record);
						$("input[name='s_title']").val(oiSite.s_title);
					}
				}
			});
		}
	</script>
</body>
</html>
