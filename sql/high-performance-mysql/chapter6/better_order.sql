SELECT actor_id, COUNT(*) AS cnt
FROM sakila.film_actor
GROUP BY actor_id
ORDER BY cnt DESC
LIMIT 10;

EXPLAIN SELECT actor_id, COUNT(*) AS cnt
FROM sakila.film_actor
GROUP BY actor_id
ORDER BY cnt DESC
LIMIT 10 \G;

SET @curr_cnt := 0, @prev_cnt := 0, @rank :=  0;
SELECT actor_id,
    @curr_cnt := cnt AS cnt,
    @rank := IF(@prev_cnt <> @curr_cnt, @rank+1, @rank) AS rank,
    @prev_cnt := @curr_cnt AS dummy
FROM (
    SELECT actor_id, COUNT(*) AS cnt
    FROM sakila.film_actor
    GROUP BY actor_id
    ORDER BY cnt DESC
    LIMIT 10
) AS der;
