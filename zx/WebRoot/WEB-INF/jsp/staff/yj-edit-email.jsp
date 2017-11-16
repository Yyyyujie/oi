<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-edit-phone.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/iconfont.css">
    <link rel="stylesheet" href= "${pageContext.request.contextPath }/statics/css/header.css">
    <script src="${pageContext.request.contextPath }/statics/js/jQuery.js"></script>
    <script src="${pageContext.request.contextPath }/statics/js/jquery.validate.js"></script>
    <style>
        .error{
            font-size: 0.24rem;
            color: red;
        }
    </style>
</head>
<body>
    <div class="headerr">
        <div class="header-zhe">
            <i class="iconfont icon-fanhui back"></i>
            <span>更换邮箱</span>
        </div>
    </div>
    <form action="${pageContext.request.contextPath }/staff/sendStaffEmail.html" class="myform" method="post">
        <div class="con">
            <input type="text" class="phone" placeholder="请输入邮箱号" name="email" >
            	
            <input type="text" class="code" placeholder="请输入验证码" name="code">
         </div>
        <input type="submit" class="submit" value="完成">
    </form>
    <div class="send"><span>发送验证码</span></div>
    <span class="code-con"></span>
</body>
<script>
    $(".back").click(function () {
        history.back();
    });
  
    $(".myform").validate({
        rules:{
            email:{
                required: true,
                	email:true
            },
            code:{
                required: true,
                digits : true,
                rangelength:[6,6]
            }
        },
        messages:{
            email:{
                required: "请输入邮件地址",
                 email:"请输入正确的邮件地址"
            },
            code:{
                required: "请输入验证码",
                digits : "验证码应该输入数字",
                rangelength:"请输入正确的验证码"
            }
        },
      
    });
    jQuery.validator.setDefaults({
    debug: true,
   
    errorPlacement: function(error, element) {
        if ($(element).parent().hasClass('datetimepicker')) {
            error.insertAfter(element.parent());
        } else {
            error.insertAfter(element);
        }
    }
});
    var tel=$(".con .phone");
    var inp=$(".con input");
    var code=$(".con .code");
    var sub=$(".submit");
    
   tel.keydown(function(){

        if(!tel.hasClass("error")){
            if($(".phone").val()!=""){
                $(".send").css("color","#fff").css("background","#13a3ff");
                $(".send").text("发送验证码");
                $(".send").click(function () {
                    var number=$(".phone").val();
                    $.ajax({
                    	type:"post",
                        url:"${pageContext.request.contextPath }/staff/sendStaffEmail.do?email="+number,
                        contentType: "application/json; charset=utf-8",
                        data: {'email':number},
                        success:function () {
                            /* alert("发送成功"); */
                            $(".phone").attr("readOnly",true)
                            var second=60;
                            var timer=setInterval(function(){

                            	if(second!=0){
                            		$(".send").text(second+"s").css("background","#c1c1c1");
             						$(".phone").attr("readOnly",true);
             						$(".send").unbind("click")
                            	}else{
                            			clearInterval(timer);
                            			
                            			$(".send").text("发送验证码");
                            			 $(".phone").attr("readOnly",false);
                            			 $(".send").attr("readOnly",false)
                            	};
                            	second--;
                            },1000);
                        },
                        error:function () {
                            alert("发送失败，请重新发送");
                        }

                    });
                });
            }

        }else{
            $(".send").css("color","");
            $(".send").text("发送验证码");
        }
    });
    
    
    	
 /*if(tel.hasClass("error")){
    		
    	}else{
    		$(".send").text("发送验证码");
    	}*/
     inp.keydown(function(){
   	if((tel.val()!="")&&(code.val()!="")){
   		 if(!tel.hasClass("error")){
   		if(!code.hasClass("error")){
   			sub.css("background","#13a3ff").css("color","#fff");
   		
   		}
   }
   	}else{
   			sub.css("background","#d3d3d3");
   		}
   });
</script>
</html>
