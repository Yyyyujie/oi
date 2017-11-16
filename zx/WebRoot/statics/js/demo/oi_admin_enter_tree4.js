jQuery(function () {
  /*获取隐藏域的值 ______角色ID*/
  if($("#or_id").val()!=undefined || $("#or_id").val()!=null || $("#or_id").val()!=""){
    var charId=$("#or_id").val();
  }
  var nameIn=$("#char_Name_edit"),statusSel=$("#char_status_edit");
  $.ajax({ //初始化树形列表数据
    type:'post',
    url: "Admin/getroleandrule/"+charId,
    dataType: "json",
    async:true,
    success: function (data) {
      console.log(data);
      nameIn.val(data[0].name); //放置角色名称在对应的input元素中
      statusSel.val(data[0].status);
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
            children: "nodes"
          },
          simpleData: {
            enable: true,
            idKey: 'r_id',
            pIdKey: 'pid'
          }
        },
        callback:{
          onClick:chk
        }
      };
      zTreeObj = $.fn.zTree.init($("#oi_admin_tree_char"), setting, data[1]);
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
        var formData = $("#oi_ad_char_edite").serialize();
        var dataArray = "";
        var chkNodes = treeObj.getCheckedNodes(true);  //获取被选中的节点集合
        if (chkNodes.length > 0) { //当有节点被选中时，则输出被选中的节点
          for (var i = 0; i < chkNodes.length; i++) {
            dataArray += chkNodes[i].r_id + ",";
          }
          formData+="&rules="+dataArray.slice(0,-1);
          console.log(formData);
          $.ajax({
            type: "post",
            data:formData,
            url:"Admin/updaterole.do",
            dataType: "json",
            success: function (msg) {
            	if(msg.code==100){
                    parent.layer.closeAll();
                  	}
            },
            error: function (msg) {
              parent.layer.alert("保存失败！请检查检查网络")
            }
          })
        }
      });
      /*获取json中被选择的ID，然后找到对应ID的多选框，然后让其选中*/
      for(var i=0;i<data[0].rule.length;i++){
        var value=data[0].rule[i];
       var node = treeObj.getNodeByParam("r_id",value);
        if(node){  //如果不为空
          console.log(node);
          treeObj.checkNode(node,true);//指定选中ID的节点
        }
      }
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
function chk(treeId,treeNode,row){
 var flag=row.checked;
 console.log(flag);
 console.log(row);
 }