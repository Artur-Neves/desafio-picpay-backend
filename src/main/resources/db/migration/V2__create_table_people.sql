CREATE TABLE people (
    id binary(16) NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    cpf varchar(14) NOT NULL UNIQUE,
    user_id binary(16) NOT NULL UNIQUE,
    FOREIGN KEY (user_id) REFERENCES user(id)
);