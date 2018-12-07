-- 41、查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩 

SELECT DISTINCT a.s_id, a.c_id, a.s_score FROM score a
    JOIN score b ON a.s_score = b.s_score AND 
    a.c_id != b.c_id;

-- 终极sql
select DISTINCT b.s_id,b.c_id,b.s_score from score a,score b where a.c_id != b.c_id and a.s_score = b.s_score;

-- 查询结果
/*
+------+------+---------+
| s_id | c_id | s_score |
+------+------+---------+
| 02   | 03   |      80 |
| 03   | 02   |      80 |
| 03   | 03   |      80 |
| 01   | 01   |      80 |
| 03   | 01   |      80 |
+------+------+---------+
5 rows in set (0.00 sec)

+------+------+---------+
| s_id | c_id | s_score |
+------+------+---------+
| 01   | 01   |      80 |
| 02   | 03   |      80 |
| 03   | 01   |      80 |
| 03   | 02   |      80 |
| 03   | 03   |      80 |
+------+------+---------+
5 rows in set (0.00 sec)
*/