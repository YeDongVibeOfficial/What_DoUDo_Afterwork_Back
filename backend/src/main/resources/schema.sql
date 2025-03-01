CREATE TABLE IF NOT EXISTS tour_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    plcode INT,
    plTitle VARCHAR(255),
    plAddrBasic VARCHAR(255),
    plAddrDetail VARCHAR(255),
    plTel VARCHAR(50),
    plImg VARCHAR(255),
    plMapX DOUBLE,
    plMapY DOUBLE
);
