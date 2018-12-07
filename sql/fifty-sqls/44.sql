-- 44、检索至少选修两门课程的学生学号 

SELECT s_id, COUNT(*) AS sel FROM score 
    GROUP BY s_id HAVING sel >= 2;

-- 终极sql
select s_id,count(*) as sel from score GROUP BY s_id HAVING sel>=2;

-- 查询结果
/*
+------+-----+
| s_id | sel |
+------+-----+
| 01   |   3 |
| 02   |   3 |
| 03   |   3 |
| 04   |   3 |
| 05   |   2 |
| 06   |   2 |
| 07   |   2 |
+------+-----+
7 rows in set (0.00 sec)

+------+-----+
| s_id | sel |
+------+-----+
| 01   |   3 |
| 02   |   3 |
| 03   |   3 |
| 04   |   3 |
| 05   |   2 |
| 06   |   2 |
| 07   |   2 |
+------+-----+
7 rows in set (0.00 sec)
*/
