-- liquibase formatted sql

-- changeset bat:init-author-table splitStatements:true endDelimiter:;
CREATE TABLE if not exists bookstore.author
(
    `id`   int(11) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(255),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- changeset bat:init-book-table splitStatements:true endDelimiter:;
CREATE TABLE if not exists `book`
(
    `id`        int(11) unsigned NOT NULL AUTO_INCREMENT,
    `title`     varchar(255),
    `author_id` int(11) unsigned NOT NULL,
    PRIMARY KEY (`id`),
    KEY `author_id` (`author_id`),
    CONSTRAINT `book_author_fk_1` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

delete from book;
delete from author;

-- changeset bat:mock-data splitStatements:true endDelimiter:;

insert into `author` (name) values ('author1');
set @authorId = LAST_INSERT_ID();
insert into `book` (title, author_id) values ('book1', @authorId);
insert into `book` (title, author_id) values ('book2', @authorId);
insert into `book` (title, author_id) values ('book3', @authorId);

insert into `author` (name) values ('author2');
set @authorId = LAST_INSERT_ID();
insert into `book` (title, author_id) values ('book4', @authorId);
insert into `book` (title, author_id) values ('book6', @authorId);
insert into `book` (title, author_id) values ('book5', @authorId);

insert into `author` (name) values ('author3');
set @authorId = LAST_INSERT_ID();
insert into `book` (title, author_id) values ('book7', @authorId);

insert into `author` (name) values ('author4');

