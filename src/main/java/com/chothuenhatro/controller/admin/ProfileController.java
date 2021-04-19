package com.chothuenhatro.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chothuenhatro.constant.SystemConstant;
import com.chothuenhatro.dto.UserDTO;
import com.chothuenhatro.security.utils.SecurityUtils;
import com.chothuenhatro.service.IUserService;
import com.chothuenhatro.service.impl.RoleService;

@Controller(value = "profileControllerOfAdmin")
public class ProfileController {

	@Autowired
	private IUserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/admin/profile", method = RequestMethod.GET)
	public ModelAndView profileUser() {
		ModelAndView mav = new ModelAndView("admin/user/edit");
		mav.addObject(SystemConstant.MODEL, new UserDTO());
		mav.addObject("user", userService.findUserById(SecurityUtils.getPrincipal().getId()));
		return mav;
	}
}
