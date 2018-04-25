CREATE TABLE IF NOT EXISTS daily_hit_counter (
    day date NOT NULL,
    slot tinyint unsigned NOT NULL,
    cnt int unsigned NOT NULL,
    PRIMARY KEY(day, slot)
) ENGINE=InnoDB;

INSERT INTO daily_hit_counter(day, slot, cnt)
    VALUES(CURRENT_DATE, RAND() * 100, 1)
    ON DUPLICATE KEY UPDATE cnt = cnt + 1;

SELECT * FROM daily_hit_counter;
SELECT SUM(cnt) FROM daily_hit_counter;
