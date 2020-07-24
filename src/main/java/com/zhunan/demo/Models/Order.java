package com.zhunan.demo.Models;

import java.io.Serializable;

/**
 * @ClassName: order
 * @Description:
 * @Author: wangguangcai
 * @Data: 2020/7/23 20:00
 **/

public class Order implements Serializable {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
