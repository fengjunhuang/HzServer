package htht.system.ocean.system.back.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import htht.system.ocean.system.back.model.MenuDO;
import htht.system.ocean.system.back.model.Tree;
import htht.system.ocean.system.back.service.MenuService;
import htht.system.ocean.util.ShiroUtils;

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
//		model.addAttribute("username", getUser().getAlias());
		return "index_v1";
	}

//	@GetMapping("/login")
//	String login() {
//		return "login";
//	}
//
//	@NeedPermission("登录")
//	@PostMapping("/login")
//	@ResponseBody
//	R ajaxLogin(String username, String password) {
//		password = MD5Utils.encrypt(username, password);
//		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//		Subject subject = SecurityUtils.getSubject();
//		try {
//			subject.login(token);
//			return R.ok();
//		} catch (AuthenticationException e) {
//			return R.error("用户或密码错误");
//		}
//	}

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

}
