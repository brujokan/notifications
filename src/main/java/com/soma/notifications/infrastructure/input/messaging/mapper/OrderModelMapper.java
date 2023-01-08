package com.soma.notifications.infrastructure.input.messaging.mapper;

import com.soma.notifications.domain.mapper.Mapper;
import com.soma.notifications.domain.model.Order;
import com.soma.notifications.infrastructure.input.messaging.model.OrderMessage;
import org.springframework.stereotype.Component;

@Component
public class OrderModelMapper implements Mapper<Order, OrderMessage> {

    @Override
    public Order map(OrderMessage input) {
        return Order.builder()
                .id(input.getId())
                .price(input.getPrice())
                .productId(input.getProductId())
                .promotionId(input.getPromotionId())
                .purchaseDate(input.getPurchaseDate())
                .userId(input.getUserId())
                .build();
    }
}
