-- 10、查询学过编号为"01"但是没有学过编号为"02"的课程的同学的信息

SELECT a.* FROM 
    student a WHERE 
    a.s_id IN (SELECT s_id FROM score WHERE c_id = '01') AND 
    a.s_id NOT IN (SELECT s_id FROM score WHERE c_id = '02');

-- 查询结果
/*
+------+--------+------------+-------+
| s_id | s_name | s_birth    | s_sex |
+------+--------+------------+-------+
| 06   | 吴兰   | 1992-03-01 | 女    |
+------+--------+------------+-------+
1 row in set (0.00 sec)
*/