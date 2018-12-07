-- 42、查询每门功成绩最好的前两名 

SELECT a.s_id, a.c_id, a.s_score FROM score a 
    WHERE (SELECT COUNT(1) FROM score b WHERE b.c_id = a.c_id 
    AND b.s_score >= a.s_score) <= 2 ORDER BY a.c_id;

-- 终极sql
select a.s_id,a.c_id,a.s_score from score a
    where (select COUNT(1) from score b where b.c_id=a.c_id and b.s_score>=a.s_score)<=2 ORDER BY a.c_id


-- 查询结果
/*
+------+------+---------+
| s_id | c_id | s_score |
+------+------+---------+
| 01   | 01   |      80 |
| 03   | 01   |      80 |
| 01   | 02   |      90 |
| 07   | 02   |      89 |
| 01   | 03   |      99 |
| 07   | 03   |      98 |
+------+------+---------+
6 rows in set (0.00 sec)

+------+------+---------+
| s_id | c_id | s_score |
+------+------+---------+
| 01   | 01   |      80 |
| 03   | 01   |      80 |
| 01   | 02   |      90 |
| 07   | 02   |      89 |
| 01   | 03   |      99 |
| 07   | 03   |      98 |
+------+------+---------+
6 rows in set (0.00 sec)
*/