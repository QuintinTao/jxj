let sysNoticeTextEdit;
layui.use(['colorpicker','form'], function () {
    let form = layui.form;//select、单选、复选等依赖form
    let colorpicker = layui.colorpicker;

    //开启全功能
    colorpicker.render({
        elem: '#test-form-sysColor'
        ,color: $('#sysColor').val()
        ,format: 'rgb'
        ,predefine: true
        ,alpha: true
        ,done: function(color){
            $('#sysColor').val(color);
        }
        ,change: function(color){
            //给当前页面头部和左侧设置主题色
            $('.header-demo,.layui-side .layui-nav').css('background-color', color);
        }
    });

    form.render();
});

/**
 * 提交保存
 */
function sysFormSave() {

     let userForm = $("#importForm").serializeObject();
        $.post(ctx + "/es/impData", userForm, function (data) {
        if(!data.data == 1){
            layer.msg(data.msg, {icon: 2,time: 2000}, function () {});
            return;
        }
        layer.msg("保存成功", {icon: 1, time: 2000}, function () {});
        location.href = "/es/list"
//        tableIns.reload();
    });
}