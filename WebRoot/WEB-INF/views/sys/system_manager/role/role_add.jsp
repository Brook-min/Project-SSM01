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
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css"/>
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <link rel="stylesheet"
          href="static/plugins/css/validate/bootstrapValidator.css"/>
    <title>添加角色</title>
    <style>
        .input-margin-bottom {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<div class="page-container">
    <div class="container-fluid">
        <form class="form-horizontal" id="role_add">
            <div class="row">
                <div
                        class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;&nbsp;角&nbsp;色&nbsp;名:&nbsp;</span>
                        <input type="text" class="form-control" name="rolename"
                               placeholder="角色名"/>
                    </div>
                </div>
                <div
                        class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><span class="c-red">*&nbsp;</span>角色code:</span>
                        <input type="text" class="form-control" name="rolecode"
                               placeholder="角色code"/>
                    </div>
                </div>
                <div
                        class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                    <div class="input-group">
                        <span class="input-group-addon">&nbsp;描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:</span>
                        <textarea class="form-control" placeholder="描述" rows="4"
                                  name="description"></textarea>
                    </div>
                </div>
            </div>
            <div class="text-r mt-15" style="display: block;">
                <div class="tooltip-demo">
                    <button class="btn btn-primary" type="submit">
                        <i class="glyphicon glyphicon-ok"></i>&nbsp;提交
                    </button>
                    &nbsp;
                    <button class="btn btn-success" type="reset" id="reset">
                        <i class="glyphicon glyphicon-refresh"></i>&nbsp;重置
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>

<jsp:include page="/static/iframe/import/_footer.jsp"></jsp:include>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/plugins/js/validate/bootstrapValidator.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script src="static/plugins/js/window/referparent.js"></script>
<script src="static/plugins/pagejs/system/role/role_add.js"></script>
<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
</body>
</html>