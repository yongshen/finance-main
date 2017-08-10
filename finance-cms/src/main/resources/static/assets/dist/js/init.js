/**
 * AdminLTE Demo Menu
 * ------------------
 * You should not use this file in production.
 * This file is for demo purposes only.
 */
$(function () {
    "use strict";

    $("select").each(function () {
        var autoVal = $(this).attr("data-wt-auto");
       if(autoVal != null){
           $(this).val(autoVal);
       }
    });


    $("form").validate({
        errorPlacement: function(error, element) {
            error.insertBefore( element);
        },
        errorClass : "validate-error"
    });

});
