CREATE TABLE IF NOT EXISTS sakila.city_demo(
    city VARCHAR(50) NOT NULL
);

INSERT INTO sakila.city_demo(city) SELECT city FROM sakila.city;

INSERT INTO sakila.city_demo(city) SELECT city FROM sakila.city_demo;
INSERT INTO sakila.city_demo(city) SELECT city FROM sakila.city_demo;
INSERT INTO sakila.city_demo(city) SELECT city FROM sakila.city_demo;
INSERT INTO sakila.city_demo(city) SELECT city FROM sakila.city_demo;
INSERT INTO sakila.city_demo(city) SELECT city FROM sakila.city_demo;

UPDATE sakila.city_demo 
    SET city = (SELECT city FROM sakila.city ORDER BY RAND() LIMIT 1);

SELECT COUNT(*) AS cnt, LEFT(city, 3) AS pref
FROM sakila.city_demo GROUP BY pref ORDER BY cnt DESC LIMIT 10;

SELECT COUNT(*) AS cnt, LEFT(city, 3) AS pref
FROM sakila.city_demo GROUP BY pref ORDER BY cnt DESC LIMIT 10;

SELECT COUNT(*) AS cnt, LEFT(city, 7) AS pref
FROM sakila.city_demo GROUP BY pref ORDER BY cnt DESC LIMIT 10;

SELECT COUNT(DISTINCT city)/COUNT(*) FROM sakila.city_demo;

SELECT COUNT(DISTINCT LEFT(city, 3))/COUNT(*) AS sel3,
    COUNT(DISTINCT LEFT(city, 4))/COUNT(*) AS sel4,
    COUNT(DISTINCT LEFT(city, 5))/COUNT(*) AS sel5,
    COUNT(DISTINCT LEFT(city, 6))/COUNT(*) AS sel6,
    COUNT(DISTINCT LEFT(city, 7))/COUNT(*) AS sel7
    FROM sakila.city_demo;

DROP TABLE sakila.city_demo;
