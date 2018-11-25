-- 4、查询平均成绩小于60分的同学的学生编号和学生姓名和平均成绩
        -- (包括有成绩的和无成绩的)

SELECT a.s_id, a.s_name, b.* FROM
    student a LEFT JOIN score b ON a.s_id = b.s_id;

SELECT a.s_id, a.s_name, ROUND(AVG(b.s_score), 2) AS avg_score FROM
    student a LEFT JOIN score b ON a.s_id = b.s_id
    GROUP BY a.s_id, a.s_name;

SELECT a.s_id, a.s_name, ROUND(AVG(b.s_score), 2) AS avg_score FROM
    student a LEFT JOIN score b ON a.s_id = b.s_id
    GROUP BY a.s_id, a.s_name HAVING ROUND(AVG(b.s_score), 2) < 60;

SELECT a.s_id, a.s_name, 0 AS avg_score FROM
    student a WHERE a.s_id NOT IN (
        SELECT DISTINCT s_id FROM score
    );
    
-- 终极SQL
SELECT a.s_id, a.s_name, ROUND(AVG(b.s_score), 2) AS avg_score FROM
    student a LEFT JOIN score b ON a.s_id = b.s_id
    GROUP BY a.s_id, a.s_name HAVING ROUND(AVG(b.s_score), 2) < 60
    UNION
SELECT a.s_id, a.s_name, 0 AS avg_score FROM
    student a WHERE a.s_id NOT IN (
        SELECT DISTINCT s_id FROM score
    );

-- 查询结果
/*
+------+--------+------+------+---------+
| s_id | s_name | s_id | c_id | s_score |
+------+--------+------+------+---------+
| 01   | 赵雷   | 01   | 01   |      80 |
| 01   | 赵雷   | 01   | 02   |      90 |
| 01   | 赵雷   | 01   | 03   |      99 |
| 02   | 钱电   | 02   | 01   |      70 |
| 02   | 钱电   | 02   | 02   |      60 |
| 02   | 钱电   | 02   | 03   |      80 |
| 03   | 孙风   | 03   | 01   |      80 |
| 03   | 孙风   | 03   | 02   |      80 |
| 03   | 孙风   | 03   | 03   |      80 |
| 04   | 李云   | 04   | 01   |      50 |
| 04   | 李云   | 04   | 02   |      30 |
| 04   | 李云   | 04   | 03   |      20 |
| 05   | 周梅   | 05   | 01   |      76 |
| 05   | 周梅   | 05   | 02   |      87 |
| 06   | 吴兰   | 06   | 01   |      31 |
| 06   | 吴兰   | 06   | 03   |      34 |
| 07   | 郑竹   | 07   | 02   |      89 |
| 07   | 郑竹   | 07   | 03   |      98 |
| 08   | 王菊   | NULL | NULL |    NULL |
+------+--------+------+------+---------+
19 rows in set (0.00 sec)

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
| 08   | 王菊   |      NULL |
+------+--------+-----------+
8 rows in set (0.00 sec)

+------+--------+-----------+
| s_id | s_name | avg_score |
+------+--------+-----------+
| 04   | 李云   |     33.33 |
| 06   | 吴兰   |     32.50 |
+------+--------+-----------+
2 rows in set (0.00 sec)

+------+--------+-----------+
| s_id | s_name | avg_score |
+------+--------+-----------+
| 08   | 王菊   |         0 |
+------+--------+-----------+
1 row in set (0.00 sec)

+------+--------+-----------+
| s_id | s_name | avg_score |
+------+--------+-----------+
| 04   | 李云   |     33.33 |
| 06   | 吴兰   |     32.50 |
| 08   | 王菊   |      0.00 |
+------+--------+-----------+
3 rows in set (0.00 sec)
*/