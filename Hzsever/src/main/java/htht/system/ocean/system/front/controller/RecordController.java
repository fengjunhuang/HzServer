package htht.system.ocean.system.front.controller;


import com.github.pagehelper.PageInfo;
import htht.system.ocean.dao.FrontUserMapper;
import htht.system.ocean.system.back.controller.BaseController;
import htht.system.ocean.system.back.model.DeptDO;
import htht.system.ocean.system.back.model.R;
import htht.system.ocean.system.back.model.Tree;
import htht.system.ocean.system.front.model.RoleDO;
import htht.system.ocean.system.front.model.UserDO;
import htht.system.ocean.system.front.service.FrontRoleService;
import htht.system.ocean.system.front.service.FrontUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/front/record")
@Controller
public class RecordController extends BaseController {
    private String prefix = "front/record";
    @Autowired
    FrontUserService mFrontUserService;
    @Autowired
    FrontRoleService roleService;
    @Autowired
    FrontUserMapper frontUserMapper;

//	@RequiresPermissions("sys:user:user")
    @GetMapping("")
    String user(Model model) {
        return prefix + "/record";
    }



	@GetMapping("/list")
	@ResponseBody
    PageInfo<UserDO> list(@RequestParam Map<String, Object> params) {
        PageInfo pageInfo = mFrontUserService.getAllUserByPage(params);
		return pageInfo;
	}

//    @RequiresPermissions("sys:user:add")
    @GetMapping("/add")
    String add(Model model) {
        List<RoleDO> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return prefix + "/add";
    }

//    @RequiresPermissions("sys:user:edit")
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") String id) {

        UserDO userDO = frontUserMapper.selectByPrimaryKey(id);
        model.addAttribute("user", userDO);
        List<RoleDO> roles = roleService.list();
        for(RoleDO roleDO:roles){
            if(roleDO.getRoleId().equals(userDO.getRoleId())){
                roleDO.setRoleSign(true);
            }else {
                roleDO.setRoleSign(false);
            }

        }
        model.addAttribute("roles", roles);
        return prefix + "/edit";
    }

//    @RequiresPermissions("sys:user:add")
    @PostMapping("/save")
    @ResponseBody
    R save(UserDO user) {
	    user.setUserId(1L);
        if (mFrontUserService.addUser(user) > 0) {
            return R.ok();
        }
        return R.error();
    }

//    @RequiresPermissions("sys:user:edit")
    @PostMapping("/update")
    @ResponseBody
    R update(UserDO user) {
        if (mFrontUserService.update(user) > 0) {
            return R.ok();
        }
        return R.error();
    }

//
//    @RequiresPermissions("sys:user:edit")
    @PostMapping("/updatePeronal")
    @ResponseBody
    R updatePeronal(UserDO user) {
        if (mFrontUserService.updatePersonal(user) > 0) {
            return R.ok();
        }
        return R.error();
    }


//    @RequiresPermissions("sys:user:remove")
    @PostMapping("/remove")
    @ResponseBody
    R remove(Long id) {
        if (mFrontUserService.deleteById(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

//    @RequiresPermissions("sys:user:batchRemove")
    @PostMapping("/batchRemove")
    @ResponseBody
    R batchRemove(@RequestParam("ids[]") Long[] userIds) {
        int r = mFrontUserService.batchremove(userIds);
        if (r > 0) {
            return R.ok();
        }
        return R.error();
    }


    //	@RequiresPermissions("sys:user:resetPwd")
    @GetMapping("/resetPwd/{id}")
    String resetPwd(@PathVariable("id") Long userId, Model model) {

        UserDO userDO = new UserDO();
        userDO.setUserId(userId);
        model.addAttribute("user", userDO);
        return prefix + "/reset_pwd";
    }


    @GetMapping("/tree")
    @ResponseBody
    public Tree<DeptDO> tree() {
        Tree<DeptDO> tree = new Tree<DeptDO>();
        tree = mFrontUserService.getTree();
        return tree;
    }

    @GetMapping("/treeView")
    String treeView() {
        return prefix + "/userTree";
    }

	@ResponseBody
	@PostMapping("/uploadImg")
    R uploadImg(@RequestParam("avatar_file") MultipartFile file, String avatar_data, HttpServletRequest request) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		Map<String, Object> result = new HashMap<>();
		try {
			result = mFrontUserService.updatePersonalImg(file, avatar_data, getUserId());
		} catch (Exception e) {
			return R.error("更新图像失败！");
		}
		if(result!=null && result.size()>0){
			return R.ok(result);
		}else {
			return R.error("更新图像失败！");
		}
	}
}
