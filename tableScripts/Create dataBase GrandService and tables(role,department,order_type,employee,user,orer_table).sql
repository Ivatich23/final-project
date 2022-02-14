CREATE DATABASE  grand_service;
USE grand_service;

CREATE TABLE order_type (
  order_type_id int NOT NULL AUTO_INCREMENT,
  type_of_order varchar(25),
  PRIMARY KEY (order_type_id)
  
);
CREATE TABLE department (
  dep_id int NOT NULL AUTO_INCREMENT,
  dep_name varchar(25),
  dep_position varchar(25),
  PRIMARY KEY (dep_id)
);
CREATE TABLE role (
  id int NOT NULL AUTO_INCREMENT,
  role varchar(25),
  PRIMARY KEY (id)
);
CREATE TABLE employees (
  id int NOT NULL AUTO_INCREMENT,
  position varchar(25),
   emp_name varchar(15),
  surname varchar(25),
   salary int,
  dep_id int,
  PRIMARY KEY (id),
  FOREIGN KEY (dep_id)  REFERENCES department (dep_id)
);
CREATE TABLE user (
  id int NOT NULL auto_increment,
  login varchar(25),
  password varchar(200),
  role int,
  PRIMARY KEY (id),
  FOREIGN KEY (role)  REFERENCES role (id)
);
CREATE TABLE order_table (
  order_id int NOT NULL AUTO_INCREMENT,
  employee_id int,
   order_type_id int,
  production_time int,
   price int,
  PRIMARY KEY (order_id),
  FOREIGN KEY (employee_id)  REFERENCES employees (dep_id),
  FOREIGN KEY (order_type_id)  REFERENCES order_type (order_type_id)
);


