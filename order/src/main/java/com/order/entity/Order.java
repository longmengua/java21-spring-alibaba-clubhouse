package com.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long productId = 0L;  // Default value for productId
    private Integer quantity = 0;  // Default value for quantity
    private String status;
    private String createTime;
    private String updateTime;
}
