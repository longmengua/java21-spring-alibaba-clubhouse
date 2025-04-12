package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.request.StockRequest;
import com.order.service.OrderService;

import io.seata.spring.annotation.GlobalTransactional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    @GlobalTransactional(name = "create_order_tx", rollbackFor = Exception.class)
    public String createOrder(@RequestBody StockRequest request) {
        orderService.createOrder(request.getProductId(), request.getQuantity());
        return "Order Created Successfully";
    }
}
