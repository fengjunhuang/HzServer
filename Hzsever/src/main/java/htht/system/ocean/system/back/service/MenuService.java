package htht.system.ocean.system.back.service;


import htht.system.ocean.system.back.model.MenuDO;
import htht.system.ocean.system.back.model.Tree;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public interface MenuService {
	Tree<MenuDO> getSysMenuTree(Long id);

	List<Tree<MenuDO>> listMenuTree(Long id);

	Tree<MenuDO> getTree();

	Tree<MenuDO> getTree(Long id);

	List<MenuDO> list();

	int remove(Long id);

	int save(MenuDO menu);

	int update(MenuDO menu);

	MenuDO get(Long id);

	Set<String> listPerms(Long userId);
}
