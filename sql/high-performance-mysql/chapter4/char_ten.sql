CREATE TABLE char_test(
    char_col CHAR(10)
);

INSERT INTO char_test(char_col) VALUES
('string1'), (' string2'), ('string3 ');

SELECT CONCAT("'", char_col, "'") FROM char_test;
