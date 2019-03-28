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
    <title>服务器内部发生错误</title>
</head>
<body>
<section class="container-fluid page-404 minWP text-c">
    <p class="error-title"><i class="Hui-iconfont va-m" style="font-size:80px">&#xe688;</i>
        <span class="va-b">500</span>
    </p>
    <p class="error-description">服务器好像出错了...
        <br/>您可以:</p>
    <p class="error-info">
        <a href="javascript:window.parent.location.href='index'" class="c-primary">&lt; 返回主页</a>
</section>
</body>
</html>