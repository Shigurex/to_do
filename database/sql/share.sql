DROP TABLE IF EXISTS share;
CREATE TABLE share (
	task INTEGER,
	member INTEGER,
	is_editable BOOLEAN default false
);

INSERT INTO share (task, member, is_editable) VALUES (1, 2, false);
INSERT INTO share (task, member, is_editable) VALUES (1, 3, false);