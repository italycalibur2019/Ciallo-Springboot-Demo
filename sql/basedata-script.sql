-- DROP SCHEMA basedata;

CREATE SCHEMA basedata AUTHORIZATION postgres;

-- basedata.td_driver definition

-- Drop table

-- DROP TABLE basedata.td_driver;

CREATE TABLE basedata.td_driver (
                                    id int8 NOT NULL, -- 主键
                                    first_name varchar(100) NULL, -- 名字
                                    last_name varchar(100) NULL, -- 姓氏
                                    code int4 NULL, -- 车手编号
                                    country varchar(100) NULL, -- 国家
                                    CONSTRAINT td_driver_pk PRIMARY KEY (id)
);
COMMENT ON TABLE basedata.td_driver IS '车手';

-- Column comments

COMMENT ON COLUMN basedata.td_driver.id IS '主键';
COMMENT ON COLUMN basedata.td_driver.first_name IS '名字';
COMMENT ON COLUMN basedata.td_driver.last_name IS '姓氏';
COMMENT ON COLUMN basedata.td_driver.code IS '车手编号';
COMMENT ON COLUMN basedata.td_driver.country IS '国家';


INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(1, 'Max', 'Verstappen', 1, 'Netherlands');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(2, 'Sergio', 'Perez', 11, 'Mexico');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(3, 'Fernando', 'Alonso', 14, 'Spain');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(4, 'Charles', 'Leclerc', 16, 'Monaco');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(5, 'Carlos', 'Sainz', 55, 'Spain');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(6, 'Lance', 'Stroll', 18, 'Canada');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(7, 'Lando', 'Norris', 4, 'Great Britain');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(8, 'Oscar', 'Piastri', 81, 'Australia');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(9, 'Pierre', 'Gasly', 10, 'France');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(10, 'Esteban', 'Ocon', 31, 'France');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(11, 'Nico', 'Hulkenberg', 27, 'Germany');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(12, 'Kevin', 'Magnussen', 20, 'Denmark');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(13, 'Yuki', 'Tsunoda', 22, 'Japan');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(14, 'Daniel', 'Riccaiardo', 3, 'Australia');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(15, 'Alexander', 'Albon', 23, 'Thailand');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(16, 'Logan', 'Sargeant', 2, 'America');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(17, 'Valtteri', 'Bottas', 77, 'Finland');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(18, 'Guanyu', 'Zhou', 24, 'China');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(19, 'Lewis', 'Hamilton', 44, 'Great Britain');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country) VALUES(20, 'George', 'Russell', 63, 'Great Britain');