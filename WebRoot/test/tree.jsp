<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <link rel="stylesheet" href="static/iframe/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css"/>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css"/>
    <script type="text/javascript" src="static/iframe/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="static/iframe/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
    <script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
    <title>用户管理</title>
</head>
<body>
<div class="content_wrap table-bordered form-inline">
    <div class="zTreeDemoBackground left">
        上级资源:<input id="resourceName" type="text" readonly value=""
                    style="width: 120px;" class="form-control" onclick="showMenu(); return false;"/>
        <!-- 资源编号 -->
        <input id="id" name="id" type="hidden">
        <a id="menuBtn" href="#">选择</a>
    </div>
</div>
<div id="menuContent" class="menuContent table-bordered" style="display: none; position: absolute;">
    <ul id="resourceTree" class="ztree" style="margin-top:0; width: 150px;">
    </ul>
</div>
</body>
<script type="text/javascript">

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
        $("#resourceName").val(v);
        //资源编号
        $("#id").val(id);
        //点击后隐藏
        hideMenu();
        return false;
    }

    //显示菜单
    function showMenu() {
        //获取资源input
        var resourceName = $("#resourceName");
        //偏移
        var resourceOffset = $("#resourceName").offset();
        $("#menuContent").css({
            left: resourceOffset.left + "px",
            top: resourceOffset.top + resourceName.outerHeight() + "px"
        }).slideDown("fast");
        $("body").bind("mousedown", onBodyDown);
    }

    //隐藏菜单
    function hideMenu() {
        $("#menuContent").fadeOut("fast");
        $("body").unbind("mousedown", onBodyDown);
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
        $.getJSON('dept/findDeptName', function (data) {
            //初始化tree
            $.fn.zTree.init($("#resourceTree"), setting, data);
        });
    });
</script>
</html>