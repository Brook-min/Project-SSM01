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
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>真实姓名:</span> <input
                                type="text" class="form-control" readonly="readonly" value="${user.realname}"
                                name="realname" placeholder="真实姓名"/>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3">
                    <div class="form-group">
                        <div class="input-group">
								<span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;&nbsp;用&nbsp;户&nbsp;名&nbsp;
								</span> <input type="text" value="${user.username}" readonly="readonly"
                                               class="form-control" placeholder="用户名" name="username"/> <input
                                type="hidden" name="id" id="userId" value="${user.id}">
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <input type="hidden" id="sexvalue" value="${user.sex}">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
                            <select class="form-control" id="sex" name="sex">
                                <option value="">请选择</option>
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:</span>
                            <input type="text" class="form-control" value="${user.age}"
                                   name="age" placeholder="年龄"/>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="c-red">*&nbsp;</span>&nbsp;电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</span>
                            <input type="text" class="form-control"
                                   value="${user.telephone}" name="telephone" placeholder="电话"/>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon" style="height: 36px;"><span class="c-red">*&nbsp;</span>&nbsp;角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色:</span>
                            <select id="roleid" name="roleid"
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
                    <input type="hidden" id="educationvalue" value="${user.education}">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:</span>
                            <select class="form-control" id="education" name="education">
                                <option value="">请选择</option>
                                <c:forEach items="${education}" var="edu">
                                    <c:if test="${user.education==edu}">
                                        <option value="${user.education}" selected="selected">${user.education}
                                    </c:if>
                                    <c:if test="${user.education!=edu}">
                                        <option value="${edu}">${edu}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">&nbsp;&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</span>
                            <input type="text" class="form-control" value="${user.email}"
                                   name="email" id="email" placeholder="邮箱"/>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">&nbsp;&nbsp;&nbsp;上级名称:</span> <select
                                class="form-control" name="upno">
                            <option value="">请选择</option>
                            <c:forEach items="${userlist}" var="g">
                                <c:if test="${user.upno == g.id}">
                                    <option value="${g.id}" selected="selected">${g.realname}
                                </c:if>
                                <c:if test="${user.upno != g.id}">
                                    <option value="${g.id}">${g.realname}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <input type="hidden" id="showname" value="${user.deptno}">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">&nbsp;&nbsp;&nbsp;部门名称:</span> <input
                                id="deptName" name="deptName" type="text" readonly
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
                            <span class="input-group-addon">&nbsp;&nbsp;省&nbsp;&nbsp;市&nbsp;&nbsp;县:</span>
                            <select class="form-control radius" id="province" name="province">
                            </select>
                            <select class="form-control radius" id="city" name="city">
                            </select>
                            <select class="form-control radius" id="area" name="area">
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-3 ">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">详&nbsp;细&nbsp;地&nbsp;址:</span>
                            <input type="text" class="form-control" value="${user.address}"
                                   name="address" placeholder="详细地址"/>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-3 mb-50">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">&nbsp;&nbsp;描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:</span>
                            <textarea class="form-control" placeholder="描述" rows="4"
                                      name="description">${user.description}</textarea>
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
<c:if test="${user.province == ''}">
    <script src="static/plugins/js/h-ui.3jld/main.js"></script>
</c:if>


<!--引入三级联动js -->

<!-- bootstrap-select -->
<script
        src="static/plugins/js/bootstrap-select/bootstrap-select.min.js"></script>
<script src="static/plugins/js/bootstrap-select/defaults-zh_CN.min.js"></script>
<!-- bootstrap-select -->
<!--  <script src="static/plugins/pagejs/system/user/user_edit.js"></script> -->

<script type="text/javascript">
    $(function () {
        if ("${user.province}" == "") {
            $('#distpicker5').distpicker();
        } else {
            //加载3连城市驱动
            $('#distpicker5').distpicker({
                province: "${user.province}",
                city: "${user.city}",
                district: "${user.area}"
            });
        }
        var array = new Array();
        <c:forEach items="${roleids}" var="r">
        array.push(${r}); //js中可以使用此标签，报错不影响传值，将EL表达式中的值push到数组中
        </c:forEach>
        $('#roleid').selectpicker('val', array);
    });
</script>

