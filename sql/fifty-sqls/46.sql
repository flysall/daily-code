-- 46、查询各学生的年龄
    -- 按照出生日期来算，当前月日 < 出生年月的月日则，年龄减一

SELECT s_birth, (DATE_FORMAT(NOW(), '%Y') - DATE_FORMAT(s_birth, '%Y') -
    (CASE WHEN DATE_FORMAT(NOW(), '%m%d') > DATE_FORMAT(s_birth, '%m%d')
    THEN 0 ELSE 1 END)) AS age FROM student;

-- 终极sql
select s_birth,(DATE_FORMAT(NOW(),'%Y')-DATE_FORMAT(s_birth,'%Y') - 
            (case when DATE_FORMAT(NOW(),'%m%d')>DATE_FORMAT(s_birth,'%m%d') then 0 else 1 end)) as age
    from student;

-- 查询结果
/*
+------------+------+
| s_birth    | age  |
+------------+------+
| 1990-01-01 |   28 |
| 1990-12-21 |   27 |
| 1990-05-20 |   28 |
| 1990-08-06 |   28 |
| 1991-12-01 |   27 |
| 1992-03-01 |   26 |
| 1989-07-01 |   29 |
| 1990-01-20 |   28 |
+------------+------+
8 rows in set (0.00 sec)

+------------+------+
| s_birth    | age  |
+------------+------+
| 1990-01-01 |   28 |
| 1990-12-21 |   27 |
| 1990-05-20 |   28 |
| 1990-08-06 |   28 |
| 1991-12-01 |   27 |
| 1992-03-01 |   26 |
| 1989-07-01 |   29 |
| 1990-01-20 |   28 |
+------------+------+
8 rows in set (0.00 sec)
*/

