jQuery(function(){
    /*时间选择*/
    $("#datetime-picker").datetimePicker();
    /*任务进度条*/
    $('#oi_sf_tsk_progress').slider(function (percent) {
        console.log(percent)
    });
    /*任务进度条结束*/
    questTo();
});
//部门成员加载
function questTo(){
    var html="";
    $.ajax({
    	type:'post',
        url:"staff/oi_sf_branch.json",
        success:function(obj){
            console.log(obj);
            for(var i=0;i<obj.length;i++){
                var objL=obj[i];
                html+=`<option value="${objL.dept_id}">${objL.dept_name}</option>`;
            }
            $("#st_publicTo").find("#select1").html(html);
        }
    });
    $("#st_publicTo").on("change","#select1",function(){
        var html1="";
        var _self=$(this);
        var selData=_self.val();
        $.ajax({
            type:'post',
            url:"staff/oi_sf_branch_staff.json?selData="+selData,
            data:{data:selData},
            success:function(msg){
                $.each(msg,function(index,value){
                    html1+=`<option value="${value.user_id}">${value.realname}</option>`
                });
                $("#st_publicTo").find("#select2").html(html1);
            }
        })
    })
}