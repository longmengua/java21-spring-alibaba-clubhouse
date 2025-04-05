package com.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.storage.request.StockRequest;
import com.storage.service.StorageService;

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
