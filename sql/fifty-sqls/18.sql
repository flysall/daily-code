-- 18.查询各科成绩最高分、最低分和平均分：以如下形式显示：课程ID，课程name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
-- 及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90

SELECT a.c_id, b.c_name, a.s_score 
    FROM score a JOIN course b ON a.c_id = b.c_id;

SELECT MAX(s_score) FROM score;SELECT a.c_id, b.c_name, a.s_score, MAX(a.s_score)
    FROM score a JOIN course b ON a.c_id = b.c_id
    GROUP BY a.c_id;


-- 终极sql
SELECT a.c_id, b.c_name, MAX(a.s_score), MIN(a.s_score), ROUND(AVG(a.s_score),2),
    ROUND(100 * (SUM(CASE WHEN a.s_score >= 60 then 1 else 0 end) / SUM(CASE WHEN a.s_score THEN 1 ELSE 0 END)), 2) AS 及格率,
    ROUND(100 * (SUM(CASE WHEN a.s_score >= 70 AND a.s_score <= 80 THEN 1 ELSE 0 END) / SUM(CASE WHEN a.s_score THEN 1 ELSE 0 END)), 2) AS 中等率,
    ROUND(100 * (SUM(CASE WHEN a.s_score >= 80 AND a.s_score <= 90 THEN 1 ELSE 0 END) / SUM(CASE WHEN a.s_score THEN 1 ELSE 0 END)), 2) AS 优良率,
    ROUND(100 * (SUM(CASE WHEN a.s_score >= 90 THEN 1 ELSE 0 END) / SUM(CASE WHEN a.s_score THEN 1 ELSE 0 END)), 2) AS 优秀率
    FROM score a JOIN course b ON a.c_id = b.c_id 
    GROUP BY a.c_id, b.c_name;

-- 查询结果
/*
+------+--------+---------+
| c_id | c_name | s_score |
+------+--------+---------+
| 01   | 语文   |      80 |
| 02   | 数学   |      90 |
| 03   | 英语   |      99 |
| 01   | 语文   |      70 |
| 02   | 数学   |      60 |
| 03   | 英语   |      80 |
| 01   | 语文   |      80 |
| 02   | 数学   |      80 |
| 03   | 英语   |      80 |
| 01   | 语文   |      50 |
| 02   | 数学   |      30 |
| 03   | 英语   |      20 |
| 01   | 语文   |      76 |
| 02   | 数学   |      87 |
| 01   | 语文   |      31 |
| 03   | 英语   |      34 |
| 02   | 数学   |      89 |
| 03   | 英语   |      98 |
+------+--------+---------+
18 rows in set (0.39 sec)

+--------------+
| MAX(s_score) |
+--------------+
|           99 |
+--------------+
1 row in set (0.00 sec)

ERROR 1055 (42000): Expression #3 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'fifty_sqls.a.s_score' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
+------+--------+----------------+----------------+-------------------------+-----------+-----------+-----------+-----------+
| c_id | c_name | MAX(a.s_score) | MIN(a.s_score) | ROUND(AVG(a.s_score),2) | 及格率    | 中等率    | 优良率    | 优秀率    |
+------+--------+----------------+----------------+-------------------------+-----------+-----------+-----------+-----------+
| 01   | 语文   |             80 |             31 |                   64.50 |     66.67 |     66.67 |     33.33 |      0.00 |
| 02   | 数学   |             90 |             30 |                   72.67 |     83.33 |     16.67 |     66.67 |     16.67 |
| 03   | 英语   |             99 |             20 |                   68.50 |     66.67 |     33.33 |     33.33 |     33.33 |
+------+--------+----------------+----------------+-------------------------+-----------+-----------+-----------+-----------+
3 rows in set (0.01 sec)
*/
