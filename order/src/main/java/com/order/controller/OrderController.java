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

    /**
     * 如果想測試 Seata 的分佈式事務，請取消 @GlobalTransactional 註解，可以看 table order 內數據是否有異動
     * 如果註釋@GlobalTransactional，這樣會將整個方法標記為全局事務，當方法內的任何一個操作失敗時，所有操作都會回滾
    */
    @PostMapping("/createOrder")
    // @GlobalTransactional(name = "create_order_tx", rollbackFor = Exception.class)
    public String createOrder(@RequestBody StockRequest request) {
        orderService.createOrder(request.getProductId(), request.getQuantity());
        orderService.decreaseStock(request.getProductId(), request.getQuantity());
        return "Order Created Successfully";
    }
}
