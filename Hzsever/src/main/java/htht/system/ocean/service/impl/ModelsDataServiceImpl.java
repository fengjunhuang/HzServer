package htht.system.ocean.service.impl;

import htht.system.ocean.dao.ModelsDataMapper;
import htht.system.ocean.model.ModelsData;
import htht.system.ocean.service.ModelsDataService;
import htht.system.ocean.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/05/03.
 */
@Service
@Transactional
public class ModelsDataServiceImpl extends AbstractService<ModelsData> implements ModelsDataService {
    @Resource
    private ModelsDataMapper modelsDataMapper;

    @Override
    public int updateSujectId(ModelsData modelsData) {
        return modelsDataMapper.updateSujectId(modelsData);
    }
}
