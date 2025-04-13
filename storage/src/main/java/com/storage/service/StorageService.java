package com.storage.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storage.entity.Storage;
import com.storage.repository.StorageRepository;

@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepository;

    public void decreaseStock(Long productId, Integer quantity) {
        // 根據商品 ID 查找庫存
        Optional<Storage> storage = storageRepository.findById(productId);
        if (storage.isPresent() && storage.get().getQuantity() >= quantity) {
            Storage existingStorage = storage.get();
            existingStorage.setQuantity(existingStorage.getQuantity() - quantity);
            storageRepository.save(existingStorage);
        } else {
            throw new RuntimeException("Not enough stock");
        }
    }

    public void createStock(Long productId, Integer quantity) {
        Storage storage = new Storage();
        storage.setId(productId);
        storage.setQuantity(quantity);
        storageRepository.save(storage);
    }
}
