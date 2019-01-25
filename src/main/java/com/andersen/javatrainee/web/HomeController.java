package com.andersen.javatrainee.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "homepage"})
    public String homePage() {
        return "home";
    }
}