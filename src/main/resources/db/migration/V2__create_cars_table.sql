-- Create table if it doesn't exist
CREATE TABLE IF NOT EXISTS my_schema.cars (
                                              id BIGSERIAL PRIMARY KEY,
                                              name VARCHAR(255) NOT NULL,
                                              model VARCHAR(255) NOT NULL,
                                              year INTEGER NOT NULL,
                                              user_id BIGINT,
                                              CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES my_schema.users (id) ON DELETE SET NULL
);