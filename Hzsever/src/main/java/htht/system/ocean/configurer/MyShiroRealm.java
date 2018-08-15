package htht.system.ocean.configurer;

import htht.system.ocean.dao.FrontDeptMenauMapper;
import htht.system.ocean.dao.FrontRoleMapper;
import htht.system.ocean.dao.FrontUserMapper;
import htht.system.ocean.dao.MenuDataMapper;
import htht.system.ocean.model.FrontDeptMenau;
import htht.system.ocean.model.MenuData;
import htht.system.ocean.service.FrontDeptMenauService;
import htht.system.ocean.system.front.model.RoleDO;
import htht.system.ocean.system.front.model.UserDO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {
//角色权限和对应权限添加

    @Autowired
    FrontRoleMapper frontRoleMapper;
    @Autowired
    FrontDeptMenauService frontDeptMenauService;
    @Autowired
    FrontUserMapper frontUserMapper;
    @Autowired
    MenuDataMapper menuDataMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //添加角色
        simpleAuthorizationInfo.addRole("admin");

        //添加权限
        simpleAuthorizationInfo.addStringPermission("create");
     UserDO userDO=   frontUserMapper.selectByPrimaryKey(name);
RoleDO roleDO=      frontRoleMapper.selectByPrimaryKey( userDO.getRoleId());


        Condition condition = new  Condition(FrontDeptMenau.class);
        condition.createCriteria().andEqualTo("deptId", roleDO.getRoleId());
        List<FrontDeptMenau>  frontDeptMenaus =frontDeptMenauService.findByCondition(condition);

          simpleAuthorizationInfo.addRole(roleDO.getRoleName());

      for(FrontDeptMenau menuData:frontDeptMenaus){
      String  permisson=    menuDataMapper.selectByPrimaryKey(menuData.getMenuId()).getMenuName();
          simpleAuthorizationInfo.addStringPermission(permisson);

      }



        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken atoken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) atoken;
        // 从数据库获取对应用户名密码的用户

       UserDO  frontUser= frontUserMapper.selectByPrimaryKey(token.getUsername());

      String pwd=   new String((char[]) token.getPassword());
       if(frontUser!=null){
        if (null == pwd) {
            throw new AccountException("用户名不正确");
        } else if (!frontUser.getPassword().equals(new String((char[]) token.getCredentials()))) {
            throw new AccountException("密码不正确");
        }
       }else {
           throw new AccountException("账户不存在");
       }

        return new SimpleAuthenticationInfo(token.getPrincipal(), pwd, getName());

    }
}