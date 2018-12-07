-- 49、查询本月过生日的学生

SELECT * FROM student WHERE MONTH(DATE_FORMAT(NOW(), '%Y%m%d')) = 
    MONTH(s_birth);

-- 终极sql
    select * from student where MONTH(DATE_FORMAT(NOW(),'%Y%m%d')) =MONTH(s_birth);

-- 查询结果
/*
+------+--------+------------+-------+
| s_id | s_name | s_birth    | s_sex |
+------+--------+------------+-------+
| 02   | 钱电   | 1990-12-21 | 男    |
| 05   | 周梅   | 1991-12-01 | 女    |
+------+--------+------------+-------+
2 rows in set (0.00 sec)

+------+--------+------------+-------+
| s_id | s_name | s_birth    | s_sex |
+------+--------+------------+-------+
| 02   | 钱电   | 1990-12-21 | 男    |
| 05   | 周梅   | 1991-12-01 | 女    |
+------+--------+------------+-------+
2 rows in set (0.00 sec)
*/