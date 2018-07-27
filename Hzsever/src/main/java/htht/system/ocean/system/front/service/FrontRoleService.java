package htht.system.ocean.system.front.service;


import org.springframework.stereotype.Service;

import java.util.List;

import htht.system.ocean.system.front.model.RoleDO;

@Service
public interface FrontRoleService extends htht.system.ocean.core.Service<RoleDO> {

	RoleDO get(Long id);

	List<RoleDO> list();

	int remove(Long id);

	List<RoleDO> list(Long userId);

	int batchremove(Long[] ids);
}
