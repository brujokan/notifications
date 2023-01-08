package com.soma.notifications.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    private Long id;
    private Long userId;
    private Timestamp purchaseDate;
    private Long promotionId;
    private Float price;
    private String productId;
}
