--Таблица 1 : Роли пользователей
CREATE TABLE users_roles
(
    id NUMBER(9) not null,
    title NVARCHAR2(30) not null,
    CONSTRAINT users_roles_pk
        PRIMARY KEY (id)
);

--Таблица 2 : Статусы пользователей
CREATE TABLE users_statuses
(
    id NUMBER(9) not null,
    title NVARCHAR2(30) not null,
    CONSTRAINT users_statuses_pk
        PRIMARY KEY (id)
);

--Таблица 3 : Пользователи
CREATE TABLE users
(
    id NUMBER(9) not null,
    login NVARCHAR2(30) not null,
    password NVARCHAR2(30) not null,
    full_name NVARCHAR2(50) not null,
    status_id NUMBER(9) not null,
    role_id NUMBER(9) not null,
    CONSTRAINT id_users_pk
        PRIMARY KEY (id),
    CONSTRAINT users_roles_fk
        FOREIGN KEY (role_id)
        REFERENCES users_roles(id),
    CONSTRAINT users_statuses_fk
        FOREIGN KEY (status_id)
        REFERENCES users_statuses(id),
    CONSTRAINT users_login_unique UNIQUE (login)
);

--Таблица 4 : Корабли
CREATE TABLE ships
(
    id NUMBER(9) not null,
    user_id NUMBER(9) not null,
    title NVARCHAR2(20) not null,
    CONSTRAINT id_ships_pk
        PRIMARY KEY (id),
    CONSTRAINT ships_user_id_unique UNIQUE (user_id),
    CONSTRAINT ships_users_fk
        FOREIGN KEY (user_id)
        REFERENCES users(id)
);

--Таблица 5 : Пирсы
CREATE TABLE piers
(
    id NUMBER(9) not null,
    capacity NUMBER(20) not null,
    start_date TIMESTAMP not null,
    end_date TIMESTAMP,
    CONSTRAINT id_piers_pk
        PRIMARY KEY (id)  
);

--Таблица 7 : Товары
CREATE TABLE goods
(
    name NVARCHAR2(20) not null,
    pier_id NUMBER(9) not null,
    CONSTRAINT goods_piers_fk
        FOREIGN KEY (pier_id)
        REFERENCES piers(id)
);

--Таблица 8 : Типы заявок
CREATE TABLE statements_types
(
    id NUMBER(9) not null,
    title NVARCHAR2(30) not null,
    CONSTRAINT id_statements_types_pk
        PRIMARY KEY (id)
);

--Таблица 9 : Статусы заявок
CREATE TABLE statements_statuses
(
    id NUMBER(9) not null,
    title NVARCHAR2(30) not null,
    CONSTRAINT id_statements_statuses_pk
        PRIMARY KEY (id)
);

--Таблица 10 : Заявки
CREATE TABLE statements
(
    id NUMBER(9) not null,
    user_id NUMBER(9) not null,
    ship_id NUMBER(9) not null,
    pier_id NUMBER(9),
    type_id NUMBER(9) not null,
    status_id NUMBER(9) not null,
    do_statement_date TIMESTAMP not null,
    finish_statement_date TIMESTAMP,
    CONSTRAINT id_statements_pk
        PRIMARY KEY (id),
    CONSTRAINT statements_users_fk
        FOREIGN KEY (user_id)
        REFERENCES users(id),
    CONSTRAINT statements_ships_fk
        FOREIGN KEY (ship_id)
        REFERENCES ships(id),
    CONSTRAINT statements_types_fk
      FOREIGN KEY (type_id)
      REFERENCES statements_types(id),
    CONSTRAINT statements_statuses_fk
      FOREIGN KEY (status_id)
      REFERENCES statements_statuses(id)  
);