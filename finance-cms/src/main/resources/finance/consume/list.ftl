<#if resultList?? && resultList.rows?size gt 0>
    <#list resultList.rows as item>
    <tr class="cen <#if item.financeType == 1>color-red<#elseif item.financeType == 2>color-green</#if>">
        <td style="display: none">${item.id!}</td>
        <td><#if item.financeType == 1>收入<#elseif item.financeType == 2>支出</#if></td>
        <td>${item.consumeTypeName!}</td>
        <td>${item.consumeMoney!0?string('#.##')}</td>
        <td>${item.consumeDate?string('yyyy-MM-dd HH:mm:ss')}</td>
        <td>${item.consumeLocation!'-'}</td>
        <td>${item.consumeDetail!}</td>
        <td>${item.remark!}</td>
        <td><a title="查看" data-id="${item.id}" class="mr-5 item-view" href="javascript:;">查看</a></td>
    </tr>
    </#list>
<#else>
    <tr class="cen"><td colspan="8">暂无数据</td></tr>
</#if>
<script type="text/javascript">
    $(function () {
        $(".pagination").createPage({
            pageCount:'${resultList.total}',
            current:1,
            backFn:function(page){
                loadDataList(page);
            }
        });
    });
</script>