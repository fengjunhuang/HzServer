package htht.system.ocean.service.impl;

import htht.system.ocean.dao.FrontDeptMenauMapper;
import htht.system.ocean.model.FrontDeptMenau;
import htht.system.ocean.service.FrontDeptMenauService;
import htht.system.ocean.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/07/31.
 */
@Service
@Transactional
public class FrontDeptMenauServiceImpl extends AbstractService<FrontDeptMenau> implements FrontDeptMenauService {
    @Resource
    private FrontDeptMenauMapper frontDeptMenauMapper;


  public List<FrontDeptMenau> querydeptId(long deptId){

      return frontDeptMenauMapper.querydeptId(deptId);
   }

}
