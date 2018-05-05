SET @rownum := 0;
SELECT actor_id, @rownum := @rownum + 1 AS cnt
FROM sakila.actor
WHERE @rownum <= 1;


SET @rownum := 0;
SELECT actor_id, @rownum := @rownum + 1 AS cnt
FROM sakila.actor
WHERE @rownum <= 1
ORDER BY first_name;

SET @rownum := 0;
SELECT actor_id, @rownum AS rownum
FROM sakila.actor
WHERE (@rownum := @rownum + 1) <= 1;

SET @rownum := 0;
SELECT actor_id, first_name,  @rownum AS rownum
FROM sakila.actor
WHERE @rownum <= 1
ORDER BY first_name, LEAST(0, @rownum := @rownum + 1);

