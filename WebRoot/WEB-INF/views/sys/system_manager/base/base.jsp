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
    <link
            href="static/plugins/css/datetimepicker/bootstrap-datetimepicker.min.css"/>
    <link href="static/plugins/css/bootstrap-table/bootstrap-table.min.css"
          rel="stylesheet">
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <title>基础数据-列表</title>
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
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
    系统管理 <span class="c-gray en">&gt;</span> 基础数据管理 <a
        class="btn btn-success radius r"
        style="line-height: 1.6em; margin-top: 3px"
        href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <c:if test="${fn:contains(userSession.resourceList, 'base:select')}">
        <div class="text-c">
            <input type="text" class="input-text radius" style="width: 250px"
                   placeholder="输入名称" id="baseName">
            <button type="button" class="btn btn-success radius" id="search">
                <i class="Hui-iconfont">&#xe665;</i> 搜索
            </button>
        </div>
    </c:if>
    <div id="boolbar">
        <c:if
                test="${fn:contains(userSession.resourceList, 'base:batchdelete')}">
            <a href="javascript:;" onclick="batchDel()"
               class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
                批量删除</a>
        </c:if>
        <c:if test="${fn:contains(userSession.resourceList, 'base:add')}">
            <a class="btn btn-primary radius" href="javascript:;"
               onclick="base_add('添加基础数据','system_manager/base/base_add','550','360')"><i
                    class="Hui-iconfont">&#xe600;</i> 添加基础数据</a>
        </c:if>
    </div>
    <div class="mt-20">
        <table id="baseTable" style="white-space: nowrap;"
               class="table table-hover text-nowrap" data-pagination="true"
               data-checkbox-header="true" data-toolbar="#boolbar"
               data-show-refresh="true"
               data-content-type="application/x-www-form-urlencoded"
               data-showColumns="true" data-undefined-text=" "
               data-maintain-selected="true">
            <thead>
            <tr>
                <th data-checkbox="true" class="text-c"></th>
                <th data-width="100" class="text-c" data-sortable="true"
                    data-field="id">ID
                </th>
                <th data-width="200" class="text-c" data-sortable="true"
                    data-field="name">名称
                </th>
                <th data-width="200" class="text-c" class="text-c"
                    data-field="value">值
                </th>
                <th data-width="400" class="text-c" data-field="description">描述</th>
                <th data-width="300" class="text-c" data-field="createtime"
                    data-sortable="true" data-formatter="fmtCreateTime">创建时间
                </th>
                <th data-width="150" class="text-c"
                    data-formatter="actionFormatter">相关操作
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
<script src="static/iframe/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script
        src="static/plugins/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="static/plugins/js/window/layershow.js"></script>
<script src="static/iframe/lib/moment.js"></script>

<c:if test="${fn:contains(userSession.resourceList, 'base:update')}">
    <script type="text/javascript">
        $.canEdit = true;
    </script>
</c:if>
<c:if test="${fn:contains(userSession.resourceList, 'base:delete')}">
    <script type="text/javascript">
        $.canDelete = true;
    </script>
</c:if>
<script type="text/javascript">
    function initTable() {
        //先销毁表格
        $('#baseTable').bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据
        $("#baseTable").bootstrapTable({
            method: "post", //使用请求到服务器获取数据
            url: "base/select", //获取数据的Servlet地址
            dataType: "json",
            maintainSelected: true,
            pageList: [5, 10, 15, 20, 25], //记录数可选列表
            showColumns: true, //显示下拉框勾选要显示的列
            showRefresh: true, //显示刷新按钮
            clickToSelect: true, //是否启用点击选中行
            sidePagination: "server", //表示服务端请求
            paginationLoop: false,
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
            //设置为limit可以获取limit, offset, search, sort, order
            queryParamsType: "limit",
            queryParams: function queryParams(params) { //设置查询参数

                var param = {
                    offset: params.offset,
                    limit: params.limit,
                    sort: params.sort,
                    order: params.order,
                    baseName: $("#baseName").val()
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

    $(document).ready(function () {
        //调用函数，初始化表格
        initTable();
        //当点击查询按钮的时候执行
        $("#search").bind("click", initTable);
    });

    /*操作显示*/
    function actionFormatter(value, row, index) {
        var str = '';
        if ($.canEdit) {
            str += ("<a title='编辑' href='javascript:;' onclick=base_edit('编辑','base/selectById/"
                + row.id + "','650','430')  style='text-decoration:none'><i class='Hui-iconfont'>&#xe6df;</i></a>");
        }
        str += '&nbsp;&nbsp;&nbsp;&nbsp;';
        if ($.canDelete) {
            str += ("<a title='删除' href='javascript:;' onclick=base_del(this,'"
                + row.id + "') class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>");
        }
        return str;
    }

    /*添加*/
    function base_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }

    //编辑
    function base_edit(title, url, w, h) {
        layer_show(title, url, w, h);
    }

    //删除
    function base_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.ajax({
                type: 'POST',
                url: 'base/delete/' + id,
                dataType: 'json',
                success: function (result) {
                    if (result.flag) {
                        layer.msg(result.msg, {
                            icon: 1,
                            time: 1000
                        });
                        setTimeout(initTable, 1000);
                    } else {
                        layer.msg(result.msg, {
                            icon: 2,
                            time: 1000
                        });
                    }
                },

            });
        });
    }

    //批量删除
    function batchDel() {
        //获得已经选中的id
        var base = $("#baseTable").bootstrapTable('getSelections');
        var ids = "";
        if (base != "") {
            $.each(base, function (index, item) {
                ids += item.id + ",";
            });
            ids = ids.substr(0, ids.length - 1);
            //是否确定要删除
            layer.confirm('确认要删除吗？', function (index) {
                $.ajax({
                    type: 'POST',
                    url: 'base/batchdelete',
                    data: {
                        "ids": ids
                    },
                    dataType: 'json',
                    success: function (result) {
                        if (result.flag) {
                            layer.msg(result.msg, {
                                icon: 1,
                                time: 1000
                            });
                            setTimeout(initTable, 1000);
                        } else {
                            layer.msg(result.msg, {
                                icon: 2,
                                time: 1000
                            });
                        }
                    }

                });
            });
        } else {
            layer.msg('未选中需要删除的数据', {
                time: 1500
            });
        }

    }

    /*格式创建时间*/
    function fmtCreateTime(value, row, index) {
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }
</script>
<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
</body>
<script type="text/javascript">
    //添加回车按钮事件，点击时查询
    document.onkeydown = function (event) {
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if (e && e.keyCode == 13) { // enter 键
            //调用函数，初始化表格
            initTable();
        }
    };
</script>
</html>
