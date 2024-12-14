-- public.td_user_seq definition

-- DROP SEQUENCE public.td_user_seq;

CREATE SEQUENCE public.td_user_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 6000001
	CACHE 1
	NO CYCLE;

-- public.td_user definition

-- Drop table

-- DROP TABLE public.td_user;

CREATE TABLE public.td_user (
                                id int8 DEFAULT nextval('td_user_seq'::regclass) NULL,
                                username varchar(50) NULL,
                                "password" varchar(200) NULL,
                                nickname varchar(50) NULL,
                                avatar varchar(1000) NULL,
                                CONSTRAINT td_user_unique UNIQUE (id)
);