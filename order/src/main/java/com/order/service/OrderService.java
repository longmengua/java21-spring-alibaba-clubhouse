package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.client.StorageClient;
import com.order.entity.Orders;
import com.order.repository.OrderRepository;
import com.order.request.StockRequest;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StorageClient storageClient;

    // @Transactional(rollbackFor = Exception.class)
    public void createOrder(Long productId, Integer quantity) {
        // 創建訂單邏輯
        Orders order = new Orders();
        order.setId(productId);
        order.setQuantity(quantity);
        orderRepository.save(order);
    }

    public void decreaseStock(Long productId, Integer quantity) {
        StockRequest request = new StockRequest(productId, quantity);
        storageClient.decreaseStock(request);
    }
}
