//登录成功后跳转的界面
function toIndex() {
    window.location.href = "page/toindex";
}

jQuery(document).ready(function () {

    /*
    *加载背景图片      
    */
    $.backstretch([
        "static/plugins/login/img/backgrounds/2.jpg"
        , "static/plugins/login/img/backgrounds/3.jpg"
        , "static/plugins/login/img/backgrounds/1.jpg"
    ], {duration: 3000, fade: 750});

    /*
     * 刷新验证码
     * 
     */
    $('#kaptchaImage,#refresh').click(
        function () {
            $("#kaptchaImage").attr('src',
                'authCode?' + Math.floor(Math.random() * 100)).fadeIn();
        });

    /*
     *表单验证(请使用bootstrap validate后自行删除以下内容)
    */
    /*    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
            $(this).removeClass('input-error');
        });*/


    /*  $('.login-form').on('submit', function(e) {

          $(this).find('input[type="text"], input[type="password"]').each(function(){
              if( $(this).val() == "" || $(this).val() == undefined || $(this).val() ==null) {
                  e.preventDefault();
                  $(this).removeClass('input-success');
                  $(this).addClass('input-error');
              }
              else {
                  $(this).removeClass('input-error');
                  $(this).addClass('input-success');
                 }
          });

      });*/


});
