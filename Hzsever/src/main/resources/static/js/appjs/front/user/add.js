$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function getCheckedRoles() {
	var adIds = "";
	$("input:checkbox[name=role]:checked").each(function(i) {
		if (0 == i) {
			adIds = $(this).val();
		} else {
			adIds += ("," + $(this).val());
		}
	});
	return adIds;
}
function save() {
    var deptId = $("#deptId").val();
    console.log(deptId)
    if (deptId==''){
        parent.layer.alert('请选择一个部门');
        return;
    }
	$("#roleIds").val(getCheckedRoles());
	$.ajax({
		cache : true,
		type : "POST",
		url : "/front/user/save",
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
            userAlias : {
				required : true
			},
			userName : {
				required : true,
				minlength : 2,
				// remote : {
				// 	url : "/front/user/exit", // 后台处理程序
				// 	type : "post", // 数据发送方式
				// 	dataType : "json", // 接受数据格式
				// 	data : { // 要传递的数据
				// 		username : function() {
				// 			return $("#userName").val();
				// 		}
				// 	}
				// }
			},
            deptId : {
                required : true,
                deptId : true
            },
			topic : {
				required : "#newsletter:checked",
				minlength : 2
			},
			agree : "required"
		},
		messages : {

            userAlias : {
				required : icon + "请输入姓名"
			},
			userName : {
				required : icon + "请输入您的用户名",
				minlength : icon + "用户名必须两个字符以上",
				remote : icon + "用户名已经存在"
			},
            confirm_dept : {
                required : icon+"请选择一个部门",
            },
		}
	})
}

var openDept = function(){
	layer.open({
		type:2,
		title:"选择部门",
		area : [ '300px', '450px' ],
		content:"/system/sysDept/treeView"
	})
}
function loadDept( deptId,deptName){
	$("#deptId").val(deptId);
	$("#deptName").val(deptName);
}