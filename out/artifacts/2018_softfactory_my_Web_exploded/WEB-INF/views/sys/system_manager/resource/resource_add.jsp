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
          href="static/iframe/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css"/>
    <link rel="stylesheet"
          href="static/plugins/css/validate/bootstrapValidator.css"/>
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <title>资源管理--添加</title>
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
        }
    </style>
</head>
<body>
<form class="form-horizontal" method="post">
    <div class="page-container">
        <div class="container-fluid">
            <div class="row">
                <div
                        class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom input-margin-bottom  form-group">
                    <div class="input-group">
							<span class="input-group-addon"> <span class="c-red">*&nbsp;</span>&nbsp;&nbsp;资&nbsp;源&nbsp;&nbsp;名&nbsp;称:&nbsp;
							</span> <input type="text" value="${resource.name }"
                                           class="form-control" placeholder="资源名称" name="name"/>
                    </div>
                </div>
                <div
                        class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom input-margin-bottom  form-group">
                    <div class="input-group">
							<span class="input-group-addon"> <span class="c-red">*&nbsp;</span>&nbsp;&nbsp;资&nbsp;源&nbsp;&nbsp;类&nbsp;型:&nbsp;
							</span><select name="type" class="form-control" id="type">
                        <option value="0">菜单</option>
                        <option value="1">按钮</option>
                        <option value="2">超链接</option>
                    </select>
                    </div>
                </div>
                <div
                        class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;&nbsp;资&nbsp;源&nbsp;&nbsp;路&nbsp;径:&nbsp;</span>
                        <input type="text" class="form-control"
                               placeholder="资源路径" name="url"/>
                    </div>
                </div>
                <div
                        class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><span class="c-red">*&nbsp;</span>排&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;序:</span>
                        <input type="number" name="seq" class="form-control"
                        >
                    </div>
                </div>
                <div
                        class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group"
                        id="glyphicon">
                    <div class="input-group">
                        <span class="input-group-addon"><span class="c-red">*&nbsp;</span>图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标:</span>
                        <input class="form-control" name="icon" id="icon"
                               readonly="readonly">
                    </div>
                    <button class="btn btn-primary size-MINI radius">
                        <i class='Hui-iconfont Hui-iconfont-manage'></i>&nbsp;系统
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <i class="Hui-iconfont Hui-iconfont-user2"></i>&nbsp;用户
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <i class="Hui-iconfont Hui-iconfont-root"></i>&nbsp;角色
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <i class="Hui-iconfont Hui-iconfont-tongji-bing">&nbsp;</i>资源
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <i class="Hui-iconfont Hui-iconfont-gongsi">&nbsp;</i>部门
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <i class="Hui-iconfont Hui-iconfont-xianshiqi">&nbsp;</i>前台
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <i class="Hui-iconfont Hui-iconfont-kefu">&nbsp;</i>咨询
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <i class="Hui-iconfont Hui-iconfont-feedback2">&nbsp;</i>市场
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <i class="Hui-iconfont Hui-iconfont-manage2">&nbsp;</i>工具
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <i class='Hui-iconfont Hui-iconfont-add'>&nbsp;</i>添加
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <i class='Hui-iconfont Hui-iconfont-del3'>&nbsp;</i>删除
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <i class='Hui-iconfont Hui-iconfont-edit'>&nbsp;</i>编辑
                    </button>
                    <button class="btn btn-primary size-MINI radius">
                        <i class="Hui-iconfont Hui-iconfont-search2"></i>查询
                    </button>
                </div>
                <div
                        class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><span class="c-red">*&nbsp;</span>状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态:</span>
                        <select class="form-control" name="status" id="status">
                            <option value="0">启用</option>
                            <option value="1">停用</option>
                        </select>
                    </div>
                </div>
                <div
                        class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;&nbsp;资&nbsp;源&nbsp;code:&nbsp;</span>
                        <!-- <select class="form-control" name="resourcecode" id="resourcecode">
                            <option value="resource:add">资源添加</option>
                            <option value="resource:delete">资源删除</option>
                            <option value="resource:update">资源修改</option>
                            <option value="resource:select">资源查询</option>
                        </select> -->

                        <input id="resourcecode" name="resourcecode" type="text" class="form-control"
                               placeholder="资源code"/>
                    </div>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-3 input-margin-bottom">
                    <div class="input-group">
                        <span class="input-group-addon"><span class="c-red">*&nbsp;</span>上级资源名称:</span>
                        <input id="resourceName" type="text" readonly
                               value="${resource.pName }" class="form-control"
                               onclick="showMenu(); "/> <input id="pid"
                                                               name="pid" value="${resource.pid }" type="hidden">
                    </div>
                    <div id="menuContent">
                        <ul id="resourceTree" style="padding-left: 120px; display: none;"
                            class="ztree">
                        </ul>
                    </div>
                </div>
                <div class="col-sm-12 col-md-12 col-lg-6">
                    <div class="input-group">
                        <span class="input-group-addon">&nbsp;&nbsp;&nbsp;资&nbsp;源&nbsp;&nbsp;描&nbsp;述:&nbsp;&nbsp;</span>
                        <textarea name="description" class="form-control" placeholder="资源描述" rows="4"></textarea>
                    </div>
                </div>
            </div>
            <div class="text-right mt-50" style="display: block;">
                <div class="tooltip-demo"
                     style=" bottom: 10; right: 10;">
                    <button class="btn btn-primary" type="submit">
                        <i class="glyphicon glyphicon-ok"></i>&nbsp;编辑
                    </button>
                    &nbsp;
                    <button class="btn btn-success" type="reset" id="reset">
                        <i class="glyphicon glyphicon-refresh"></i>&nbsp;重置
                    </button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<!--请在下方写此页面业务相关的脚本-->
<jsp:include page="/static/iframe/import/_footer.jsp"></jsp:include>
<script src="static/iframe/lib/moment.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/plugins/js/validate/bootstrapValidator.min.js"></script>
<script src="static/plugins/js/window/referparent.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script src="static/plugins/pagejs/system/resource/resource_add.js"></script>
<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->

</html>