package com.zhunan.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    @GetMapping("hello")
    public String index(ModelMap modelMap){
        String username="ceshi";
        String userpasd="123";
        modelMap.addAttribute("username",username);
        modelMap.addAttribute("userpasd",userpasd);
        return "index";
    }
}
