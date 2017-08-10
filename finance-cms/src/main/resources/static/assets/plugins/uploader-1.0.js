function FDLMUploader(option){
	
	var config = option || {};
	
	var baseUrl = config.baseUrl || "";	//	默认地址URL
	var imgUrl = config.imgUrl || "";	//	图片地址URL
	var swf = config.swf || "";			//	swf路径
	var uploadMethod = config.uploadMethod || "files/ajax_upload";	//	上传方法
	var checkMethod = config.checkMethod || "files/ajax_check";	//	校验方法
	var max = config.max || 1024;	//	最大文件数
	var imgsName = config.imgsName || "upload_imgs";	//	默认文件名称
	var onFileMoreThenMax = option.onFileMoreThenMax || function(){};	//	超过最大文件限制
	
	
	
	function append_file(src){
		if ($(".upload-item").size() >= max) {onFileMoreThenMax();return;}
		
		
		var imgSrc = imgUrl + '/' +  src;
		
    	var fileId = "file_" + new Date().getTime();
    	var $item = $('<div class="upload-item" id="'+fileId+'"><div class="upload-div-img"><img src="'+imgSrc+'"></div><div class="upload-div-panel"><span class="cancel">删除</span><span class="next">后移</span><span class="prev">前移</span><input type="hidden" name="'+imgsName+'" value="'+src+'"></div></div>');
		$(".upload-content").children(".upload-btns").before($item);
		
		$("#" + fileId).on( 'mouseenter', function() {
			$(this).children(".upload-div-panel").stop().animate({height: 30});
        }).on( 'mouseleave', function() {
            $(this).children(".upload-div-panel").stop().animate({height: 0});
        });
        
        $("#" + fileId).find(".cancel").click(function(){
        	$item.remove();
        	if ($(".upload-item").size() < max) {
				$(".upload-btns").show();
			}
        });
        $("#" + fileId).find(".next").click(function(){
			if ($item.next(".upload-item").attr("id") != null ) {
				$item.insertAfter($item.next(".upload-item"));
			}
        });
        $("#" + fileId).find(".prev").click(function(){
			if ($item.prev(".upload-item").attr("id") != null ) {
				$item.insertBefore($item.prev(".upload-item"));
			}
        });
        
        if ($(".upload-item").size() >= max) {
			$(".upload-btns").hide();
		}
        
	}
	
	
	var webuploader = WebUploader.create({
	    swf: baseUrl + swf,
	    server: baseUrl + uploadMethod,
	    pick: {id: '.upload-btn'},
	    compress : false,
	     accept: {
		  //title: 'Images',
		  extensions: 'jpg,jpeg,png',
		  mimeTypes: 'image/jpg,image/jpeg,image/png'   //修改这行
		},
	    resize: false
	});
	
	// 当有文件被添加进队列的时候
	webuploader.on( 'fileQueued', function( file ) {
		webuploader.md5File( file ).then(function(val) {
            FDLM.fdlm_ajax_jsondata(baseUrl + checkMethod , {md5:val} , function(result){
            	if(result.data[val] != null){
            		append_file(result.data[val]);
            		webuploader.reset();
            	}else if (result.code == 1) {
            		webuploader.upload();
				}else{
					FDLM.fdlm_alert('上传失败,请检查网络,稍后再试');
					webuploader.reset();
				}
            	
            });
        });
	});
	
	webuploader.on( 'uploadStart', function( file ) {
		$(".upload-progress").show();
	});
	
	// 文件上传过程中创建进度条实时显示。
	webuploader.on( 'uploadProgress', function( file, percentage ) {
		$(".upload-progress").html(percentage * 100 + '%');
	});
	
	webuploader.on( 'uploadError', function( file ) {
		FDLM.fdlm_alert('上传失败,请检查网络,稍后再试');
	});
	
	webuploader.on('uploadSuccess', function(file ,resp){
		webuploader.md5File( file ).then(function(val) {
			var result = resp;
    		append_file(result.data[val]);
    		webuploader.reset();
        });
	});
	
	webuploader.on( 'uploadComplete', function( file ) {
		$(".upload-progress").hide();
	});
	
	return {
		testConfig : function(){
			
		},
		getFileSize : function(){
			return $(".upload-item").size();
		},
		preview : function(imgs){
			imgs = imgs || [];
			for (var i = 0; i < imgs.length; i++) {
				append_file(imgs[i]);
			}
		}
	};
}