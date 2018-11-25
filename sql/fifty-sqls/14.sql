-- 14、查询没学过"张三"老师讲授的任一门课程的学生姓名

SELECT s_id FROM score WHERE c_id = (
    SELECT c_id FROM course WHERE t_id = (
        SELECT t_id FROM teacher WHERE t_name = '张三'
    )
);

SELECT DISTINCT s_id FROM score WHERE c_id = (
    SELECT c_id FROM course WHERE t_id = (
        SELECT t_id FROM teacher WHERE t_name = '张三'
    )
);

-- 终极SQL
SELECT s_name FROM student WHERE s_id NOT IN(
    SELECT DISTINCT s_id FROM score WHERE c_id = (
        SELECT c_id FROM course WHERE t_id = (
            SELECT t_id FROM teacher WHERE t_name = '张三'
        )
    )
);

-- 查询结果
/*
+------+
| s_id |
+------+
| 01   |
| 02   |
| 03   |
| 04   |
| 05   |
| 07   |
+------+
6 rows in set (0.00 sec)

+------+
| s_id |
+------+
| 01   |
| 02   |
| 03   |
| 04   |
| 05   |
| 07   |
+------+
6 rows in set (0.03 sec)

+--------+
| s_name |
+--------+
| 吴兰   |
| 王菊   |
+--------+
2 rows in set (0.00 sec)
*/