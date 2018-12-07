-- 40、查询选修"张三"老师所授课程的学生中，成绩最高的学生信息及其成绩

SELECT a.*, b.s_score, c.c_id, c.c_name FROM student a 
    JOIN score b ON a.s_id = b.s_id 
    JOIN course c ON b.c_id = c.c_id
    WHERE b.c_id = (SELECT c_id FROM course c, teacher d 
        WHERE c.t_id = d.t_id AND d.t_name = '张三')
    AND b.s_score IN (SELECT MAX(s_score) from score WHERE c_id = '02');

-- 查询结果
/*
+------+--------+------------+-------+---------+------+--------+
| s_id | s_name | s_birth    | s_sex | s_score | c_id | c_name |
+------+--------+------------+-------+---------+------+--------+
| 01   | 赵雷   | 1990-01-01 | 男    |      90 | 02   | 数学   |
+------+--------+------------+-------+---------+------+--------+
1 row in set (0.03 sec)
*/