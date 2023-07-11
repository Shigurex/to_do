DROP TABLE IF EXISTS member;
CREATE TABLE member (
	id INTEGER PRIMARY KEY,
	name TEXT,
	email TEXT,
	password TEXT
);

INSERT INTO member (name, email, password) VALUES ('admin', 'admin@admin.com', 'admin');
INSERT INTO member (name, email, password) VALUES ('kohei', 'kohmatsu@gmail.com', 'kohmatsu');