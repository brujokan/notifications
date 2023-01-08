package com.soma.notifications.infrastructure.input.messaging.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soma.notifications.application.use_case.notification.NotificationCreateUseCase;
import com.soma.notifications.domain.mapper.Mapper;
import com.soma.notifications.domain.model.Order;
import com.soma.notifications.infrastructure.input.messaging.model.OrderMessage;
import com.soma.notifications.infrastructure.output.persistence.entity.NotificationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreateConsumer {

    private NotificationCreateUseCase notificationCreateUseCase;
    private ObjectMapper objectMapper;
    private Mapper<Order, OrderMessage> orderMapper;

    @Autowired
    public OrderCreateConsumer(
            NotificationCreateUseCase notificationCreateUseCase,
            ObjectMapper objectMapper,
            Mapper<Order, OrderMessage> orderMapper
    ) {
        this.notificationCreateUseCase = notificationCreateUseCase;
        this.objectMapper = objectMapper;
        this.orderMapper = orderMapper;
    }

    @KafkaListener(topics = "${kafka.topic.create.order}", groupId = "2")
    public void consume(String message) {
        try {
            OrderMessage orderMessage = objectMapper.readValue(message, OrderMessage.class);
            Order order = orderMapper.map(orderMessage);

            notificationCreateUseCase.create(
                    order
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
