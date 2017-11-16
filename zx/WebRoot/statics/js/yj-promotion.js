mui('body').on('tap','a',function(){document.location.href=this.href;});  
	
	var path=window.location.href;
	var lastPath=path.substring(0, path.lastIndexOf("/"));
	var rootPath=lastPath.substring(0, lastPath.lastIndexOf("/"));	
	var pager=0;
function getLis(){
	$.ajax({
		   url:rootPath+"/staff/selectPromotion.do",
		   dataType:"json",
		   data:{limit: 10,pager:++pager},
		   success:function(data){
			   mui('#pullrefresh').pullRefresh().endPulldownToRefresh();
			   console.log(data)
			   if(data.length==0){
				    var str="<p style='text-align: center; color: #ccc;'>暂无数据</p>";
					$(".js").append(str);
			   }else{
			   for(var i=0;i<data.length;i++){
				   var header=data[i].header;
				   if(data[i].face!=null && data[i].face!="" && data[i].face!="undefined"){
					   header="http://oi.sxfs0351.com/"+data[i].face;
				   }
				   var agree=0;
				   if(data[i].agree != null){
					   agree=data[i].agree;
				   }
				   var str="";

				   str+=" <li><a href='"+rootPath+"/staff/staffVote.html?id="+data[i].promotion_id+"'>" +
                   "                    <!--头像部分-->" +
                   "                       <div class=\"li-header\">" +
                   "                           <img src='" + data[i].header + "' alt=''>" +
                   "                       </div>\n" +
                   "                    <!--投向部分结束-->" +
                   "                    <!--公告内容-->" +
                   "                    <div class=\"li-con\">" +
                   "                        <div class=\"li-conTitle\">" +
                   "                            <p>"+data[i].realname+"</p>" +
                   "                        </div>\n" +
                   "                        <div class=\"li-conCon\">目标："+data[i].level_name+"</div>" +
                   "                        <div class=\"li-conTime\">\n" +
                   "                            <span class=\"iconfont icon-bumen time\">\n" +
                   "                                <span>"+getMyDate(data[i].create_time)+"</span>\n" +
                   "                            </span>\n" +
                   "                            <span class=\"iconfont icon-zhiwei look\">\n" +
                   "                                <span>"+agree+"</span>\n" +
                   "                            </span>\n" +
                   "\n" +
                   "                        </div>\n" +
                   "                    </div>\n" +
                   "                    <!--公告内容结束-->\n" +
                   "                </a>\n" +
                   "            </li>"
 $(".li-content").append(str);
			   }
			  
			   } 
		   },
		   error:function(){
			   alert("error")
		   }
	   });
}