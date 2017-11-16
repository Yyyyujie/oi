<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8"/>
<meta http-equiv="x-ua-compatible" content="IE=Edge,chrome=1"/>
  <meta name="apple-mobile-web-app-capable" content="yes"/>
  <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
  <title>OI - 登录</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/allReset.css"/> 
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/pc_register.css"/>
  <script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>
  <script>
  	document.addEventListener("touchmove", function(e) {
  		e.preventDefault();
  	})
  </script>
</head>
<body>
	<!--账号密码注册-->
	<div class="sf_reg_container">
		<!--公司logo-->
		<div class="sf_logo_1">
		</div>
		<form class="oi_form_reg_box" id="oi_form_reg_con_3" onsubmit="return false">
			<!--输入表单组合-->
			<div class="oi_form_reg">
				<!--手机号-->
				<div class="form_input oi_tel clearfix">
					 <input type="text" name="sf_username" class="forminput" id="sf-username" required="required" placeholder="手机号" />
				</div>
				<!--验证码-->
				<div class="form_input clearfix">
					<input type="password" name="sf_password" class="forminput" id="sf-password" required="required" placeholder="请输入密码"/>
				</div>
				<div class="tipsBox_absolute clearfix">
					<span style="color: red" id="message"></span>
				</div>
			</div>
			<button type="submit" class="sf_submit_button">登录</button>
		</form>
	</div>
	<!--账号密码注册 结束-->
	<script src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
    <script>
       	
        $(function(){
        	$(".forminput").keydown(function(){
	$("#message").html("");
	});
            /*登陆验证*/
                     $("#oi_form_reg_con_3").submit(function(){
                      var formData=$("#oi_form_reg_con_3").serialize();
                    $.ajax({
                        type:'post',
                        url:"staffLogin/login.json",
                        data:formData,
                        success:function(msg){
                            console.log(msg);
                            if(msg.code==100){
                                window.location.href="Newstaff/oi_staff_welPage.html";
                            }else{
								 $("#message").html("帐号或密码错误");
                            }
                        }
                    })
            })
            })
    </script>
</body>
</html>