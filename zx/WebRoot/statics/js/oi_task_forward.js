/**
 * Created by kemplaw on 2017/10/6.
 */
$(function () {
  wxScrollSolve(document.querySelector("ul._sel_contact"));
  fzySearch.init();
});
var fzySearch = {
  lastTime: null,
  inputBox: $("#_sel_input_box"), //搜索输入框
  nameList: $("#_sel_contact").find("li"), //名字列表
  showInput: $("#_t_form_sel_checker"),  //选择对象展示列表
  sdClass: "filter_blur",        //阴影Class
  sdBG: $(".sf_reg_container"),  //阴影背景
  nameSelLs: $("._sel_list"),   //名字选择列表
  confirmAlert: $("._alert_box"),   //确认弹层
  init: function () {
    this.search();
    this.clickAdd();
    this.showSel();
    this.clkCloseSD();
    this.tsk_sel();
    this.smtTsk();
  },
  search: function () {
    this.inputBox.bind("input porpertychange", function (e) {
      var s = $(this), txt = s.val(), names = fzySearch.nameList;
      fzySearch.lastTime = e.timeStamp;
      setTimeout(function () {
        if (e.timeStamp == fzySearch.lastTime) {
          for (var i = 0; i < names.length; i++) {
            if (names[i].innerText.indexOf(txt) !== -1) {
              console.log(names[i]);
              names[i].setAttribute("data-sel", "sel");
            } else {
              names[i].setAttribute("data-sel", "unsel");
            }
          }
        }
      }, 1000)
    })
  },
  clickAdd: function () {
    this.nameList.on("click", function () {
      var s = $(this), sName = s.text(),sId=s.attr("liid");
      fzySearch.showInput.css("color", "#333641").text(sName);
      //将名字打入隐藏域中
      $("#sel_per").val(sId);
      fzySearch.closeShade();
    })
  },
  closeShade: function () {  //关闭遮罩
    fzySearch.nameSelLs.fadeOut(200);
    fzySearch.sdBG.removeClass(fzySearch.sdClass);
  },
  showSel: function () {  //点击选择任务对象显示遮罩层
    this.showInput.click(function () {
      fzySearch.nameSelLs.fadeIn();
      fzySearch.sdBG.addClass(fzySearch.sdClass);
    });
  },
  clkCloseSD: function () {  //点击背景关闭遮罩层
    $('._shade_c').click(function (e) {
      e.stopPropagation();
      fzySearch.closeShade();
    });
  },
  /*任务级别选择*/
  tsk_sel: function () {
    $("._task_level").on("click", "._t_level", function () {
      var s = $(this), sAtr = s.attr("data-target");
      if (s.hasClass("_default")) {
        s.removeClass("_default");
        document.getElementById(sAtr).value = 1;
      } else {
        s.addClass("_default");
        document.getElementById(sAtr).value = 0;
      }
    })
  },
  smtTsk: function () {
    $("#_pub_tsk_form").submit(function (e) {
    	e.preventDefault();
      var dataStr = $("#_pub_tsk_form").serialize();
      dataStr = decodeURIComponent(dataStr,true);
      var pathName=window.document.location.pathname;
      var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
      $.ajax({
        url: projectName+"/Newstaff/forwardtask",
        type: "POST",
        data: dataStr,
        success: function (result) {
        	console.log(result);
	        	if(result.code==100){
	        	var task_id=result.extend.taskid
	         //kAlert("任务已发布","THE TASK HAS BEEN RELEASED",["继续发布","查看任务"],"Newstaff/oi_staff_task_detail_pre.html?task_id="+task_id);
	        	kAlert({
	        		title:"任务发布成功",
	        		subtitle:"task released success",
	        		btns:['继续发布','查看任务'],
	        		taskUrl:"Newstaff/oi_staff_task_detail_pre.html?task_id="+task_id
	        	})	
        	}else{
        		alert(result.extend.msg);
        	}
        },
        error: function () {
        }
      })
    })
  },
  clkT:function(){
    this.confirmAlert.on("click",".__continue",function(){
      window.location.reload(true);
    })
  }
};
