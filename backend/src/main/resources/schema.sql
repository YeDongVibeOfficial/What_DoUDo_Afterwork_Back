Drop TABLE IF EXISTS tour_info;

CREATE TABLE tour_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    plcode INT,
    plTitle VARCHAR(255) NOT Null,
    plAddrBasic VARCHAR(255) NOT Null,
    plAddrDetail VARCHAR(255),
    plTel VARCHAR(50000) NOT Null,
    plImg VARCHAR(255) NOT Null,
    plMapX DOUBLE NOT Null,
    plMapY DOUBLE NOT Null
);
