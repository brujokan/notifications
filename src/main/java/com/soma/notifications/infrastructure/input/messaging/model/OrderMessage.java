package com.soma.notifications.infrastructure.input.messaging.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderMessage {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("purchase_date")
    private Timestamp purchaseDate;
    @JsonProperty("promotion_id")
    private Long promotionId;
    @JsonProperty("price")
    private Float price;
    @JsonProperty("product_id")
    private String productId;
}
