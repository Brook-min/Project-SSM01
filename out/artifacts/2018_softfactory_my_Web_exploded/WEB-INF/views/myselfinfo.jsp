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
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css"/>
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <jsp:include page="/static/iframe/import/_footer.jsp"></jsp:include>
    <link rel="stylesheet"
          href="static/plugins/css/validate/bootstrapValidator.css">
    <style type="text/css">
        .c1 {
            margin-bottom: 10px;
        }

        .c2 {
            margin-left: 30px;
            color: green;
        }
    </style>
    <title>个人信息</title>
</head>
<body>
<div class="page-container">
    <div class="container-fluid">
        <div class="col-sm-12 col-md-12">
            <form class="form-horizontal" id="myfrm">
                <div class="row">
                    <fieldset>
                        <legend><i class='Hui-iconfont' style="color:green;font-size:50px;">&#xe638;</i></legend>
                        <input type="hidden" id="showname" value="${user.deptno}">
                        <span class="c2">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span><span>${user.realname}</span><br/>
                        <span class="c2">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</span><span>${user.username}</span><br/>
                        <span class="c2">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</span><span>${user.sex}</span><br/>
                        <span class="c2">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</span><span>${user.age}</span><br/>
                        <span class="c2">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</span><span>${user.telephone}</span><br/>
                        <span class="c2">角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</span><span><c:if
                            test="${roles == ''}"><i class='Hui-iconfont'>&#xe647;</i></c:if><c:if
                            test="${roles != ''}">${roles}</c:if></span><br/>
                        <span class="c2">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历：</span><span><c:if
                            test="${user.education == ''}"><i class='Hui-iconfont'>&#xe647;</i></c:if><c:if
                            test="${user.education != ''}">${user.education}</c:if></span><br/>
                        <span class="c2">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</span><span><c:if
                            test="${user.email == ''}"><i class='Hui-iconfont'>&#xe647;</i></c:if><c:if
                            test="${user.email != ''}">${user.email}</c:if></span><br/>
                        <span class="c2">部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门：</span><span id="deptname"></span><br/>
                        <span class="c2">上级名称：</span><span><c:if test="${user.upno == ''}"><i class='Hui-iconfont'>&#xe647;</i></c:if><c:if
                            test="${user.upno != ''}"><c:forEach items="${userlist}" var="g"><c:if
                            test="${user.upno == g.id}">${g.realname}</c:if></c:forEach></c:if></span><br/>
                        <span class="c2">省&nbsp;&nbsp;市&nbsp;&nbsp;县：</span><span><c:if test="${user.province == ''}"><i
                            class='Hui-iconfont'>&#xe647;</i></c:if><c:if
                            test="${user.province != ''}">${user.province}-${user.city}-${user.area}</c:if></span><br/>
                        <span class="c2">详细地址：</span><span><c:if test="${user.address == ''}"><i class='Hui-iconfont'>&#xe647;</i></c:if><c:if
                            test="${user.address != ''}">${user.address}</c:if></span><br/>
                        <span class="c2">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</span><span><c:if
                            test="${user.description == ''}"><i class='Hui-iconfont'>&#xe647;</i></c:if><c:if
                            test="${user.description != ''}">${user.description}</c:if></span><br/>
                    </fieldset>
                </div>
            </form>
        </div>
    </div>
</div>


<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/plugins/js/validate/bootstrapValidator.min.js"></script>
<script src="static/plugins/js/window/layershow.js"></script>
<script type="text/javascript" src="static/iframe/lib/layer/2.4/layer.js"></script>
<script type="text/javascript">
    $(function () {
        loadDeptNames();

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
                if (data.msg == '') {
                    $("#deptname").html("<i class='Hui-iconfont'>&#xe647;</i>");
                } else {
                    $("#deptname").html(data.msg);
                }
            },
            error: function (data) {
            },
        });
    }
</script>
</body>
</html>