$(function () {
    /*表单验证*/
    $("#role_add").bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            rolename: {
                message: '角色名验证失败',
                validators: {
                    remote: {
                        url: "role/checkRoleName",
                        message: "该角色已经存在!",
                        delay: 1000,
                        type: 'post'
                    },
                    notEmpty: {
                        message: '角色名不能为空'
                    }
                }
            },
            rolecode: {
                validators: {
                    notEmpty: {
                        message: '角色code不能为空'
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
            //请求修改角色
            $.ajax({
                type: "post",
                url: "role/add",
                dataType: "json",
                data: $form.serialize(),
                success: function (result) {
                    if (result.flag) {
                        layer.msg(result.msg, {
                            icon: 1,
                            time: 1000
                        });
                        setTimeout(referParent, 1000);
                    } else {
                        layer.msg(result.msg, {
                            icon: 2,
                            time: 1000
                        });
                        $("#role_edit").data('bootstrapValidator')
                            .resetForm();
                    }
                }
            });
        });
    //清空表单数据和状态
    $("#reset").on("click", function () {
        $("#role_add").data('bootstrapValidator').resetForm();
    });
})