create table transactions (
id BIGSERIAL primary key not null,
code varchar(100) not null,
describe_transaction varchar(255) not null,
payment varchar(50) not null,
value decimal(15,4) not null,
status varchar(50) not null,
date_registration date not null,
unique(code)
)