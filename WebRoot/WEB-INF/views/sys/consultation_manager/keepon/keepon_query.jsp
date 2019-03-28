<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="/static/iframe/import/_meta.jsp"></jsp:include>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="static/plugins/css/bootstrap-table/bootstrap-table.min.css"/>
    <link rel="stylesheet"
          href="static/plugins/css/datetimepicker/bootstrap-datetimepicker.min.css"/>
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <title>数据备案查询</title>
    <style>
        .input-margin-bottom {
            margin-bottom: 10px;
        }

        textarea {
            resize: none;
        }

        fieldset {
            padding: .35em .625em .75em;
            margin: 0 2px;
            border: 1px solid silver;
        }

        legend {
            font-size: 16px;
            padding: .5em;
            border: 0;
            width: auto;
            margin-bottom: 0px;
        }

        .form-control[readonly] {
            background: #fcfcfc;
        }

        .fixed-table-body {
            height: auto;
        }

        .dropdown-toggle {
            background-color: rgb(230, 230, 230);
        }

        .table th.text-c, .table td.text-c {
            vertical-align: middle;
        }

        .table tr:nth-child(even) {
            background: #F0F8FF;
        }

        .fixed-table-container .bs-checkbox, .fixed-table-container .no-records-found {
            vertical-align: middle;
        }
    </style>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
    咨询管理 <span class="c-gray en">&gt;</span>数据备案查询<a
        class="btn btn-success radius r"
        style="line-height: 1.6em; margin-top: 3px"
        href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <form class="form-horizontal" method="post" id="kpponForm">
        <div class="container-fluid">
            <!-- 查询条件 -->
            <div class="row">
                <fieldset>
                    <legend>查询条件</legend>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">学员姓名: </span> <input type="text"
                                                                                 class="form-control" name="userName"
                                                                                 id="userName"
                                                                                 placeholder="学员姓名"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">姓名备注: </span> <input type="text"
                                                                                 class="form-control" name="nameRemark"
                                                                                 id="nameRemark"
                                                                                 placeholder="姓名备注"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">联系电话: </span> <input type="text"
                                                                                 class="form-control" name="telephone"
                                                                                 id="telephone"
                                                                                 placeholder="联系电话"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">Q&nbsp;Q号码: </span> <input
                                type="text" class="form-control" name="qq" id="qq"
                                placeholder="学员姓名"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">校&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区:</span><select
                                class="form-control" name="schoolArea" id="schoolArea">
                            <option value="">请选择</option>
                            <option value="五一校区">五一校区</option>
                            <option value="河西校区">河西校区</option>
                        </select>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">咨&nbsp;询&nbsp;师:&nbsp;</span><select
                                class="form-control" name="consultationPerson"
                                id="consultationPerson">
                            <option value="">未选择</option>
                        </select>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">咨询进度:</span><select
                                class="form-control" name="consultationProcess" id="schedule">
                            <option value="">未选择</option>
                        </select>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">学员状态:</span><select
                                class="form-control" name="nowStatus" id="state">
                            <option value="">未选择</option>
                        </select>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">信息来源:</span><select
                                class="form-control" name="infoSource" id="infoSource">
                            <option value="">未选择</option>
                        </select>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">市场分类:</span><select
                                class="form-control" name="marketType" id="market">
                            <option value="">未选择</option>
                        </select>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">咨询分类:</span><select
                                class="form-control" name="consultationType" id="consult">
                            <option value="">未选择</option>
                        </select>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">市场专员:</span><select
                                class="form-control" name="marketer" id="marketer">
                            <option value="">未选择</option>
                        </select>
                        </div>
                    </div>
                    <div class="row col-sm-12 col-md-12 col-lg-12"></div>
                    <div class="col-sm-6 col-md-6 col-lg-6 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">备案时间:</span> <input readonly
                                                                                type="text" placeholder="开始时间"
                                                                                class="form-control date"
                                                                                id="keeponStartTime"
                                                                                name="keeponStartTime"/> <span
                                class="input-group-addon hidden-xs ">至</span> <input readonly
                                                                                     type="text" placeholder="结束时间"
                                                                                     class="form-control date"
                                                                                     id="keeponEndTime"
                                                                                     name="keeponEndTime"/>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-6 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">咨询时间:</span> <input readonly
                                                                                type="text" placeholder="开始时间"
                                                                                class="form-control date"
                                                                                id="consultationStartTime"
                                                                                name="consultationStartTime"/> <span
                                class="input-group-addon hidden-xs">至</span> <input readonly
                                                                                    type="text" placeholder="结束时间"
                                                                                    class="form-control date"
                                                                                    id="consultationEndTime"
                                                                                    name="consultationEndTime"/>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-12 input-margin-bottom">
                        <button type="button" class="btn btn-success" id="kpoSearch">
                            <i class="Hui-iconfont">&#xe665;</i> 查询
                        </button>
                        <button type="reset" class="btn btn-white">
                            <i class="glyphicon glyphicon-refresh"></i> 重置
                        </button>
                    </div>
                </fieldset>
            </div>
        </div>
    </form>
    <div id="boolbar">
        <a href="javascript:;"
           onclick="assign('学员咨询','consultation_keepon/selectToSultation')"
           class="btn btn-primary radius"><i class="Hui-iconfont">&#xe692;</i>
            咨询</a> <a href="javascript:;"
                      onclick="keepon_remark('咨询进度跟踪','front/keepon/query/consultionProgress','1000','700')"
                      class="btn btn-primary radius"><i class="Hui-iconfont">&#xe665;</i>
        咨询进度跟踪</a>
    </div>
    <div class="mt-20">
        <table class="table table-bordered  table-hover"
               style="white-space: nowrap;" data-pagination="true"
               data-toolbar="#boolbar" data-show-refresh="true"
               data-showColumns="true"
               data-content-type="application/x-www-form-urlencoded"
               data-undefined-text=" " id="keeponTable">
            <thead>
            <tr class="text-c">
                <th data-checkbox="true"></th>
                <th class="text-c" data-field="id" data-sortable="true">ID</th>
                <th class="text-c" data-field="studentname"
                    data-formatter="fmtStudentName" data-sortable="true">学员姓名
                </th>
                <th class="text-c" data-field="nameremark" data-sortable="true">姓名备注</th>
                <th class="text-c" data-field="age" data-sortable="true">年龄</th>
                <th class="text-c" data-field="education">学历</th>
                <th class="text-c" data-field="telephone">联系电话</th>
                <th class="text-c" data-formatter="fmtLocation">所在区域</th>
                <th class="text-c" data-field="consultationperson">咨询师</th>
                <th class="text-c" data-field="marketer">市场专员</th>
                <th class="text-c" data-field="visitdate"
                    data-formatter="fmtVisitdate" data-sortable="true">预计上门时间
                </th>
                <th class="text-c" data-field="infosource">信息来源</th>
                <th class="text-c" data-field="qq">QQ/微信</th>
                <th class="text-c" data-field="keeponperson">备案人</th>
                <th class="text-c" data-field="keepontime"
                    data-formatter="fmtKeepontime" data-sortable="true">备案时间
                </th>
                <th class="text-c" data-field="consultationtime"
                    data-formatter="fmtConsultationtime" data-sortable="true">最后跟踪时间
                </th>
                <th class="text-c" data-field="nowstatus">学员状态</th>
                <th class="text-c" data-field="visiteddate"
                    data-formatter="fmtVisiteddate" data-sortable="true">上门时间
                </th>
                <th class="text-c" data-field="bookclass">订座班级</th>
                <th class="text-c" data-field="shiftclass">进入班级</th>
                <th class="text-c" data-field="shifttime"
                    data-formatter="fmtShifttime" data-sortable="true">进班时间
                </th>
                <th width="150" data-field="id" data-formatter="toConsultation">操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
