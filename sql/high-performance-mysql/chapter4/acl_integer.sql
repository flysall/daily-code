SET @CAN_READ := 1 << 0,
    @CAN_WRITE := 1 <<1,
    @CAN_DELETE := 1 << 2;

CREATE TABLE acl_int (
    perms TINYINT UNSIGNED NOT NULL DEFAULT 0
);

INSERT INTO acl_int(perms) VALUES
(
    @CAN_READ + @CAN_DELETE
);

SELECT perms FROM acl_int WHERE perms & @CAN_READ;
