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

INSERT INTO public.td_user (id, username, "password", nickname, avatar) VALUES(1868929727973167104, 'yoshiro', '4d627b911c60b0b48ccee6560d23eb1c', '芳乃', 'https://ciallo-admin.oss-cn-chengdu.aliyuncs.com/default_avatar.jpg');

-- public.td_role definition

-- Drop table

-- DROP TABLE public.td_role;

CREATE TABLE public.td_role (
                                id int8 NOT NULL, -- 主键
                                "name" varchar(50) NULL, -- 角色名
                                description varchar(500) NULL, -- 角色描述
                                code varchar(50) NULL, -- 角色编号
                                CONSTRAINT td_role_pk PRIMARY KEY (id)
);
COMMENT ON TABLE public.td_role IS '角色表';

-- Column comments

COMMENT ON COLUMN public.td_role.id IS '主键';
COMMENT ON COLUMN public.td_role."name" IS '角色名';
COMMENT ON COLUMN public.td_role.description IS '角色描述';
COMMENT ON COLUMN public.td_role.code IS '角色编号';

INSERT INTO public.td_role (id, "name", description, code) VALUES(1, '管理员', '拥有最高权限', 'admin');
INSERT INTO public.td_role (id, "name", description, code) VALUES(2, '普通用户', '部分权限受限制', 'common');

-- public.td_menu definition

-- Drop table

-- DROP TABLE public.td_menu;

CREATE TABLE public.td_menu (
                                id int8 NOT NULL, -- 主键
                                "path" varchar(100) NULL, -- 路径
                                "name" varchar(100) NULL, -- 菜单名称
                                title varchar(100) NULL, -- 标题
                                parent_id int8 DEFAULT 0 NULL, -- 父级菜单id
                                icon varchar(50) NULL, -- 菜单图标
                                component varchar(100) NULL, -- 组件
                                CONSTRAINT td_menu_pk PRIMARY KEY (id)
);
COMMENT ON TABLE public.td_menu IS '菜单表';

-- Column comments

COMMENT ON COLUMN public.td_menu.id IS '主键';
COMMENT ON COLUMN public.td_menu."path" IS '路径';
COMMENT ON COLUMN public.td_menu."name" IS '菜单名称';
COMMENT ON COLUMN public.td_menu.title IS '标题';
COMMENT ON COLUMN public.td_menu.parent_id IS '父级菜单id';
COMMENT ON COLUMN public.td_menu.icon IS '菜单图标';
COMMENT ON COLUMN public.td_menu.component IS '组件';

INSERT INTO public.td_menu (id, "path", "name", title, parent_id, icon, component) VALUES(1, '/system', NULL, '系统管理', 0, 'ep:setting', NULL);
INSERT INTO public.td_menu (id, "path", "name", title, parent_id, icon, component) VALUES(11, '/system/user', 'User', '用户管理', 1, NULL, 'system/user');
INSERT INTO public.td_menu (id, "path", "name", title, parent_id, icon, component) VALUES(12, '/system/role', 'Role', '角色管理', 1, NULL, 'system/role');
INSERT INTO public.td_menu (id, "path", "name", title, parent_id, icon, component) VALUES(13, '/system/menu', 'SysMenu', '菜单管理', 1, NULL, 'system/menu');

-- public.t_user_role definition

-- Drop table

-- DROP TABLE public.t_user_role;

CREATE TABLE public.t_user_role (
                                    user_id int8 NULL, -- 用户id
                                    role_id int8 NULL, -- 角色id
                                    id int8 NOT NULL, -- 主键
                                    CONSTRAINT t_user_role_pk PRIMARY KEY (id)
);
COMMENT ON TABLE public.t_user_role IS '用户角色关系';

-- Column comments

COMMENT ON COLUMN public.t_user_role.user_id IS '用户id';
COMMENT ON COLUMN public.t_user_role.role_id IS '角色id';
COMMENT ON COLUMN public.t_user_role.id IS '主键';

INSERT INTO public.t_user_role (user_id, role_id, id) VALUES(1868929727973167104, 1, 114514);

-- public.td_permission definition

-- Drop table

-- DROP TABLE public.td_permission;

CREATE TABLE public.td_permission (
                                      role_id int8 NULL, -- 角色id
                                      menu_id int8 NULL, -- 菜单id
                                      id int8 NOT NULL, -- 主键
                                      CONSTRAINT td_permission_pk PRIMARY KEY (id)
);
COMMENT ON TABLE public.td_permission IS '角色权限表';

-- Column comments

COMMENT ON COLUMN public.td_permission.role_id IS '角色id';
COMMENT ON COLUMN public.td_permission.menu_id IS '菜单id';
COMMENT ON COLUMN public.td_permission.id IS '主键';

INSERT INTO public.td_permission (role_id, menu_id, id) VALUES(1, 1, 111);
INSERT INTO public.td_permission (role_id, menu_id, id) VALUES(1, 11, 112);
INSERT INTO public.td_permission (role_id, menu_id, id) VALUES(1, 12, 113);
INSERT INTO public.td_permission (role_id, menu_id, id) VALUES(1, 13, 114);