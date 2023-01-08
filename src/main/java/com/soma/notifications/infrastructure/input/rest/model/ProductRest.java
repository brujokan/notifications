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
public class ProductRest {
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("language")
    private String language;
    @JsonProperty("id_number")
    private String idNumber;
    @JsonProperty("author")
    private AuthorRest author;
    @JsonProperty("category")
    private CategoryRest category;
}
