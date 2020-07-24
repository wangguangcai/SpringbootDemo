package com.zhunan.demo.Service.Impl;

import com.zhunan.demo.Dao.OrderDao;
import com.zhunan.demo.Models.Order;
import com.zhunan.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: OrderServiceImpl
 * @Description:
 * @Author: wangguangcai
 * @Data: 2020/7/23 20:09
 **/
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public Order getByOrder(Long id) {
        return orderDao.getByOrder(id);
    }
}