</body>
<script type="text/javascript"
        src="static/iframe/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<!--请在下方写此页面业务相关的脚本 -->
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
<script src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script
        src="static/plugins/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="static/plugins/js/window/layershow.js"></script>
<script src="static/plugins/js/window/openiframe.js"></script>
<script src="static/iframe/lib/moment.js"></script>
<script type="text/javascript">
    $(function () {
        //bootstrap时间控件
        $('.date').datetimepicker({
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            endDate: new Date(),
            autoclose: true,//选中自动关闭
            todayBtn: true,//显示今日按钮
            clearBtn: true
            //清空时间按钮
        });
    });

    /*信息来源*/
    $.post("base/infoSource", {
        name: "信息来源"
    }, function (data) {
        $.each(data, function (i, n) {
            $("<option value=" + n.value + ">" + n.value + "</option >").appendTo(
                "#infoSource");
        });
    }, "json");

    /*咨询分类*/
    $.post("base/consult", {
        name: "咨询分类"
    }, function (data) {
        $.each(data, function (i, n) {
            $("<option value=" + n.value + ">" + n.value + "</option >").appendTo(
                "#consult");
        });
    }, "json");

    /*市场分类*/
    $.post("base/market", {
        name: "市场分类"
    }, function (data) {
        $.each(data, function (i, n) {
            $("<option value=" + n.value + ">" + n.value + "</option >").appendTo(
                "#market");
        });
    }, "json");

    /*市场专员*/
    $.post("user/selectUserByRole", {
        rolecode1: "marketer",
        rolecode2: "Marketing"
    }, function (data) {
        $.each(data, function (i, n) {
            $("<option value=" + n.realname + ">" + n.realname + "</option >")
                .appendTo("#marketer");
        });
    }, "json");
    /*咨询师*/
    $.post("user/selectUserByRole", {
        rolecode1: "counselor",
        rolecode2: "Consulting"
    }, function (data) {
        $.each(data, function (i, n) {
            $("<option value=" + n.realname + ">" + n.realname + "</option >")
                .appendTo("#consultationPerson");
        });
    }, "json");

    /*学员状态*/
    $.post("base/state", {
        name: "目前状态"
    }, function (data) {
        $.each(data, function (i, n) {
            $("<option value=" + n.value + ">" + n.value + "</option >").appendTo(
                "#state");
        });
    }, "json");

    /*咨询进度*/
    $.post("base/schedule", {
        name: "咨询进度"
    }, function (data) {
        $.each(data, function (i, n) {
            $("<option value=" + n.value + ">" + n.value + "</option >").appendTo(
                "#schedule");
        });
    }, "json");
