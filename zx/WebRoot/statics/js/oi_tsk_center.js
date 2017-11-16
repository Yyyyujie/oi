function tsk_center_btns(settings) {
  $("#pullrefresh").on("tap", ".aui-swipe-right-btn", function () {
    var _s = $(this), btnTxt = _s.text(),task_id=_s.attr("data-tskid"),to_user=_s.attr("data-toUser");
  /*  console.log(btnTxt);
    console.log(_s);*/
    var path = window.location.href;
	var lastPath = path.substring(0, path.lastIndexOf("/"));
	var rootPath = lastPath.substring(0, lastPath.lastIndexOf("/"));
    if (btnTxt == "退回") {
      kAlert({
        title: "确定退回吗？",
        subtitle: "sure to return?",
        btns: ["确定", "取消"]
      }, function () {
        $.ajax({
          type: "post",
          url: settings.url,
          data: {
        	  status:3,
        	task_id: task_id
          },
          success: function () {
        	  var tpl_cle=$('<div class="aui-swipe-right-btn" data-tskId="' + task_id + '">已退回</div>');
        	  _s.parent(".bottom_group").prev(".liBox").find(".__tsk_title").attr("tsk-type",3);
        	  _s.parent(".bottom_group").html(tpl_cle);
            closeL();
          }
        })
      });
    } else if (btnTxt == "拒绝") {
      kAlert({
        title: "确定拒绝吗？",
        subtitle: "sure to refuse?",
        btns: ["确定", "取消"]
      }, function () {
        $.ajax({
          type: "post",
          url: settings.url,
          data: {
        	  status:5,
        	  task_id: task_id
          },
          success: function () {
        	  var tpl_cle=$('<div class="aui-swipe-right-btn" data-tskId="' + task_id + '">取消</div><div class="aui-swipe-right-btn aui-bg-info" data-tskId="' + task_id + '">提醒</div>');
        	  _s.parent(".bottom_group").prev(".liBox").find(".__tsk_title").attr("tsk-type",5);
        	  _s.parent(".bottom_group").html(tpl_cle);
            closeL();
          }
        })
      });
    } else if (btnTxt == "催办") {
        $.ajax({
            type: "post",
            url: "staff/tmpl",
            data: {
            	to_user: to_user,   //催办对象的ID
            	tmplId:2,
            	task_id:task_id,          //任务id
            },
            success: function () {
            	  kAlert({
                      title: "催办成功",
                      subtitle: "Reminder success",
                      btns: ["关闭"]
                    });
            }
          })
        } else if (btnTxt == "提醒") {
          $.ajax({
            type: "post",
            url: "staff/tmpl",
            data: {
            	to_user: to_user,		//提醒对象的ID
            	tmplId:1,
            	task_id:task_id          //任务id
            },
            success: function () {
            	 kAlert({
                     title: "提醒成功",
                     subtitle: "Remind success",
                     btns: ["关闭"]
                   });
            }
          })
        } else if (btnTxt == "取消") {
      kAlert({
        title: "确定取消吗?",
        subtitle: "sure to cancel",
        btns: ["确定", '取消']
      }, function () {
        $.ajax({
          type: "post",
          url: settings.url,
          data: {
        	  status:1,
        	  task_id: task_id
          },
          success: function () {
        	  var tpl_cle=$('<div class="aui-swipe-right-btn" data-tskId="' + task_id + '">已取消</div>')
        	  _s.parent(".bottom_group").prev(".liBox").find(".__tsk_title").attr("tsk-type",1);
        	  _s.parent(".bottom_group").html(tpl_cle)
            closeL();
          }
        })
      });
    } else if (btnTxt == "接受") {
    
    	var toLink=_s.attr("data-href");
          $.ajax({
            type: "post",
            url: settings.url,
            data: {
            	status:4,
            	task_id:task_id          //任务id
            },
            success: function () {
            	var html='<div class="aui-swipe-right-btn" data-tskId="' + task_id + '">退回</div><a href="Newstaff/oi_staff_task_detail.html?task_id=' + task_id + '" class="aui-swipe-right-btn aui-bg-info" data-tskId="' + task_id + '">编辑</a>';
	          	  _s.parent(".bottom_group").prev(".liBox").find(".__tsk_title").attr("tsk-type",4);
	          	  _s.parent(".bottom_group").html(html);
            	
            	 kAlert({
                     title: "接受成功",
                     subtitle: "Receive success",
                     btns: ["编辑","关闭"]
                   },function(){
                	   location.href=rootPath + "/Newstaff/oi_staff_task_detail.html?task_id="+task_id;
                   });
            },
            error:function(){
            	kAlert({
                    title: "接受失败",
                    subtitle: "Receive failed",
                    btns: ["关闭"]
                  });
            }
          })
        }
  })
}