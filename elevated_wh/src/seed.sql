-- This is the seed file to populate our database with the information provided
-- by the owner of the actual shop whose warehouse we are modelling
-- in cases where data wasn't provided, we made up data (ie customers and orders)

-- populate the Product table with samples

insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(product_counter.nextval,'Sativa Tincture',30,'mL',20,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(product_counter.nextval,'Indica Tincture',30,'mL',19,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(product_counter.nextval,'Extra Strength Tincture',30,'mL',50,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(product_counter.nextval,'Headache Rollon',10,'mL',40,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(product_counter.nextval,'Sleep Rollon',10,'mL',40,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(product_counter.nextval,'Cannabis Spray',200,'mL',80,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(product_counter.nextval,'30 CBD Tincture',30,'mL',40,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(product_counter.nextval,'100ml Cannabis Healing Salve',100,'mL',80,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(product_counter.nextval,'50ml Cannabis Healing Salve',50,'mL',45,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(product_counter.nextval,'15ml Cannabis Healing Salve',15,'mL',20,100);

-- populate the Cust_Order table with samples
insert into Cust_Order(orderID) values (order_counter.nextval);
insert into Cust_Order(orderID) values (order_counter.nextval);
insert into Cust_Order(orderID) values (order_counter.nextval);
insert into Cust_Order(orderID) values (order_counter.nextval);
insert into Cust_Order(orderID) values (order_counter.nextval);

-- order 5 has all the products in it
insert into Cust_Order(orderID) values (order_counter.nextval);

-- populate the Recipe table with samples
insert into Recipe(recID, recName, procedure) values(recipe_counter.nextval,'Sativa Tincture','Add ingredients together at the same time. Mix ingredients together for 2 mins');
insert into Recipe(recID, recName, procedure) values(recipe_counter.nextval,'Indica Tincture','Add ingredients together at the same time. Mix ingredients together for 2 mins');
insert into Recipe(recID, recName, procedure) values(recipe_counter.nextval,'Extra Strength Tincture','Add ingredients together at the same time. Mix ingredients together for 4 mins');
insert into Recipe(recID, recName, procedure) values(recipe_counter.nextval,'Headache Rollon','Add ingredients together at the same time. Mix ingredients together for 5 mins');
insert into Recipe(recID, recName, procedure) values(recipe_counter.nextval,'Sleep Rollon','Add ingredients together at the same time. Mix ingredients together for 2 mins');
insert into Recipe(recID, recName, procedure) values(recipe_counter.nextval,'Cannabis Spray','Add ingredients together at the same time. Mix ingredients together for 9 mins');
insert into Recipe(recID, recName, procedure) values(recipe_counter.nextval,'30 CBD Tincture','Add ingredients together at the same time. Mix ingredients together for 7 mins');
insert into Recipe(recID, recName, procedure) values(recipe_counter.nextval,'100ml Cannabis Healing Salve','Add ingredients together at the same time. Mix ingredients together for 9 mins');
insert into Recipe(recID, recName, procedure) values(recipe_counter.nextval,'50ml Cannabis Healing Salve','Add ingredients together at the same time. Mix ingredients together for 5 mins');
insert into Recipe(recID, recName, procedure) values(recipe_counter.nextval,'15ml Cannabis Healing Salve','Add ingredients together at the same time. Mix ingredients together for 3 mins');

-- populate the Customer table with samples
insert into Customer(custID,custFName, custLName, pnum) values(customer_counter.nextval,'Snoop', 'Dogg', '4204327777');
insert into Customer(custID,custFName, custLName, pnum) values(customer_counter.nextval,'Martha', 'Stewart', '5555555555');
insert into Customer(custID,custFName, custLName, pnum) values(customer_counter.nextval,'Barack','Obama', '6665554444');
insert into Customer(custID,custFName, custLName, pnum) values(customer_counter.nextval,'Carl', 'Sagan', '9878767654');
insert into Customer(custID,custFName, custLName, pnum) values(customer_counter.nextval,'Joe', 'Rogan', '1000000000');

-- populate the Material table with samples
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'coconut oil',20,'L',5);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'castor oil',20,'L',5);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'calendula oil',5,'L',20);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'sunflower oil',50,'L',10);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'cannabis oil sativa',2,'kg',200);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'cannabis oil indica',2,'kg',200);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'cannabis oil pink kush',2,'kg',300);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'cannabis infused coconut oil',2,'L',500);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'CBD infused coconut oil',5,'L',500);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'pure cbd oil',1,'L',500);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'essential oil mix',2,'L',100);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'essential oil premix (headache)',2,'L',100);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'essential oil premix (sleep)',2,'L',100);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'beeswax',1,'kg',75);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'honey',10,'L',45);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'distilled water',50,'L',10);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'pure ethanol',20,'L',100);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'amber 30ml glass bottle',50,'bottles',1);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'10 ml glass roll-on bottle',60,'bottles',1);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'plastic 200ml bottle spray',25,'bottles',1);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'blue cobalt glass bottle',13,'bottles',3);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'label large',200,'labels',2);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(material_counter.nextval,'label small',150,'labels',2);