<script type="text/javascript">
    $(function () {
        loadDeptNames();

        $("#myform")
            .bootstrapValidator(
                {
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        /* realname : {
                            message : '真实姓名验证失败',
                            validators : {
                                notEmpty : {
                                    message : '真实姓名不能为空'
                                },
                                stringLength : {
                                    min : 2,
                                    max : 6,
                                    message : '真实姓名必须在2到6位之间'
                                },
                                regexp : {
                                    regexp : /^[\u4e00-\u9fa5]{0,}$/,
                                    message : '真实姓名只能包含中文'
                                }
                            }
                        }, */
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
                                    regexp: /^(?:[1-9]?\d|100)$/,
                                    message: '年龄只能是[0-100]岁'
                                }
                            }
                        },
                        telephone: {
                            message: '电话验证失败',
                            validators: {
                                /* remote : {
                                    type : 'post',
                                    url : 'user/selectUserEditBytelephone',
                                    data : {
                                        id:$("#userId").val()
                                    },
                                    message : '电话号码已存在',
                                    delay : 1000
                                }, */
                                notEmpty: {
                                    message: '电话不能为空'
                                },
                                regexp: {
                                    regexp: /^0?(13[0-9]|15[0-9]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}$/,
                                    message: '电话号码格式错误,例：18942536166'
                                }
                            }
                        },
                        email: {
                            message: '邮箱验证失败',
                            validators: {
                                remote: {
                                    type: 'post',
                                    url: 'user/selectUserEditByemail',
                                    data: {
                                        id: $("#userId").val()
                                    },
                                    message: '邮箱已存在',
                                    delay: 1000
                                },
                                regexp: {
                                    regexp: /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
                                    message: '邮箱格式错误,例：www.**@163.com'
                                }
                            }
                        },
                        roleid: {
                            message: '角色无效',
                            validators: {
                                notEmpty: {
                                    message: '角色不可为空'
                                }
                            }
                        }
                    }
                    //做ajax请求用到
                }).on('success.form.bv', function (e) {
            e.preventDefault();
            var $form = $(e.target); //拿到form表单
            layer.load(2, {
                time: 1000
            });
            setTimeout(function () {
                $.ajax({
                    type: "post",
                    url: "user/update",
                    dataType: "json",
                    data: $form.serialize(),
                    success: function (result) {
                        if (result.flag) {
                            layer.msg(result.msg, {
                                time: 1500,
                                icon: 1
                            });
                            setTimeout(function () {
                                window.parent.location.reload();
                            }, 1500);
                        } else {
                            layer.msg(result.msg, {
                                time: 1500,
                                icon: 2
                            });
                        }
                    },
                    error: function (result) {
                        layer.msg(result.msg, {
                            time: 1500,
                            icon: 2
                        });
                    },
                });
            }, 1000);
        });

        $("#reset").click(function () {
            loadDeptNames();
            //页面刷新
            window.location.reload();

        });

        //邮箱单独验证********************************************************
        $("#email").mouseout(function () {
            if ($("#email").val() == "") {
                $("#myform").data('bootstrapValidator').updateStatus("email", "NOT_VALIDATED", null);
            }
        });

        $("#email").blur(function () {
            if ($("#email").val() == "") {
                $("#myform").data('bootstrapValidator').updateStatus("email", "NOT_VALIDATED", null);
            }
        });

        //点击提交按钮消除email样式
        $("#submit").click(function () {
            setTimeout(function () {
                if ($("#email").val() == "") {
                    $("#myform").data('bootstrapValidator').updateStatus("email", "NOT_VALIDATED", null);
                }
            }, 500);
        });
        //邮箱单独验证********************************************************


        //加载锁
        $("#locked option[value='" + $("#lockedvalue").val() + "']").attr(
            'selected', true);
        //加载性别
        $("#sex option[value='" + $("#sexvalue").val() + "']").attr(
            'selected', true);
        //加载学历
        $("#education option[value='" + $("#educationvalue").val() + "']")
            .attr('selected', true);

    });
</script>
<script type="text/javascript">
    //配置
    var setting = {
        view: {
            dblClickExpand: true,
            selectedMulti: true, //是否允许多选
            txtSelectedEnable: true, //是否允许选中节点的文字
            autoCancelSelected: true, //不允许按下Ctrl键取消节点选中状态
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onClick: onClick
        }
    };

    //点击节点时
    function onClick(e, treeId, treeNode) {
        //获取树
        var zTree = $.fn.zTree.getZTreeObj("deptTree");
        //获取所有的节点
        var nodes = zTree.getSelectedNodes(), v = "";
        id = "";
        nodes.sort(function compare(a, b) {
            return a.id - b.id;
        });
        for (var i = 0, l = nodes.length; i < l; i++) {
            v += nodes[i].deptname + ",";
            id += nodes[i].id + ",";
        }
        if (id.length > 0)
            id = id.substring(0, id.length - 1);
        if (v.length > 0)
            v = v.substring(0, v.length - 1);

        //资源名称
        $("#deptName").val(v);
        //资源编号
        $("#deptno").val(id);
        //点击后隐藏
        $("#myform").data("bootstrapValidator").updateStatus("deptName",
            "VALID", null);
        hideMenu();
        return false;
    }

    //显示菜单
    function showMenu() {

        if ($("#deptTree").css("display") == 'none') {
            $("#deptTree").stop().show();
        } else {
            $("#deptTree").stop().hide();
        }
    }

    //隐藏菜单
    function hideMenu() {
        $("#deptTree").stop().hide();
    }

    //点击body时
    function onBodyDown(event) {
        if (!(event.target.id == "menuBtn"
            || event.target.id == "menuContent" || $(event.target)
                .parents("#menuContent").length > 0)) {
            hideMenu();
        }
    }

    //加载时发生
    $(document).ready(function () {
        var zNodes;
        //获取数据
        $.getJSON('dept/Tree', function (data) {
            //初始化tree
            $.fn.zTree.init($("#deptTree"), setting, data);
        });
    });

    function loadDeptNames() {
        //加载部门名称
        $.ajax({
            type: 'get',
            url: 'user/showName',
            dataType: 'json',
            data: {
                "id": $("#showname").val()
            },
            success: function (data) {
                $("#deptName").val(data.msg);
            },
            error: function (data) {
            },
        });
    }
</script>

<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->

</body>
</html>