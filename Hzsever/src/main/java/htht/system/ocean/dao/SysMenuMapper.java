package htht.system.ocean.dao;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import htht.system.ocean.core.Mapper;
import htht.system.ocean.system.back.model.MenuDO;

@Repository
public interface SysMenuMapper extends Mapper<MenuDO> {

	MenuDO get(Long menuId);

	List<MenuDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(MenuDO menu);

	int update(MenuDO menu);

	int remove(Long menuId);

	int batchRemove(Long[] menuIds);

	List<MenuDO> listMenuByUserId(Long id);

	List<String> listUserPerms(Long id);
}
