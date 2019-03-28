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
    <link rel="stylesheet" href="static/iframe/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css"/>
    <link rel="stylesheet"
          href="static/plugins/css/validate/bootstrapValidator.css"/>
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <title>基础信息--编辑</title>
    <style>
        .input-margin-bottom {
            margin-bottom: 10px;
        }

        /*大文本框不能被拖动*/
        textarea {
            resize: none;
        }

        .form-horizontal .form-group {
            margin-right: 0px;
            margin-left: 0px;
            height: 50px;
        }
    </style>
</head>
<body>
<div class="page-container">
    <div class="container-fluid">
        <form class="form-horizontal" id="base_update" method="post">
            <div class="row">
                <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                    <div class="input-group ">
                        <span class="input-group-addon"><span class="c-red">*&nbsp;</span>编&nbsp;&nbsp;&nbsp;号:</span>
                        <input type="text" class="form-control" value="${base.id }" id="id" placeholder="编号" name="id"
                               readonly="readonly"/>
                    </div>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom input-margin-bottom form-group">
                    <div class="input-group">
							<span class="input-group-addon"> <span class="c-red">*&nbsp;</span>名&nbsp;&nbsp;&nbsp;称:
							</span><input type="text" value="${base.name }" class="form-control" readonly
                                          placeholder="名称"
                                          name="name"/>
                    </div>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;&nbsp;&nbsp;值:&nbsp;&nbsp;&nbsp;</span>
                        <input type="text" class="form-control" value="${base.value }" placeholder="值"
                               name="value"/>
                    </div>
                </div>
                <div class="col-sm-12 col-md-8 col-lg-8 ">
                    <div class="input-group">
                        <span class="input-group-addon">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:</span>
                        <textarea rows="4" class="form-control" name="description"
                                  placeholder="描述">${base.description }</textarea>
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
</body>
<!--请在下方写此页面业务相关的脚本-->
<jsp:include page="/static/iframe/import/_footer.jsp"></jsp:include>
<script src="static/iframe/lib/moment.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/plugins/js/validate/bootstrapValidator.min.js"></script>
<script src="static/plugins/js/window/referparent.js"></script>
<script type="text/javascript" src="static/iframe/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
<script type="text/javascript">
    $(function () {
        /*表单验证*/
        $("#base_update").bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                name: {
                    validators: {
                        notEmpty: {
                            message: '名称不能为空'
                        }
                    }
                },
                value: {
                    validators: {
                        notEmpty: {
                            message: '值不能为空'
                        }
                    }
                }
            }
            //做ajax请求用到
        }).on('success.form.bv', function (e) {
            e.preventDefault();
            var $form = $(e.target); //拿到form表单
            //请求修改部门
            $.ajax({
                type: "post",
                url: "base/edit",
                dataType: "json",
                data: $form.serialize(),
                success: function (result) {
                    if (result.flag) {
                        layer.msg(result.msg, {
                            icon: 1,
                            time: 1000
                        });
                        setTimeout(referParent, 1000);
                    } else {
                        layer.msg(result.msg, {
                            icon: 2,
                            time: 1000
                        });
                        //清空表单数据和状态
                        $("#base_update").data('bootstrapValidator').resetForm();
                    }
                }
            });
        });
        //清空表单数据和状态
        $("#reset").on("click", function () {
            $("#base_update").data('bootstrapValidator').resetForm();
        });
    })
</script>
</html>