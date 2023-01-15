create table Address
(
    id			bigint				not null primary key,
    address1	varchar(255)        not null,
    address2  	varchar(255)        not null,
    city  		varchar(255)        not null,
    state  		varchar(100) 		not null,
    postal  	varchar(10)        	not null
);

insert into Address
    (id, address1, address2, city, state, postal)
values (1, '5400 River Rd', 'RiverGrove', 'Rockwell', 'IL', '60079') ,
    (2, '701 Alma Rd', 'AlmaGrove', 'Rockton', 'IL', '60179') ;

create table User
(
    id        bigint              not null primary key,
    firstName varchar(255)        not null,
    lastName  varchar(255)        not null,
    username  varchar(255) unique not null,
    password  varchar(255)        not null,
    addressId bigInt constraint addressId_FK REFERENCES address(id)
);

insert into User
    (id, firstName, lastName, username, password, addressId)
values (1, 'Phil', 'Ingwell', 'PhilIngwell', 'Password123', 1) ,
    (2, 'Anna', 'Conda', 'AnnaConda', 'Password234', 2);