package com.storage.repository;

import org.springframework.stereotype.Component;

import com.storage.entity.Storage;

@Component
public class StorageRepository {
    public Storage findByProductId(Long productId) {
        Storage storage = new Storage();
        return storage;
    }

    public boolean save(Storage storage) {
        // Simulate saving the storage entity
        return true;
    }
}
