package htht.system.ocean.dao;

import htht.system.ocean.core.Mapper;
import htht.system.ocean.model.Branch;
import htht.system.ocean.model.FrontDeptMenau;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FrontDeptMenauMapper extends Mapper<FrontDeptMenau> {
    int createMenau(FrontDeptMenau frontDeptMenau);

//    @Select("SELECT   * FROM FRONT_DEPT_MENAU WHERE DEPT_ID = #{deptId}" )
//    @ResultType(FrontDeptMenau.class)
    List<FrontDeptMenau> querydeptId( Long deptId);
    int updateBymeIdAndDeptId(FrontDeptMenau frontDeptMenau);
}