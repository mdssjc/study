CREATE TABLE files (
        owner VARCHAR(20) NOT NULL,
        type VARCHAR(50) NOT NULL,
        name VARCHAR(50) NOT NULL,
        data BLOB,
        PRIMARY KEY(owner, NAME));
