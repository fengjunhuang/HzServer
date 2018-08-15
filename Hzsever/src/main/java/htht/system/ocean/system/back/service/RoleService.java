package htht.system.ocean.system.back.service;


import htht.system.ocean.system.back.model.RoleDO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

	RoleDO get(Long id);

	List<RoleDO> list();

	int save(RoleDO role);

	int update(RoleDO role);

	int remove(Long id);

	List<RoleDO> list(Long userId);

	int batchremove(Long[] ids);
}
