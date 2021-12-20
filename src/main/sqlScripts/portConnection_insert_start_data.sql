INSERT ALL
    INTO users_roles VALUES (0, 'ADMINISTRATOR')
    INTO users_roles VALUES (1, 'MODERATOR')
    INTO users_roles VALUES (2, 'DISPATCHER')
    INTO users_roles VALUES (3, 'CAPTAIN')
    INTO users_statuses VALUES (0, 'ONLINE')
    INTO users_statuses VALUES (1, 'BLOCKED')
    INTO users_statuses VALUES (2, 'DELETED')
    INTO users_statuses VALUES (3, 'OFFLINE')
    
    INTO statements_statuses VALUES (0, 'CREATED')
    INTO statements_statuses VALUES (1, 'APPROVED')
    INTO statements_statuses VALUES (2, 'REJECTED')
    INTO statements_statuses VALUES (3, 'FINISHED')
    INTO statements_statuses VALUES (4, 'CANCELED')
    INTO statements_types VALUES (0, 'ENTER')
    INTO statements_types VALUES (1, 'EXIT')
    
    INTO users VALUES (0, 'root', '0000', 'root', 3, 0)
    INTO users VALUES (1, 'aleksej', '123', 'Aleksej Vladimirovich Ronzhin', 3, 3)
    
    INTO ships VALUES (0, 1, 'ship_title')
    
    INTO piers VALUES (0, 123, TO_DATE('2021/12/12 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), null)
    INTO piers VALUES (1, 123, TO_DATE('2021/12/12 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), null)
    INTO piers VALUES (2, 123, TO_DATE('2021/12/12 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), null)
    
    INTO goods VALUES ('TESTNAME', 1)
    INTO goods VALUES ('TESTNAME', 1)
    INTO goods VALUES ('TESTNAME', 1)
    INTO goods VALUES ('TESTNAME', 1)
    INTO goods VALUES ('TESTNAME', 1)
    
    INTO statements VALUES (0, 1, 0, 0, 0, 3, TO_DATE('2021/12/12 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2021/12/12 22:02:44', 'yyyy/mm/dd hh24:mi:ss'))
    INTO statements VALUES (1, 1, 0, 0, 1, 3, TO_DATE('2021/12/12 23:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2021/12/12 23:02:44', 'yyyy/mm/dd hh24:mi:ss'))
    INTO statements VALUES (2, 1, 0, 0, 0, 3, TO_DATE('2021/12/13 00:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2021/12/13 01:02:44', 'yyyy/mm/dd hh24:mi:ss'))
    INTO statements VALUES (3, 1, 0, 0, 1, 3, TO_DATE('2021/12/13 02:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2021/12/13 03:02:44', 'yyyy/mm/dd hh24:mi:ss'))
    
    INTO statements VALUES (4, 1, 0, 1, 0, 3, TO_DATE('2020/12/12 23:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2021/12/12 23:02:44', 'yyyy/mm/dd hh24:mi:ss'))
    INTO statements VALUES (5, 1, 0, 1, 1, 3, TO_DATE('2020/12/13 00:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2021/12/13 01:02:44', 'yyyy/mm/dd hh24:mi:ss'))
    INTO statements VALUES (6, 1, 0, 1, 0, 3, TO_DATE('2020/12/13 02:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2021/12/13 04:02:44', 'yyyy/mm/dd hh24:mi:ss'))
    
    INTO statements VALUES (7, 1, 0, 2, 0, 3, TO_DATE('2020/12/12 23:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2021/12/12 23:02:44', 'yyyy/mm/dd hh24:mi:ss'))
    INTO statements VALUES (8, 1, 0, 2, 1, 3, TO_DATE('2020/12/13 00:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2021/12/13 01:02:44', 'yyyy/mm/dd hh24:mi:ss'))
    INTO statements VALUES (9, 1, 0, 2, 0, 3, TO_DATE('2020/12/13 02:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2021/12/13 03:02:44', 'yyyy/mm/dd hh24:mi:ss'))
    INTO statements VALUES (10, 1, 0, 2, 1, 3, TO_DATE('2020/12/13 02:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2021/12/13 03:02:44', 'yyyy/mm/dd hh24:mi:ss'))
SELECT * 
FROM DUAL;

SELECT goods.name AS product_title, pier_id, COUNT(pier_id) AS count, piers.capacity AS pier_capacity, start_date, end_date
FROM goods LEFT JOIN piers ON piers.id = goods.pier_id
GROUP BY goods.name, pier_id, piers.capacity, start_date, end_date;

SELECT pier_ids, pier_capacity, (pier_capacity - COUNT(goods.id)) AS r_c, pier_status
FROM goods RIGHT JOIN (

SELECT DISTINCT piers.id AS pier_ids, piers.capacity AS pier_capacity, 'FREE' AS pier_status
FROM piers LEFT JOIN statements ON statements.pier_id = piers.id
WHERE piers.end_date IS null AND ((SELECT COUNT(statements.id)
        FROM statements
        WHERE statements.status_id = 3 AND statements.type_id = 1 AND statements.pier_id = piers.id) = (SELECT COUNT(statements.id)
                                                                                                    FROM statements
                                                                                                    WHERE statements.status_id = 3 AND statements.type_id = 0 AND statements.pier_id = piers.id))
UNION ALL
SELECT piers.id AS pier_ids, piers.capacity AS pier_capacity, 'BUSY' AS pier_status
FROM piers
WHERE piers.end_date IS null AND ((SELECT COUNT(statements.id)
        FROM statements
        WHERE statements.status_id = 3 AND statements.type_id = 1 AND statements.pier_id = piers.id) != (SELECT COUNT(statements.id)
                                                                                                    FROM statements
                                                                                                    WHERE statements.status_id = 3 AND statements.type_id = 0 AND statements.pier_id = piers.id)))
ON pier_ids = goods.pier_id
GROUP BY pier_ids, pier_capacity, pier_status