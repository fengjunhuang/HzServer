package htht.system.ocean.service;
import htht.system.ocean.model.FrontDeptMenau;
import htht.system.ocean.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/07/31.
 */
public interface FrontDeptMenauService extends Service<FrontDeptMenau> {
    List<FrontDeptMenau> querydeptId(long deptId);
}
