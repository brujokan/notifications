package com.soma.notifications.domain.rest;

import com.soma.notifications.domain.model.Product;
import com.soma.notifications.domain.model.User;
import reactor.core.publisher.Mono;

public interface NotificationRest {

    public Mono<User> getUserInformation(Long idUser);

    public Mono<Product> getProductInformation(String idProduct);
}
