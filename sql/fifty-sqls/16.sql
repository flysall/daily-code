-- 16、检索"01"课程分数小于60，按分数降序排列的学生信息

SELECT s_id FROM score WHERE c_id = '01'
    AND s_score < 60;

SELECT a.*, b.s_score FROM student a 
    JOIN score b ON a.s_id = b.s_id AND c_id = '01' AND a.s_id IN(
        SELECT s_id FROM score WHERE s_score < 60
    ) ORDER BY b.s_score DESC;

-- 终极SQL
SELECT a.*, b.s_score FROM student a, score b 
    WHERE a.s_id = b.s_id AND b.c_id = '01' AND b.s_score < 60 
    ORDER BY b.s_score;

-- 查询结果
/*
+------+
| s_id |
+------+
| 04   |
| 06   |
+------+
2 rows in set (0.00 sec)

+------+--------+------------+-------+---------+
| s_id | s_name | s_birth    | s_sex | s_score |
+------+--------+------------+-------+---------+
| 04   | 李云   | 1990-08-06 | 男    |      50 |
| 06   | 吴兰   | 1992-03-01 | 女    |      31 |
+------+--------+------------+-------+---------+
2 rows in set (0.00 sec)

+------+--------+------------+-------+---------+
| s_id | s_name | s_birth    | s_sex | s_score |
+------+--------+------------+-------+---------+
| 06   | 吴兰   | 1992-03-01 | 女    |      31 |
| 04   | 李云   | 1990-08-06 | 男    |      50 |
+------+--------+------------+-------+---------+
2 rows in set (0.00 sec)
*/