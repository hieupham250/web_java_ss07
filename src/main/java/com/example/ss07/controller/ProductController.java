package com.example.ss07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @RequestMapping("/{category}")
    public ModelAndView filterProductsByMatrixVariable(
            @PathVariable String category,
            @MatrixVariable(value = "color", required = false) String color,
            @MatrixVariable(value = "size", required = false) String size) {

        ModelAndView mav = new ModelAndView("filter_result");

        List<String> filteredProducts = new ArrayList<>();

        if ("shoes".equals(category)) {
            if ("red".equals(color)) {
                filteredProducts.add("Giày đỏ thể thao");
            } else if ("black".equals(color)) {
                filteredProducts.add("Giày đen công sở");
            } else {
                filteredProducts.add("Giày mặc định");
            }

            if ("42".equals(size)) {
                filteredProducts.add("Size 42");
            } else if (size != null) {
                filteredProducts.add("Size khác: " + size);
            }
        } else {
            filteredProducts.add("Danh mục khác: " + category);
        }

        mav.addObject("category", category);
        mav.addObject("color", color);
        mav.addObject("size", size);
        mav.addObject("products", filteredProducts);
        return mav;
    }
}

