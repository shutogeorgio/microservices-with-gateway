CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE users(
    id uuid PRIMARY KEY,
    first_name VARCHAR (100) NOT NULL ,
    last_name VARCHAR (100) NOT NULL ,
    email VARCHAR (100) NOT NULL ,
    country VARCHAR (100) NOT NULL ,
    state VARCHAR (100) NOT NULL ,
    city VARCHAR (100) NOT NULL ,
    zip VARCHAR (100) NOT NULL
);