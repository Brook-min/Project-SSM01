<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE>
<html>
<head>
    <base href="<%=basePath%>">
    <jsp:include page="/static/iframe/import/_meta.jsp"></jsp:include>
    <jsp:include page="/static/iframe/import/_header.jsp"></jsp:include>
    <title>SSM框架整合及权限</title>
</head>
<style>
    dt {
        font-size: 14px;
    }

    dd {
        font-size: 12px;
    }
</style>
<body>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl">
            <a class="logo navbar-logo f-l mr-10 hidden-xs" href="javascript:;">牛耳信息管理系统</a>
            <a class="logo navbar-logo-m f-l mr-10 visible-xs"
               href="javascript:;">Newer.mis</a> <span
                class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span> <a
                aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs"
                href="javascript:;">&#xe667;</a>
            <nav class="nav navbar-nav hide">
                <ul class="cl">
                    <li class="dropDown dropDown_hover"><a href="javascript:;"
                                                           class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i
                            class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;"
                                   onclick="article_add('添加咨询','article-add.html')"><i
                                    class="Hui-iconfont">&#xe616;</i> 咨询</a></li>
                            <li><a href="javascript:;"
                                   onclick="picture_add('添加咨询','picture-add.html')"><i
                                    class="Hui-iconfont">&#xe613;</i> 图片</a></li>
                            <li><a href="javascript:;"
                                   onclick="product_add('添加咨询','product-add.html')"><i
                                    class="Hui-iconfont">&#xe620;</i> 产品</a></li>
                            <li><a href="javascript:;"
                                   onclick="member_add('添加用户','member-add.html','','510')"><i
                                    class="Hui-iconfont">&#xe60d;</i> 用户</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <nav id="Hui-userbar"
                 class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li>欢迎您,</li>
                    <li class="dropDown dropDown_hover"><a href="javascript:;"
                                                           class="dropDown_A">${userSession.realname} <i
                            class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;"
                                   onClick="myselfinfo('个人信息','user/selectUserByMyselfInfo','570','550')">个人信息</a></li>
                            <li><a href="javascript:change_password()">修改密码</a></li>
                            <li><a href="javascript:logOut()">退出</a></li>
                        </ul>
                    </li>
                    <c:if
                            test="${fn:contains(userSession.resourceList, 'index:voice')}">
                        <li id="Hui-msg"><a href="javascript:;" onclick="voice()"
                                            title="消息"><i class="Hui-iconfont Hui-iconfont-yuyin"
                                                          style="font-size: 18px"></i></a></li>
                    </c:if>
                    <li id="Hui-skin" class="dropDown right dropDown_hover"><a
                            href="javascript:;" class="dropDown_A" title="换肤"><i
                            class="Hui-iconfont" style="font-size: 18px">&#xe62a;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" data-val="default"
                                   title="默认(蓝色)">蓝色(默认)</a></li>
                            <li><a href="javascript:;" data-val="black" title="黑色">黑色</a></li>
                            <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                            <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<aside class="Hui-aside">
    <div class="menu_dropdown bk_2">
        <!-- 遍历左侧菜单栏 -->
        <c:forEach items="${userSession.resources}" var="resource">
            <dl id="menu-article">
                <dt>
                    <i class="${resource.icon}">&nbsp;</i>${resource.name}<i
                        class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
                </dt>
                <dd>
                    <ul>
                        <!-- 子级菜单显示 -->
                        <c:forEach items="${resource.resources}" var="cresource">
                            <c:if test="${cresource.url!='consultation_keepon/add'}">
                                <li><a data-href="${cresource.url}"
                                       data-title="${cresource.name}" href="javascript:void(0)"><i
                                        class="${cresource.icon }">&nbsp;</i>${cresource.name}</a></li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </dd>
            </dl>
        </c:forEach>
    </div>
</aside>
<div class="dislpayArrow hidden-xs">
    <a class="pngfix" href="javascript:void(0);"
       onClick="displaynavbar(this)"></a>
</div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active"><span title="首页" data-href="welcome.jsp">首页</span>
                    <em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group">
            <a id="js-tabNav-prev" class="btn radius btn-default size-S"
               href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
                id="js-tabNav-next" class="btn radius btn-default size-S"
                href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
        </div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display: none" class="loading"></div>
            <iframe scrolling="yes" frameborder="0" src="welcome.jsp"></iframe>
        </div>
    </div>
</section>

<div class="contextMenu" id="Huiadminmenu">
    <ul>
        <li id="closethis">关闭当前</li>
        <li id="closeall">关闭全部</li>
    </ul>
</div>
<!--[if lt IE 10]>
<script type="text/javascript" src="static/plugins/js/input-placeholder/ieplaceholder.js"></script>
<![endif]-->
<!--_footer 作为公共模版分离出去-->
<jsp:include page="/static/iframe/import/_footer.jsp"></jsp:include>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript"
        src="static/iframe/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
    $(function () {
        /*$("#min_title_list li").contextMenu('Huiadminmenu', {
            bindings: {
                'closethis': function(t) {
                    console.log(t);
                    if(t.find("i")){
                        t.find("i").trigger("click");
                    }
                },
                'closeall': function(t) {
                    alert('Trigger was '+t.id+'\nAction was Email');
                },
            }
        });*/

    });

    function voice() {
        window.top.emolument_reload.call();
    }

    /*退出登录*/
    function logOut() {
        layer
            .confirm(
                '确认要退出登录吗？',
                function (index) {
                    $
                        .ajax({
                            type: 'POST',
                            url: 'user/logOut',
                            dataType: 'json',
                            success: function (data) {
                                layer.msg(data.msg, {
                                    icon: 1,
                                    time: 1000
                                });
                                window.location.href = "${pageContext.request.contextPath}/login.jsp";
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

    function change_password() {
        layer_show('修改密码', 'user/toIndexchangepwd', '420', '310');
    }

    /*个人信息*/
    function myselfinfo(title, url, w, h) {
        layer_show(title, url, w, h);
    }

    /*咨询-添加*/
    function article_add(title, url) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*图片-添加*/
    function picture_add(title, url) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*产品-添加*/
    function product_add(title, url) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*用户-添加*/
    function member_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }
</script>
</body>
</html>