INSERT ALL
    INTO users_roles VALUES (0, 'ADMINISTRATOR')
    INTO users_roles VALUES (1, 'MODERATOR')
    INTO users_roles VALUES (2, 'DISPATCHER')
    INTO users_roles VALUES (3, 'CAPTAIN')
    INTO users_statuses VALUES (0, 'ACTIVE')
    INTO users_statuses VALUES (1, 'BLOCKED')
    INTO users_statuses VALUES (2, 'DELETED')
    INTO users VALUES (0, 'root', '0000', null, 0, 0)
    INTO users VALUES (1, 'aleksej', '123', 'Aleksej Vladimirovich Ronzhin', 0, 3)
SELECT * 
FROM DUAL;