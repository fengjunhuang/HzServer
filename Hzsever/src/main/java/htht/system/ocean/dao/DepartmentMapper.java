package htht.system.ocean.dao;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import htht.system.ocean.core.Mapper;
import htht.system.ocean.system.back.model.DeptDO;

@Repository
public interface DepartmentMapper extends Mapper<DeptDO> {

	DeptDO get(Long deptId);
	
	List<DeptDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(DeptDO dept);
	
	int remove(Long deptId);
	
	int batchRemove(Long[] deptIds);
	
	Long[] listParentDept();
	
	int getDeptUserNumber(Long deptId);
}
