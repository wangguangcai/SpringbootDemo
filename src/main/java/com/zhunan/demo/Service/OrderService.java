package com.zhunan.demo.Service;

import com.zhunan.demo.Models.Order;
import org.apache.ibatis.annotations.Param;


public interface OrderService {
    public Order getByOrder(@Param("id") Long id);
}
