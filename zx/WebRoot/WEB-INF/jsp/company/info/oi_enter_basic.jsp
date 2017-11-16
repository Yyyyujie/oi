<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>OI平台-企业版-企业基础设置</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/statics/favicon.ico">
<link
	href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/statics/css/mui.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/statics/css/font-awesome.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/statics/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/statics/css/animate.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/statics/css/style.css"
	rel="stylesheet">
<style>
.switch {
	display: inline-block
}
</style>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>
							企业基础设置 <small>请确认所有选项填写无误</small>
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
						<form action="<%=basePath%>/company/Basic/updateBasic.html"
							method="post" class="form-horizontal">
							<input type="hidden" value="${companyBasic.b_id }" name="b_id">
							<!--企业简称-->
							<div class="form-group">
								<label class="col-sm-2 control-label">企业简称</label>
								<div class="col-sm-8">
									<input type="text" value="${companyBasic.company_name }"
										class="form-control" disabled="disabled" placeholder="请填写企业简称">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--企业网址-->
							<div class="form-group">
								<label class="col-sm-2 control-label">企业网址</label>
								<div class="col-sm-8">
									<input type="text" value="${companyBasic.URL }" name="URL"
										class="form-control" placeholder="请填写企业网址">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--勉励口号-->
							<div class="form-group">
								<label class="col-sm-2 control-label">勉励口号</label>
								<div class="col-sm-8">
									<input type="text" value="${companyBasic.slogan }"
										name="slogan" class="form-control" placeholder="请填写勉励口号">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!-- 开关 -->
							<div class="form-group">
								<label class="col-sm-2 control-label">投票通道</label>
								<div class="mui-switch switch mui-active">
									<div class="mui-switch-handle"></div>
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--晋级周期-->
							<div class="form-group">
								<label class="col-sm-2 control-label">晋级周期</label>
								<div class="col-sm-8 ">
									<input type="number" value="${companyBasic.period }"
										name="period" class="form-control sss"
										placeholder="请填写经济周期（数字）" />
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--晋级标准-->
							<div class="form-group">
								<label class="col-sm-2 control-label">晋级标准</label>
								<div class="col-sm-8">
									<input type="text" value="${companyBasic.standard }"
										name="standard" class="form-control sss"
										placeholder="请填写晋级标准（数字）">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--投票天数-->
							<div class="form-group">
								<label class="col-sm-2 control-label">投票天数</label>
								<div class="col-sm-8">
									<input type="number" value="${companyBasic.days }" name="days"
										class="form-control sss" placeholder="请填写投票天数（数字）">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--提醒节点-->
							<div class="form-group">
								<label class="col-sm-2 control-label">提醒节点</label>
								<div class="col-sm-8">
									<input type="number" value="${companyBasic.panel_point }"
										name="panel_point" class="form-control sss"
										placeholder="请填写提醒节点（数字）">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--默认密码-->
							<div class="form-group">
								<label class="col-sm-2 control-label">默认密码</label>
								<div class="col-sm-8">
									<input type="text" value="${companyBasic.password }"
										name="password" class="form-control" placeholder="请填写默认密码">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->

							<!--提交表单部分-->
							<div class="form-group row">
								<button class="col-md-offset-5 col-md-2 btn btn-success">确认无误,提交</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script
		src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/statics/js/mui.min.js"></script>
	<!-- 自定义js -->
	<script src="${pageContext.request.contextPath }/statics/js/content.js"></script>
	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath }/statics/js/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(function() {
			var period = $(".sss").val();
			//页面加载判断是否已禁用过
			if (period == null || period == 99999) {
				$(".switch").removeClass("mui-active");
				$(".sss").attr("disabled", true);
			}
			//单击开关触发事件
			$(".switch").click(function() {
				if ($(this).hasClass("mui-active")) {
					$(".sss").attr("disabled", false);
				} else {
					$(".sss").attr("disabled", true);
				}
			});
		});
		$(document).ready(function() {
			$('.i-checks').iCheck({
				checkboxClass : 'icheckbox_square-green',
				radioClass : 'iradio_square-green'
			});
		});
	</script>
</body>
</html>
