<header class="top-hd">
    <div class="hd-lt">
        <a class="icon-reorder"></a>
    </div>
    <div class="hd-rt">
    <#if Session["ACCOUNTENTITY"]??>
        <#assign user = Session["ACCOUNTENTITY"]>
        <ul>
            <li>
                <a><i class="icon-user"></i><em>${user.userName!}</em></a>
            </li>
        <#--<li>-->
        <#--<a><i class="icon-bell-alt"></i>系统消息</a>-->
        <#--</li>-->
            <li>
                <a href="javascript:;" onclick="logout()"><i class="icon-signout"></i>安全退出</a>
            </li>
        </ul>
    <#else>
        <ul>
            <li>
                <a href="javascript:;"><em>欢迎使用</em></a>
            </li>
        </ul>
    </#if>
    </div>
</header>
<script type="text/javascript">
    function logout(){
        WT.wt_confirm("确认要退出?", function () {
            top.location.href = '${base}/logout1';
        });
    }
</script>