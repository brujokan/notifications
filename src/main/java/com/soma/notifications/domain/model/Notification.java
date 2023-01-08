package com.soma.notifications.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {

    private Long id;
    private User user;
    private Product product;
    private Timestamp sendDate;
    private String message;
}
