DROP TABLE IF EXISTS share;
CREATE TABLE share (
	task INTEGER,
	member INTEGER,
	is_editable BOOLEAN
);

INSERT INTO share (task, member, is_editable) VALUES (1, 2, false);