-- populate the Container table with samples
insert into Container(matID,volume) values(18,30);
insert into Container(matID,volume) values(19,10);
insert into Container(matID,volume) values(20,200);
insert into Container(matID,volume) values(21,30);

-- populate the Build_Product table with samples
insert into Build_Product(prodID, recID) values (2, 2);
insert into Build_Product(prodID, recID) values (5, 6);
insert into Build_Product(prodID, recID) values (3, 7);
insert into Build_Product(prodID, recID) values (4, 9);
insert into Build_Product(prodID, recID) values (1, 8);
insert into Build_Product(prodID, recID) values (6, 4);
insert into Build_Product(prodID, recID) values (7, 1);
insert into Build_Product(prodID, recID) values (8, 3);
insert into Build_Product(prodID, recID) values (9, 5);
insert into Build_Product(prodID, recID) values (10, 10);


-- populate the RawMaterial table with samples
insert into RawMaterial(matID,potency,active) values(5,'high','cannabis sativa');
insert into RawMaterial(matID,potency,active) values(6,'high','cannabis indica');
insert into RawMaterial(matID,potency,active) values(7,'high','cannabis pink kush');
insert into RawMaterial(matID,potency,active) values(8,'10%','cannabis');
insert into RawMaterial(matID,potency,active) values(9,'10%','CBD');
insert into RawMaterial(matID,potency,active) values(10,'100%','CBD');

-- populate the Label table with samples
insert into Label(matID,labelSize) values(22,'large');
insert into Label(matID,labelSize) values(23,'small');

-- populate the Recipe_Uses table with samples
insert into Recipe_Uses(recID,matID,quantity) values(1,1,30);
insert into Recipe_Uses(recID,matID,quantity) values(1,5,400);
insert into Recipe_Uses(recID,matID,quantity) values(1,18,1);
insert into Recipe_Uses(recID,matID,quantity) values(8,14,10);
insert into Recipe_Uses(recID,matID,quantity) values(8,11,2);
insert into Recipe_Uses(recID,matID,quantity) values(8,1,70);
insert into Recipe_Uses(recID,matID,quantity) values(8,2,2);
insert into Recipe_Uses(recID,matID,quantity) values(8,3,3);
insert into Recipe_Uses(recID,matID,quantity) values(8,9,10);
insert into Recipe_Uses(recID,matID,quantity) values(9,14,5);
insert into Recipe_Uses(recID,matID,quantity) values(9,11,1);
insert into Recipe_Uses(recID,matID,quantity) values(9,1,35);
insert into Recipe_Uses(recID,matID,quantity) values(9,2,1);
insert into Recipe_Uses(recID,matID,quantity) values(9,3,1.5);
insert into Recipe_Uses(recID,matID,quantity) values(9,9,5);
insert into Recipe_Uses(recID,matID,quantity) values(10,14,1.5);
insert into Recipe_Uses(recID,matID,quantity) values(10,11,0.3);
insert into Recipe_Uses(recID,matID,quantity) values(10,1,10.5);
insert into Recipe_Uses(recID,matID,quantity) values(10,2,0.3);
insert into Recipe_Uses(recID,matID,quantity) values(10,3,0.45);
insert into Recipe_Uses(recID,matID,quantity) values(10,9,1.5);
insert into Recipe_Uses(recID,matID,quantity) values(2,1,30);
insert into Recipe_Uses(recID,matID,quantity) values(2,6,400);
insert into Recipe_Uses(recID,matID,quantity) values(2,18,1);
insert into Recipe_Uses(recID,matID,quantity) values(3,1,30);
insert into Recipe_Uses(recID,matID,quantity) values(3,7,400);
insert into Recipe_Uses(recID,matID,quantity) values(3,18,1);
insert into Recipe_Uses(recID,matID,quantity) values(4,19,1);
insert into Recipe_Uses(recID,matID,quantity) values(4,8,5);
insert into Recipe_Uses(recID,matID,quantity) values(4,4,3);
insert into Recipe_Uses(recID,matID,quantity) values(4,12,2);
insert into Recipe_Uses(recID,matID,quantity) values(5,19,1);
insert into Recipe_Uses(recID,matID,quantity) values(5,8,5);
insert into Recipe_Uses(recID,matID,quantity) values(5,4,3);
insert into Recipe_Uses(recID,matID,quantity) values(5,13,2);
insert into Recipe_Uses(recID,matID,quantity) values(6,20,1);
insert into Recipe_Uses(recID,matID,quantity) values(6,17,13);
insert into Recipe_Uses(recID,matID,quantity) values(6,16,3);
insert into Recipe_Uses(recID,matID,quantity) values(6,15,2);
insert into Recipe_Uses(recID,matID,quantity) values(6,6,1);
insert into Recipe_Uses(recID,matID,quantity) values(7,10,400);
insert into Recipe_Uses(recID,matID,quantity) values(7,1,30);
insert into Recipe_Uses(recID,matID,quantity) values(7,21,1);

