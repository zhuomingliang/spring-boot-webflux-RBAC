create table sys_user
(
    id          bigserial    not null
        constraint my_user_pkey
            primary key,
    username    varchar(64)  not null
        constraint my_user_username_key
            unique,
    password    varchar(254) not null,
    authorities varchar(254)
);

alter table sys_user
    owner to postgres;

INSERT INTO public.sys_user (id, username, password, authorities) VALUES (2, 'admin', 'admin', 'authorities');
INSERT INTO public.sys_user (id, username, password, authorities) VALUES (4, 'admin2', '{bcrypt}$2a$10$5GNdViXJLfnUMK0ZeAJ0tej7RXF0HkoML/hkMJO7DDTQTMfdwv6ta', 'authorities');
INSERT INTO public.sys_user (id, username, password, authorities) VALUES (6, 'user', '{bcrypt}$2a$10$sGFtea5wKPaiSUiH0RX0qOgxqDJDKlzBVIlVvvPD2a91Y.ZP5TVuy', 'authorities');