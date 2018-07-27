package htht.system.ocean.system.front.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import htht.system.ocean.core.AbstractService;
import htht.system.ocean.dao.FrontRoleMapper;
import htht.system.ocean.dao.FrontUserMapper;
import htht.system.ocean.dao.FrontUserRoleMapper;
import htht.system.ocean.system.front.model.RoleDO;
import htht.system.ocean.system.front.model.UserDO;
import htht.system.ocean.system.front.service.FrontRoleService;


@Service
public class FrontRoleServiceImpl extends AbstractService<RoleDO> implements FrontRoleService {

    public static final String ROLE_ALL_KEY = "\"role_all\"";

    public static final String DEMO_CACHE_NAME = "role";

    @Autowired
    FrontRoleMapper roleMapper;
    @Autowired
    FrontUserMapper userMapper;
    @Autowired
    FrontUserRoleMapper userRoleMapper;

    @Cacheable(value = DEMO_CACHE_NAME, key = ROLE_ALL_KEY)
    @Override
    public List<RoleDO> list() {
        List<RoleDO> roles = roleMapper.selectAll();
        return roles;
    }

    @Override
    public List<RoleDO> list(Long userId) {
        UserDO userDO = userMapper.selectByPrimaryKey(userId);
        long roleId = userDO.getRoleId();
        List<RoleDO> roles = roleMapper.selectAll();
        for (RoleDO roleDO : roles) {
            roleDO.setRoleSign("false");
            if (roleDO.getRoleId()== roleId) {
                roleDO.setRoleSign("true");
                break;
            }
        }
        return roles;
    }

    @CacheEvict(value = DEMO_CACHE_NAME, key = ROLE_ALL_KEY)
    @Transactional
    @Override
    public int save(RoleDO role) {
        int count = roleMapper.insert(role);
        return count;
    }

    @CacheEvict(value = DEMO_CACHE_NAME, key = ROLE_ALL_KEY)
    @Transactional
    @Override
    public int remove(Long id) {
        int count = roleMapper.remove(id);
        return count;
    }

    @Override
    public RoleDO get(Long id) {
        RoleDO roleDO = roleMapper.selectByPrimaryKey(id);
        return roleDO;
    }

    @CacheEvict(value = DEMO_CACHE_NAME, key = ROLE_ALL_KEY)
    @Override
    public int update(RoleDO role) {
        int r = roleMapper.update(role);
//        List<Long> menuIds = role.getMenuIds();
//        Long roleId = role.getRoleId();
//        roleMenuMapper.removeByRoleId(roleId);
//        List<RoleMenuDO> rms = new ArrayList<>();
//        for (Long menuId : menuIds) {
//            RoleMenuDO rmDo = new RoleMenuDO();
//            rmDo.setRoleId(roleId);
//            rmDo.setMenuId(menuId);
//            rms.add(rmDo);
//        }
//        if (rms.size() > 0) {
//            roleMenuMapper.batchSave(rms);
//        }
        return r;
    }

    @Override
    public int batchremove(Long[] ids) {
        int r = roleMapper.batchRemove(ids);
        return r;
    }

}
