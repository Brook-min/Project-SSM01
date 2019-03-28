$(function () {

    $("#createtime").val(moment().format('YYYY-MM-DD HH:mm:ss'));

    /*点击按钮更换图标*/
    $("#glyphicon").find("button").click(function () {
        $("#icon").val($(this).find("span").attr('class'));
        return false;
    });

    /*表单验证*/
    $("#dept_update").bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            deptname: {
                validators: {
                    notEmpty: {
                        message: '部门名称不能为空'
                    }
                }
            },
            address: {
                validators: {
                    notEmpty: {
                        message: '地址不能为空'
                    }
                }
            }
        }
    }).on('success.form.bv', function (e) {
        e.preventDefault();
        var $form = $(e.target); //拿到form表单
        //请求修改部门
        $.ajax({
            type: "post",
            url: "dept/update",
            dataType: "json",
            data: $form.serialize(),
            success: function (result) {
                if (result.flag) {
                    layer.msg(result.msg, {icon: 1, time: 1000});
                    setTimeout(referParent, 1000);
                } else {
                    layer.msg(result.msg, {icon: 2, time: 1000});
                    $("#dept_update").data('bootstrapValidator').resetForm();
                }
            }
        });
    });

    //清空表单数据和状态
    $("#reset").on("click", function () {
        $("#deptTree").stop().hide();
        $("#dept_update").data('bootstrapValidator').resetForm();

    });
})

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
    var nodes = zTree.getSelectedNodes(),
        v = "";
    id = "";
    nodes.sort(function compare(a, b) {
        return a.id - b.id;
    });
    for (var i = 0, l = nodes.length; i < l; i++) {
        v += nodes[i].deptname + ",";
        id += nodes[i].id + ",";
    }
    if (id.length > 0) id = id.substring(0, id.length - 1);
    if (v.length > 0) v = v.substring(0, v.length - 1);

    //资源名称
    $("#deptName").val(v);
    //资源编号
    $("#pid").val(id);
    //点击后隐藏
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
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length > 0)) {
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
        var zTree = $.fn.zTree.getZTreeObj("deptTree");
        //下面这段可以放在其他地方，比如配合搜索功能使用，搜索到节点ID然后触发点击事件
        var treeNode = zTree.getNodeByParam("id", $("#pid").val());
        $("#deptName").val(treeNode.deptname);
    });
});