-- populate the Reserves table with samples
insert into Reserves(prodID,orderID,numProd) values(1,1,5);
insert into Reserves(prodID,orderID,numProd) values(3,2,5);
insert into Reserves(prodID,orderID,numProd) values(2,3,20);
insert into Reserves(prodID,orderID,numProd) values(7,4,17);
insert into Reserves(prodID,orderID,numProd) values(6,5,4);

-- orderID 5 has all the procucts in it
insert into Reserves(prodID,orderID,numProd) values(1,5,4);
insert into Reserves(prodID,orderID,numProd) values(2,5,4);
insert into Reserves(prodID,orderID,numProd) values(3,5,4);
insert into Reserves(prodID,orderID,numProd) values(4,5,4);
insert into Reserves(prodID,orderID,numProd) values(5,5,4);
insert into Reserves(prodID,orderID,numProd) values(7,5,4);
insert into Reserves(prodID,orderID,numProd) values(8,5,4);
insert into Reserves(prodID,orderID,numProd) values(9,5,4);
insert into Reserves(prodID,orderID,numProd) values(10,5,4);


insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 12:56 PM','DD-MON-YY HH:MI PM'),1,1,5,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 03:34 PM','DD-MON-YY HH:MI PM'),3,2,5,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 10:42 AM','DD-MON-YY HH:MI AM'),2,3,13,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 02:30 PM','DD-MON-YY HH:MI PM'),7,4,17,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 01:56 PM','DD-MON-YY HH:MI AM'),6,5,2,0);

-- order 1 has more than one product on it, it has 5 products
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 12:55 PM','DD-MON-YY HH:MI PM'),2,1,5,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 12:56 PM','DD-MON-YY HH:MI PM'),3,1,5,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 12:56 PM','DD-MON-YY HH:MI PM'),4,1,5,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 12:56 PM','DD-MON-YY HH:MI PM'),5,1,5,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 12:54 PM','DD-MON-YY HH:MI PM'),1,1,5,0);

-- order 2 has more than one product on it, it has 4 products,
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 03:35 PM','DD-MON-YY HH:MI PM'),3,2,5,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 03:36 PM','DD-MON-YY HH:MI PM'),1,2,5,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 03:37 PM','DD-MON-YY HH:MI PM'),3,2,5,0);

-- order 5 has 1 product on it (prodID = 6) the quantity is updated on it
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 01:58 PM','DD-MON-YY HH:MI AM'),9,5,0,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 01:58 PM','DD-MON-YY HH:MI AM'),8,5,3,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 01:58 PM','DD-MON-YY HH:MI AM'),7,5,3,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 01:57 PM','DD-MON-YY HH:MI AM'),6,5,1,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 01:58 PM','DD-MON-YY HH:MI AM'),5,5,0,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 01:58 PM','DD-MON-YY HH:MI AM'),4,5,3,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 01:58 PM','DD-MON-YY HH:MI AM'),3,5,0,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 01:58 PM','DD-MON-YY HH:MI AM'),2,5,2,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 01:57 PM','DD-MON-YY HH:MI AM'),1,5,1,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 01:58 PM','DD-MON-YY HH:MI AM'),9,5,3,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 01:58 PM','DD-MON-YY HH:MI AM'),8,5,3,0);

-- populate the Placed_For table with samples
-- customer 1 orders all the products
insert into Placed_For(orderID,custID) values(1,5);
insert into Placed_For(orderID,custID) values(2,3);
insert into Placed_For(orderID,custID) values(3,4);
insert into Placed_For(orderID,custID) values(4,2);
insert into Placed_For(orderID,custID) values(5,1);