package com.chothuenhatro.controller.customer;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.chothuenhatro.constant.SystemConstant;
import com.chothuenhatro.dto.UserDTO;
import com.chothuenhatro.security.utils.SecurityUtils;
import com.chothuenhatro.service.IUserService;
import com.chothuenhatro.service.impl.RoleService;
import com.chothuenhatro.utils.MessageUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller(value = "profileControllerOfCustomer")
public class ProfileController {

	@Autowired
	private IUserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/customer-profile", method = RequestMethod.GET)
	public ModelAndView profileUser() {
		ModelAndView mav = new ModelAndView("customer/profile");
		mav.addObject(SystemConstant.MODEL, new UserDTO());
		mav.addObject("user", userService.findUserById(SecurityUtils.getPrincipal().getId()));
		return mav;
	}
}
