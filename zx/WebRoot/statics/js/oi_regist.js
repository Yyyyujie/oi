$(function(){
  $("#oi_form_reg_con_3").on("focus","input",function(){
    $(this).next(".errorTips").fadeOut();
  });
  $('.sf_submit_button').click(function(){
    var unm=$("[in-tp='uname']"),utl=$("[in-tp='tel']");
    var uname=unm.val(),utel=utl.val();
    if(uname == null || uname == undefined || uname == ""){
      unm.next('.errorTips').fadeIn().text("请填写用户名");
    }else if(checkMobile(utel)){
      utl.next('.errorTips').fadeIn().text("请填写正确的手机号");
    }else{
      $("#oi_form_reg_con_3").submit();
    }
  })
});
function checkMobile(sMobile){  //手机号码验证
  if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(sMobile))){
    return true;
  }
}