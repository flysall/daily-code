-- 28、查询男生、女生人数 

SELECT s_sex, COUNT(s_id) AS 人数 FROM 
    student GROUP BY s_sex;


-- 终极sql
select s_sex,COUNT(s_sex) as 人数  from student GROUP BY s_sex;

/*
+-------+--------+
| s_sex | 人数   |
+-------+--------+
| 女    |      4 |
| 男    |      4 |
+-------+--------+
2 rows in set (0.00 sec)

+-------+--------+
| s_sex | 人数   |
+-------+--------+
| 女    |      4 |
| 男    |      4 |
+-------+--------+
2 rows in set (0.00 sec)
*/
