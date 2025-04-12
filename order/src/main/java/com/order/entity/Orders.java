package com.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    private Long id;
    private Integer quantity = 0;  // Default value for quantity
    private String status;
    private String createTime;
    private String updateTime;
}
