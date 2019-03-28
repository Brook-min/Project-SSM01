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
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <title>姓名备注</title>
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
    </style>
</head>
<body>
<div class="page-container">
    <form class="form-horizontal" id="remarkform">
        <div class="container-fluid">
            <div class="row">
                <fieldset>
                    <legend>备案信息</legend>
                    <div class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom">
                        <input type="hidden" value="${consultantObj.id}" name="id">
                        <div class="input-group">
								<span class="input-group-addon"> <!-- <span class="c-red">*&nbsp;</span> -->学员姓名:
								</span> <input type="text" readonly="readonly" class="form-control"
                                               placeholder="学员姓名" value="${consultantObj.studentname}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
                            <input type="text" readonly="readonly" class="form-control"
                                   placeholder="性别" value="${consultantObj.sex}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:</span>
                            <input type="text" readonly="readonly" min="1" max="100"
                                   class="form-control" placeholder="年龄"
                                   value="${consultantObj.age}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">信息来源:</span> <input type="text"
                                                                                readonly="readonly" min="1" max="100"
                                                                                class="form-control"
                                                                                placeholder="信息来源"
                                                                                value="${consultantObj.infosource}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">联系电话:</span> <input type="text"
                                                                                readonly="readonly" class="form-control"
                                                                                placeholder="联系电话"
                                                                                value="${consultantObj.telephone}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">QQ/微信:</span> <input type="text"
                                                                                 readonly="readonly"
                                                                                 class="form-control" placeholder="QQ号码"
                                                                                 value="${consultantObj.qq}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">市场专员:</span> <input type="text"
                                                                                readonly="readonly" min="1" max="100"
                                                                                class="form-control"
                                                                                placeholder="市场专员"
                                                                                value="${consultantObj.marketer}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校:</span>
                            <input type="text" readonly="readonly" class="form-control"
                                   placeholder="学校" value="${consultantObj.school}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:</span>
                            <input type="text" readonly="readonly" class="form-control"
                                   placeholder="学历" value="${consultantObj.education}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">所在区域:</span> <input type="text"
                                                                                class="form-control" readonly="readonly"
                                                                                placeholder="所在区域"
                                                                                value="${consultantObj.area}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">关&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联:</span><input
                                type="text" class="form-control" readonly="readonly"
                                placeholder="关联人" value="${consultantObj.associates}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">关&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系:</span><input
                                type="text" class="form-control" readonly="readonly"
                                placeholder="关系人关系" value="${consultantObj.relationship}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">课程体系:</span> <input type="text"
                                                                                readonly="readonly" class="form-control"
                                                                                placeholder="课程体系"
                                                                                value="${consultantObj.system}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">咨&nbsp;&nbsp;询&nbsp;&nbsp;师:</span><input
                                type="text" class="form-control" readonly="readonly"
                                placeholder="咨询师" value="${consultantObj.consultationperson}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">咨询时间:</span><input type="text"
                                                                               class="form-control" readonly="readonly"
                                                                               value="<fmt:formatDate value='${consultantObj.consultationtime}' pattern='yyyy-HH-dd hh:mm:ss'/>"
                                                                               placeholder="咨询时间"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">咨询进度:</span><input type="text"
                                                                               class="form-control" placeholder="咨询进度"
                                                                               readonly="readonly"
                                                                               value="${consultantObj.consultationprocess}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">联系状态:</span><input type="text"
                                                                               class="form-control" placeholder="联系状态"
                                                                               readonly="readonly"
                                                                               value="${consultantObj.contactstate}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">备&nbsp;案&nbsp;人:&nbsp;&nbsp;</span><input
                                type="text" class="form-control" placeholder="备案人"
                                readonly="readonly" value="${consultantObj.keeponperson}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">备案时间:</span><input type="text"
                                                                               class="form-control" placeholder="备案时间"
                                                                               value="<fmt:formatDate value='${consultantObj.keepontime}' pattern='yyyy-HH-dd hh:mm:ss'/>"
                                                                               readonly="readonly"/>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-6">
                        <div class="input-group">
                            <span class="input-group-addon">备注信息:</span>
                            <textarea class="form-control" readonly="readonly"
                                      placeholder="备注信息" rows="4">${consultantObj.description}</textarea>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>请填写姓名备注</legend>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">姓名备注:</span><input type="text"
                                                                               class="form-control" placeholder="姓名备注"
                                                                               value="${consultantObj.nameremark}"
                                                                               name="nameremark"/>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>
        <div class="text-center mt-30">
            <button class="btn btn-primary" type="button"
                    onclick="send();">
                <i class="glyphicon glyphicon-ok"></i>&nbsp;提交
            </button>
            <button class="btn btn-success" type="reset">
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
<script type="text/javascript"
        src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="static/plugins/js/window/layershow.js"></script>
<script src="static/plugins/js/window/referparent.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script type="text/javascript">
    function send() {
        $.ajax({
            type: "post",
            url: "front/keepon/query/updateRemarkName",
            dataType: "json",
            data: $("#remarkform").serialize(),
            success: function (result) {
                if (result.flag) {
                    layer.msg(result.msg, {
                        time: 1500,
                        icon: 1
                    });
                    setTimeout(function () {
                        referParent();
                    }, 2000);
                }
            },
            error: function (result) {
                layer.msg(result.msg, {
                    time: 1500,
                    icon: 2
                });
            }
        });
    }
</script>
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
            //清空时间按钮
        })

        //bootstrap数据表格
    });
</script>
</html>