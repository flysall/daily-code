-- 13、查询和"01"号的同学学习的课程完全相同的其他同学的信息

SELECT COUNT(1) from score WHERE s_id = '01';

SELECT c_id FROM score WHERE s_id = '01';

SELECT s_id FROM score WHERE s_id != '01' AND
c_id IN(SELECT c_id FROM score WHERE s_id = '01');

SELECT DISTINCT s_id FROM score WHERE s_id != '01' AND
c_id IN(SELECT c_id FROM score WHERE s_id = '01');

SELECT s_id FROM score WHERE s_id != '01' AND
c_id IN(SELECT c_id FROM score WHERE s_id = '01')
GROUP BY s_id HAVING COUNT(1) = (SELECT COUNT(1) FROM
score WHERE s_id = '01');

-- 终极SQL
SELECT a.* FROM student a WHERE s_id IN(
    SELECT DISTINCT s_id FROM score WHERE s_id != '01' AND
    c_id IN(SELECT c_id FROM score WHERE s_id = '01')
    GROUP BY s_id HAVING COUNT(1) = (SELECT COUNT(1) FROM
    score WHERE s_id = '01')
);

-- 查询结果
/*
+----------+
| COUNT(1) |
+----------+
|        3 |
+----------+
1 row in set (0.00 sec)

+------+
| c_id |
+------+
| 01   |
| 02   |
| 03   |
+------+
3 rows in set (0.00 sec)

+------+
| s_id |
+------+
| 02   |
| 02   |
| 02   |
| 03   |
| 03   |
| 03   |
| 04   |
| 04   |
| 04   |
| 05   |
| 05   |
| 06   |
| 06   |
| 07   |
| 07   |
+------+
15 rows in set (0.00 sec)

+------+
| s_id |
+------+
| 02   |
| 03   |
| 04   |
| 05   |
| 06   |
| 07   |
+------+
6 rows in set (0.00 sec)

+------+
| s_id |
+------+
| 02   |
| 03   |
| 04   |
+------+
3 rows in set (0.00 sec)

+------+--------+------------+-------+
| s_id | s_name | s_birth    | s_sex |
+------+--------+------------+-------+
| 02   | 钱电   | 1990-12-21 | 男    |
| 03   | 孙风   | 1990-05-20 | 男    |
| 04   | 李云   | 1990-08-06 | 男    |
+------+--------+------------+-------+
3 rows in set (0.00 sec)
*/