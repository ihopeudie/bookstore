USE liquibase;

create table book(
    id long not null auto_increment primary key,
    title varchar(255)
);
