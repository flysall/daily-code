-- 3、查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩

SELECT a.s_id, a.s_name, b.s_score FROM
    student AS a JOIN score AS b ON a.s_id = b.s_id;

SELECT a.s_id, a.s_name, ROUND(AVG(b.s_score), 2) AS avg_score FROM
    student AS a JOIN score AS b ON a.s_id = b.s_id 
    GROUP BY a.s_id, a.s_name;

-- 终极SQL
SELECT a.s_id, a.s_name, ROUND(AVG(b.s_score), 2) AS avg_score FROM
    student AS a JOIN score AS b ON a.s_id = b.s_id 
    GROUP BY a.s_id, a.s_name HAVING ROUND(AVG(b.s_score), 2) >= 60;

-- 查询结果
/*
+------+--------+---------+
| s_id | s_name | s_score |
+------+--------+---------+
| 01   | 赵雷   |      80 |
| 01   | 赵雷   |      90 |
| 01   | 赵雷   |      99 |
| 02   | 钱电   |      70 |
| 02   | 钱电   |      60 |
| 02   | 钱电   |      80 |
| 03   | 孙风   |      80 |
| 03   | 孙风   |      80 |
| 03   | 孙风   |      80 |
| 04   | 李云   |      50 |
| 04   | 李云   |      30 |
| 04   | 李云   |      20 |
| 05   | 周梅   |      76 |
| 05   | 周梅   |      87 |
| 06   | 吴兰   |      31 |
| 06   | 吴兰   |      34 |
| 07   | 郑竹   |      89 |
| 07   | 郑竹   |      98 |
+------+--------+---------+
18 rows in set (0.01 sec)

+------+--------+-----------+
| s_id | s_name | avg_score |
+------+--------+-----------+
| 01   | 赵雷   |     89.67 |
| 02   | 钱电   |     70.00 |
| 03   | 孙风   |     80.00 |
| 04   | 李云   |     33.33 |
| 05   | 周梅   |     81.50 |
| 06   | 吴兰   |     32.50 |
| 07   | 郑竹   |     93.50 |
+------+--------+-----------+
7 rows in set (0.00 sec)

+------+--------+-----------+
| s_id | s_name | avg_score |
+------+--------+-----------+
| 01   | 赵雷   |     89.67 |
| 02   | 钱电   |     70.00 |
| 03   | 孙风   |     80.00 |
| 05   | 周梅   |     81.50 |
| 07   | 郑竹   |     93.50 |
+------+--------+-----------+
5 rows in set (0.00 sec)
*/