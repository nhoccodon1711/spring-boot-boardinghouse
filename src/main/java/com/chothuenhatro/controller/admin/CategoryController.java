package com.chothuenhatro.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chothuenhatro.dto.ProductCategoryDTO;
import com.chothuenhatro.dto.ProductDTO;
import com.chothuenhatro.service.IProductCategoryService;

@Controller(value = "categoryControllerOfAdmin")
public class CategoryController {

	@Autowired
	private IProductCategoryService productCategoryService;

	@RequestMapping(value = "/admin/category-list", method = RequestMethod.GET)
	public ModelAndView categoryList() {
		ModelAndView mav = new ModelAndView("admin/category/list");
		mav.addObject("catogories", productCategoryService.findAll());
		return mav;
	}

	@RequestMapping(value = "/admin/category-new", method = RequestMethod.GET)
	public ModelAndView showNewCategoryPage() {
		ModelAndView mav = new ModelAndView("admin/category/add");
		mav.addObject("category", new ProductCategoryDTO());
		return mav;
	}

	@RequestMapping(value = "/admin/category-edit-{id}", method = RequestMethod.GET)
	public ModelAndView showEditCategoryPage(@PathVariable(name = "id") Long categoryId) {
		ModelAndView mav = new ModelAndView("admin/category/edit");
		ProductCategoryDTO productCategoryDTO = productCategoryService.findOne(categoryId);
		mav.addObject("category", productCategoryDTO);
		return mav;
	}
}
