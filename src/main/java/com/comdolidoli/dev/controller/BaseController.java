package com.comdolidoli.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String getIndex(String data,ModelMap modelMap){
        modelMap.addAttribute("data","welcome to comdolidol-i web site " + data);
        return "index";
    }

    @PostMapping("/")
    public String postIndex(String data,ModelMap modelMap){
        modelMap.addAttribute("data","welcome to comdolidol-i web site " + data);
        return "index";
    }
}
