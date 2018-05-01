SET AUTOCOMMIT=0;
BEGIN;
    SELECT actor_id FROM sakila.actor WHERE actor_id < 5
    AND actor_id <> 1 FOR UPDATE;

EXPLAIN SELECT actor_id FROM sakila.actor WHERE actor_id < 5
    AND actor_id <> 1 FOR UPDATE \G;
    
SET AUTOCOMMIT=0;
BEGIN;
    SELECT actor_id FROM sakila.actor WHERE actor_id = 1
    FOR UPDATE;
