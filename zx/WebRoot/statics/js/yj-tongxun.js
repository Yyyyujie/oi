
$(function () {
	selectStaffByCompanyId();
});
var path=window.location.href;
var lastPath=path.substring(0, path.lastIndexOf("/"));
var rootPath=lastPath.substring(0, lastPath.lastIndexOf("/"));

function selectStaffByCompanyId() {
	$.ajax({
		type : "post", //请求类型
		url : "selectStaffByCompanyId", //请求的url
		dataType : "json", //ajax接口（请求url）返回的数据类型
		success : function(data) { //data：返回数据（json对象）
			console.log(data);
			$("#mui-table-view").html("");

			


			var array = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"];



			$('.mui-indexed-list-search-input').bind('input propertychange', function() {

			    var v=$(".mui-indexed-list-search-input").val();
			       
			    var arr=[];
			    for(var i=0;i<data.length;i++){
			        if(data[i].realname.indexOf(v)>=0){
			            arr.push(data[i])
			        }
			    }
			   
			    var str ="";
			    var str1="";
			    for (var k = 0; k < array.length; k++) {
			        var flag=false;
			        var str2="";
			        for (var i = 0; i < arr.length; i++) {
			            if (arr[i].py == array[k]) { //如果有值
			            	var header="";
			            	
			            	if(arr[i].dept_name=="0" ||arr[i].dept_name==null || arr[i].dept_name=="" ||  arr[i].dept_name=="undefined"){
			            		dept_name="";
			            	}
			            	
			            	if(data[i].face!=""  && data[i].face!=null){
			            		header="http://oi.sxfs0351.com/"+data[i].face;
			            	}else{
			            		if(data[i].header!=""){
			            			header=data[i].header;
			            			
			            		}else{
			            			header=rootPath+"/statics/img/person.jpg";
			            		}
			            	}			            	
			            	var id=data[i].user_id;
			                str2 +=
			                    "<li class='mui-table-view-cell'><a href='"+rootPath+"/staff/getStafferByID.html?id="+id+"' style='display:inline'><div class=\"left\">\n" +
			                    "<div class=\"tx\">\n" +
			                    "<div class=\"img\">\n" +
			                    "<img src=\""+header+"\" alt=\"\" style=\"width: 100%;height: 100%;\">\n" +
			                    "</div>\n" +
			                    "</div>\n" +
			                    "</div>\n" +
			                    "<div class=\"right\">\n" +
			                    "<ul>\n" +
			                    "<li>\n" +
			                    "<span class=\"name\">" + arr[i].realname + "</span>\n" +
			                    "<span>" + dept_name + "</span>\n" +
			                    "</li>\n" +
			                    "<li>\n" +
			                    "<span>工作质量：</span> <span>" + arr[i].qualityavg + "</span>\n" +
			                    "<span>工作效率：</span> <span>" + arr[i].efficiencyavg + "</span>\n" +
			                    "</li>\n" +
			                    "<li class=\"user_tel\">\n" +
			                    "<a href=\"tel:" + arr[i].phone + "\">" + arr[i].phone + "</a>\n" +
			                    "</li>\n" +
			                    "                    </ul>\n" +
			                    "                </div>\n" +
			                    "                <div class=\"fabu post-release\">\n" +
			                    "                    <a href=\""+rootPath+"/Newstaff/oi_staff_task_release.html?userId="+id+"\">发任务</a>\n" +
			                    "                </div></a></li>";
			                flag=true;
			            }
			        }
			        if(flag){
			            str1="<li data-group=" + array[k] + " class=\"mui-table-view-divider mui-indexed-list-group\">" + array[k] + "</li>"+str2;
			            str+=str1;
			        }
			    }
			        $(".mui-table-view").empty();
			        $(".mui-table-view").append(str);
			}
			);




			for (var k = 0; k < array.length; k++) {
			    for (var i = 0; i < data.length; i++) {
			        if (data[i].py == array[k]) {

			        }
			    }
			    var letter = [];
			}
			var str ="";
			var str1="";
			for (var k = 0; k < array.length; k++) {
			    var flag=false;
			    var str2="";

			    for (var i = 0; i < data.length; i++) {
			        if (data[i].py == array[k]) { //如果有值
			        	var header="";
			        	if(data[i].face!="" && data[i].face!=null){
			        		header="http://oi.sxfs0351.com/"+data[i].face;
		            	}else{
		            		if(data[i].header!=""){
		            			header=data[i].header;
		            			
		            		}else{
		            			header=rootPath+"/statics/img/person.jpg";
		            		}
		            	}	
		            	var dept_name="";
		            	if(data[i].dept_name=="0" ||data[i].dept_name=="" || data[i].dept_name=="" || data[i].dept_name=="undefined"){
		            		dept_name=data[i].dept_name;
		            	}
		            	
			        	var id=data[i].user_id;
			            str2 +=
			                "<li class='mui-table-view-cell'><a href='"+rootPath+"/staff/getStafferByID.html?id="+id+"' style='display:inline'><div class=\"left\">\n" +
			                "<div class=\"tx\">\n" +
			                "<div class=\"img\">\n" +
			                "<img src=\""+header+"\" alt=\"\" style=\"width: 100%;height: 100%;\">\n" +
			                "</div>\n" +
			                "</div>\n" +
			                "</div>\n" +
			                "<div class=\"right\">\n" +
			                "<ul>\n" +
			                "<li>\n" +
			                "<span class=\"name\">" + data[i].realname + "</span>\n" +
			                "<span>" +dept_name + "</span>\n" +
			                "</li>\n" +
			                "<li>\n" +
			                "<span>工作质量：</span> <span>" + data[i].qualityavg + "</span>\n" +
			                "<span>工作效率：</span> <span>" + data[i].efficiencyavg + "</span>\n" +
			                "</li>\n" +
			                "<li class=\"user_tel\">\n" +
			                "<a href=\"tel:" + data[i].phone + "\">" + data[i].phone + "</a>\n" +
			                "</li>\n" +
			                "                    </ul>\n" +
			                "                </div>\n" +
			                "                <div class=\"fabu post-release\">\n" +
			                "                     <a href=\""+rootPath+"/Newstaff/oi_staff_task_release.html?userId="+id+"\">发任务</a>\n" +
			                "                </div></a></li>";
			            flag=true;
			        }
			    }
			    if(flag){
			        str1="<li data-group=" + array[k] + " class=\"mui-table-view-divider mui-indexed-list-group\">" + array[k] + "</li>"+str2;
			        str+=str1;
			    }
			}
			$(".mui-table-view").append(str);


	        
//			$("#mui-table-view").html(table);
		},
		error : function(data) { //当访问时候，404，500 等非200的错误状态码
			alert("加载公司职员失败");
		}
	});
}