DROP TABLE IF EXISTS member;
CREATE TABLE member (
	id INTEGER PRIMARY KEY,
	name TEXT,
	email TEXT,
	password TEXT,
	is_public BOOLEAN
);

INSERT INTO member (name, email, password, is_public) VALUES ('admin', 'admin@admin.com', 'admin', false);
INSERT INTO member (name, email, password, is_public) VALUES ('hara', 'hara@gmail.com', 'hara', true);
INSERT INTO member (name, email, password, is_public) VALUES ('hokari', 'hokari@gmail.com', 'hokari', true);
INSERT INTO member (name, email, password, is_public) VALUES ('morisaki', 'morisaki@gmail.com', 'morisaki', true);
INSERT INTO member (name, email, password, is_public) VALUES ('matsushima', 'matsushima@gmail.com', 'matsushima', true);