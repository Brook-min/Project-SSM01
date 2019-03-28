<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="static/plugins/css/bootstap-select/bootstrap-select.min.css"/>
    <link rel="stylesheet"
          href="static/plugins/css/validate/bootstrapValidator.css">
    <link rel="stylesheet"
          href="static/iframe/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css"/>


    <title>用户管理</title>

    <style>
        .input-margin-bottom {
            margin-bottom: 20px;
        }

        .form-horizontal .form-group {
            height: 48px;
            margin-left: 0px;
            margin-right: 0px;
        }

        .bootstrap-select.btn-group .dropdown-toggle .filter-option {
            width: 240px;
            overflow-x: auto;
        }
    </style>
</head>
<body>

<div class="page-container">
    <div class="container-fluid">
        <form class="form-horizontal" method="post" id="myform">
            <div class="row">
                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>指令名称:</span>
                            <input type="hidden" value="${meslist.id}" name="id">
                            <input type="text" class="form-control" id="command" value="${meslist.command}"
                                   name="command" placeholder="指令名称"/>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3">
                    <div class="form-group">
                        <div class="input-group">
								<span class="input-group-addon"> <span class="c-red">*&nbsp;</span>&nbsp;描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:
								</span> <input type="text" id="description" value="${meslist.description}"
                                               class="form-control" placeholder="描述" name="description"/>
                        </div>
                    </div>
                </div>


                <div class="col-sm-4 col-md-4 col-lg-3 mb-50"
                     style="margin-top: 6px;">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;内&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;容:</span>
                            <textarea class="form-control" placeholder="内容" rows="4"
                                      name="content">${meslist.content}</textarea>
                        </div>
                    </div>
                </div>


            </div>
            <div class="text-r mt-15" style="display: block;">
                <div class="tooltip-demo">
                    <button class="btn btn-primary" id="submit" type="submit">
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
        src="static/iframe/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script type="text/javascript"
        src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/plugins/js/validate/bootstrapValidator.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>


<!-- bootstrap-select -->
<script
        src="static/plugins/js/bootstrap-select/bootstrap-select.min.js"></script>
<script src="static/plugins/js/bootstrap-select/defaults-zh_CN.min.js"></script>
<!-- bootstrap-select -->
<!--  <script src="static/plugins/pagejs/system/user/user_edit.js"></script> -->


<script type="text/javascript">
    $(function () {

        $("#myform")
            .bootstrapValidator(
                {
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        command: {
                            message: '指令名称验证失败',
                            validators: {
                                notEmpty: {
                                    message: '指令名称不能为空'
                                }
                            }
                        },
                        description: {
                            message: '指令描述验证失败',
                            validators: {
                                notEmpty: {
                                    message: '指令描述不能为空'
                                }
                            }
                        },
                        content: {
                            message: '内容验证失败',
                            validators: {
                                notEmpty: {
                                    message: '内容不能为空'
                                }
                            }
                        }
                    }
                    //做ajax请求用到
                }).on('success.form.bv', function (e) {
            e.preventDefault();
            var $form = $(e.target); //拿到form表单
            layer.load(2, {
                time: 1000
            });
            setTimeout(function () {
                $.ajax({
                    type: "post",
                    url: "mes/updateMessage",
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
            //页面刷新
            window.location.reload();

        });

    });
</script>

<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->

</body>
</html>