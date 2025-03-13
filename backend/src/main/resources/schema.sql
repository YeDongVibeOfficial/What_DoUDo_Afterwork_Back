-- Drop TABLE IF EXISTS tour_info;
-- DROP TABLE IF EXISTS BOARD;

CREATE TABLE IF NOT EXISTS tour_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    plcode INT,
    plTitle VARCHAR(255) NOT Null,
    plAddrBasic VARCHAR(255) NOT Null,
    plAddrDetail VARCHAR(255),
    plTel VARCHAR(50) NOT Null,
    plImg VARCHAR(255) NOT Null,
    plMapX DOUBLE NOT Null,
    plMapY DOUBLE NOT Null
);

CREATE TABLE IF NOT EXISTS BOARD(
    boardId Long AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR (50) NOT Null,
    content VARCHAR (50) NOT Null,
    name VARCHAR (50) NOT Null
)

