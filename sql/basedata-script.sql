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
