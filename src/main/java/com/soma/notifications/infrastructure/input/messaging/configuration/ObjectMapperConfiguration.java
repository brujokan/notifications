package com.soma.notifications.infrastructure.input.messaging.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfiguration {

    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();
    }
}
