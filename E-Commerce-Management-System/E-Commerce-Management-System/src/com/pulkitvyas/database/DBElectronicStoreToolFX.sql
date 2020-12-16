DROP DATABASE IF EXISTS DBElectrnoicStoreToolFX;
CREATE DATABASE DBElectrnoicStoreToolFX;
USE DBElectrnoicStoreToolFX;

CREATE TABLE Customers (
    Customer_ID int AUTO_INCREMENT,
    Fname varchar(45) NOT NULL,
    Lname varchar(45) NOT NULL,
    Locality varchar(100) NOT NULL,
    CustomerAddress longtext NOT NULL,
    City varchar(45) NOT NULL,
    CState varchar(45) NOT NULL,
    Pincode int NOT NULL,
    Country varchar(45) NOT NULL,
    Phone_no varchar(15) NOT NULL,
    Email varchar(45) NOT NULL,
    CPassword varchar(45) NOT NULL,
    Gender varchar(45) NOT NULL,
    PRIMARY KEY (Customer_ID),
    UNIQUE KEY Email_UNIQUE (Email),
    UNIQUE KEY Customer_ID_UNIQUE (Customer_ID),
    UNIQUE KEY Phone_no_UNIQUE (Phone_no)
);

CREATE TABLE Orders (
    Order_ID INT NOT NULL AUTO_INCREMENT,
    Customer_ID INT NOT NULL,
    Payment_ID INT NOT NULL,
    OrderDate DATE NOT NULL,
    SalesTax DECIMAL NOT NULL,
    Freight VARCHAR(45) NOT NULL,
    Shipping_ID INT NOT NULL,
    ShipDate DATE NOT NULL,
    Product_ID INT NOT NULL,
    Price DECIMAL NOT NULL,
    Quantity INT NOT NULL,
    Discount DECIMAL NOT NULL,
    TotalAmount DECIMAL NOT NULL,
    Size DECIMAL NOT NULL,
    Color VARCHAR(45) NOT NULL,
    PRIMARY KEY (Order_ID),
    UNIQUE INDEX Order_ID_UNIQUE (Order_ID ASC) VISIBLE,
    UNIQUE INDEX Payment_ID_UNIQUE (Payment_ID ASC) VISIBLE,
    UNIQUE INDEX Shipping_ID_UNIQUE (Shipping_ID ASC) VISIBLE,
    CONSTRAINT FOREIGN KEY (Customer_ID)
    REFERENCES Customers (Customer_ID)
    ON DELETE CASCADE
);

CREATE TABLE Payment (
  Payment_ID INT NOT NULL AUTO_INCREMENT,
  PaymentType VARCHAR(45) NOT NULL,
  Amount DECIMAL NOT NULL,
  PayDate DATE NOT NULL,
  PRIMARY KEY (Payment_ID),
  UNIQUE INDEX Payment_ID_UNIQUE (Payment_ID ASC) VISIBLE
);

CREATE TABLE Shippers (
  Shipping_ID INT NOT NULL AUTO_INCREMENT,
  CompanyName VARCHAR(45) NOT NULL,
  Phone VARCHAR(15) NOT NULL,
  Email VARCHAR(45) NOT NULL,
  PRIMARY KEY (Shipping_ID),
  UNIQUE INDEX Phone_UNIQUE (Phone ASC) VISIBLE,
  UNIQUE INDEX Email_UNIQUE (Email ASC) VISIBLE
);

CREATE TABLE Products (
    Product_ID INT NOT NULL AUTO_INCREMENT,
    ProductName LONGTEXT NOT NULL,
    ProductDescription LONGTEXT NOT NULL,
    QuantityAvailable INT NULL,
    Commission DECIMAL NULL,
    Cost DECIMAL NULL,
    SizeAvailable DECIMAL NULL,
    Category_ID INT NULL,
    Age_group VARCHAR(5) NULL,
    Gender VARCHAR(15) NULL,
    ColourAvailable VARCHAR(45) NULL,
    PType VARCHAR(45) NULL,
    Supplier_ID INT NULL,
    Brand VARCHAR(45) NULL,
    Discount DECIMAL NULL,
    PRIMARY KEY (Product_ID)
);

CREATE TABLE Category (
  Category_ID INT NOT NULL AUTO_INCREMENT,
  Category_Name VARCHAR(45) NOT NULL,
  CategoryDescription LONGTEXT NOT NULL,
  PRIMARY KEY (Category_ID)
);

CREATE TABLE Supplier (
  Supplier_ID INT NOT NULL AUTO_INCREMENT,
  CompanyName VARCHAR(100) NOT NULL,
  SName VARCHAR(100) NOT NULL,
  Locality VARCHAR(45) NOT NULL,
  SAddress LONGTEXT NOT NULL,
  City VARCHAR(45) NOT NULL,
  SState VARCHAR(45) NOT NULL,
  Pincode INT NOT NULL,
  Country VARCHAR(45) NOT NULL,
  Phone_no VARCHAR(15) NOT NULL,
  Email VARCHAR(45) NOT NULL,
  SPassword VARCHAR(45) NOT NULL,
  Gender VARCHAR(15) NOT NULL,
  PRIMARY KEY (Supplier_ID),
  UNIQUE INDEX Phone_no_UNIQUE (Phone_no ASC) VISIBLE,
  UNIQUE INDEX Email_UNIQUE (Email ASC) VISIBLE
);

CREATE TABLE Users (
	id INT NOT NULL AUTO_INCREMENT,
    nameUser VARCHAR(150) NOT NULL,
	email VARCHAR(150) NOT NULL,
	pass VARCHAR(150) NOT NULL,
    biography LONGTEXT NOT NULL,
    dialogTransition VARCHAR(150) NOT NULL,
    userType VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE UserSession (
	id INT NOT NULL AUTO_INCREMENT,
    userId INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (userId)
    REFERENCES Users (id)
);

CREATE TRIGGER triggerAddCustomerInsertDate BEFORE INSERT ON Customers	
    FOR EACH ROW SET NEW.insertionDate = NOW();
    
CREATE TRIGGER triggerAddProductInsertDate BEFORE INSERT ON Products	
	FOR EACH ROW SET NEW.insertionDate = NOW();

CREATE TRIGGER triggerAddDialogTransition BEFORE INSERT ON Users	
    FOR EACH ROW SET NEW.dialogTransition = "CENTER";
    
CREATE TRIGGER triggerAddBiography BEFORE INSERT ON Users	
    FOR EACH ROW SET NEW.biography = "Every day is a new opportunity to change your life.";
