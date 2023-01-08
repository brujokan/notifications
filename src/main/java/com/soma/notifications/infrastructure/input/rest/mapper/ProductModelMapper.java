package com.soma.notifications.infrastructure.input.rest.mapper;

import com.soma.notifications.domain.mapper.Mapper;
import com.soma.notifications.domain.model.Product;
import com.soma.notifications.infrastructure.input.rest.model.ProductRest;
import org.springframework.stereotype.Component;

@Component
public class ProductModelMapper implements Mapper<Product, ProductRest> {

    @Override
    public Product map(ProductRest input) {
        return Product.builder()
                .id(input.getId())
                .title(input.getTitle())
                .build();
    }
}
