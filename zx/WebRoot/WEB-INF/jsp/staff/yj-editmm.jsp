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
            <span>修改密码</span>
        </div>
    </div>
    <form action="" class="myform" method="post">
        <div class="con">
            <input type="tel" class="phone" placeholder="请输入手机号码" name="phone" >
            	
            <input type="text" class="code" placeholder="请输入验证码" name="code">
         </div>
        <input type="submit" class="submit" value="下一步">
    </form>
    <span class="send">发送验证码</span>
    <span class="code-con"></span>
</body>
<script>
    $(".back").click(function () {
        history.back()
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
    jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请正确填写您的手机号码");
    $(".myform").validate({
        rules:{
            phone:{
                required: true,
                 isMobile : true
            },
            code:{
                required: true,
                digits : true,
                rangelength:[4,4]
            }
        },
        messages:{
            phone:{
                required: "请输入手机号码",
                 isMobile : "请正确填写您的手机号码"
            },
            code:{
                required: "请输入验证码",
                digits : "验证码应该输入数字",
                rangelength:"请输入正确的验证码"
            }
        },
        /*errorPlacement: function(error, element) {
            // Append error within linked label
            $( element )
                .closest( ".myform" )
                .find( "label[for='" + element.attr( "id" ) + "']" )
                .append( error );
        },
        errorElement: ".code-con",*/
   
      /* errorPlacement : function(error, element) {
        error.appendTo(element.next().next());
    },
    errorElement:".code-con"*/
    })
    var tel=$(".con .phone");
    var code=$(".con .code");
    var inp=$(".con input");
    var sub=$(".submit")
//  console.log(tel);
     tel.blur(function(){
//  	alert(1)
    	if(!tel.hasClass("error")){
    		
    	$(".send").css("color","#13a3ff");
    	$(".send").text("发送验证码");
    }else{
    	$(".send").css("color","");
    	$(".send").text("");
    }
    });
         inp.blur(function(){
   	if((tel.val()!="")&&(code.val()!="")){
   		 if(!tel.hasClass("error")){
   		if(!code.hasClass("error")){
   			sub.css("background","-webkit-linear-gradient(left,#13a3ff,#13f0ff)");
   			sub.click(function(){
   				location.href="yj-setmm.html"
   			})
   		}
   }
   	}else{
   			sub.css("background","#d3d3d3");
   		}
   })
</script>
</html>
