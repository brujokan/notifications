package com.soma.notifications.application.use_case.notification.builder;

import com.soma.notifications.domain.model.Notification;
import com.soma.notifications.domain.model.Order;
import com.soma.notifications.domain.rest.NotificationRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class NotificationBuilder {

    private NotificationRest notificationRest;

    @Autowired
    public NotificationBuilder(NotificationRest notificationRest) {
        this.notificationRest = notificationRest;
    }

    public Notification build(Order order) {
        Notification notification = Notification.builder()
                .id(order.getId())
                .sendDate(order.getPurchaseDate())
                .build();

        notification.setUser(notificationRest.getUserInformation(order.getUserId()).block());
//        notificationRest.getUserInformation(order.getUserId()).subscribe(notification::setUser);
        notification.setProduct(notificationRest.getProductInformation(order.getProductId()).block());
//        notificationRest.getProductInformation(order.getProductId()).subscribe(notification::setProduct);
        notification.setMessage(getMessage(notification));

        return notification;
    }

    private String getMessage(Notification notification) {
        return String.format(
                "Created new order for user %s with id $v. Ordered product %s.",
                notification.getUser().getName(),
                notification.getUser().getId(),
                notification.getProduct().getTitle()
        );
    }
}

