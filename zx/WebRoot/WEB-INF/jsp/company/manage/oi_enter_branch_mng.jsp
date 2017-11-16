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
  <title>OI平台-节点编辑</title>
  <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
  <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
  <link rel="shortcut icon" href="${pageContext.request.contextPath }/statics/favicon.ico">
  <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/font-awesome.css?v=4.4.0" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/plugins/iCheck/custom.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/animate.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/style.css?v=4.1.0" rel="stylesheet">
  <style>
    .text-warning{
      color:#DC3937;
    }
    .dd-handle button.btn{
      margin:0 5px;
      position:relative;
      z-index:1000;
    }
   .layui-layer-dialog .layui-layer-content{
    	color:#333;
    }
    .blue-bg{
    color:#333}
  </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title clearfix">
          <span class="btn btn-link">部门设置</span>
          <div class="ibox-tools" id="netable-itoolbar">
            <button data-action="add_branch" class="btn btn-link" type="button">添加</button>
            <button data-action="expand-all" class="btn btn-link" type="button">展开</button>
            <button data-action="collapse-all" class="btn btn-link" type="button">收起</button>
            <!-- <button data-action="serialize" class="btn btn-link" type="button">保存序列</button> -->
            <button data-action="renovate" class="btn btn-link" type="button">刷新</button>
          </div>
        </div>
        <!--表单正文-->
        <div class="ibox-content">
          <div class="dd" id="nestable2">
          </div>
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
<script src="${pageContext.request.contextPath }/statics/js/plugins/layer/layer.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/plugins/nestable/jquery.nestable.js"></script>
<script>
  $(document).ready(function() {
  	
  
    $.ajax({
      type:"post",
      url:"${pageContext.request.contextPath }/company/dept/selectDept.do",
      dataType:"json",
      success:function(nestableData){
        //模拟数据
        var nestableBody = $('#nestable2');
        var createNestable = function(nestableData) {
          if (nestableData.length > 0) {
            var tempHtml = $('<ol class="dd-list">');
            nestableData.forEach(function(value, index, array) {
              if (value.children) {
                var childrenHtml = $('<li class="dd-item" data-id="'+value.id+'"><div class="dd-handle"><span data-id="'+value.id+'" class="dd-nodrag label label-danger pull-right o_delete_btn"><i class="fa fa-remove"></i></span><span data-id="'+value.id+'" class="dd-nodrag label label-info pull-right o_edit_btn"><i class="fa fa-edit"></i></span><span class="label label-primary"><i class="fa fa-users"></i></span></span>' + value.text + '</div></li>');
                childrenHtml.append(createNestable(value.children));
                tempHtml.append(childrenHtml);
              } else {
                tempHtml.append(' <li class="dd-item" data-id="'+value.id+'"><div class="dd-handle"><span data-id="'+value.id+'" class="dd-nodrag label label-danger pull-right o_delete_btn"><i class="fa fa-remove"></i></span><span data-id="'+value.id+'" class="dd-nodrag label label-info pull-right o_edit_btn"><i class="fa fa-edit"></i></span><span class="label label-warning"><i class="fa fa-user"></i></span></span>'+ value.title + '</div> </li>');
              }
            });
            tempHtml.append('</ol>');
          }
          return tempHtml;
        };
        nestableBody.append(createNestable(nestableData)).nestable({
          group : 1
        });
        var updateOutput = function(e) {
          var list = e.length ? e : $(e.target), output = list.data('output');
          if (window.JSON) {
            output.val(window.JSON.stringify(list.nestable('serialize')));//, null, 2));
          } else {
            output.val('JSON browser support required for this demo.');
          }
        };
        // activate Nestable for list 1
        nestableBody.nestable({
          group : 1
        }).on('change', updateOutput);
        // output initial serialised data
        updateOutput(nestableBody.data('output', $('#nestable-output')));
        $('#netable-itoolbar').on('click','button', function() {
          var _self = $(this), action = _self.attr("data-action");
          if (action === 'expand-all') {  //展开全部
            $('.dd').nestable('expandAll');
          }
          if (action === 'collapse-all') {  //收起全部
            $('.dd').nestable('collapseAll');
          }
          if (action === 'add_branch') {    //添加部门
            layerContent("添加","${pageContext.request.contextPath }/company/dept/insertDept.html")
          }
         /*  if (action === 'serialize') { */     //保存序列
            /*保存序列化之后的json数据*/
            /* var data = JSON.stringify($('#nestable2').nestable('serialize')); */
            /*发送给服务器*/
            /* parent.layer.confirm("确定保存当前排序吗？",{
              btn:['确定','取消'],
              shade:false
            },function(){
              $.ajax({
                type:'post',
                url:'',
                data:data,
                success:function(msg){
//            判断保存状态status
                  layer.msg("确认成功");
                },
                error:function(){
                  alert("保存失败，请检查网络");
                }
              })
            })
          } */
          
          if (action === 'renovate') {  //刷新
            window.location.href = "";
          }
        });
        //监听每个列表的删除、修改按钮点击事件
        nestableBody.on("click",".o_delete_btn",function(){ //删除事件
          var _self=$(this),listData=_self.attr("data-id");
          layer.confirm("确定要删除当前部门吗?",{
            btn:['确定','取消'],
            shade:false
          },function(){
            $.post("${pageContext.request.contextPath }/company/dept/delete.do",{id:listData},function(msg){
              $("#layui-layer6").hide();
              layer.alert("删除成功");
            })
          })
        }).on("click",".o_edit_btn",function(){ //编辑列表
          var _self=$(this),listData=_self.attr("data-id");
          layerContent('编辑','${pageContext.request.contextPath }/company/dept/update.html?id='+listData);
        });
      },
      error:function(){
        layer.alert("获取数据失败，请检查网络！");
      }
    })
  });
  function layerContent(title,template){
    layer.open({
      type: 2,
      title: title,
      shadeClose: true,
      shade: false,
      //maxmin: true, //开启最大化最小化按钮
      area: ['900px', '500px'],
      content: template
    });
  }
</script>
</body>
</html>
