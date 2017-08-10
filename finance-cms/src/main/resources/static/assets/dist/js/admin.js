(function($) {
    'use strict';

    // ajax请求
    function wt_ajax_form(urlString, formId, success, failure) {
        $.ajax({
            url : urlString,
            data : $("#" + formId).serialize(),
            type : 'post',
            cache : false,
            dataType : 'json',
            success : function(data) {
                if (data.code == 0) { // 成功
                    if (success) {
                        success(data);
                    }
                } else {
                    if (failure) {
                        failure(data);
                    } else if (data.code == 1) { // 失败
                        layer.msg(data.msg);
                    } else if (data.code == 2) { // 失败
                        layer.msg(data.msg);
                    } else if (data.code == 1000) { // 未登录
                        layer.msg("请先登录");
                    } else { // 其他异常
                        layer.msg(data.msg);
                    }
                }
            },
            error : function(data) {
                if (failure) {
                    failure(data);
                }
            }
        });
    }

    // ajax请求
    function wt_ajax_formdata(urlString, formData, success, failure) {
        wt_ajax_formdata_any(urlString, formData, success, failure, 'post');
    }
    // ajax请求
    function wt_ajax_formdata_get(urlString, formData, success, failure) {
        wt_ajax_formdata_any(urlString, formData, success, failure, 'get');
    }

    // ajax请求
    function wt_ajax_formdata_any(urlString, formData, success, failure , method) {
        var layerIndex = layer.load(0);
        $.ajax({
            url : urlString,
            data : formData,
            type : method,
            cache : false,
            dataType : 'json',
            success : function(data) {
                if (data.code == 0) { // 成功
                    if (success) {
                        success(data);
                    }
                    setTimeout(function() {
                        layer.close(layerIndex);
                    }, 500);
                } else {
                    if (failure) {
                        failure(data);
                    } else if (data.code == 1) { // 失败
                        layer.close(layerIndex);
                        layer.msg(data.msg);
                    } else if (data.code == 2) { // 失败
                        layer.close(layerIndex);
                        layer.msg(data.msg);
                    } else if (data.code == 1000) { // 未登录
                        layer.close(layerIndex);
                        layer.msg("请先登录");
                    } else { // 其他异常
                        layer.msg(data.msg);
                    }
                    setTimeout(function() {
                        layer.close(layerIndex);
                    }, 1000);
                }
            },
            error : function(data) {
                setTimeout(function() {
                    layer.close(layerIndex);
                }, 1000);
            }
        });
    }

    // ajax请求
    function wt_ajax_jsondata(urlString, jsonData, success, failure) {
        $.ajax({
            url : urlString,
            data : jsonData,
            type : 'post',
            cache : false,
            dataType : 'json',
            success : function(data) {
                if (data.code == 0) { // 成功
                    if (success) {
                        success(data);
                    }
                } else {
                    if (failure) {
                        failure(data);
                    } else if (data.code == 1) { // 失败
                        layer.msg(data.msg);
                    } else if (data.code == 2) { // 失败
                        layer.msg(data.msg);
                    } else if (data.code == 1000) { // 未登录
                        layer.msg("请先登录");
                    } else { // 其他异常
                        layer.msg(data.msg);
                    }
                }
            },
            error : function(data) {
                if (failure) {
                    failure(data);
                }
            }
        });
    }

    function wt_ajax_jsondata_method(options){
        var opt_urlString = options.urlString;
        var opt_jsonData = options.jsonData;
        var opt_success = options.success;
        var opt_failure = options.failure;
        var delay = options.delay || 0;
        var opt_method = options.method || "POST";

        $.ajax({
            url : opt_urlString,
            data : opt_jsonData,
            type : opt_method,
            cache : false,
            dataType : 'json',
            success : function(data) {
                if (data.code == 0) { // 成功
                    if (opt_success) {
                        setTimeout(opt_success(data), delay);
                    }
                } else {
                    if (opt_failure) {
                        setTimeout(opt_failure(data), delay);
                    } else if (data.code == 1) { // 失败
                        layer.msg(data.msg);
                    } else if (data.code == 2) { // 失败
                        layer.msg(data.msg);
                    } else if (data.code == 1000) { // 未登录
                        layer.msg("请先登录");
                    } else { // 其他异常
                        layer.msg(data.msg);
                    }
                }
            },
            error : function(data) {
                if (opt_failure) {
                    setTimeout(opt_failure(data), delay);
                }
            }
        });
    }

    //	去掉字符串前后的空格
    function wt_trim(str){
        return str.replace(/(^\s*)|(\s*$)/g, '');
    };


    var reg_cn = /[\u4e00-\u9fa5]/;
    var reg_id_card = /(^\d{15}$)|(^\d{17}([0-9]|X|x)$)/;
    var reg_mobile =  /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    var reg_restaurant_name = /[\u4e00-\u9fa5a-zA-Z0-9_]{4,15}$/;
    var reg_password = /[a-zA-Z0-9_]{4,18}$/;
    var reg_email = /^[0-9\w\_\-\.]+@[\w\-\.]+(\.\w+)+$/;
    var reg_username = /[a-zA-Z0-9_]{4,15}$/;

    function wt_is_email(email){
        if (reg_email.test(email)){
            return true;
        }
        return false;
    }

    function wt_is_mobile(mobile){
        if (reg_mobile.test(mobile)){
            return true;
        }
        return false;
    }
    //	判断是否为空
    function wt_is_empty(str){
        return (str == null || wt_trim(str).length <= 0);
    }

    //	弹出警告框
    function wt_alert(content,func) {
        layer.alert(content,{scrollbar: false},func);
    }

    //	询问框
    function wt_confirm(title,doneFunc,cancelFunc){
        layer.confirm( title, {
            btn: ['确定','取消'] //按钮
        }, function(index){
            if (doneFunc != null) {
                doneFunc();
            }
            layer.close(index);
        }, function(){
            if (cancelFunc != null) {
                cancelFunc();
            }
        });
    }

    //	关闭弹出曾
    function wt_close() {
        parent.layer.close(parent.layer.getFrameIndex(window.name));
    }

    function wt_serializeJSONObject(formId){
        var formData = $("#" + formId ).serializeArray();
        var formJSON = new Object();
        for (var index = 0; index < formData.length; index++) {
            var item = formData[index];
            var name = item.name;
            var value = item.value;

            formJSON[name] = value;
        }
        return formJSON;
    }

    function wt_open_layer(url,params,title){
        title = title || "详情";
        layer.open({
            type: 2,
            title: title,
            shadeClose: false,
            shade: 0.8,
            scrollbar:false,
            area: ['80%', '80%'],
            content: getUrl(url, params)
        });
    }    
    
    function wt_open_layer_set(url,params,title,width,height){
        title = title || "详情";
        layer.open({
            type: 2,
            title: title,
            shadeClose: false,
            shade: 0.8,
            scrollbar:false,
            area: [width, height],
            content: getUrl(url, params)
        });
    }  

    function wt_open_fullscreen(url,params,title){
        title = title || "详情";
        var index = layer.open({
            type: 2,
            title: title,
            shadeClose: false,
            shade: 0.8,
            scrollbar:false,
            area: ['80%', '70%'],
            content: url
        });
        layer.full(index);
    }


    function wt_format_publish(cellvalue, options, rowObject) {
        if (cellvalue == 1) {
            return "<font style=\"color:#1ab394;font-weight: bold;\">启用</font>";
        } else if (cellvalue == 0) {
            return "<font style=\"color:#ed5565;font-weight: bold;\">停用</font>";
        } else {
            return "-";
        }
    }

    function wt_jqtable(urlString, colNames, colModels, serialzeFormData){
        if (serialzeFormData == null)
            serialzeFormData = WT.wt_serializeJSONObject("frameForm");
        wt_jqtable_params(urlString, colNames, colModels, {}, serialzeFormData);
    }

    function wt_jqtable_multi(urlString, colNames, colModels, serialzeFormData){
        if (serialzeFormData == null)
            serialzeFormData = WT.wt_serializeJSONObject("frameForm");
        wt_jqtable_params(urlString, colNames, colModels, {multiselect: true}, serialzeFormData);
    }
    function wt_jqtable_radio(urlString, colNames, colModels, serialzeFormData){
        if (serialzeFormData == null)
            serialzeFormData = WT.wt_serializeJSONObject("frameForm");
        wt_jqtable_params(urlString, colNames, colModels, {multiselect: true,multiboxonly:true,beforeSelectRow:radioSelectRow}, serialzeFormData);
    }
    function wt_jqtable_schoolradio(urlString, colNames, colModels, serialzeFormData){
        if (serialzeFormData == null)
            serialzeFormData = WT.wt_serializeJSONObject("frameForm");
        wt_jqtable_params(urlString, colNames, colModels, {multiselect: true,multiboxonly:true,beforeSelectRow:radioSelectRow,gridComplete:hidetitle}, serialzeFormData);
    }
    function hidetitle(){
    	$(this).closest('.ui-jqgrid-view').find('div.ui-jqgrid-hdiv').remove();    	
    }
    function wt_jqtable_params(urlString, colNames, colModels, params, serialzeFormData){
        params = $.extend({
            postData: serialzeFormData,
            url: urlString,
            colNames: colNames,
            colModel: colModels,
            mtype : 'POST',
            datatype: "json",
            pager: "#pager_list",
            height: 500,
            autowidth: true,
            shrinkToFit: true,
            rowNum: 20,
            rowList: [20, 50, 100],
            viewrecords: true,
            multiselect: false,
            rownumbers: true
        }, params);
        $("#table_list").jqGrid(params);
    }
    function radioSelectRow()  
    {  
        $("#table_list").jqGrid('resetSelection');
        return(true);  
    }

    function wt_reload_jqtable(owner, tableId){
        tableId = tableId || "table_list";
        owner.$("#" + tableId).trigger('reloadGrid');
    }
    function go_url(url, datas){
        window.location.href = getUrl(url, datas);
    }

    function getUrl(url, datas) {
        datas = eval(datas);
        var dataStr = "";
        var flag = 0;
        for(var data in datas){
            dataStr += ((flag===0?"?":"&") + data + "=" + datas[data]);
            flag++;
        }
        return url + dataStr;
    }

    window['WT'] = window['WT'] || {};
    window['WT']['wt_ajax_form'] = wt_ajax_form;
    window['WT']['wt_ajax_formdata'] = wt_ajax_formdata;
    window['WT']['wt_ajax_formdata_get'] = wt_ajax_formdata_get;
    window['WT']['wt_ajax_jsondata'] = wt_ajax_jsondata;
    window['WT']['wt_ajax_jsondata_method'] = wt_ajax_jsondata_method;
    window['WT']['wt_is_empty'] = wt_is_empty;

    window['WT']['wt_alert'] = wt_alert;
    window['WT']['wt_confirm'] = wt_confirm;
    window['WT']['wt_close'] = wt_close;
    window['WT']['wt_serializeJSONObject'] = wt_serializeJSONObject;
    window['WT']['wt_open_layer'] = wt_open_layer;    
    window['WT']['wt_open_layer_set'] = wt_open_layer_set;
    window['WT']['wt_open_fullscreen'] = wt_open_fullscreen;


    window['WT']['wt_format_publish'] = wt_format_publish;
    window['WT']['wt_is_email'] = wt_is_email;
    window['WT']['wt_is_mobile'] = wt_is_mobile;
    window['WT']['wt_jqtable'] = wt_jqtable;
    window['WT']['wt_jqtable_multi'] = wt_jqtable_multi;
    window['WT']['wt_jqtable_radio'] = wt_jqtable_radio;
    window['WT']['wt_jqtable_schoolradio'] = wt_jqtable_schoolradio;    
    window['WT']['wt_reload_jqtable'] = wt_reload_jqtable;
    window['WT']['go_url'] = go_url;

})(jQuery);
