var imgStr = "";
$(function () {
  var $ = jQuery, $list = $('._task_imgs'), uploader;
  var url = document.getElementById("url").value,imgArray = $("#imgs_array");
  var applicationPath = window.applicationPath === "" ? "" : window.applicationPath || "../../";
  $(function () {

    uploader = WebUploader.create({
      // 选完文件后，是否自动上传。
      auto: true,

      disableGlobalDnd: true,
      // swf文件路径
      swf: applicationPath + '/statics/js/plugins/webuploader/Uploader.swf',

      // 文件接收服务端。
      server: url,

      // 选择文件的按钮。可选。
      // 内部根据当前运行是创建，可能是input元素，也可能是flash.
      pick: '#filePicker',

      //只允许选择图片
      accept: {
        title: 'Images',
        extensions: 'gif,jpg,jpeg,bmp,png',
        mimeTypes: 'image/*'
      },
      compress: {
        width: 1600,
        height: 1600,

        // 图片质量，只有type为`image/jpeg`的时候才有效。
        quality: 90,

        // 是否允许放大，如果想要生成小图的时候不失真，此选项应该设置为false.
        allowMagnify: false,

        // 是否允许裁剪。
        crop: false,

        // 是否保留头部meta信息。
        preserveHeaders: true,

        // 如果发现压缩后文件大小比原来还大，则使用原来图片
        // 此属性可能会影响图片自动纠正功能
        noCompressIfLarger: false,

        // 单位字节，如果图片大小小于此值，不会采用压缩。
        compressSize: 0
      },
      thumb: {
        width: 1600,
        height: 1600,
        // 图片质量，只有type为`image/jpeg`的时候才有效。
        quality: 70,

        // 是否允许放大，如果想要生成小图的时候不失真，此选项应该设置为false.
        allowMagnify: true,
        // 是否允许裁剪。
        crop: false,
        // 为空的话则保留原有图片格式。
        // 否则强制转换成指定的类型。
        type: 'image/jpeg'
      },
      resize: false
    });
    // 当有文件添加进来的时候
    uploader.on('fileQueued', function (file) {
      var $li = $('<li id="' + file.id + '"><span class="delete"></span></li>');
      // $list为容器jQuery实例
      $list.append($li);
      // 创建缩略图
      // 如果为非图片文件，可以不用调用此方法。
      // thumbnailWidth x thumbnailHeight 为 100 x 100
      uploader.makeThumb(file, function (error, src) {
        if (error) {
          $li.replaceWith('<span>不能预览</span>');
          return;
        }
        console.log($li);
        $li.css({
          backgroundImage: "url(" + src + ")"
        });
      });
    });
    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on('uploadSuccess', function (file, response) {
    	uploader.removeFile(file);
      $('#' + file.id).addClass('upload-state-done');
      //将上传的url保存到数组
      /*PhotoUrlArray.push(new PhotoUrl(response.id, response.filePath));*/
      imgStr += response.extend.img_id + ",";
      imgArray.val(imgStr.slice(0, -1)) //将图片ID打进隐藏域c
      $('#' + file.id).attr('img_id', response.extend.img_id);
    });

    // 文件上传失败，显示上传出错。
    uploader.on('uploadError', function (file) {
      var $li = $('#' + file.id),
        $error = $li.find('span.error');
      // 避免重复创建
      if (!$error.length) {
        $error = $('<span class="error"></span>').appendTo($li);
      }
    });

    // 完成上传完了，成功或者失败，先删除进度条。
    uploader.on('uploadComplete', function (file) {
      $('#' + file.id).find('.progress').remove();
    });
    //所有文件上传完毕
    /*uploader.on("uploadFinished", function ()
     {
     });*///显示删除按钮
    /*$(".cp_img").delegate("mouseover", function ()
     {
     $(this).children(".cp_img_jian").css('display', 'block');

     });
     //隐藏删除按钮
     $(".cp_img").delegate("mouseout", function () {
     $(this).children(".cp_img_jian").css('display', 'none');
     });*/
  });
})