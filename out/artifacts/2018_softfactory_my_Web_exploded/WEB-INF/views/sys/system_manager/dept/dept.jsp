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
    <link rel="stylesheet" type="text/css"
          href="static/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="static/plugins/css/datetimepicker/bootstrap-datetimepicker.min.css"/>
    <link href="static/plugins/css/bootstrap-table/bootstrap-table.min.css"
          rel="stylesheet">
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <title></title>
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
    系统管理 <span class="c-gray en">&gt;</span> 部门管理 <a
        class="btn btn-success radius r"
        style="line-height: 1.6em; margin-top: 3px"
        href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <!--<div class="text-c"> 日期范围:
    <input type="text" class="input-text date" style="width:100px;" placeholder="开始时间"/>
    <i class="glyphicon glyphicon-calendar" style="font-size:20px;top:7px;"></i>
    -
    <input type="text"  class="input-text date" style="width:100px;" placeholder="结束时间">
    <i class="glyphicon glyphicon-calendar" style="font-size:20px;top:7px;"></i>
    <input type="text" class="input-text" style="width:150px" placeholder="输入部门名称、地址" id="" name="">
    <button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜部门</button>
</div>
-->
    <c:if test="${fn:contains(userSession.resourceList, 'dept:add')}">
        <div id="boolbar">
            <!-- <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> -->
            <a href="javascript:;"
               onclick="member_add('添加部门','system_manager/dept/dept_add','650','490')"
               class="btn btn-primary radius"> <i class="Hui-iconfont">&#xe600;</i>添加部门
            </a>
        </div>
    </c:if>
    <table id="deptTable" style="white-space:nowrap;"
           class="table table-hover" data-pagination="true"
           data-toolbar="#boolbar" data-show-refresh="true"
           data-showColumns="true">
        <thead>
        <tr>
            <th class="text-c" data-field="id">ID</th>
            <th data-field="deptname">部门名称</th>
            <th class="text-c" data-field="description">描述</th>
            <th class="text-c" data-field="address">地址</th>
            <th class="text-c" data-width="100px" data-field="pName"
                data-formatter="fmtPName">上级部门名称
            </th>
            <th class="text-c" data-field="icon" data-formatter="fmtIcon">图标</th>
            <th class="text-c" data-field="createtime"
                data-formatter="fmtCreateTime">创建时间
            </th>
            <th class="text-c" data-field="deploymentId"
                data-formatter="fmtAction">相关操作
            </th>
        </tr>
        </thead>
    </table>
</div>
<!--请在下方写此页面业务相关的脚本-->
<script src="static/iframe/lib/jquery/1.9.1/jquery.min.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/iframe/lib/moment.js"></script>
<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script type="text/javascript"
        src="static/plugins/js/window/layershow.js"></script>
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script
        src="static/plugins/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-treeview/bootstraptable-treeview.js"></script>
<c:if test="${fn:contains(userSession.resourceList, 'dept:update')}">
    <script type="text/javascript">
        $.canEdit = true;
    </script>
</c:if>
<c:if test="${fn:contains(userSession.resourceList, 'dept:delete')}">
    <script type="text/javascript">
        $.canDelete = true;
    </script>
</c:if>
<script type="text/javascript" src="static/plugins/pagejs/system/dept/dept.js"></script>
</body>
</html>