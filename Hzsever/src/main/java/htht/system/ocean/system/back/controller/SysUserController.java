package htht.system.ocean.system.back.controller;


import com.github.pagehelper.PageHelper;
import htht.system.ocean.system.back.model.*;
import htht.system.ocean.system.back.service.RoleService;
import htht.system.ocean.system.back.service.UserService;
import htht.system.ocean.util.PageUtils;
import htht.system.ocean.util.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/sys/user")
@Controller
public class SysUserController extends BaseController {
    private String prefix = "system/user";
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    //	@Autowired
//	DictService dictService;
	@RequiresPermissions("sys:user:user")
    @GetMapping("")
    String user(Model model) {
        return prefix + "/user";
    }

	@GetMapping("/list")
	@ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
        PageHelper.startPage(Integer.parseInt((String)params.get("offset")), Integer.parseInt((String)params.get("limit")));
        List<SysUserDO> list = userService.list(params);
//        PageInfo pageInfo = new PageInfo(list);
		// 查询列表数据
		Query query = new Query(params);
//		List<SysUserDO> sysUserList = userService.list(query);
		int total = userService.count(query);
		PageUtils pageUtil = new PageUtils(list, total);
		return pageUtil;
	}

    @RequiresPermissions("sys:user:add")
    @GetMapping("/add")
    String add(Model model) {
        List<RoleDO> roles = roleService.list();
        model.addAttribute("roles", roles);
        return prefix + "/add";
    }

//    @RequiresPermissions("sys:user:edit")
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") Long id) {
        SysUserDO userDO = userService.get(id);
        model.addAttribute("user", userDO);
        List<RoleDO> roles = roleService.list(id);
        model.addAttribute("roles", roles);
        return prefix + "/edit";
    }

//    @RequiresPermissions("sys:user:add")
    @PostMapping("/save")
    @ResponseBody
    R save(SysUserDO user) {
	    user.setUserId(12l);
	    user.setLoginTime(new Date(System.currentTimeMillis()));
        if (userService.save(user) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @RequiresPermissions("sys:user:edit")
    @PostMapping("/update")
    @ResponseBody
    R update(SysUserDO user) {
        if (userService.update(user) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @RequiresPermissions("sys:user:edit")
    @PostMapping("/updatePeronal")
    @ResponseBody
    R updatePeronal(SysUserDO user) {
        if (userService.updatePersonal(user) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @RequiresPermissions("sys:user:remove")
    @PostMapping("/remove")
    @ResponseBody
    R remove(Long id) {
        if (userService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @RequiresPermissions("sys:user:batchRemove")
    @PostMapping("/batchRemove")
    @ResponseBody
    R batchRemove(@RequestParam("ids[]") Long[] userIds) {
        int r = userService.batchremove(userIds);
        if (r > 0) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("/exit")
    @ResponseBody
    boolean exit(@RequestParam Map<String, Object> params) {
        // 存在，不通过，false
        return !userService.exit(params);
    }

    //	@RequiresPermissions("sys:user:resetPwd")
    @GetMapping("/resetPwd/{id}")
    String resetPwd(@PathVariable("id") Long userId, Model model) {

        SysUserDO userDO = new SysUserDO();
        userDO.setUserId(userId);
        model.addAttribute("user", userDO);
        return prefix + "/reset_pwd";
    }

//    @PostMapping("/resetPwd")
//    @ResponseBody
//    R resetPwd(UserVO userVO) {
//        try {
//            userService.resetPwd(userVO, getUser());
//            return R.ok();
//        } catch (Exception e) {
//            return R.error(1, e.getMessage());
//        }
//    }
//
//    @RequiresPermissions("sys:user:resetPwd")
//    @PostMapping("/adminResetPwd")
//    @ResponseBody
//    R adminResetPwd(UserVO userVO) {
//        try {
//            userService.adminResetPwd(userVO);
//            return R.ok();
//        } catch (Exception e) {
//            return R.error(1, e.getMessage());
//        }
//
//    }

    @GetMapping("/tree")
    @ResponseBody
    public Tree<DeptDO> tree() {
        Tree<DeptDO> tree = new Tree<DeptDO>();
        tree = userService.getTree();
        return tree;
    }

    @GetMapping("/treeView")
    String treeView() {
        return prefix + "/userTree";
    }

//	@GetMapping("/personal")
//	String personal(Model model) {
//		SysUserDO userDO  = userService.get(getUserId());
//		model.addAttribute("user",userDO);
//		model.addAttribute("hobbyList",dictService.getHobbyList(userDO));
//		model.addAttribute("sexList",dictService.getSexList());
//		return prefix + "/personal";
//	}

//	@ResponseBody
//	@PostMapping("/uploadImg")
//	R uploadImg(@RequestParam("avatar_file") MultipartFile file, String avatar_data, HttpServletRequest request) {
//		if ("test".equals(getUsername())) {
//			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
//		}
//		Map<String, Object> result = new HashMap<>();
//		try {
//			result = userService.updatePersonalImg(file, avatar_data, getUserId());
//		} catch (Exception e) {
//			return R.error("更新图像失败！");
//		}
//		if(result!=null && result.size()>0){
//			return R.ok(result);
//		}else {
//			return R.error("更新图像失败！");
//		}
//	}
}
