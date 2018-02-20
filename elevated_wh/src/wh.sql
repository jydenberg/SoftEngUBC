drop table Material cascade constraints;
drop table Container;
drop table RawMaterial;
drop table Label;
drop table Recipe_Uses;
drop table Recipe cascade constraints;
drop table Product cascade constraints;
drop table Build_Product;
drop table Reserves cascade constraints;
drop table Cust_Order cascade constraints;
drop table Customer cascade constraints;
drop table Filled_For;
drop table Placed_For;
drop sequence material_counter;
drop sequence recipe_counter;
drop sequence product_counter;
drop sequence customer_counter;
drop sequence order_counter;

drop view Recipe4Product;
drop view ProductXFilled_ForXOrder;
drop view cx_ordered_allproduct_res;
drop view cx_ordered_allproduct_fill;


CREATE SEQUENCE material_counter
START WITH 0
INCREMENT BY 1
MINVALUE 0;
create sequence recipe_counter
START WITH 0
INCREMENT BY 1
MINVALUE 0;
create sequence product_counter
START WITH 0
INCREMENT BY 1
MINVALUE 0;
create sequence customer_counter
START WITH 0
INCREMENT BY 1
MINVALUE 0;
create sequence order_counter
START WITH 0
INCREMENT BY 1
MINVALUE 0;

create table Material
(matID integer not null,
matName varchar2(100) not null,
matStock integer,
matPrice integer,
matUnit varchar2(10),
primary key (matID));

grant select on Material to public;

create table Container
(matID integer not null,
volume integer not null,
foreign key (matID) references Material(matID)
on delete cascade);

grant select on Container to public;

create table RawMaterial
(matID integer not null,
potency varchar2(40) not null,
active varchar2(40) not null,
foreign key (matID) references Material(matID)
on delete cascade);

grant select on RawMaterial to public;

create table Label
(matID integer not null,
labelSize varchar2(40) not null,
foreign key (matID) references Material(matID)
on delete cascade);

grant select on Label to public;

create table Recipe
(recID integer not null,
procedure varchar2(1200) not null,
recName varchar2(100) not null,
primary key (recID));

grant select on Recipe to public;

create table Recipe_Uses
(recID integer not null,
matID integer not null,
quantity integer not null,
primary key (recID, matID),
foreign key (matID) references Material (matID),
foreign key (recID) references Recipe (recID));

grant select on Recipe_Uses to public;

create table Product
(stockProduct integer default 0,
prodPrice integer not null,
prodID integer not null,
prodName varchar2(40) not null,
prodSize integer not null,
prodUnit varchar2(10),
primary key (prodID));

grant select on Product to public;

create table Build_Product
(prodID integer not null,
recID integer not null,
primary key (prodID),
foreign key (prodID) references Product (prodID),
foreign key (recID) references Recipe (recID));

grant select on Build_Product to public;

create table Cust_Order
(orderID integer not null,
primary key (orderID));

grant select on Cust_Order to public;

create table Reserves
(prodID integer not null,
orderID integer not null,
numProd integer not null,
primary key (prodID, orderID),
foreign key (prodID) references Product (prodID),
foreign key (orderID) references Cust_Order (orderID));

grant select on Reserves to public;

create table Customer
(custID integer not null,
custFName varchar2(30),
custLName varchar2(30),
pnum varchar2(10),
primary key (custID));

grant select on Customer to public;

-- Filled_For is the relationship between Product-Produces-OrderProduct and Order
create table Filled_For
(dateupdated DATE not null,
prodID integer not null,
orderID integer not null,
numFilled integer,
isShipped integer default 0,
primary key (orderID, prodID, dateUpdated),
foreign key (prodID) references Product (prodID),
foreign key (orderID) references Cust_Order (orderID),
check (isShipped >= 0 AND isShipped <= 1));

grant select on Filled_For to public;

-- Placed_For is the relationship between Order, Placed_For and Customer. It is a many-to-one relationship
-- So every order must have a customer, i.e. custID cannot be null

create table Placed_For
(orderID integer not null,
custID  integer not null,
primary key (orderID),
foreign key (custID)
references Customer(custID));

grant select on Placed_For to public;



create view Recipe4Product AS
SELECT p.prodID, p.prodName, p.prodSize, p.prodUnit, p.prodPrice, p.stockProduct, r.recID, r.recName, r.procedure
FROM Product p, Recipe r, Build_Product bp
WHERE r.recID = bp.recID AND p.prodID = bp.prodID;

grant select on Recipe4Product to public;


create view ProductXFilled_ForXOrder AS
SELECT p.prodID, p.prodName, p.prodSize, p.prodUnit, p.prodPrice, p.stockProduct, o.orderID, f.dateupdated, f.numFilled, f.isShipped
FROM Product p, Cust_Order o, Filled_For f
WHERE o.orderID = f.orderID AND p.prodID = f.prodID;

grant select on ProductXFilled_ForXOrder to public;


create view cx_ordered_allproduct_res AS
SELECT p.prodID, p.prodName, p.prodSize, p.prodUnit, p.prodPrice, p.stockProduct, o.orderID, c.custID, c.custFName, c.custLName, c.pnum, r.numProd
FROM Product p, Cust_Order o, Placed_For f, Customer c, Reserves r
WHERE c.custID = f.custID AND f.orderID = o.orderID AND o.orderID = r.orderID AND r.prodID = p.prodID;

grant select on cx_ordered_allproduct_res to public;


create view cx_ordered_allproduct_fill AS
SELECT p.prodID, p.prodName, p.prodSize, p.prodUnit, p.prodPrice, p.stockProduct, o.orderID, c.custID, c.custFName, c.custLName, c.pnum, r.numProd
FROM Product p, Cust_Order o, Placed_For pf, Customer c, Reserves r, Filled_For ff
WHERE c.custID = pf.custID AND pf.orderID = o.orderID AND ff.prodID = p.prodID;

grant select on cx_ordered_allproduct_fill to public;