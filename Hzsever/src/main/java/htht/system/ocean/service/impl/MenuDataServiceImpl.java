package htht.system.ocean.service.impl;

import htht.system.ocean.dao.MenuDataMapper;
import htht.system.ocean.model.MenuData;
import htht.system.ocean.service.MenuDataService;
import htht.system.ocean.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/07/31.
 */
@Service
@Transactional
public class MenuDataServiceImpl extends AbstractService<MenuData> implements MenuDataService {
    @Resource
    private MenuDataMapper menuDataMapper;

}
