insert into users (USER_ID, USERNAME, EMAIL, PASSWORD, CITY) values
(101, 'Dhananjay Jain','dj2@gaiml.com', 'asdfg', 'Pune' ),
(102, 'Gaurav Jain','gj2@gaiml.com', 'zxcvb', 'Indore' );

insert into role (ROLE_ID, ROLE_NAME) values
(1001, 'ADMIN'),
(1002, 'NORMAL');

insert into user_roles (USER_ID, ROLE_ID) values
(101,1001),
(101,1002),
(102,1002);
