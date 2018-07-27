package htht.system.ocean.util;

import java.util.ArrayList;
import java.util.List;

import htht.system.ocean.system.front.model.PermissionVO;

public class PermissionUtils {
    private static List<PermissionVO> PERMISSIONS ;

    public static List<PermissionVO> getAllPermissions(){
        if (PERMISSIONS==null){
            PERMISSIONS=new ArrayList<>();
            PERMISSIONS.add(new PermissionVO("添加",MyConstants.Resource.ADD));
            PERMISSIONS.add(new PermissionVO("删除",MyConstants.Resource.DELETE));
            PERMISSIONS.add(new PermissionVO("修改",MyConstants.Resource.EDIT));
            PERMISSIONS.add(new PermissionVO("查看",MyConstants.Resource.LOOK));
        }
        return PERMISSIONS;
    }
}
