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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="static/iframe/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css"/>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css"/>
    <title>角色授权</title>
    <style>
    </style>
</head>
<body>
<div class="page-container">
    <div class="zTreeDemoBackground">
        <!-- 资源编号 -->
        <input id="id" name="id" type="hidden">
    </div>
    <div id="menuContent" class="menuContent table-bordered"
         style="overflow-y: auto; height: 250px;">
        <ul id="role_grant_Tree" class="ztree" style="margin-top: 10px;">
        </ul>
    </div>
    <div class="tooltip-demo"
         style="position: absolute; bottom: 10; right: 10;">
        <button class="btn btn-primary" type="submit" onclick="grant()">
            <i class="glyphicon glyphicon-ok"></i>&nbsp;提交
        </button>
        &nbsp;
        <button class="btn btn-info" type="button" id="selectNodes">
            <i class="glyphicon glyphicon-check"></i>&nbsp;全选
        </button>
        &nbsp;
        <button class="btn btn-success" type="button" id="reset">
            <i class="glyphicon glyphicon-refresh"></i>&nbsp;重置
        </button>
    </div>
    <input type="hidden" id="roleId" value="${roleId}"/> <input
        type="hidden" id="resourceids" value="${resourceids}"/>
</div>
<jsp:include page="/static/iframe/import/_footer.jsp"></jsp:include>
<script type="text/javascript"
        src="static/iframe/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript"
        src="static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script src="static/plugins/js/window/referparent.js"></script>
<script src="static/plugins/pagejs/system/role/role_grant.js"></script>
<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
</body>
</html>