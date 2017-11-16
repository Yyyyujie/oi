function getSearch(obj) {
  var t_release = $("#__tsk_released").find("ul"), t_receive = $("#__tsk_received").find("ul");
  $("#__search_forms").on("submit", function (e) {
    e.preventDefault();
    var search = $("#__sf_button_1"),
      searchTxt = search.val(),
      searchType = search.attr("search-type");
    if (searchType === "received") {
      clearList({
        elem:t_receive,
        isLoad:"isFull"
      });
      $(".lisCon").empty();
		html_rels="";
     getLis({search:searchTxt})
    } else {
      clearList({
        elem:t_release,
        isLoad:"isFull"
      });
      $(".lisCon").empty();
		html_rels="";
      getLis({search:searchTxt})
    }
  })
}
function clearList(option) {  //����б� Ϊ�������¼�����׼��
  option.elem.html("");
  option.elem.attr("data-check", option.isLoad);
}