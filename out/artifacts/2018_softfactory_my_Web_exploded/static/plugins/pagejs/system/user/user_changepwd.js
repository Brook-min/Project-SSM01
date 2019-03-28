$(function () {
    $("#pwdform").bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                message: '密码验证失败',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 15,
                        message: '密码长度必须在6到15位之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '密码只能包含大写、小写、数字和下划线'
                    }
                }
            },
            realname: {
                message: '密码重复还没有验证',
                validators: {
                    notEmpty: {
                        message: '密码重复不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 15,
                        message: '密码长度在6到15之间'
                    },
                    identical: {
                        field: 'username',
                        message: '两次密码不同请重新输入'
                    }
                }
            }
        }
        //做ajax请求用到
    }).on(
        'success.form.bv',
        function (e) {
            e.preventDefault();
            var $form = $(e.target); //拿到form表单
            layer.load(2, {
                time: 1000
            });
            setTimeout(function () {
                //请求注册用户
                $.ajax({
                    type: "post",
                    url: "user/changeIndexPwds",
                    dataType: "json",
                    data: $form.serialize(),
                    success: function (result) {
                        if (result.flag) {
                            layer.msg(result.msg, {
                                time: 1500,
                                icon: 1
                            });
                            setTimeout(function () {
                                window.parent.location.reload();
                            }, 1500);
                        } else {
                            $("#pwdform")
                                .data('bootstrapValidator')
                                .resetForm();
                            $("#passwords").val("");
                            layer.msg(result.msg, {
                                time: 1500,
                                icon: 2
                            });
                        }
                    },
                    error: function (result) {
                        layer.msg(result.msg, {
                            time: 1500,
                            icon: 2
                        });
                    },
                });
            }, 1000);
        });

    $("#reset").click(function () {
        $("#pwdform").data('bootstrapValidator').resetForm();

    });

});