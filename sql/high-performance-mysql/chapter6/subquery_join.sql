SELECT * FROM sakila.film
WHERE film_id IN(
    SELECT film_id FROM sakila.film_actor WHERE actor_id = 1) \G;

EXPLAIN SELECT * FROM sakila.film
WHERE film_id IN(
    SELECT film_id FROM sakila.film_actor WHERE actor_id = 1) \G;

SELECT * FROM sakila.film
WHERE EXISTS(
    SELECT * FROM sakila.film_actor WHERE actor_id = 1
    AND sakila.film_actor.film_id = film.film_id) \G;

EXPLAIN SELECT * FROM sakila.film
WHERE EXISTS(
    SELECT * FROM sakila.film_actor WHERE actor_id = 1
    AND sakila.film_actor.film_id = film.film_id) \G;
