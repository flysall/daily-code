-- 26、查询每门课程被选修的学生数

SELECT c_id, COUNT(s_id) FROM score 
    GROUP BY c_id;

-- 终极sql    
select c_id,count(s_id) from score a GROUP BY c_id;

-- 查询结果
/*
+------+-------------+
| c_id | COUNT(s_id) |
+------+-------------+
| 01   |           6 |
| 02   |           6 |
| 03   |           6 |
+------+-------------+
3 rows in set (0.00 sec)

+------+-------------+
| c_id | count(s_id) |
+------+-------------+
| 01   |           6 |
| 02   |           6 |
| 03   |           6 |
+------+-------------+
*/