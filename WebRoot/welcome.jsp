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
    <!-- bootstrap 和_header.jsp引入就没有语音 -->
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/plugins/css/bootstrap-table/bootstrap-table.min.css"
          rel="stylesheet">
    <!--[if lt IE 10]>
    <script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <![endif]-->

    <title>首页</title>
    <style>
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

        .col-center-block {
            float: none;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }

        .fixed-table-body {
            height: auto;
        }

        .table th.text-c, .table td.text-c {
            vertical-align: middle;
        }
    </style>
</head>

<!-- 判断是否需要语音播报 -->
<c:choose>
<c:when test="${fn:contains(userSession.resourceList, 'index:voice')}">
<body onload="voice()">
</c:when>
<c:otherwise>
<body>
</c:otherwise>
</c:choose>

<!--拓展型 
<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=36693494&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:270863798:53" alt="点击这里给我发消息" title="点击这里给我发消息"/></a>-->
<div class="page-container">
    <iframe allowtransparency="true" frameborder="0" width="565"
            height="98" scrolling="no"
            src="//tianqi.2345.com/plugin/widget/index.htm?s=2&z=3&t=1&v=0&d=3&bd=0&k=&f=&ltf=009944&htf=cc0000&q=1&e=1&a=1&c=54511&w=565&h=98&align=center"></iframe>

    <!-- 判断是否有回返记录 -->
    <c:if
            test="${fn:contains(userSession.resourceList, 'index:returnVisit')}">
        <fieldset>
            <legend>回访记录</legend>
            <div class="page-container">
                <div class="text-c">
                    <input type="text" class="input-text radius" style="width: 250px"
                           placeholder="输入姓名,姓名备注,电话,地址,QQ,咨询师" id="returnSearch">
                    <button type="submit" class="btn btn-success radius" id="search">
                        <i class="Hui-iconfont">&#xe665;</i> 搜用户
                    </button>
                </div>
            </div>


            <input type="hidden" id="returnRow" value=""> <input
                type="hidden" id="VisRow" value="">

            <table class="table table-bordered table-hover mt-10"
                   data-pagination="true" data-show-refresh="true"
                   data-showColumns="true"
                   data-content-type="application/x-www-form-urlencoded"
                   id="ReturnTable" data-undefined-text=" "
                   style="white-space: nowrap;">
                <thead>
                <tr class="text-c">
                    <th class="text-c" data-field="id">ID</th>
                    <th class="text-c" data-field="studentname" data-formatter="fmtStudentName" data-sortable="true">
                        学员姓名
                    </th>
                    <th class="text-c" data-field="nameremark">姓名备注</th>
                    <th class="text-c" data-field="age">年龄</th>
                    <th class="text-c" data-field="education">学历</th>
                    <th class="text-c" data-field="consultationperson">咨询师</th>
                    <th class="text-c" data-field="marketer">市场专员</th>
                    <th class="text-c" data-field="visitdate"
                        data-formatter="fmtVisitdate">预计上门时间
                    </th>
                    <th class="text-c" data-field="infosource">信息来源</th>
                    <th class="text-c" data-field="keeponperson">备案人</th>
                    <th class="text-c" data-field="keepontime"
                        data-formatter="fmtKeepontime">备案时间
                    </th>
                    <th class="text-c" data-field="remindtime"
                        data-formatter="fmtRemindtime">回返时间
                    </th>
                    <th class="text-c" data-field="consultationtime"
                        data-formatter="fmtConsultationtime" data-sortable="true">最后跟踪时间
                    </th>
                    <th class="text-c" data-field="status" data-formatter="fmtStatus">学员状态</th>
                    <th class="text-c" data-field="visiteddate"
                        data-formatter="fmtVisiteddate">上门时间
                    </th>
                    <th class="text-c" data-field="bookclass">订座班级</th>
                    <th class="text-c" data-field="shiftclass">进入班级</th>
                    <th class="text-c" data-field="shifttime"
                        data-formatter="fmtShifttime">进班时间
                    </th>
                    <th class="text-c" data-field="action" data-formatter="fmtAction">操作</th>
                </tr>
                </thead>
            </table>
        </fieldset>
    </c:if>
    <c:if
            test="${fn:contains(userSession.resourceList, 'index:forTheDoor')}">
        <fieldset>
            <legend>待上门</legend>
            <div class="page-container">
                <div class="text-c">
                    <input type="text" class="input-text radius" style="width: 250px"
                           placeholder="输入姓名,姓名备注,电话,地址,QQ,咨询师" id="visitSearch">
                    <button type="submit" class="btn btn-success radius" id="visSearch">
                        <i class="Hui-iconfont">&#xe665;</i> 搜用户
                    </button>
                </div>
            </div>
            <table class="table table-bordered table-hover mt-10"
                   data-pagination="true" data-show-refresh="true"
                   data-showColumns="true"
                   data-content-type="application/x-www-form-urlencoded"
                   id="visitTable" data-undefined-text=" " style="white-space: nowrap;">
                <thead>
                <tr class="text-c">
                    <th class="text-c" data-field="id">ID</th>
                    <th class="text-c" data-field="studentname">学员姓名</th>
                    <th class="text-c" data-field="nameremark">姓名备注</th>
                    <th class="text-c" data-field="age">年龄</th>
                    <th class="text-c" data-field="education">学历</th>
                    <th class="text-c" data-field="consultationperson">咨询师</th>
                    <th class="text-c" data-field="marketer">市场专员</th>
                    <th class="text-c" data-field="visitdate"
                        data-formatter="fmtVisitdate">预计上门时间
                    </th>
                    <th class="text-c" data-field="infosource">信息来源</th>
                    <th class="text-c" data-field="keeponperson">备案人</th>
                    <th class="text-c" data-field="keepontime"
                        data-formatter="fmtKeepontime">备案时间
                    </th>
                    <th class="text-c" data-field="remindtime"
                        data-formatter="fmtRemindtime">回返时间
                    </th>
                    <th class="text-c" data-field="consultationtime"
                        data-formatter="fmtConsultationtime" data-sortable="true">最后跟踪时间
                    </th>
                    <th class="text-c" data-field="status"
                        data-formatter="fmtVisStatus">学员状态
                    </th>
                    <th class="text-c" data-field="visitdate"
                        data-formatter="fmtVisiteddate">上门时间
                    </th>
                    <th class="text-c" data-field="bookclass">订座班级</th>
                    <th class="text-c" data-field="shiftclass">进入班级</th>
                    <th class="text-c" data-field="shifttime"
                        data-formatter="fmtShifttime">进班时间
                    </th>
                    <th class="text-c" data-field="action"
                        data-formatter="fmtVisAction">操作
                    </th>
                </tr>
                </thead>
            </table>
        </fieldset>
    </c:if>