</script>
<script type="text/javascript">
    function initTable() {
        //先销毁表格
        $('#keeponTable').bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据
        $("#keeponTable").bootstrapTable({
            method: "post", //使用get请求到服务器获取数据
            url: "consultation_keepon/selectConsultationKeepon", //获取数据的Servlet地址
            pagination: true, //启动分页
            showExport: true,//导出按钮
            exportDataType: "all",//导出所有
            pageList: [5, 10, 15, 20, 25], //记录数可选列表
            search: false, //是否启用查询
            showColumns: true, //显示下拉框勾选要显示的列
            showRefresh: true, //显示刷新按钮
            clickToSelect: true, //是否启用点击选中行
            sortName: 'keepontime', //排序字段
            sortOrder: 'desc',//升序或者降序
            sidePagination: "server", //表示服务端请求
            singleSelect: true, //设置True 将禁止多选
            checkboxHeader: true, //设置false 将在列头隐藏check-all checkbox .
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
            //设置为limit可以获取limit, offset, search, sort, order
            queryParamsType: "limit",
            icons: {
                refresh: 'glyphicon-repeat',
                toggle: 'glyphicon-list-alt',
                columns: 'glyphicon-list',
                "export": 'glyphicon-export icon-share'
            },
            queryParams: function queryParams(params) { //设置查询参数
                var param = {
                    offset: params.offset,
                    limit: params.limit,
                    sort: params.sort,
                    order: params.order,
                    userName: $.trim($("#userName").val()),
                    nameRemark: $.trim($("#nameRemark").val()),
                    telephone: $.trim($("#telephone").val()),
                    qq: $.trim($("#qq").val()),
                    schoolArea: $("#schoolArea").val(),
                    consultationPerson: $("#consultationPerson").val(),
                    consultationProcess: $("#schedule").val(),
                    nowStatus: $("#state").val(),
                    infoSource: $("#infoSource").val(),
                    marketType: $("#market").val(),
                    consultationType: $("#consult").val(),
                    marketer: $("#marketer").val(),
                    keeponStartTime: $("#keeponStartTime").val(),
                    keeponEndTime: $("#keeponEndTime").val(),
                    consultationStartTime: $("#consultationStartTime").val(),
                    consultationEndTime: $("#consultationEndTime").val()
                };
                return param;
            },
            onLoadError: function () { //加载失败时执行
                layer.msg("加载数据失败", {
                    time: 1500,
                    icon: 2
                });
            }
        });
    }

    //添加回车按钮事件，点击时查询
    document.onkeydown = function (event) {
        var e = event || window.event
            || arguments.callee.caller.arguments[0];
        if (e && e.keyCode == 13) { // enter 键
            //调用函数，初始化表格
            initTable();
        }
    };

    $(document).ready(function () {
        //调用函数，初始化表格
        initTable();
        //当点击查询按钮的时候执行
        $("#kpoSearch").bind("click", initTable);
    });

    /*省市县拼接*/
    function fmtLocation(value, row, index) {
        if (row.province == "" || row.province == null) {
            row.province = "";
        }
        if (row.city == "" || row.city == null) {
            row.city = "";
        }
        if (row.area == "" || row.area == null) {
            row.area = "";
        }
        return row.province + row.city + row.area;
    }

    /*格式时间*/
    function fmtConsultationtime(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }

    /*格式化学员姓名*/
    function fmtStudentName(value, row, index) {
        return "<a class='btn btn-link' href='consultation_keepon/selectToSultation?id="
            + row.id + "' title='咨询'>" + row.studentname + "</a>"
    }

    /*格式时间*/
    function fmtKeepontime(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }

    /*格式时间*/
    function fmtVisiteddate(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD');
    }

    /*格式时间*/
    function fmtVisitdate(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD');
    }

    /*格式时间*/
    function fmtShifttime(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD');
    }

    /*咨询*/
    function toConsultation(value) {
        return "<a class='btn btn-white'  href='consultation_keepon/selectToSultation?id="
            + value + "' title='咨询'>咨询</a>";
    }

    /*咨询*/
    function assign(title, url) {
        var row = $.map($("#keeponTable").bootstrapTable('getSelections'),
            function (row) {
                return row;
            });

        if (row.length == 1 || row.length == "1") {
            window.location.href = url + "?id=" + row[0].id;
        } else {
            layer.msg("请选择学员", {
                time: 1500,
                icon: 2
            });
        }
    }

    /*咨询进度跟踪*/
    function keepon_remark(title, url) {
        var row = $.map($("#keeponTable").bootstrapTable('getSelections'),
            function (row) {
                return row;
            });

        if (row.length == 1 || row.length == "1") {
            openIframe(title, url + "/" + row[0].id);
        } else {
            layer.msg("请选择学员", {
                time: 1500,
                icon: 2
            });
        }
    }
</script>
</html>