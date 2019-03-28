//配置
var setting = {
    view: {
        dblClickExpand: true,
        selectedMulti: true, //是否允许多选
        txtSelectedEnable: true, //是否允许选中节点的文字
        autoCancelSelected: true, //不允许按下Ctrl键取消节点选中状态
    },
    //复选框打开显示
    check: {
        enable: true
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
    var zTree = $.fn.zTree.getZTreeObj("role_grant_Tree");
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
    return false;
}

//获得选中值
function fun_getCheckValue() {
    var nodes = treeObj.getChangeCheckedNodes(true);

    var result = '';
    if (nodes.length == 0) {
        layer.msg("请选择资源后，再提交！", {
            time: 1500,
            icon: 2
        });
        return false;
    }
    for (var i = 0; i < nodes.length; i++) {
        var halfCheck = nodes[i].getCheckStatus();
        result += nodes[i].id + ',';
    }
    result = result.substring(0, result.lastIndexOf(","));
    return result;
}

//tree对象
var treeObj;
//加载时发生
$(function () {
    var zNodes;
    //获取数据
    $.getJSON('role/tree', function (data) {
        //初始化tree
        $.fn.zTree.init($("#role_grant_Tree"), setting, data);
        treeObj = $.fn.zTree.getZTreeObj("role_grant_Tree");
        treeObj.checkAllNodes(false);
        treeObj.expandAll(true);
        var ids = $("#resourceids").val();
        if (ids.trim() != "") {
            var strs = ids.split(",");
            for (var j = 0; j < strs.length; j++) {
                var node = treeObj.getNodeByParam("id", strs[j]);
                //根据资源id选中节点
                treeObj.checkNode(node, true);
            }
        }

    });
    //重置所有勾选
    $("#reset").click(function () {
        treeObj.checkAllNodes(false);
    })
    //全部选中节点
    $("#selectNodes").click(function () {
        treeObj.checkAllNodes(true);
    });

});

//开始授权，首先获得选中的资源id，然后发送ajax请求.
function grant() {
    //调用fun_getCheckValue()方法获得选中的所有id，返回是以逗号隔开的字符串id
    var rids = fun_getCheckValue();
    //请求修改角色
    $.ajax({
        type: "post",
        url: "role/grant",
        dataType: 'json',
        data: {
            "roleId": $("#roleId").val(),
            "rids": rids
        },
        success: function (result) {
            if (result.flag) {
                layer.msg(result.msg, {
                    icon: 1,
                    time: 1000
                });
                setTimeout(referParent, 1000);
            } else {
                layer.msg(result.msg, {
                    icon: 2,
                    time: 1000
                });
                $.fn.zTree.getZTreeObj("role_grant_Tree")
                    .checkAllNodes(true);
            }
        }
    });
}