<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OI平台-新闻类型管理</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/statics/favicon.ico"> 
    <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/style.css?v=4.1.0" rel="stylesheet">
      <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/bootstrap-datetimepicker.min.css"/>
   
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/css/plugins/webuploader/webuploader.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/css/demo/webuploader-demo.css">
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
        #uploader .placeholder{
        	min-height: 218px;
   			 padding-top: 74px;
        }
       .page-container #uploader .queueList{
        	max-width: 400px;
        	margin-left:350px;
        }
        .img{
        	width:200px;
        	height:150px;
        	border:1px solid #ccc;
        	position:absolute;
        	left:100px;
        	top:0;
        }
        #uploader{
        position:relative;}
        #uploader .img img{width:100%;height:100%}
    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>企业宣传 <small>请确认所有选项填写无误</small></h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <!--表单正文-->
                <div class="ibox-content">
                    <form id="submit" action="<%=basePath %>/Admin/editOiNewsType.html" accept-charset="UTF-8" class="form-horizontal" id="oi_en_pub_edit">
                        <input type="hidden" name="news_type_id" value="${newsType.news_type_id }">
                        <!--请填写标题-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">类型名称</label>
                            <div class="col-sm-8">
                                <input type="text" name="news_type" value="${newsType.news_type }" class="form-control" placeholder="请填写类型名称">
                            </div>
                        </div>
                        <!--水平线-->
                        <div class="hr-line-dashed"></div>
                        <!--水平线 - 结束-->
                        <!--请填写标题-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">类型名称备注</label>
                            <div class="col-sm-8">
                                <input type="text" name="news_type_remarks" value="${newsType.news_type_remarks }" class="form-control" placeholder="请填写类型名称备注">
                            </div>
                        </div>
                        <!--水平线-->
                        <div class="hr-line-dashed"></div>
                        <!--水平线 - 结束-->
                        <!--图片上传-->
                        <input type="hidden" id="file" name="news_logo">
                        <div class="page-container">
                            <div><input type="hidden" id="url" value="${pageContext.request.contextPath }/file/upload.do"> </div>
                            <div id="uploader" class="wu-example">
                            	<div class="img">
                            		<img src="http://www.sxfs0351.com/${newsType.news_logo }" alt="图片预览">
                            	</div>
                                <div class="queueList">
                                
                                    <div id="dndArea"  class="placeholder">
                                        <div id="filePicker"><img src="${newsType.news_logo }"></img></div>
                                        <p>或将照片拖到这里，单次最多可选300张</p>
                                    </div>
                                </div>
                                <div class="statusBar" style="display:none;">
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
<!-- 兼容性问题 -->
<script src="${pageContext.request.contextPath }/statics/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/bootstrap-datetimepicker.zh-CN.js"></script>

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
    /*入职时间修改 结束*/
  	 var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
		$("#button").on('click', function(){
			$("#submit").submit();
			parent.layer.close(index); //执行关闭
		});
</script>
</body>
</html>
