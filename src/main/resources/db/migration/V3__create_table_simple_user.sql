CREATE TABLE simple_user (
    id binary(16) NOT NULL PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES people(id)
);
