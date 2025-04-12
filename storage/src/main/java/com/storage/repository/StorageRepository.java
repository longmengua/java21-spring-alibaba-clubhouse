package com.storage.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.storage.entity.Storage;

@Component
public class StorageRepository {

    private Storage storage;

    public Storage findByProductId(Long productId) {
        if (storage == null) {
            storage = new Storage();
            storage.setProductId(productId);
            storage.setQuantity(1); // Default quantity for demonstration
            storage.setStatus("Available");
        }
        return storage;
    }

    public boolean save(Storage storage) {
        // Simulate saving the storage entity
        return true;
    }
}
