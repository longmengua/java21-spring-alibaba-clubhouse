package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.client.StorageClient;
import com.order.entity.Order;
import com.order.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StorageClient storageClient;

    // @Transactional(rollbackFor = Exception.class)
    public void createOrder() {
        // 創建訂單邏輯
        Order order = new Order();
        order.setProductId(1L);
        order.setQuantity(2);
        orderRepository.save(order);

        // 調用 storage 服務減少庫存
        storageClient.decreaseStock(order.getProductId(), order.getQuantity());
    }
}
