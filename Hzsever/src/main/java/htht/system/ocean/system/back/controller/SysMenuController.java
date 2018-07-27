package htht.system.ocean.system.back.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.system.back.model.MenuDO;
import htht.system.ocean.system.back.model.Tree;
import htht.system.ocean.system.back.service.MenuService;

@RequestMapping("/sys/menu")
@Controller
public class SysMenuController {
    String prefix = "system/menu";
    @Autowired
    MenuService menuService;

    //	@RequiresPermissions("sys:menu:menu")
    @GetMapping()
    String menu(Model model) {
        return prefix + "/menu";
    }

    //	@RequiresPermissions("sys:menu:menu")
    @RequestMapping("/list")
    @ResponseBody
    List<MenuDO> list() {
        List<MenuDO> menus = menuService.list();

        return menus;
    }

    @RequiresPermissions("sys:menu:add")
    @GetMapping("/add/{pId}")
    String add(Model model, @PathVariable("pId") Long pId) {
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", menuService.get(pId).getName());
        }
        return prefix + "/add";
    }

    @RequiresPermissions("sys:menu:edit")
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") Long id) {
        MenuDO mdo = menuService.get(id);
        Long pId = mdo.getParentId();
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", menuService.get(pId).getName());
        }
        model.addAttribute("menu", mdo);
        return prefix + "/edit";
    }

    //	@RequiresPermissions("sys:menu:add")
    @PostMapping("/save")
    @ResponseBody
    Result save(MenuDO menu) {

        if (menuService.save(menu) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("保存失败");
        }
    }

    //
//	@NeedPermission("更新菜单")
//	@RequiresPermissions("sys:menu:edit")
    @PostMapping("/update")
    @ResponseBody
    Result update(MenuDO menu) {
        if (menuService.update(menu) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("更新失败");
        }
    }

    //
//	@NeedPermission("删除菜单")
//	@RequiresPermissions("sys:menu:remove")
    @PostMapping("/remove")
    @ResponseBody
    Result remove(Long id) {
        if (menuService.remove(id) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    @GetMapping("/tree")
    @ResponseBody
    Tree<MenuDO> tree() {
        Tree<MenuDO> tree = new Tree<MenuDO>();
        tree = menuService.getTree();
        return tree;
    }

    @GetMapping("/tree/{roleId}")
    @ResponseBody
    Tree<MenuDO> tree(@PathVariable("roleId") Long roleId) {
        Tree<MenuDO> tree = new Tree<MenuDO>();
        tree = menuService.getTree(roleId);
        return tree;
    }
}
