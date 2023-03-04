create table transactions (
id bigserial            primary key not null,
code                    varchar(100) not null,
describe_transaction    varchar(255) not null,
payment                 varchar(50) not null,
value                   decimal(15,4) not null,
status                  varchar(50) not null,
date_registration       date not null,
unique(code)
);

create sequence hibernate_sequence
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 1000000000000
    START 1
    NO CYCLE
    CACHE 1;