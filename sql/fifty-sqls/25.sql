-- 25、查询各科成绩前三名的记录
    -- 1.选出b表比a表成绩大的所有组
    -- 2.选出比当前id成绩大的 小于三个的

-- 不太会写
SELECT a.s_id, a.c_id, a.s_score AS a_s_score , b.s_score AS b_s_score FROM score a 
    LEFT JOIN score b ON a.c_id = b.c_id AND a.s_score < b.s_score;

SELECT a.s_id, a.c_id, a.s_score FROM score a 
    LEFT JOIN score b ON a.c_id = b.c_id AND a.s_score < b.s_score
    GROUP BY a.s_id, a.c_id, a.s_score HAVING COUNT(b.s_id) < 3
    ORDER BY a.c_id, a.s_score DESC;