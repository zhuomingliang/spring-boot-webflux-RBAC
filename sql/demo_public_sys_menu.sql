create table sys_menu
(
    id   serial not null
        constraint sys_menu_pkey
            primary key,
    name varchar(32),
    path varchar(254)
);

alter table sys_menu
    owner to postgres;

INSERT INTO public.sys_menu (id, name, path) VALUES (1, '下载', '/download');