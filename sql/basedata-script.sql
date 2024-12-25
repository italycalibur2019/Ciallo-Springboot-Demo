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

INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(20, 'George', 'Russell', 63, 'Great Britain', '1998-02-15');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(8, 'Oscar', 'Piastri', 81, 'Australia', '2001-04-06');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(16, 'Logan', 'Sargeant', 2, 'America', '2000-12-31');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(17, 'Valtteri', 'Bottas', 77, 'Finland', '1989-08-28');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(1, 'Max', 'Verstappen', 1, 'Netherlands', '1997-09-30');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(14, 'Daniel', 'Riccaiardo', 3, 'Australia', '1989-07-01');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(7, 'Lando', 'Norris', 4, 'Great Britain', '1999-11-13');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(9, 'Pierre', 'Gasly', 10, 'France', '1996-02-07');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(2, 'Sergio', 'Perez', 11, 'Mexico', '1990-01-26');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(3, 'Fernando', 'Alonso', 14, 'Spain', '1981-07-29');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(4, 'Charles', 'Leclerc', 16, 'Monaco', '1997-10-16');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(6, 'Lance', 'Stroll', 18, 'Canada', '1998-10-29');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(12, 'Kevin', 'Magnussen', 20, 'Denmark', '1992-10-15');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(13, 'Yuki', 'Tsunoda', 22, 'Japan', '2000-05-11');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(11, 'Nico', 'Hulkenberg', 27, 'Germany', '1987-08-19');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(15, 'Alexander', 'Albon', 23, 'Thailand', '1996-03-23');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(18, 'Guanyu', 'Zhou', 24, 'China', '1999-05-30');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(10, 'Esteban', 'Ocon', 31, 'France', '1996-09-17');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(19, 'Lewis', 'Hamilton', 44, 'Great Britain', '1985-01-07');
INSERT INTO basedata.td_driver (id, first_name, last_name, code, country, birthday) VALUES(5, 'Carlos', 'Sainz', 55, 'Spain', '1994-09-01');

-- basedata.td_team definition

-- Drop table

-- DROP TABLE basedata.td_team;

CREATE TABLE basedata.td_team (
                                  id int8 NOT NULL, -- 主键
                                  team_name varchar(100) NULL, -- 车队名称
                                  engine_supplier varchar(100) NULL, -- 引擎制造商
                                  leader varchar(100) NULL, -- 车队领队
                                  CONSTRAINT td_team_pk PRIMARY KEY (id)
);
COMMENT ON TABLE basedata.td_team IS '车队';

-- Column comments

COMMENT ON COLUMN basedata.td_team.id IS '主键';
COMMENT ON COLUMN basedata.td_team.team_name IS '车队名称';
COMMENT ON COLUMN basedata.td_team.engine_supplier IS '引擎制造商';
COMMENT ON COLUMN basedata.td_team.leader IS '车队领队';

INSERT INTO basedata.td_team (id, team_name, engine_supplier, leader) VALUES(1, 'McLaren', 'Mercedes', '-');
INSERT INTO basedata.td_team (id, team_name, engine_supplier, leader) VALUES(2, 'Ferrari', 'Ferrari', '-');
INSERT INTO basedata.td_team (id, team_name, engine_supplier, leader) VALUES(4, 'Mercedes', 'Mercedes', '-');
INSERT INTO basedata.td_team (id, team_name, engine_supplier, leader) VALUES(5, 'Aston Martin', 'Mercedes', '-');
INSERT INTO basedata.td_team (id, team_name, engine_supplier, leader) VALUES(7, 'Haas', 'Ferrari', '-');
INSERT INTO basedata.td_team (id, team_name, engine_supplier, leader) VALUES(9, 'Williams', 'Mercedes', '-');
INSERT INTO basedata.td_team (id, team_name, engine_supplier, leader) VALUES(10, 'Sauber', 'Ferrari', '-');
INSERT INTO basedata.td_team (id, team_name, engine_supplier, leader) VALUES(3, 'Red Bull Racing', 'Honda', '-');
INSERT INTO basedata.td_team (id, team_name, engine_supplier, leader) VALUES(6, 'Alpine', 'Renault', '-');
INSERT INTO basedata.td_team (id, team_name, engine_supplier, leader) VALUES(8, 'RB', 'Honda', '-');