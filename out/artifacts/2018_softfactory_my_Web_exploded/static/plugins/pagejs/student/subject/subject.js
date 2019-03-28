function initTable() {
    //先销毁表格
    $('#subjectTable').bootstrapTable('destroy');
    //初始化表格,动态从服务器加载数据
    $("#subjectTable").bootstrapTable({
        method: "post", //使用请求到服务器获取数据
        url: "subject/select", //获取数据的Servlet地址
        dataType: "json",
        pagination: true, //启动分页
        pageNumber: 1, //初始化加载第一页，默认第一页
        pageSize: 5, //每页的记录行数（*）
        pageList: [5, 10, 15, 20, 25], //记录数可选列表
        search: false, //是否启用查询
        showColumns: true, //显示下拉框勾选要显示的列
        showRefresh: true, //显示刷新按钮
        clickToSelect: true, //是否启用点击选中行
        sidePagination: "server", //表示服务端请求
        paginationLoop: false,
        //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
        //设置为limit可以获取limit, offset, search, sort, order
        queryParamsType: "limit",
        icons: {
            refresh: 'glyphicon-repeat',
            toggle: 'glyphicon-list-alt',
            columns: 'glyphicon-list'
        },
        queryParams: function queryParams(params) { //设置查询参数

            var param = {
                offset: params.offset,
                limit: params.limit,
                sort: params.sort,
                order: params.order,
                subName: $("#subName").val()
            };
            return param;
        },
        onLoadError: function () { //加载失败时执行
            layer.msg("加载数据失败", {
                time: 1500,
                icon: 2
            });
        }
    });
}

$(document).ready(function () {
    //调用函数，初始化表格
    initTable();

    //当点击查询按钮的时候执行
    $("#search").bind("click", initTable);
});

//value: 所在collumn的当前显示值，
//row:整个行的数据 ，对象化，可通过.获取
//表格-操作 - 格式化
function actionFormatter(value, row, index) {
    var str = '';

    str += "&nbsp;&nbsp;&nbsp;&nbsp;";

    if ($.canEdit) {
        str += ("<a title='编辑' href='javascript:;' onclick=role_edit('编辑','role/selectById/"
            + row.id + "','550','330')  style='text-decoration:none'><i class='Hui-iconfont'>&#xe6df;</i></a>");
    }

    str += "&nbsp;&nbsp;&nbsp;&nbsp;";

    if ($.canDelete) {
        str += ("<a title='删除' href='javascript:;' onclick=role_del(this,'"
            + row.id + "') class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>");
    }

    return str;
}

function datadel() {
    var row = $.map($("#subjectTable").bootstrapTable('getSelections'),
        function (row) {
            return row;
        });

    //row 是数组
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
        layer.confirm('角色删除须谨慎，确认要批量删除吗？', function (index) {
            $.ajax({
                type: 'get',
                url: 'role/batchdelete/' + ids,
                dataType: 'json',
                success: function (result) {
                    if (result.flag) {
                        layer.msg(result.msg, {
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

/*添加*/
function subject_add(title, url, w, h) {
    layer_show(title, url, w, h);
}

/*角色-编辑*/
function role_edit(title, url, w, h) {
    layer_show(title, url, w, h);
}

/*管理员-角色-删除*/
function role_del(obj, id) {
    layer.confirm('角色删除须谨慎，确认要删除吗？', function (index) {
        $.ajax({
            type: 'get',
            url: 'role/delete/' + id,
            dataType: 'json',
            success: function (result) {
                if (result.flag) {
                    $(obj).parents("tr").remove();
                    layer.msg(result.msg, {
                        icon: 1,
                        time: 1000
                    });
                } else {
                    layer.msg(result.msg, {
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