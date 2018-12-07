-- 45、查询选修了全部课程的学生信息 

SELECT * FROM student WHERE s_id IN(
    SELECT s_id FROM score GROUP BY 
    s_id HAVING COUNT(*) = (SELECT COUNT(*) FROM course)
);

-- 终极sql
select * from student where s_id in(        
    select s_id from score GROUP BY s_id HAVING count(*)=(select count(*) from course));

-- 查询结果
/*
+------+--------+------------+-------+
| s_id | s_name | s_birth    | s_sex |
+------+--------+------------+-------+
| 01   | 赵雷   | 1990-01-01 | 男    |
| 02   | 钱电   | 1990-12-21 | 男    |
| 03   | 孙风   | 1990-05-20 | 男    |
| 04   | 李云   | 1990-08-06 | 男    |
+------+--------+------------+-------+
4 rows in set (0.00 sec)

+------+--------+------------+-------+
| s_id | s_name | s_birth    | s_sex |
+------+--------+------------+-------+
| 01   | 赵雷   | 1990-01-01 | 男    |
| 02   | 钱电   | 1990-12-21 | 男    |
| 03   | 孙风   | 1990-05-20 | 男    |
| 04   | 李云   | 1990-08-06 | 男    |
+------+--------+------------+-------+
4 rows in set (0.00 sec)
*/
