<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <title>市场---添加咨询信息</title>
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

        .fixed-table-body {
            height: auto;
        }

        .dropdown-toggle {
            background-color: rgb(230, 230, 230);
        }
    </style>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
    市场管理 <span class="c-gray en">&gt;</span>添加咨询信息<a
        class="btn btn-success radius r"
        style="line-height: 1.6em; margin-top: 3px"
        href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <form class="form-horizontal" id="consultationForm">
        <input type="hidden" name="keeponid" id="keeponid"
               value="${keepon.id}"/> <input type="hidden" name="consultationid"
                                             value="${userSession.id}"/> <input type="hidden"
                                                                                name="consultationname"
                                                                                value="${userSession.realname}"/>
        <div class="container-fluid">
            <div class="row">
                <fieldset>
                    <legend>备案信息</legend>
                    <div class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom">
                        <div class="input-group">
								<span class="input-group-addon"> <!-- <span class="c-red">*&nbsp;</span> -->学员姓名:
								</span> <input type="text" name="studentname"
                                               value="${keepon.studentname}" readonly="readonly"
                                               class="form-control" placeholder="学员姓名"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3  input-margin-bottom">
                        <div class="input-group">
								<span class="input-group-addon"> <!-- <span class="c-red">*&nbsp;</span> -->姓名备注:
								</span> <input type="text" name="nameremark"
                                               value="${keepon.nameremark}" readonly="readonly"
                                               class="form-control" placeholder="姓名备注"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
                            <input type="text" readonly="readonly" class="form-control"
                                   placeholder="性别" name="sex" value="${keepon.sex}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:</span>
                            <input type="text" readonly="readonly" min="1" max="100"
                                   class="form-control" name="age" value="${keepon.age}"
                                   placeholder="年龄"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">联系电话:</span> <input type="text"
                                                                                readonly="readonly" class="form-control"
                                                                                placeholder="联系电话"
                                                                                name="telephone"
                                                                                value="${keepon.telephone}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">QQ/微信:</span> <input type="text"
                                                                                 readonly="readonly"
                                                                                 class="form-control" placeholder="QQ号码"
                                                                                 name="qq" value="${keepon.qq}"/>
                        </div>
                    </div>

                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校:</span>
                            <input type="text" readonly="readonly" class="form-control"
                                   placeholder="学校" name="school" value="${keepon.school}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:</span>
                            <input type="text" readonly="readonly" class="form-control"
                                   placeholder="学历" name="education" value="${keepon.education}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">所在区域:</span> <input type="text"
                                                                                class="form-control" name="area"
                                                                                value="${keepon.area }"
                                                                                readonly="readonly" placeholder="所在区域"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">信息来源:</span><input type="text"
                                                                               class="form-control"
                                                                               value="${keepon.infosource}"
                                                                               name="infosource" readonly="readonly"
                                                                               placeholder="信息来源"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">关&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联:</span><input
                                type="text" class="form-control" readonly="readonly"
                                placeholder="关联人" name="associates"
                                value="${keepon.associates}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">关&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系:</span><input
                                type="text" class="form-control" value="${keepon.relationship}"
                                name="relationship" readonly="readonly" placeholder="关系人关系"/>
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
                            <span class="input-group-addon">咨&nbsp;询&nbsp;师:&nbsp;&nbsp;</span><input
                                type="text" name="consultationperson"
                                value="${keepon.consultationperson}" class="form-control"
                                readonly="readonly" placeholder="咨询师"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">咨询时间:</span><input type="text"
                                                                               class="form-control"
                                                                               name="consultationtime"
                                                                               value="<fmt:formatDate value="${keepon.consultationtime}" pattern="yyyy-MM-dd hh:mm:ss"/>"
                                                                               readonly placeholder="咨询时间"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">咨询进度:</span><input type="text"
                                                                               class="form-control"
                                                                               name="consultationprocess"
                                                                               value="${keepon.consultationprocess}"
                                                                               placeholder="咨询进度"
                                                                               readonly="readonly"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">联系状态:</span><input type="text"
                                                                               class="form-control" name="contactstate"
                                                                               value="${keepon.contactstate}"
                                                                               placeholder="联系状态"
                                                                               readonly="readonly"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">备&nbsp;案&nbsp;人:&nbsp;&nbsp;</span><input
                                type="text" class="form-control" placeholder="备案人"
                                readonly="readonly" name="keeponperson"
                                value="${keepon.keeponperson}"/>
                        </div>
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">备案时间:</span><input type="text"
                                                                               class="form-control"
                                                                               value="<fmt:formatDate value="${keepon.keepontime}" pattern="yyyy-MM-dd hh:mm:ss"/>"
                                                                               name="keepontime" placeholder="备案时间"
                                                                               readonly="readonly"/>
                        </div>
                    </div>

                    <div class="col-sm-12 col-md-12 col-lg-6">
                        <div class="input-group">
                            <span class="input-group-addon">备注信息:</span>
                            <textarea class="form-control" name="description"
                                      readonly="readonly" placeholder="备注信息" rows="4">${keepon.description}</textarea>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>咨询信息</legend>
                    <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">咨询进度:</span> <select
                                class="form-control" id="schedule" name="process">
                        </select>
                        </div>
                    </div>
                    <div class="col-sm-3 col-md-4 col-lg-3 input-margin-bottom">
                        <div class="input-group">
                            <span class="input-group-addon">学员分类:</span> <select
                                class="form-control" name="studenttype" id="studenttype">
                        </select>
                        </div>
                    </div>
                    <div
                            class="col-sm-12 col-md-12 col-lg-12 col-sm-offset-3 col-md-offset-4 col-lg-offset-3">
                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-6">
                        <div class="input-group">
                            <span class="input-group-addon">咨询信息:</span>
                            <textarea class="form-control" name="content" placeholder="备注信息"
                                      rows="4"></textarea>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>
        <div class="text-center mt-30">
            <button class="btn btn-primary" type="button" id="subConsulation">
                <i class="glyphicon glyphicon-ok"></i>&nbsp;提交
            </button>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <button class="btn btn-success" type="reset">
                <i class="glyphicon glyphicon-refresh"></i>&nbsp;重置
            </button>
            <a class="btn btn-white" href="javascript:window.history.go(-1);"
               target="_blank"><i class="glyphicon glyphicon-share-alt"></i>&nbsp;返回</a>
        </div>
    </form>
    <fieldset>
        <legend>备案跟踪记录</legend>
        <!-- 显示备案跟踪信息-->
        <table class="table table-bordered table-hover"
               style="white-space: nowrap;" class="table table-hover"
               data-pagination="true" data-toolbar="#boolbar"
               data-show-refresh="true"
               data-content-type="application/x-www-form-urlencoded"
               data-undefined-text=" " id="keeponWithConsultation">
            <thead>
            <tr>
                <th class="text-c" data-field="consultationname">咨询师/市场专员</th>
                <th class="text-c" data-field="studenttype">学员分类</th>
                <th data-field="process" class="text-c">咨询进度</th>
                <th data-field="content" class="text-c"
                    data-formatter="fmtInformation">咨询信息
                </th>
                <th data-field="consultationtime" class="text-c"
                    data-formatter="fmtCtime">最后跟踪时间
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </fieldset>
</div>
</body>
<!--_footer 作为公共模版分离出去-->
<jsp:include page="/static/iframe/import/_footer.jsp"></jsp:include>
<!--请在下方写此页面业务相关的脚本 -->
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="static/iframe/lib/moment.js"></script>
<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
<script type="text/javascript"
        src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
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

        /*咨询进度*/
        $.post("base/schedule", {
            name: "咨询进度"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#schedule");
            });
        }, "json");

        /*学生分类*/
        $.post("base/studentType", {
            name: "学员分类"
        }, function (data) {
            $.each(data, function (i, n) {
                $("<option value=" + n.value + ">" + n.value + "</option >")
                    .appendTo("#studenttype");
            });
        }, "json");

        /*提交表单*/
        $("#subConsulation").click(function () {
            //console.log($("#consultationForm").serialize());
            //alert($("#consultationForm").serialize());
            $.ajax({
                type: "post",
                url: "consultation_keepon/add",
                dataType: "json",
                data: $("#consultationForm").serialize(),
                success: function (result) {
                    if (result.flag) {
                        layer.msg(result.msg, {
                            time: 1200,
                            icon: 1
                        });
                        setTimeout(function () {
                            window.location.reload();
                        }, 1200);
                    } else {
                        layer.msg(result.msg, {
                            time: 1200,
                            icon: 2
                        });
                    }
                }
            });
        });
    });
