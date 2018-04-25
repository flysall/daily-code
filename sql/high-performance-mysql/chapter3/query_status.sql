FLUSH STATUS;
SELECT * FROM hahu.user \G;
SHOW STATUS WHERE Variable_name LIKE 'Handler%'
    OR Variable_name LIKE 'Created%';
