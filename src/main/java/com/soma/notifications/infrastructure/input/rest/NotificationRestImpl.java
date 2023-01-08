package com.soma.notifications.infrastructure.input.rest;

import com.soma.notifications.domain.mapper.Mapper;
import com.soma.notifications.domain.model.Product;
import com.soma.notifications.domain.model.User;
import com.soma.notifications.domain.rest.NotificationRest;
import com.soma.notifications.infrastructure.input.rest.model.ProductRest;
import com.soma.notifications.infrastructure.input.rest.model.UserRest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class NotificationRestImpl implements NotificationRest {

    private static final String USER_URL = "user/";
    private static final String PRODUCT_URL = "product/";
    private Mapper<User, UserRest> userMapper;
    private Mapper<Product, ProductRest> productMapper;

    @Autowired
    public NotificationRestImpl(
            Mapper<User, UserRest> userMapper,
            Mapper<Product, ProductRest> productMapper
    ) {
        this.userMapper = userMapper;
        this.productMapper = productMapper;
    }

    @Override
    public Mono<User> getUserInformation(Long idUser) {
       return WebClient.create()
                .get()
                .uri("http://localhost:8080/users/" + USER_URL + idUser)
                .retrieve()
                .bodyToMono(UserRest.class)
                .flatMap(u -> {
                    return Mono.just(userMapper.map(u));
                });
    }

    @Override
    public Mono<Product> getProductInformation(String idProduct) {
        return WebClient.create()
                .get()
                .uri("http://localhost:8082/products/" + PRODUCT_URL + idProduct)
                .retrieve()
                .bodyToMono(ProductRest.class)
                .flatMap(p -> {
                    return Mono.just(productMapper.map(p));
                });
    }
}
