create table sys_users_roles
(
    user_id bigint,
    role_id integer,
    constraint sys_users_roles_user_id_role_id_key
        unique (user_id, role_id)
);

alter table sys_users_roles
    owner to postgres;

INSERT INTO public.sys_users_roles (user_id, role_id) VALUES (6, 1);