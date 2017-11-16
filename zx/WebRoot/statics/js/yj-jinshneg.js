$(function(){
	var uid=$("#useID").val();
	var pid=$("#promotionId").val();
	var endTime=$("#endTime").val();
	var isVote=$("#isVote").val();
	var day=$("#day").val();
	if(isVote=='no'){
		$("button").css("background","#e3e3e3");
		$("button").attr("disabled",true);
	}	
	if(day=='已过期'){
		$("button").css("background","#e3e3e3");
		$("button").attr("disabled",true);
	}
$(".ok").click(function () {
	
    $.ajax({
        url:"insertCompanyPromotion.do",
        type:"post",
        data:{vote:1,uid:uid,pid:pid,endTime:endTime},
        success:function (e) {
        		if(e=="成功"){
        			$("button").css("background","#e3e3e3");
            		$("button").attr("disabled",true);
            		alert("投票成功");
        		}else{
        			alert("失败");
        		}
        		
                
        },
        error:function () {
        	alert("投票失败");
        }

    });
});

$(".no").click(function () {
    $.ajax({
        url:"insertCompanyPromotion.do",
        type:"post",
        data:{vote:-1,uid:uid,pid:pid,endTime:endTime},
        success:function (e) {
        	if(e=="成功"){
    			$("button").css("background","#e3e3e3");
        		$("button").attr("disabled",true);
        		alert("投票成功");
    		}else{
    			alert(e);
    		}
        },
        error:function () {
        	alert("投票失败，请重新投票");
        }

    });
});
$(".wait").click(function () {
    $.ajax({
        url:"insertCompanyPromotion.do",
        type:"post",
        data:{vote:0,uid:uid,pid:pid,endTime:endTime},
        success:function (e) {
        	if(e=="成功"){
    			$("button").css("background","#e3e3e3");
        		$("button").attr("disabled",true);
        		alert("投票成功");
    		}else{
    			alert(e);
    		}
        },
        error:function () {
            alert("投票失败，请重新投票");
        }
    });
});
})
