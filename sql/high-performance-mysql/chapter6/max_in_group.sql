SELECT actor_id, MAX(film_id)
FROM sakila.film_actor
GROUP BY actor_id;

EXPLAIN SELECT actor_id, MAX(film_id)
FROM sakila.film_actor
GROUP BY actor_id \G;

SELECT MIN(actor_id) FROM sakila.actor WHERE first_name = 'PENELOPE';

EXPLAIN SELECT MIN(actor_id) FROM sakila.actor WHERE first_name = 'PENELOPE' \G;

SELECT actor_id FROM sakila.actor USE INDEX(PRIMARY)
WHERE first_name = 'PENELOPE' LIMIT 1;

EXPLAIN SELECT actor_id FROM sakila.actor USE INDEX(PRIMARY)
WHERE first_name = 'PENELOPE' LIMIT 1 \G;

