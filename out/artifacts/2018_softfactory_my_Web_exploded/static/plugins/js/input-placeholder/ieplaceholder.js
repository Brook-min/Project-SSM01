$(function () {
    $("input[placeholder],textarea[placeholder]").each(function (index, item) {
        $(this).val($(item).attr("placeholder"));
    });
    $("input[placeholder],textarea[placeholder]").focus(function () {
        $(this).val("");
    });
    $("input[placeholder],textarea[placeholder]").blur(function () {
        if ($(this).val() == "") {
            $(this).val($(this).attr("placeholder"));
        }
    });

});