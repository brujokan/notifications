package com.soma.notifications.infrastructure.output.persistence.repository;

import com.soma.notifications.domain.mapper.Mapper;
import com.soma.notifications.domain.model.Notification;
import com.soma.notifications.domain.repository.NotificationRepository;
import com.soma.notifications.infrastructure.output.persistence.entity.NotificationEntity;
import com.soma.notifications.infrastructure.output.persistence.jpa.NotificationJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {

    private final NotificationJPA notificationJPA;

    private final Mapper<NotificationEntity, Notification> entityMapper;

    private final Mapper<Notification, NotificationEntity> modelMapper;

    @Autowired
    public NotificationRepositoryImpl(
            NotificationJPA notificationJPA,
            Mapper<NotificationEntity, Notification> entityMapper,
            Mapper<Notification, NotificationEntity> modelMapper
    ) {
        this.notificationJPA = notificationJPA;
        this.entityMapper = entityMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public Mono<Notification> save(Notification notification) {
        return Mono.just(
                modelMapper.map(
                        notificationJPA.save(
                                entityMapper.map(notification)
                        ).block()
                )
        );
    }
}
