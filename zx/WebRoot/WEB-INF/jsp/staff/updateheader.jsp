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
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">
    <meta name="msapplication-tap-highlight" content="no"/>
<script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/iconfont.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/header.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/oi_alert.css"/>
    <link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/iconfont.css">
  <title>OI - ${companyStaffer.company_name}</title>
</head>
<body>
<!--加载资源-->
<div class="lazy_tip" id="lazy_tip"><span>1%</span><br>	载入中......</div>
<div class="lazy_cover"></div>
<div class="resource_lazy hide"></div>
<div class="pic_edit">
    <div class="header" style="height: 1.4rem;
    line-height: 1.4rem;
    background: #13a3ff;">
    <i class="iconfont icon-fanhui back"></i>
    <h2 style="color:#fff; margin:0;">选择图片上传头像</h2></div>
    <div id="clipArea"></div>
    <div class="wx-header">
    	<div class="imgBox">
    		<c:if test="${companyStaffer.face !=null && companyStaffer.face!='' }">
				<img src="http://oi.sxfs0351.com/${companyStaffer.face}" alt="" style="width: 100%;height: 100%;">
			 </c:if>
			<c:if test="${companyStaffer.face==null || companyStaffer.face=='' }">
			   <img src="${companyStaffer.header}" alt="" style="width: 100%;height: 100%;">
			</c:if>
    	</div>
    </div>
    <button id="upload2">选择图片</button>
    <button id="clipBtn">上传图片</button>
    <input type="file" id="file" style="opacity: 0;position: fixed;bottom: -100px">
    <div id="plan" style="display:none">
    <div class="headerr" style="height:1.173333rem">
    		头像预览
    		<i class="iconfont icon-fanhui back"></i>
    </div>
    <p>头像预览</p><canvas id="myCanvas"></canvas>
    <div onClick="Close();" style="cursor:pointer" class="close">关闭</div>
    </div>
</div>
<img src="" fileName="" id="hit" style="display:none;z-index: 9">

<div id="cover"></div>
<!--遮罩层 确认遮罩层-->
	<div class="_shade_box _alert_box" style="display: none;"></div>
	<!--遮罩层-->
<script src="${pageContext.request.contextPath }/statics/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/oi_alert.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/sonic.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/comm.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/hammer.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/iscroll-zoom.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/jquery.photoClip.js"></script>
<script>
    var hammer = '';
    var currentIndex = 0;
    var body_width = $('body').width();
    var body_height = $('body').height();
$(".back").click(function() {
		history.back()
	});
    $("#clipArea").photoClip({
        width: body_width * 0.8125,
        height: body_width * 0.8125,
        file: "#file",
        view: "#hit",
        ok: "#clipBtn",
        loadStart: function () {
            //console.log("照片读取中");
            $('.lazy_tip span').text('');
            $('.lazy_cover,.lazy_tip').show();
        },
        loadComplete: function () {
            //console.log("照片读取完成");
            $('.lazy_cover,.lazy_tip').hide();
        },
        clipFinish: function (dataURL) {
            $('#hit').attr('src', dataURL);
            saveImageInfo();
        }
    });
   

    //图片上传
    function saveImageInfo() {
        var filename = $('#hit').attr('fileName');
        var img_data = $('#hit').attr('src');
        if(img_data==""){
        kAlert({
				        title: "请选择图片",
				        subtitle: "点击确定关闭",
				        btns: ["确定"]
				      },function(){
				    	 
				      })
        }
       /*  alert(filename+'|'+img_data); */
        /* console.log(img_data); */
        render(img_data);

        $.post("${pageContext.request.contextPath }/Newstaff/updateheader", {image: img_data}, function (data) {
            if (data.code= 100) {
			//console.info(data);
            //data 为返回文件名；
    
            }
        });
    }

    /*获取文件拓展名*/
    function getFileExt(str) {
        var d = /\.[^\.]+$/.exec(str);
        return d;
    }

    //图片上传结束
    $(function () {
        $('#upload2').on('touchstart', function () {
            //图片上传按钮
            $('#file').click();
        });
        $('#upload2').on('click', function () {
       
            //图片上传按钮
            $('#file').click();
            setInterval(function(){
            if($("#hit").attr("filename")!=""){
            $(".wx-header").hide();
            }
            },10);
            
        });
    })


    function Close(){
  location.href="${pageContext.request.contextPath }/staff/yj-member.html";
    }
    // 渲染 Image 缩放尺寸
    function render(src){
        var MAX_HEIGHT = 256;  //Image 缩放尺寸
        // 创建一个 Image 对象
        var image = new Image();

        // 绑定 load 事件处理器，加载完成后执行
        image.onload = function(){
            // 获取 canvas DOM 对象
            var canvas = document.getElementById("myCanvas");
            // 如果高度超标
            if(image.height > MAX_HEIGHT) {
                // 宽度等比例缩放 *=
                image.width *= MAX_HEIGHT / image.height;
                image.height = MAX_HEIGHT;
            }
            // 获取 canvas的 2d 环境对象,
            // 可以理解Context是管理员，canvas是房子
            var ctx = canvas.getContext("2d");
            // canvas清屏
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            canvas.width = image.width;        // 重置canvas宽高
            canvas.height = image.height;
            // 将图像绘制到canvas上
            ctx.drawImage(image, 0, 0, image.width, image.height);
            // !!! 注意，image 没有加入到 dom之中

            var dataurl = canvas.toDataURL("image/jpeg");
            var imagedata =  encodeURIComponent(dataurl);
            $('#plan').attr('data-src',dataurl);
            $('#plan').show();
        };
        // 设置src属性，浏览器会自动加载。
        // 记住必须先绑定render()事件，才能设置src属性，否则会出同步问题。
        image.src = src;
    };
</script>

</body>
</html>