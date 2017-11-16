
$(function(){
	selectNewsCount();
});

function selectNewsCount() {
	$.ajax({
		type : "post", //请求类型
		url : "staff/selectNewsCount.json", //请求的url
		dataType : "json", //ajax接口（请求url）返回的数据类型
		success : function(data) { //data：返回数据（json对象）
			$("#newsCount").html(data);
		},
		error : function(data) { //当访问时候，404，500 等非200的错误状态码
			$.alert("加载信息条数失败");
		}
	});
}