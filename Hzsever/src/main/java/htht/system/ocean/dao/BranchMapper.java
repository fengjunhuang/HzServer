package htht.system.ocean.dao;

import htht.system.ocean.core.Mapper;
import htht.system.ocean.model.Branch;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BranchMapper extends Mapper<Branch> {

 /*   @Select("SELECT * FROM ( SELECT a.*, ROWNUM RN FROM (SELECT * FROM account) a  WHERE ROWNUM <= #{endNum} )WHERE RN >= #{startNum} ")*/


    @Update("UPDATE TB_BRANCH SET BRANCH_NAME = #{branchName} WHERE BRANCH_ID = #{id}")
    int updateBranchName(@Param("id") Long id, @Param("branchName") String branchName);
//


    @Select("SELECT   * FROM TB_BRANCH WHERE BRANCH_NAME = #{branchName} AND PARENT_ID = #{parentId}" )
    @ResultType(Branch.class)
    List<Branch> queryByNameAndPranentId(@Param("parentId") Long parentId, @Param("branchName") String branchName);

    int createBranch(Branch branch);

    int updateSujectId(Branch branche);
}