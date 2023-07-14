DROP TABLE IF EXISTS todo;
CREATE TABLE todo (
	id INTEGER PRIMARY KEY,
	task INTEGER,
	title TEXT,
	deadline TIMESTAMP,
	create_time TIMESTAMP,
	update_time TIMESTAMP,
	priority INTEGER,
	is_done BOOLEAN default false
);

INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (1, 'java final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (5, 'shift', '2023/07/23 15:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 4, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (5, 'shift submit', '2023/08/22 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (3, 'movie', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (4, 'java final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 4, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (4, 'sql final report', '2023/07/23 23:59:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (4, 'algo final report', '2023/07/25 23:59:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 4, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (7, 'Visual Computing exam', '2023/07/28 13:00:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 3, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (7, 'human interface final report', '2023/07/24 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (10, 'java final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 4, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (8, 'competition', '2023/07/26 12:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (10, 'sql final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (10, 'science final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (13, 'Visual computing exam', '2023/07/28 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (13, 'java final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 2, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (13, 'VC test', '2023/07/28 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 5, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (16, 'java final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 3, false);
INSERT INTO todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES (16, 'sql final report', '2023/07/23 23:50:00', strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), strftime('%Y/%m/%d %H:%M:%S', CURRENT_TIMESTAMP, 'localtime'), 1, false);