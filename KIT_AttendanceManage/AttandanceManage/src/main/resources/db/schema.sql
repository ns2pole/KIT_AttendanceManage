-- schema.sql
CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    deadlinedate DATE NOT NULL,
    planminute INTEGER NOT NULL,
    actualminute INTEGER NOT NULL,
    statuscode INTEGER NOT NULL
);
