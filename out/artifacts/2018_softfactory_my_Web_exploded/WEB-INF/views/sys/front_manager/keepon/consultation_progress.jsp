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
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <title>咨询进度信息</title>
    <style type="text/css">
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

        .table th.text-c, .table td.text-c {
            vertical-align: middle;
        }

        .table tr:nth-child(even) {
            background: #F0F8FF;
        }

        .fixed-table-container .bs-checkbox, .fixed-table-container .no-records-found {
            vertical-align: middle;
        }
    </style>
</head>
<body>
<input type="hidden" name="keeponid" id="keeponid" value="${keeponid}"/>
<div class="page-container">
    <fieldset>
        <legend>备案跟踪记录</legend>
        <!-- 显示备案跟踪信息-->
        <div id="boolbar">
            <a href="javascript:;"
               onclick="assign('学员咨询','consultation_keepon/selectToSultation','${keeponid}')"
               class="btn btn-primary radius"><i class="Hui-iconfont">&#xe692;</i>
                咨询</a>
        </div>
        <table class="table table-bordered table-hover"
               style="white-space: nowrap;" data-pagination="true"
               data-toolbar="#boolbar" data-show-refresh="true"
               data-content-type="application/x-www-form-urlencoded"
               data-undefined-text=" " id="keeponWithConsultation">
            <thead>
            <tr>
                <th class="text-c" data-field="consultationname">咨询师/市场专员</th>
                <th class="text-c" data-field="studenttype">学员分类</th>
                <th data-field="process" class="text-c">咨询进度</th>
                <th data-field="content" class="text-c">咨询信息</th>
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
<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
<script type="text/javascript"
        src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script src="static/iframe/lib/moment.js"></script>
<script type="text/javascript"
        src="static/plugins/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript">
    //初始化表格
    function initTable() {
        //先销毁表格
        $("#keeponWithConsultation").bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据
        $("#keeponWithConsultation").bootstrapTable({
            method: "post", //使用get请求到服务器获取数据
            url: "front/keepon/query/consultionProgress", //获取数据的Servlet地址
            dataType: "json",
            pagination: false, //启动分页
            showColumns: false, //显示下拉框勾选要显示的列
            pageList: [2, 5, 15, 20, 25], //记录数可选列表
            search: false, //是否启用查询
            showRefresh: true, //显示刷新按钮
            clickToSelect: true, //是否启用点击选中行
            sortName: 'consultationtime', //排序字段
            sortOrder: 'desc',//升序或者降序
            singleSelect: true, //设置True 将禁止多选
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

    /*咨询*/
    function assign(title, url, id) {
        window.location.href = url + "?id=" + id;
    }

    /*格式化最后跟踪时间*/
    function fmtCtime(value) {
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }

    $(document).ready(function () {
        initTable();
    })
</script>
</html>