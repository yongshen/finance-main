<!DOCTYPE html>
<html lang="cn">
<head>
<#include "commons/top.ftl" />
</head>
<body>
<div class="main-wrap">
    <#include "commons/sidebar.ftl" />
    <div class="content-wrap">
        <#include "commons/header.ftl" />
        <main class="main-cont content mCustomScrollbar">
            <iframe id="mainFrame" name="mainFrame" src="${base}/main/indexPage" width="100%" height="100%" frameborder="0"></iframe>
        </main>
        <footer class="btm-ft">
            <p class="clear">
                <span class="fl">©Copyright 2017 <a href="javascript:;" title="sgy" target="_blank">gylm1314.com</a></span>
                <span class="fr text-info">
					<em class="uppercase">
						<i class="icon-user"></i>
						author:sgy
					</em>
				</span>
            </p>
        </footer>
    </div>
</div>
<#include "commons/bottom.ftl" />
</body>
</html>
