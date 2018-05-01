CREATE TABLE IF NOT EXISTS pseudohash (
    id int unsigned NOT NULL auto_increment,
    url varchar(255) NOT NULL,
    url_crc int unsigned NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);

DELIMITER //

CREATE TRIGGER pseudohash_crc_ins BEFORE INSERT ON pseudohash FOR EACH ROW BEGIN
SET NEW.url_crc=crc32(NEW.url);
END;
//

CREATE TRIGGER pesudohash_crc_upd BEFORE UPDATE ON pseudohash FOR EACH ROW BEGIN
SET NEW.url_crc=crc32(NEW.url);
END;
//

DELIMITER ;

INSERT INTO pseudohash(url) VALUES ('http://www.mysql.com');
SELECT * FROM pseudohash;

UPDATE pseudohash SET url='http://www.mysql.com/' WHERE id = 1;

SELECT * FROM pseudohash;

SELECT id FROM pseudohash WHERE url_crc=CRC32("http://www.mysql.com");

DROP TABLE pseudohash;

SELECT CONV(RIGHT(MD5('http://www.mysql.com/'), 16), 16, 10) AS HASH64;
