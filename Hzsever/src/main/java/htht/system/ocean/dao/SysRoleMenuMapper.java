package htht.system.ocean.dao;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import htht.system.ocean.core.Mapper;
import htht.system.ocean.system.back.model.RoleMenuDO;

@Repository
public interface SysRoleMenuMapper extends Mapper<RoleMenuDO> {

	RoleMenuDO get(Long id);
	
	List<RoleMenuDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(RoleMenuDO roleMenu);
	
	int update(RoleMenuDO roleMenu);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	List<Long> listMenuIdByRoleId(Long roleId);
	
	int removeByRoleId(Long roleId);
	
	int batchSave(List<RoleMenuDO> list);
}
