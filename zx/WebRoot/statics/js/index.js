mui('body').on('tap','a',function(){document.location.href=this.href;});  

var path = window.location.href;
	var lastPath = path.substring(0, path.lastIndexOf("/"));
	var rootPath = lastPath.substring(0, lastPath.lastIndexOf("/"));
	var pager=0;
function getLis(){
		$.ajax({
			url : rootPath + "/Newstaff/selectCompanyNews",
			dataType : "json",
			type : "post",
			data: {limit: 10,pager:++pager},
			success : function(data) {
				mui('#pullrefresh').pullRefresh().endPulldownToRefresh();
				$(".msg-searchBox").removeAttr("isLoading")
				/*$(".tab").removeAttr("isLoading");*/
				if(data.length==0){
					$(".mui-pull-bottom-pocket").css("visibility","unset");
					$(".mui-pull-caption").text("没有更多数据了")
				}
				var str = "";
				/*var e=data.listNews;//新闻数据*/
				for (var i = 0; i < data.length; i++) {
					//			alert(data.isView);
					var createTime = getMyDate(data[i].create_time); //将时间戳转换成日期格式
					var id = data[i].new_id;
				    str+=" <li><a href='"+rootPath+"/staff/selectCompanyNewsID.html?id="+id+"'>" +
                    "                    <!--头像部分-->" +
                    "                       <div class=\"li-header\">" +
                    "                           <img src='http://oi.sxfs0351.com/" + data[i].news_logo + "' alt=''>" +
                    "                       </div>\n" +
                    "                    <!--投向部分结束-->" +
                    "                    <!--公告内容-->" +
                    "                    <div class=\"li-con\">" +
                    "                        <div class=\"li-conTitle\">" +
                    "                            <p>"+data[i].title+"</p>" +
                    "                        </div>\n" +
                    "                        <div class=\"li-conCon\">" +data[i].content+"</div>" +
                    "                        <div class=\"li-conTime\">\n" +
                    "                            <span class=\"iconfont icon-shijian time\">\n" +
                    "                                <span>"+createTime+"</span>\n" +
                    "                            </span>\n" +
                    "                            <span class=\"iconfont icon-liulan look\">\n" +
                    "                                <span>"+data[i].pageView+"</span>\n" +
                    "                            </span>\n" +
                    "\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                    <!--公告内容结束-->\n" +
                    "                </a>\n" +
                    "            </li>"
				};
				$(".li-content").append(str);

			},
			error : function() {
				$(".tip").show();
			}
		});
	}
$(function() {
	$(".key").focus(function(){
		document.onkeydown = function (e) {
		    if (!e) e = window.event;
		    if ((e.keyCode || e.which) == 13) {
		        /*$("#btnSubmit").click();*/
		    	getKey()	
		    }
		}
	})
	
	$(".ss").click(
	getKey	
	);
	function getKey(){
			var keyWord=$(".key").val();
			$.ajax({
				url:rootPath+"/Newstaff/selectCompanyNews",
				dataType:"json",
				data:{"search":keyWord},
				type:"post",
				success:function(data){
					$(".li-content").empty();
					
					var str="";
					/*var e=data.listNews;//新闻数据
		*/			
					for(var i=0;i<data.length;i++){
					
//						alert(data.isView);
						var createTime=getMyDate(data[i].create_time);//将时间戳转换成日期格式
						var id=data[i].new_id;
					    str+=" <li><a href='"+rootPath+"/staff/selectCompanyNewsID.html?id="+id+"'>" +
	                    "                    <!--头像部分-->" +
	                    "                       <div class=\"li-header\">" +
	                    "                           <img src='http://oi.sxfs0351.com/" + data[i].news_logo + "' alt=''>" +
	                    "                       </div>\n" +
	                    "                    <!--投向部分结束-->" +
	                    "                    <!--公告内容-->" +
	                    "                    <div class=\"li-con\">" +
	                    "                        <div class=\"li-conTitle\">" +
	                    "                            <p>"+data[i].title+"</p>" +
	                    "                        </div>\n" +
	                    "                        <div class=\"li-conCon\">" +data[i].content+"</div>" +
	                    "                        <div class=\"li-conTime\">\n" +
	                    "                            <span class=\"iconfont icon-shijian time\">\n" +
	                    "                                <span>"+createTime+"</span>\n" +
	                    "                            </span>\n" +
	                    "                            <span class=\"iconfont icon-liulan look\">\n" +
	                    "                                <span>"+data[i].pageView+"</span>\n" +
	                    "                            </span>\n" +
	                    "\n" +
	                    "                        </div>\n" +
	                    "                    </div>\n" +
	                    "                    <!--公告内容结束-->\n" +
	                    "                </a>\n" +
	                    "            </li>"
					};
					$(".li-content").append(str);
					
					
					
				},
				error:function(){
				$(".tip").show();
				}
			});
	}

/*	footer.click(function() {
		// footer.removeClass("active2");
		footer.children("i").removeClass("active");
		footer.children("p").removeClass("active");

		$(this).children("i").addClass("active");
		$(this).children("p").addClass("active");
		var index = $(this).index(".f-tu");
		var flag = true;
		if (index == 2) {
			$(this).children(".fabu").children(".ic").css("transform", "rotate(180deg)");
			flag = false;
		// console.log(flag)
		} else {
			// console.log(footer[2])
			// footer[2].children(".fabu").children(".ic").css("transform","rotate(-180deg)");
		}

	})*/
	//时间戳转换日期格式方法
	function getMyDate(str) {
		var oDate = new Date(str),
			oYear = oDate.getFullYear(),
			oMonth = oDate.getMonth() + 1,
			oDay = oDate.getDate(),
			oHour = oDate.getHours(),
			oMin = oDate.getMinutes(),
			oSen = oDate.getSeconds(),
			oTime = oYear + '-' + getzf(oMonth) + '-' + getzf(oDay) /* +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen)*/ ; //最后拼接时间
		return oTime;
	}
	;
	//补0操作
	function getzf(num) {
		if (parseInt(num) < 10) {
			num = '0' + num;
		}
		return num;
	}
})