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
    <jsp:include page="/static/iframe/import/_meta.jsp"></jsp:include>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="static/plugins/css/validate/bootstrapValidator.css">
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <title>修改数据备案</title>
    <style>
        fieldset {
            padding: .35em .625em .75em;
            margin: 0 2px;
            border: 1px solid silver;
        }

        .form-control[readonly] {
            background: #fcfcfc;
        }

        legend {
            padding: .5em;
            border: 0;
            width: auto;
            margin-bottom: 0px;
            font-size: 16px;
        }

        .input-margin-bottom {
            margin-bottom: -5px;
        }

        .form-horizontal .form-group {
            height: 48px;
            margin-left: 0px;
            margin-right: 0px;
        }
    </style>
</head>
<body onload="province()">
<div class="page-container">
    <div class="container-fluid">
        <div class="col-sm-12 col-md-12">
            <form class="form-horizontal" id="myfrm">
                <div class="row">
                    <fieldset>
                        <legend>基本信息</legend>
                        <div
                                class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
										<span class="input-group-addon"><span class="c-red">*&nbsp;</span>学员姓名:
										</span> <input type="text" class="form-control" name="studentname"
                                                       placeholder="学员姓名" value="${keepon.studentname }"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="c-red">*&nbsp;</span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span><select
                                        class="form-control" name="sex">
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
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="c-red">*&nbsp;</span>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:</span>
                                    <input type="text" name="age" class="form-control"
                                           placeholder="年龄" value="${keepon.age }"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="c-red">*&nbsp;</span>联系电话:</span>
                                    <input type="text" name="telephone" class="form-control"
                                           placeholder="联系电话" value="${keepon.telephone }"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="c-red">*&nbsp;</span>信息来源:</span>
                                    <select class="form-control radius" id="infoSource"
                                            name="infosource">
                                        <option value="">请选择</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:</span>
                                    <select class="form-control radius" id="education"
                                            name="education">
                                        <option value="">请选择</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校:</span>
                                    <input type="text" name="school" class="form-control"
                                           placeholder="学校" value="${keepon.school }"/>
                                </div>
                            </div>
                        </div>
                        <div id="distpicker2">
                            <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;省:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                        <select class="form-control radius" name="province"
                                                id="province">
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom ">
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;市:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                        <select class="form-control radius" name="city" id="city">
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;县:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                        <select class="form-control radius" name="area" id="area">
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">市&nbsp;场&nbsp;专&nbsp;员:</span>
                                    <select class="form-control radius" name="marketer"
                                            id="marketer">
                                        <option value="">请选择</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>相关信息</legend>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">关&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联:</span><input
                                        type="text" name="associates" class="form-control"
                                        placeholder="关联人" value="${keepon.associates }"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">关&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系&nbsp;:</span>
                                    <select class="form-control radius" id="relation"
                                            name="relationship">
                                        <option value="">请选择</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">Q&nbsp;&nbsp;&nbsp;Q号码:&nbsp;</span>
                                    <input type="text" class="form-control" placeholder="QQ号码"
                                           name="qq" value="${keepon.qq }"/>
                                </div>
                            </div>

                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">咨&nbsp;&nbsp;询&nbsp;&nbsp;师:&nbsp;&nbsp;</span>
                                    <select class="form-control" name="consultationperson"
                                            id="consultationperson">
                                        <option value="">请选择</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">咨&nbsp;询&nbsp;进&nbsp;度:</span><select
                                        class="form-control" id="schedule" name="consultationprocess">
                                </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">咨&nbsp;询&nbsp;分&nbsp;类:</span>
                                    <select class="form-control" name="consultationtype"
                                            id="consult">
                                        <option value="">
                                            请选择&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">市&nbsp;场&nbsp;分&nbsp;类:</span><select
                                        class="form-control" name="markettype" id="market">
                                    <option value="">未选择</option>
                                </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">备&nbsp;案&nbsp;时&nbsp;间:</span>
                                    <input type="text" class="form-control date"
                                           readonly="readonly" placeholder="备案时间" name="keepontime"
                                           value="<fmt:formatDate value="${keepon.keepontime}" pattern="YYYY-MM-dd HH:mm:ss"/>"/>
                                </div>
                            </div>
                        </div>
                        <!--
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">课&nbsp;程&nbsp;体&nbsp;系:</span> <select
                                        class="form-control" name="system" id="system">
                                        <option>请选择</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                            <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业&nbsp;:</span> <select
                                        class="form-control" name="major" id="major">
                                        <option>请选择</option>
                                    </select>
                                </div>
                            </div>

                        </div>
                        -->
                        <!-- 偏移列  用于排版 -->
                        <div
                                class="row col-sm-offset-12 col-md-offset-12 col-lg-offset-12 "></div>
                        <div class="col-sm-12 col-md-12 col-lg-6">
                            <div class="input-group">
                                <span class="input-group-addon">备注信息:&nbsp;&nbsp;</span>
                                <textarea class="form-control" placeholder="备注信息"
                                          name="description" rows="4">${keepon.description }</textarea>
                            </div>
                            <input name="id" type="hidden" value="${keepon.id }"
                                   id="keeponId"/>
                        </div>
                    </fieldset>
                </div>
                <div class="text-center mt-30">
                    <div class="tooltip-demo">
                        <button class="btn btn-primary" id="submits" type="submit">
                            <i class="glyphicon glyphicon-ok"></i>&nbsp;提交
                        </button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button class="btn btn-success" type="reset" id="reset">
                            <i class="glyphicon glyphicon-refresh"></i>&nbsp;重置
                        </button>
                    </div>
                </div>
                <!-- 不允许修改备案人 -->
                <%-- <input name="keeponperson" type="hidden"
                    value="${userSession.realname }"> --%>
            </form>
        </div>
    </div>
