-- 34、查询课程名称为"数学"，且分数低于60的学生姓名和分数 

SELECT a.s_name, b.s_score FROM student a 
    JOIN score b ON a.s_id = b.s_id WHERE b.s_score < 60 
    AND b.c_id = (SELECT c_id FROM course WHERE c_name = '数学');

-- 终极sql

select a.s_name,b.s_score from score b LEFT JOIN student a on a.s_id=b.s_id where b.c_id=(
    select c_id from course where c_name ='数学') and b.s_score<60

-- 查询结果
/*
+--------+---------+
| s_name | s_score |
+--------+---------+
| 李云   |      30 |
+--------+---------+
1 row in set (0.01 sec)

+--------+---------+
| s_name | s_score |
+--------+---------+
| 李云   |      30 |
+--------+---------+
1 row in set (0.00 sec)
*/