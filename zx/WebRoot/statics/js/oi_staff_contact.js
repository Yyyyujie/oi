
$(function () {
	selectStaffByCompanyId();
});


function selectStaffByCompanyId() {
	$.ajax({
		type : "post", //请求类型
		url : "staff/selectStaffByCompanyId", //请求的url
		dataType : "json", //ajax接口（请求url）返回的数据类型
		success : function(data) { //data：返回数据（json对象）
			$("#sf_tsk_backlog_4").html("");
			var table = "";
			for (var i = 0; i < data.length; i++) {
				table += "<div class='weui-panel__bd'><div class='weui-media-box weui-media-box_appmsg staff_info_box'><div class='weui-media-box__hd'><img class='weui-media-box__thumb' src=''></div><div class='weui-media-box__bd'><h4 class='weui-media-box__title'><span>" 
						+data[i].realname+"</span><small>"+data[i].dept_name+"</small></h4><p class='weui-media-box__desc'><strong>" 
						+data[i].phone+"</strong></p><ul class='weui-media-box__info'><li class='weui-media-box__info__meta'>质量：" 
						+data[i].qualityavg+"</li><li class='weui-media-box__info__meta'>效率：" 
						+data[i].efficiencyavg+"</li><li class='weui-media-box__info__meta font_strong'><a href='staff/oi_staff_publish.html'>发任务</a></li></ul></div></div></div>";
	        }
			$("#sf_tsk_backlog_4").html(table);
		},
		error : function(data) { //当访问时候，404，500 等非200的错误状态码
			alert("加载公司职员失败");
		}
	});
}