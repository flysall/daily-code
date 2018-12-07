-- 47、查询本周过生日的学生

SELECT * FROM student WHERE WEEK(DATE_FORMAT(NOW(), '%Y%m%d')) =
    WEEK(s_birth);

-- 终极sql
select * from student where WEEK(DATE_FORMAT(NOW(),'%Y%m%d'))=WEEK(s_birth);

-- 查询结果
/*
+------+--------+------------+-------+
| s_id | s_name | s_birth    | s_sex |
+------+--------+------------+-------+
| 05   | 周梅   | 1991-12-01 | 女    |
+------+--------+------------+-------+
1 row in set (0.00 sec)
 
+------+--------+------------+-------+
| s_id | s_name | s_birth    | s_sex |
+------+--------+------------+-------+
| 05   | 周梅   | 1991-12-01 | 女    |
+------+--------+------------+-------+
1 row in set (0.00 sec)
*/