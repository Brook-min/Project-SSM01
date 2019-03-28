<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>

    <style type="text/css">
        .fixed-table-body {
            height: auto;
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
    <title>市场管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
    市场管理 <span class="c-gray en">&gt;</span> 是否备案查询 <a
        class="btn btn-success radius r"
        style="line-height: 1.6em; margin-top: 3px"
        href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-4 col-md-4 col-lg-3">
                <input type="text" class="form-control" id="information"
                       placeholder="输入学员姓名、姓名备注、QQ、电话、地域"/>
            </div>
            <div class="col-sm-4 col-md-4 col-lg-3">
                <button type="submit" class="btn btn-success radius" id="search">
                    <i class="Hui-iconfont">&#xe665;</i> 搜索
                </button>
            </div>
        </div>

        <div class="mt-20">
            <table id="iskepponTable" class="table table-bordered table-hover"
                   data-content-type="application/x-www-form-urlencoded"
                   style="white-space: nowrap;">
                <thead>
                <tr>
                    <th width="80" class="text-c" data-field="id">序号</th>
                    <th width="100" class="text-c" data-formatter="fmtInfo">信息</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="static/iframe/lib/jquery/1.9.1/jquery.min.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script
        src="static/plugins/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<!-- 时间格式转化 -->
<script src="static/iframe/lib/moment.js"></script>
<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
<script type="text/javascript">
    function initTable() {
        //先销毁表格
        $('#iskepponTable').bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据
        $("#iskepponTable").bootstrapTable({
            method: "post", //使用get请求到服务器获取数据
            url: "market_keepon/selectIsKepoon", //获取数据的Servlet地址
            dataType: "json",
            pagination: false, //启动分页
            search: false, //是否启用查询
            sidePagination: "server", //表示服务端请求
            queryParams: function queryParams(params) { //设置查询参数
                var param = {
                    keeponSearch: $.trim($("#information").val())
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
        initTable();
        //当点击查询按钮的时候执行
        $("#search").bind("click", initTable);
    });

    //信息
    function fmtInfo(value, row, index) {
        var str = "&nbsp;";
        str += "<span class='c-red'>" + row.studentname + "</span>学员于"
            + "<span class='c-red'>"
            + moment(row.keepontime).format('YYYY-MM-DD HH:mm:ss')
            + "</span>由" + "<span class='c-red'>" + row.keeponperson
            + "</span>进行备案," + "指派咨询师为 <span class='c-red'>"
            + row.consultationperson + "</span>,"

        if (row.consultationtime == null) {
            str += "最后跟踪时间为:<span class='c-red'>无 </span>";
        } else {
            str += "最后跟踪时间为:<span class='c-red'>"
                + moment(row.consultationtime).format(
                    'YYYY-MM-DD HH:mm:ss') + "</span>"
        }
        return str;
    }
</script>
</body>
</html>