$(function () {

    $('#roleidForSelect').selectpicker({
        'selectedText': 'cat'
    });

    $('.selectpicker').selectpicker('val', 'Mustard');

    // 加载3连城市驱动
    $("#distpicker5").distpicker();
    // 加载上级名称
    $("#myform")
        .bootstrapValidator(
            {
                excluded: [':disabled'],
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    password: {
                        message: '密码验证失败',
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            },
                            stringLength: {
                                min: 6,
                                max: 15,
                                message: '密码长度必须在6到15位之间'
                            },
                            regexp: {
                                regexp: /^[a-zA-Z0-9_]+$/,
                                message: '密码只能包含大写、小写、数字和下划线'
                            },
                            different: {
                                field: 'username',
                                message: '密码不能和用户名相同'
                            }
                        }
                    },
                    surepassword: {
                        message: '密码重复还没有验证',
                        validators: {
                            notEmpty: {
                                message: '密码重复不能为空'
                            },
                            stringLength: {
                                min: 6,
                                max: 15,
                                message: '密码长度在6到15之间'
                            },
                            identical: {
                                field: 'password',
                                message: '两次密码不同请重新输入'
                            }
                        }
                    },
                    realname: {
                        message: '真实姓名验证失败',
                        validators: {
                            notEmpty: {
                                message: '真实姓名不能为空'
                            },
                            stringLength: {
                                min: 2,
                                max: 6,
                                message: '真实姓名必须在2到6位之间'
                            },
                            regexp: {
                                regexp: /^[\u4e00-\u9fa5]{0,}$/,
                                message: '真实姓名只能包含中文'
                            }
                        }
                    },
                    username: {
                        message: '性别验证失败',
                        validators: {
                            notEmpty: {
                                message: '用户名不能为空'
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
                    /*
                     * 盐 salt : { message : '盐验证失败', validators : {
                     * notEmpty : { message : '盐值不能为空' }, stringLength : {
                     * min : 4, max : 6, message :
                     * '盐值必须在4到6位之间,颜值设置后不可修改' } } },
                     */
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
                                url: 'user/selectUserByemail',
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
                // 做ajax请求用到
            }).on('success.form.bv', function (e) {
        e.preventDefault();
        var $form = $(e.target); // 拿到form表单
        layer.load(2, {
            time: 1000
        });
        setTimeout(function () {
            // 请求注册用户
            $.ajax({
                type: "post",
                url: "user/add",
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
                }
            });
        }, 1000);
    });

    // 清空表格样式
    $("#reset").click(function () {
        $("#myform").data('bootstrapValidator').resetForm();

    });

    // 邮箱单独验证********************************************************
    $("#email").mouseout(
        function () {
            if ($("#email").val() == "") {
                $("#myform").data('bootstrapValidator').updateStatus(
                    "email", "NOT_VALIDATED", null);
            }
        });

    $("#email").blur(
        function () {
            if ($("#email").val() == "") {
                $("#myform").data('bootstrapValidator').updateStatus(
                    "email", "NOT_VALIDATED", null);
            }
        });

    $("#submit").click(
        function () {
            setTimeout(function () {
                if ($("#email").val() == "") {
                    $("#myform").data('bootstrapValidator').updateStatus(
                        "email", "NOT_VALIDATED", null);
                }
            }, 500);
        });
    // 邮箱单独验证**************************************************************

    $("#realname").blur(
        function () {
            // 请求注册用户
            $.ajax({
                type: "post",
                url: "user/makeUserName",
                dataType: "json",
                data: {
                    "realname": $("#realname").val()
                },
                success: function (result) {
                    $("#makeusername").val(result.msg)
                    $("#myform").data('bootstrapValidator').updateStatus(
                        "username", "NOT_VALIDATED", null);
                    $("#myform").data('bootstrapValidator').validateField(
                        'username');
                }
            });
        });

    // 通过点击角色下拉列表加载隐藏域roleid的值
    /*
     * $('#roleidForSelect').click( function() { //该方法注册到$(function(){})函数中 var
     * tmpSelected = $('#roleidForSelect').val(); if (tmpSelected != null) {
     * $('#roleid').val(tmpSelected); } else { $('#roleid').val(""); }
     * //由于input为hidden，验证会出现一些bug，此处手动验证隐藏的input组件
     * $('#myModalForm').data('bootstrapValidator') .updateStatus('roleid',
     * 'NOT_VALIDATED') .validateField('roleid'); });
     */

});

// 配置
var setting = {
    view: {
        dblClickExpand: true,
        selectedMulti: true, // 是否允许多选
        txtSelectedEnable: true, // 是否允许选中节点的文字
        autoCancelSelected: true, // 不允许按下Ctrl键取消节点选中状态
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

// 点击节点时
function onClick(e, treeId, treeNode) {
    // 获取树
    var zTree = $.fn.zTree.getZTreeObj("deptTree");
    // 获取所有的节点
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

    // 资源名称
    $("#deptName").val(v);
    // 资源编号
    $("#deptno").val(id);
    // 点击后隐藏
    $("#myform").data("bootstrapValidator").updateStatus("deptName", "VALID",
        null);
    hideMenu();
    return false;
}

// 显示菜单
function showMenu() {

    if ($("#deptTree").css("display") == 'none') {
        $("#deptTree").stop().show();
    } else {
        $("#deptTree").stop().hide();
    }
}

// 隐藏菜单
function hideMenu() {
    $("#deptTree").stop().hide();
}

// 点击body时
function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
        event.target).parents("#menuContent").length > 0)) {
        hideMenu();
    }
}

// 加载时发生
$(document).ready(function () {
    var zNodes;
    // 获取数据
    $.getJSON('dept/Tree', function (data) {
        // 初始化tree
        $.fn.zTree.init($("#deptTree"), setting, data);
    });
});