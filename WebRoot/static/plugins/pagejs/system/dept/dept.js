function initTable() {
    //先销毁表格
    $('#deptTable').bootstrapTable('destroy');
    //初始化表格,动态从服务器加载数据
    $("#deptTable").bootstrapTable({
        method: "get", //使用post请求到服务器获取数据
        url: "dept/select", //获取数据的Servlet地址
        dataType: "json",
        treeView: true,
        treeId: "id",
        treeField: "deptname",
        pagination: true, //启动分页
        showColumns: true, //显示下拉框勾选要显示的列
        showRefresh: true, //显示刷新按钮
        sidePagination: "server", //表示服务端请求
        //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
        //设置为limit可以获取limit, offset, search, sort, order
        icons: {
            refresh: 'glyphicon-repeat',
            toggle: 'glyphicon-list-alt',
            columns: 'glyphicon-list'
        },
        /* 	queryParams : function queryParams(params) { //设置查询参数
                var param = {
                    offset : params.offset,
                    limit : params.limit,
                    orderNum : $("#orderNum").val()
                };
                return param;
            }, */
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

    //时间控件
    /*$(".date").datetimepicker({
        language : 'zh-CN',//显示中文
        format : 'yyyy-mm-dd',//显示格式
        minView : "month",//设置只显示到月份
        endDate : new Date(),
        clearBtn : true,
        autoclose : true,//选中自动关闭
        todayBtn : true,//显示今日按钮
    });*/
});


/*上级部门为空null判断*/
function fmtPName(value, row, index) {
    return value == null ? "" : value;
}

/*格式创建时间*/
function fmtCreateTime(value, row, index) {
    return moment(value).format('YYYY-MM-DD HH:mm:ss');
}

/*删除判断*/
function fmtStatus(value, row, index) {
    return value == 0 ? "<span class='label label-success radius'>未删除</span>"
        : "<span class='label label-danger radius'>已删除</span>";
}

/*图标显示*/
function fmtIcon(value, row, index) {
    return "<span class='" + value + "'></span>";
}

/*操作显示*/
function fmtAction(value, row, index) {
    var str = '';
    if ($.canEdit) {
        str += ("<a title='编辑' href='javascript:;' onclick=member_edit('编辑','dept/selectById/"
            + row.id + "','650','560')  style='text-decoration:none'><i class='Hui-iconfont'>&#xe6df;</i></a>");
    }
    str += '&nbsp;&nbsp;&nbsp;&nbsp;';
    if ($.canDelete) {
        str += ("<a title='删除' href='javascript:;' onclick=member_del(this,'"
            + row.id + "') class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>");
    }
    return str;
}


/*部门-添加*/
function member_add(title, url, w, h) {
    layer_show(title, url, w, h);
}

/*部门-编辑*/
function member_edit(title, url, w, h) {
    layer_show(title, url, w, h);
}

/*部门-删除*/
function member_del(obj, id) {
    layer.confirm('确认要删除吗？', function (index) {
        $.ajax({
            type: 'POST',
            url: 'dept/delete/' + id,
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