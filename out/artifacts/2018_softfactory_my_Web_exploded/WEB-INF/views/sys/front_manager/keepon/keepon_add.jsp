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
    <link rel="stylesheet"
          href="static/plugins/css/validate/bootstrapValidator.css">
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <title>添加数据备案</title>
    <style>
        fieldset {
            padding: .35em .625em .75em;
            margin: 0 2px;
            border: 1px solid silver;
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
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
    前台管理 <span class="c-gray en">&gt;</span>添加数据备案<a
        class="btn btn-success radius r"
        style="line-height: 1.6em; margin-top: 3px"
        href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a>
</nav>
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
                                                       placeholder="学员姓名"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="c-red">*&nbsp;</span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span><select
                                        class="form-control" name="sex">
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="c-red">*&nbsp;</span>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:</span>
                                    <input type="text" name="age" class="form-control"
                                           placeholder="年龄"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><span class="c-red">*&nbsp;</span>联系电话:</span>
                                    <input type="text" name="telephone" class="form-control"
                                           placeholder="联系电话"/>
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
                                           placeholder="学校"/>
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
                            <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
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
                                        placeholder="关联人"/>
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
                                           name="qq"/>
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
                                          name="description" rows="4"></textarea>
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="text-center mt-30">
                    <div class="tooltip-demo">
                        <button class="btn btn-primary" id="submit" type="submit">
                            <i class="glyphicon glyphicon-ok"></i>&nbsp;提交
                        </button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button class="btn btn-success" type="reset" id="reset">
                            <i class="glyphicon glyphicon-refresh"></i>&nbsp;重置
                        </button>
                    </div>
                </div>
                <input name="keeponperson" type="hidden"
                       value="${userSession.realname}"> <input name="keeponid"
                                                               type="hidden" value="${userSession.id}">
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
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<!--引入三级联动js -->
<script src="static/plugins/js/h-ui.3jld/distpicker.data.js"></script>
<script src="static/plugins/js/h-ui.3jld/distpicker.js"></script>
<script src="static/plugins/js/h-ui.3jld/main.js"></script>
<script>
    $(document).ready(function () {
        $(".i-checks").iCheck({
            checkboxClass: "icheckbox_square-green",
            radioClass: "iradio_square-green",
        })
    });

    $(function () {
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
        //加载3连城市驱动
        $("#distpicker2").distpicker();
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
        }, "json");

        /*学历*/
        $.post("base/education", {
            name: "学历"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#education");
            });
        }, "json");

        /*关联人关系*/
        $.post("base/relation", {
            name: "关联人关系"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#relation");
            });
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
        }, "json");

        /*咨询分类*/
        $.post("base/consult", {
            name: "咨询分类"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#consult");
            });
        }, "json");

        /* /*市场专员
        $.post("user/selectUserByRole", {
            rolename : "市场"
        }, function(data) {
            $.each(data, function(i, n) {
                $(
                        "<option value="+n.realname+">" + n.realname
                                + "</option >").appendTo("#marketer");
            });
        }, "json"); */

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
        }, "json");

        //验证表单
        $("form")
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
                                    message: 'qq号码已经备案',
                                    delay: 1000
                                }
                            }
                        },
                        telephone: {
                            message: '电话验证失败',
                            validators: {
                                notEmpty: {
                                    message: '联系电话不能为空'
                                },
                                regexp: {
                                    regexp: /^0?(13[0-9]|15[0-9]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}$/,
                                    message: '电话号码格式错误,例：18942536166'
                                },
                                remote: {
                                    type: 'post',
                                    url: 'user/selectBytelephone',
                                    message: '电话号码已经备案',
                                    delay: 1000
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
                        }
                    }
                    //做ajax请求用到
                }).on('success.form.bv', function (e) {
            e.preventDefault();
            var $form = $(e.target); //拿到form表单
            //请求注册用户
            $.ajax({
                type: "post",
                url: "front/keepon/add",
                dataType: "json",
                data: $form.serialize(),
                success: function (result) {
                    if (result.flag) {
                        layer.msg(result.msg, {
                            time: 1500,
                            icon: 1
                        });
                        $("#reset").trigger("click");
                        /* window.location.href = "front_keepon/query"; */
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
        $("input[name='qq']").keyup(
            function () {
                if ($.trim($(this).val()) != "") {
                    $("form").data("bootstrapValidator").updateStatus(
                        "telephone", "VALID", null);
                }
            });

        $("#submit").click(
            function () {
                setTimeout(function () {
                    if ($("input[name='qq']").val() == "") {
                        $("form").data('bootstrapValidator')
                            .updateStatus("qq", "NOT_VALIDATED",
                                null);
                    }
                }, 10);

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

        /* 	  $("input[name='qq']").blur(function(){
                  if($("input[name='qq']").val()==""){
                      $("form").data('bootstrapValidator').updateStatus("qq","NOT_VALIDATED",null);
                  }
              });

              $("input[name='qq']").mouseout(function(){
                  if($("input[name='qq']").val()==""){
                      $("form").data('bootstrapValidator').updateStatus("qq","NOT_VALIDATED",null);
                  }
              }); */

    });
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>