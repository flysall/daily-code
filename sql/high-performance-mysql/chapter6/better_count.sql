SELECT COUNT(*) FROM world.city WHERE ID > 5;

EXPLAIN SELECT COUNT(*) FROM world.city WHERE ID > 5 \;

SELECT (SELECT COUNT(*) FROM world.city) - COUNT(*)
FROM world.city WHERE ID <= 5;

EXPLAIN SELECT (SELECT COUNT(*) FROM world.city) - COUNT(*)
FROM world.city WHERE ID <= 5 \G;
