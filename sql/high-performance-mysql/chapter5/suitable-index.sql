SELECT * FROM sakila.payment WHERE staff_id = 2 AND customer_id = 584;

SELECT SUM(staff_id = 2), SUM(customer_id = 584) FROM sakila.payment;

SELECT SUM(staff_id = 2) FROM sakila.payment WHERE customer_id = 584;

SELECT COUNT(DISTINCT staff_id)/COUNT(*) AS staff_id_selectivity,
COUNT(DISTINCT customer_id)/COUNT(*) AS customer_id_selectivity,
COUNT(*) FROM sakila.payment;
