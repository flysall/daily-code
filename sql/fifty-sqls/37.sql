-- 37、查询不及格的课程

SELECT a.s_id, c.c_id, c.c_name, b.s_score 
    FROM student a JOIN score b ON a.s_id = b.s_id 
    JOIN course c ON b.c_id = c.c_id
    WHERE b.s_score < 60;

-- 终极sql
select a.s_id,a.c_id,b.c_name,a.s_score from score a left join course b on a.c_id = b.c_id
    where a.s_score<60; 

-- 查询结果
/*
+------+------+--------+---------+
| s_id | c_id | c_name | s_score |
+------+------+--------+---------+
| 04   | 01   | 语文   |      50 |
| 04   | 02   | 数学   |      30 |
| 04   | 03   | 英语   |      20 |
| 06   | 01   | 语文   |      31 |
| 06   | 03   | 英语   |      34 |
+------+------+--------+---------+
5 rows in set (0.00 sec)

+------+------+--------+---------+
| s_id | c_id | c_name | s_score |
+------+------+--------+---------+
| 04   | 01   | 语文   |      50 |
| 06   | 01   | 语文   |      31 |
| 04   | 02   | 数学   |      30 |
| 04   | 03   | 英语   |      20 |
| 06   | 03   | 英语   |      34 |
+------+------+--------+---------+
5 rows in set (0.00 sec)
*/