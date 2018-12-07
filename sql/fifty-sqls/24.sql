-- 24、查询学生平均成绩及其名次 

SELECT s_id, ROUND(AVG(s_score), 2) AS avg_s 
    FROM score GROUP BY s_id;

-- 终极sql
SELECT a.s_id, @i := @i+1 AS 排名, a.avg_s AS 平均分 FROM
    (SELECT s_id, ROUND(AVG(s_score), 2) AS avg_s 
    FROM score GROUP BY s_id)a, (SELECT @i := 0)b
    ORDER BY avg_s DESC;

-- 查询结果
/*
+------+-------+
| s_id | avg_s |
+------+-------+
| 01   | 89.67 |
| 02   | 70.00 |
| 03   | 80.00 |
| 04   | 33.33 |
| 05   | 81.50 |
| 06   | 32.50 |
| 07   | 93.50 |
+------+-------+
7 rows in set (0.00 sec)

+------+--------+-----------+
| s_id | 排名   | 平均分    |
+------+--------+-----------+
| 07   |      1 |     93.50 |
| 01   |      2 |     89.67 |
| 05   |      3 |     81.50 |
| 03   |      4 |     80.00 |
| 02   |      5 |     70.00 |
| 04   |      6 |     33.33 |
| 06   |      7 |     32.50 |
+------+--------+-----------+
7 rows in set (0.00 sec)

*/
