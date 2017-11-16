<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <title>OI - 修改密码</title>
  <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/font-awesome.css?v=4.4.0" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/animate.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/style.css?v=4.1.0" rel="stylesheet">
  <!--[if lt IE 9]>
  <meta http-equiv="refresh" content="0;ie.html"/>
  <![endif]-->
  <script>
    if (window.top !== window.self) {
      window.top.location = window.location;
    }
  </script>
  <style>
    #form-change {
      color: #333;
    }

    .form-control {
      padding: 15px 12px;
    }
  </style>
</head>
<body class="gray-bg">
<div class="middle-box text-center loginscreen  animated fadeInDown">
  <div>
    <div>
      <h1 class="logo-name">OI</h1>
    </div>
    <h3>欢迎使用 OI</h3>
    <form id="form-change" method="post" action="${pageContext.request.contextPath }/company/admin/updateAdmin.html">
      <div class="form-group">
        <input name="phone" id="telInput" type="text" class="form-control" placeholder="请输入手机号码"/>
      </div>
      <div class="form-group">
        <input name="password" id="psInput" type="password" class="form-control" placeholder="请输入新密码"/>
      </div>
      <div class="form-group">
        <input name="password1" id="psInput2" type="password" class="form-control" placeholder="请确认新密码"/>
      </div>
      <div class="form-group clearfix">
        <input name="code" id="code" style="width:55%;float:left;" type="text" class="form-control" placeholder="验证码"/>
        <button id="btnSendVcode" style="outline:none;" type="button" class="btn btn-default col-sm-5 pull-right">
          发送验证码
        </button>
      </div>
      <button id="button" class="btn btn-primary btn-block">确定修改密码</button>
      <a class="btn btn-warning btn-block" href="${pageContext.request.contextPath }/login.jsp">返回登录</a>
    </form>
  </div>
</div>
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script>
  $(function () {
    $("#button").click(function () {
      var tel = $("#telInput").val();
      var psInput = $("#psInput").val();
      var psInput2 = $("#psInput2").val();
      var code=$("#code").val();
      if (tel == "" || tel == undefined || tel == null) {
        alert("请填写手机号码");
        return false;
      } else if (psInput == "" || psInput == undefined || psInput == null) {
        alert("请输入密码");
        return false;
      } else if (psInput != psInput2) {
        alert("两次密码不相同");
        return false;
      }else if (code == "" || code == undefined || code == null) {
        alert("请输入验证码");
        return false;
      }
    });
    $("#btnSendVcode").click(function () {
      var tel = $("#telInput").val();
      var psInput = $("#psInput").val();
      var psInput2 = $("#psInput2").val();
      if (tel == "" || tel == undefined || tel == null) {
        alert("请填写手机号码");
      } else {
        $.ajax({
          type: "post",
          url: "${pageContext.request.contextPath }/company/admin/sendSms.do",
          data: {telNumber: tel},
          success: function (msg) {
            alert(msg);
          },
          error: function () {
            alert("发送失败");
          }
        });
      }
    });
  });
</script>
</body>
</html>
