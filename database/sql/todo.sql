DROP TABLE IF EXISTS todo;
CREATE TABLE todo (
	id INTEGER PRIMARY KEY,
	task INTEGER,
	title TEXT,
	deadline TIMESTAMP,
	create_time TIMESTAMP,
	update_time TIMESTAMP,
	priority INTEGER,
	is_done BOOLEAN
);

INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (1, 'java final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (2, 'java final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (2, 'sql final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (2, 'algo final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (2, 'human interface final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (3, 'java final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (3, 'sql final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (3, 'science final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (4, 'Visual computing exam', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (4, 'java final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (4, 'java final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (5, 'java final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (5, 'java final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);