-- 1、查询"01"课程比"02"课程成绩高的学生的信息及课程分数  

-- 终极SQL
SELECT a.*, b.s_score AS 01_score, c.s_score AS 02_score FROM
    student a JOIN score b ON a.s_id = b.s_id AND b.c_id = '01'
    LEFT JOIN score c ON a.s_id = c.s_id AND c.c_id = '02' OR 
    c.c_id = NULL WHERE b.s_score > c.s_score;

-- 查询结果
/*
+------+--------+------------+-------+----------+----------+
| s_id | s_name | s_birth    | s_sex | 01_score | 02_score |
+------+--------+------------+-------+----------+----------+
| 02   | 钱电   | 1990-12-21 | 男    |       70 |       60 |
| 04   | 李云   | 1990-08-06 | 男    |       50 |       30 |
+------+--------+------------+-------+----------+----------+
2 rows in set (0.00 sec)
*/