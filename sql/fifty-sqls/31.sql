-- 31、查询1990年出生的学生名单

SELECT s_name FROM student WHERE s_birth LIKE '1990%';

-- 查询结果
/*
+--------+
| s_name |
+--------+
| 赵雷   |
| 钱电   |
| 孙风   |
| 李云   |
| 王菊   |
+--------+
5 rows in set (0.00 sec)
*/
