package htht.system.ocean.service.impl;

import htht.system.ocean.dao.FileDataMapper;
import htht.system.ocean.model.FileData;
import htht.system.ocean.service.FileDataService;
import htht.system.ocean.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/27.
 */
@Service
@Transactional
public class FileDataServiceImpl extends AbstractService<FileData> implements FileDataService {
    @Resource
    private FileDataMapper fileDataMapper;

}
