package com.chothuenhatro.controller.web;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.chothuenhatro.constant.SystemConstant;
import com.chothuenhatro.dto.ProductDTO;
import com.chothuenhatro.dto.UserDTO;
import com.chothuenhatro.service.IProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	private IProductService productService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(@ModelAttribute(SystemConstant.MODEL) ProductDTO productDTO,
								 @RequestParam(required = false) Map<String, String> params) {
		ModelAndView mav = new ModelAndView("web/product/list");
		mav.addObject(SystemConstant.MODEL, productDTO);

		List<ProductDTO> products = new ArrayList<>();

		if (CollectionUtils.isEmpty(params)) {
			products = productService.findAll();
		} else {
			products = productService.findByCondition(params);
		}

		mav.addObject("products", products);
		mav.addObject("mapDistricts", productService.getDistrict());
		mav.addObject("mapCategories", productService.getProductCategory());
		mav.addObject("mapAres", productService.getAreas());
		mav.addObject("mapPrices", productService.getPrices());

		return mav;
	}

//	@RequestMapping(value = "/product-list", method = RequestMethod.GET)
//	public ModelAndView roomList(@ModelAttribute("modelSearch") ProductDTO productDTO,
//								 @RequestParam(required = false) Map<String, String> params) {
//		ModelAndView mav = new ModelAndView("web/product/list");
//
//		List<ProductDTO> products = new ArrayList<>();
//
//		if (CollectionUtils.isEmpty(params)) {
//			products = productService.findAll();
//		} else {
//			products = productService.findByCondition(params);
//		}
//
//		mav.addObject("products", products);
//		mav.addObject("modelSearch", productDTO);
//		mav.addObject("mapDistricts", productService.getDistrict());
//		mav.addObject("mapCategories", productService.getProductCategory());
//		mav.addObject("mapAres", productService.getAreas());
//		mav.addObject("mapPrices", productService.getPrices());
//
//		return mav;
//	}

	@RequestMapping(value = "/product-detail-{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable(name = "id") Long productId) {
		ModelAndView mav = new ModelAndView("web/product/detail");
		ProductDTO product = productService.findOne(productId);
		mav.addObject("product", product);
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView("signup");
		mav.addObject("user", new UserDTO());
		return mav;
	}

	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/login?accessDenied");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
}