</script>
<script type="text/javascript">
    //初始化表格
    function initTable() {
        //先销毁表格
        $("#keeponWithConsultation").bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据
        $("#keeponWithConsultation").bootstrapTable({
            method: "post", //使用get请求到服务器获取数据
            url: "consultation_keepon/selectConsultationWithKeepon", //获取数据的Servlet地址
            dataType: "json",
            striped: true, //表格显示条纹
            pagination: false, //启动分页
            pageList: [5, 15, 20, 25], //记录数可选列表
            search: false, //是否启用查询
            showColumns: false, //显示下拉框勾选要显示的列
            showRefresh: true, //显示刷新按钮
            clickToSelect: false, //是否启用点击选中行
            sortName: 'consultationtime', //排序字段
            sortOrder: 'desc',//升序或者降序
            sidePagination: "server", //表示服务端请求
            paginationLoop: false,
            queryParamsType: "limit",
            icons: {
                refresh: 'glyphicon-repeat',
                toggle: 'glyphicon-list-alt',
                columns: 'glyphicon-list'
            },
            queryParams: function queryParams(params) { //设置查询参数
                var param = {
                    offset: params.offset,
                    limit: params.limit,
                    id: $("#keeponid").val()
                };
                return param;
            },
            onLoadError: function () { //加载失败时执行
                layer.msg("加载数据失败", {
                    time: 1500,
                    icon: 2
                });
            }
        });
    }

    /*格式化最后跟踪时间*/
    function fmtCtime(value) {
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }

    //控制咨询信息每行显示30个字符
    function fmtInformation(value) {
        var temp = "";
        var len = value.length;
        for (var i = 0; i < len; i++) {
            if ((i + 1) % 30 == 0) {
                temp += "<br/>";
            }
            temp += value.charAt(i);
        }
        return temp;
    }

    $(document).ready(function () {
        initTable();
    })
</script>
</html>