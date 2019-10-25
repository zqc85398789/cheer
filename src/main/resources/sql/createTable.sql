CREATE DATABASE cheer;

DROP TABLE user;

-- 员工表
CREATE TABLE user(
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(30) NOT NULL UNIQUE,
password VARCHAR(30) NOT NULL,
legal_name VARCHAR(20) NOT NULL,
birth_date DATE,
gender CHAR(1),
tel_no VARCHAR(20),
dimission_date Date,
empno CHAR(6), #编号，结构为字母+5位数字，A、B、T、E分别表示管理员、老板、组长、员工
permission char(10) NOT NULL DEFAULT 'nomal',
create_by varchar(30) NOT NULL,
create_time DATETIME NOT NULL,
update_by varchar(30),
update_time DATETIME,
version INT DEFAULT 1 NOT NULL
);


DROP TABLE income;

-- 收入表
CREATE TABLE income(
id INT PRIMARY KEY AUTO_INCREMENT,
item VARCHAR(100) NOT NULL,
income_source VARCHAR(100) NOT NULL,
received_by VARCHAR(30) NOT NULL,
amount DECIMAL(10,2) NOT NULL,
received_time DATETIME NOT NULL,
create_by varchar(30) NOT NULL,
create_time DATETIME NOT NULL,
update_by varchar(30),
update_time DATETIME,
version INT DEFAULT 1 NOT NULL
);

DROP TABLE expense;

-- 支出表
CREATE TABLE expense(
id INT PRIMARY KEY AUTO_INCREMENT,
item VARCHAR(100) NOT NULL,
expensed_to VARCHAR(100) NOT NULL,
expensed_by VARCHAR(30) NOT NULL,
amount DECIMAL(10,2) NOT NULL,
expensed_time DATETIME NOT NULL,
create_by varchar(30) NOT NULL,
create_time DATETIME NOT NULL,
update_by varchar(30),
update_time DATETIME,
version INT DEFAULT 1 NOT NULL
);