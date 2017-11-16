<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>OI平台-平台公告</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/statics/favicon.ico">
<link
	href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/statics/css/font-awesome.css?v=4.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/statics/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/statics/css/animate.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/statics/css/style.css?v=4.1.0"
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

.box {
	display: flex;
	-webkit-display: flex;
	justify-content：space-between;
	-webkit-justify-content：space-between;
}
/* .box .form-control{
          margin:0 20px 0 0;
        } */
#dept {
	margin: 0 20px 0 20px;
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
							企业新闻 <small>请确认所有选项填写无误</small>
						</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					<!--表单正文-->
					<div class="ibox-content">
						<form id="submit" action="${pageContext.request.contextPath}/Admin/publishNotice"
							method="post" class="form-horizontal" accept-charset="UTF-8">
							<input type="hidden" name="new_id" value="${news.new_id }">
							<div class="form-group">
								<label class="control-label col-sm-2">标题</label>
								<div class="col-sm-8">
									<input type="text" name="title" value="${news.title }"
										class="form-control" placeholder="请填写新闻标题"  required="required"/>
								</div>
							</div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--企业分类-->
							<div class="form-group">
								<label class="col-sm-2 control-label">接收方</label>
								<div class="col-sm-8 box">
									<select class="form-control" name="company_id" id="company" required="required">
										<option value="">请选择公司</option>
										<c:forEach var="company" items="${requestScope.companys}">
											<c:if test="${company.company_id==news.company_id }">
												<option value="${company.company_id }" selected="selected">${company.company_name }</option>
											</c:if>
											<c:if test="${company.company_id!=news.company_id  }">
												<option value="${company.company_id }" >${company.company_name }</option>
											</c:if>
										</c:forEach>
									</select> <span class="glyphicon glyphicon-asterisk" aria-hidden="true"
										style="color: red"></span> <select class="form-control"
										id="dept" name="dept_id">
										<option value="">请选择部门</option>
									</select> <select class="form-control" name="user_id" id="user">
										<option value="">请选择个人</option>
									</select>
								</div>
							</div>
							<!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <div class="form-group">
								<label class="col-sm-2 control-label">类型</label>
								<div class="col-sm-8 box">
									 <select class="form-control" name="type_id">
										<option value="0">请选择类型</option>
										<c:forEach var="newsType" items="${listNewsType }">
											<c:if test="${newsType.news_type_id==news.type_id }">
												<option value="${newsType.news_type_id }" selected="selected">${newsType.news_type
												}</option>	
											</c:if>
											<c:if test="${newsType.news_type_id!=news.type_id }">
												<option value="${newsType.news_type_id }">${newsType.news_type
												}</option>	
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>		
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<div class="form-group">
                                <label class="control-label col-sm-2">内容</label>
                                <div class="col-sm-8">
                                	<textarea id="TextArea1" name="content" cols="30" rows="10" class="ckeditor">${news.content }</textarea>
                                    <%-- <textarea name="content" id="contentEditor" cols="30" rows="10" class="form-control">${news.content }</textarea> --%>
                                </div>
                            </div>
							<!--水平线-->
							<div class="hr-line-dashed"></div>
							<!--水平线 - 结束-->
							<!--提交表单部分-->
							<div class="form-group row">
								<input type="button" id="button" value="确认无误,提交"
									class="col-md-offset-5 col-md-2 btn btn-success">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script
		src="${pageContext.request.contextPath }/statics/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/bootstrap.min.js?v=3.3.6"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/plugins/ckeditor/ckeditor.js"></script>
	<script>
		  	 var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
		$("#button").on('click', function(){
			$("#submit").submit();
			parent.layer.close(index); //执行关闭
		});
		$(function() {
			$("#company").change(function() {
				var company_id = $("#company").val();
				$.ajax({
					url : "${pageContext.request.contextPath}/Admin/getdept/" + company_id,
					type : "GET",
					dataType : "json",
					success : function(result) {
						var dept = result.extend.depts;
						if (dept.length!=0) {
							var str = "<option value='0'>请选择部门</option>";
							$.each(dept, function(index, item) {
								str += '<option value="' + item.dept_id + '">' + item.dept_name + '</option>';
							});
							$("#dept").html(str);
						} else {
							$("#dept").html("<option value='0'>该公司下暂无部门</option>")
						}
	
					}
				});
			});
			$("#dept").change(function() {
				var dept_id = $("#dept").val();
				var company_id = $("#company").val();
				$.ajax({
					url : "${pageContext.request.contextPath}/Admin/getstaffer/"+dept_id+"/"+company_id,
					type : "GET",
					dataType : "json",
					success : function(result) {
						var staffer = result.extend.staffers;
						if (staffer.length!=0) {
							var str = "<option value='0'>请选择员工</option>";
							$.each(staffer, function(index, item) {
								str += '<option value="' + item.user_id + '">' + item.realname + '</option>';
							});
							$("#user").html(str);
						} else {
							$("#user").html("<option value='0'>该部门下暂无员工</option>")
						}
	
					}
				});
			});
		});
	</script>
</body>
</html>
