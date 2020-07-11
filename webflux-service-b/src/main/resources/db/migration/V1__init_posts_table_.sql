CREATE TABLE IF NOT EXISTS post (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    content VARCHAR(255),
    author_id uuid,
    category_id SERIAL,
    created_at timestamp,
    updated_at timestamp
);