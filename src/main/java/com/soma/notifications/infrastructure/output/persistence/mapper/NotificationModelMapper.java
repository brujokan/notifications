package com.soma.notifications.infrastructure.output.persistence.mapper;

import com.soma.notifications.domain.mapper.Mapper;
import com.soma.notifications.domain.model.Notification;
import com.soma.notifications.domain.model.Product;
import com.soma.notifications.domain.model.User;
import com.soma.notifications.infrastructure.output.persistence.entity.NotificationEntity;
import org.springframework.stereotype.Component;

@Component
public class NotificationModelMapper implements Mapper<Notification, NotificationEntity> {

    @Override
    public Notification map(NotificationEntity input) {
        return Notification.builder()
                .id(input.getId())
                .user(User.builder().id(input.getIdUser()).email(input.getEmail()).build())
                .product(Product.builder().id(input.getIdProduct()).build())
                .sendDate(input.getSendDate())
                .message(input.getMessage())
                .build();
    }
}
