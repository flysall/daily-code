SELECT SQL_NO_CACHE COUNT(*) FROM sakila.film_actor;
SHOW STATUS  LIKE 'Last_query_cost';
EXPLAIN SELECT SQL_NO_CACHE COUNT(*) FROM sakila.film_actor \G; 

SELECT film.film_id, film_actor.actor_id
FROM sakila.film
INNER JOIN sakila.film_actor USING(film_id)
WHERE film.film_id = 1;

EXPLAIN SELECT film.film_id, film_actor.actor_id
FROM sakila.film
INNER JOIN sakila.film_actor USING(film_id)
WHERE film.film_id = 1 \G;

SELECT film.film_id FROM sakila.film WHERE film_id = -1;
EXPLAIN SELECT film.film_id FROM sakila.film WHERE film_id = -1 \G;

SELECT film.film_id
FROM sakila.film
    LEFT JOIN sakila.film_actor USING(film_id)
WHERE film_actor.film_id IS NULL;

SELECT film.film_id
FROM sakila.film
    INNER JOIN sakila.film_actor USING(film_id)
WHERE film.film_id > 500;    

EXPLAIN SELECT film.film_id
FROM sakila.film
    INNER JOIN sakila.film_actor USING(film_id)
WHERE film.film_id > 500 \G;
