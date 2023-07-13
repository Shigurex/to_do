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
INSERT INTO member (name, email, password, is_public) VALUES ('a', 'a@gmail.com', 'a', true);
INSERT INTO member (name, email, password, is_public) VALUES ('aa', 'aa@gmail.com', 'a', true);
INSERT INTO member (name, email, password, is_public) VALUES ('aaa', 'aaa@gmail.com', 'a', true);
INSERT INTO member (name, email, password, is_public) VALUES ('aaaa', 'aaaaa@gmail.com', 'a', true);
INSERT INTO member (name, email, password, is_public) VALUES ('aaaaa', 'aaaaaa@gmail.com', 'a', true);
INSERT INTO member (name, email, password, is_public) VALUES ('aaaaaa', 'aaaaaaa@gmail.com', 'a', true);
INSERT INTO member (name, email, password, is_public) VALUES ('aaaaaaa', 'aaaaaaa@gmail.com', 'a', true);
INSERT INTO member (name, email, password, is_public) VALUES ('aaaaaaaa', 'aaaaaaaa@gmail.com', 'a', true);
INSERT INTO member (name, email, password, is_public) VALUES ('aaaaaaaaa', 'aaaaaaaaa@gmail.com', 'a', true);
INSERT INTO member (name, email, password, is_public) VALUES ('aaaaaaaaaa', 'aaaaaaaaaa@gmail.com', 'a', true);