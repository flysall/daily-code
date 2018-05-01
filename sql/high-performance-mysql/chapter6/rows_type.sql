SELECT * FROM sakila.film_actor WHERE film_id = 1;

EXPLAIN SELECT * FROM sakila.film_actor WHERE film_id = 1 \G;

ALTER TABLE sakila.film_actor DROP FOREIGN KEY fk_film_actor_film;
ALTER TABLE sakila.film_actor DROP KEY idx_fk_film_id;

EXPLAIN SELECT * FROM sakila.film_actor WHERE film_id = 1 \G;

SELECT actor_id, COUNT(*) FROM sakila.film_actor GROUP BY actor_id;

EXPLAIN SELECT actor_id, COUNT(*) FROM sakila.film_actor GROUP BY actor_id \G;
