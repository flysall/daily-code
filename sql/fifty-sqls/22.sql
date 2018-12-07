-- 22、查询所有课程的成绩第2名到第3名的学生信息及该课程成绩

SELECT * FROM score
    WHERE c_id = '01'
    ORDER BY s_score DESC;

SELECT d.*, c.排名, c.s_score, c.c_id FROM(
    SELECT a.s_id, a.s_score, a.c_id, @i := @i+1 AS 排名 
    FROM score a, (SELECT @i := 0)s WHERE a.c_id = '01'
    ORDER BY a.s_score DESC
)c 
JOIN student d ON c.s_id = d.s_id
WHERE 排名 BETWEEN 2 AND 3
UNION 
SELECT d.*, c.排名, c.s_score, c.c_id FROM (
    SELECT a.s_id, a.s_score, a.c_id, @j := @j+1 AS 排名 
    FROM score a, (SELECT @j := 0)s WHERE a.c_id = '02'
    ORDER BY a.s_score DESC
)c 
JOIN student d ON c.s_id = d.s_id
WHERE 排名 BETWEEN 2 AND 3
UNION
SELECT d.*, c.排名, c.s_score, c.c_id FROM(
    SELECT a.s_id, a.s_score, a.c_id, @k := @k+1 AS 排名 
    FROM score a, (SELECT @k := 0)s WHERE a.c_id = '03'
    ORDER BY a.s_score DESC
)c 
JOIN student d ON c.s_id = d.s_id
WHERE 排名 BETWEEN 2 AND 3;

-- 终极sql
select d.*,c.排名,c.s_score,c.c_id from (
    select a.s_id,a.s_score,a.c_id,@i:=@i+1 as 排名 from score a,(select @i:=0)s where a.c_id='01'    
)c
left join student d on c.s_id=d.s_id
where 排名 BETWEEN 2 AND 3
UNION
select d.*,c.排名,c.s_score,c.c_id from (
    select a.s_id,a.s_score,a.c_id,@j:=@j+1 as 排名 from score a,(select @j:=0)s where a.c_id='02'    
)c
left join student d on c.s_id=d.s_id
where 排名 BETWEEN 2 AND 3
UNION
select d.*,c.排名,c.s_score,c.c_id from (
    select a.s_id,a.s_score,a.c_id,@k:=@k+1 as 排名 from score a,(select @k:=0)s where a.c_id='03'    
)c
left join student d on c.s_id=d.s_id
where 排名 BETWEEN 2 AND 3;

-- 查询结果
/*
+------+--------+------------+-------+--------+---------+------+
| s_id | s_name | s_birth    | s_sex | 排名   | s_score | c_id |
+------+--------+------------+-------+--------+---------+------+
| 03   | 孙风   | 1990-05-20 | 男    |      2 |      80 | 01   |
| 05   | 周梅   | 1991-12-01 | 女    |      3 |      76 | 01   |
| 07   | 郑竹   | 1989-07-01 | 女    |      2 |      89 | 02   |
| 05   | 周梅   | 1991-12-01 | 女    |      3 |      87 | 02   |
| 07   | 郑竹   | 1989-07-01 | 女    |      2 |      98 | 03   |
| 02   | 钱电   | 1990-12-21 | 男    |      3 |      80 | 03   |
+------+--------+------------+-------+--------+---------+------+
6 rows in set (0.00 sec)

+------+--------+------------+-------+--------+---------+------+
| s_id | s_name | s_birth    | s_sex | 排名   | s_score | c_id |
+------+--------+------------+-------+--------+---------+------+
| 02   | 钱电   | 1990-12-21 | 男    |      2 |      70 | 01   |
| 03   | 孙风   | 1990-05-20 | 男    |      3 |      80 | 01   |
| 02   | 钱电   | 1990-12-21 | 男    |      2 |      60 | 02   |
| 03   | 孙风   | 1990-05-20 | 男    |      3 |      80 | 02   |
| 02   | 钱电   | 1990-12-21 | 男    |      2 |      80 | 03   |
| 03   | 孙风   | 1990-05-20 | 男    |      3 |      80 | 03   |
+------+--------+------------+-------+--------+---------+------+
6 rows in set (0.01 sec)
*/
