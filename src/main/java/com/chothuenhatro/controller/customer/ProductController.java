package com.chothuenhatro.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.chothuenhatro.constant.SystemConstant;
import com.chothuenhatro.dto.ProductDTO;
import com.chothuenhatro.security.utils.SecurityUtils;
import com.chothuenhatro.service.IProductService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller(value = "productControllerOfCustomer")
public class ProductController {
    @Autowired
    private IProductService productService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/customer-product-list", method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute(SystemConstant.MODEL) ProductDTO productDTO,
                                     @RequestParam(required = false) Map<String, String> params) {
        ModelAndView mav = new ModelAndView("customer/list");
        mav.addObject(SystemConstant.MODEL, productDTO);

        List<ProductDTO> products = new ArrayList<>();

        mav.addObject("products", productService.findByUser(SecurityUtils.getPrincipal().getId()));
        return mav;
    }

    @RequestMapping(value = "/customer-product-new", method = RequestMethod.GET)
    public ModelAndView showNewBuildingPage() {
        ModelAndView mav = new ModelAndView("customer/add");
        mav.addObject("model", new ProductDTO());
        mav.addObject("mapDistricts", productService.getDistrict());
        mav.addObject("mapCategories", productService.getProductCategory());
        return mav;
    }

    @RequestMapping(value = "/customer-product-{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable(name = "id") Long productId) {
        ModelAndView mav = new ModelAndView("customer/detail");
        ProductDTO product = productService.findOne(productId);
        mav.addObject("product", product);
        return mav;
    }

    @RequestMapping(value = "/customer-product-edit-{id}", method = RequestMethod.GET)
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long productId) {
        ModelAndView mav = new ModelAndView("customer/edit");
        ProductDTO productDTO = productService.findOne(productId);
        mav.addObject("product", productDTO);
        mav.addObject("mapDistricts", productService.getDistrict());
        mav.addObject("mapCategories", productService.getProductCategory());
        return mav;
    }
}
