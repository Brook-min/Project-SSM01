$(function () {
    $("#myform")
        .bootstrapValidator(
            {
                excluded: [':disabled'],
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    command: {
                        message: '指令名称验证失败',
                        validators: {
                            notEmpty: {
                                message: '指令名称不能为空'
                            }
                        }
                    },
                    description: {
                        message: '指令描述验证失败',
                        validators: {
                            notEmpty: {
                                message: '指令描述不能为空'
                            }
                        }
                    },
                    content: {
                        message: '内容验证失败',
                        validators: {
                            notEmpty: {
                                message: '内容不能为空'
                            }
                        }
                    }
                }
                // 做ajax请求用到
            }).on('success.form.bv', function (e) {
        e.preventDefault();
        var $form = $(e.target); // 拿到form表单
        layer.load(2, {
            time: 1000
        });
        setTimeout(function () {
            // 请求注册用户
            $.ajax({
                type: "post",
                url: "mes/addMes",
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
                        layer.msg(result.msg, {
                            time: 1500,
                            icon: 2
                        });
                    }
                }
            });
        }, 1000);
    });

    // 清空表格样式
    $("#reset").click(function () {
        $("#myform").data('bootstrapValidator').resetForm();

    });

});

