package htht.system.ocean.system.front.controller;


import com.github.pagehelper.PageInfo;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.system.back.controller.BaseController;
import htht.system.ocean.system.back.model.DeptDO;
import htht.system.ocean.system.back.model.FrontUserVO;
import htht.system.ocean.system.back.model.R;
import htht.system.ocean.system.back.model.Tree;
import htht.system.ocean.system.front.model.RoleDO;
import htht.system.ocean.system.front.model.UserDO;
import htht.system.ocean.system.front.service.FrontRoleService;
import htht.system.ocean.system.front.service.FrontUserService;
import htht.system.ocean.util.GsonHelper;
import htht.system.ocean.util.OkHttpUtils;

@RequestMapping("/front/user")
@Controller
public class UserController extends BaseController {
    private String prefix = "front/user";
    @Autowired
    FrontUserService mFrontUserService;
    @Autowired
    FrontRoleService roleService;

	@RequiresPermissions("sys:user:user")
    @GetMapping("")
    String user(Model model) {
        return prefix + "/user";
    }

    @PostMapping("/login")
    @ResponseBody
    Result login(@RequestBody FrontUserVO frontUserVO ){
        String resultJson = OkHttpUtils.getSync("");
        UserDO userDO = GsonHelper.fromJsontoBean(resultJson, UserDO.class);
        mFrontUserService.saveUserInfo(userDO);
	    return ResultGenerator.genSuccessResult(userDO);
    }

	@GetMapping("/list")
	@ResponseBody
    PageInfo<UserDO> list(@RequestParam Map<String, Object> params) {
        PageInfo pageInfo = mFrontUserService.getAllUserByPage(params);
		return pageInfo;
	}

    @RequiresPermissions("sys:user:add")
    @GetMapping("/add")
    String add(Model model) {
        List<RoleDO> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return prefix + "/add";
    }

//    @RequiresPermissions("sys:user:edit")
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") Long id) {
        UserDO userDO = mFrontUserService.findById(id);
        model.addAttribute("user", userDO);
        List<RoleDO> roles = roleService.list(id);
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

    @RequiresPermissions("sys:user:edit")
    @PostMapping("/update")
    @ResponseBody
    R update(UserDO user) {
        if (mFrontUserService.update(user) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @RequiresPermissions("sys:user:edit")
    @PostMapping("/updatePeronal")
    @ResponseBody
    R updatePeronal(UserDO user) {
        if (mFrontUserService.updatePersonal(user) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @RequiresPermissions("sys:user:remove")
    @PostMapping("/remove")
    @ResponseBody
    R remove(Long id) {
        if (mFrontUserService.deleteById(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @RequiresPermissions("sys:user:batchRemove")
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
