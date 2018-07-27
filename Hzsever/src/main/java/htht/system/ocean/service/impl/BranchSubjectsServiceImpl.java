package htht.system.ocean.service.impl;

import htht.system.ocean.dao.BranchSubjectsMapper;
import htht.system.ocean.model.BranchSubjects;
import htht.system.ocean.service.BranchSubjectsService;
import htht.system.ocean.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/18.
 */
@Service
@Transactional
public class BranchSubjectsServiceImpl extends AbstractService<BranchSubjects> implements BranchSubjectsService {
    @Resource
    private BranchSubjectsMapper branchSubjectsMapper;

    @Override
    public int create(BranchSubjects branchSubjects) {
        return  branchSubjectsMapper.create(branchSubjects);
    }
}
