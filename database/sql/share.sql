DROP TABLE IF EXISTS share;
CREATE TABLE share (
	task INTEGER,
	member INTEGER,
	is_editable BOOLEAN default false
);

INSERT INTO share (task, member, is_editable) VALUES (1, 3, true);
INSERT INTO share (task, member, is_editable) VALUES (4, 1, true);
INSERT INTO share (task, member, is_editable) VALUES (1, 4, false);
INSERT INTO share (task, member, is_editable) VALUES (1, 5, false);
INSERT INTO share (task, member, is_editable) VALUES (4, 1, false);
INSERT INTO share (task, member, is_editable) VALUES (8, 4, false);
INSERT INTO share (task, member, is_editable) VALUES (1, 4, false);
INSERT INTO share (task, member, is_editable) VALUES (4, 4, false);