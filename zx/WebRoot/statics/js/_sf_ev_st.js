/*员工星评*/
$(function(){
  starCheck();
});
function starCheck(){
  var target=$("._e_star"),starCount=0;
  target.on("click","li",function(){
    var self=$(this),ptarget=self.parent().attr("data-eva");
    if(!self.hasClass("_s_on")){
      self.addClass("_s_on").prevAll().addClass("_s_on");
    }else if(self.hasClass("_s_on")){
      self.nextAll().removeClass("_s_on");
    }
    starCount=self.siblings("._s_on").size()+1;
    if(ptarget=='effc'){  //效率
      $("#_ev_effc").val(starCount);
    }else if(ptarget=='qua'){ //质量
      $("#_ev_qua").val(starCount);
    }
  })
}
