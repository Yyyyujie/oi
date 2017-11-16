if (!picView) {
	var picView = { //图片预览
		picBox : $("#__release_pic_list"),
		picShade : $("#_pic_preview"),
		task_important : $("._task_level"), //任务重要程度
		init : function() {
			this.picListSel();
			this.closeSd();
			this.getImportant();
		},
		picListSel : function() { //点击图片之后的function
			this.picBox.on("click", "li", function(e) {
				e.stopPropagation();
				var _s = $(this);
				var picSrc = picView.getSrc(_s); //获取当前图片的url
				var imgDom = $('<div class="shade_img_preview" style=background-image:url(' + picSrc + ');></div>'); //预览图片
				picView.picShade.fadeIn("fast").html(imgDom);
				console.log(picSrc);
			})
		},
		getSrc : function(elem) { //获取background:url中的链接
			var eSrc = elem.css("background-image");
			var i_start = eSrc.indexOf('('),
				i_end = eSrc.lastIndexOf(')');
			return eSrc.substring(i_start + 1, i_end);
		},
		closeSd : function() { //关闭模态框
			this.picShade.on("click", function(e) {
				e.stopPropagation();
				$(this).fadeOut("fast");
			})
		},
		del_pic : function(setting) { //删除图片
			this.picBox.on("click", ".delete", function(e) {
				e.stopPropagation();
				var _s = $(this);
				var imgId = _s.parent().attr("img_id"); //获取要删除的图片ID
				if (setting.type === "useAjax") { //如果使用ajax方法删除
					kAlert({
						title : "确定删除吗？",
						subtitle : "sure to delete？",
						btns : [ "确定", "取消" ]
					}, function() {
						$.ajax({
							type : "post",
							url : setting.url,
							data : {
								imgId : imgId
							},
							success : function() {
								var str = id.replace(imgId + ",", '');
								imgIdHidden.val(str);
								_s.parent().remove();
							},
							error : function() {
								kAlert({
									title : "删除失败",
									subtitle : "Failed",
									btns : [ "关闭" ]
								})
							}
						})
					})
				} else if (setting.type === "offline") { //如果使用提交表单最终才删除
					var imgIdHidden = $("#imgs_array"),
						id = imgStr.toString(),
					idCount=id.split(",");
					console.log(idCount);
					kAlert({
						title : "确定删除吗？",
						subtitle : "sure to delete？",
						btns : [ "确定", "取消" ]
					}, function() {
						console.log(id);
						imgStr = idCount.length>1?id.replace(imgId+",", ''):id.replace(imgId,'');
						imgIdHidden.val(imgStr.slice(0, -1));
						_s.parent().remove();
					})
				}
			})
		},
		getImportant : function() { //获取任务紧急状态
			var status = this.task_important;
			var im_status = status.find("#sel_important").val(), //重要程度
				ur_status = status.find("#sel_urgency").val(); //紧急程度

			if (im_status == 1) {
				status.find("[data-target='sel_important']").removeClass('_default');
			}
			if (ur_status == 1) {
				status.find("[data-target='sel_urgency']").removeClass('_default');
			}
		}
	}
}