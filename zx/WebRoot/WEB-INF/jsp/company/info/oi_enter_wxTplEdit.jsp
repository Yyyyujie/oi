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
  <title>OI平台-微信模板管理</title>
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
    <div class="col-sm-9">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>微信模板管理 <small>请确认所有选项填写无误</small></h5>
          <div class="ibox-tools">
            <a class="collapse-link">
              <i class="fa fa-chevron-up"></i>
            </a>
          </div>
        </div>
        <!--表单正文-->
        <div class="ibox-content">
          <form id="submit" action="<%=basePath %>/company/weChatTpl/editWeChat.html" accept-charset="UTF-8" class="form-horizontal" id="oi_ad_enter_edite">
            <!--水平线-->
            <div class="hr-line-dashed"></div>
            <!--水平线 - 结束-->
            <!--firstData-->
            <div class="form-group">
              <label class="col-sm-2 control-label">类型</label>
              <div class="col-sm-8">
                <input type="text" name="type" value="${WechatTmpl.type }" class="form-control" placeholder="模板类型">
              </div>
            </div>
            <!--水平线-->
            <div class="hr-line-dashed"></div>
            <!--水平线 - 结束-->
            <!--firstData-->
            <div class="form-group">
              <label class="col-sm-2 control-label">title</label>
              <div class="col-sm-8">
                <input type="text" name="title" value="${WechatTmpl.title }" class="form-control" placeholder="模板标题">
              </div>
            </div>
            <!--水平线-->
            <div class="hr-line-dashed"></div>
            <!--水平线 - 结束-->
            <!--firstData-->
            <div class="form-group">
              <label class="col-sm-2 control-label">serial</label>
              <div class="col-sm-8">
                <input type="text" name="serial" value="${WechatTmpl.serial }" class="form-control" placeholder="模板编号">
              </div>
            </div>
             <!--水平线-->
            <div class="hr-line-dashed"></div>
            <!--水平线 - 结束-->
            <!--ID-->
           <input type="hidden" name="tmpl_id" value="${WechatTmpl.tmpl_id }">
            <div class="form-group">
              <label class="col-sm-2 control-label">模板ID</label>
              <div class="col-sm-8">
                <input type="text" name="template_id" value="${WechatTmpl.template_id }" class="form-control" placeholder="模板ID">
              </div>
            </div>
            <!--水平线-->
            <div class="hr-line-dashed"></div>
            <!--水平线 - 结束-->
            <!--firstData-->
            <div class="form-group">
              <label class="col-sm-2 control-label">firstData</label>
              <div class="col-sm-8">
                <input type="text" name="firstdata" value="${WechatTmpl.firstdata }" class="form-control" placeholder="firstData">
              </div>
            </div>
            <!--水平线-->
            <div class="hr-line-dashed"></div>
            <!--水平线 - 结束-->
            <!--keyword1-->
            <div class="form-group">
              <label class="col-sm-2 control-label">keyword1</label>
              <div class="col-sm-8">
                <input type="text" name="keyword1" value="${WechatTmpl.keyword1 }" class="form-control" placeholder="keyword1">
              </div>
            </div>
            <!--水平线-->
            <div class="hr-line-dashed"></div>
            <!--水平线 - 结束-->
            <!--keyword2-->
            <div class="form-group">
              <label class="col-sm-2 control-label">keyword2</label>
              <div class="col-sm-8">
                <input type="text" name="keyword2" value="${WechatTmpl.keyword2 }" class="form-control" placeholder="keyword2">
              </div>
            </div>
            <!--水平线-->
            <div class="hr-line-dashed"></div>
            <!--水平线 - 结束-->
            <!--keyword3-->
            <div class="form-group">
              <label class="col-sm-2 control-label">keyword3</label>
              <div class="col-sm-8">
                <input type="text" name="keyword3" value="${WechatTmpl.keyword3 }" class="form-control" placeholder="keyword3">
              </div>
            </div>
            <!--水平线-->
            <div class="hr-line-dashed"></div>
            <!--水平线 - 结束-->
            <!--keyword4-->
            <div class="form-group">
              <label class="col-sm-2 control-label">keyword4</label>
              <div class="col-sm-8">
                <input type="text" name="keyword4" value="${WechatTmpl.keyword4 }" class="form-control" placeholder="keyword4">
              </div>
            </div>
            <!--水平线-->
            <div class="hr-line-dashed"></div>
            <!--水平线 - 结束-->
            <!--keyword5-->
            <div class="form-group">
              <label class="col-sm-2 control-label">keyword5</label>
              <div class="col-sm-8">
                <input type="text" name="keyword5" value="${WechatTmpl.keyword5 }" class="form-control" placeholder="keyword5">
              </div>
            </div>
            <!--水平线-->
            <div class="hr-line-dashed"></div>
            <!--水平线 - 结束-->

            <!--企业所在城市-->
            <!--remark-->
            <div class="form-group">
              <label class="col-sm-2 control-label">remark</label>
              <div class="col-sm-8">
                <input type="text" name="remark" value="${WechatTmpl.remark }" class="form-control" placeholder="remark">
              </div>
            </div>
            <!--水平线-->
            <div class="hr-line-dashed"></div>
            <!--水平线 - 结束-->
            <!--排序：-->
            <div class="form-group">
              <label class="col-sm-2 control-label">排序：</label>
              <div class="col-sm-8">
                <input type="text" name="o" value="${WechatTmpl.o }"  class="form-control" placeholder="排序">
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
    <!--变量说明-->
    <div class="col-sm-3">
      可调用的变量 说明
      <ul>
        <li>{task_id}：任务编号</li>
        <li>{task_title}：任务标题</li>
        <li>{task_start_time}：任务开始时间例子：2017-04-0511:50:33</li>
        <li>{task_end_time}：任务要求结束时间例子：2017-04-0611:50:00</li>
        <li>{task_complete_time}：任务实际完成时间例子：1970-01-0108:00:00</li>
        <li>{task_progress}：任务进度例子：0%</li>
        <li>{task_cd}：是否紧急例子：紧急一般</li>
        <li>{task_important}：是否紧急紧急一般例子：重要任务是否重要重要一般</li>
        <li>{task_content}：任务内容截取10个字符</li>
        <li>{task_status}：任务状态待接收进行中待评价已完成已退回已取消</li>
        <li>{task_del_reasion}：任务取消原因</li>
        <li>{task_reback_reasion}：任务退回原因</li>
        <li>{send_user_name}：任务发布人姓名</li>
        <li>{send_user_depart}：任务发布人职务</li>
        <li>{receive_user_name}：任务接收人姓名</li>
        <li>{receive_user_depart}：任务接收人职务 </li>
      </ul>

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
  	 var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
		$("#button").on('click', function(){
			$("#submit").submit();
			parent.layer.close(index); //执行关闭
		});
  });
 
</script>
</body>
</html>
