package com.zhunan.demo.Dao;

import com.zhunan.demo.Models.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {
        public Order getByOrder(Long id);
}
