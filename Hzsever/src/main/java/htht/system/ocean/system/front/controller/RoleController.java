package htht.system.ocean.system.front.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import htht.system.ocean.system.back.model.R;
import htht.system.ocean.system.front.model.PermissionVO;
import htht.system.ocean.system.front.model.RoleDO;
import htht.system.ocean.system.front.service.FrontRoleService;
import htht.system.ocean.util.PermissionUtils;


@RequestMapping("/front/role")
@Controller
public class RoleController {
    String prefix = "front/role";

    @Autowired
    FrontRoleService roleService;

    @RequiresPermissions("sys:role:role")
    @GetMapping()
    String role() {
        return prefix + "/role";
    }

    @RequiresPermissions("sys:role:role")
    @GetMapping("/list")
    @ResponseBody()
    List<RoleDO> list() {
        List<RoleDO> roles = roleService.findAll();
        return roles;
    }

    @RequiresPermissions("sys:role:add")
    @GetMapping("/add")
    String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("sys:role:edit")
    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        RoleDO roleDO = roleService.findById(id);
        model.addAttribute("role", roleDO);
        model.addAttribute("permissions", PermissionUtils.getAllPermissions());
        model.addAttribute("currentPermissions", PermissionUtils.getAllPermissions());
        return prefix + "/edit";
    }

    @RequiresPermissions("sys:role:add")
    @PostMapping("/save")
    @ResponseBody()
    R save(RoleDO role) {
        if (roleService.save(role) > 0) {
            return R.ok();
        } else {
            return R.error(1, "保存失败");
        }
    }

    @GetMapping("/getPermissions")
    @ResponseBody()
    List<PermissionVO> getPermissions() {
       return PermissionUtils.getAllPermissions();
    }

    @RequiresPermissions("sys:role:edit")
    @PostMapping("/update")
    @ResponseBody()
    R update(RoleDO role) {
        if (roleService.update(role) > 0) {
            return R.ok();
        } else {
            return R.error(1, "更新失败");
        }
    }

    @RequiresPermissions("sys:role:remove")
    @PostMapping("/remove")
    @ResponseBody()
    R save(Long id) {
        if (roleService.remove(id) > 0) {
            return R.ok();
        } else {
            return R.error(1, "删除失败");
        }
    }

    @RequiresPermissions("sys:role:batchRemove")
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
