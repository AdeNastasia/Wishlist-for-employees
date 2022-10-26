CREATE DATABASE IF NOT EXISTS db_for_holidays
    COLLATE utf8mb4_unicode_ci;

USE db_for_holidays;

CREATE TABLE wish (
    id INT PRIMARY KEY AUTO_INCREMENT,
    wish VARCHAR(255)
);

CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(15),
    surname VARCHAR(25),
    birth_day INT,
    birth_month VARCHAR(10),
    wish_id INT,
    FOREIGN KEY (wish_id) REFERENCES db_for_holidays.wish(id)
);

