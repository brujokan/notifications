package com.soma.notifications.infrastructure.input.rest.mapper;

import com.soma.notifications.domain.mapper.Mapper;
import com.soma.notifications.domain.model.User;
import com.soma.notifications.infrastructure.input.rest.model.UserRest;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapper implements Mapper<User, UserRest> {
    @Override
    public User map(UserRest input) {
        return new User().builder()
                .id(input.getId())
                .name(input.getName())
                .email(input.getEmail())
                .build();
    }
}