</div>
<footer class="footer mt-20">
    <div class="container">
        <p>
            Copyright &copy;2017-2018 newer_mis v1.0 All Rights Reserved.<br>
            本后台系统由<a href="http://www.newer.cn.com/" target="_blank"
                     title="Newer">Newer</a>提供技术支持
        </p>
    </div>
</footer>
<input type="hidden" id="waitDoor" value="${waitDoor}"/>
</body>
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
<script src="static/iframe/lib/moment.js"></script>
<script src="static/plugins/js/window/openiframe.js"></script>
<script type="text/javascript"
        src="static/plugins/js/window/WebSpeech.js"></script>
<!-- 转上门 -->
<c:if
        test="${fn:contains(userSession.resourceList, 'index:consultVis')}">
<script type="text/javascript">
    $.canSultVis = true;
</script>
</c:if>
<!-- 咨询 -->
<c:if test="${fn:contains(userSession.resourceList, 'index:consult')}">
<script type="text/javascript">
    $.canSult = true;
</script>
</c:if>
<!-- 未上门 -->
<c:if test="${fn:contains(userSession.resourceList, 'index:notVisit')}">
<script type="text/javascript">
    $.canVis = true;
</script>
</c:if>

<script type="text/javascript">
    window.top["emolument_reload"] = function () {
        voice();
    }

    function voice() {
        var reRow = document.getElementById("returnRow").value;
        var visRow = document.getElementById("VisRow").value;
        if (reRow != 0 && visRow == 0) {
            WebSpeech.speak("您有" + reRow + "条回访记录处理");
        }
        if (reRow == 0 && visRow != 0) {
            WebSpeech.speak("您有" + visRow + "条待上门记录处理");
        }
        if (reRow != 0 && visRow != 0) {
            WebSpeech.speak("您有" + reRow + "条回访记录处理和" + visRow + "条待上门记录处理");
        }
        if (reRow == 0 || visRow == 0) {
            return;
        }
    }

    $(function () {
        //调用函数，初始化回返表格
        initTable();
        //当点击查询按钮的时候执行
        $("#search").bind("click", initTable);

        //调用函数，初始化待上门表格
        VisTable();
        //当点击查询按钮的时候执行
        $("#visSearch").bind("click", VisTable);

        $('.date').datetimepicker({
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            endDate: new Date(),
            autoclose: true,//选中自动关闭
            todayBtn: true,//显示今日按钮
        });

        $('#ReturnTable').on(
            'load-success.bs.table',
            function () {
                $("#returnRow")
                    .val($('#ReturnTable').bootstrapTable('getOptions').totalRows);
                //alert("待回访记录数：" + $("#returnRow").val());
            });
        $('#visitTable').on(
            'load-success.bs.table',
            function () {
                $("#VisRow").val($('#visitTable').bootstrapTable('getOptions').totalRows);
                //alert("待回访记录数：" + $("#VisRow").val());
            });

    });
