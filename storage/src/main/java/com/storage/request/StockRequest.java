package com.storage.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockRequest {
    @Getter
    @Setter
    private Long productId;

    @Getter
    @Setter
    @NonNull
    private Integer quantity;
}
