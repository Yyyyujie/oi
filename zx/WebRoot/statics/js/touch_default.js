function wxScrollSolve(scrollWrapObj) {//Scrollobj要滚动的内容外部包裹的容器对象
  if (scrollWrapObj == "" || scrollWrapObj == undefined || scrollWrapObj == null) {
    return
  }
  var overscroll = function (el) {
    el.addEventListener('touchstart', function () {
      var top = el.scrollTop
        , totalScroll = el.scrollHeight
        , currentScroll = top + el.offsetHeight;
      if (top === 0) {
        el.scrollTop = 1;
      } else if (currentScroll === totalScroll) {
        el.scrollTop = top - 1;
      }
    });
    el.addEventListener('touchmove', function (e) {
      if (el.offsetHeight < el.scrollHeight)
        e._isScroller = true;
    })
  };
  overscroll(scrollWrapObj);
  document.body.addEventListener('touchmove', function (e) {
    if (!e._isScroller) {
      e.preventDefault();
    }
  });
}
/*ios微信浏览器上下滚动兼容性问题解决 end*/