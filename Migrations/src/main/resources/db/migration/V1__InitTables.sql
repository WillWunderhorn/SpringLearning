CREATE TABLE company (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    date DATE NOT NULL,
    unique (name)
);