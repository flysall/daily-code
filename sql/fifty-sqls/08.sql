-- 8、查询没学过"张三"老师授课的同学的信息

SELECT * FROM 
    student c WHERE c.s_id NOT IN(
        SELECT a.s_id FROM student AS a JOIN score AS b ON a.s_id = b.s_id WHERE b.c_id IN(
            SELECT c_id FROM course WHERE t_id = (
                SELECT t_id FROM teacher WHERE t_name = '张三'
            )
        )
    );

-- 查询结果
/*
+------+--------+------------+-------+
| s_id | s_name | s_birth    | s_sex |
+------+--------+------------+-------+
| 06   | 吴兰   | 1992-03-01 | 女    |
| 08   | 王菊   | 1990-01-20 | 女    |
+------+--------+------------+-------+
2 rows in set (0.00 sec)
*/