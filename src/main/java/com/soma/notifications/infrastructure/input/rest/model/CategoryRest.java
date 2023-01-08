package com.soma.notifications.infrastructure.input.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
}