</script>
<script type="text/javascript">
    function initTable() {
        //先销毁表格
        $("#ReturnTable").bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据
        $("#ReturnTable").bootstrapTable({
            method: "post", //使用get请求到服务器获取数据
            url: "keepon/keepReturn", //获取数据的Servlet地址
            dataType: "json",
            striped: true, //表格显示条纹
            pagination: true, //启动分页
            pageSize: 3,
            pageNumber: 1,
            pageList: [5, 10, 15, 20], //记录数可选列表
            search: false, //是否启用查询
            showColumns: true, //显示下拉框勾选要显示的列
            showRefresh: true, //显示刷新按钮
            clickToSelect: false, //是否启用点击选中行
            sortName: 'keepontime', //排序字段
            sortOrder: 'desc',//升序或者降序
            sidePagination: "server", //表示服务端请求
            paginationLoop: false,
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
            //设置为limit可以获取limit, offset, search, sort, order
            queryParamsType: "limit",
            icons: {
                refresh: 'glyphicon-repeat',
                toggle: 'glyphicon-list-alt',
                columns: 'glyphicon-list'
            },
            queryParams: function queryParams(params) { //设置查询参数
                var param = {
                    offset: params.offset,
                    limit: params.limit,
                    sort: params.sort,
                    order: params.order,
                    retuSearch: $.trim($("#returnSearch").val())
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

    //初始化待上门表格
    function VisTable() {
        //先销毁表格
        $("#visitTable").bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据
        $("#visitTable").bootstrapTable({
            method: "post", //使用get请求到服务器获取数据
            url: "keepon/keepVisit", //获取数据的Servlet地址
            dataType: "json",
            striped: true, //表格显示条纹
            pagination: true, //启动分页
            pageSize: 2,
            pageNumber: 1,
            pageList: [2, 3, 4], //记录数可选列表
            search: false, //是否启用查询
            showColumns: true, //显示下拉框勾选要显示的列
            showRefresh: true, //显示刷新按钮
            clickToSelect: false, //是否启用点击选中行
            sortName: 'keepontime', //排序字段
            sortOrder: 'desc',//升序或者降序
            sidePagination: "server", //表示服务端请求
            paginationLoop: false,
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
            //设置为limit可以获取limit, offset, search, sort, order
            queryParamsType: "limit",
            icons: {
                refresh: 'glyphicon-repeat',
                toggle: 'glyphicon-list-alt',
                columns: 'glyphicon-list'
            },
            queryParams: function queryParams(params) { //设置查询参数
                var param = {
                    offset: params.offset,
                    limit: params.limit,
                    sort: params.sort,
                    order: params.order,
                    visitSearch: $.trim($("#visitSearch").val())
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

    function fmtVisitdate(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }

    function fmtStatus(value, row, index) {
        return "未咨询";
    }

    function fmtVisiteddate(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD');
    }

    function fmtShifttime(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }

    function fmtAction(value, row, index) {
        var str = "";
        if ($.canSult) {
            str += "<a class='btn btn-white' title='咨询' href='consultation_keepon/selectToSultation?id="
                + row.id + "' title='咨询'>咨询</a>"
        }
        str += "&nbsp;&nbsp;";
        return str;
    }

    /*格式化学员姓名*/
    function fmtStudentName(value, row, index) {
        return "<a class='btn btn-link'  href='consultation_keepon/selectToSultation?id="
            + row.id + "' title='咨询'>" + row.studentname + "</a>"
    }

    /*格式时间*/
    function fmtConsultationtime(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }

    /*格式化备案时间*/
    function fmtKeepontime(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }

    /*格式化提醒时间*/
    function fmtRemindtime(value, row, index) {
        if (value == null) {
            return "";
        }
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }

    function fmtVisStatus(value, row, index) {
        return "待上门";
    }

    function fmtVisAction(value, row, index) {
        var str = ""
        if ($.canSultVis) {
            str += "<a class='btn btn-white' onClick=keepon_visit('转上门','front/keepon/query/transferVisit/"
                + row.id
                + "') href='javascript:;' class='ml-5' title='转上门'>转上门</a>";
        }
        str += "&nbsp;&nbsp;&nbsp;";
        if ($.canVis) {
            str += "<a class='btn btn-white' onClick=keepon_Notvisit('"
                + row.id
                + "') href='javascript:;' class='ml-5' title='未上门'>未上门</a>"
        }
        return str;
    }

    /*转上门*/
    function keepon_visit(title, url, id, w, h) {
        openIframe(title, url, w, h);
    }

    /*未上门*/
    function keepon_Notvisit(id) {
        $.ajax({
            type: "post",
            url: "keepon/notVis",
            dataType: "json",
            data: {
                id: id
            },
            success: function (result) {
                if (result.flag) {
                    layer.msg(result.msg, {
                        icon: 1,
                        time: 1000
                    });
                    VisTable();
                } else {
                    layer.msg(result.msg, {
                        icon: 2,
                        time: 1000
                    });
                    VisTable();
                }
            }
        });
    }
</script>
</html>