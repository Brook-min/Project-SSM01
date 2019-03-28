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
    <title>首页</title>
    <style>
        fieldset {
            padding: .35em .625em .75em;
            margin: 0 2px;
            border: 1px solid silver;
        }

        legend {
            padding: .5em;
            border: 0;
            width: auto;
            margin-bottom: 0px;
            font-size: 16px;
        }

        .col-center-block {
            float: none;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }

        .fixed-table-body {
            height: auto;
        }
    </style>
</head>
<body>
<audio id="voiceAd">
    <source id="voiceSr" src="" type="audio/mpeg">
    <embed id="voiceEd" height="0" width="0" src="">
</audio>
</body>
<script type="text/javascript">
    /*调用百度语音播报接口*/
    function speak(text) {
        var zhText = encodeURI(encodeURI(text));
        var voicebbUrl = "http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&spd=3&text=" + zhText;
        var voiceAdDoc = document.getElementById("voiceAd");
        var voiceSrDoc = document.getElementById("voiceSr");
        var voiceEdDoc = document.getElementById("voiceEd");
        voiceSrDoc.src = voicebbUrl;
        voiceEdDoc.src = voicebbUrl;
        voiceAdDoc.play();
    }

    function voice() {
        speak("您有2条回访记录处理");
    }

    voice();
</script>
<script src="static/iframe/lib/jquery/1.9.1/jquery.min.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
        src="static/iframe/lib/layer/2.4/layer.js"></script>
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
        src="static/plugins/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="static/plugins/js/bootstrap-table/bootstrap-table.min.js"></script>
<script
        src="static/plugins/js/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="static/iframe/lib/moment.js"></script>
<script src="static/plugins/js/window/openiframe.js"></script>
</html>