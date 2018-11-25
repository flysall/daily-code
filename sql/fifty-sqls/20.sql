-- 20、查询学生的总成绩并进行排名

SELECT a.s_id, @i := @i + 1 AS i,
    @k := @k + 1 AS rank,
    @score:= a.sum_score AS score
    FROM (SELECT s_id, SUM(s_score) AS sum_score FROM score 
    GROUP BY s_id ORDER BY sum_score DESC)a,
    (SELECT @k := 0, @i := 0, @socre := 0)s;


-- 终极sql
SELECT a.s_id, @i := @i + 1 AS ic,
    @k := (CASE WHEN @score = a.sum_score THEN @k else @i END) AS rank,
    @score:= a.sum_score AS score
    FROM (SELECT s_id, SUM(s_score) AS sum_score FROM score 
    GROUP BY s_id ORDER BY sum_score DESC)a,
    -- 声明并初始化变量?
    -- s为派生表表名，必须写上。
    (SELECT @k := 0, @i := 0, @socre := 0)s;

-- 查询结果
/*
+------+------+------+-------+
| s_id | i    | rank | score |
+------+------+------+-------+
| 01   |    1 |    1 |   269 |
| 03   |    2 |    2 |   240 |
| 02   |    3 |    3 |   210 |
| 07   |    4 |    4 |   187 |
| 05   |    5 |    5 |   163 |
| 04   |    6 |    6 |   100 |
| 06   |    7 |    7 |    65 |
+------+------+------+-------+
7 rows in set (0.00 sec)

+------+------+------+-------+
| s_id | ic   | rank | score |
+------+------+------+-------+
| 01   |    1 |    1 |   269 |
| 03   |    2 |    2 |   240 |
| 02   |    3 |    3 |   210 |
| 07   |    4 |    4 |   187 |
| 05   |    5 |    5 |   163 |
| 04   |    6 |    6 |   100 |
| 06   |    7 |    7 |    65 |
+------+------+------+-------+
7 rows in set (0.00 sec)
*/