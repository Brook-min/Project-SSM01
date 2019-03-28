$(function () {
    $(".date").datetimepicker({
        language: 'zh-CN',//显示中文
        format: 'yyyy-mm-dd',//显示格式
        minView: "month",//设置只显示到月份
        endDate: new Date(),
        clearBtn: true,
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
    });
    //初始化表格
    initTable();
});

//初始化表格
function initTable() {
    $("#resource").bootstrapTable("destroy");
    $("#resource").bootstrapTable({
        method: "get", //使用get请求到服务器获取数据
        url: "resource/select", //获取数据的Servlet地址
        treeView: true,
        treeId: "id",
        treeField: "name",
        pagination: false, //启动分页
        showColumns: true, //显示下拉框勾选要显示的列
        showRefresh: true, //显示刷新按钮
        clickToSelect: true, //是否启用点击选中行
        sidePagination: "server", //表示客户端请求
    });
}

//格式化Url
function fmtUrl(value) {
    return value == null ? "" : value;
}

//格式化 图标
function fmtIcon(value) {
    return "<span class='" + value + "'></span>";
}

//格式类型
function fmtType(value) {
    if (value == 0) {
        return "菜单"
    }
    if (value == 1) {
        return "按钮";
    }
    if (value == 2) {
        return "超链接";
    }
}

//格式化状态
function fmtStatus(value) {
    if (value == "0") {
        return "<span class='label label-success radius'>已启用</span>";
    }
    if (value == "1") {
        return "<span class='label radius'>已停用</span>";
    }
}

/*操作显示*/
function fmtOperate(value, row, index) {
    var str = '';
    if (row.status == "0") {
        if ($.canEdit) {
            str += "<a style='text-decoration:none' onClick=updateStatus(this,'"
                + row.id
                + "','"
                + row.status
                + "') href='javascript:;' class='ml-5' title='停用'><i class='Hui-iconfont'>&#xe631;</i></a>";
            str += ("&nbsp;&nbsp;&nbsp;&nbsp;<a title='编辑' href='javascript:;' onclick=resource_edit('编辑','resource/selectById?id="
                + row.id + "','550','550')  style='text-decoration:none'><i class='Hui-iconfont'>&#xe6df;</i></a>");
        }

        str += '&nbsp;&nbsp;&nbsp;&nbsp;';

        if ($.canDelete) {
            str += ("<a title='删除' href='javascript:;' onclick=resource_del(this,'"
                + row.id + "') class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>");
        }

    } else {
        str += "<a onClick= updateStatus(this,'"
            + row.id
            + "','"
            + row.status
            + "') href='javascript:;' class='ml-5' title='启用' style='text-decoration:none'><i class='Hui-iconfont'>&#xe615;</i></a>";
    }
    return str;
}

/*资源-编辑*/
function resource_edit(title, url, w, h) {
    layer_show(title, url, w, h);
}

/*资源添加*/
function resource_add(title, url, w, h) {
    layer_show(title, url, w, h);
}

/*修改状态*/
function updateStatus(obj, id, status) {
    var str = '';
    var statu = '';
    if (status == "0") {
        statu = "1";
        str = "确定要停用当前资源吗?";
    } else {
        statu = "0";
        str = "确定要启动当前资源吗?"
    }
    layer.confirm(str, function (index) {
        $.ajax({
            type: 'POST',
            url: 'resource/updateStatus',
            dataType: 'json',
            data: {
                "id": id,
                "status": statu
            },
            success: function (data) {
                if (data.flag) {
                    layer.msg(data.msg, {
                        icon: 1,
                        time: 1000
                    });
                    initTable();
                } else {
                    layer.msg(data.msg, {
                        icon: 2,
                        time: 1000
                    });
                }
            },
            error: function (data) {
                layer.msg(data.msg, {
                    icon: 2,
                    time: 1000
                });
            },
        });
    });
}


/*资源删除*/
function resource_del(obj, id) {
    layer.confirm('确认要删除吗？', function (index) {
        $.ajax({
            type: 'GET',
            url: 'resource/delete/' + id,
            dataType: 'json',
            success: function (result) {
                if (result.flag) {
                    layer.msg(result.msg, {
                        icon: 1,
                        time: 1000
                    });
                    setTimeout(initTable, 1000);
                } else {
                    layer.msg(result.msg, {
                        icon: 2,
                        time: 1000
                    });
                }
            }
        });
    });
}