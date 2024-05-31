insert into USERS (USER_ID, USER_NAME, EMAIL,CITY,PASSWORD) values
(10001, 'Gaurav','jn2@gmail.com','Pune','ASDFF'),
(10002, 'Dhananjay','dn2@gmail.com','Indore','ALKSDFF');

insert into role(ROLE_ID,ROLE_NAME) values 
(101,'SELLER'),
(102,'CONSUMER');

insert into user_roles(ROLE_ID,USER_ID) values
(101,10001),
(102,10002);