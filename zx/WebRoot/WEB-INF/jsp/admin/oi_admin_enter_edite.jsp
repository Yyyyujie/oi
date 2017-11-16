<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>OI平台-企业版-企业基础设置</title>
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
							企业列表编辑 <small>请确认所有选项填写无误</small>
						</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					<!--表单正文-->
					<div class="ibox-content">
						<form class="form-horizontal" id="oi_ad_enter_edite" onsubmit="return false">
							<!--企业名称-->
							<div class="form-group">
								
							<input type="hidden" name="company_id" <c:if test="${requestScope.company !=null}">	value="${requestScope.company}"</c:if>/> 
								<label	class="col-sm-2 control-label">企业名称</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="企业名称"
										name="company_name" disabled="disabled">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--企业分类-->
							<div class="form-group">
								<label class="col-sm-2 control-label">企业分类</label>
								<div class="col-sm-8">
									<select class="form-control" name="type_id" id="type"
										disabled="disabled">
										<option value="">请选择企业类型</option>
										<c:forEach var="type" items="${requestScope.Type}">
											<option value="${type.type_id }">${type.type_name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--企业人数-->
							<div class="form-group">
								<label class="col-sm-2 control-label">企业人数</label>
								<div class="col-sm-8">
									<input type="number" class="form-control" placeholder="请填写企业人数"
										name="company_num" disabled="disabled">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--企业所在城市-->
							<div class="form-group">
								<label class="col-sm-2 control-label">所在城市</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="addr"
										disabled="disabled">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--详细地址-->
							<div class="form-group">
								<label class="col-sm-2 control-label">公司法人</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="请填写公司法人"
										name="corporate_rep" disabled="disabled">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--详细地址-->
							<div class="form-group">
								<label class="col-sm-2 control-label">详细地址</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="请填写详细地址"
										name="address" disabled="disabled">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--联系人-->
							<div class="form-group">
								<label class="col-sm-2 control-label">联系人</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="请填写联系人"
										name="contact" disabled="disabled">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--手机号-->
							<div class="form-group">
								<label class="col-sm-2 control-label">手机号</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="请填写手机号"
										name="phone" disabled="disabled">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--统一社会信用代码-->
							<div class="form-group">
								<label class="col-sm-2 control-label">统一社会信用代码：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control"
										placeholder="请填写统一社会信用代码" name="license_id"
										disabled="disabled">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--营业执照-->
							<div class="form-group">
								<label class="col-sm-2 control-label">营业执照</label>
								<div class="col-sm-8 pic-uploader-box">
									<!--营业执照状态-->

									<!--营业执照照片-->
									<img class="img-responsive thumbnail" alt="" id="pic" />
									<!--上传按钮-->
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--审核状态-->
							<div class="form-group clearfix">
								<label class="col-sm-2 control-label">审核状态：</label>
								<div class="row">
									<label class="col-sm-2" for="oi_check_status_1"><input
										id="oi_check_status_1" name="audit" type="radio" value="0" />&nbsp;待审核</label>
									<label class="col-sm-2" for="oi_check_status_2"><input
										id="oi_check_status_2" name="audit" type="radio" value="1" />&nbsp;已审核</label>
									<label class="col-sm-2" for="oi_check_status_3"><input
										id="oi_check_status_3" name="audit" type="radio" value="2"/>&nbsp;已拒绝</label>
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--提交表单部分-->
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
	<script	src="${pageContext.request.contextPath}/statics/js/plugins/layer/layer.js"></script>
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
				var company_id=$("[name='company_id']").val();
				if(company_id.length!=0){
				$.ajax({
				url : "${pageContext.request.contextPath}/Admin/getcompany.do/"+company_id,
				type : "POST",
				dataType:"json",
				success : function(result) {
					//console.log(result);
					var Company = result.extend.company;
					$("#oi_ad_enter_edite input[name='company_name']").val(Company.company_name);
					$("#type").val(Company.type_id);
					$("#oi_ad_enter_edite input[name='company_num']").val(Company.company_num);
					$("#oi_ad_enter_edite input[name='addr']").val(Company.addr);
					$("#oi_ad_enter_edite input[name='corporate_rep']").val(Company.corporate_rep);
					$("#oi_ad_enter_edite input[name='address']").val(Company.address);
					$("#oi_ad_enter_edite input[name='contact']").val(Company.contact);
					$("#oi_ad_enter_edite input[name='phone']").val(Company.phone);
					$("#oi_ad_enter_edite input[name='license_id']").val(Company.license_id);
					$("#pic").attr("src",Company.license_img);
					$("#oi_ad_enter_edite input[name=audit]").val([Company.audit]);	
				}
			});
			}	
				
							
			$("#oi_ad_enter_edite").submit(function(){
			var params=$("#oi_ad_enter_edite").serialize();
			params = decodeURIComponent(params,true);
			//alert(params);
			$.ajax({
				url : "${pageContext.request.contextPath}/Admin/updatecompany.do",
				type : "POST",
				data:params,
					dataType:"json",
				success : function(result) {
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
</body>
</html>
