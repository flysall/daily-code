SELECT film_id, language_id FROM sakila.film
WHERE NOT EXISTS(
    SELECT * FROM sakila.film_actor
    WHERE film_actor.film_id = film.film_id
);

EXPLAIN SELECT film_id, language_id FROM sakila.film
WHERE NOT EXISTS(
    SELECT * FROM sakila.film_actor
    WHERE film_actor.film_id = film.film_id
) \G;


SELECT film.film_id, film.language_id
FROM sakila.film
    LEFT OUTER JOIN sakila.film_actor USING(film_id)
WHERE film_actor.film_id IS NULL;  

EXPLAIN SELECT film.film_id, film.language_id
FROM sakila.film
    LEFT OUTER JOIN sakila.film_actor USING(film_id)
WHERE film_actor.film_id IS NULL \G;


SELECT film.film_id FROM sakila.film
    INNER JOIN sakila.film_actor USING(film_id);

SELECT DISTINCT film.film_id FROM sakila.film
    INNER JOIN sakila.film_actor USING(film_id);

EXPLAIN SELECT DISTINCT film.film_id FROM sakila.film
    INNER JOIN sakila.film_actor USING(film_id) \G; 

EXPLAIN SELECT film_id FROM sakila.film
    WHERE EXISTS(SELECT * FROM sakila.film_actor
        WHERE film.film_id = film_actor.film_id) \G;
