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
              style="font-size: 15px; margin-left: 7%; margin-top: 5%">尊敬的&nbsp;${userSession.realname}&nbsp;,您正在尝试修改密码,请谨慎操作!</span>
</div>
<div class="page-container">
    <div class="container-fluid">
        <form class="form-horizontal" method="post" id="pwdform">
            <div class="row">
                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;旧&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码:</span>
                            <input type="hidden" value="${userSession.id}" name="id"> <input
                                type="password" class="form-control" name="password"
                                id="passwords" placeholder="旧密码"/>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-3 ">
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


<script type="text/javascript">
    $(function () {
        $("#pwdform").bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                password: {
                    message: '密码验证失败',
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 15,
                            message: '密码长度必须在6到15位之间'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '密码只能包含大写、小写、数字和下划线'
                        }
                    }
                },
                username: {
                    message: '密码验证失败',
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 15,
                            message: '密码长度必须在6到15位之间'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '密码只能包含大写、小写、数字和下划线'
                        },
                        different: {
                            field: 'password',
                            message: '新密码不能和您输入的原密码相同'
                        }
                    }
                },
                realname: {
                    message: '密码重复还没有验证',
                    validators: {
                        notEmpty: {
                            message: '密码重复不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 15,
                            message: '密码长度在6到15之间'
                        },
                        identical: {
                            field: 'username',
                            message: '两次密码不同请重新输入'
                        },
                        different: {
                            field: 'password',
                            message: '新密码不能和您输入的原密码相同'
                        }
                    }
                }
            }
            //做ajax请求用到
        }).on(
            'success.form.bv',
            function (e) {
                e.preventDefault();
                var $form = $(e.target); //拿到form表单
                layer.load(2, {
                    time: 1000
                });
                setTimeout(function () {
                    //请求注册用户
                    $.ajax({
                        type: "post",
                        url: "user/changePassword",
                        dataType: "json",
                        data: $form.serialize(),
                        success: function (result) {
                            if (result.flag) {
                                layer.msg(result.msg, {
                                    time: 1500,
                                    icon: 1
                                });
                                setTimeout(function () {
                                    window.parent.location.reload();
                                }, 1500);
                            } else {
                                $("#pwdform")
                                    .data('bootstrapValidator')
                                    .resetForm();
                                $("#passwords").val("");
                                layer.msg(result.msg, {
                                    time: 1500,
                                    icon: 2
                                });
                            }
                        },
                        error: function (result) {
                            layer.msg(result.msg, {
                                time: 1500,
                                icon: 2
                            });
                        },
                    });
                }, 1000);
            });

        $("#reset").click(function () {
            $("#pwdform").data('bootstrapValidator').resetForm();

        });

    });
</script>


<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
</body>
</html>