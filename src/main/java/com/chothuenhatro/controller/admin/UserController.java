package com.chothuenhatro.controller.admin;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.chothuenhatro.constant.SystemConstant;
import com.chothuenhatro.dto.ProductCategoryDTO;
import com.chothuenhatro.dto.ProductDTO;
import com.chothuenhatro.dto.UserDTO;
import com.chothuenhatro.security.utils.SecurityUtils;
import com.chothuenhatro.service.IUserService;
import com.chothuenhatro.service.impl.RoleService;
import com.chothuenhatro.utils.DisplayTagUtils;
import com.chothuenhatro.utils.MessageUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller(value = "usersControllerOfAdmin")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private MessageUtils messageUtil;

//	@RequestMapping(value = "/admin/user-list", method = RequestMethod.GET)
//	public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL) UserDTO model, HttpServletRequest request) {
//		ModelAndView mav = new ModelAndView("admin/user/list");
//		DisplayTagUtils.of(request, model);
//		List<UserDTO> news = userService.getUsers(model.getSearchValue(),
//				PageRequest.of(model.getPage() - 1, model.getMaxPageItems()));
//		model.setListResult(news);
//		model.setTotalItems(userService.getTotalItems(model.getSearchValue()));
//		mav.addObject(SystemConstant.MODEL, model);
//		initMessageResponse(mav, request);
//		return mav;
//	}

	@RequestMapping(value = "/admin/user-list", method = RequestMethod.GET)
	public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL) UserDTO userDTO,
								@RequestParam(required = false) Map<String, String> params) {
		ModelAndView mav = new ModelAndView("admin/user/list");
		mav.addObject(SystemConstant.MODEL, userDTO);

		List<UserDTO> users = new ArrayList<>();

		if (CollectionUtils.isEmpty(params)) {
			users = userService.findAll();
		} else {
			users = userService.findByCondition(params);
		}
		mav.addObject("users", users);
		return mav;
	}

	@RequestMapping(value = "/admin/user-new", method = RequestMethod.GET)
	public ModelAndView showNewUserPage() {
		ModelAndView mav = new ModelAndView("admin/user/add");
		mav.addObject("user", new UserDTO());
		return mav;
	}

	@RequestMapping(value = "/admin/user-edit-{id}", method = RequestMethod.GET)
	public ModelAndView showEditUserPage(@PathVariable(name = "id") Long userId) {
		ModelAndView mav = new ModelAndView("admin/user/edit");
		UserDTO userDTO = userService.findUserById(userId);
		mav.addObject("user", userDTO);
		return mav;
	}

	@RequestMapping(value = "/admin/profile-{username}", method = RequestMethod.GET)
	public ModelAndView updateProfile(@PathVariable("username") String username, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/profile");
		UserDTO model = userService.findOneByUserName(username);
		initMessageResponse(mav, request);
		model.setRoleDTOs(roleService.getRoles());
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}

	@RequestMapping(value = "/admin/profile-password", method = RequestMethod.GET)
	public ModelAndView updatePassword(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/password");
		UserDTO model = userService.findOneByUserName(SecurityUtils.getPrincipal().getUsername());
		initMessageResponse(mav, request);
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}

	private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
		String message = request.getParameter("message");
		if (message != null && StringUtils.isNotEmpty(message)) {
			Map<String, String> messageMap = messageUtil.getMessage(message);
			mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
			mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get(SystemConstant.MESSAGE_RESPONSE));
		}
	}
}
