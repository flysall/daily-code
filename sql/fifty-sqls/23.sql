-- 23、统计各科成绩各分数段人数：课程编号,课程名称,[100-85],[85-70],[70-60],[0-60]及所占百分比

SELECT DISTINCT f.c_name, a.c_id, b.`85-100`, b.百分比,
    c.`70-85`, c.百分比, d.`60-70`, d.百分比, e.`0-60`, e.百分比
    FROM score a 
    JOIN (SELECT c_id, SUM(CASE WHEN s_score > 85 AND s_score <= 100
        THEN 1 ELSE 0 END) AS `85-100`,
        ROUND(100*(SUM(CASE WHEN s_score > 85 AND s_score <= 100 
        THEN 1 ELSE 0 END) / COUNT(*)),2) AS 百分比
        FROM score GROUP BY c_id)b ON a.c_id = b.c_id
    JOIN (SELECT c_id, SUM(CASE WHEN s_score > 70 AND s_score <= 85
        THEN 1 ELSE 0 END) AS `70-85`,
        ROUND(100*(SUM(CASE WHEN s_score > 70 AND s_score <= 85
        THEN 1 ELSE 0 END) / COUNT(*)), 2) AS 百分比
        FROM score GROUP BY c_id)c ON a.c_id = c.c_id
    JOIN (SELECT c_id, SUM(CASE WHEN s_score > 60 AND s_score <= 70
        THEN 1 ELSE 0 END) AS `60-70`,
        ROUND(100*(SUM(CASE WHEN s_score > 60 AND s_score <= 70 
        THEN 1 ELSE 0 END) / COUNT(*)), 2) AS 百分比
        FROM score GROUP BY c_id)d ON a.c_id = d.c_id
    JOIN (SELECT c_id, SUM(CASE WHEN s_score >= 0 AND s_score <= 60
        THEN 1 ELSE 0 END) AS `0-60`, 
        ROUND(100*(SUM(CASE WHEN s_score >= 0 AND s_score <= 60
        THEN 1 ELSE 0 END) / COUNT(*)), 2) AS 百分比
        FROM score GROUP BY c_id)e ON a.c_id = e.c_id
    JOIN course f ON a.c_id = f.c_id;


-- 终极sql
select distinct f.c_name,a.c_id,b.`85-100`,b.百分比,c.`70-85`,c.百分比,d.`60-70`,d.百分比,e.`0-60`,e.百分比 from score a
        left join (select c_id,SUM(case when s_score >85 and s_score <=100 then 1 else 0 end) as `85-100`,
                                    ROUND(100*(SUM(case when s_score >85 and s_score <=100 then 1 else 0 end)/count(*)),2) as 百分比
                        from score GROUP BY c_id)b on a.c_id=b.c_id
        left join (select c_id,SUM(case when s_score >70 and s_score <=85 then 1 else 0 end) as `70-85`,
                                    ROUND(100*(SUM(case when s_score >70 and s_score <=85 then 1 else 0 end)/count(*)),2) as 百分比
                        from score GROUP BY c_id)c on a.c_id=c.c_id
        left join (select c_id,SUM(case when s_score >60 and s_score <=70 then 1 else 0 end) as `60-70`,
                                    ROUND(100*(SUM(case when s_score >60 and s_score <=70 then 1 else 0 end)/count(*)),2) as 百分比
                        from score GROUP BY c_id)d on a.c_id=d.c_id
        left join (select c_id,SUM(case when s_score >=0 and s_score <=60 then 1 else 0 end) as `0-60`,
                                    ROUND(100*(SUM(case when s_score >=0 and s_score <=60 then 1 else 0 end)/count(*)),2) as 百分比
                        from score GROUP BY c_id)e on a.c_id=e.c_id
        left join course f on a.c_id = f.c_id;

-- 查询结果
/*
+--------+------+--------+-----------+-------+-----------+-------+-----------+------+-----------+
| c_name | c_id | 85-100 | 百分比    | 70-85 | 百分比    | 60-70 | 百分比    | 0-60 | 百分比    |
+--------+------+--------+-----------+-------+-----------+-------+-----------+------+-----------+
| 语文   | 01   |      0 |      0.00 |     3 |     50.00 |     1 |     16.67 |    2 |     33.33 |
| 数学   | 02   |      3 |     50.00 |     1 |     16.67 |     0 |      0.00 |    2 |     33.33 |
| 英语   | 03   |      2 |     33.33 |     2 |     33.33 |     0 |      0.00 |    2 |     33.33 |
+--------+------+--------+-----------+-------+-----------+-------+-----------+------+-----------+
3 rows in set (0.01 sec)

+--------+------+--------+-----------+-------+-----------+-------+-----------+------+-----------+
| c_name | c_id | 85-100 | 百分比    | 70-85 | 百分比    | 60-70 | 百分比    | 0-60 | 百分比    |
+--------+------+--------+-----------+-------+-----------+-------+-----------+------+-----------+
| 语文   | 01   |      0 |      0.00 |     3 |     50.00 |     1 |     16.67 |    2 |     33.33 |
| 数学   | 02   |      3 |     50.00 |     1 |     16.67 |     0 |      0.00 |    2 |     33.33 |
| 英语   | 03   |      2 |     33.33 |     2 |     33.33 |     0 |      0.00 |    2 |     33.33 |
+--------+------+--------+-----------+-------+-----------+-------+-----------+------+-----------+
3 rows in set (0.00 sec)
*/
