package com.zhunan.demo.Controllers;

import com.zhunan.demo.Models.Order;
import com.zhunan.demo.Models.jsonData;
import com.zhunan.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: OrderController
 * @Description:
 * @Author: wangguangcai
 * @Data: 2020/7/23 20:07
 **/
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping(value="/getOrder/{id}")
    public jsonData getBYOrderId(@RequestParam("id")Long id){

        Order order=orderService.getByOrder(id);
        if (order != null) {
            return new jsonData(200,"查询成功",order);
        }else{
            return new jsonData(500,"查询失败",null);
        }
    }
}
