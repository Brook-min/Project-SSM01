$(function () {
    //加载删除状态
    $("#deletestatus option[value='" + $("#deletestatusValue").val() + "']").attr('selected', true);
    /*表单验证*/
    $("#role_edit").bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            rolename: {
                validators: {
                    notEmpty: {
                        message: '角色名称不能为空'
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
                url: "role/update",
                dataType: 'json',
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
        $("#role_edit").data('bootstrapValidator').resetForm();
    });
})