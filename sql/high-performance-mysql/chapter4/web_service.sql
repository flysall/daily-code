CREATE TABLE IF NOT EXISTS webservicecalls(
    day date NOT NULL,
    account smallint NOT NULL,
    service varchar(10) NOT NULL,
    method varchar(50) NOT NULL,
    calls int NOT NULL,
    items int NOT NULL,
    time float NOT NULL,
    cost decimal(9, 5) NOT NULL,
    updated datetime,
    PRIMARY KEY (day, account, service, method)
) ENGINE = InnoDB;
