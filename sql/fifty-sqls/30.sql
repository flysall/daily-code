-- 30、查询同名同性学生名单，并统计同名人数 

-- 修改数据进行测试
UPDATE student SET s_name = '赵雷' WHERE s_id = '02';

UPDATE student SET s_name = '赵雷' WHERE s_id = '03';

-- 终极sql
SELECT s_name, s_sex, count(*) FROM student WHERE s_id IN(
    SELECT a.s_id FROM student a JOIN 
    student b ON a.s_id != b.s_id AND a.s_name = b.s_name AND
    a.s_sex = b.s_sex GROUP BY a.s_id) 
    GROUP BY s_name, s_sex;

-- 恢复数据
UPDATE student SET s_name = '钱电' WHERE s_id = '02';

UPDATE student SET s_name = '孙风' WHERE s_id = '03';

-- 查询结果
/*
+--------+-------+----------+
| s_name | s_sex | count(*) |
+--------+-------+----------+
| 赵雷   | 男    |        3 |
+--------+-------+----------+
*/