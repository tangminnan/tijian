$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/checkItem/save",
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
            parentItem : {
				required : true
			},
			price:{
            	required: true,
                isNumber :true
			},
			pin:{
                required: true
			}
		},
		messages : {
            parentItem : {
				required : icon + "项目名称不可以为空"
			},
			price :{
                required : icon + "价格不可以为空"
			},
			pin:{
                required : icon + "拼音代码不可以为空"
			}
		}
	})
}


jQuery.validator.addMethod("isNumber", function(value, element) {
    return !isNaN(value)&& value>0&&value.substr(0,1)!="."&&value.substr(-1.0)!=".";
}, "输入的价格必须合法");