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
    <title>HTTP-500</title>
    <style>
        body,html{
            width:100%;
            height:100%;
            margin:0;
            padding:0;
        }
        *{
            box-sizing: border-box;
        }
        .main{
            width:50%;
            height:50%;
            background: url("${pageContext.request.contextPath }/statics/images/error.png") no-repeat;
            background-size: 100%;
            background-position: center;
            position: absolute;
            left:0;
            right:0;
            top:0;
            bottom:0;
            margin:auto;
        }
        .again{
            width:200px;
            height:80px;
            position: absolute;
            right: 233px;
            bottom: 160px;
        }
        .again p{
            font-size: 18px;
        }


    </style>
</head>
<body>
    <div class="main">
      <div class="again">
           
      </div>
    </div>
</body>
</html>