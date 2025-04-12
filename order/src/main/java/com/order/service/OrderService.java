package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order.client.StorageClient;
import com.order.entity.Orders;
import com.order.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StorageClient storageClient;

    @Transactional(rollbackFor = Exception.class)
    public void createOrder(Long productId, Integer quantity) {
        // 創建訂單邏輯
        Orders order = new Orders();
        order.setId(productId);
        order.setQuantity(quantity);
        orderRepository.save(order);

        // 調用 storage 服務減少庫存
        storageClient.decreaseStock(order.getId(), order.getQuantity());
    }
}
