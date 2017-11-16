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
  <title>OI - 企业版 注册模块</title>
  <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
  <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
  <link rel="shortcut icon" href="${pageContext.request.contextPath }/statics/favicon.ico">
  <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/font-awesome.css?v=4.4.0" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/animate.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<style>
  .form-group {
    margin-bottom: 5px;
  }
</style>
<body class="gray-bg">
<div>
  <div style="text-align: center;">

    <h1 class="logo-name" style="text-align: center;"></h1>

  </div>
</div>
<div class="middle-box text-center loginscreen  animated fadeInDown" style="padding-top: 0px;">
  <div>
    <div style="position: relative;width: 300px;height: 100px;">
      <div class="col-xs-9" style="position: absolute;width: 200px;left:100px;height: 20px;bottom: 0;">
        <h3 style="color: #999;">无为而治·智慧管理</h3>
      </div>
    </div>
    <form class="m-t" action="" id="form">
      <div class="form-group">
        <input name="license_id" id="companyname" type="text" class="form-control" placeholder="统一社会信用代码"
               required="请输入企业名称">

        <div class="col-xs-3 col-ms-3"></div>
      </div>
      <div class="form-group">
        <input name="phone" id="mobile" type="text" class="form-control" placeholder="请输入手机号,后台登陆用户名。"
               required="">

        <div class="col-xs-3 col-ms-3"></div>
      </div>
      <div class="form-group">
        <input name="password" id="password" type="password" class="form-control" placeholder="密码"
               required="请输入密码">

        <div class="col-xs-3 col-ms-3"></div>
      </div>
      <div class="form-group">
        <input name="data[repassword]" type="password" class="form-control" placeholder="确认密码" required="请输入密码">

        <div class="col-xs-3 col-ms-3"></div>
      </div>
      <div class="form-group clearfix">
        <input name="data[verify]" class="form-control pull-left" type="text" placeholder="验证码" required="请输入验证码"
               style="width:145px;" datatype="*" nullmsg="请填写验证码">
        <canvas id="yanzhengma" width="120" height="40"></canvas>
        <div class="col-xs-3 col-ms-3"></div>
      </div>
      <button type="submit" class="btn btn-primary block full-width m-b">我要注册</button>
      <p class="text-muted text-center"><a href="${pageContext.request.contextPath }/login.jsp">已经有账号</a></p>
    </form>
  </div>
</div>

<!-- 全局js -->
<!-- 全局js -->
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath }/statics/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath }/statics/js/content.js?v=1.0.0"></script>

<!-- jQuery Validation plugin javascript-->
<script src="${pageContext.request.contextPath }/statics/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/plugins/validate/messages_zh.min.js"></script>

