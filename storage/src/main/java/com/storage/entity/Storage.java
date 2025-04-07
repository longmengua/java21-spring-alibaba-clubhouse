package com.storage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    private Long productId = 0L;  // Default value for productId
    private Integer quantity = 1;  // Default value for quantity
    private String status;
    private String createTime;
    private String updateTime;
}
