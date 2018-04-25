CREATE TABLE IF NOT EXISTS hit_counter (
    slot tinyint unsigned NOT NULL PRIMARY KEY,
    nt int unsigned NOT NULL
) ENGINE=InnoDB;

UPDATE hit_counter SET cnt = cnt + 1 WHERE slot = RAND() * 100;

SELECT SUM(cnt) FROM hit_counter;
