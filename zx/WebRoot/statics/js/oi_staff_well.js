function $(elem) {
  return document.getElementById(elem);
}
(function (window) {
	var second=3;
	var Interval=setInterval(function(){
		second--;
		$("time").innerHTML=second+"s";
		if (second<=0){
			second=0;
			$("time").innerHTML="点击";
		}
	},1000);
	

		
  var wellcome = {
    getAjax: function (setting) {
      if (window.XMLHttpRequest) {
        var ajax = new XMLHttpRequest();
      } else {
        var ajax = new ActiveXObject("Microsoft.XMLHttp");
      }
      ;
      ajax.open(setting.type, setting.url, setting.async);//打开端口 type为get/post数据获取方式,url数据接口
      if (setting.type === "post") {
        ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      }
      ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200) { //请求成功的回调
          var data = JSON.parse(ajax.responseText);
          setting.success(data)
        }
      };
      ajax.send(setting.data);
    },
    viewInit: function (option) {    /*swiper启用*/
      var mySwiper = new Swiper('.swiper-container', {
        effect: 'cube',
        direction: option.direction,
        loop: option.loop,
        onInit: option.init,
        onTransitionEnd: option.transitionEnd
      });
      return mySwiper;
    },
    template: function (data, option) { //首页模板
      var tplHtml = '';
      if (option && option.type === 1) { //如果是图文类别
        if(option && option.go){ //true-启动跳转功能 =》按钮实现
          tplHtml = '<div class="swiper-slide" style="background-image:url(' + data.url + ');opacity:1!important">'
            + '<div style="' + option.style + '" class="page_text">您与<span class="oi_well_text i_well_company">' + data.company + '</span>的第<span class="oi_well_text i_well_days">' + data.days + '</span>天</div>'
              +'<a href="'+option.url+'" class="oi_wel_btn_go"><span id="time">3s</span>&nbsp;&nbsp;&nbsp;进入OI</a>'
            + '</div>';
        }else{
          tplHtml = '<div class="swiper-slide" style="background-image:url(' + data.url + ');opacity:1!important">'
            + '<div style="' + option.style + '" class="page_text">您与<span class="oi_well_text i_well_company">' + data.company + '</span>的第<span class="oi_well_text i_well_days">' + data.days + '</span>天</div>'
            + '</div>';
        }
      }
      else {
        if(option && option.go){
          tplHtml = '<div class="swiper-slide" style="background-image:url(' + data.url + ');opacity:1!important">'
            +'<a href="'+option.url+'" class="oi_wel_btn_go"><span id="time">3s</span>&nbsp;&nbsp;&nbsp;进入OI</a>'
            '</div>';
        }else{
          tplHtml = '<div class="swiper-slide" style="background-image:url(' + data.url + ');opacity:1!important"></div>';
        }
      }
      return tplHtml;
    }
  };
  window.well = wellcome;
  
})
(window);