DROP TABLE IF EXISTS task;
CREATE TABLE task (
	id INTEGER PRIMARY KEY,
	owner INTEGER,
	name TEXT,
	description TEXT,
	is_public BOOLEAN,
	is_archive BOOLEAN
);

INSERT INTO task (owner, name, description, is_public, is_archive) VALUES (1, 'school', 'task about school is written', false, false);