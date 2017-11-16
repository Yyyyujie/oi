function getTskList(ajaxObj) {
	var userId = $(".userId").val();
	console.log(userId);
	var html_rec = "",
		html_rels = "",
		ulBox_rec = $("#__tsk_received ul"),
		ulBox_relse = $("#__tsk_released ul"),
		
		buttonTpl = '',

		
		flag;
	$.ajax({
		cache : false,
		type : ajaxObj.type,
		url : ajaxObj.url, //连接接口
		dataType : "json",
		async : ajaxObj.async ? false : true,
		data : ajaxObj.data ? ajaxObj.data : null,
		success : function(obj) {
			console.log($("#pull_down_container").find(".scroll_bottom_inner"));
			$("#pull_down_container").find(".scroll_bottom_inner").html("加载完成");
			var staff_length = obj.sum;

			$(".all span").empty().text(staff_length);
			if (obj === undefined || obj === null || obj.TaskInfo.length <= 0) { //如果没有数据

				flag = true;
				ulBox_relse.attr("data-check", 'isNull');
			} else { //如果数据不为空
				flag = false;

				if (obj.TaskInfo.length < 7) { //如果获取的数据不足一次十条，则说明没有更多内容。

					ulBox_relse.attr("data-check", 'isNull');
				}

				for (var i = 0; i < obj.TaskInfo.length; i++) {

					var task_status = obj.TaskInfo[i].companyTask.task_status;
					var data = obj.TaskInfo[i].companyTask,
						tStatus = data.task_status;
					if (userId == obj.TaskInfo[i].publisher.user_id) {
						//发布者
						var userHeaderIcon = obj.TaskInfo[i].receiver.face ? "http://www.sxfs0351.com" + obj.TaskInfo[i].receiver.face : obj.TaskInfo[i].receiver.header ? obj.TaskInfo[i].receiver.header : null; //获取对应的头像
						/* console.log(userHeaderIcon);*/
						if (task_status === 1) { //已取消
							buttonTpl = '<div class="__tsk_btns clearfix"><button data-tskId="' + data.task_id + '" class="btn __btn_right __tsk_btn_bg_df" type="button" disabled>已取消</button></div>';
						} else if (task_status === 2) { /*已完成*/
							continue;
							buttonTpl = '<div class="__tsk_btns clearfix"><button data-tskId="' + data.task_id + '" class="btn __btn_right __tsk_btn_bg_bl" type="button" disabled>已完成</button></div>';
						} else if (task_status === 3) { /*已退回*/
							buttonTpl = '<div class="__tsk_btns __trible clearfix"><button data-tskId="' + data.task_id + '" class="btn __btn_left __tsk_btn_bg_bl" type="button">拒绝</button><a data-tskId="' + data.task_id + '" tsk-change="cg" class="btn __btn_left __tsk_btn_bg_df" href="Newstaff/oi_staff_task_forward.html?task_id=' + data.task_id + '">转发</a><button data-tskId="' + data.task_id + '" class="btn __btn_right __tsk_btn_bg_df" type="button">取消</button></div>';
						} else if (task_status === 4) { /*进行中*/
							buttonTpl = '<div class="__tsk_btns clearfix"><button data-tskId="' + data.task_id + '" class="btn __btn_left __tsk_btn_bg_bl" type="button">取消</button><button data-tskId="' + data.task_id + '" data-toUser="' + data.to_user + '" class="btn __btn_right __tsk_btn_bg_df" type="button">催办</button></div>';
						} else if (task_status === 5) { /*待接收*/
							buttonTpl = '<div class="__tsk_btns clearfix"><button data-tskId="' + data.task_id + '" class="btn __btn_left __tsk_btn_bg_bl" type="button">取消</button><button data-tskId="' + data.task_id + '" data-toUser="' + data.to_user + '" class="btn __btn_right __tsk_btn_bg_df" type="button">提醒</button></div>';
						} else if (task_status === 6) { /*待评价*/
							buttonTpl = '<div class="__tsk_btns clearfix"><a data-tskId="' + data.task_id + '" class="btn __btn_right __tsk_btn_bg_bl" href="Newstaff/oi_staff_task_evaluate.html?task_id=' + data.task_id + '">评论</a></div>';
						}


						html_rels += htmlTmp("", data, task_status, buttonTpl, userHeaderIcon, 'fabu');


					} else if (userId == obj.TaskInfo[i].receiver.user_id) {
						//接收者
						var userHeaderIcon = obj.TaskInfo[i].publisher.face ? "http://www.sxfs0351.com" + obj.TaskInfo[i].publisher.face : obj.TaskInfo[i].publisher.header ? obj.TaskInfo[i].publisher.header : null; //获取对应的头像
						if (task_status === 1) { //已取消
							buttonTpl = '<div class="__tsk_btns clearfix"><button data-tskId="' + data.task_id + '" class="btn __btn_right __tsk_btn_bg_df" type="button" disabled>已取消</button></div>';
						} else if (task_status === 2) { /*已完成*/
							buttonTpl = '<div class="__tsk_btns clearfix"><button data-tskId="' + data.task_id + '" class="btn __btn_right __tsk_btn_bg_bl" type="button" disabled>已完成</button></div>';
						} else if (task_status === 3) { /*已退回*/
							buttonTpl = '<div class="__tsk_btns clearfix"><button data-tskId="' + data.task_id + '" class="btn __btn_right __tsk_btn_bg_df" type="button" disabled>已退回</button></div>';
						} else if (task_status === 4) { /*进行中*/
							var receiveUrl = "Newstaff/oi_staff_task_detail.html?task_id=" + data.task_id;
							buttonTpl = '<div class="__tsk_btns clearfix"><button data-tskId="' + data.task_id + '" class="btn __btn_left __tsk_btn_bg_bl" type="button">退回</button><a data-tskId="' + data.task_id + '" class="btn __btn_right __tsk_btn_bg_df" href="Newstaff/oi_staff_task_detail.html?task_id=' + data.task_id + '">编辑</a></div>';
						} else if (task_status === 5) { /*待接收*/
							var receiveUrl = "Newstaff/oi_staff_task_detail.html?task_id=" + data.task_id;
							buttonTpl = '<div class="__tsk_btns clearfix"><button data-tskId="' + data.task_id + '" class="btn __btn_left __tsk_btn_bg_bl" type="button">退回</button><a data-tskId="' + data.task_id + '" class="btn __btn_right __tsk_btn_bg_df" href="javascript:void(0);" data-href="Newstaff/oi_staff_task_detail_receive.html?task_id=' + data.task_id + '">接受</a></div>';
						} else if (task_status === 6) { /*待评价*/
							buttonTpl = '<div class="__tsk_btns clearfix"><button data-tskId="' + data.task_id + '" class="btn __btn_right __tsk_btn_bg_df" type="button" disabled>待评价</button></div>';
						}


						html_rels += htmlTmp("", data, task_status, buttonTpl, userHeaderIcon, "jieshou", receiveUrl);
					}
				}

				if (ajaxObj.formatter) { //true为在原有内容后面追加新内容
					/*  ulBox_rec.append(html_rec);*/
					ulBox_relse.append(html_rels);
				} else if (!ajaxObj.formatter) { //false为覆盖原有新内容
					/* ulBox_rec.html(html_rec);*/
					ulBox_relse.html(html_rels);
				}
			}
			//下拉刷新部分
			pull_load.flag=true;
	        console.log(pull_load.flag);
	        if( pull_load.flag){
	          setTimeout(function(){
	        	  pull_load.setTime(2);
		          pull_load.setY(-99.975);
		          pull_load.isLock=false;
		          $("#pull_down_container .scroll_bottom_inner").html("加载更多···");
	          },300)
	        }
		},
		error : function(data) {
			console.log(data);
			ulBox_relse.attr("data-check", 'errOnline') && ulBox_rec.attr("data-check", 'errOnline');
		}
	});
	return flag;
	
}
//html模板
function htmlTmp(html, data, task_status, buttonTpl, userHeader, isRes, receiveUrl) {
	html += '<li class="__tsk_list" data-type="' + isRes + '"><div class="liBox">'
		+ '<!--头像部分-->'
		+ '<div class="__tsk_list_header _list_header"><div class="__list_header_inner" style="background-image:url(' + (userHeader ? userHeader : "statics/images/header/header_01.jpg") + ');">'
		+ '</div>'
		+ '</div>'
		+ '<!--头像部分 结束-->'
		+ '<div class="__tsk_list_content">'
		+ '<a href="' + (receiveUrl ? receiveUrl : ('Newstaff/oi_staff_task_detail_pre.html?task_id=' + data.task_id)) + '">'
		+ '<!--任务标题-->'
		+ '<div class="__tsk_title" tsk-type=' + task_status + '><span class="__t_title">' + (data.task_title ? data.task_title : "暂时没有标题") + '</span></div>'
		+ '<!--任务标题 结束-->'
		+ '<!--任务简述-->'
		+ '<div class="__tsk_content">' + (data.task_content ? data.task_content : "暂时没有内容") + '</div>'
		+ '<!--任务简述 结束-->'
		+ '<!--任务时间-->'
		+ '<div class="__tsk_time">'
		+ '<em class="_icon __icon_timer"></em>'
		+ '<span>' + (data.task_start_time ? data.task_start_time : "发布时间暂无") + '—' + (data.task_end_time ? data.task_end_time : "截止时间暂无") + '</span>'
		+ '</div>'
		+ '<!--任务时间 结束-->'
		+ '<!--任务状态-->'
		+ '<div class="__tsk_status_container clearfix">'
		+ '<!--紧急状态-->'
		+ '<div class="__tsk_status __t_s_ur ' + (data.task_urgent == 1 ? "_status_1" : "_status_2") + '"></div>'
		+ '<!--重要状态-->'
		+ '<div class="__tsk_status __t_s_im ' + (data.task_important == 1 ? "_status_1" : "_status_2") + '"></div>'
		+ '</div>'
		+ '</a>'
		+ '<!--按钮组合-->'
		+ '</div>'
		+ '<!--按钮组合 结束-->'
		+ '</div></div>'
		+ '<div class="operate">'+buttonTpl+'</div>'
		+ '</li>';
	return html;
	cosnsole.log($(".all").html())
	
}
