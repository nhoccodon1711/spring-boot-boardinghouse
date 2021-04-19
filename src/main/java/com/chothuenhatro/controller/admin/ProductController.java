package com.chothuenhatro.controller.admin;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.chothuenhatro.constant.SystemConstant;
import com.chothuenhatro.dto.ProductDTO;
import com.chothuenhatro.service.IProductService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller(value = "productControllerOfAdmin")
public class ProductController {
    @Autowired
    private IProductService productService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/admin/product-list", method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute(SystemConstant.MODEL) ProductDTO productDTO,
                                     @RequestParam(required = false) Map<String, String> params) {
        ModelAndView mav = new ModelAndView("admin/product/list");
        mav.addObject(SystemConstant.MODEL, productDTO);

        List<ProductDTO> products = new ArrayList<>();

        if (CollectionUtils.isEmpty(params)) {
            // get all buildings when initial the first time
            products = productService.findAll();
        } else {
            // get buildings that satisfy the searching condition
            products = productService.findByCondition(params);
        }
        mav.addObject("products", products);
        mav.addObject("mapDistricts", productService.getDistrict());
        mav.addObject("mapCategories", productService.getProductCategory());
        mav.addObject("mapAres", productService.getAreas());
        mav.addObject("mapPrices", productService.getPrices());
        return mav;
    }

    @RequestMapping(value = "/admin/product-new", method = RequestMethod.GET)
    public ModelAndView showNewBuildingPage() {
        ModelAndView mav = new ModelAndView("admin/product/add");
        mav.addObject("product", new ProductDTO());
        mav.addObject("mapDistricts", productService.getDistrict());
        mav.addObject("mapCategories", productService.getProductCategory());
        return mav;
    }

    @RequestMapping(value = "/admin/product-edit-{id}", method = RequestMethod.GET)
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long productId) {
        ModelAndView mav = new ModelAndView("admin/product/edit");
        ProductDTO productDTO = productService.findOne(productId);
        mav.addObject("product", productDTO);
        mav.addObject("mapDistricts", productService.getDistrict());
        mav.addObject("mapCategories", productService.getProductCategory());
        return mav;
    }
}
