SELECT film.film_id, film.title, film.release_year, actor.actor_id,
    actor.first_name, actor.last_name
    FROM sakila.film
    INNER JOIN sakila.film_actor USING(film_id)
    INNER JOIN sakila.actor USING(actor_id);

EXPLAIN SELECT film.film_id, film.title, film.release_year, actor.actor_id,
    actor.first_name, actor.last_name
    FROM sakila.film
    INNER JOIN sakila.film_actor USING(film_id)
    INNER JOIN sakila.actor USING(actor_id) \G;
