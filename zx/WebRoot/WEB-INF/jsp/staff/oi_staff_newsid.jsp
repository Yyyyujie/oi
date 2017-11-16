<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-index-con.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/iconfont.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/header.css">
    <script src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
</head>
<body>
    <div class="headerr">
        <div class="header-zhe">
            <i class="iconfont icon-fanhui back"></i>
            <span>企业公告</span>
        </div>
    </div>
    <div class="title">
      <p>${companyNews.title }</p>
        <div class="time">
            <i class="iconfont icon-shijian">&nbsp<span id="create_time">${companyNews.create_time }</span></i>

        </div>
    </div>
    <div class="main-con">
        ${companyNews.content }
    </div>
</body>
<script>
    $(".back").click(function () {
          location.href="${pageContext.request.contextPath }/Newstaff/yj-index.html"
    });
    $(function(){
		var create_time=$("#create_time");
		var create_data=Todate(create_time.text());
		create_time.text(create_data);
		
		
	})
	function Todate(num)
	{
		//Fri Oct 31 18:00:00 UTC+0800 2008  
		num=num+"";
		var date="";
		var month=new Array();
		 month["Jan"]=1;month["Feb"]=2;month["Mar"]=3;month["Apr"]=4;month["May"]=5;month["Jan"]=6;
		month["Jul"]=7;month["Aug"]=8;month["Sep"]=9;month["Oct"]=10;month["Nov"]=11;month["Dec"]=12;
		var week=new Array();
		week["Mon"]="一";week["Tue"]="二";week["Wed"]="三";week["Thu"]="四";week["Fri"]="五";week["Sat"]="六";week["Sun"]="日";
		str=num.split(" ");
		date=str[5]+"-";
		date=date+month[str[1]]+"-"+str[2];
		//date=date+" 周"+week[str[0]];
		 return date;
}

var format = function(time, format)
{
	var t = new Date(time);
	var tf = function(i){return (i < 10 ? '0' : '') + i};
	return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
	switch(a){
	case 'yyyy':
	return tf(t.getFullYear());
	break;
	case 'MM':
	return tf(t.getMonth() + 1);
	break;
	case 'mm':
	return tf(t.getMinutes());
	break;
	case 'dd':
	return tf(t.getDate());
	break;
	case 'HH':
	return tf(t.getHours());
	break;
	case 'ss':
	return tf(t.getSeconds());
	break;
	}
	})
}
</script>
</html>