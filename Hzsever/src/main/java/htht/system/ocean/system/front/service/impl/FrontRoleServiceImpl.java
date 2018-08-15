package htht.system.ocean.system.front.service.impl;


import htht.system.ocean.core.AbstractService;
import htht.system.ocean.dao.*;
import htht.system.ocean.model.FrontDeptMenau;
import htht.system.ocean.model.MenuData;
import htht.system.ocean.system.back.model.MenuDO;
import htht.system.ocean.system.front.model.RoleDO;
import htht.system.ocean.system.front.model.UserDO;
import htht.system.ocean.system.front.service.FrontRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    @Autowired
    FrontRoleMapper frontRoleMapper;
    @Autowired
    FrontDeptMenauMapper frontDeptMenauMapper;
    @Autowired
    MenuDataMapper menuDataMapper;

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
//            roleDO.setRoleSign("false");
            if (roleDO.getRoleId()== roleId) {
//                roleDO.setRoleSign("true");
                break;
            }
        }
        return roles;
    }

    @CacheEvict(value = DEMO_CACHE_NAME, key = ROLE_ALL_KEY)
    @Transactional
    @Override
    public int save(RoleDO role) {
        role.setRoleId(222l);
        role.setGmtCreate(new Date(System.currentTimeMillis()));
        int count = roleMapper.create(role);
        return count;
    }

    @CacheEvict(value = DEMO_CACHE_NAME, key = ROLE_ALL_KEY)
    @Transactional
    @Override
    public int remove(Long id) {
        int count = roleMapper.deleteByPrimaryKey(id);
        return count;
    }

    @Override
    public RoleDO get(Long id) {
        RoleDO roleDO = roleMapper.selectByPrimaryKey(id);
        return roleDO;
    }

    @CacheEvict(value = DEMO_CACHE_NAME, key = ROLE_ALL_KEY)
    @Override
    @Transactional
    public int update(RoleDO role) {
    List<MenuData> menuDatas=  menuDataMapper.selectAll();
        FrontDeptMenau frontDeptMenau =new FrontDeptMenau();
       List<String> menusIds =new ArrayList<>();
        for(MenuData menuData:menuDatas){
            menusIds.add(menuData.getMenuId()+"");

        }
        List<String> chooseIds=new ArrayList<>();
        for(String s :role.getPermissions().split(",")){
            frontDeptMenau.setDeptId(role.getRoleId());
            frontDeptMenau.setMenuId(Long.valueOf(s));
            frontDeptMenau.setMenuStatus(1);

            chooseIds.add(s);
            frontDeptMenau.setCreateTime(new Date(System.currentTimeMillis()));

            Condition condition = new Condition(FrontDeptMenau.class);
            condition.createCriteria().andEqualTo("deptId",role.getRoleId()).andEqualTo("menuId", frontDeptMenau.getMenuId());
             for(MenuData menuData:menuDatas){
                 if(menuData.getMenuId().equals(frontDeptMenau.getMenuId())){
                     frontDeptMenau.setMenuName(menuData.getMenuName());
                 }
             }
            if( frontDeptMenauMapper.updateBymeIdAndDeptId(frontDeptMenau)==0){
                frontDeptMenauMapper.createMenau(frontDeptMenau);
            }


        }
        menusIds.removeAll(chooseIds);
        for(String s :menusIds){
            frontDeptMenau.setDeptId(role.getRoleId());
            frontDeptMenau.setMenuId(Long.valueOf(s));
            frontDeptMenau.setMenuStatus(0);

            frontDeptMenau.setCreateTime(new Date(System.currentTimeMillis()));
            Condition condition = new Condition(FrontDeptMenau.class);
            condition.createCriteria().andEqualTo("deptId",role.getRoleId()).andEqualTo("menuId", frontDeptMenau.getMenuId());
            for(MenuData menuData:menuDatas){
                if(menuData.getMenuId().equals(frontDeptMenau.getMenuId())){
                    frontDeptMenau.setMenuName(menuData.getMenuName());
                }
            }
            if( frontDeptMenauMapper.updateBymeIdAndDeptId(frontDeptMenau)==0){
                frontDeptMenauMapper.createMenau(frontDeptMenau);
            }

        }



return  super.update(role);
    }

    @Override
    public int batchremove(Long[] ids) {
        int r = roleMapper.batchRemove(ids);
        return r;
    }

}
