$(function () {
    $("#loginfrm").bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                validators: {
                    notEmpty: {
                        message: '登陆账号不能为空'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '登陆密码不能为空'
                    }
                }
            }/* ,
				kaptcha: {
					validators: {
						notEmpty: {
							message: '请输入验证码'
						},
						 remote: {
	                            type: 'post',
	                            url: 'checkCode?' + Math.floor(Math.random() * 100),
	                            message: '验证码不匹配',
	                            delay: 1000
	                      }
					}
				} */
        }
        //做ajax请求用到
    }).on('success.form.bv', function (e) {
        e.preventDefault();
        var $form = $(e.target); //拿到form表单
        layer.load(2, {time: 1000});
        setTimeout(function () {
            //请求注册用户
            $.ajax({
                type: "post",
                url: "user/login",
                dataType: "json",
                data: $form.serialize(),
                success: function (result) {
                    if (result.flag) {
                        layer.msg(result.msg, {time: 1500});
                        setTimeout(function () {
                            window.location.href = "index";
                        }, 1500);
                    } else {
                        /* 				 $("#kaptchaImage").attr('src',
                                                    'authCode?' + Math.floor(Math.random() * 100)); */
                        $("#loginfrm").data('bootstrapValidator').resetForm();
                        layer.msg(result.msg, {time: 1500});
                    }
                }
            });
        }, 1000);
    });

    $("form").bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    }
                }
            }
        }
    });
});
 
 
 