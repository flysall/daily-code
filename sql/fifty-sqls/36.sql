 -- 36、查询任何一门课程成绩在70分以上的姓名、课程名称和分数； 

SELECT a.s_name, c.c_name, b.s_score FROM student a 
    JOIN score b ON a.s_id = b.s_id 
    JOIN course c ON b.c_id = c.c_id
    WHERE b.s_score >= 70; 

-- 终极sql
select a.s_name,b.c_name,c.s_score from course b left join score c on b.c_id = c.c_id
    left join student a on a.s_id=c.s_id where c.s_score>=70;

-- 查询结果
/*
+--------+--------+---------+
| s_name | c_name | s_score |
+--------+--------+---------+
| 赵雷   | 语文   |      80 |
| 赵雷   | 数学   |      90 |
| 赵雷   | 英语   |      99 |
| 钱电   | 语文   |      70 |
| 钱电   | 英语   |      80 |
| 孙风   | 语文   |      80 |
| 孙风   | 数学   |      80 |
| 孙风   | 英语   |      80 |
| 周梅   | 语文   |      76 |
| 周梅   | 数学   |      87 |
| 郑竹   | 数学   |      89 |
| 郑竹   | 英语   |      98 |
+--------+--------+---------+
12 rows in set (0.00 sec)

+--------+--------+---------+
| s_name | c_name | s_score |
+--------+--------+---------+
| 赵雷   | 语文   |      80 |
| 赵雷   | 数学   |      90 |
| 赵雷   | 英语   |      99 |
| 钱电   | 语文   |      70 |
| 钱电   | 英语   |      80 |
| 孙风   | 语文   |      80 |
| 孙风   | 数学   |      80 |
| 孙风   | 英语   |      80 |
| 周梅   | 语文   |      76 |
| 周梅   | 数学   |      87 |
| 郑竹   | 数学   |      89 |
| 郑竹   | 英语   |      98 |
+--------+--------+---------+
12 rows in set (0.00 sec)
*/