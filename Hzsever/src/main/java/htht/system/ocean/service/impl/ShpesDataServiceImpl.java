package htht.system.ocean.service.impl;

import htht.system.ocean.dao.ShpesDataMapper;
import htht.system.ocean.model.ShpesData;
import htht.system.ocean.service.ShpesDataService;
import htht.system.ocean.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/12.
 */
@Service
@Transactional
public class ShpesDataServiceImpl extends AbstractService<ShpesData> implements ShpesDataService {
    @Resource
    private ShpesDataMapper shpesDataMapper;

    @Override
    public int insert(ShpesData shpesData) {


        return  shpesDataMapper.insertshp(shpesData);
    }

    @Override
    public int updateSujectId(ShpesData shpesData) {
        return shpesDataMapper.updateSujectId(shpesData);
    }
}
