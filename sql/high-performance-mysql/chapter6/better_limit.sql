SELECT film_id, description FROM sakila.film ORDER BY title LIMIT 50, 5 \G;

EXPLAIN SELECT film_id, description FROM sakila.film ORDER BY title LIMIT 50, 5 \G;

SELECT film.film_id, film.description 
FROM sakila.film
    INNER JOIN (
        SELECT film.film_id FROM sakila.film
        ORDER BY title LIMIT 50, 5)
AS lim USING(film_id) \G;

EXPLAIN SELECT film.film_id, film.description 
FROM sakila.film
    INNER JOIN (
        SELECT film.film_id FROM sakila.film
        ORDER BY title LIMIT 50, 5)
AS lim USING(film_id) \G;

SELECT film_id, description FROM sakila.film
WHERE position BETWEEN 50 AND 54 ORDER BY position;

EXPLAIN SELECT film_id, description FROM sakila.film
WHERE position BETWEEN 50 AND 54 ORDER BY position \G;
