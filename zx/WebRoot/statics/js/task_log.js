
$(function () {
	selectTaskLogByTaskId();
});


function selectTaskLogByTaskId() {
	var task_id=$("#task_id").val();
	$.ajax({
		type : "post", //请求类型
		url : "staff/selectTaskLogByTaskId.json?task_id="+task_id, //请求的url
		dataType : "json", //ajax接口（请求url）返回的数据类型
		success : function(data) { //data：返回数据（json对象）
			$("#weui-cell__ft").html("");
			var table = "";
			for (var i = 0; i < data.length; i++) {
				table += "<small>"+data[i].sub_time+"  任务进度"+data[i].task_progress+"%</small></br>";
			}
			$("#weui-cell__ft").html(table);
		},
		error : function(data) { //当访问时候，404，500 等非200的错误状态码
			alert("加载日志失败");
		}
	});
}