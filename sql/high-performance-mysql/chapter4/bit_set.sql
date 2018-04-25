CREATE TABLE IF NOT EXISTS bittest(
    a bit(8)
);

INSERT INTO bittest VALUES (b'00111001');

SELECT a, a + 0 FROM bittest;
