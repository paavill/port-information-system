INSERT ALL
    INTO users_roles VALUES (0, 'ADMINISTRATOR')
    INTO users_roles VALUES (1, 'MODERATOR')
    INTO users_roles VALUES (2, 'DISPATCHER')
    INTO users_roles VALUES (3, 'CAPTAIN')
    INTO users_statuses VALUES (0, 'AUTHORIZED')
    INTO users_statuses VALUES (1, 'UNATHORIZED')
    INTO users_statuses VALUES (2, 'BLOCKED')
    INTO users VALUES (0, 'root', '0000', null, 1, 0)
    INTO users VALUES (1, 'aleksej', '123', 'Aleksej Vladimirovich Ronzhin', 1, 3)
SELECT * 
FROM DUAL;