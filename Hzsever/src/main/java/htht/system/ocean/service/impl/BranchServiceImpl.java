package htht.system.ocean.service.impl;

import htht.system.ocean.dao.BranchMapper;
import htht.system.ocean.model.Branch;
import htht.system.ocean.service.BranchService;
import htht.system.ocean.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/04/03.
 */
@Service
@Transactional
public class BranchServiceImpl extends AbstractService<Branch> implements BranchService {
    @Resource
    private BranchMapper branchMapper;


    @Override
    public int createUser(Branch branch) {
        return branchMapper.createBranch(branch);
    }

    @Override
    public int updateBranchName(Long id, String branchName) {
        return branchMapper.updateBranchName(id,branchName);
    }

    @Override
    public List<Branch> queryByNameAndPranentId(Long praentId, String branchName) {

        return  branchMapper.queryByNameAndPranentId(praentId,branchName);
    }

    @Override
    public int updateSujectId(Branch branch) {
        return  branchMapper.updateSujectId(branch);
    }
}
