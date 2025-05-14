package com.example.ss07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @RequestMapping(value = "home", method = RequestMethod.GET)
    @ResponseBody
    public String home() {
        return "Welcome to Spring MVC!";
    }

    @RequestMapping(value = "greet", method = RequestMethod.GET)
    @ResponseBody
    public String greet(@RequestParam String name) {
        return "Hello " + name + "!";
    }
}
