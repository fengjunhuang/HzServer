package htht.system.ocean.system.front.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.dao.FrontUserMapper;
import htht.system.ocean.model.FrontDeptMenau;
import htht.system.ocean.model.MenuData;
import htht.system.ocean.service.FrontDeptMenauService;
import htht.system.ocean.service.MenuDataService;
import htht.system.ocean.system.back.model.R;
import htht.system.ocean.system.front.model.PermissionVO;
import htht.system.ocean.system.front.model.RoleDO;
import htht.system.ocean.system.front.model.UserDO;
import htht.system.ocean.system.front.service.FrontRoleService;
import htht.system.ocean.util.GsonHelper;
import htht.system.ocean.util.MD5Utils;
import htht.system.ocean.util.PermissionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/front/role")
@Controller
public class RoleController {
    String prefix = "front/role";

    @Autowired
    FrontRoleService roleService;
    @Autowired
    MenuDataService menuDataService;
    @Autowired
    FrontDeptMenauService frontDeptMenauService;
    @Autowired
    FrontUserMapper frontUserMapper;
//    @RequiresPermissions("sys:role:role")
    @GetMapping()
    String role() {
        return prefix + "/role";
    }

//    @RequiresPermissions("sys:role:role")
    @GetMapping("/list")
    @ResponseBody()
    List<RoleDO> list() {
        List<RoleDO> roles = roleService.findAll();
        return roles;
    }
//
//    @RequiresPermissions("sys:role:add")
    @GetMapping("/add")
    String add(Model model) {

        List<MenuData> lists= menuDataService.findAll();





        model.addAttribute("permissions", lists);
        return prefix + "/add";
    }

//    @RequiresPermissions("sys:role:edit")

    @PostMapping("/getPermissions")

    @ResponseBody
    Result  getPermission(@RequestBody String jsonParams) {


       JSONObject jsonObject = JSON.parseObject(jsonParams);

        String userId=jsonObject.getString("userName");
        UserDO userDO=   frontUserMapper.selectByPrimaryKey(userId);
        List<MenuData> lists= menuDataService.findAll();

        Condition condition = new  Condition(FrontDeptMenau.class);
        condition.createCriteria().andEqualTo("deptId", userDO.getRoleId());
        List<FrontDeptMenau>  frontDeptMenaus =frontDeptMenauService.findByCondition(condition);

        List<Boolean> booleans =new ArrayList<>();
        for(MenuData menuData:lists){
            menuData.setChooseBol(false);
            for(FrontDeptMenau frontDeptMenau:frontDeptMenaus){
                if(menuData.getMenuId()==frontDeptMenau.getMenuId()){
                    if(frontDeptMenau.getMenuStatus()==1){
                        menuData.setChooseBol(true);
                    }else {
                        menuData.setChooseBol(false);
                    }
                }


            }
        }

        return  ResultGenerator.genSuccessResult( frontDeptMenaus);

    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        RoleDO roleDO = roleService.findById(id);
        List<MenuData> lists= menuDataService.findAll();

        Condition condition = new  Condition(FrontDeptMenau.class);
        condition.createCriteria().andEqualTo("deptId", roleDO.getRoleId());
        List<FrontDeptMenau>  frontDeptMenaus =frontDeptMenauService.findByCondition(condition);

        List<Boolean> booleans =new ArrayList<>();
        for(MenuData menuData:lists){
            menuData.setChooseBol(false);
          for(FrontDeptMenau frontDeptMenau:frontDeptMenaus){
              if(menuData.getMenuId()==frontDeptMenau.getMenuId()){
                  if(frontDeptMenau.getMenuStatus()==1){
                      menuData.setChooseBol(true);
                  }else {
                      menuData.setChooseBol(false);
                  }
              }


          }
        }


        model.addAttribute("role", roleDO);

        model.addAttribute("permissions", lists);
        model.addAttribute("currentPermissions", frontDeptMenaus);


        return prefix + "/edit";
    }



//    @RequiresPermissions("sys:role:add")
    @PostMapping("/save")
    @ResponseBody()
    R save(RoleDO role) {
        if (roleService.save(role) > 0) {
            return R.ok();
        } else {
            return R.error(1, "保存失败");
        }
    }

//    @GetMapping("/getPermissions")
//    @ResponseBody()
//    List<PermissionVO> getPermissions() {
//       return PermissionUtils.getAllPermissions();
//    }
//
//    @RequiresPermissions("sys:role:edit")
    @PostMapping("/update")
    @ResponseBody()
    R update(RoleDO role) {
        if (roleService.update(role) > 0) {
            return R.ok();
        } else {
            return R.error(1, "更新失败");
        }
    }
//
//    @RequiresPermissions("sys:role:remove")
    @PostMapping("/remove")
    @ResponseBody()
    R save(Long id) {
        if (roleService.remove(id) > 0) {
            return R.ok();
        } else {
            return R.error(1, "删除失败");
        }
    }

//    @RequiresPermissions("sys:role:batchRemove")
    @PostMapping("/batchRemove")
    @ResponseBody
    R batchRemove(@RequestParam("ids[]") Long[] ids) {
        int r = roleService.batchremove(ids);
        if (r > 0) {
            return R.ok();
        }
        return R.error();
    }


}
