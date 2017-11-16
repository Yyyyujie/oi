<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OI平台-企业版-企业基础设置</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/statics/favicon.ico"> 
    <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>企业微信设置 <small>请确认所有选项填写无误</small></h5>
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
                        <form method="post" action="${pageContext.request.contextPath }/company/weChatSet/updateWechat.html" class="form-horizontal">
                        	<input type="hidden" value="${wechatSetting.set_id }" name="set_id">
                            <!--请填写URL-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">URL</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${sortName }" name="sortname" class="form-control" readonly placeholder="请填写URL">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--请填写AppID-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">AppID</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${wechatSetting.appid }" name="appid" class="form-control" placeholder="请填写AppID">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--请填写AppSecret-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">AppSecret</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${wechatSetting.appsecret }" name="appsecret" class="form-control" placeholder="请填写AppSecret">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--请填写TOKEN-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">TOKEN</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${wechatSetting.token }" name="token" class="form-control" placeholder="请填写TOKEN"/>
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
    </script>
</body>
</html>
