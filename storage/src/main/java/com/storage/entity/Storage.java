package com.storage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    private Long productId;
    private Integer quantity;
    private String status;
    private String createTime;
    private String updateTime;
}
