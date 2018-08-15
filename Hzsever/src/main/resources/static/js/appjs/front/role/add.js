//var menuTree;

var menuIds;
$(function () {
    getMenuTreeData();
    validateRule();
});
$.validator.setDefaults({
                            submitHandler: function () {
                                getAllSelectNodes();
                                save();
                            }
                        });

function getAllSelectNodes() {
    var parent = $('#permission-list input');
    var resultStr="";
    for (var i = parent.length-1; i >0 ; i--) {
        var permissionInput = parent[i];
        var isCheck = permissionInput.checked;
        if (isCheck){
            var value = permissionInput.value;
            resultStr+=value+",";
        }
    }
    $('#permissions').val(resultStr)
}

function getMenuTreeData() {
    console.log("伙执行力")
    $.ajax({
               type: "GET",
               url: "/front/role/getPermissions",
               success: function (permissions) {
                   console.log(permissions);
                   // loadPermissions(permissions);
               }
           });
}

function loadPermissions(permissions) {
    var parent = $('#permission-list');
    if (permissions != null && permissions.length > 0) {
        for (var i = 0; i < permissions.length; i++) {
            var permission = permissions[i];
            var domStr = '<label class="checkbox-inline">';
            domStr += '<input name="permission" type="checkbox" value="' + permission.type + '" >';
            domStr += permission.name;
            domStr += '</label>';
            parent.append(domStr);
            console.log("添加元素")
        }
    }

    // $('#menuTree').jstree("open_all");

}

function parseDom(arg) {

    var objE = document.createElement("div");

    objE.innerHTML = arg;

    return objE.childNodes;

};

function save() {
    $('#menuIds').val(menuIds);
    var role = $('#signupForm').serialize();

    var permissions =[];
    $("#roleWrap input:checkbox").each(function () {
        if ($(this).is(':checked')) {
            var aa  = $(this).attr('id');
            permissions.push(aa)
        }
    });
    // console.log(permissions.join())
    var newPermissions = permissions.join();
    var role = $('#signupForm').serializeArray();
    console.log(role[4]);
    role[4].value =  newPermissions;
    $.ajax({
               cache: true,
               type: "POST",
               url: "/front/role/save",
               data: role, // 你的formid

               async: false,
               error: function (request) {
                   alert("Connection error");
               },
               success: function (data) {
                   if (data.code == 0) {
                       parent.layer.msg("操作成功");
                       parent.reLoad();
                       var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引

                       parent.layer.close(index);

                   } else {
                       parent.layer.msg(data.msg);
                   }
               }
           });
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
                                  rules: {
                                      roleName: {
                                          required: true
                                      }
                                  },
                                  messages: {
                                      roleName: {
                                          required: icon + "请输入角色名"
                                      }
                                  }
                              });
}