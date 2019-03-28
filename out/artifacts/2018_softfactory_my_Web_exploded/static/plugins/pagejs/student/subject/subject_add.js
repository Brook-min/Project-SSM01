$(function () {
    /*表单验证*/
    $("#subject_add").bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            subName: {
                message: '科目名验证失败',
                validators: {
                    remote: {
                        url: "subject/checkSubName",
                        message: "该科目已经存在!",
                        delay: 1000,
                        type: 'post'
                    },
                    notEmpty: {
                        message: '科目名称不能为空'
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
                url: "subject/save",
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
                        $("#subject_add").data('bootstrapValidator')
                            .resetForm();
                    }
                }
            });
        });
    //清空表单数据和状态
    $("#reset").on("click", function () {
        $("#subject_add").data('bootstrapValidator').resetForm();
    });
})