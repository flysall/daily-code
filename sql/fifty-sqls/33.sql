-- 33、查询平均成绩大于等于85的所有学生的学号、姓名和平均成绩 

SELECT a.s_id, a.s_name, ROUND(AVG(b.s_score), 2) AS avg_score
    FROM student a JOIN score b ON a.s_id = b.s_id 
    GROUP BY b.s_id HAVING avg_score >= 85;

-- 终极sql

select a.s_id,b.s_name,ROUND(avg(a.s_score),2) as avg_score from score a
    left join student b on a.s_id=b.s_id GROUP BY s_id HAVING avg_score>=85

-- 查询结果
/*
+------+--------+-----------+
| s_id | s_name | avg_score |
+------+--------+-----------+
| 01   | 赵雷   |     89.67 |
| 07   | 郑竹   |     93.50 |
+------+--------+-----------+
2 rows in set (0.00 sec)

+------+--------+-----------+
| s_id | s_name | avg_score |
+------+--------+-----------+
| 01   | 赵雷   |     89.67 |
| 07   | 郑竹   |     93.50 |
+------+--------+-----------+
*/