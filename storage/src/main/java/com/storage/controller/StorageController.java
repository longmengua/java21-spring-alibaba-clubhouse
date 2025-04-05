package com.storage.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/decreaseStock")
    public String decreaseStock(@RequestBody StockRequest request) {
        storageService.decreaseStock(request.getProductId(), request.getQuantity());
        return "Stock Decreased";
    }
}
