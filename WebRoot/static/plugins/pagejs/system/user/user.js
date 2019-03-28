//初始化表格
function initTable() {
    // 先销毁表格
    $("#userTable").bootstrapTable('destroy');
    // 初始化表格,动态从服务器加载数据
    $("#userTable").bootstrapTable({
        method: "post", // 使用get请求到服务器获取数据
        url: "user/select", // 获取数据的Servlet地址
        dataType: "json",
        pagination: true, // 启动分页
        pageSize: 10, // 每页显示的记录数
        pageNumber: 1, // 当前第几页
        pageList: [5, 10, 15, 20, 25], // 记录数可选列表
        search: false, // 是否启用查询
        showColumns: true, // 显示下拉框勾选要显示的列
        showRefresh: true, // 显示刷新按钮
        clickToSelect: true, // 是否启用点击选中行
        sidePagination: "server", // 表示服务端请求
        paginationLoop: false,
        // 设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
        // 设置为limit可以获取limit, offset, search, sort, order
        queryParamsType: "limit",
        icons: {
            refresh: 'glyphicon-repeat',
            toggle: 'glyphicon-list-alt',
            columns: 'glyphicon-list'
        },
        queryParams: function queryParams(params) { // 设置查询参数
            var param = {
                offset: params.offset,
                limit: params.limit,
                sort: params.sort,
                order: params.order,
                userSearch: $.trim($("#information").val())
            };
            return param;
        },
        onLoadError: function () { // 加载失败时执行
            layer.msg("加载数据失败", {
                time: 1500,
                icon: 2
            });
        }
    });
}

// 批量删除用户
function dataUserDel() {
    var row = $.map($("#userTable").bootstrapTable('getSelections'), function (
        row) {
        return row;
    });

    // row 是数组
    for (var i = 0; i < row.length; i++) {
        console.log(row[i].字段名);
    }

    var ids = "";
    for (var i = 0; i < row.length; i++) {
        if (i == 0 || i == "0") {
            ids += row[i].id;
        } else {
            ids += "," + row[i].id;
        }
    }
    if (ids == "") {
        layer.msg('请选择后再删除!', {
            icon: 2,
            time: 1000
        });
    } else {
        layer.confirm('用户删除须谨慎，确认要批量删除吗？', function (index) {
            $.ajax({
                type: 'delete',
                url: 'user/batchdelete/' + ids,
                dataType: 'json',
                success: function (data) {
                    if (data.flag) {
                        layer.msg('已删除!', {
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
                    console.log(data.msg);
                },
            });
        });
    }
}

// value: 所在collumn的当前显示值，
// row:整个行的数据 ，对象化，可通过.获取
// 表格-操作 - 格式化
// 显示是否启用的状态
function lockedcheck(value, row, index) {
    if (row.locked == "0") {
        return "<span class='label label-success radius'>已启用</span>";
    } else if (row.locked == "1") {
        return "<span class='label radius'>已停用</span>";
    }
}

/* 省市县拼接 */
function fmtCity(value, row, index) {
    return row.province + "" + row.city + "" + row.area;
}

// value: 所在collumn的当前显示值，
// row:整个行的数据 ，对象化，可通过.获取
// 表格-操作 - 格式化
function operation(value, row, index) {
    var str = "&nbsp;";
    if (row.locked == 0) {
        if ($.canStop) {
            str += "<a style='text-decoration:none' onClick=member_stop(this,'"
                + row.id
                + "','"
                + row.locked
                + "') href='javascript:;' class='ml-5' title='停用'><i class='Hui-iconfont'>&#xe631;</i></a>";
        }
        str += "&nbsp;&nbsp;"
        if ($.canEdit) {
            str += "<a style='text-decoration:none' onClick=member_edit('编辑','user/selectUserById/"
                + row.id
                + "','450','480')  title='编辑'  href='javascript:;'  class='ml-5'><i class='Hui-iconfont'>&#xe6df;</i></a>";
        }
        str += "&nbsp;&nbsp;"
        if ($.canPWD) {
            str += "<a style='text-decoration:none' class='ml-5' onClick=change_password('修改密码','user/changepwd/"
                + row.id
                + "','420','250') href='javascript:;' title='修改密码'><i class='Hui-iconfont'>&#xe63f;</i></a>";
        }
        str += "&nbsp;&nbsp;"
        if ($.canDelete) {
            str += "<a title='删除' href='javascript:;' onclick=member_del(this,'"
                + row.id
                + "') class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
        }
    } else {
        if ($.canStart) {
            str += "<a onClick= member_start(this,'"
                + row.id
                + "','"
                + row.locked
                + "') href='javascript:;' class='ml-5' title='启用' style='text-decoration:none'><i class='Hui-iconfont'>&#xe615;</i></a>";
        }
    }
    return str;
}


$(function () {
    // 调用函数，初始化表格
    initTable();
    // 当点击查询按钮的时候执行
    $("#userSearch").bind("click", initTable);
});

/* 用户-编辑 */
function member_edit(title, url, w, h) {
    layer_show(title, url, w, h);
}

/* 用户-添加 */
function member_add(title, url, w, h) {
    layer_show(title, url, w, h);
}

/* 用户-查看 */
function member_show(title, url, w, h) {
    layer_show(title, url, w, h);
}

/* 用户-停用 */
function member_stop(obj, id, locked) {
    layer.confirm('确认要停用吗？', function (index) {
        $.ajax({
            type: 'POST',
            url: 'user/blockup',
            dataType: 'json',
            data: {
                "id": id,
                "locked": locked
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

/* 用户-启用 */
function member_start(obj, id, locked) {
    layer.confirm('确认要启用吗？', function (index) {
        $.ajax({
            type: 'POST',
            url: 'user/startusing',
            dataType: 'json',
            data: {
                "id": id,
                "locked": locked
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

/* 格式创建时间 */
function fmtCreateTime(value, row, index) {
    return moment(value).format('YYYY-MM-DD HH:mm:ss');
}

/* 密码-修改 */
function change_password(title, url, w, h) {
    layer_show(title, url, w, h);
}

/* 用户-删除 */
function member_del(obj, id) {
    layer.confirm('确认要删除吗？', function (index) {
        $.ajax({
            type: 'POST',
            url: 'user/delete',
            dataType: 'json',
            data: {
                "id": id,
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