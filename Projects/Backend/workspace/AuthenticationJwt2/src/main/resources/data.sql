insert into users(USER_ID, FIRST_NAME, LAST_NAME,EMAIL, PASSWORD, STREET_NAME,SOCIETY_NAME,CITY,ZIP_CODE) values
(101,'Dhananjay','Jain','dj@gmail.com','poilkj','Sakri Road','Opus76','Pune','411057'),
(102,'Gaurav','Jain','gj@gmail.com','asdf','Shirpur Road','Opus77','Nashik','411058'),
(103,'Ram','Jain','rj@gmail.com','zxcv','Jalgoan Road','Opus78','Dhule','411059');

insert into role(ROLE_ID, ROLE_NAME) values
(1001, 'ADMIN'),
(1002,'SELLER'),
(1003,'CONSUMER');

insert into user_roles(USER_ID, ROLE_ID) values
(101,1001),
(102,1002),
(103,1003);