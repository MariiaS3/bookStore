CREATE TABLE `account` (
    `id`  UUID  NOT NULL PRIMARY KEY,
    `name`  VARCHAR NOT NULL,
    `email` VARCHAR NOT NULL,
    `password`  VARCHAR NOT NULL
);