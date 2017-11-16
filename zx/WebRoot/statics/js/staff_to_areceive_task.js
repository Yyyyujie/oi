
$(function () {
	selectAllTaskByToUserId();
	//滑动加载
	  var flag=false; //滚动开关
	  var html='';
	  window.onscroll=function(){
	    var t=document.documentElement.scrollTop || document.body.scrollTop;
	    var cHeight=document.documentElement.clientHeight || document.body.clientHeight;
	    var dHeight=document.documentElement.scrollHeight || document.body.scrollHeight;
	    var n=Math.floor(dHeight-cHeight-t);
	    console.log(n);
	    if(n<=50){ //满足滑动加载条件，开始ajax请求数据
	      if(flag) return;
	      flag=true;
	      $.ajax({
	  		type : "post", //请求类型
	  		url : "staff/selectAllTaskByToUserId.json", //请求的url
	  		dataType : "json", //ajax接口（请求url）返回的数据类型
	  		success : function(data) { //data：返回数据（json对象）
	  			$("#weui-panel__bd2").html("");
	  			var table = "";
	  			for (var i = 0; i < data.length; i++) {
	  				table += "<a href='staff/oi_staff_tsk_detailToUser.html?task_id="+data[i].task_id+"&task_status="+data[i].task_status+"'><div task-status='" + data[i].task_status + "' class='weui-media-box weui-media-box_appmsg'><div class='weui-media-box__hd'><img class='weui-media-box__thumb' src=''></div><div class='weui-media-box__bd'><h4 class='weui-media-box__title'>发布人："
	  					+ data[i].realname
	  					+ "</h4><p class='weui-media-box__desc'>"
	  					+ "<h6>时间：" + data[i].task_start_time + "到 " + data[i].task_end_time + "</h6>"
	  					+ "<h6 class='task_content_ellipse'>"+data[i].task_title+"</h6></p>";
	  					
	  				if(data[i].task_status==5){
	  					table+="<ul class='weui-media-box__info'><li class='weui-media-box__info__meta'><a href='javascript:;' name='"+data[i].task_status+"' task_id='"+data[i].task_id+"'>退回</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='staff/oi_staff_edit.html?task_id="+data[i].task_id+"&task_status="+data[i].task_status+"'>接受</a></li></ul>";
	  				}else if(data[i].task_status==4){
	  					table+="<ul class='weui-media-box__info'><li class='weui-media-box__info__meta'><a href='javascript:;' name='"+data[i].task_status+"' task_id='"+data[i].task_id+"'>退回</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='staff/oi_staff_tsk_detailToUser.html?task_id="+data[i].task_id+"&task_status="+data[i].task_status+"'>编辑</a></li></ul>";
	  				}
	  				
	  				
	  				table+="</div><span class='oi_sf_tsk_tips'></span></div></a>";
	  			}
	  			$("#weui-panel__bd2").html(table);
	  			console.log("加载一次！"+new Date())
	  	        flag=false;
	  		},
	  		error : function(data) { //当访问时候，404，500 等非200的错误状态码
	  			$.alert("加载我接收的任务失败");
	  		}
	  	});
	    }
	  }
	  //滑动加载结束
});


function selectAllTaskByToUserId() {
    $.ajax({
		type : "post", //请求类型
		url : "staff/selectAllTaskByToUserId.json", //请求的url
		dataType : "json", //ajax接口（请求url）返回的数据类型
		success : function(data) { //data：返回数据（json对象）
			$("#weui-panel__bd2").html("");
			var table = "";
			for (var i = 0; i < data.length; i++) {
				table += "<a href='staff/oi_staff_tsk_detailToUser.html?task_id="+data[i].task_id+"&task_status="+data[i].task_status+"'><div task-status='" + data[i].task_status + "' class='weui-media-box weui-media-box_appmsg'><div class='weui-media-box__hd'><img class='weui-media-box__thumb' src=''></div><div class='weui-media-box__bd'><h4 class='weui-media-box__title'>发布人："
					+ data[i].realname
					+ "</h4><p class='weui-media-box__desc'>"
					+ "<h6>时间：" + data[i].task_start_time + "到 " + data[i].task_end_time + "</h6>"
					+ "<h6 class='task_content_ellipse'>"+data[i].task_title+"</h6></p>";
					
				if(data[i].task_status==5){
					table+="<ul class='weui-media-box__info'><li class='weui-media-box__info__meta'><a href='javascript:;' name='"+data[i].task_status+"' task_id='"+data[i].task_id+"'>退回</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='staff/oi_staff_edit.html?task_id="+data[i].task_id+"&task_status="+data[i].task_status+"'>接受</a></li></ul>";
				}else if(data[i].task_status==4){
					table+="<ul class='weui-media-box__info'><li class='weui-media-box__info__meta'><a href='javascript:;' name='"+data[i].task_status+"' task_id='"+data[i].task_id+"'>退回</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='staff/oi_staff_tsk_detailToUser.html?task_id="+data[i].task_id+"&task_status="+data[i].task_status+"'>编辑</a></li></ul>";
				}
				
				
				table+="</div><span class='oi_sf_tsk_tips'></span></div></a>";
			}
			$("#weui-panel__bd2").html(table);
		},
		error : function(data) { //当访问时候，404，500 等非200的错误状态码
			$.alert("加载我接收的任务失败");
		}
	});
	
}