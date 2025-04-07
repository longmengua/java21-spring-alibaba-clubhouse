package com.order.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.order.request.StockRequest;

@Component
public class StorageClient {

    private final String STORAGE_SERVICE_URL = "http://localhost:8082"; // storage-service 地址

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean decreaseStock(Long productId, Integer quantity) {
        try {
            restTemplate.postForObject(STORAGE_SERVICE_URL + "/decreaseStock", new StockRequest(productId, quantity), String.class);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return false;
        }
        return true;
    }
}
