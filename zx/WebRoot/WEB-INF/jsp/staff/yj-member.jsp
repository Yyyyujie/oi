<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-footer-header.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-member.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/iconfont.css">

  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/allReset.css"/>  
  	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/yj-footer-header.css" />
  <script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>

  <style>
    a {
      text-decoration: none;
    }
.li-msg{
	background: url(${pageContext.request.contextPath }/statics/images/footer/msg.png) no-repeat;
	background-size: contain;
    background-position: center;
}
.li-me{
	background: url(${pageContext.request.contextPath }/statics/images/footer/me_on.png) no-repeat;
	background-size: contain;
    background-position: center;
}

  </style>
</head>
<body>
<header>	
    <span class="header-title">我的</span>
</header>
<main>
    <!--头像-->
    <div class="person">
    <a href="${pageContext.request.contextPath }/Newstaff/updateheader.html">
        <div class="me-header">
             <c:if test="${companyStaffer.face !=null && companyStaffer.face!='' }">
		<img src="http://oi.sxfs0351.com/${companyStaffer.face}" alt="" style="width: 100%;height: 100%;">
	 </c:if>
	<c:if test="${companyStaffer.face==null || companyStaffer.face=='' }">
	   <img src="${companyStaffer.header}" alt="" style="width: 100%;height: 100%;">
	</c:if>
        </div>
     </a>
        <p class="me-name">${companyStaffer.realname}</p>
        <p class="me-zz">${companyStaffer.dept_name}[${companyStaffer.post_name}][${companyStaffer.level_name}]</p>
    </div>
    <div class="me-grade">
        <div class="grade-left">
            <div class="grade-num">${conCompanyStaffer.qualityavg}</div>
            <div class="grade-txt">
                <div class="mark">mark</div>
                <div class="mark1">工作质量</div>
            </div>
        </div>
        <div class="grade-mid"></div>
        <div class="grade-left">
            <div class="grade-num">${conCompanyStaffer.efficiencyavg}</div>
            <div class="grade-txt">
                <div class="mark">mark</div>
                <div class="mark1">工作效率</div>
            </div>
        </div>
    </div>
    <a href="${pageContext.request.contextPath }/staff/yj-mingp.html">
    <div class="fenlei">
        <div class="icon">
            <i class="iconfont icon-erweima"></i>
        </div>
        <span>我的名片</span>
    </div>
    </a>
    <a href="${pageContext.request.contextPath }/staff/yj-tongxun.html">
    <div class="fenlei">
        <div class="icon">
            <i class="iconfont icon-lianxiren"></i>
        </div>
        <span>通讯录</span>
    </div>
    </a>
    <a href="${pageContext.request.contextPath }/staff/yj-zhanghao.html">
    <div class="fenlei">
        <div class="icon">
            <i class="iconfont icon-shezhi"></i>
        </div>
        <span>账号与安全</span>
    </div>
    </a>
    <a href="${pageContext.request.contextPath }/staff/selectPromotion.html">
    <div class="fenlei">
        <div class="icon">
           <div class="jsicon"></div>
        </div>
        <span>员工晋级</span>
    </div>
    </a>
</main>


 <footer>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath }/Newstaff/yj-index.html" class="li-a li-msg">         
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/Newstaff/oi_staff_task_center.html" class="li-a li-task">
                </a>
            </li>
            <li >
                <a href="${pageContext.request.contextPath }/Newstaff/oi_staff_task_release.html" class="li-a li-release-on">

                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/staff/oi_staff_data_center.html" class="li-a li-data">
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/staff/yj-member.html" class="li-me">
                </a>
            </li>
        </ul>
    </footer>






</body>
  <script src="${pageContext.request.contextPath }/statics/js/jQuery.js"></script>

</html>