DROP TABLE IF EXISTS member;
CREATE TABLE member (
	id INTEGER PRIMARY KEY,
	name TEXT,
	email TEXT,
	introduction TEXT,
	password TEXT,
	is_public BOOLEAN default 1
);

INSERT INTO member (name, email, password, is_public) VALUES ('admin', 'admin@admin.com', 'admin', false);
INSERT INTO member (name, email, password) VALUES ('hara', 'hara@gmail.com', 'hara');
INSERT INTO member (name, email, password) VALUES ('hokari', 'hokari@gmail.com', 'hokari');
INSERT INTO member (name, email, password) VALUES ('morisaki', 'morisaki@gmail.com', 'morisaki');
INSERT INTO member (name, email, password) VALUES ('matsushima', 'matsushima@gmail.com', 'matsushima');