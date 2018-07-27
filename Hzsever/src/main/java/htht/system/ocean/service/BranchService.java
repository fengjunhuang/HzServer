package htht.system.ocean.service;
import htht.system.ocean.core.Service;
import htht.system.ocean.model.Branch;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/04/03.
 */
public interface BranchService extends Service<Branch> {
  int  createUser(Branch branch);


  int updateBranchName(@Param("id") Long id, @Param("branchName") String branchName);
  List<Branch> queryByNameAndPranentId(Long praentId, String branchName);
  int updateSujectId(Branch branch);
}
