SELECT actor_id FROM sakila.actor
WHERE actor_id > 45;

EXPLAIN SELECT actor_id FROM sakila.actor
WHERE actor_id > 45 \G;

SELECT actor_id FROM sakila.actor
WHERE actor_id IN(1, 4, 99);

EXPLAIN SELECT actor_id FROM sakila.actor
WHERE actor_id IN(1, 4, 99) \G; 
