-- 27、查询出只有两门课程的全部学生的学号和姓名

SELECT a.s_id, a.s_name
    FROM student a JOIN score b ON a.s_id = b.s_id
    GROUP BY a.s_id, a.s_name HAVING COUNT(c_id) = 2;

SELECT s_id, s_name FROM student WHERE s_id IN(
    SELECT s_id FROM score 
    GROUP BY s_id HAVING COUNT(c_id) = 2
);

-- 终极sql
select s_id,s_name from student where s_id in(
    select s_id from score GROUP BY s_id HAVING COUNT(c_id)=2);

-- 查询结果
/*
+------+--------+
| s_id | s_name |
+------+--------+
| 05   | 周梅   |
| 06   | 吴兰   |
| 07   | 郑竹   |
+------+--------+
3 rows in set (0.00 sec)

+------+--------+
| s_id | s_name |
+------+--------+
| 05   | 周梅   |
| 06   | 吴兰   |
| 07   | 郑竹   |
+------+--------+
3 rows in set (0.01 sec)

+------+--------+
| s_id | s_name |
+------+--------+
| 05   | 周梅   |
| 06   | 吴兰   |
| 07   | 郑竹   |
+------+--------+
3 rows in set (0.00 sec)
*/

