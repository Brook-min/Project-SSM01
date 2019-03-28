<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet"
          href="static/plugins/css/bootstrap-table/bootstrap-table.min.css"/>
    <link rel="stylesheet"
          href="static/plugins/css/datetimepicker/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet"
          href="static/plugins/css/validate/bootstrapValidator.css">
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <title>转上门</title>
    <style>
        .input-margin-bottom {
            margin-bottom: 10px;
        }

        textarea {
            resize: none;
        }

        fieldset {
            padding: .35em .625em .75em;
            margin: 0 2px;
            border: 1px solid silver;
        }

        .form-horizontal .has-feedback .form-control-feedback {
            right: 10;
        }

        legend {
            font-size: 16px;
            padding: .5em;
            border: 0;
            width: auto;
            margin-bottom: 0px;
        }

        .form-control[readonly] {
            background: #fcfcfc;
        }

        .form-horizontal .form-group {
            height: 48px;
            margin-left: 0px;
            margin-right: 0px;
        }
    </style>
</head>
<body>
<div class="page-container">
    <form class="form-horizontal" id="transferFrm" method="post">
        <div class="container-fluid">
            <div class="row">
                <fieldset>
                    <legend>备案信息</legend>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
								<span class="input-group-addon"><span class="c-red">*&nbsp;</span>学员姓名:
								</span> <input type="text" class="form-control" placeholder="学员姓名"
                                               name="studentname" value="${keepon.studentname }"/>
                        </div>
                    </div>

                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
								<span class="input-group-addon"><span class="c-red">*&nbsp;</span>姓名备注:
								</span> <input type="text" class="form-control" placeholder="姓名备注"
                                               name="nameremark" value="${keepon.nameremark }"/>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>联系电话:</span><input
                                type="text" class="form-control" name="telephone"
                                value="${keepon.telephone }" placeholder="联系电话"/>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
                            <select name="sex" class="form-control">
                                <c:if test="${keepon.sex eq '男' }">
                                    <option value="男" selected="selected">男</option>
                                    <option value="女">女</option>
                                </c:if>
                                <c:if test="${keepon.sex eq '女' }">
                                    <option value="男">男</option>
                                    <option value="女" selected="selected">女</option>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
								<span class="input-group-addon"><span class="c-red">*&nbsp;</span>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:
								</span><input type="text" maxlength="3" name="age"
                                              value="${keepon.age }" class="form-control" placeholder="年龄"/>
                        </div>
                    </div>

                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">QQ/微信:</span> <input type="text"
                                                                                 name="qq" value="${keepon.qq }"
                                                                                 class="form-control"
                                                                                 placeholder="QQ号码"/>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>校&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区:</span>
                            <select name="schoolarea" class="form-control">
                                <c:if test="${keepon.schoolarea eq '牛耳校区' }">
                                    <option value="">请选择</option>
                                    <option value="牛耳校区" selected="selected">牛耳校区</option>
                                </c:if>
                                <c:if test="${keepon.schoolarea ne '牛耳校区' }">
                                    <option value="">请选择</option>
                                    <option value="牛耳校区">牛耳校区</option>
                                </c:if>
                            </select>
                        </div>
                    </div>

                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校:</span>
                            <input type="text" name="school" class="form-control"
                                   value="${keepon.school }" placeholder="学校"/>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:</span>
                            <select id="education" name="education" class="form-control">
                                <option value="">请选择</option>
                            </select>
                        </div>
                    </div>
                    <div id="distpicker2">
                        <div
                                class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                            <div class="input-group">
                                <span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;省:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                <select class="form-control radius" name="province"
                                        id="province">
                                </select>
                            </div>
                        </div>
                        <div
                                class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                            <div class="input-group">
                                <span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;市:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                <select class="form-control radius" name="city" id="city">
                                </select>
                            </div>
                        </div>
                        <div
                                class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                            <div class="input-group">
                                <span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;县:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                <select class="form-control radius" name="area" id="area">
                                </select>
                            </div>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">课&nbsp;程&nbsp;体&nbsp;系:</span> <select
                                name="system" id="system" class="form-control">
                            <option value="">请选择</option>
                        </select>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</span>
                            <select name="major" id="major" class="form-control">
                                <option value="">请选择</option>
                            </select>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">目&nbsp;前&nbsp;状&nbsp;态:</span> <select
                                id="state" name="nowstatus" class="form-control">
                            <option value="">请选择</option>
                        </select>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">培&nbsp;训&nbsp;形&nbsp;式:</span> <select
                                id="trainingtype" name="trainingtype" class="form-control">
                            <option value="">请选择</option>
                        </select>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">招&nbsp;生&nbsp;主&nbsp;管:</span> <input
                                type="text" name="supervisor" class="form-control"
                                placeholder="招生主管" value="${keepon.supervisor }"/>
                        </div>
                    </div>

                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">市&nbsp;场&nbsp;专&nbsp;员:</span> <input
                                type="text" name="marketer" class="form-control"
                                placeholder="市场专员" value="${keepon.marketer }"/>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span
                                    class="c-red">*&nbsp;</span>&nbsp;咨&nbsp;询&nbsp;师:</span>
                            <select id="consultationperson" name="consultationperson"
                                    class="form-control">
                                <option value=" ">请选择</option>
                            </select>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>上门时间:</span>
                            <input type="text" placeholder="上门时间"
                                   value="<fmt:formatDate value='${keepon.visiteddate}' pattern='yyyy-MM-dd'/>"
                                   name="visiteddate" readonly="readonly"
                                   class="form-control date"/>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">订&nbsp;座&nbsp;班&nbsp;级:</span> <select
                                id="bookclass" name="bookclass" class="form-control">
                            <option value="">请选择</option>
                        </select>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">订&nbsp;座&nbsp;时&nbsp;间:</span> <input
                                type="text" placeholder="订座时间"
                                value="<fmt:formatDate value='${keepon.booktime}' pattern='yyyy-MM-dd'/>"
                                name="booktime" readonly="readonly" class="form-control date"/>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>信息来源:</span>
                            <select id="infoSource" name="infosource"
                                    class="form-control radius">
                                <option value="">请选择</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-lg-offset-6 col-lg-6"></div>
                    <div class="col-sm-12 col-md-12 col-lg-6  input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">咨&nbsp;询&nbsp;信&nbsp;息:</span>
                            <textarea class="form-control" name="consultation.content"
                                      placeholder="咨询信息" rows="4">${keepon.consultation.content }</textarea>
                        </div>
                        <input name="consultation.id" type="hidden"
                               value="${keepon.consultation.id }"/> <input name="id"
                                                                           type="hidden" value="${keepon.id }"
                                                                           id="keeponId"/>
                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-6 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">备&nbsp;注&nbsp;信&nbsp;息:</span>
                            <textarea class="form-control" name="description"
                                      placeholder="备注信息" rows="4">${keepon.description }</textarea>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>
        <div class="text-center mt-30">
            <button class="btn btn-primary" type="submit">
                <i class="glyphicon glyphicon-ok"></i>&nbsp;提交
            </button>
            <button class="btn btn-success" type="button" id="reset">
                <i class="glyphicon glyphicon-refresh"></i>&nbsp;重置
            </button>
            <a class="btn btn-white" href="javascript:layer_close()"
               target="_blank"><i class="glyphicon glyphicon-share-alt"></i>&nbsp;返回</a>
        </div>
    </form>
