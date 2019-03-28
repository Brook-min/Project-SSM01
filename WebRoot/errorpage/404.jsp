<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <link rel="Bookmark" href="errorpage/error.ico"/>
    <link rel="Shortcut Icon" href="errorpage/error.ico"/>
    <title>找不到页面</title>
</head>
<body>
<section class="container-fluid page-404 minWP text-c">
    <p class="error-title"><i class="Hui-iconfont va-m" style="font-size:80px">&#xe688;</i>
        <span class="va-b">404</span>
    </p>
    <p class="error-description">不好意思，您访问的去火星了</p>
    <p class="error-info">您可以：
        <a href="javascript:;" onclick="history.go(-1)" class="c-primary">&lt; 返回上一页</a>
        <span class="ml-20">|</span>
        <a href="javascript:window.parent.location.href='index'" target="_parent" class="c-primary ml-20">去首页 &gt;</a>
    </p>
</section>
</body>
</html>