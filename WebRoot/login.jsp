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

    <jsp:include page="static/iframe/import/_meta.jsp"></jsp:include>
    <link rel="Bookmark" href="favicon.ico"/>
    <link rel="Shortcut Icon" href="favicon.ico"/>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="static/plugins/login/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="static/plugins/login/css/form-elements.css">
    <link rel="stylesheet" href="static/plugins/login/css/style.css">
    <link rel="stylesheet"
          href="static/plugins/css/validate/bootstrapValidator.css">
    <!--[if lt IE 9]>
    <script type="text/javascript" src="static/iframe/lib/html5shiv.js"></script>
    <script type="text/javascript" src="static/iframe/lib/respond.min.js"></script>
    <![endif]-->
    <!--[if IE 6]>
    <script type="text/javascript" src="static/iframe/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="static/plugins/login/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="static/plugins/login/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72"
          href="static/plugins/login/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed"
          href="static/plugins/login/ico/apple-touch-icon-57-precomposed.png">
    <title>牛耳信息管理系统登录</title>
    <style type="text/css">
        body {
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        .form-control-feedback {
            top: 8 !important;
            right: 10;
        }

        /* 			element.style {
                        top: 9px;
                        z-index: 100;
                        display: block;
                    } */
    </style>
</head>
<body>
<!-- Top content -->
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1>
                        <strong>SSM框架整合及权限</strong>
                    </h1>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>欢迎使用</h3>
                            <p>请先输入您的账号和密码:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form class="login-form" method="post" id="loginfrm">
                            <div class="form-group">
                                <div class="input-group">
										<span class="input-group-addon"><span
                                                class="glyphicon glyphicon-user"></span></span> <input type="text"
                                                                                                       name="username"
                                                                                                       placeholder="请输入用户名"
                                                                                                       class="form-username form-control"
                                                                                                       id="form-username"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
										<span class="input-group-addon"><span
                                                class="glyphicon glyphicon-lock"></span></span> <input
                                        type="password" name="password" placeholder="请输入密码"
                                        class="form-password form-control" id="form-password">
                                </div>
                            </div>
                            <!--验证码 -->
                            <!-- 				<div class="form-group">
                                <div class="form-inline">
                                    <input type="text" name="kaptcha"
                                        placeholder="&nbsp;&nbsp;请输入验证码" class="" value="" style="" />
                                    <img src="authCode" id="kaptchaImage"
                                        ondragstart="return false;" class="refresh" />&nbsp;&nbsp;&nbsp;
                                    <span class="glyphicon glyphicon-refresh refresh hidden-xs"
                                        id="refresh"></span>
                                </div>
                            </div> -->
                            <button type="submit" class="btn btn-primary btn-success">登
                                录
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Javascript -->
<jsp:include page="static/iframe/import/_footer.jsp"></jsp:include>
<script type="text/javascript"
        src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/plugins/login/js/jquery.backstretch.min.js"></script>
<script src="static/plugins/login/js/login.js"></script>
<script src="static/plugins/js/validate/bootstrapValidator.min.js"></script>
<script src="static/plugins/pagejs/login.js"></script>

<!--[if lt IE 10]>
<script src="static/plugins/login/js/placeholder.js"></script>
<![endif]-->
</body>
</html>