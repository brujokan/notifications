package com.soma.notifications.domain.repository;

import com.soma.notifications.domain.model.Notification;
import reactor.core.publisher.Mono;

public interface NotificationRepository {

    public Mono<Notification> save(Notification notification);
}
