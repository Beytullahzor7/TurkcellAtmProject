------------------------TABLE LOGIN/REGISTER------------------------------------------------------
CREATE TABLE IF NOT EXISTS register(
    register_id serial NOT NULL,
	register_name character varying DEFAULT 'kullanýcý adýný girmediniz' ,
	register_surname  character varying  DEFAULT 'kullanýcý soyadýný girmediniz',
	register_password character varying  DEFAULT 'kullanýcý þifresini girmediniz',
	register_email_address character varying  DEFAULT 'kullanýcý email adresini girmediniz' UNIQUE,
	created_date TIMESTAMP WITH TIME ZONE default  CURRENT_TIMESTAMP,
	PRIMARY KEY (bank_id)
)

--INSERT
insert into register (register_name,register_surname,register_password,register_email_address) values ('Hamit','Mizrak','root','hamitmizrak@gmail.com');

-- SELECT
select * from register where register_password=? AND register_email_address=?

--TABLE
drop table register;

--TRUNCATE
truncate table register restart identity

-- CREATE Bank (1)
------------------------TABLE BANK------------------------------------------------------
CREATE TABLE IF NOT EXISTS bank(
    bank_id serial NOT NULL,
	bank_name character varying DEFAULT 'banka adini girmediniz' UNIQUE,
	branch_name  character varying  DEFAULT 'sube adini girmediniz',
	created_date TIMESTAMP WITH TIME ZONE default  CURRENT_TIMESTAMP,
	PRIMARY KEY (bank_id)
)

-----------------------TABLE CUSTOMER------------------------------------------------------
-- CREATE Customer (N)
CREATE TABLE IF NOT EXISTS customer(
    customer_id serial NOT NULL,
	customer_name character varying,
	customer_surname character varying,
	customer_identity character varying(44) UNIQUE,
	bank_id INT NOT NULL references bank(bank_id),
	created_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (customer_id)
)

-- Silme ilk önce 
drop table customer;
drop table bank;


-- Ekleme ilk önce 
insert into  bank (bank_name,branch_name) values ('banka xyz','banka subesi 452');
insert into  customer (customer_name,customer_surname,customer_identity,bank_id) values ('musteri adi','müsteri soyadi','1245155',1);

------------------------INDEX------------------------------------------------------
-- sürekli sorgu attigimiz tablodaki sutun için kullaniyoruz.
CREATE INDEX customer_name_index on customer(customer_name);


------------------------FUNCTION------------------------------------------------------


------------------------INNER JOIN------------------------------------------------------
select * from bank as b1 inner join customer as c1 on b1.bank_id=c1.bank_id;


------------------------VIEW------------------------------------------------------
--CREATE VIEW
CREATE VIEW customer_inner_join
AS
select * from bank
select * from bank  inner join customer on bank.bank_id=customer.bank_id

--DROP VIEW
drop view customer_inner_join

