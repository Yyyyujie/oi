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
<title>OI平台-管理设置</title>
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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/css/plugins/webuploader/webuploader.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/css/demo/webuploader-demo.css">
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
							管理成员 <small>请确认所有选项填写无误</small>
						</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					<!--表单正文-->
					<div class="ibox-content">
						<form class="form-horizontal" id="oi_ad_enter_edite"
							onsubmit="return false;">
							<input type="hidden" value="${oiAdmin.admin_id }" name="admin_id">
							<!--用户名称-->
							<div class="form-group">
								<input type="hidden" name="admin_id"> <label
									class="col-sm-2 control-label">用户名称</label> <span id="usermsg"></span>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="用户名称"
										name="user_name" value="${oiAdmin.user_name }">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--角色-->
							<div class="form-group">
								<label class="col-sm-2 control-label">角色</label>
								<div class="col-sm-8">
									<select class="form-control" name="role" id="role">
									</select>
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--用户密码-->
							<div class="form-group">
								<label class="col-sm-2 control-label">用户密码</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="用户密码留空不修改"
										name="password" > 
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--企业所在城市-->
							<!--电话号码-->
							<div class="form-group">
								<label class="col-sm-2 control-label">电话号码</label> <span
									id="phonemsg"></span>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="电话号码"
										name="phone" value="${oiAdmin.phone }">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--邮箱号码-->
							<div class="form-group">
								<label class="col-sm-2 control-label">邮箱号码</label> <span
									id="emailmsg"></span>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="邮箱号码"
										name="email" value="${oiAdmin.email }">
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--图片上传-->
							<div class="form-group">
								<label class="col-sm-2 control-label">头像</label>
								<div class="col-sm-8" id="head_div">
									<input type="hidden" id="file" name="head">
									<div class="page-container">
										<div>
											<input type="hidden" id="url"
												value="${pageContext.request.contextPath }/file/upload.do">
										</div>
										<div id="uploader" class="wu-example">

											<div class="queueList">

												<div id="dndArea" class="placeholder">
													<div id="filePicker"></div>
													<p>或将照片拖到这里，单次最多可选300张</p>
												</div>
											</div>
											<div class="statusBar" style="display:none;">
												<div class="progress">
													<span class="text">0%</span> <span class="percentage"></span>
												</div>
												<div class="info"></div>
												<div class="btns">
													<div id="filePicker2"></div>
													<div class="uploadBtn">开始上传</div>
												</div>
											</div>
										</div>
									</div>
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
	<!-- Web Uploader -->
	<script type="text/javascript">
		// 添加全局站点信息
		var BASE_URL = '${pageContext.request.contextPath }/statics/js/plugins/webuploader';
	</script>
	<script
		src="${pageContext.request.contextPath }/statics/js/plugins/webuploader/webuploader.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/statics/js/demo/webuploader-demo.js"></script>
	<!-- Web Uploader -->
	<script type="text/javascript">
		// 添加全局站点信息
		var BASE_URL = '${pageContext.request.contextPath }/statics/js/plugins/webuploader';
	</script>
	<script
		src="${pageContext.request.contextPath }/statics/js/plugins/webuploader/webuploader.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/statics/js/demo/webuploader-demo.js"></script>
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
			$.ajax({
				url : "${pageContext.request.contextPath}/Admin/getrolelist",
				type : "GET",
				dataType:"json",
				success : function(result) {
					var roles = result.extend.Roles;
					$("#role").html("");
					var Str = "<option value='0'>请选择角色</option>";
					for (var i = 0; i < roles.length; i++) {
						Str += '<option value="' + roles[i].o_r_id + '">' + roles[i].name + '</option>';
					}
					;
					$("#role").html(Str);
					var admin_id = "${requestScope.adminId}";
					if (admin_id.length != 0) {
						$.ajax({
							url : "${pageContext.request.contextPath}/Admin/getadmin.do/" + admin_id,
							type : "POST",
							success : function(result) {
								console.log(result);
								var admin = result.extend.Admin;
								$("input[name='admin_id']").val(admin.admin_id);
								$("input[name='user_name']").val(admin.user_name);
								//$("input[name='password']").val(admin.password);
								$("#role").val(admin.role);
								$("input[name='email']").val(admin.email);
								$("input[name='phone']").val(admin.phone);
								$("input[name='admin_id']").val(admin.admin_id);
								$("#head_div").empty();
								$("#head_div").append($("<img></img>").attr("src", admin.head));
							}
						});
					}
				}
			});
	
			$("input[name='user_name']").keyup(function() {
				checkuser();
			});
			$("input[name='email']").keyup(function() {
				checkemail();
			});
			$("input[name='phone']").keyup(function() {
				checkphone();
			});
			function checkuser() {
				$.ajax({
					url : "${pageContext.request.contextPath}/Admin/checkuser",
					type : "POST",
					dataType:"json",
					data : "name=" + $("input[name='user_name']").val(),
					success : function(result) {
						//console.log(result);
						if (result.code == 200) {
							$("#usermsg").html(result.extend.msg);
							return false;
						} else {
							$("#usermsg").html("");
						}
					}
				});
			}
			function checkemail() {
				$.ajax({
					url : "${pageContext.request.contextPath}/Admin/checkemail",
					type : "POST",
					dataType:"json",
					data : "email=" + $("input[name='email']").val(),
					success : function(result) {
						//console.log(result);
						if (result.code == 200) {
							$("#emailmsg").html(result.extend.msg);
							return false;
						} else {
							$("#emailmsg").html("");
						}
					}
				});
			}
			function checkphone() {
				$.ajax({
					url : "${pageContext.request.contextPath}/Admin/checkphone",
					type : "POST",
					data : "phone=" + $("input[name='phone']").val(),
					dataType : "json",
					success : function(result) {
						//console.log(result);
						if (result.code == 200) {
							$("#phonemsg").html(result.extend.msg);
							return false;
						} else {
							$("#phonemsg").html("");
						}
					}
				});
			}
			$("#oi_ad_enter_edite").submit(function() {
				checkuser();
				checkemail();
				checkphone();
				var params = $("#oi_ad_enter_edite").serialize();
				params = decodeURIComponent(params, true);
				//alert(params);
				$.ajax({
					url : "${pageContext.request.contextPath}/Admin/updateadmin.do",
					type : "POST",
					data : params,
					dataType : "json",
					success : function(result) {
						//console.log(result);
						if (result.code == 200) {
							alert(result.extend.msg);
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
