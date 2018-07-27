package htht.system.ocean.service.impl;

import htht.system.ocean.dao.ShpesChildDataMapper;
import htht.system.ocean.model.ShpesChildData;
import htht.system.ocean.service.ShpesChildDataService;
import htht.system.ocean.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/23.
 */
@Service
@Transactional
public class ShpesChildDataServiceImpl extends AbstractService<ShpesChildData> implements ShpesChildDataService {
    @Resource
    private ShpesChildDataMapper shpesChildDataMapper;

}
