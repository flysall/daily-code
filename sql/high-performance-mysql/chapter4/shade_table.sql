DROP TABLE IF EXISTS my_summary_new, my_summary_old;

CREATE TABLE IF NOT EXISTS my_summary
(
    id int NOT NULL,
    name varchar(10) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO my_summary(id, name) VALUES(1, 'flysall');
INSERT INTO my_summary(id, name) VALUES(2, 'yield');

SELECT * FROM my_summary;

DROP TABLE IF EXISTS my_summary__new;

CREATE TABLE my_summary_new LIKE my_summary;

RENAME TABLE my_summary TO my_summary_old, my_summary_new TO my_summary;

INSERT INTO my_summary(id, name) VALUES(3, 'pass');

SELECT * FROM my_summary;
