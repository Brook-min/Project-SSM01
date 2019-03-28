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
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet"
          href="static/plugins/css/bootstap-select/bootstrap-select.min.css"/>
    <script type="text/javascript"
            src="static/iframe/lib/jquery/1.9.1/jquery.min.js"></script>
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
    <script src="static/plugins/js/bootstrap-select/bootstrap-select.min.js"></script>
    <script src="static/plugins/js/bootstrap-select/defaults-zh_CN.min.js"></script>
    <title>boot管理</title>
</head>
<body>
<div class="form-group">
    <label class="col-sm-3 control-label">客资类型：</label>
    <div class="col-sm-4">
        <select id="usertype" name="usertype"
                class="selectpicker show-tick form-control" multiple
                data-live-search="false">
            <option value="0">苹果</option>
            <option value="1">菠萝</option>
            <option value="2">香蕉</option>
            <option value="3">火龙果</option>
            <option value="4">梨子</option>
            <option value="5">草莓</option>
            <option value="6">哈密瓜</option>
            <option value="7">椰子</option>
            <option value="8">猕猴桃</option>
            <option value="9">桃子</option>
        </select>
    </div>
</div>

<input type="button" value="提交" id="submit">
</body>
<script type="text/javascript">
    $(window).on('load', function () {
        $('#usertype').selectpicker({
            'selectedText': 'cat'
        });
    });

    $(function () {
        $('.selectpicker').selectpicker('val', 'Mustard');
        $("#submit").click(function () {
            alert($("#usertype").val());
        })
    })
</script>
</html>