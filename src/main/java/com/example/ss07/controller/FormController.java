package com.example.ss07.controller;

import com.example.ss07.model.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Controller
public class FormController {
    private final List<Feedback> feedbackList = new ArrayList<>();

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String showForm() {
        return "form";
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String submitForm(
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            @RequestParam("content") String content,
            HttpServletRequest request
    ) {
        List<String> errors = new ArrayList<>();

        if (name == null || name.trim().isEmpty()) {
            errors.add("Họ và tên là bắt buộc.");
        }
        if (content == null || content.trim().isEmpty()) {
            errors.add("Nội dung góp ý là bắt buộc.");
        }
        if (phone != null && !Pattern.matches("\\d{9,11}", phone)) {
            errors.add("Số điện thoại không hợp lệ. Chỉ chứa số và từ 9-11 chữ số.");
        }

        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            request.setAttribute("name", name);
            request.setAttribute("phone", phone);
            request.setAttribute("address", address);
            request.setAttribute("content", content);
            return "form";
        }

        Feedback fb = new Feedback(name, phone, address, content);
        feedbackList.add(fb);

        request.setAttribute("feedback", fb);
        return "result";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(HttpServletRequest request) {
        request.setAttribute("feedbackList", feedbackList);
        return "list";
    }
}
