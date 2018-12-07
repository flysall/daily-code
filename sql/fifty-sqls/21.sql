-- 21、查询不同老师所教不同课程平均分从高到低显示 

SELECT a.t_id, a.t_name, b.c_id, b.s_score
    FROM teacher a JOIN course c ON a.t_id = c.t_id
    JOIN score b ON b.c_id = c.c_id;

SELECT a.t_id, a.t_name, b.c_id, ROUND(AVG(b.s_score), 2) AS avg_score
    FROM score b JOIN course c ON b.c_id = c.c_id
    JOIN teacher a ON a.t_id = c.t_id
    GROUP BY a.t_id, a.t_name, b.c_id -- only_full_group_by模式下必须将三个列都GROUP BY
    ORDER BY avg_score DESC;

-- 终极sql
select a.t_id,c.t_name,a.c_id,ROUND(avg(s_score),2) as avg_score from course a
    left join score b on a.c_id=b.c_id 
    left join teacher c on a.t_id=c.t_id
    GROUP BY a.c_id,a.t_id,c.t_name ORDER BY avg_score DESC;

-- 查询结果
/*
+------+--------+------+---------+
| t_id | t_name | c_id | s_score |
+------+--------+------+---------+
| 02   | 李四   | 01   |      80 |
| 01   | 张三   | 02   |      90 |
| 03   | 王五   | 03   |      99 |
| 02   | 李四   | 01   |      70 |
| 01   | 张三   | 02   |      60 |
| 03   | 王五   | 03   |      80 |
| 02   | 李四   | 01   |      80 |
| 01   | 张三   | 02   |      80 |
| 03   | 王五   | 03   |      80 |
| 02   | 李四   | 01   |      50 |
| 01   | 张三   | 02   |      30 |
| 03   | 王五   | 03   |      20 |
| 02   | 李四   | 01   |      76 |
| 01   | 张三   | 02   |      87 |
| 02   | 李四   | 01   |      31 |
| 03   | 王五   | 03   |      34 |
| 01   | 张三   | 02   |      89 |
| 03   | 王五   | 03   |      98 |
+------+--------+------+---------+
18 rows in set (0.00 sec)

+------+--------+------+-----------+
| t_id | t_name | c_id | avg_score |
+------+--------+------+-----------+
| 01   | 张三   | 02   |     72.67 |
| 03   | 王五   | 03   |     68.50 |
| 02   | 李四   | 01   |     64.50 |
+------+--------+------+-----------+
3 rows in set (0.00 sec)

+------+--------+------+-----------+
| t_id | t_name | c_id | avg_score |
+------+--------+------+-----------+
| 01   | 张三   | 02   |     72.67 |
| 03   | 王五   | 03   |     68.50 |
| 02   | 李四   | 01   |     64.50 |
+------+--------+------+-----------+
3 rows in set (0.00 sec)
*/