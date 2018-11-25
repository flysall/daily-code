-- 11、查询没有学全所有课程的同学的信息 

SELECT a.s_id FROM score a 
JOIN score b ON a.s_id = b.s_id AND b.c_id = '02'
JOIN score c ON a.s_id = c.s_id AND c.c_id = '03';

SELECT a.s_id FROM score a 
JOIN score b ON a.s_id = b.s_id AND b.c_id = '02'
JOIN score c ON a.s_id = c.s_id AND c.c_id = '03'
WHERE a.c_id = '01';

-- 终极sql
SELECT s.* FROM 
    student s WHERE s.s_id IN(
        SELECT s_id FROM score WHERE s_id NOT IN(
            SELECT a.s_id FROM score a 
            JOIN score b ON a.s_id = b.s_id AND b.c_id = '02'
            JOIN score c ON a.s_id = c.s_id AND c.c_id = '03'
            WHERE a.c_id = '01'
        )
    );
-- 查询结果
/*
+------+--------+------------+-------+
| s_id | s_name | s_birth    | s_sex |
+------+--------+------------+-------+
| 05   | 周梅   | 1991-12-01 | 女    |
| 06   | 吴兰   | 1992-03-01 | 女    |
| 07   | 郑竹   | 1989-07-01 | 女    |
+------+--------+------------+-------+
3 rows in set (0.00 sec)
*/