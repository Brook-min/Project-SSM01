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
    <jsp:include page="/static/iframe/import/_meta.jsp"></jsp:include>
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/plugins/css/bootstrap-table/bootstrap-table.min.css"
          rel="stylesheet">
    <link
            href="static/plugins/css/datetimepicker/bootstrap-datetimepicker.min.css"
            rel="stylesheet"/>
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <style type="text/css">
        .input-margin-bottom {
            margin-bottom: 10px;
        }

        fieldset {
            padding: .35em .625em .75em;
            margin: 0 2px;
            border: 1px solid silver;
        }

        legend {
            padding: .5em;
            border: 0;
            width: auto;
            margin-bottom: 0px;
            font-size: 16px;
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

        .modal-backdrop.in {
            opacity: -0.5;
        }

        .modal-backdrop {
            z-index: 0;
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
    <title>备案查询</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
    前台管理 <span class="c-gray en">&gt;</span> 备案查询<a
        class="btn btn-success radius r"
        style="line-height: 1.6em; margin-top: 3px"
        href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <div class="container-fluid">
        <form class="form-horizontal" method="post" id="kpponForm">
            <div class="container-fluid">
                <!-- 查询条件 -->
                <div class="row">
                    <fieldset>
                        <legend>查询条件</legend>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="input-group">
                                <span class="input-group-addon">学员姓名: </span> <input
                                    type="text" class="form-control" name="userName" id="userName"
                                    placeholder="学员姓名"/>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="input-group">
                                <span class="input-group-addon">姓名备注: </span> <input
                                    type="text" class="form-control" name="nameRemark"
                                    id="nameRemark" placeholder="姓名备注"/>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="input-group">
                                <span class="input-group-addon">联系电话: </span> <input
                                    type="text" class="form-control" name="telephone"
                                    id="telephone" placeholder="学员姓名"/>
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
            <c:if
                    test="${fn:contains(userSession.resourceList, 'front_keepon_query:add')}">
                <a href="javascript:window.location.href='front/keepon'"
                   class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
                    新增备案数据</a>
            </c:if>
            <c:if
                    test="${fn:contains(userSession.resourceList, 'front_keepon_query:importKeepon')}">
                <a data-toggle="modal" data-target="#myExcel"
                   class="btn btn-primary radius"><i class="Hui-iconfont">&#xe645;</i>
                    导入备案数据</a>
            </c:if>
            <c:if
                    test="${fn:contains(userSession.resourceList, 'front_keepon_query:assignCounselor')}">
                <a href="javascript:;"
                   onclick="keepon_assign('指派咨询师','front/keepon/query/assignCounselor')"
                   style="text-decoration: none" class="btn btn-primary radius"><i
                        class="Hui-iconfont">&#xe60d;</i> 指派咨询师</a>
            </c:if>
            <c:if
                    test="${fn:contains(userSession.resourceList, 'front_keepon_query:assignMarker')}">
                <a href="javascript:;"
                   onclick="keepon_marker('指派市场专员','front/keepon/query/assignMarker')"
                   style="text-decoration: none" class="btn btn-primary radius"><i
                        class="Hui-iconfont">&#xe60d;</i> 指派市场专员</a>
            </c:if>
            <c:if
                    test="${fn:contains(userSession.resourceList, 'front_keepon_query:nameRemark')}">
                <a href="javascript:;"
                   onclick="keepon_remark('姓名备注','front/keepon/query/nameRemark')"
                   class="btn btn-primary radius"><i class="Hui-iconfont">&#xe6df;</i>
                    姓名备注</a>
            </c:if>
            <c:if
                    test="${fn:contains(userSession.resourceList, 'front_keepon_query:consultionProgress')}">
                <a href="javascript:;"
                   onclick="keepon_remark('咨询进度跟踪','front/keepon/query/consultionProgress','1000','700')"
                   class="btn btn-primary radius"><i class="Hui-iconfont">&#xe665;</i>
                    咨询进度跟踪</a>

            </c:if>
            <c:if
                    test="${fn:contains(userSession.resourceList, 'front_keepon_query:update')}">
                <a href="javascript:;"
                   onclick="keepon_update('修改备案信息','front/keepon/query/toKeeponUpdate','1000','700')"
                   class="btn btn-primary radius"><i
                        class="Hui-iconfont Hui-iconfont-edit"></i> 修改备案信息</a>
            </c:if>
        </div>
        <div class="mt-20">
            <table class="table table-bordered table-hover"
                   style="white-space: nowrap;" data-pagination="true"
                   data-toolbar="#boolbar" data-show-refresh="true"
                   data-showColumns="true"
                   data-content-type="application/x-www-form-urlencoded"
                   data-undefined-text=" " id="keeponTable">
                <thead>
                <tr class="text-c">
                    <th data-checkbox="true" style="vertical-align: bottom;"></th>
                    <th class="text-c" data-field="id" data-sortable="true">ID</th>
                    <th class="text-c" data-field="studentname" data-sortable="true">学员姓名</th>
                    <th class="text-c" data-field="nameremark" data-sortable="true">姓名备注</th>
                    <th class="text-c" data-field="age" data-sortable="true">年龄</th>
                    <th class="text-c" data-field="education">学历</th>
                    <th class="text-c" data-field="telephone">联系电话</th>
                    <th class="text-c" data-formatter="fmtLocation">所在区域</th>
                    <th class="text-c" data-field="infosource">信息来源</th>
                    <th class="text-c" data-field="qq">QQ/微信</th>
                    <th class="text-c" data-field="consultationperson">咨询师</th>
                    <th class="text-c" data-field="marketer">市场专员</th>
                    <th class="text-c" data-field="keeponperson">备案人</th>
                    <th class="text-c" data-field="keepontime"
                        data-formatter="fmtKeepontime" data-sortable="true">备案时间
                    </th>
                    <th class="text-c" data-field="consultationtime"
                        data-formatter="fmtConsultationtime" data-sortable="true">最后跟踪时间
                    </th>
                    <c:if
                            test="${fn:contains(userSession.resourceList, 'front_keepon_query:transferClass') or fn:contains(userSession.resourceList, 'front_keepon_query:transferVisit')}">
                        <th class="text-c" data-field="status"
                            data-formatter="fmtStatus">学员状态
                        </th>
                    </c:if>
                    <th class="text-c" data-field="visiteddate"
                        data-formatter="fmtVisiteddate" data-sortable="true">上门时间
                    </th>
                    <th class="text-c" data-field="visitdate"
                        data-formatter="fmtVisitdate" data-sortable="true">预计上门时间
                    </th>
                    <th class="text-c" data-field="bookclass">订座班级</th>
                    <th class="text-c" data-field="shiftclass">进入班级</th>
                    <th class="text-c" data-field="shifttime"
                        data-formatter="fmtShifttime" data-sortable="true">进班时间
                    </th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<div class="modal fade" id="myExcel" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;
                </button>
                <h4 class="modal-title" id="myModalLabel">导入Excel表格</h4>
            </div>
            <div class="modal-body">
                <form enctype="multipart/form-data" method="post" name="fileForm">
                    <label for="upload"> <input type="file" id="upload"
                                                class="file" name="fileName"
                                                style='opacity: 1.5; filter: alpha(opacity = 1.5);'>
                    </label>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="btnExcel" class="btn btn-primary">提交更改</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<script src="static/iframe/lib/jquery/1.9.1/jquery.min.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script
        src="static/plugins/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="static/plugins/js/window/layershow.js"></script>
<script src="static/plugins/js/window/openiframe.js"></script>
<script src="static/iframe/lib/moment.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-tableExport/bootstrap-table-export.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-tableExport/tableExport.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-tableExport/jspdf.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-tableExport/jspdf.plugin.autotable.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-tableExport/html2canvas.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-tableExport/FileSaver.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-tableExport/xlsx.core.min.js"></script>
<script src="static/plugins/js/window/referparent.js"></script>
<script src="static/iframe/lib/jquery.form.js"></script>
<c:if
        test="${fn:contains(userSession.resourceList, 'front_keepon_query:transferVisit')}">
    <script type="text/javascript">
        $.canVisit = true;
    </script>
</c:if>
<c:if
        test="${fn:contains(userSession.resourceList, 'front_keepon_query:transferClass')}">
    <script type="text/javascript">
        $.canClass = true;
    </script>
</c:if>
<c:if
        test="${fn:contains(userSession.resourceList, 'front_keepon_query:exportKeepon')}">
    <script type="text/javascript">
        $.canExport = true;
    </script>
</c:if>

<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
<script type="text/javascript">
    $(function () {
        /*信息来源*/
        $.post("base/infoSource", {
            name: "信息来源"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#infoSource");
            });
        }, "json");

        /*咨询分类*/
        $.post("base/consult", {
            name: "咨询分类"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#consult");
            });
        }, "json");

        /*市场分类*/
        $.post("base/market", {
            name: "市场分类"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#market");
            });
        }, "json");

        /*市场专员*/
        $.post("user/selectUserByRole", {
            rolecode1: "marketer",
            rolecode2: "Marketing"
        }, function (data) {
            $.each(data, function (i, n) {
                $(
                    "<option value=" + n.realname + ">" + n.realname
                    + "</option >").appendTo("#marketer");
            });
        }, "json");
        /*咨询师*/
        $.post("user/selectUserByRole", {
            rolecode1: "counselor",
            rolecode2: "Consulting"
        }, function (data) {
            $.each(data, function (i, n) {
                $(
                    "<option value=" + n.realname + ">" + n.realname
                    + "</option >").appendTo(
                    "#consultationPerson");
            });
        }, "json");

        /*目前状态*/
        $.post("base/state", {
            name: "目前状态"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#state");
            });
        }, "json");

        /*咨询进度*/
        $.post("base/schedule", {
            name: "咨询进度"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#schedule");
            });
        }, "json");

        /*时间控件*/
        $('.date').datetimepicker({
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            endDate: new Date(),
            autoclose: true,//选中自动关闭
            todayBtn: true,//显示今日按钮
            clearBtn: true
        });

        $("#btnExcel").click(
            function () {
                var fileType = $("#upload").val().substring(
                    $("#upload").val().lastIndexOf(".") + 1);
                if (fileType != "xls" && fileType != "xlsx") {
                    alert("只能上传excel文件");
                    return false;
                }
                var form = $("form[name=fileForm]");
                var options = {
                    url: 'front/keepon/query/importKeepon', //上传文件的路径
                    type: 'post',
                    success: function (result) {
                        var data = $.parseJSON(result);
                        if (data.flag) {
                            layer.msg(data.msg, {
                                icon: 1,
                                time: 1000
                            });
                            $("#myExcel").modal('hide');
                            initTable();
                        } else {
                            layer.msg(data.msg, {
                                icon: 2,
                                time: 2000
                            });
                        }
                    }
                };
                form.ajaxSubmit(options);
            });

    });
