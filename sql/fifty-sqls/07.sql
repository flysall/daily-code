-- 7、查询学过"张三"老师授课的同学的信息

SELECT * FROM 
    student WHERE s_id IN (
        SELECT s_id FROM score WHERE c_id IN (
            SELECT c_id FROM course WHERE t_id = (
                SELECT t_id FROM teacher WHERE t_name = '张三'
            )
        )
    );

SELECT a.* FROM
    student AS a JOIN score AS b ON a.s_id = b.s_id;

-- 终极sql
SELECT a.* FROM
    student AS a JOIN score AS b ON a.s_id = b.s_id WHERE b.c_id IN (
        SELECT c_id FROM course WHERE t_id = (
            SELECT t_id FROM teacher WHERE t_name = '张三'
        )
    );

/*
+------+--------+------------+-------+
| s_id | s_name | s_birth    | s_sex |
+------+--------+------------+-------+
| 01   | 赵雷   | 1990-01-01 | 男    |
| 02   | 钱电   | 1990-12-21 | 男    |
| 03   | 孙风   | 1990-05-20 | 男    |
| 04   | 李云   | 1990-08-06 | 男    |
| 05   | 周梅   | 1991-12-01 | 女    |
| 07   | 郑竹   | 1989-07-01 | 女    |
+------+--------+------------+-------+
6 rows in set (0.00 sec)

+------+--------+------------+-------+
| s_id | s_name | s_birth    | s_sex |
+------+--------+------------+-------+
| 01   | 赵雷   | 1990-01-01 | 男    |
| 01   | 赵雷   | 1990-01-01 | 男    |
| 01   | 赵雷   | 1990-01-01 | 男    |
| 02   | 钱电   | 1990-12-21 | 男    |
| 02   | 钱电   | 1990-12-21 | 男    |
| 02   | 钱电   | 1990-12-21 | 男    |
| 03   | 孙风   | 1990-05-20 | 男    |
| 03   | 孙风   | 1990-05-20 | 男    |
| 03   | 孙风   | 1990-05-20 | 男    |
| 04   | 李云   | 1990-08-06 | 男    |
| 04   | 李云   | 1990-08-06 | 男    |
| 04   | 李云   | 1990-08-06 | 男    |
| 05   | 周梅   | 1991-12-01 | 女    |
| 05   | 周梅   | 1991-12-01 | 女    |
| 06   | 吴兰   | 1992-03-01 | 女    |
| 06   | 吴兰   | 1992-03-01 | 女    |
| 07   | 郑竹   | 1989-07-01 | 女    |
| 07   | 郑竹   | 1989-07-01 | 女    |
+------+--------+------------+-------+
18 rows in set (0.01 sec)

+------+--------+------------+-------+
| s_id | s_name | s_birth    | s_sex |
+------+--------+------------+-------+
| 01   | 赵雷   | 1990-01-01 | 男    |
| 02   | 钱电   | 1990-12-21 | 男    |
| 03   | 孙风   | 1990-05-20 | 男    |
| 04   | 李云   | 1990-08-06 | 男    |
| 05   | 周梅   | 1991-12-01 | 女    |
| 07   | 郑竹   | 1989-07-01 | 女    |
+------+--------+------------+-------+
6 rows in set (0.00 sec)
*/
