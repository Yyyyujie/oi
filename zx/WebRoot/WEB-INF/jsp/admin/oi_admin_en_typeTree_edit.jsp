<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<base href="<%=basePath%>">
<title>OI平台-节点编辑</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
<link rel="shortcut icon" href="favicon.ico">
<link href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${pageContext.request.contextPath}/statics/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath}/statics/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/statics/css/animate.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/statics/css/style.css?v=4.1.0" rel="stylesheet">
<style>
.pic-uploader-box {
	position: relative;
}

.pic-uploader {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	opacity: 0;
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
							节点编辑 <small></small>
						</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					<!--表单正文-->
					<div class="ibox-content">
						<form class="form-horizontal" id="oi_ad_enter_edite" onsubmit="return false">
						<c:if test="${requestScope.type!=null}">
						<input type="hidden" name="type_id" value="${requestScope.type.type_id}"/>
						</c:if>
							<!--用户名称-->
							<div class="form-group">
								<label class="col-sm-offset-3 col-sm-2 control-label">上级分类</label>
								<div class="col-sm-3">
									<select name="pid" class="form-control" id="typeid">
									</select>
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--分类名称-->
							<div class="form-group">
								<label class="col-sm-offset-3 col-sm-2 control-label">分类名称</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" placeholder="请输入中文菜单名称" name="type_name" <c:if test="${requestScope.type!= null}">value="${requestScope.type.type_name}"</c:if> />
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--排序-->
							<div class="form-group">
								<label class="col-sm-offset-3 col-sm-2 control-label">排序：</label>
								<div class="col-sm-3">
									<input type="number" class="form-control" placeholder="排序" name="o" <c:if test="${requestScope.type!= null}">value="${requestScope.type.o}"</c:if> />
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--状态-->
							<div class="form-group">
								<label class="col-sm-offset-1 col-sm-4 control-label">是否启用</label>
								<div class="col-sm-2">
									<label> <input type="radio" name="status" value="1" <c:if test="${requestScope.type!=null && requestScope.type.status==1}">checked</c:if> /> 启用
									</label>
								</div>
								<div class="col-sm-2">
									<label> <input type="radio" name="status" value="0" <c:if test="${requestScope.type!=null && requestScope.type.status==0}">checked</c:if> /> 停用
									</label>
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--提交表单部分-->
							<div class="form-group row text-center">
								<button class="col-sm-offset-5 col-sm-2 btn btn-success">确认无误,提交</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/statics/js/jquery.min.js?v=2.1.4"></script>
	<script src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js?v=3.3.6"></script>
	<!-- 自定义js -->
	<script src="${pageContext.request.contextPath}/statics/js/content.js?v=1.0.0"></script>
</body>
<script type="text/javascript">
$(function(){
var type_id=${requestScope.type_id};
	$.ajax({
			url:"${pageContext.request.contextPath}/Admin/findtype",
			type:"GET",
			dataType:"json",
			success:function(result){
				var type = result.extend.Types;
				$("#typeid").html("");
					var Str = ''
					for (var i = 0; i < type.length; i++) {
						Str += '<option value="'+type[i].type_id+'">'+type[i].type_name+'</option>';
					}
					;
					$("#typeid").html(Str);
					$("#typeid").val(type_id);
				}

	 });
	 $("#oi_ad_enter_edite").submit(function(){
			var params=$("#oi_ad_enter_edite").serialize();
			params = decodeURIComponent(params,true);
			$.ajax({
				url : "${pageContext.request.contextPath}/Admin/updatetype.do",
				type : "POST",
				dataType:"json",
				data:params,
				success : function(result) {
					//console.log(result);
					if (result.code == 200) {
						alert("失败");
					} else {
			   var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
				parent.layer.close(index);
					}
				}
			});
			});
			
});
</script>
</html>
