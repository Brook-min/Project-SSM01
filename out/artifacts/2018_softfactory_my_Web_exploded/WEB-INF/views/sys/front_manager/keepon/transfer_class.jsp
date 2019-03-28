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
    <link rel="stylesheet"
          href="static/plugins/css/bootstrap-table/bootstrap-table.min.css"/>
    <link rel="stylesheet"
          href="static/plugins/css/validate/bootstrapValidator.css">
    <link rel="stylesheet"
          href="static/plugins/css/datetimepicker/bootstrap-datetimepicker.min.css"/>
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <title>转进班</title>
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
    <form class="form-horizontal" id="inClassform">
        <div class="container-fluid">
            <div class="row">
                <fieldset>
                    <legend>备案信息</legend>
                    <input type="hidden" name="id" value="${keepon.id}">
                    <div class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon"> 学员姓名: </span> <input
                                type="text" readonly="readonly" class="form-control"
                                placeholder="学员姓名" id="studentName"
                                value="${keepon.studentname}"/>
                        </div>
                    </div>
                    <div
                            class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom form-group">
                        <div class="input-group">
								<span class="input-group-addon"><span class="c-red">*&nbsp;</span>姓名备注:
								</span> <input type="text" class="form-control" placeholder="姓名备注"
                                               name="nameremark" value="${keepon.nameremark }" readonly="readonly"/>
                        </div>
                    </div>

                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">联系电话:</span> <input type="text"
                                                                                class="form-control" readonly="readonly"
                                                                                value="${keepon.telephone}"
                                                                                placeholder="联系电话"/>
                        </div>
                    </div>

                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
                            <input type="text" class="form-control" readonly="readonly"
                                   value="${keepon.sex}" placeholder="性别"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:</span>
                            <input type="text" class="form-control" readonly="readonly"
                                   value="${keepon.age}" placeholder="年龄"/>
                        </div>
                    </div>

                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">QQ/微信:</span> <input type="text"
                                                                                 class="form-control"
                                                                                 readonly="readonly" placeholder="QQ号码"
                                                                                 value="${keepon.qq}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">校&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区:</span>
                            <input type="text" class="form-control" readonly="readonly"
                                   placeholder="校区" value="${keepon.schoolarea}"/>
                        </div>
                    </div>

                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">课程体系:</span> <input type="text"
                                                                                class="form-control" readonly="readonly"
                                                                                value="${keepon.system}"
                                                                                placeholder="课程体系"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">目前状态:</span> <input type="text"
                                                                                class="form-control" readonly="readonly"
                                                                                placeholder="目前状态"
                                                                                value="${keepon.nowstatus}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校:</span>
                            <input type="text" readonly="readonly" value="${keepon.school}"
                                   class="form-control" placeholder="学校"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:</span>
                            <input type="text" class="form-control" readonly="readonly"
                                   value="${keepon.education}" placeholder="学历"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">所在区域:</span> <input type="text"
                                                                                readonly="readonly" class="form-control"
                                                                                value="${keepon.area}"
                                                                                placeholder="所在区域"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">培训形式:</span> <input type="text"
                                                                                class="form-control"
                                                                                value="${keepon.trainingtype}"
                                                                                readonly="readonly" placeholder="培训形式"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">招生主管:</span> <input type="text"
                                                                                readonly="readonly"
                                                                                value="${keepon.supervisor}"
                                                                                class="form-control"
                                                                                placeholder="招生主管"/>
                        </div>
                    </div>

                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">市场专员:</span> <input type="text"
                                                                                readonly="readonly"
                                                                                value="${keepon.marketer}"
                                                                                class="form-control"
                                                                                placeholder="招生专员"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">咨&nbsp;&nbsp;询&nbsp;&nbsp;师:</span>
                            <input type="text" readonly="readonly"
                                   value="${keepon.consultationperson}" class="form-control"
                                   placeholder="咨询师"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="input-group">
                            <span class="input-group-addon">信息来源:</span> <input type="text"
                                                                                readonly="readonly"
                                                                                value="${keepon.infosource}"
                                                                                class="form-control"
                                                                                placeholder="信息来源"/>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-6 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">备注信息:</span>
                            <textarea class="form-control" readonly="readonly"
                                      placeholder="备注信息" rows="4">${keepon.description}</textarea>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>转进班信息</legend>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="c-red">*&nbsp;</span>进班时间:</span>
                                <input type="text" placeholder="进班时间" readonly="readonly"
                                       id="inclasstime" class="form-control date" name="shifttime"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="c-red">*&nbsp;</span>进班班级:</span>
                                <select class="form-control" id="inclass" name="shiftclass">
                                    <option value="">请选择</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="c-red">*&nbsp;</span>缴费金额:</span>
                                <input type="text" class="form-control" placeholder="缴费金额"
                                       title="元" id="money" name="paymoney"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="c-red">*&nbsp;</span>班&nbsp;&nbsp;主&nbsp;&nbsp;任:</span>
                                <select class="form-control" id="headmaster" name="headmaster">
                                    <option value="">请选择</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>
        <div class="form-bottom">
            <div class="text-center mt-40">
                <button class="btn btn-primary" type="submit">
                    <i class="glyphicon glyphicon-ok"></i>&nbsp;提交
                </button>
                <button class="btn btn-success" id="reset" type="reset">
                    <i class="glyphicon glyphicon-refresh"></i>&nbsp;重置
                </button>
                <a class="btn btn-white" href="javascript:layer_close()"
                   target="_blank"><i class="glyphicon glyphicon-share-alt"></i>&nbsp;返回</a>
            </div>
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
<script type="text/javascript"
        src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/plugins/js/validate/bootstrapValidator.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="static/plugins/js/window/layershow.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>

