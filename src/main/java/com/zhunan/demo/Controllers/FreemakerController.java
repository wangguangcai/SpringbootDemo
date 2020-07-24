package com.zhunan.demo.Controllers;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freemaker")
public class FreemakerController {
    @GetMapping("hello")
    public String index(ModelMap modelMap){
        String name="admin";
        String password="zhunan";
        modelMap.addAttribute("name",name);
        modelMap.addAttribute("password",password);
        return "fm/index";
    }
}
