function oiService(option,flag) {
  well.getAjax({
    type: "get",
    url: option.url,
    async:true,
    success: function (data) {
      var html = '', data = data.extend;
      console.log(data);
      var imgArray = data.backpic,//获取图片
        name = data.companyname ? data.companyname : "某个不愿透露名字的公司", //公司名称
        day = data.day ? data.day : 0, //天数
        textIndex = (flag.index > imgArray.length) ? imgArray.length : flag.index;
      for (var i = 0; i < imgArray.length; i++) {
        if(flag.fl && i!==imgArray.length-1){ //true 所有页面都有文字
          console.log(flag.fl);
          html += well.template({url: imgArray[i], company: name, days: day}, {type: 1, style: option.style});
        }else if(!flag.fl && i!==imgArray.length-1){ //false 指定页面有文字
          if (i == textIndex - 1) { //第一页的时候放文字，可以定义下表i的位置来决定图文页的位置
            console.log(flag.fl);
            html += well.template({url: imgArray[i], company: name, days: day}, {type: 1, style: option.style});
          }else{
            html += well.template({url: imgArray[i]});
          }
        }
        else{ //如果是最后一页
          html += well.template({url: imgArray[i]},{go:true,btnName:"进入OI",url:flag.url});
        }
      }
      $("oiWellContainer").innerHTML = html;
      var mySwiper=well.viewInit({
        direction:"horizontal",
        loop:false,
        init:function(swiper){
          swiper.slides[0].setAttribute("slideTop","true");
        },
        transitionEnd:function(swiper){
          var i=swiper.activeIndex,cElem=mySwiper.slides[i];
          console.log(i,textIndex-1);
          if(!flag.fl){
            if(i==(textIndex-1)){  //如果是指定文字的那一页
              cElem.getAttribute("slideTop")!=="true"&&cElem.setAttribute("slideTop","true");
            }else{  //如果非指定文字的那一页
              mySwiper.slides[textIndex-1].setAttribute("slideTop","");
            }
          }else{
            for(var k=0;k<mySwiper.slides.length;k++){
              if(k==i){ //如果是当前页
                mySwiper.slides[i].setAttribute("slideTop","true");
              }else{
                mySwiper.slides[k].setAttribute("slideTop","");
              }
            }
          }
        },

      })
    }
  })
}