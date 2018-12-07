-- 32、查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列 

SELECT c_id, ROUND(AVG(s_score), 2)AS avg_score FROM score 
    GROUP BY c_id ORDER BY avg_score DESC, c_id ASC;

-- 查询结果
/*
+------+-----------+
| c_id | avg_score |
+------+-----------+
| 02   |     72.67 |
| 03   |     68.50 |
| 01   |     64.50 |
+------+-----------+
*/