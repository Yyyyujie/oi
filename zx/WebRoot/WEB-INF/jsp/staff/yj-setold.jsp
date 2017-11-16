<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>OI - ${companyStaffer.company_name}</title>
<script src="${pageContext.request.contextPath }/statics/js/rem.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/iconfont.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/yj-editold.css">
<script src="${pageContext.request.contextPath }/statics/js/jQuery.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/js/jquery.validate.js"></script>
<!--<script src="js/pass.js"></script>-->
</head>
<body>
	<div class="headerr">
		<div class="header-zhe">
			<i class="iconfont icon-fanhui back"></i> <span>设置密码</span>
		</div>
	</div>
	<form action="${pageContext.request.contextPath }/staff/updatePassword.html" class="myform" method="post">
		<div class="phone">
			<input type="password" placeholder="请输入旧密码" name="old" class="old" >
			<input type="password" placeholder="6-18位英文、数字组合" name="pass"
				class="pass"> <input type="password" placeholder="请再次输入密码"
				name="pass1" class="pass1">
		</div>
		<!--   <p class="forget"><a href="${pageContext.request.contextPath }/staff/yj-editmm.html">忘记密码</a></p> -->
		 <span class="span"></span> <input type="button" value="完成" class="sub" > 
	</form>
</body>
<script>
    $(".back").click(function () {
     location.href="${pageContext.request.contextPath }/staff/yj-zhanghao.html";
    })
var flag=false;//定义全局变量
//验证密码是否正确
$('.old').bind('input propertychange', function() {  
var oldPass=$(".old").val();
  $.ajax({
		url:"${pageContext.request.contextPath }/staff/checkPassword.do",
		type:"post",
		dataType:"json",
		data:{"password":oldPass},
		success:function(data){
			if(data){
				flag=true;
				$(".old").removeClass("error");
			}else{
				$(".old").addClass("error");	
			}
		},
		error:function(){
		}
	})
}); 
//失去焦点事件
$('.old').blur(function() {  
flag=false;
var oldPass=$(".old").val();
  $.ajax({
		url:"${pageContext.request.contextPath }/staff/checkPassword.do",
		type:"post",
		dataType:"json",
		data:{"password":oldPass},
		success:function(data){
			if(data){
				flag=true;
				$(".old").removeClass("error");
			}else{
				$(".old").addClass("error");	
			}
		},
		error:function(){
		}
	})
}); 
	//按键按下事件
  $("input").keydown(function(){
  	if(
  		($(".old").val()!="" && !$(".old").hasClass("error"))
  		&& ($(".pass").val()!="" && !$(".pass").hasClass("error"))
  		&& ($(".pass1").val()!="" && !$(".pass1").hasClass("error"))
  		&& ($(".pass").val()==$(".pass1").val())
  	){	
  		
		$(".sub").css("background","#13a3ff");
		flag=true;		
	}else{
		flag=false;
	}
  })
  //按键松开事件
  $("input").keyup(function(){
  	if(
  		($(".old").val()!="" && !$(".old").hasClass("error"))
  		&& ($(".pass").val()!="" && !$(".pass").hasClass("error"))
  		&& ($(".pass1").val()!="" && !$(".pass1").hasClass("error"))
  		&& ($(".pass").val()==$(".pass1").val())
  	){		
		$(".sub").css("background","#13a3ff");
		flag=true;		
	}else{
		flag=false;
	}
  })
  //验证密码格式，两次新密码是否相同
	jQuery.validator.addMethod("isPwd", function(value, element) {
		return this.optional(element) || /^(?=.{6,18})(?=.*[a-z])(?=.*[0-9])[0-9a-z]*$/.test(value);
	});
	$(".myform").validate({
		rules : {
			old:{
			required : true,
			},
			pass : {
				required : true,
				isPwd : true
			},
			pass1 : {
				required : true,
				equalTo : ".pass"
			}
		},
		messages : {
		old:{
			required : "请输入旧密码",
		},
			pass : {
				required : "请输入密码",
				/*rangelength:"密码长度为6-18位",
				digits:"密码由字母和数字组合",
						minlength:"密码由字母和数字组合"*/
				isPwd : "请输入正确的密码"
			},
			pass1 : {
				required : "请再次输入密码",
				equalTo : "请确认密码"
			//              required: "请输入验证码",
			//              equalTo："请再次输入密码"
			}
		},

	});
	//设置错误提醒的位置
	jQuery.validator.setDefaults({
		debug : true,

		errorPlacement : function(error, element) {
			if ($(element).parent().hasClass('datetimepicker')) {
				error.insertAfter(element.parent());
			} else {
				error.insertAfter(element);
			}
		}
	});
	//from表单提交事件
$(".sub").on('click', function(){
		if(flag==true){
			$(".myform").submit();	
		}
	});

</script>
</html>