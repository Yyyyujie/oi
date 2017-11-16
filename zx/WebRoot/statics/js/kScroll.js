function Kscroll(url, callback) {
  //滑动加载
  var flag = false, //滚动开关
    ajaxObj = {},   //数据参数对象
    pager=1,        //任务分页
    tabTogger=$("#_tc_tabContainer"), //标签选择器
    interUrl=url.url_1;    //数据接口
  tabTogger.on("click",".__tab",function(){
    var _s=$(this),_sA=_s.attr("data-target");
    if(_sA){
      interUrl=((_sA==="__tsk_released")?(url.url_2):(url.url_1)); //重定向数据获取接口
      pager=1;                                                      //重置数据页数
    }
  });
  window.onscroll = function () {
    var t = document.documentElement.scrollTop || document.body.scrollTop;
    var cHeight = document.documentElement.clientHeight || document.body.clientHeight;
    var dHeight = document.documentElement.scrollHeight || document.body.scrollHeight;
    var n = Math.floor(dHeight - cHeight - t);
    console.log(n);
    var task_type=$("#swiper-container").attr("current-status");//获取当前任务种类--我接收/我发布

    if (n <= 50) { //满足滑动加载条件，开始ajax请求数据
      if (flag) {
        return
      } else {
        flag = true;
        ajaxObj = {
          type: "post",  //请求方式
          async: "noAsync", //是否同步
          data: {limit: 10, status: task_type,pager:++pager}, //传递参数
          url: interUrl,    //数据接口
          formatter: true     //是否覆盖 true - 追加内容 false - 覆盖内容
        };
        console.log(flag);
        console.log("滚动加载");
        flag = callback(ajaxObj);
        console.log(flag);
      }
    }
  };
}