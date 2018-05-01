SELECT film_id, actor_id FROM sakila.film_actor
WHERE actor_id = 1 OR film_id = 1;

SELECT film_id, actor_id FROM sakila.film_actor WHERE actor_id = 1
UNION ALL 
SELECT film_id, actor_id FROM sakila.film_actor WHERE film_id = 1
    AND actor_id <> 1;

EXPLAIN SELECT film_id, actor_id FROM sakila.film_actor
WHERE actor_id = 1 OR film_id = 1 \G;
