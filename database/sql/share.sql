DROP TABLE IF EXISTS share;
CREATE TABLE share (
	task INTEGER,
	member INTEGER,
	is_editable BOOLEAN default false,
	is_archive BOOLEAN default false
);

INSERT INTO share (task, member, is_editable) VALUES (4, 3, true);
INSERT INTO share (task, member, is_editable) VALUES (5, 3, true);
INSERT INTO share (task, member, is_editable) VALUES (6, 4, false);
INSERT INTO share (task, member, is_editable) VALUES (7, 5, false);
INSERT INTO share (task, member, is_editable) VALUES (8, 6, false);
INSERT INTO share (task, member, is_editable) VALUES (9, 7, false);
INSERT INTO share (task, member, is_editable) VALUES (10, 8, false);
INSERT INTO share (task, member, is_editable) VALUES (11, 9, false);