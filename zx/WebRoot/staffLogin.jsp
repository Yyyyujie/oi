<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
       <meta charset="utf-8"/>
    <meta http-equiv="x-ua-compatible" content="IE=Edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <title>个人信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/oi_sf_login.css"/>
    <script>
        document.addEventListener("touchmove",function(e){
            e.preventDefault();
        })
    </script>
  </head>
  
  <body>
      	<div class="sf_container">
        <!--用户头像:默认无-->
        <div class="sf-head-icon" style="background-image:url(${pageContext.request.contextPath }/statics/images/logo.png);"></div>
        <div id="sf-login-container">
            <form id="sf-login-form">
                <!--用户名-->
                <label for="sf-username">
                    <input type="text" name="sf_username" id="sf-username" placeholder="手机号/邮箱/会员名"/>
                </label>
                <!--密码-->
                <label for="sf-password">
                    <input type="password" name="sf_password" id="sf-password" placeholder="请输入密码"/>
                </label>
                <!--其他功能-->
                <div class="sf-other-option clearfix">
                    <a href="#" class="left">免费注册</a>
                    <a href="#" class="right">忘记密码</a>
                </div>
                <!--登陆按钮-->
                <button type="button" id="sf-login-btn">登陆</button>
            </form>
        </div>
        <div class="sf_footer_info">本系统最终解释权归<strong>知行</strong>所有©</div>
    </div>
    <script src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
    <script>
        $(function(){
            /*登陆验证*/
            $("#sf-login-btn").click(function(){
                if($("#sf-username").val()!==""&&$("#sf-password").val()!==""){
                    var formData=$("#sf-login-form").serialize();
                    $.ajax({
                        type:'post',
                        url:"staffLogin/login.json",
                        data:formData,
                        success:function(msg){
                            console.log(msg);
                            if(msg==true){
                                window.location.href="staff/oi_staff_msg.html";
                            }else{

                            }
                        },
                        error:function(err){
                            console.log(err);
                        }
                    })
                }else{
                    $.alert("请填写正确的用户名或密码");
                }
            })
        })
    </script>
</body>
  </body>
</html>
