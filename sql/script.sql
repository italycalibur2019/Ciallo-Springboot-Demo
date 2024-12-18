-- public.td_user definition

-- Drop table

-- DROP TABLE public.td_user;

CREATE TABLE public.td_user (
                                id int8 NOT NULL, -- 主键ID
                                username varchar(50) NULL, -- 用户名
                                "password" varchar(200) NULL, -- 密码
                                nickname varchar(50) NULL, -- 昵称
                                avatar varchar(1000) NULL, -- 头像
                                CONSTRAINT td_user_pk PRIMARY KEY (id)
);
COMMENT ON TABLE public.td_user IS '用户表';

-- Column comments

COMMENT ON COLUMN public.td_user.id IS '主键ID';
COMMENT ON COLUMN public.td_user.username IS '用户名';
COMMENT ON COLUMN public.td_user."password" IS '密码';
COMMENT ON COLUMN public.td_user.nickname IS '昵称';
COMMENT ON COLUMN public.td_user.avatar IS '头像';

INSERT INTO public.td_user (id, username, "password", nickname, avatar) VALUES(1868911050561159169, 'common', '4d627b911c60b0b48ccee6560d23eb1c', '小林', 'https://avatars.githubusercontent.com/u/52823142');
INSERT INTO public.td_user (id, username, "password", nickname, avatar) VALUES(1868911050561159168, 'admin', '4d627b911c60b0b48ccee6560d23eb1c', '小铭', 'https://avatars.githubusercontent.com/u/44761321');