package com.example.ss07.controller;

import com.example.ss07.model.Category;
import com.example.ss07.model.Product2;
import com.example.ss07.repository.ProductRepository;
import com.example.ss07.repository.ProductRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/products2")
public class ProductController2 {
    private ProductRepository productRepo = new ProductRepositoryImpl();

    private List<Category> categories = Arrays.asList(
            new Category(1, "Điện thoại"),
            new Category(2, "Máy tính"),
            new Category(3, "Phụ kiện")
    );

    @ModelAttribute("categories")
    public List<Category> populateCategories() {
        return categories;
    }

    @GetMapping
    public String listProducts(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        List<Product2> products = productRepo.search(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        return "productList";
    }

    @GetMapping("/{id}")
    public String showProductDetails(@PathVariable("id") int id, Model model) {
        Product2 product = productRepo.findById(id);
        if (product == null) return "redirect:/products2";
        model.addAttribute("product", product);
        return "productDetails";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product2());
        return "addProduct";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product2 product, RedirectAttributes redirectAttributes) {
        productRepo.save(product);
        redirectAttributes.addFlashAttribute("message", "Thêm sản phẩm thành công!");
        return "redirect:/products2";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product2 product = productRepo.findById(id);
        if (product == null) return "redirect:/products2";
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product2 product, RedirectAttributes redirectAttributes) {
        productRepo.update(product);
        redirectAttributes.addFlashAttribute("message", "Cập nhật sản phẩm thành công!");
        return "redirect:/products2";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        productRepo.delete(id);
        redirectAttributes.addFlashAttribute("message", "Xóa sản phẩm thành công!");
        return "redirect:/products2";
    }
}