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
                <div class="panel-hd">注册账号</div>
                <div class="panel-bd">
                    <form id="signForm" action="" method="post">
                    <div class="form-group-col-2">
                        <div class="form-label">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</div>
                        <div class="form-cont">
                            <input type="text" id="account" name="account" placeholder="请输入您的账号" class="form-control form-boxed">
                        </div>
                    </div>
                    <div class="form-group-col-2">
                        <div class="form-label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</div>
                        <div class="form-cont">
                            <input type="text" id="userEmail" name="userEmail" placeholder="请输入您的邮箱" class="form-control form-boxed">
                        </div>
                    </div>
                    <div class="form-group-col-2">
                        <div class="form-label">性别：</div>
                        <div class="form-cont">
                            <label class="radio">
                                <input type="radio" name="userGender" value="M" checked="checked"/>
                                <span>男士</span>
                            </label>
                            <label class="radio">
                                <input type="radio" name="userGender" value="F"/>
                                <span>女士</span>
                            </label>
                            <label class="radio">
                                <input type="radio" name="userGender" value="N"/>
                                <span>保密</span>
                            </label>
                        </div>
                    </div>
                    <div class="form-group-col-2">
                        <div class="form-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</div>
                        <div class="form-cont">
                            <input type="password" id="password" name="password" placeholder="请输入您的密码" class="form-control form-boxed">
                        </div>
                    </div>
                    <div class="form-group-col-2">
                        <div class="form-label">确认密码：</div>
                        <div class="form-cont">
                            <input type="password" id="rePassword" name="rePassword" placeholder="请再次输入您的密码" class="form-control form-boxed">
                        </div>
                    </div>
                    <div class="form-group-col-2">
                        <div class="form-cont signDiv" style="margin-left: 0;">
                            <input id="doSignUser" type="button" class="btn btn-default" value="立即注册" />
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
<#include "./../commons/bottom.ftl" />
<script type="text/javascript">
    $(function () {
        $("#doSignUser").click(function () {
            var accountPattern = /[A-Za-z0-9_]{6,20}/g;
            var emailPattern = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
            var passwordPattern = /\S{6,16}/g;
            var account = $("#account").val();
            if(!account) {
                layer.alert("请输入您的账号");
                return;
            }
            if(!accountPattern.test(account)) {
                layer.alert("账号只能是6-20位数字、字母、下划线组成");
                return;
            }
            var email = $("#userEmail").val();
            if(email && !emailPattern.test(email)) {
                layer.alert("请正确填写您的邮箱");
                if(email.length > 50) {
                    layer.alert("邮箱字符过长，请重新输入");
                }
                return;
            }
            var password = $("#password").val();
            var rePassword = $("#rePassword").val();
            if(!password) {
                layer.alert("请输入您的密码");
                return;
            }
            if(!passwordPattern.test(password)) {
                layer.alert("密码为6-16位非空白字符");
                return;
            }
            if(rePassword != password) {
                layer.alert("两次输入的密码不一致");
                return;
            }
            WT.wt_ajax_jsondata("${base}/to/signUser", $("#signForm").serialize(), function (res) {
                if(res && res.code == '0') {
                    location.href = "${base}/to/signSuccess";
                } else {
                    layer.alert(res ? res.msg : "系统异常");
                }
            });
        });
    });

</script>
</body>
</html>