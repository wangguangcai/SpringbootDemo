package com.zhunan.demo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//测试HTTP协议post、delete、put请求
@RestController
public class OtherHttpController {

    private Map<String,Object> params=new HashMap<>();


    @RequestMapping(value = "/api2/v1/account")
    public Object account(){
     System.out.println("Controller------->account");
     params.put("money","1000");
     return  params;
    }

}
