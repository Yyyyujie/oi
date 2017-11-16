$(function(){
  $("#datePicker_2").datetimePicker({
    title: '截止日期',
    yearSplit: '年',
    monthSplit: '月',
    dateSplit: '日',
    times: function () {
      return [  // 自定义的时间
        {
          values: (function () {
            var hours = [];
            for (var i=0; i<24; i++) hours.push(i > 9 ? i : '0'+i);
            return hours;
          })()
        },
        {
          divider: true,  // 这是一个分隔符
          content: '时'
        },
        {
          values: (function () {
            var minutes = [];
            for (var i=0; i<59; i++) minutes.push(i > 9 ? i : '0'+i);
            return minutes;
          })()
        },
        {
          divider: true,  // 这是一个分隔符
          content: '分'
        }
      ];
    },
    onChange: function (picker, values, displayValues) {
      console.log(values);
      var imgStr='',yM='',day='',timeAttr=this.input.getAttribute("time-name");
      for(var i=0;i<values.length;i++){
    	  if(i<=2){
    		  yM+=values[i]+"-";
    	  }
    	  if(i>2){
    		  day+=values[i]+":";
    	  }
      };
      imgStr=yM.slice(0,-1)+" "+day.slice(0,-1);
      document.getElementById(timeAttr).value=imgStr;
    }
  });
  $("#datePicker_1").datetimePicker({
	    title: '开始日期',
	    yearSplit: '年',
	    monthSplit: '月',
	    dateSplit: '日',
	    times: function () {
	      return [  // 自定义的时间
	        {
	          values: (function () {
	            var hours = [];
	            for (var i=0; i<24; i++) hours.push(i > 9 ? i : '0'+i);
	            return hours;
	          })()
	        },
	        {
	          divider: true,  // 这是一个分隔符
	          content: '时'
	        },
	        {
	          values: (function () {
	            var minutes = [];
	            for (var i=0; i<59; i++) minutes.push(i > 9 ? i : '0'+i);
	            return minutes;
	          })()
	        },
	        {
	          divider: true,  // 这是一个分隔符
	          content: '分'
	        }
	      ];
	    },
	    onChange: function (picker, values, displayValues) {
	      console.log(values);
	      var imgStr='',yM='',day='',timeAttr=this.input.getAttribute("time-name");
	      for(var i=0;i<values.length;i++){
	    	  if(i<=2){
	    		  yM+=values[i]+"-";
	    	  }
	    	  if(i>2){
	    		  day+=values[i]+":";
	    	  }
	      };
	      imgStr=yM.slice(0,-1)+" "+day.slice(0,-1);
	      document.getElementById(timeAttr).value=imgStr;
	    }
	  });
})