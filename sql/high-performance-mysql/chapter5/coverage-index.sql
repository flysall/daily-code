EXPLAIN SELECT store_id, film_id FROM sakila.inventory \G;

EXPLAIN SELECT *  FROM sakila.products WHERE actor='SEAN CAREY'
AND title LIKE '%APOLLO%' \G;

EXPLAIN SELECT * FROM sakila.products
    JOIN (
        SELECT prod_id FROM products
        WHERE actor='SEAN CARREY' AND title LIKE '%APOLLO%'
    ) AS t1 ON(t1.prod_id=sakila.products.prod_id) \G;


EXPLAIN SELECT actor_id, last_name
FROM sakila.actor WHERE last_name = 'HOPPER'\G;
