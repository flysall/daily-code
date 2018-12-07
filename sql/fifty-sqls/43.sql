-- 43、统计每门课程的学生选修人数（超过5人的课程才统计）。要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列  

SELECT c_id, COUNT(*) AS total FROM score 
    GROUP BY c_id HAVING total > 5
    ORDER BY total, c_id ASC;

-- 终极sql
select c_id,count(*) as total from score GROUP BY c_id HAVING total>5 ORDER BY total,c_id ASC

-- 查询结果
/*
+------+-------+
| c_id | total |
+------+-------+
| 01   |     6 |
| 02   |     6 |
| 03   |     6 |
+------+-------+
3 rows in set (0.00 sec)

+------+-------+
| c_id | total |
+------+-------+
| 01   |     6 |
| 02   |     6 |
| 03   |     6 |
+------+-------+
3 rows in set (0.00 sec)
*/