</div>
</body>
<!--_footer 作为公共模版分离出去-->
<jsp:include page="/static/iframe/import/_footer.jsp"></jsp:include>
<!--请在下方写此页面业务相关的脚本 -->
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
<script src="static/plugins/js/validate/bootstrapValidator.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script src="static/plugins/js/h-ui.3jld/distpicker.data.js"></script>
<script src="static/plugins/js/h-ui.3jld/distpicker.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="static/plugins/js/window/referparent.js"></script>
<script type="text/javascript">
    $(function () {
        //bootstrap时间控件
        $('.date').datetimepicker({
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            //endDate : new Date(),
            autoclose: true,//选中自动关闭
            todayBtn: true,//显示今日按钮
            clearBtn: true
            //清除按钮
            //清空时间按钮
        })

        //加载3连城市驱动
        $('#distpicker2').distpicker({
            province: "${keepon.province}",
            city: "${keepon.city}",
            district: "${keepon.area}"
        });
        /*咨询师*/
        $.post("user/selectUserByRole", {
            rolecode1: "counselor",
            rolecode2: "Consulting"
        }, function (data) {
            $.each(data, function (i, n) {
                if (n.realname == "${keepon.consultationperson}") {
                    $("<option value=" + n.realname + " selected='selected'>" + n.realname + "</option >")
                        .appendTo("#consultationperson");
                } else {
                    $("<option value=" + n.id + ">" + n.realname + "</option >")
                        .appendTo("#consultationperson");
                }
            });
            $("#consultationperson").val(["${keepon.consultationperson}"]);
        }, "json");

        /*信息来源*/
        $.post("base/infoSource", {
            name: "信息来源"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#infoSource");
            });
            $("#infoSource").val(["${keepon.infosource}"]);
        }, "json");

        /*订座班级*/
        $.post("base/infoSource", {
            name: "订座班级"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#bookclass");
            });
            $("#bookclass").val(["${keepon.bookclass}"]);
        }, "json");
        /*目前状态*/
        $.post("base/state", {
            name: "目前状态"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#state");
            });
            $("#state").val(["${keepon.nowstatus}"]);
        }, "json");
        /*培训形式*/
        $.post("base/trainingtype", {
            name: "培训形式"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#trainingtype");
            });
            $("#trainingtype").val(["${keepon.trainingtype}"]);
        }, "json");
        /*课程体系*/
        $.post("base/system", {
            name: "课程体系"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#system");
            });
            $("#system").val(["${keepon.system}"]);
        }, "json");
        /*学历*/
        $.post("base/education", {
            name: "学历"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#education");
            });
            $("#education").val(["${keepon.education}"]);
        }, "json");

        /*专业*/
        $.post("base/major", {
            name: "专业"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#major");
            });
            $("#major").val(["${keepon.major}"]);
        }, "json");

        //验证表单
        $("#transferFrm")
            .bootstrapValidator(
                {
                    excluded: [':disabled'],
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        studentname: {
                            message: '学员姓名信息有误',
                            validators: {
                                notEmpty: {
                                    message: '学员姓名不能为空'
                                }
                            }
                        },
                        sex: {
                            message: '性别验证失败',
                            validators: {
                                notEmpty: {
                                    message: '请选择性别'
                                }
                            }
                        },
                        age: {
                            message: '年龄验证失败',
                            validators: {
                                notEmpty: {
                                    message: '年龄不能为空'
                                },
                                regexp: {
                                    regexp: /^(?:0|[1-9][0-9]?|100)$/,
                                    message: '年龄只能是[0-100]岁'
                                }
                            }
                        },
                        telephone: {
                            message: '电话验证失败',
                            validators: {
                                /* notEmpty : {
                                    message : '电话不能为空'
                                }, */
                                regexp: {
                                    regexp: /^0?(13[0-9]|15[0-9]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}$/,
                                    message: '电话号码格式错误,例：18942536166'
                                },
                                remote: {
                                    type: 'post',
                                    url: 'user/selectBytelephone',
                                    data: {
                                        id: $("#keeponId").val()
                                    },
                                    message: '电话号码已经备案'
                                }
                            }
                        },
                        infosource: {
                            message: '信息来源验证失败',
                            validators: {
                                notEmpty: {
                                    message: '请选择信息来源'
                                }
                            }
                        },
                        /* 		marketer : {
                                    message : '市场专员验证失败',
                                    validators : {
                                        notEmpty : {
                                            message : '请选择市场专员'
                                        }
                                    }
                                }, */
                        qq: {
                            message: 'QQ号码验证失败',
                            validators: {
                                regexp: {
                                    regexp: /^[0-9]*$/,
                                    message: 'QQ号码只能是数字'
                                },
                                remote: {
                                    type: 'post',
                                    url: 'user/selectByqq',
                                    data: {
                                        id: $("#keeponId").val()
                                    },
                                    message: 'qq号码已经备案'
                                }
                            }
                        },
                        /* schoolarea : {
                            message : '校区验证失败',
                            validators : {
                                notEmpty : {
                                    message : '请选择校区'
                                }
                            }
                        }, */
                        consultationid: {
                            message: '咨询师验证失败',
                            validators: {
                                notEmpty: {
                                    message: '请选择咨询师'
                                }
                            }
                        },
                        visiteddate: {
                            message: '上门时间验证失败',
                            validators: {
                                notEmpty: {
                                    message: '请选择上门时间'
                                }
                            }
                        }
                    }
                    //做ajax请求用到
                }).on('success.form.bv', function (e) {
            e.preventDefault();
            var $form = $(e.target); //拿到form表单
            //请求注册用户
            $.ajax({
                type: "post",
                url: "front/keepon/query/updateKeeponWithConsulation",
                dataType: "json",
                data: $form.serialize(),
                success: function (result) {
                    if (result.flag) {
                        layer.msg(result.msg, {
                            time: 1500,
                            icon: 1
                        });
                        setTimeout(function () {
                            referParent();
                        }, 2000);
                    } else {
                        layer.msg(result.msg, {
                            time: 1500,
                            icon: 2
                        });
                    }
                }
            });
        });
        /*重置表单状态*/
        $("#reset").click(function () {
            $("#transferFrm").data('bootstrapValidator').resetForm();
        });

        $("input[name='visiteddate']").change(
            function () {
                $("#transferFrm").data('bootstrapValidator').updateStatus(
                    "visiteddate", "NOT_VALIDATED", null);
                $("#transferFrm").data('bootstrapValidator').validateField(
                    'visiteddate');
            });

        //自定义验证
        $("input[name='qq']")
            .keyup(
                function () {
                    if ($.trim($(this).val()) != "") {
                        $("form").data("bootstrapValidator")
                            .updateStatus("telephone", "VALID",
                                null);
                    }
                    if ($.trim($(this).val()) == ""
                        && $.trim($("input[name='telephone']")
                            .val()) == "") {
                        $("form").data("bootstrapValidator")
                            .updateStatus("telephone",
                                "NOT_VALIDATED", null);
                        $("form").data("bootstrapValidator")
                            .updateStatus("qq", "NOT_VALIDATED",
                                null);
                    }
                });

        $("input[name='telephone']").keyup(
            function () {
                if ($.trim($(this).val()) != "") {
                    $("form").data("bootstrapValidator").updateStatus("qq",
                        "VALID", null);
                }
            });

        $("#submit").click(
            function () {
                setTimeout(function () {
                    if ($("input[name='qq']").val() == ""
                        && $("input[name='telephone']").val() != ""
                        || $("input[name='qq']").val() != ""
                        && $("input[name='telephone']").val() == "") {
                        $("form").data('bootstrapValidator').updateStatus(
                            "qq", "VALID", null);
                        $("form").data('bootstrapValidator').updateStatus(
                            "telephone", "VALID", null);
                    }
                }, 10);
            });
    });
</script>
</html>