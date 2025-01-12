CREATE TABLE IF NOT EXISTS groups (
                                      id uuid PRIMARY KEY, -- Primary key
                                      name VARCHAR(255) NOT NULL UNIQUE     -- Unique group name
);

CREATE TABLE IF NOT EXISTS  user_groups (
                                            user_id uuid NOT NULL,  -- Foreign key referencing users table
                                            group_id uuid NOT NULL, -- Foreign key referencing groups table
                                            PRIMARY KEY (user_id, group_id), -- Composite primary key
                                            FOREIGN KEY (user_id) REFERENCES my_schema.users(id) ON DELETE CASCADE, -- Maintain referential integrity
                                            FOREIGN KEY (group_id) REFERENCES groups(id) ON DELETE CASCADE
);