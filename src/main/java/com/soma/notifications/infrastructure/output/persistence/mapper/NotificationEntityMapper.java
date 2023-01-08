package com.soma.notifications.infrastructure.output.persistence.mapper;

import com.soma.notifications.domain.mapper.Mapper;
import com.soma.notifications.domain.model.Notification;
import com.soma.notifications.infrastructure.output.persistence.entity.NotificationEntity;
import org.springframework.stereotype.Component;

@Component
public class NotificationEntityMapper implements Mapper<NotificationEntity, Notification> {

    @Override
    public NotificationEntity map(Notification input) {
        return NotificationEntity.builder()
                .id(input.getId())
                .idUser(input.getUser().getId())
                .email(input.getUser().getEmail())
                .idProduct(input.getProduct().getId())
                .message(input.getMessage())
                .sendDate(input.getSendDate())
                .build();
    }
}
