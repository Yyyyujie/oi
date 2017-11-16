jQuery(function () {
  $.ajax({ //初始化树形列表数据
    url: "Admin/getrule.do",
    dataType:"json",
    success: function (data) {
      console.log(data);
      var zTreeObj;
      var setting = {
        view: {
          dblClickExpand: false,
          showLine: false
        },
        check: {
          enable: true
        },
        data: {
          key: {
            name: "title",
          },
          simpleData: {
            enable: true,
            idKey:'r_id',
            pIdKey:'pid'
          }
        }
      };
      zTreeObj = $.fn.zTree.init($("#oi_admin_tree_char"), setting, data);
      var treeObj = $.fn.zTree.getZTreeObj("oi_admin_tree_char");
      treeObj.expandAll(true);
      $("#collapseBtn").click(function () { //收束全部按钮
        console.log(treeObj);
        treeObj.expandAll(false);
      });
      $("#unfoldBtn").click(function () {   //展开全部按钮
        console.log(treeObj);
        treeObj.expandAll(true);
      });
      $("#charSaveBtn").click(function () {   //保存当前角色的权限\
        var formData=$("#oi_ad_char_edite").serialize();
        var dataArray="";
        var chkNodes=treeObj.getCheckedNodes(true);  //获取被选中的节点集合
        if(chkNodes.length>0){ //当有节点被选中时，则输出被选中的节点
          for(var i=0;i<chkNodes.length;i++){
            dataArray+=chkNodes[i].r_id+",";
          }
          formData+="&rules="+dataArray.slice(0,-1);
          console.log(formData);
          $.ajax({
            type:"post",
            data:formData,
            url:"Admin/addrole.do",
            dataType:"json",
            success:function(msg){
            	if(msg.code==100){
              parent.layer.closeAll();
            	}
            },
            error:function(msg){
              parent.layer.alert("保存失败！请检查检查网络")
            }
          })
        }
      })
    }
  });

});
function layerContent(title, template) {
  layer.open({
    type: 2,
    title: title,
    shadeClose: true,
    shade: false,
    //maxmin: true, //开启最大化最小化按钮
    area: ['900px', '500px'],
    content: template
  });
}
/*function chk(treeId,treeNode,row){
  var flag=row.checked;
  console.log(flag);
  console.log(row);
  /!*
    判断当前节点的选中状态，如果取消选中——即checked状态为false
    把当前节点，如果有子节点的话就把当前和子节点的id一并传过去
  * *!/
}*/