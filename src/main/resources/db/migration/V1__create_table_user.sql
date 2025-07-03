CREATE TABLE user (
     id binary(16) NOT NULL PRIMARY KEY,
     email varchar(255) UNIQUE NOT NULL,
     password varchar(255) NOT NULL,
     role varchar(255) NOT NULL
);