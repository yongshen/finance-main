<!DOCTYPE html>
<html lang="en">
<head>
<#include "./../commons/top.ftl" />
    <link rel="stylesheet" type="text/css" href="${base}/assets/finance/css/signUp.css" />
</head>
<body class="login-page">
<div class="panel panel-default signup-box">
    <div class="panel-bd">
        <div class="panel panel-secondary">
            <div class="panel-hd">系统提示</div>
            <div class="panel-bd">
                <img src="${base}/assets/finance/images/success.jpg" style="width: 100px">
                <span>注册成功！</span>
                <span id="seconds">5</span>
                <span>秒钟后</span>
                <span><a href="${base}/" style="text-decoration:underline">返回登录页</a></span>
            </div>
        </div>
    </div>
</div>
<#include "./../commons/bottom.ftl" />
<script type="text/javascript">
    $(function () {
        setInterval(function () {
            var second = parseInt($("#seconds").html());
            console.log(second);
            if(second > 0) {
                $("#seconds").html(second-1);
            } else {
                location.href = "${base}/";
            }
        }, 1000);
    });

</script>
</body>
</html>