$(function () {

    /*点击按钮更换图标*/
    $("#glyphicon").find("button").click(function () {
        $("#icon").val($(this).find("i").attr("class"));
        return false;
    });

    /*表单验证*/
    $("form").bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                validators: {
                    notEmpty: {
                        message: '资源名称不能为空'
                    }
                }
            },
            resourcecode: {
                validators: {
                    notEmpty: {
                        message: '资源code不能为空'
                    }
                }
            },
            url: {
                validators: {
                    notEmpty: {
                        message: '资源路径不能为空'
                    }
                }
            },
            url: {
                validators: {
                    notEmpty: {
                        message: '资源路径不能为空'
                    }
                }
            }
        }
        //做ajax请求用到
    }).on('success.form.bv', function (e) {
        e.preventDefault();
        var $form = $(e.target); //拿到form表单
        //请求修改部门
        $.ajax({
            type: "post",
            url: "resource/add",
            dataType: "json",
            data: $form.serialize(),
            success: function (result) {
                if (result.flag) {
                    layer.msg(result.msg, {icon: 1, time: 1000});
                    setTimeout(referParent, 1000);
                } else {
                    layer.msg(result.msg, {icon: 2, time: 1000});
                    $("form").data('bootstrapValidator').resetForm();
                }
            }
        });
    });
    //清空表单数据和状态
    $("#reset").on("click", function () {
        $("#dept_update").data('bootstrapValidator').resetForm();
    });

});

//配置
var setting = {
    view: {
        dblClickExpand: true,
        selectedMulti: true, //是否允许多选
        txtSelectedEnable: true, //是否允许选中节点的文字
        autoCancelSelected: true, //不允许按下Ctrl键取消节点选中状态
    },
    //复选框打开显示
    /* check : {
        enable : true
    },  */
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
    var zTree = $.fn.zTree.getZTreeObj("resourceTree");
    //获取所有的节点
    var nodes = zTree.getSelectedNodes(), v = "";
    id = "";
    nodes.sort(function compare(a, b) {
        return a.id - b.id;
    });
    for (var i = 0, l = nodes.length; i < l; i++) {
        v += nodes[i].name + ",";
        id += nodes[i].id + ",";
    }
    if (id.length > 0)
        id = id.substring(0, id.length - 1);
    if (v.length > 0)
        v = v.substring(0, v.length - 1);

    //资源名称
    $("#resourceName").val(v);
    //上级资源编号
    $("#pid").val(id);
    //点击后隐藏
    showMenu();
    return false;
}

//显示菜单
function showMenu() {
    if ($("#resourceTree").css("display") == 'none') {
        $("#resourceTree").slideDown("fast");
    } else {
        $("#resourceTree").fadeOut("fast");
    }
}

//加载时发生
$(document).ready(function () {
    var zNodes;
    //获取数据
    $.getJSON('resource/tree', function (data) {
        //初始化tree
        $.fn.zTree.init($("#resourceTree"), setting, data);
    });
});