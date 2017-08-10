<!DOCTYPE html>
<html lang="en">
<head>
<#include "commons/top.ftl" />
    <link rel="stylesheet" type="text/css" href="${base}/assets/finance/slider/jquery.slider.css" />
    <link rel="stylesheet" type="text/css" href="${base}/assets/finance/slider/style.css" />
</head>
<body class="login-page">
<section class="login-contain">
    <header>
        <h1>记账系统</h1>
        <p>keep accounts system</p>
    </header>
    <div class="form-content">
        <div style="text-align: center;line-height: 5px;height: 20px;color: red;font-size: 17px;">
            ${SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
        <form action="${base}/login" method="post">
            <ul>
                <li>
                    <div class="form-group">
                        <label class="control-label">账&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
                        <input type="text" placeholder="账号" class="form-control form-underlined" name="username" id="username" required/>
                    </div>
                </li>
                <li>
                    <div class="form-group">
                        <label class="control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                        <input type="password" placeholder="密码" class="form-control form-underlined" name="password" id="password" required/>
                    </div>
                </li>
                <li>
                    <div class="form-group container">
                        <div class="demo">
                            <div id="slider" class="slider"></div>
                            <input id="result" type="hidden" value="">
                        </div>
                    </div>
                </li>
                <li>
                    <label class="check-box">
                        <input type="checkbox" name="remember"/>
                        <span>记住账号密码</span>
                    </label>
                </li>
                <li>
                    <button type="submit" class="btn btn-lg btn-block btn-primary" id="entry">立即登录</button>
                </li>
                <li>
                    <div>
                        <div class="fl"><a href="javascript:;">忘记密码</a></div>
                        <div class="fr"><a href="${base}/to/signUp">注册账号</a> </div>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</section>
<div class="mask"></div>
<div class="dialog">
    <div class="dialog-hd">
        <strong class="lt-title">标题</strong>
        <a class="rt-operate icon-remove JclosePanel" title="关闭"></a>
    </div>
    <div class="dialog-bd">
        <p></p>
    </div>
    <div class="dialog-ft">
        <button class="btn btn-info JyesBtn">确认</button>
        <button class="btn btn-secondary JnoBtn">关闭</button>
    </div>
</div>
<script src="${base}/assets/finance/js/jquery.js"></script>
<script src="${base}/assets/finance/slider/jquery.slider.min.js"></script>
<script src="${base}/assets/finance/js/public.js"></script>
<script type="text/javascript">
    $(function () {
        $('#entry').click(function(){
            if($('#username').val()==''){
                $('.mask,.dialog').show();
                $('.dialog .dialog-bd p').html('请输入您的账号');
                return false;
            }else if($('#password').val()==''){
                $('.mask,.dialog').show();
                $('.dialog .dialog-bd p').html('请输入您的密码');
                return false;
            }else if($("#result").val() != "true"){
                $('.mask,.dialog').show();
                $('.dialog .dialog-bd p').html('请滑动完成验证');
                return false;
            }else {
                $('.mask,.dialog').hide();
                return true;
            }
        });
        $("#slider").slider({
            callback: function(result) {
                $("#result").val(result);
            }
        });
    });

</script>
</body>
</html>