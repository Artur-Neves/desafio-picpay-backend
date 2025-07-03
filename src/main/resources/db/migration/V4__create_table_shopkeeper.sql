CREATE TABLE shopkeeper (
       id binary(16) NOT NULL PRIMARY KEY,
       cnpj varchar(14) NOT NULL UNIQUE,
        FOREIGN KEY (id) REFERENCES people(id)
);