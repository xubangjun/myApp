-- Create schema if it doesn't exist
CREATE SCHEMA IF NOT EXISTS my_schema;

-- Create table if it doesn't exist
CREATE TABLE IF NOT EXISTS my_schema.users (
                                               id BIGSERIAL PRIMARY KEY,
                                               name VARCHAR(255) NOT NULL,
                                               email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS groups (
                                      id BIGINT PRIMARY KEY, -- Primary key
                                      name VARCHAR(255) NOT NULL UNIQUE     -- Unique group name
);

CREATE TABLE IF NOT EXISTS  user_groups (
                                            user_id BIGINT NOT NULL,  -- Foreign key referencing users table
                                            group_id BIGINT NOT NULL, -- Foreign key referencing groups table
                                            PRIMARY KEY (user_id, group_id), -- Composite primary key
                                            FOREIGN KEY (user_id) REFERENCES my_schema.users(id) ON DELETE CASCADE, -- Maintain referential integrity
                                            FOREIGN KEY (group_id) REFERENCES groups(id) ON DELETE CASCADE
);

ALTER TABLE my_schema.users
    ADD COLUMN data jsonb;