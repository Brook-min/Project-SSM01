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
    <title>用户管理</title>
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
    系统管理 <span class="c-gray en">&gt;</span> 用户管理 <a
        class="btn btn-success radius r"
        style="line-height: 1.6em; margin-top: 3px"
        href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <c:if test="${fn:contains(userSession.resourceList, 'user:select')}">
        <div class="text-c">
            <input type="text" class="input-text radius" style="width: 250px"
                   placeholder="输入用户名、真实姓名、电话、邮箱" id="information">
            <button type="submit" class="btn btn-success radius" id="userSearch">
                <i class="Hui-iconfont">&#xe665;</i> 搜用户
            </button>
        </div>
    </c:if>
    <div id="boolbar">
        <c:if
                test="${fn:contains(userSession.resourceList, 'user:batchdelete')}">
            <a href="javascript:;" onclick="dataUserDel()"
               class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
                批量删除</a>
        </c:if>
        <c:if test="${fn:contains(userSession.resourceList, 'user:add')}">
            <a href="javascript:;"
               onclick="member_add('添加用户','user/loadUpGradName','450','480')"
               class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>添加用户</a>
        </c:if>
    </div>
    <div class="mt-20">
        <table id="userTable" style="white-space: nowrap;"
               class="table table-hover" data-pagination="true"
               data-toolbar="#boolbar" data-show-refresh="true"
               data-content-type="application/x-www-form-urlencoded"
               data-showColumns="true" data-undefined-text=" ">
            <thead>
            <tr class="text-c">
                <th data-checkbox="true"></th>
                <th data-width="80" class="text-c" data-field="id"
                    data-sortable="true">ID
                </th>
                <th data-width="100" class="text-c" data-field="username"
                    data-sortable="true">用户名
                </th>
                <th data-width="100" class="text-c" data-field="realname"
                    data-sortable="true">真实姓名
                </th>
                <th data-width="40" class="text-c" data-field="sex"
                    data-sortable="true">性别
                </th>
                <th data-width="90" class="text-c" data-field="telephone">手机</th>
                <th data-width="150" class="text-c" data-field="email">邮箱</th>
                <th data-width="100" class="text-c" data-field="address"
                    data-sortable="true">地址
                </th>
                <th data-width="100" class="text-c" data-field="upname">上级名称</th>
                <th data-width="100" class="text-c" data-field="deptName">部门名称</th>
                <th data-width="100" class="text-c" data-field="city"
                    data-formatter="fmtCity">省市县
                </th>
                <th data-width="130" class="text-c" data-formatter="fmtCreateTime"
                    data-field="createtime" data-sortable="true">加入时间
                </th>
                <th data-width="70" class="text-c" data-formatter="lockedcheck"
                    data-field="locked" data-sortable="true">锁定状态
                </th>
                <th data-width="100" class="text-c" data-formatter="operation">操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
<!--请在下方写此页面业务相关的脚本-->
<script src="static/iframe/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/laypage/1.2/laypage.js"></script>
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
<script src="static/iframe/lib/moment.js"></script>
<script src="static/plugins/pagejs/system/user/user.js"></script>
<c:if test="${fn:contains(userSession.resourceList, 'user:update')}">
    <script type="text/javascript">
        $.canEdit = true;
    </script>
</c:if>
<c:if test="${fn:contains(userSession.resourceList, 'user:delete')}">
    <script type="text/javascript">
        $.canDelete = true;
    </script>
</c:if>
<c:if test="${fn:contains(userSession.resourceList, 'user:add')}">
    <script type="text/javascript">
        $.canInsert = true;
    </script>
</c:if>
<c:if test="${fn:contains(userSession.resourceList, 'user:select')}">
    <script type="text/javascript">
        $.canSelect = true;
    </script>
</c:if>
<!-- 启用 -->
<c:if
        test="${fn:contains(userSession.resourceList, 'user:startusing')}">
    <script type="text/javascript">
        $.canStart = true;
    </script>
</c:if>
<!-- 停用 -->
<c:if test="${fn:contains(userSession.resourceList, 'user:blockup')}">
    <script type="text/javascript">
        $.canStop = true;
    </script>
</c:if>
<!-- 修改密码 -->
<c:if test="${fn:contains(userSession.resourceList, 'user:changepwd')}">
    <script type="text/javascript">
        $.canPWD = true;
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