-- Create schema if it doesn't exist
CREATE SCHEMA IF NOT EXISTS my_schema;

-- Create table if it doesn't exist
CREATE TABLE IF NOT EXISTS my_schema.users (
                                               id uuid PRIMARY KEY,
                                               name VARCHAR(255) NOT NULL,
                                               email VARCHAR(255) NOT NULL UNIQUE,
                                               data jsonb
);
-- Create table if it doesn't exist
CREATE TABLE IF NOT EXISTS my_schema.cars (
                                              id uuid PRIMARY KEY,
                                              name VARCHAR(255) NOT NULL,
                                              model VARCHAR(255) NOT NULL,
                                              year INTEGER NOT NULL,
                                              user_id uuid,
                                              CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES my_schema.users (id) ON DELETE SET NULL
);
