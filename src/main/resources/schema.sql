CREATE SCHEMA my_schema;
CREATE TABLE my_schema.users (
                                 id BIGSERIAL PRIMARY KEY,
                                 name VARCHAR(255) NOT NULL,
                                 email VARCHAR(255) NOT NULL UNIQUE
);