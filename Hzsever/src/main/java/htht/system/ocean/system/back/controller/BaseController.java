package htht.system.ocean.system.back.controller;


import org.springframework.stereotype.Controller;

import htht.system.ocean.system.front.model.UserDO;
import htht.system.ocean.util.ShiroUtils;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUserName();
	}
}