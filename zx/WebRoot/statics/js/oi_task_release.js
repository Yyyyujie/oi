/**
 * Created by kemplaw on 2017/10/6.
 */
$(function () {
  wxScrollSolve(document.querySelector("ul._sel_contact"));
  fzySearch.init();
});
var fzySearch = {
  showInput: $("#_t_form_sel_checker"),  //选择对象展示列表
  typeInput: $("#_t_form_sel_type"),
  selHidden: $("#sel_per"),  //选择对象展示列表
  typeHidden:$("#sel_type"),
  init: function () {  //初始化方法
   // this.tsk_sel();
  },
  showSel: function (obj) {  //任务对象选择
    this.showInput.click(function () {
      initPicker({url:obj.selUrl,elem:fzySearch.showInput,elemHidden:fzySearch.selHidden}) //启动任务对象选择器，确定对象之后保存ID
    });
  },
  showType:function(obj){
	  this.typeInput.click(function(){
		  initType({url:obj.selUrl,elem:fzySearch.typeInput,elemHidden:fzySearch.typeHidden}) //启动任务对象选择器，确定对象之后保存ID
	  })
  },
  tsk_sel: function () {/*任务级别选择*/
    $("._task_level").on("click", "._t_level", function () {
      var s = $(this), sAtr = s.attr("data-target");
      if (s.hasClass("_default")) {
        s.removeClass("_default");
        document.getElementById(sAtr).value = 1;
      } else {
        s.addClass("_default");
        document.getElementById(sAtr).value = 2;
      }
    })
  }
};


function initPicker(setting){
  var picker=new mui.PopPicker({layer:2});
  $.ajax({
    type:"get",
    url:setting.url,
    dataType:"json",
    success:function(data){
    	console.log(data);
      picker.setData(data); //初始化任务对象数据
      picker.show(function (items) { //show方法初始化任务对象选择界面
        console.log(items);
        var str="任务对象："+items[0].text+" "+items[1].text;
        setting.elem.css("color","#333").text(str);
        setting.elemHidden.val(items[1].value);
      });
    }
  })
}
function initType(setting){
	  var picker=new mui.PopPicker({layer:1});//显示一列
	  $.ajax({
	    type:"get",
	    url:setting.url,
	    dataType:"json",
	    success:function(data){
	    	console.log(data);
	      picker.setData(data); //初始化任务对象数据
	      picker.show(function (items) { //show方法初始化任务对象选择界面
	        console.log(items);
	        var str="任务类型："+items[0].text;
	        setting.elem.css("color","#333").text(str);
	        setting.elemHidden.val(items[0].value);
	      });
	    }
	  })
	}
