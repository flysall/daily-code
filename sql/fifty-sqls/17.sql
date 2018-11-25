-- 17、按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩

-- 终极sql
SELECT a.s_id, (SELECT s_score FROM score WHERE s_id = a.s_id AND c_id = '01') AS '语文',
    (SELECT s_score FROM score WHERE s_id = a.s_id AND c_id = '02') AS '数学',
    (SELECT s_score FROM score WHERE s_id = a.s_id AND c_id = '03') AS '英语',
    ROUND(AVG(s_score), 2) AS 平均分 FROM score a GROUP BY a.s_id ORDER BY 平均分 DESC;

-- 查询结果
/*
+------+--------+--------+--------+-----------+
| s_id | 语文   | 数学   | 英语   | 平均分    |
+------+--------+--------+--------+-----------+
| 07   |   NULL |     89 |     98 |     93.50 |
| 01   |     80 |     90 |     99 |     89.67 |
| 05   |     76 |     87 |   NULL |     81.50 |
| 03   |     80 |     80 |     80 |     80.00 |
| 02   |     70 |     60 |     80 |     70.00 |
| 04   |     50 |     30 |     20 |     33.33 |
| 06   |     31 |   NULL |     34 |     32.50 |
+------+--------+--------+--------+-----------+
7 rows in set (0.10 sec)
*/