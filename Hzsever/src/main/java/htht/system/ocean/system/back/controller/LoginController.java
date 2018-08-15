package htht.system.ocean.system.back.controller;


import htht.system.ocean.core.Result;
import htht.system.ocean.core.ResultGenerator;
import htht.system.ocean.system.back.model.MenuDO;
import htht.system.ocean.system.back.model.Tree;
import htht.system.ocean.system.back.service.MenuService;
import htht.system.ocean.system.front.model.UserDO;
import htht.system.ocean.util.GsonHelper;
import htht.system.ocean.util.MD5Utils;
import htht.system.ocean.util.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    MenuService menuService;
//	@Autowired
//	FileService fileService;
//	@GetMapping({ "/", "" })
//	String welcome(Model model) {
//		return "redirect:/blog";
//	}

	@GetMapping({ "/index" })
	String index(Model model) {
//		List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
		List<Tree<MenuDO>> menus = menuService.listMenuTree(null);
		model.addAttribute("menus", menus);
//		model.addAttribute("name", getUser().getAlias());
//		FileDO fileDO = fileService.get(getUser().getPicId());
//		if(fileDO!=null&&fileDO.getUrl()!=null){
//			if(fileService.isExist(fileDO.getUrl())){
//				model.addAttribute("picUrl",fileDO.getUrl());
//			}else {
//				model.addAttribute("picUrl","/img/photo_s.jpg");
//			}
//		}else {
//			model.addAttribute("picUrl","/img/photo_s.jpg");
//		}
		model.addAttribute("username","admin1");
		return "index_v1";
	}

//	@GetMapping("/login")
//	String login() {
//		return "login";
//	}
//

//	@PostMapping("/login")
//	@ResponseBody
//	R ajaxLogin(String username, String password) {
//
//
//		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//		Subject subject = SecurityUtils.getSubject();
//		try {
//			subject.login(token);
//			return R.ok();
//		} catch (AuthenticationException e) {
//			return R.error("用户或密码错误");
//		}
//	}
	/**
	 * 登录方法
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
	@ResponseBody
	public Result ajaxLogin(String username, String password) {

		Subject subject = SecurityUtils.getSubject();
		// 在认证提交前准备 token（令牌）
String ss= MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Utils.encrypt(username, password));
		// 执行认证登陆
       try {
		   subject.login(token);

	   }catch (AccountException e){
       	return  ResultGenerator.genFailResult(e.getMessage());

	   }

		//根据权限，指定返回数据
//		String role = userMapper.getRole(username);
//		if ("user".equals(role)) {
//			return resultMap.success().message("欢迎登陆");
//		}
//		if ("admin".equals(role)) {
//			return resultMap.success().message("欢迎来到管理员页面");
//		}
		return  ResultGenerator.genSuccessResult("登录成功");

}

	@PostMapping("/loginUser")
	@ResponseBody
	Result login(@RequestBody @Validated String jsonParams ){


		UserDO userDO = GsonHelper.fromJsontoBean( jsonParams, UserDO.class);
		Subject subject = SecurityUtils.getSubject();
		// 在认证提交前准备 token（令牌）
		String ss= MD5Utils.encrypt(userDO.getUserName(), userDO.getPassword());
		UsernamePasswordToken token = new UsernamePasswordToken(userDO.getUserName(), MD5Utils.encrypt(userDO.getUserName(),  userDO.getPassword()));
		// 执行认证登陆
		try {
			subject.login(token);

		}catch (AccountException e){
			return  ResultGenerator.genFailResult(e.getMessage());

		}

		//根据权限，指定返回数据
//		String role = userMapper.getRole(username);
//		if ("user".equals(role)) {
//			return resultMap.success().message("欢迎登陆");
//		}
//		if ("admin".equals(role)) {
//			return resultMap.success().message("欢迎来到管理员页面");
//		}
		return  ResultGenerator.genSuccessResult("登录成功");


	}
	@GetMapping("/logout")
	String logout() {
		ShiroUtils.logout();
		return "redirect:/login";
	}

	@GetMapping("/main")
	String main() {
		return "main";
	}

	@GetMapping("/403")
	String error403() {
		return "403";
	}
	/**
	 * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
	 * @return
	 */
	@RequestMapping(value = "/unauth")
	@ResponseBody
	public Object unauth() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "1000000");
		map.put("msg", "未登录");
		return map;
	}

}
