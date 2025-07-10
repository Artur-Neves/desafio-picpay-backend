CREATE TABLE account(
    id binary(16) NOT NULL PRIMARY KEY,
    amount DECIMAL(65, 2) DEFAULT 0.00,
    people_id binary(16) NOT NULL UNIQUE,
    version INTEGER NOT NULL DEFAULT 0,
    FOREIGN KEY(people_id) REFERENCES people(id)
);