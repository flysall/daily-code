SELECT actor.first_name, actor.last_name, COUNT(*)
FROM sakila.film_actor
    INNER JOIN sakila.actor USING(actor_id)
GROUP BY actor.first_name, actor.last_name;

EXPLAIN SELECT actor.first_name, actor.last_name, COUNT(*)
FROM sakila.film_actor
    INNER JOIN sakila.actor USING(actor_id)
GROUP BY actor.first_name, actor.last_name \G;

SELECT actor.first_name, actor.last_name, COUNT(*)
FROM sakila.film_actor
    INNER JOIN sakila.actor USING(actor_id)
    GROUP BY film_actor.actor_id;

EXPLAIN SELECT actor.first_name, actor.last_name, COUNT(*)
FROM sakila.film_actor
    INNER JOIN sakila.actor USING(actor_id)
    GROUP BY film_actor.actor_id \G;

SELECT actor.first_name, actor.last_name, c.cnt
FROM sakila.actor
    INNER JOIN (
        SELECT actor_id, COUNT(*) AS cnt
        FROM sakila.film_actor
        GROUP BY actor_id
    ) AS c USING(actor_id);

EXPLAIN SELECT actor.first_name, actor.last_name, c.cnt
FROM sakila.actor
    INNER JOIN (
        SELECT actor_id, COUNT(*) AS cnt
        FROM sakila.film_actor
        GROUP BY actor_id
    ) AS c USING(actor_id) \G;
