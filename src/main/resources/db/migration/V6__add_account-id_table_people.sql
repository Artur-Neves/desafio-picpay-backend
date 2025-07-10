ALTER TABLE people ADD account_id binary(16) UNIQUE;
ALTER TABLE people ADD FOREIGN KEY(account_id) REFERENCES account(id);
