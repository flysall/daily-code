CREATE TABLE IF NOT EXISTS enum_test(
    e ENUM('fish', 'apple', 'dog') NOT NULL
);

INSERT INTO enum_test(e) VALUES('fish'), ('dog'), ('apple');

SELECT e + 0 FROM enum_test;

SELECT e FROM enum_test;

SELECT e FROM enum_test ORDER BY e;

SELECT e FROM enum_test ORDER BY FIELD(e, 'apple', 'dog', 'fish');
