CREATE TABLE IF NOT EXISTS testhash
    fname VARCHAR(50) NOT NULL,
    lname VARCHAR(50) NOT NULL,
    KEY USING HASH(fname)
) ENGINE=MEMORY;

INSERT INTO testhash(fname, lname) VALUES('Arjen', 'Lentz');
INSERT INTO testhash(fname, lname) VALUES('Baron', 'Schwartz');
INSERT INTO testhash(fname, lname) VALUES('Peter', 'Zaitsev');
INSERT INTO testhash(fname, lname) VALUES('Vadim', 'Tkachenko');

SELECT fname, lname FROM testhash;

SELECT lname FROM testhash WHERE fname='Peter';
