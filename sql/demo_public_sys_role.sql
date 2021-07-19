create table sys_role
(
    id   serial not null
        constraint sys_role_pkey
            primary key,
    name varchar(32)
);

alter table sys_role
    owner to postgres;

INSERT INTO public.sys_role (id, name) VALUES (1, '用户');