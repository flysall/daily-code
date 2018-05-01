SELECT rental_id, staff_id FROM sakila.rental
WHERE rental_date = '2005-05-25'
ORDER BY inventory_id, customer_id;

EXPLAIN SELECT rental_id, staff_id FROM sakila.rental
WHERE rental_date = '2005-05-25'
ORDER BY inventory_id, customer_id \G;

SELECT actor_id, title FROM sakila.film_actor
INNER JOIN sakila.film USING(film_id) ORDER BY actor_id;

EXPLAIN SELECT actor_id, title FROM sakila.film_actor
INNER JOIN sakila.film USING(film_id) ORDER BY actor_id \G;

