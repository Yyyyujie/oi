jQuery(function() {
	$.ajax({ //初始化树形列表数据
		url : "Admin//gettypelist.do",
		dataType : "json",
		success : function(data) {
			//console.log(data);
			var zTreeObj;
			var setting = {
				view : {
					dblClickExpand : false,
					showLine : false,
					addHoverDom : addHoverDom,
					removeHoverDom : removeHoverDom
				},
				edit : {
					enable : true
				},
				check : {
					enable : true
				},
				data : {
					key : {
						name : "type_name",
					},
					simpleData : {
						enable: true,
						idKey: "type_id",
						pIdKey: "pid",
						rootPId: 0
					}
				},
				callback : {
					beforeEditName : editTreeNode,
					onRemove : removeNode
				}
			};
			zTreeObj = $.fn.zTree.init($("#oi_admin_typeTree"), setting, data);
			var treeObj = $.fn.zTree.getZTreeObj("oi_admin_typeTree");
			$("#collapseBtn").click(function() { //收束全部按钮
				console.log(treeObj);
				treeObj.expandAll(false);
			});
			$("#unfoldBtn").click(function() { //展开全部按钮
				console.log(treeObj);
				treeObj.expandAll(true);
			});
			$("#addTableBtn").click(function() { //添加节点按钮
				//console.log(treeObj);
				layerContent("添加", "Admin/oi_admin_en_typeTree_edit.html?type=add");
			})
		},
		error:function(){
			alert('添加失败');
		}
	});

});
function addHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span"); //获取节点信息
	if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;

	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='add node' onfocus='this.blur();'></span>"; //定义添加按钮
	sObj.after(addStr); //加载添加按钮
	var btn = $("#addBtn_" + treeNode.tId);
	//绑定添加事件，并定义添加操作
	if (btn) btn.bind("click", function() {
		console.log("以下是添加部分：");
		console.log(treeNode)
			//将新节点添加到数据库中
			var id = treeNode.type_id; //表当前行的id
			layerContent("添加", "Admin/oi_admin_en_typeTree_edit.html?type=add&type_id=" + id);
		});
	return false
}
;
function removeHoverDom(treeId, treeNode) {
	$("#addBtn_" + treeNode.tId).unbind().remove();
}
;
function layerContent(title, template) {
	parent.layer.open({
		type : 2,
		title : title,
		shadeClose : true,
		shade : false,
		//maxmin: true, //开启最大化最小化按钮
		area : [ '900px', '500px' ],
		content : template
	});
}
function removeNode(treeId, treeNode, row) {
	var tid = row.type_id;
	console.log("以下是删除部分：");
	console.log(row)
	layer.confirm("确定删除吗？", function() {
		if (tid != undefined && tid !== "" && tid !== null) {
			layer.closeAll();
			$.ajax({
				type : "post",
				url : "Admin/removetype.do/"+tid,
				success : function(msg) {
					if(msg.code){
						layer.alert("删除成功");
					}
				},
				error : function(msg) {
					layer.alert("删除失败！请检查网络")
				}
			})
		} else {
			layer.alert("不能为空的ID");
		}
	})
}
/*function clickBtn(e,treeId,treeNode){ //点击节点对应的一系列数据
    console.log(e,treeId,treeNode);
}*/
function editTreeNode(treeId, treeNode) { //点击节点对应的一系列数据
console.log("以下是修改部分：")
console.log(treeNode);
	layerContent("编辑", "Admin/oi_admin_en_typeTree_edit.html?type=edit&type_id=" + treeNode.type_id);
	return false
}