<script src="${pageContext.request.contextPath }/statics/js/plugins/layer/layer.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/validate.js"></script>
<script>

  //以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
  $.validator.setDefaults({
    highlight: function (element) {
      $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function (element) {
      element.closest('.form-group').removeClass('has-error').addClass('has-success');
    },
    errorElement: "span",
    errorPlacement: function (error, element) {
      if (element.is(":radio") || element.is(":checkbox")) {
        error.appendTo(element.parent().parent().parent());
      } else {
        error.appendTo(element.parent());
      }
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none"


  });

  $.validator.setDefaults({
    submitHandler: function (form) {
      //alert("提交事件!");
      var data = $("#form").serializeArray();

      var index = parent.layer.getFrameIndex(window.name);
      layer.msg('提交中', {time: 1000, shift: 1}, function () {
        $.post("${pageContext.request.contextPath }/company/admin/register.do", data, function (row) {
          if (row == '1') {
            parent.layer.msg("注册成功（3秒后到登陆界面）", {shift: 1});
            setTimeout(function(){ //三秒的计时器
            	window.location.href = "${pageContext.request.contextPath }/login.jsp";
            },3000);
          } else {
            parent.layer.msg("注册失败", {shift: 1, time: 2000});
            $("#captcha").click();
          }
        });

      });
    }
  });
  $().ready(function () {
    function randomNum(min, max) {
      return Math.floor(Math.random() * (max - min) + min);
    }

    /**生成一个随机色**/
    function randomColor(min, max) {
      var r = randomNum(min, max);
      var g = randomNum(min, max);
      var b = randomNum(min, max);
      return "rgb(" + r + "," + g + "," + b + ")";
    }

    drawPic();
    document.getElementById("yanzhengma").onclick = function (e) {
      e.preventDefault();
      drawPic();
    }
    /**绘制验证码图片**/
    function drawPic() {
      var canvas = document.getElementById("yanzhengma");
      var width = canvas.width;
      var height = canvas.height;
      var ctx = canvas.getContext('2d');
      ctx.textBaseline = 'bottom';
      /**绘制背景色**/
      ctx.fillStyle = randomColor(180, 240); //颜色若太深可能导致看不清
      ctx.fillRect(0, 0, width, height);
      /**绘制文字**/
      var str = 'ABCEFGHJKLMNPQRSTWXY123456789';
      var vcode = [];
      for (var i = 0; i < 4; i++) {
        var txt = str[randomNum(0, str.length)];
        ctx.fillStyle = randomColor(50, 160);  //随机生成字体颜色
        ctx.font = randomNum(20, 40) + 'px SimHei'; //随机生成字体大小
        var x = 10 + i * 25;
        var y = randomNum(25, 45);
        var deg = randomNum(-45, 45);
        //修改坐标原点和旋转角度
        ctx.translate(x, y);
        ctx.rotate(deg * Math.PI / 180);
        ctx.fillText(txt, 0, 0);
        //恢复坐标原点和旋转角度
        ctx.rotate(-deg * Math.PI / 180);
        ctx.translate(-x, -y);
        vcode.push(txt);
      }
      $("#vCode").val(vcode);
      /**绘制干扰线**/
      for (var i = 0; i < 8; i++) {
        ctx.strokeStyle = randomColor(40, 180);
        ctx.beginPath();
        ctx.moveTo(randomNum(0, width), randomNum(0, height));
        ctx.lineTo(randomNum(0, width), randomNum(0, height));
        ctx.stroke();
      }
    }


    jQuery.validator.addMethod("phone", function (value, element) {
      return this.optional(element) || /^(13|15|18|14|17)[0-9]{9}?$/.test(value);
    }, "请输入正确的手机号码.");
    jQuery.validator.addMethod("UnifiedSocialCreditCode", function (value, element) {
      return this.optional(element) || /^[1-9A-GY]{1}[1239]{1}[1-5]{1}[0-9]{5}[0-9A-Z]{11}$/.test(value);
    }, "请输入正确的统一社会信用代码.");

    // validate signup form on keyup and submit
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#form").validate({
      onkeyup: false,
      rules: {
        "data[license_id]": {
          required: true,
          minlength: 2,
          UnifiedSocialCreditCode: false
        },
        "data[mobile]": {
          required: true,
          minlength: 2,
          phone: true
        },
        "data[password]": {
          required: true,
          minlength: 5
        },
        "data[repassword]": {
          required: true,
          minlength: 5,
          equalTo: "#password"
        },
      },
      messages: {
        "data[license_id]": {
          required: icon + "请输入统一社会信用代码",
        },
        "data[mobile]": {
          required: icon + "请输入您的手机号",
          phone: icon + "请输入正确的手机号"
        },
        "data[password]": {
          required: icon + "请输入您的密码",
          minlength: icon + "密码必须5个字符以上"
        },
        "data[repassword]": {
          required: icon + "请再次输入密码",
          minlength: icon + "密码必须5个字符以上",
          equalTo: icon + "两次输入的密码不一致"
        },

      },
    });

  });
</script>
</body>
</html>