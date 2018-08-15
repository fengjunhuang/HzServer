package htht.system.ocean.util;

import java.util.ArrayList;
import java.util.List;

import htht.system.ocean.system.front.model.PermissionVO;

public class PermissionUtils {
    private static List<PermissionVO> PERMISSIONS ;

    public static List<PermissionVO> getAllPermissions(){
        if (PERMISSIONS==null){
            PERMISSIONS=new ArrayList<>();
            PERMISSIONS.add(new PermissionVO("行政区划",MyConstants.Resource.行政区划));
            PERMISSIONS.add(new PermissionVO("上传",MyConstants.Resource.上传));
            PERMISSIONS.add(new PermissionVO("海域管理界限",MyConstants.Resource.海域管理界限));
            PERMISSIONS.add(new PermissionVO("剖面图",MyConstants.Resource.剖面图));

        }
        return PERMISSIONS;
    }
}
