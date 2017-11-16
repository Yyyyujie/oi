(function(window){
  function get(elem){return document.getElementById(elem);}
  var pl={
    start:null,
    end:null,
    isLock:false,
    isCanDo:false,
    flag:false,
    elem:get("pull_down_container"),
    setTime:function(time){
      this.elem.style.cssText="-webkit-transition:transform +"+time+"+s ease;transition:transform +"+time+"+s ease";
    },
    setY:function(Y){
      this.elem.style.cssText="-webkit-transform:translate3d(0,"+Y/75+"rem,0);transform:translate3d(0,"+Y/75+"rem,0);";
    },
    init:function(obj){
    	var ulBox_relse = $("#__tsk_released ul");
      var target=this.elem;
      target.addEventListener("touchstart",function(e){ //开始
        var scrollTop=document.documentElement.scrollTop || document.body.scrollTop;  //保存页面当前的位置
        if(scrollTop<=0 && !pl.isLock){
          pl.isLock=true;
          pl.isCanDo=true;
          pl.start=e.touches[0].pageY;
        }
      });
      target.addEventListener("touchmove",function(e){ //移动中
        var scrollTop=document.documentElement.scrollTop || document.body.scrollTop;  //保存页面当前的位置
        if(scrollTop<=0 && pl.isCanDo){
          pl.end=e.touches[0].pageY;
          if(pl.start<pl.end){
            e.preventDefault();
            pl.setTime(0);
            pl.setY(pl.end-pl.start-obj.max);
          }
        }
      });
      target.addEventListener("touchend",function(e){ //结束
        if(pl.isCanDo){
          pl.isCanDo=false;
          if(pl.end-pl.start>=obj.max){
        	  pl.setTime(5);
        	 pl.setY(0);
            if(typeof obj.do =="function"){
            	obj.do()
            }
          }else{
        	 pl.setY(-99.975);
            pl.setTime(2);
            pl.isLock=false;
          }
        }
      })
    }
  };
  window.pull_load=pl;
})(window);