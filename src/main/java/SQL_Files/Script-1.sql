CREATE TABLE customer_table (
	name_ID SERIAL PRIMARY KEY, 
	first_name VARCHAR(30), 
	last_name VARCHAR(30),
	address VARCHAR(100), 
	city VARCHAR(30));
	
CREATE TABLE employee_table (
	employee_ID SERIAL PRIMARY KEY,  
	access_level VARCHAR(5));

CREATE TABLE login_table (
	login_ID SERIAL PRIMARY KEY, 
	name_ID SERIAL REFERENCES customer_table(name_ID), 
	employee_ID SERIAL REFERENCES employee_table(employee_ID), 
	login_username VARCHAR(20), 
	login_password VARCHAR(20)); 

CREATE TABLE accounts_table (
	account_ID SERIAL PRIMARY KEY,
	account_number SERIAL UNIQUE,
	name_ID SERIAL REFERENCES customer_table(name_ID));

CREATE TABLE transactions_table (
	transaction_ID SERIAL PRIMARY KEY,
	name_ID SERIAL REFERENCES customer_table(name_ID), 
	account_number SERIAL REFERENCES accounts_table(account_number), 
	transaction_type VARCHAR(1), 
	amount FLOAT);

DROP TABLE if EXISTS customer_table CASCADE ;
DROP TABLE if EXISTS employee_table CASCADE ;
DROP TABLE if EXISTS login_table CASCADE ;
DROP TABLE if EXISTS accounts_table CASCADE ;
DROP TABLE if EXISTS transactions_table CASCADE ;

INSERT INTO employee_table (
	access_level)
	VALUES ('Admin'); 

UPDATE login_table SET (login_username, login_password) = ('adameve', 'TheFirst')
  WHERE employee_id = 1;

insert into login_table where employee_id = 1(
	login_username,
	login_password)
	VALUES ('adameve', 'first');