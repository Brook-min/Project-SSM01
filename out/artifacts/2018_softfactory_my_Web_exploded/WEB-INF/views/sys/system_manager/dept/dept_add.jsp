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
    <title>部门管理--添加</title>
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
        <form class="form-horizontal" id="dept_add" method="post">
            <div class="row">
                <div
                        class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom input-margin-bottom form-group">
                    <div class="input-group">
							<span class="input-group-addon"> <span class="c-red">*&nbsp;</span>&nbsp;部&nbsp;门&nbsp;&nbsp;名&nbsp;称:&nbsp;
							</span> <input type="text" class="form-control" placeholder="部门名称"
                                           name="deptname"/>
                    </div>
                </div>
                <div
                        class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><span class="c-red">*&nbsp;</span>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:</span>
                        <input type="text" class="form-control" placeholder="地址"
                               name="address"/>
                    </div>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom "
                     id="glyphicon">
                    <div class="input-group">
                        <span class="input-group-addon"><span class="c-red">*&nbsp;</span>图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标:</span>
                        <input class="form-control" name="icon" id="icon" readonly
                               value="Hui-iconfont Hui-iconfont-manage2">
                    </div>
                    <button class="btn btn-primary size-MINI radius">
                        <span class="Hui-iconfont Hui-iconfont-manage2"></span>技术部
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <span class="Hui-iconfont Hui-iconfont-shuru"></span>开发部
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <span class="Hui-iconfont Hui-iconfont-user2"></span>人事部
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <span class="Hui-iconfont Hui-iconfont-jieri"></span>后勤部
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <span class="Hui-iconfont Hui-iconfont Hui-iconfont-kefu"></span>咨询部
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <span class="Hui-iconfont Hui-iconfont Hui-iconfont-tongji"></span>销售部
                    </button>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                    <div class="input-group">
                        <span class="input-group-addon">&nbsp;&nbsp;上级部门名称:</span>
                        <input id="deptName" type="text" readonly
                               class="form-control" onclick="showMenu(); "/>
                        <!-- 部门编号 -->
                        <input id="id" name="pid" type="hidden">
                    </div>
                    <div id="menuContent">
                        <ul id="deptTree" style="padding-left:120px;display:none;" class="ztree">
                        </ul>
                    </div>
                </div>
                <div class="col-sm-12 col-md-8 col-lg-8 mt-20 input-margin-bottom">
                    <div class="input-group">
                        <span class="input-group-addon">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:</span>
                        <textarea rows="4" class="form-control" name="description"
                                  placeholder="描述"></textarea>
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
<script type="text/javascript" src="static/plugins/pagejs/system/dept/dept_add.js"></script>
</html>