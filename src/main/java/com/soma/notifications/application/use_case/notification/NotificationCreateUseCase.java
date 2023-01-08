package com.soma.notifications.application.use_case.notification;

import com.soma.notifications.application.use_case.notification.builder.NotificationBuilder;
import com.soma.notifications.domain.model.Notification;
import com.soma.notifications.domain.model.Order;
import com.soma.notifications.domain.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationCreateUseCase {

    private NotificationRepository notificationRepository;
    private NotificationBuilder notificationBuilder;

    @Autowired
    public NotificationCreateUseCase(
            NotificationRepository notificationRepository,
            NotificationBuilder notificationBuilder
    ) {
        this.notificationRepository = notificationRepository;
        this.notificationBuilder = notificationBuilder;
    }

    public void create(Order order) {
        Notification notification = notificationBuilder.build(order);

        notificationRepository.save(notification);
    }
}
