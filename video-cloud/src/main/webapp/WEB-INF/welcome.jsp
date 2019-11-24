<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/11/23
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link 	href="css/bootstrap.css" rel="stylesheet" type="text/css"  />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="js/qrcode.min.js"></script>
</head>
<body>
<h1>Hello Tencent Video Cloud</h1>

<button type="button" class="btn btn-info" id='getSafeUrl' onclick="getPushUrl()">获取推流地址</button>
<h3 class="text" id="showPushUrl"></h3>
<div id="pushQrcode" style="margin:0 auto;border:0px solid #000;width:200px;height:200px"></div>
<h3 class="text" id="showPullUrlRtmp"></h3>
<div id="pullRtmpQrcode" style="margin:0 auto;border:0px solid #000;width:200px;height:200px"></div>
<h3 class="text" id="showPullUrlFlv"></h3>
<div id="pullFlvQrcode" style="margin:0 auto;border:0px solid #000;width:200px;height:200px"></div>
<h3 class="text" id="showPullUrlHls"></h3>
<div id="pullHlsQrcode" style="margin:0 auto;border:0px solid #000;width:200px;height:200px"></div>

<script>
    function getPushUrl(){
        $.get("live/getPushUrl",function(data){
            console.log(data);
            var urls = data;
            $("#showPushUrl").text("推流地址：" + urls.pushUrl);
            $("#showPullUrlRtmp").text("拉流地址RTMP：" + urls.pullUrlRtmp);
            $("#showPullUrlFlv").text("拉流地址FLV：" + urls.pullUrlFlv);
            $("#showPullUrlHls").text("拉流地址HLS：" + urls.pullUrlHls);
            var qrcodePush = new QRCode(document.getElementById("pushQrcode"), {
                text: urls.pushUrl,
                width: 200,
                height: 200,
                colorDark : "#000000",
                colorLight : "#ffffff",
                correctLevel : QRCode.CorrectLevel.M
            });
            var qrcodePull = new QRCode(document.getElementById("pullRtmpQrcode"), {
                text: urls.pullUrlRtmp,
                width: 200,
                height: 200,
                colorDark : "#000000",
                colorLight : "#ffffff",
                correctLevel : QRCode.CorrectLevel.M
            });
            var qrcodePull = new QRCode(document.getElementById("pullFlvQrcode"), {
                text: urls.pullUrlFlv,
                width: 200,
                height: 200,
                colorDark : "#000000",
                colorLight : "#ffffff",
                correctLevel : QRCode.CorrectLevel.M
            });
            var qrcodePull = new QRCode(document.getElementById("pullHlsQrcode"), {
                text: urls.pullUrlHls,
                width: 200,
                height: 200,
                colorDark : "#000000",
                colorLight : "#ffffff",
                correctLevel : QRCode.CorrectLevel.M
            });
        })
    }
</script>
</body>
</html>
