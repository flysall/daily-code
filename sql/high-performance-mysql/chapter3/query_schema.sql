SET @query_id = 2; 
SELECT STATE, SUM(DURATION) AS Total_R,
    ROUND(
        100 * SUM(DURATION) / 
            (SELECT SUM(DURATION)
                FROM information_schema.profiling
                WHERE QUERY_ID = @query_id
            ), 2) AS Pct_R,
    COUNT(*) AS Calls,
    SUM(DURATION) / COUNT(*) AS "R/CALL"
FROM information_schema.profiling
WHERE QUERY_ID = @query_id
GROUP BY STATE
ORDER BY Total_R DESC;

