CREATE TABLE feedback (
    id integer primary key AUTOINCREMENT,
    iduser integer not null,
    post_id INTEGER not null,
    rating integer not null,
    comment text
);