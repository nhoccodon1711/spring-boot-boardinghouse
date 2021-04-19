package com.chothuenhatro.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chothuenhatro.constant.SystemConstant;
import com.chothuenhatro.dto.ProductDTO;
import com.chothuenhatro.service.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView homePage(@ModelAttribute(SystemConstant.MODEL) ProductDTO productDTO,
								 @RequestParam(required = false) Map<String, String> params) {
		ModelAndView mav = new ModelAndView("/admin/product/list");
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
}
