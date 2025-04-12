package com.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.entity.Storage;

public interface StorageRepository extends JpaRepository<Storage, Long> {

}