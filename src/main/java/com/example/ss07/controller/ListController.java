package com.example.ss07.controller;

import com.example.ss07.model.CartItem;
import com.example.ss07.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class ListController {
    private List<Product> getProductList() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1L, "Laptop Dell", 1200.0, 10, "Laptop hiệu suất cao", "https://via.placeholder.com/150"));
        list.add(new Product(2L, "iPhone 14", 999.0, 15, "Điện thoại cao cấp của Apple", "https://via.placeholder.com/150"));
        list.add(new Product(3L, "Samsung TV", 700.0, 5, "Smart TV 50 inch", "https://via.placeholder.com/150"));
        return list;
    }

    @ModelAttribute("cart")
    public List<CartItem> createCart() {
        return new ArrayList<>();
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView showProductList() {
        ModelAndView mav = new ModelAndView("product_list");
        mav.addObject("products", getProductList());
        return mav;
    }

    @RequestMapping(value = "details", method = RequestMethod.GET)
    public ModelAndView showProductDetails(@RequestParam("id") Long id) {
        Product found = null;
        for (Product p : getProductList()) {
            if (p.getId().equals(id)) {
                found = p;
                break;
            }
        }
        ModelAndView mav = new ModelAndView("product_details");
        mav.addObject("product", found);
        return mav;
    }

    @RequestMapping(value = "/products/add-to-cart", method = RequestMethod.POST)
    public String addToCart(@RequestParam Long id,
                            @RequestParam int quantity,
                            @ModelAttribute("cart") List<CartItem> cart,
                            RedirectAttributes ra) {

        if (quantity <= 0) {
            ra.addFlashAttribute("error", "Số lượng phải lớn hơn 0");
            return "redirect:/products";
        }

        Product selected = getProductList().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (selected == null) {
            ra.addFlashAttribute("error", "Sản phẩm không tồn tại");
            return "redirect:/products";
        }

        for (CartItem item : cart) {
            if (item.getProduct().getId().equals(id)) {
                item.setQuantity(item.getQuantity() + quantity);
                return "redirect:/products";
            }
        }

        cart.add(new CartItem(selected, quantity));
        return "redirect:/products";
    }

    @RequestMapping(value = "cart", method = RequestMethod.GET)
    public ModelAndView showCart(@ModelAttribute("cart") List<CartItem> cart) {
        ModelAndView mav = new ModelAndView("cart");
        double total = cart.stream().mapToDouble(CartItem::getTotalPrice).sum();
        mav.addObject("cartItems", cart);
        mav.addObject("total", total);
        return mav;
    }

    @RequestMapping(value = "increase", method = RequestMethod.GET)
    public String increaseQuantity(@RequestParam Long id,
                                   @ModelAttribute("cart") List<CartItem> cart) {
        for (CartItem item : cart) {
            if (item.getProduct().getId().equals(id)) {
                item.setQuantity(item.getQuantity() + 1);
                break;
            }
        }
        return "redirect:cart";
    }

    @RequestMapping(value = "decrease", method = RequestMethod.GET)
    public String decreaseQuantity(@RequestParam Long id,
                                   @ModelAttribute("cart") List<CartItem> cart) {
        for (CartItem item : cart) {
            if (item.getProduct().getId().equals(id) && item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                break;
            }
        }
        return "redirect:cart";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String removeFromCart(@RequestParam Long id,
                                 @ModelAttribute("cart") List<CartItem> cart) {
        cart.removeIf(item -> item.getProduct().getId().equals(id));
        return "redirect:cart";
    }
}
