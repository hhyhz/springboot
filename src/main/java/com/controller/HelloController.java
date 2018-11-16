package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping(value = {"", "/hello"})
    public String hello(Model model) {
        String name = "World";
        model.addAttribute("name", name);
        return "hello";
    }

}