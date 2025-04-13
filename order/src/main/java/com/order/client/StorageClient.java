package com.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.order.request.StockRequest;

@FeignClient(name = "storageClient", url = "http://localhost:8082")
public interface StorageClient {
    @PostMapping("/decreaseStock")
    void decreaseStock(StockRequest request);  
} 
