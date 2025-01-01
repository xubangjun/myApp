-- Create schema if it doesn't exist
CREATE SCHEMA IF NOT EXISTS my_schema;

-- Create table if it doesn't exist
CREATE TABLE IF NOT EXISTS my_schema.users (
                                               id BIGSERIAL PRIMARY KEY,
                                               name VARCHAR(255) NOT NULL,
                                               email VARCHAR(255) NOT NULL UNIQUE
);