</script>
<script type="text/javascript">
    var exFlag = false;
    if ($.canExport) {
        exFlag = true;
    }

    function initTable() {
        //先销毁表格
        $('#keeponTable').bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据
        $("#keeponTable").bootstrapTable(
            {
                method: "post", //使用get请求到服务器获取数据
                url: "front/keepon/selectAll", //获取数据的Servlet地址
                pagination: true, //启动分页
                showExport: exFlag,//导出按钮
                exportDataType: "all",//导出所有
                pageSize: 10,
                pageNumber: 1,
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
                //表格导出数据设置
                exportOptions: {
                    //忽略列
                    ignoreColumn: [0, 0],
                    fileName: "备案信息报表",
                    worksheetName: "备案信息报表",
                    tableName: "tb_keepon"
                },
                exportTypes: ['excel', 'xlsx', 'txt', 'sql', 'doc',
                    'json', 'xml'],
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
                        consultationPerson: $("#consultationPerson")
                            .val(),
                        consultationProcess: $("#schedule").val(),
                        nowStatus: $("#state").val(),
                        infoSource: $("#infoSource").val(),
                        marketType: $("#market").val(),
                        consultationType: $("#consult").val(),
                        marketer: $("#marketer").val(),
                        keeponStartTime: $("#keeponStartTime").val(),
                        keeponEndTime: $("#keeponEndTime").val(),
                        consultationStartTime: $(
                            "#consultationStartTime").val(),
                        consultationEndTime: $("#consultationEndTime")
                            .val()
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
    function fmtShifttime(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }

    /*格式时间*/
    function fmtConsultationtime(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }

    /*格式时间*/
    function fmtKeepontime(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }

    /*格式时间*/
    function fmtVisitdate(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD');
    }

    /*格式时间*/
    function fmtVisiteddate(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD');
    }

    /*学员状态*/
    function fmtStatus(value, row, index) {

        var str = "&nbsp;";
        if ($.canVisit) {
            if (row.visiteddate == null) {
                str += "<a class='btn btn-white size-MINI' onClick=keepon_visit('转上门','front/keepon/query/transferVisit/"
                    + row.id
                    + "') href='javascript:;' class='ml-5' title='转上门'>转上门</a>"
            } else {
                str += "<span class='label label-success radius'>已上门</span>";
            }
        }

        str += "&nbsp;";
        if ($.canClass) {
            if (row.shifttime == null) {
                str += "<a class='btn btn-white size-MINI' onClick=transfer_class('转进班','front/keepon/query/transferClass/"
                    + row.id
                    + "') href='javascript:;' class='ml-5' title='转进班'>转进班</a>"
            } else {
                str += "<span class='label label-success radius'>已进班</span>";
            }
        }
        return str;
    }

    /*指派咨询师*/
    function keepon_assign(title, url) {
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

    /*指派市场专员*/
    function keepon_marker(title, url) {
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

    /*修改备案信息*/
    function keepon_update(title, url) {
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

    /*姓名备注*/
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

    /*转进班*/
    function transfer_class(title, url) {
        openIframe(title, url);
    }

    /*转上门*/
    function keepon_visit(title, url, id, w, h) {
        openIframe(title, url, w, h);
    }
</script>
</body>
</html>