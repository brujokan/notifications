CREATE SEQUENCE "notification".NOTIFICATION_SEQUENCE
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE "notification".notification (
    id INT8 not null,
    id_user INT8 not null,
    send_date TIMESTAMP not null,
    email varchar(255) not null,
    id_product varchar(255) not null,
    message VARCHAR(2000),
    primary key (id)
);
