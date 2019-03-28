<%@ page language="java" import="java.lang.*"
         contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <title>角色管理</title>
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
    学生管理 <span class="c-gray en">&gt;</span> 科目管理 <a
        class="btn btn-success radius r"
        style="line-height: 1.6em; margin-top: 3px"
        href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <c:if test="${fn:contains(userSession.resourceList, 'subject:select')}">
        <div class="text-c">
            <input type="text" class="input-text radius" style="width: 250px"
                   placeholder="输入科目名称" id="subName">
            <button type="button" class="btn btn-success radius" id="search"
                    name="">
                <i class="Hui-iconfont">&#xe665;</i> 搜索
            </button>
        </div>
    </c:if>
    <div id="boolbar">
        <c:if
                test="${fn:contains(userSession.resourceList, 'subject:batchdelete')}">
            <a href="javascript:;" onclick="datadel()"
               class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
                批量删除</a>
        </c:if>
        <c:if test="${fn:contains(userSession.resourceList, 'subject:add')}">
            <a class="btn btn-primary radius" href="javascript:;"
               onclick="subject_add('添加科目','subject/add','500','320')"><i
                    class="Hui-iconfont">&#xe600;</i> 添加科目</a>
        </c:if>
    </div>
    <table id="subjectTable" style="white-space: nowrap;"
           class="table table-hover text-nowrap" data-pagination="true"
           data-checkbox-header="true" data-toolbar="#boolbar"
           data-show-refresh="true"
           data-content-type="application/x-www-form-urlencoded"
           data-showColumns="true" data-undefined-text=" ">
        <thead>
        <tr>
            <th data-checkbox="true" class="text-c"></th>
            <th data-width="30" class="text-c" data-field="subId"
                data-sortable="true">科目编号
            </th>
            <th data-width="100" class="text-c" data-field="subName"
                data-sortable="true">科目名称
            </th>
            <th data-width="100" class="text-c"
                data-formatter="actionFormatter">相关操作
            </th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<script src="static/iframe/lib/jquery/1.9.1/jquery.min.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script
        src="static/plugins/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="static/plugins/js/window/layershow.js"></script>
<script src="static/plugins/pagejs/student/subject/subject.js"></script>
<c:if test="${fn:contains(userSession.resourceList, 'subject:update')}">
    <script type="text/javascript">
        $.canEdit = true;
    </script>
</c:if>

<c:if test="${fn:contains(userSession.resourceList, 'subject:delete')}">
    <script type="text/javascript">
        $.canDelete = true;
    </script>
</c:if>

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