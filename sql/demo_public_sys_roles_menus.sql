create table sys_roles_menus
(
    role_id integer,
    menu_id integer,
    constraint sys_roles_menus_role_id_menu_id_key
        unique (role_id, menu_id)
);

alter table sys_roles_menus
    owner to postgres;

INSERT INTO public.sys_roles_menus (role_id, menu_id) VALUES (1, 1);