//弹出窗铺满整个父窗口  
function openIframe(title, url) {
    var index = layer.open({
        type: 2,
        title: title,
        content: url,
        end: function () {
            //每次关闭iframe层后解绑resize事件，这样再次打开就绑定另一次新的index。
            $(window).unbind("resize");
        }
    });
    layer.full(index);
    //自动设置全屏尺寸
    $(window).resize(function () {
        layer.full(index);
    });
}