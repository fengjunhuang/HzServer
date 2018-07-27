package htht.system.ocean.dao;


import java.util.List;
import java.util.Map;

import htht.system.ocean.core.Mapper;
import htht.system.ocean.system.back.model.RoleDO;

public interface SysRoleMapper extends Mapper<RoleDO> {

	RoleDO get(Long roleId);
	
	List<RoleDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(RoleDO role);
	
	int update(RoleDO role);
	
	int remove(Long roleId);
	
	int batchRemove(Long[] roleIds);
}
