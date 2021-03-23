package com.tijian.common.controller;

import org.springframework.stereotype.Controller;

import com.tijian.common.utils.ShiroUtils;
import com.tijian.owneruser.domain.OwnerUserDO;
import com.tijian.system.domain.UserToken;

@Controller
public class BaseController {
	public OwnerUserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getChectorId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
	/*public Long getforIds() {
		return getUser().getUserId();
	}*/
}