</div>
<div class="hr-line-dashed"></div>
<!--请在下方写此页面业务相关的脚本-->
<jsp:include page="/static/iframe/import/_footer.jsp"></jsp:include>
<script type="text/javascript"
        src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/plugins/js/validate/bootstrapValidator.min.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript"
        src="static/iframe/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script src="static/plugins/js/h-ui.3jld/distpicker.data.js"></script>
<script src="static/plugins/js/h-ui.3jld/distpicker.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/plugins/js/window/referparent.js"></script>
<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
<script>
    $(document).ready(function () {
        $(".i-checks").iCheck({
            checkboxClass: "icheckbox_square-green",
            radioClass: "iradio_square-green",
        })
    });

    $(function () {

        //加载3连城市驱动
        $('#distpicker2').distpicker({
            province: "${keepon.province}",
            city: "${keepon.city}",
            district: "${keepon.area}"
        });

        //失去焦点事件
        $("#province,#city,#area").change(
            function () {
                $("#marketer option:not(:first)").remove();
                var province = $("#province").val();
                var city = $("#city").val();
                var area = $("#area").val();
                var date = {
                    province: province,
                    city: city,
                    area: area
                }
                var url = "keepon/selectByPCA";
                $.post(url, date, function (data) {
                    if (data != "") {
                        $("#marketer option:first").remove();
                    } else {
                        $("#marketer option:first").remove();
                        $("<option value=''>请选择</option >").appendTo(
                            "#marketer");
                    }
                    $.each(data, function (i, n) {
                        $(
                            "<option value=" + n.realname + ">"
                            + n.realname + "</option >")
                            .appendTo("#marketer");
                    });
                }, "json");
            });
        //重置表单信息
        $("#reset").click(function () {
            $("#myfrm").data('bootstrapValidator').resetForm();
        });
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

        /*关联人关系*/
        $.post("base/relation", {
            name: "关联人关系"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#relation");
            });
            $("#relation").val(["${keepon.relationship}"]);
        }, "json");

        /*市场分类*/
        $.post("base/market", {
            name: "市场分类"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#market");
            });
        }, "json");

        /*专业
        $.post("base/major", {
            name : "专业"
        }, function(data) {
            $.each(data, function(i, n) {
                $("<option value="+n.value+">" + n.value + "</option >")
                        .appendTo("#major");
            });
        }, "json");*/
        /*专业
        $.post("base/system", {
            name : "课程体系"
        }, function(data) {
            $.each(data, function(i, n) {
                $("<option value="+n.value+">" + n.value + "</option >")
                        .appendTo("#system");
            });
        }, "json");*/

        /*咨询进度*/
        $.post("base/schedule", {
            name: "咨询进度"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#schedule");
            });
            $("#schedule").val(["${keepon.consultationprocess}"]);
        }, "json");

        /*咨询分类*/
        $.post("base/consult", {
            name: "咨询分类"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#consult");
            });
            $("#consult").val(["${keepon.consultationtype}"]);
        }, "json");

        /*咨询师*/
        $.post("user/selectUserByRole", {
            rolecode1: "counselor",
            rolecode2: "Consulting"
        }, function (data) {
            $.each(data, function (i, n) {
                $(
                    "<option value=" + n.realname + ">" + n.realname
                    + "</option >").appendTo(
                    "#consultationperson");
            });
            $("#consultationperson")
                .val(["${keepon.consultationperson}"]);
        }, "json");

        //验证表单
        $("form").bootstrapValidator({
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
                }

            }
            //做ajax请求用到
        }).on('success.form.bv', function (e) {
            e.preventDefault();
            var $form = $(e.target); //拿到form表单
            //请求注册用户
            $.ajax({
                type: "post",
                url: "front/keepon/query/update",
                dataType: "json",
                data: $form.serialize(),
                success: function (result) {
                    if (result.flag) {
                        layer.msg(result.msg, {
                            time: 1500,
                            icon: 1
                        });
                        $("#reset").trigger("click");
                        setTimeout(referParent, 1000);
                    } else {
                        layer.msg(result.msg, {
                            time: 1500,
                            icon: 2
                        });
                    }
                }
            });
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
                            .updateStatus("qq",
                                "NOT_VALIDATED", null);
                    }
                });

        $("input[name='telephone']").keyup(
            function () {
                if ($.trim($(this).val()) != "") {
                    $("form").data("bootstrapValidator").updateStatus(
                        "qq", "VALID", null);
                }
            });

        $("#submit")
            .click(
                function () {
                    setTimeout(
                        function () {
                            if ($("input[name='qq']").val() == ""
                                && $(
                                    "input[name='telephone']")
                                    .val() != ""
                                || $("input[name='qq']")
                                    .val() != ""
                                && $(
                                    "input[name='telephone']")
                                    .val() == "") {
                                $("form").data(
                                    'bootstrapValidator')
                                    .updateStatus("qq",
                                        "VALID", null);
                                $("form").data(
                                    'bootstrapValidator')
                                    .updateStatus(
                                        "telephone",
                                        "VALID", null);
                            }
                        }, 10);
                });
    });
</script>
<script type="text/javascript">
    function province() {
        $("#marketer option:not(:first)").remove();
        var province = $("#province").val();
        var city = $("#city").val();
        var area = $("#area").val();
        var date = {
            province: province,
            city: city,
            area: area
        }
        var url = "keepon/selectByPCA";
        $.post(url, date, function (data) {
            if (data != "") {
                $("#marketer option:first").remove();
            } else {
                $("#marketer option:first").remove();
                $("<option value=''>请选择</option >").appendTo(
                    "#marketer");
            }
            $.each(data, function (i, n) {
                $(
                    "<option value=" + n.realname + ">"
                    + n.realname + "</option >")
                    .appendTo("#marketer");
            });
        }, "json");
    };
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>