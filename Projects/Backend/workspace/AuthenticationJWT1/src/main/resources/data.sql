insert into users(USER_ID, USERNAME, EMAIL, PASSWORD, CITY) values
(101, 'Dhananjay Jain', 'dj2@gmail.com','asdf','Pune'),
(102, 'Gaurav Jain', 'gj2@gmail.com','lkjh','Mumbai'),
(103, 'Ram Jain', 'rj2@gmail.com','poiu','Indore');

insert into role(ROLE_ID, ROLENAME) values
(1001,'ADMIN'),
(1002,'SELLER'),
(1003, 'CONSUMER');

insert into user_roles(USER_ID, ROLE_ID) values
(101,1001),
(102,1002),
(103,1003);

insert into category (CATEGORY_ID,CATEGORY_NAME) values
(10001,'Fashion'),
(20001,'Electronics'),
(30001,'Books'),
(40001,'Groceries'),
(50001,'Medicines');

insert into cart (CART_ID, TOTAL_AMOUNT, USER_ID) values
(11,210,103),
(12,150000,101);

insert into product (PRODUCT_ID, PRODUCT_NAME, PRICE,CATEGORY_ID, USER_ID) values
(11,'Apple 15 pro', 150000, 20001, 102),
(12,'The 5 AM Club', 200, 30001, 102),
(13,'Dolo', 10, 50001, 102);

insert into cart_product(CART_PRODUCT_ID, PRODUCT_ID,QUANTITY) values
(11,12,1),
(12,13,1),
(13,11,1);

