<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OI平台-企业版-企业信息</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/statics/favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/style.css?v=4.1.0" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/css/plugins/webuploader/webuploader.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/css/demo/webuploader-demo.css">
	
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>企业信息设置 <small>请确认所有选项填写无误</small></h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="form_basic.html#">选项1</a>
                                </li>
                                <li><a href="form_basic.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <!--表单正文-->
                    <div class="ibox-content">
                        <form action="${pageContext.request.contextPath }/company/message/updateMessage.html" method="post" class="form-horizontal" enctype="multipart/form-data">
                           	<!-- 企业ID -->
                           	<input type="hidden" value="${Message.company_id }" name="company_id">
                            <!--企业名称-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">企业名称</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${Message.company_name }" name="company_name" class="form-control" placeholder="请填写企业名称">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--企业分类-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="typeSelector">企业分类</label>
                                <div class="col-sm-8">
                                	<input type="hidden" id="typeId" value="${Message.type_id }">
                                    <select id="type_id"  class="form-control" name="type_id" id="typeSelector">
                                    	<option value="0">请选择分类</option>
                                    	<c:forEach var="type" items="${type }">
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
                                    <input type="number" value="${Message.company_num }" name="company_num"  class="form-control" placeholder="请填写企业人数">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--所在城市-->
							<div class="form-group">
								<input type="hidden" id="addr" value="${Message.addr }">
								<input type="hidden" name="addre" id="addre">
								<label class="col-sm-2 control-label">所在城市</label>
								<div class="col-sm-3">
									<input type="hidden" id="pro_id" value="${Message.pro_id }">
									<select class=" form-control" name="pro_id" id="pro">
										<option value="">请填写所在省</option>
									</select>
								</div>
								 <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
								<div class="col-sm-3">
									<input type="hidden" id="city_id" value="${Message.city_id }">
									<select class=" form-control" name="city_id" id="city">
										<option value="">请填写所在城市</option>
									</select>
								</div>
								 <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
								<div class="col-sm-3">
									<input type="hidden" id="area_id" value="${Message.area_id }">
									<select class=" form-control" name="area_id" id="area">
										<option value="">请填写所在区</option>
									</select>
								</div>
							</div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--详细地址-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">详细地址</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${Message.address }" name="address" class="form-control" placeholder="请填写详细地址">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--联系人-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">联系人</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${Message.contact }" name="contact" class="form-control" placeholder="请填写联系人">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--联系电话-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">联系电话</label>
                                <div class="col-sm-8">
                                    <input type="number" value="${Message.phone }" name="phone" class="form-control" placeholder="请填写联系电话">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--统一社会信用代码-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">统一社会信用代码</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${Message.license_id }" name="license_id" class="form-control" placeholder="请填写统一社会信用代码">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--营业执照图片-->
                            <div class="form-group" style="position:relative;overflow:hidden;">
                                <label class="col-sm-2 control-label">营业执照图片</label>
                                <div class="col-sm-8" style="height:200px;width: 300px;border:1px solid #ccc">
                                   
                                    <img src="http://oi.sxfs0351.com/${Message.license_img }" style="height:100%;width:100%">
                                     <input type="hidden" id="file" name="license_img">
                                </div>
                                <div class="uploadBox">
                                 <div><input type="hidden" id="url" value="${pageContext.request.contextPath }/file/upload.do"> </div>
                                <div id="uploader" class="wu-example" style="height:200px">                            
                                <div class="queueList" style="margin:0;height:193px">                                
                                    <div id="dndArea"  class="placeholder" style="padding-top:0">
                                        <div id="filePicker" style="margin-top:40px"><img src="${propaganda.pic_URL }"></img></div>
                                        <p>或将照片拖到这里，单次最多可选300张</p>
                                    </div>
                                </div>
                                <div class="statusBar" style="display:none; bottom:61px">
                                    <div class="progress">
                                        <span class="text">0%</span>
                                        <span class="percentage"></span>
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
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--认真阅读同意协议-->
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-8">
                                    <label for="checkService">
                                        <input type="checkbox" id="checkService">
                                        <strong>我已经认真阅读并同意《使用协议》</strong>
                                    </label>
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--提交表单部分-->
                            <div class="form-group row">
                                <button id="submit" class="col-md-offset-5 col-md-2 btn btn-success" style="border:none;">确认无误,提交</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 全局js -->
    <script src="${pageContext.request.contextPath }/statics/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath }/statics/js/bootstrap.min.js?v=3.3.6"></script>
    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath }/statics/js/content.js?v=1.0.0"></script>
    <!-- iCheck -->
    <script src="${pageContext.request.contextPath }/statics/js/plugins/iCheck/icheck.min.js"></script>
   <!-- 上传图片 -->
   	<script type="text/javascript">
        // 添加全局站点信息
        var BASE_URL = '${pageContext.request.contextPath }/statics/js/plugins/webuploader';
    </script>
    <script src="${pageContext.request.contextPath }/statics/js/plugins/webuploader/webuploader.min.js"></script>

    <script src="${pageContext.request.contextPath }/statics/js/demo/webuploader-demo.js"></script>
   	
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green'
            });
        });
    </script>
    <script type="text/javascript">
		$(function() {
			
				 var type_id=document.getElementById("type_id");
		        	  var typeId=$("#typeId").val();
		        	 for(var i=0;i<type_id.options.length;i++){                      
		                  if(typeId==type_id.options[i].value){                       		
		                     type_id.options[i].selected="true";
		                  }
		              } 
		
		
		
			$.ajax({
				url : "${pageContext.request.contextPath}/Admin/companyready.do",
				type : "GET",
				dataType:"json",
				success : function(result) {
					console.log(result);
					var province=result.extend.district;
					$("#pro").html("");
					var Strpro = ' <option value="">请选择所在省</option>'
					for (var j = 0; j < province.length; j++) {
						Strpro += '<option value="' + province[j].district_id + '">' + province[j].district + '</option>';
					}
					
					 var pro=document.getElementById("pro");
		        	  var proD=$("#pro_id").val();
		        	 for(var i=0;i<pro.options.length;i++){                      
		                  if(proD==pro.options[i].value){                       		
		                     pro.options[i].selected="true";
		                  }
		              } 
					;
					$("#pro").html(Strpro);
					
					
				}
			});
				$("#pro").change(function(){
				$.ajax({
				url : "${pageContext.request.contextPath}/Admin/findcity",
				type : "GET",
				dataType:"json",
				data:"pro_id="+$(this).val(),
				success : function(result) {
				var city = result.extend.districts;
				$("#city").html("");
					var Str = '<option value="">请选择所在市</option>'
					for (var i = 0; i < city.length; i++) {
						Str += '<option value="' + city[i].district_id + '">' + city[i].district + '</option>';
					}
					var pro=document.getElementById("city");
		        	  var proC=$("#city_id").val();
		        	 for(var i=0;i<pro.options.length;i++){                      
		                  if(proC==pro.options[i].value){                       		
		                     pro.options[i].selected="true";
		                  }
		              } 
					;
					$("#city").html(Str);
				}
				});
				});
				$("#city").change(function(){
				$.ajax({
				url : "${pageContext.request.contextPath}/Admin/findarea",
				type : "GET",
				dataType:"json",
				data:"city_id="+$(this).val(),
				success : function(result) {
				var area = result.extend.districts;
				$("#area").html("");
					var Str = '<option value="">请选择所在区</option>'
					for (var i = 0; i < area.length; i++) {
						Str += '<option value="' + area[i].district_id + '">' + area[i].district + '</option>';
					}
					var pro=document.getElementById("area");
		        	  var proC=$("#area_id").val();
		        	 for(var i=0;i<pro.options.length;i++){                      
		                  if(proC==pro.options[i].value){                       		
		                     pro.options[i].selected="true";
		                  }
		              } 
					;
					$("#area").html(Str);
				}
				});
				});
			$("#submit").click(function(){
				var pro=$("#pro").find("option:selected");
				var city=$("#city").find("option:selected");
				var area=$("#area").find("option:selected");
				if(pro.val()=="" || city.val()=="" || area.val()==""){
					$("#addre").val($("#addr").val());
				}else{
					$("#addre").val(pro.text()+"/"+city.text()+"/"+area.text());
				}
				
			})
		$("#submit").attr("disabled",true).css("background","#ccc");
		$("#checkService").click(function(){
		if($("#checkService").is(':checked')){
			$("#submit").attr("disabled",false).css("background","");
			
			}else{
			$("#submit").attr("disabled",true).css("background","#ccc");
			} 
		})
		 
		})
		
	</script>
</body>
</html>
