package com.soma.notifications.infrastructure.output.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Table(name = "notification", schema = "notification")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationEntity implements Persistable {
    @Id
    private Long id;

    @Column("id_user")
    private Long idUser;

    @Column("send_date")
    private Timestamp sendDate;

    private String email;

    @Column("id_product")
    private String idProduct;

    private String message;

    @Override
    public boolean isNew() {
        return true;
    }
}
