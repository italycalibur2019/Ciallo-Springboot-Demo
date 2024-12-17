-- public.td_user definition

-- Drop table

-- DROP TABLE public.td_user;

CREATE TABLE public.td_user (
                                id int8 NOT NULL,
                                username varchar(50) NULL,
                                "password" varchar(200) NULL,
                                nickname varchar(50) NULL,
                                avatar varchar(1000) NULL,
                                CONSTRAINT td_user_pk PRIMARY KEY (id)
);

INSERT INTO public.td_user (id, username, "password", nickname, avatar) VALUES(1868911050561159169, 'common', '4d627b911c60b0b48ccee6560d23eb1c', '小林', 'https://avatars.githubusercontent.com/u/52823142');
INSERT INTO public.td_user (id, username, "password", nickname, avatar) VALUES(1868911050561159168, 'admin', '4d627b911c60b0b48ccee6560d23eb1c', '小铭', 'https://avatars.githubusercontent.com/u/44761321');