<script type="text/javascript">
    $(function () {
        //bootstrap时间控件
        $('.date').datetimepicker({
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd HH:mm:ss',//显示格式
            minView: "month",//设置只显示到月份
            //endDate : new Date(),
            autoclose: true,//选中自动关闭
            todayBtn: true,//显示今日按钮
            clearBtn: true
            //清除按钮
            //清空时间按钮
        });

        /*进班班级*/
        $.post("base/shiftclass", {
            name: "进班班级"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#inclass");
            });
        }, "json");

        /*班主任*/
        $.post("base/headmaster", {
            name: "班主任"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#headmaster");
            });
        }, "json");

        //bootstrap数据表格
        $("#inClassform")
            .bootstrapValidator(
                {
                    excluded: [':disabled'],
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        shifttime: {
                            message: '时间验证失败',
                            validators: {
                                notEmpty: {
                                    message: '时间不能为空'
                                }
                            }
                        },
                        shiftclass: {
                            message: '班级验证失败',
                            validators: {
                                notEmpty: {
                                    message: '班级不能为空'
                                }
                            }
                        },
                        paymoney: {
                            message: '金额验证失败',
                            validators: {
                                notEmpty: {
                                    message: '金额不能为空'
                                },
                                regexp: {
                                    regexp: /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/,
                                    message: '金额验证失败'
                                }
                            }
                        },
                        headmaster: {
                            message: '班主任验证失败',
                            validators: {
                                notEmpty: {
                                    message: '班主任不能为空'
                                }
                            }
                        }
                    }
                    //做ajax请求用到
                })
            .on(
                'success.form.bv',
                function (e) {
                    e.preventDefault();
                    layer
                        .confirm(
                            "<font color='red'>"
                            + $("#studentName").val()
                            + "</font> 同学<br/><font color='red'>"
                            + $("#inclasstime").val()
                            + "</font>  进入 <font color='red'>"
                            + $("#inclass").val()
                            + "</font>  班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>班主任为：<font color='red'>"
                            + $("#headmaster").val()
                            + "<br/></font> 共缴费金额为：<font color='red' size='+1;'' >"
                            + $("#money").val()
                            + "</font> 元，您确定吗？",
                            function (index) {
                                layer.load(2, {
                                    time: 1000
                                });
                                setTimeout(
                                    function () {
                                        //请求注册用户
                                        $
                                            .ajax({
                                                type: "post",
                                                url: "front/keepon/toInClass",
                                                dataType: "json",
                                                data: $(
                                                    "#inClassform")
                                                    .serialize(),
                                                success: function (
                                                    result) {
                                                    if (result.flag) {
                                                        layer
                                                            .msg(
                                                                result.msg,
                                                                {
                                                                    time: 1500,
                                                                    icon: 1
                                                                });
                                                        setTimeout(
                                                            function () {
                                                                window.parent.location
                                                                    .reload();
                                                            },
                                                            1500);
                                                    } else {
                                                        layer
                                                            .msg(
                                                                result.msg,
                                                                {
                                                                    time: 1500,
                                                                    icon: 2
                                                                });
                                                    }
                                                }
                                            });
                                    }, 1000);
                            });
                    $('#inClassform').bootstrapValidator(
                        'disableSubmitButtons', false);
                });

        $("#reset").on("click", function () {
            $("#inClassform").data('bootstrapValidator').resetForm();
        });

        $("input[name='shifttime']").change(
            function () {
                $("#inClassform").data('bootstrapValidator').updateStatus(
                    "shifttime", "NOT_VALIDATED", null);
                $("#inClassform").data('bootstrapValidator').validateField(
                    'shifttime');
            });

    });
</script>
</html>