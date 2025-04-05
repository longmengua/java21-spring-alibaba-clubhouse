package com.order.repository;

import org.springframework.stereotype.Component;

import com.order.entity.Order;

@Component
public class OrderRepository {
    public void save(Order order) {
        // 模擬保存訂單到數據庫
        // 在這裡可以使用 JPA 或其他數據庫操作來保存訂單
        System.out.println(order);
    }
}
