package com.soma.notifications.infrastructure.output.persistence.jpa;

import com.soma.notifications.infrastructure.output.persistence.entity.NotificationEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface NotificationJPA extends ReactiveCrudRepository<NotificationEntity, Long> {
}
