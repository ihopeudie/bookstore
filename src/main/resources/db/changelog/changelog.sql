-- liquibase formatted sql

-- changeset bat:init-table splitStatements:true endDelimiter:;
create table if not exists bookstore.book
(
    id    int auto_increment primary key,
    title varchar(45) null,
    constraint idbook_UNIQUE unique (id)
);

-- changeset bat: add-few-books splitStatements:true endDelimiter:;

insert into book (title)
values ('book1');
insert into book (title)
values ('book2');
insert into book (title)
values ('book3');
insert into book (title)
values ('book4');
insert into book (title)
values ('book5');

-- changeset bat: init-author-table splitStatements:true endDelimiter:;
create table if not exists bookstore.author
(
    id   int auto_increment primary key,
    name varchar(45) null,
    constraint idAuthor_UNIQUE unique (id)
);

-- changeset bat: add-few-authors splitStatements:true endDelimiter:;

insert into author (name)
values ('author1');
insert into author (name)
values ('author2');
insert into author (name)
values ('author3');
insert into author (name)
values ('author4');
