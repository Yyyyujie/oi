function tabGet(obj, formatt) {
  /*点击标签获取对应的数据*/
  var t_release = $("#__tsk_released"), t_receive = $("#__tsk_received"), searchInput = $("#__sf_button_1");
  $("#_tc_tabContainer").on("click", ".__tab", function () {
    var self = $(this), targetBox = self.attr("data-target");
    self.addClass("__tab_on").siblings(".__tab").removeClass("__tab_on");
    if (targetBox === "__tsk_released") {
      searchInput.attr("search-type", "released") && t_receive.hide() && t_release.fadeIn() && clearList({
        elem: t_release.find("ul"),
        isLoad: "isFull"
      });
      getTskList({ //我发布的
        type: "post",
        url: obj.url_2,
        data: obj.data ? obj.data : null,
        formatter: formatt,  //数据覆盖是否
        level: obj.level
      });
    } else if (targetBox === "__tsk_received") {
      searchInput.attr("search-type", "received") && t_release.hide() && t_receive.fadeIn() && clearList({
        elem: t_receive.find("ul"),
        isLoad: "isFull"
      });
      getTskList({ //我接收的
        type: "post",
        url: obj.url_1,
        data: obj.data ? obj.data : null,
        formatter: formatt, //数据覆盖是否
        level: obj.level
      });
    }
  })
}
/*点击任务状态选择对应任务*/
function getStatusList(setting) {
  /*_t_status  -  对应任务状态*/
  var statusBox = $("#swiper-container"), _t_status, url = '',t_release = $("#__tsk_released"), t_receive = $("#__tsk_received");
  statusBox.on("click", ".__tp_container a", function (e) {
    e.preventDefault();
    var s = $(this);
    _t_status = s.attr("task-status");
    var __task_type = $("#_tc_tabContainer").find(".__tab.__tab_on").attr("data-target");  //获取接受/发布状态
    if (__task_type === "__tsk_received") {  //接收 => url_1
      url = setting.url_1;
      clearList({elem:t_receive.find("ul"),isLoad:"isFull"})
    } else if (__task_type === "__tsk_released") { //发布 => url_2
      url = setting.url_2;
      clearList({elem:t_release.find("ul"),isLoad:"isFull"})
    }  //重定向数据接口
    statusBox.attr("current-status", _t_status);
    getTskList({
      type: "post",
      url: url,
      data: {limit: 10, status: _t_status},
      formatter: false
    })
  });
}
function clearList(option) {  //清空列表 为数据重新加载做准备
  option.elem.html("");
  option.elem.attr("data-check", option.isLoad);
}