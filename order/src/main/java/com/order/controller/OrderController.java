package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.OrderService;

import io.seata.spring.annotation.GlobalTransactional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    @GlobalTransactional(name = "create_order_tx", rollbackFor = Exception.class)
    public String createOrder() {
        orderService.createOrder();
        return "Order Created Successfully";
    }
}
