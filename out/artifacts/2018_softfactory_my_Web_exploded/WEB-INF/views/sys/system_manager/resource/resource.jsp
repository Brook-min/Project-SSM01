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
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" type="text/css"
          href="static/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="static/plugins/css/bootstrap-table/bootstrap-table.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="static/plugins/css/datetimepicker/bootstrap-datetimepicker.min.css"/>
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <title>资源管理</title>
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
    系统管理 <span class="c-gray en">&gt;</span> 资源管理 <a
        class="btn btn-success radius r"
        style="line-height: 1.6em; margin-top: 3px"
        href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a>
</nav>

<div class="page-container">
    <c:if test="${fn:contains(userSession.resourceList, 'resource:add')}">
        <div id="toolbar">
            <a href="javascript:;"
               onclick="resource_add('添加资源','system_manager/resource/add','550','550')"
               class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>添加资源</a>
        </div>
    </c:if>
    <c:if
            test="${fn:contains(userSession.resourceList, 'resource:select')}">
        <table id="resource" style="white-space:nowrap;"
               class="table table-hover"
               data-show-refresh="true" data-toolbar="#toolbar"
               data-content-type="application/x-www-form-urlencoded"
               data-showColumns="true">
            <thead>
            <tr>
                <th class="text-c" data-field="id">编号</th>
                <th data-field="name">资源名称</th>
                <th class="text-c" data-field="url" data-formatter="fmtUrl">资源路径</th>
                <th class="text-c" data-field="seq">序号</th>
                <th class="text-c" data-field="icon" data-formatter="fmtIcon">图标</th>
                <th class="text-c" data-field="type" data-formatter="fmtType">类型</th>
                <th class="text-c" data-field="status" data-formatter="fmtStatus">状态</th>
                <th class="text-c" data-field="id" data-formatter="fmtOperate">操作</th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
    </c:if>
</div>
<script type="text/javascript"
        src="static/iframe/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
        src="static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-treeview/bootstraptable-treeview.js"></script>
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script type="text/javascript"
        src="static/plugins/js/window/layershow.js"></script>
<script src="static/plugins/pagejs/system/resource/resource.js"></script>
<c:if
        test="${fn:contains(userSession.resourceList, 'resource:update')}">
    <script type="text/javascript">
        $.canEdit = true;
    </script>
</c:if>
<c:if
        test="${fn:contains(userSession.resourceList, 'resource:delete')}">
    <script type="text/javascript">
        $.canDelete = true;
    </script>
</c:if>

</body>
</html>