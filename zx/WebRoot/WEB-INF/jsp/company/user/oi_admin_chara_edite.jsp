<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OI平台-角色管理</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/statics/favicon.ico">
    <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/style.css?v=4.1.0" rel="stylesheet">
    <style>
        .pic-uploader-box{
            position:relative;
        }
        .pic-uploader{
            position:absolute;
            top:0;
            left:0;
            width:100%;
            height:100%;
            opacity:0;
        }
    </style>
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>管理成员 <small>请确认所有选项填写无误</small></h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <!--表单正文-->
                    <div class="ibox-content">
                        <form id="submit" action="<%=basePath %>/company/role/edit.html" class="form-horizontal" id="oi_ad_enter_edite">
                            <input type="hidden" name="user_id" value="${propa.user_id }">
                            <!--用户名称-->
                            <div class="form-group">
                                <label class="col-sm-offset-3 col-sm-2 control-label">用户名称</label>
                                <div class="col-sm-3">
                                <input id="titleValue" type="hidden" value="${propa.title }">
                                    <select id="title" name="title" class="form-control">
                                        <option value="0">角色类型</option>
                                        <option value="1">超级管理员</option>
                                        <option value="2">测试角色</option>
                                    </select>
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--用户名称-->
                            <div class="form-group">
                                <label class="col-sm-offset-3 col-sm-2 control-label">用户名称</label>
                                <div class="col-sm-3">
                                	<input id="rulesValue" type="hidden" value="${propa.rules }">
                                    <select id="rules" name="rules" class="form-control">
                                        <option value="0">是否启用</option>
                                        <option value="1">启用</option>
                                        <option value="2">禁用</option>
                                    </select>
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--提交表单部分-->
                            <div class="form-group row">
                                <input type="button" id="button" value="确认无误,提交" class="col-md-offset-5 col-md-2 btn btn-success">
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
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green'
            });
        });
        $(function(){
        	 var optsT=document.getElementById("title");
        	  var stageT=$("#titleValue").val();
        	 for(var i=0;i<optsT.options.length;i++){                      
                  if(stageT==optsT.options[i].value){                       		
                     optsT.options[i].selected="true";
                  }
              } 
              var optsS=document.getElementById("rules");
        	  var stageS=$("#rulesValue").val();
        	 for(var i=0;i<optsS.options.length;i++){                      
                  if(stageS==optsS.options[i].value){                       		
                     optsS.options[i].selected="true";
                  }
              }    
        });
        $(function(){
  	 var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
		$("#button").on('click', function(){
			$("#submit").submit();
			parent.layer.close(index); //执行关闭
		});
  });
    </script>
</body>
</html>
