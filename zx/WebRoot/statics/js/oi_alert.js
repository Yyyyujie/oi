/*kAlert _v1.3
* 更新日志：
*   1.按钮可二选一
*   2.修复bug
* */
function kAlert(setting,callBack) {
  var btnGroup=setting.btns.length>=2?('<button class="_al_button __continue">'+setting.btns[0]+'</button>'+'<button class="_al_button _d">'+setting.btns[1] +'</button>'):('<button class="_al_button __continue _al_btn_block">'+setting.btns[0]+'</button>');  //按钮组
  var alertBox = $("._alert_box"); //确认弹框
  var html = '<div class="_shade_c"></div>'
    + '<div class="_task_re_alert">'
    + '<div class="_al_top"></div>'
    + '<div class="_al_content">'
    + '<div class="_al_t1">' + setting.title + '</div>'
    + '<div class="_al_t2">' + setting.subtitle + '</div>'
    + '</div>'
    + '<div class="_al_btns">'
    + btnGroup
    + '</div>'
    + '</div>';
  alertBox.fadeIn().html(html);
  $(".sf_reg_container").addClass("filter_blur");
  alertBox.on("click", "._al_button", function () {
    var s = $(this), sTarget = s.text();
    if (sTarget === "确定" || sTarget === "编辑") {
    	closeL();
      callBack();
    } else if (sTarget === "取消" || sTarget === "继续发布" || sTarget === "关闭") {
      closeL();
    } else if(sTarget === "查看任务"){
        console.log(setting.taskUrl);
      window.location.href=setting.taskUrl;
  
    }
  });
}
function closeL() {
  $("._alert_box").fadeOut();
  $(".sf_reg_container").removeClass("filter_blur");
}