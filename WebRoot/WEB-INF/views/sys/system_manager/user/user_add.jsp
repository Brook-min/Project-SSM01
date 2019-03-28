<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="static/plugins/css/bootstap-select/bootstrap-select.min.css"/>
    <link rel="stylesheet"
          href="static/plugins/css/validate/bootstrapValidator.css">
    <link rel="stylesheet"
          href="static/iframe/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css"/>

    <title>用户管理</title>

    <style>
        .input-margin-bottom {
            margin-bottom: 20px;
        }

        .form-horizontal .form-group {
            height: 48px;
            margin-left: 0px;
            margin-right: 0px;
        }

        .bootstrap-select.btn-group .dropdown-toggle .filter-option {
            width: 240px;
            overflow-x: auto;
        }
    </style>
</head>
<body>

<div class="page-container">
    <div class="container-fluid">
        <form class="form-horizontal" method="post" id="myform">
            <div class="row">
                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;真实姓名:</span>
                            <input type="text" class="form-control" id="realname"
                                   name="realname" placeholder="真实姓名"/>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3">
                    <div class="form-group">
                        <div class="input-group">
								<span class="input-group-addon"> <span class="c-red">*&nbsp;</span>&nbsp;用&nbsp;&nbsp;户&nbsp;&nbsp;名&nbsp;
								</span> <input type="text" id="makeusername" readonly="readonly"
                                               class="form-control" placeholder="用户名" name="username"/>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</span>
                            <input type="password" class="form-control" name="password"
                                   placeholder="密码"/>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="hidden" value="0" name="locked"> <span
                                class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;确认密码:</span>
                            <input type="password" class="form-control" name="surepassword"
                                   placeholder="密码"/>
                        </div>
                    </div>
                </div>

                <!-- 盐值 -->
                <!-- 	<div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;盐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</span>
                             <input type="text" class="form-control" name="salt" placeholder="盐" />
                        </div>
                    </div>
                </div> -->

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
                            <select class="form-control" name="sex">
                                <option selected="selected" value="">请选择</option>
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:</span>
                            <input type="text" class="form-control" name="age"
                                   placeholder="年龄"/>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</span>
                            <input type="text" class="form-control" name="telephone"
                                   placeholder="电话"/>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
								<span class="input-group-addon" style="height: 36px;"><span
                                        class="c-red">*&nbsp;</span>角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色:</span>
                            <select id="roleidForSelect" name="roleid"
                                    class="selectpicker show-tick form-control" multiple
                                    data-live-search="false">
                                <c:forEach items="${roles}" var="role">
                                    <option value="${role.id}">${role.rolename}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:</span>
                            <select class="form-control" name="education">
                                <option value="">请选择</option>
                                <c:forEach items="${education}" var="edu">
                                    <option ${edu}>${edu}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</span>
                            <input type="text" class="form-control" id="email" name="email"
                                   placeholder="邮箱"/>
                        </div>
                    </div>
                </div>


                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;上级名称:</span>
                            <select class="form-control" name="upno">
                                <option value="0">请选择</option>
                                <c:forEach items="${gradName}" var="g">
                                    <option value="${g.id}">${g.realname}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;部门名称:</span>
                            <input id="deptName" name="deptName" type="text" readonly
                                   class="form-control" onclick="showMenu(); "/>
                            <!-- 部门编号 -->
                            <input id="deptno" name="deptno" type="hidden"/>
                        </div>
                    </div>
                    <div id="menuContent" style="position: relative; top: -30px;">
                        <ul id="deptTree" style="padding-left: 100px; display: none;"
                            class="ztree">
                        </ul>
                    </div>
                </div>

                <div
                        class="col-sm-4 col-md-4 col-lg-3 col-sm-offset-8 col-md-offset-8 col-lg-offset-9"></div>
                <div class="col-sm-4 col-md-4 col-lg-3"
                     style="margin-bottom: 70px;">
                    <div class="form-group">
                        <div class="input-group" id="distpicker5">
                            <span class="input-group-addon">&nbsp;&nbsp;&nbsp;省&nbsp;&nbsp;市&nbsp;&nbsp;县:</span>
                            <select class="form-control radius" name="province">
                            </select> <select class="form-control radius" name="city">
                        </select> <select class="form-control radius" name="area">
                        </select>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">详&nbsp;细&nbsp;地&nbsp;址:</span> <input
                                type="text" class="form-control" name="address"
                                placeholder="详细地址"/>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-3 mb-50"
                     style="margin-top: 6px;">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:</span>
                            <textarea class="form-control" placeholder="描述" rows="4"
                                      name="description"></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="text-r mt-15" style="display: block;">
                <div class="tooltip-demo">
                    <button class="btn btn-primary" id="submit" type="submit">
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


<script type="text/javascript"
        src="static/iframe/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script type="text/javascript"
        src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/plugins/js/validate/bootstrapValidator.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>

<!--引入三级联动js -->
<script src="static/plugins/js/h-ui.3jld/distpicker.data.js"></script>
<script src="static/plugins/js/h-ui.3jld/distpicker.js"></script>
<script src="static/plugins/js/h-ui.3jld/main.js"></script>
<!--引入三级联动js -->
<!-- bootstrap-select -->
<script
        src="static/plugins/js/bootstrap-select/bootstrap-select.min.js"></script>
<script src="static/plugins/js/bootstrap-select/defaults-zh_CN.min.js"></script>
<!-- bootstrap-select -->
<!-- 页面js -->
<script src="static/plugins/pagejs/system/user/user_add.js"></script>

<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->

</body>
</html>