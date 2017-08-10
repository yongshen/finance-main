<!DOCTYPE html>
<html lang="en">
<head>
<#include "./../commons/top.ftl" />
    <link rel="stylesheet" href="${base}/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${base}/assets/plugins/daterangepicker/daterangepicker.css">
    <style rel="stylesheet" type="text/css">
        .color-red{color:#F14444}
        .color-green{color:#019A01}
        .form-cont i {
            position: relative; bottom: 25px; left: 90%; top: auto; cursor: pointer;
        }
    </style>
</head>
<body>
<div class="page-wrap">
    <div class="flow-layout">
        <ul>
            <li class="child-wrap">
                <div class="panel panel-default">
                    <div class="panel-bd" style="height: 65px;">
                        <div class="form-group-col-2 fl" style="width: 25%;">
                            <div class="form-label">财务类型：</div>
                            <div class="form-cont">
                                <select id="financeType" name="financeType" class="form-control form-boxed">
                                    <option value="" disabled selected>请选择</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group-col-2 fl" style="width: 25%;">
                            <div class="form-label">消费分类：</div>
                            <div class="form-cont">
                                <select id="consumtType" name="consumtType" class="form-control form-boxed">
                                    <option value="" disabled selected>请选择</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group-col-2 fl" style="width: 32%;">
                            <div class="form-label">消费时间：</div>
                            <div class="form-cont">
                                <input type="text" id="consume-date" class="form-control">
                                <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                <input type="hidden" name="consumeStartDate" id="consumeStartDate">
                                <input type="hidden" name="consumeEndDate" id="consumeEndDate">
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
    <div class="mb-10" style="clear: both"><button class="btn btn-primary item-add"><i class="icon-plus"></i>新增记录</button></div>
    <table class="table table-bordered table-hover">
        <thead>
            <tr>
                <th style="display: none">id</th>
                <th width="8%">财务类型</th>
                <th width="11%">消费/收入分类</th>
                <th width="10%">金额（元）</th>
                <th width="15%">消费/收入日期</th>
                <th width="14%">消费地点</th>
                <th width="20%">详细信息</th>
                <th width="10%">备注</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody class="data-list">

        </tbody>
    </table>
    <div class="panel panel-default">
        <div class="panel-bd">
            <div class="pagination"></div>
        </div>
    </div>
</div>
<#include "./../commons/bottom.ftl" />
<script type="text/javascript" src="${base}/assets/finance/js/plug-ins/pagination.js"></script>
<script type="text/javascript" src="${base}/assets/plugins/daterangepicker/moment.js"></script>
<script type="text/javascript" src="${base}/assets/plugins/daterangepicker/daterangepicker.js"></script>
<script type="text/javascript">
    $(function () {
        //加载list
        loadDataList(1);
        //初始化时间选择控件
        initDateTime();

        //编辑
        $(".data-list").on("click", "a.item-view", function () {

        });
    });

    //加载数据
    function loadDataList(page, params) {
        var index = layer.load();
        params = $.extend(params, {rows:20, page:page});
        $(".data-list").load("${base}/consume/doSearch", params, function () {
            layer.close(index);
        });
    }
    
    //初始化时间控件
    function initDateTime() {
        var options = {
            opens: "left",
            locale: {
                format: "YYYY-MM-DD",
                separator: " - ",
                applyLabel: "确定",
                cancelLabel: "取消",
                fromLabel: "从",
                toLabel: "到",
                customRangeLabel: "自定义",
                weekLabel: "W",
                daysOfWeek: ["日","一","二","三","四","五","六"],
                monthNames: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
                firstDay: 7
            }
        };
        $('#consume-date').daterangepicker(options, function(start, end, label) {
            $("#consumeStartDate").val(start.format('YYYY-MM-DD'));
            $("#consumeEndDate").val(end.format('YYYY-MM-DD'));
        });
    }
</script>
</body>
</html>
