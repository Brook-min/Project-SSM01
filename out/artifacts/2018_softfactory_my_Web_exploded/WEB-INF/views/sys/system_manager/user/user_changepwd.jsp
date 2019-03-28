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
    <jsp:include page="/static/iframe/import/_meta.jsp"></jsp:include>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css"/>
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <jsp:include page="/static/iframe/import/_footer.jsp"></jsp:include>
    <link rel="stylesheet"
          href="static/plugins/css/validate/bootstrapValidator.css">
    <title>更改密码</title>
    <style>
        .input-margin-bottom {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div style="width: 100%;">
		<span class="c-red"
              style="font-size: 15px; margin-left: 7%; margin-top: 5%">尊敬的用户,您正在尝试修改密码,请谨慎操作!</span>
</div>
<div class="page-container">
    <div class="container-fluid">
        <form class="form-horizontal" method="post" id="pwdform">
            <div class="row">
                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <input type="hidden" value="${id}" name="id">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;新&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码:</span>
                            <input type="password" class="form-control" name="username"
                                   placeholder="新密码"/>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>确认新密码:</span>
                            <input type="password" class="form-control" name="realname"
                                   placeholder="确认新密码"/>
                        </div>
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
<script type="text/javascript"
        src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/plugins/js/validate/bootstrapValidator.min.js"></script>
<script src="static/plugins/js/window/layershow.js"></script>
<script type="text/javascript" src="static/iframe/lib/layer/2.4/layer.js"></script>
<script src="static/plugins/pagejs/system/user/user_changepwd.js"></script>

<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
</body>
</html>