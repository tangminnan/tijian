$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/user/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            name : {
                required : true
            },
            phone :{
                required : true,
                isMobile :true
            },
            identityCard :{
                required : true,
                isidentityCard :true
            }
        },
        messages : {
            name : {
                required : icon + "请输入姓名"
            },
            phone : {
                required : icon + "请输入手机号"
            },
            identityCard : {
                required : icon + "请输入身份证号"
            }
        }
    })
}

//手机号码验证
jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(10[0-9]{1})|(11[0-9]{1})|(12[0-9]{1})|(14[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
    return length == 11;
}, "请正确填写您的手机号码");
//身份证号验证
jQuery.validator.addMethod("isidentityCard", function(value, element) {
    var length = value.length;
    var regIdNo = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    return this.optional(element) || regIdNo.test(value);
}, "请正确的身份证号");