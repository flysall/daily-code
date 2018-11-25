-- 15、查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩 

SELECT s_id FROM score WHERE s_score < 60;

SELECT s_id FROM score WHERE s_score < 60 
    GROUP BY s_id HAVING COUNT(1) >= 2;

SELECT a.s_id, a.s_name, ROUND(AVG(b.s_score)) FROM student a 
    JOIN score b ON a.s_id = b.s_id AND a.s_id IN(
        SELECT s_id FROM score WHERE s_score < 60
        GROUP BY s_id HAVING count(1) >= 2)
    GROUP BY a.s_id, a.s_name;

-- 终极SQL
SELECT a.s_id, a.s_name, ROUND(AVG(b.s_score)) FROM
    student a JOIN score b ON a.s_id = b.s_id 
    WHERE a.s_id IN(
        SELECT s_id FROM score WHERE s_score < 60 
        GROUP BY s_id HAVING COUNT(1) >= 2)
    GROUP BY a.s_id, a.s_name;

-- 查询结果
/*
+------+
| s_id |
+------+
| 04   |
| 04   |
| 04   |
| 06   |
| 06   |
+------+
5 rows in set (0.00 sec)

+------+
| s_id |
+------+
| 04   |
| 06   |
+------+
2 rows in set (0.00 sec)

+------+--------+-----------------------+
| s_id | s_name | ROUND(AVG(b.s_score)) |
+------+--------+-----------------------+
| 04   | 李云   |                    33 |
| 06   | 吴兰   |                    33 |
+------+--------+-----------------------+
2 rows in set (0.00 sec)

+------+--------+-----------------------+
| s_id | s_name | ROUND(AVG(b.s_score)) |
+------+--------+-----------------------+
| 04   | 李云   |                    33 |
| 06   | 吴兰   |                    33 |
+------+--------+-----------------------+
2 rows in set (0.00 sec)
*/