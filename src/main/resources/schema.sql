DROP TABLE IF EXISTS USER;

CREATE TABLE USER(
	id int auto_increment primary key,
	name varchar(20) NOT NULL,
	bonusPoints int not null default 100
);

DROP TABLE IF EXISTS HOTEL;

CREATE TABLE HOTEL(
	id int auto_increment primary key,
	name varchar(20) NOT NULL,
	location varchar(20) NOT NULL
);

DROP TABLE IF EXISTS ROOMTYPE;

CREATE TABLE ROOMTYPE(
	id int auto_increment primary key,
	roomType varchar(20) NOT NULL,
	cost double NOT NULL
);

DROP TABLE IF EXISTS HOTELROOM;

CREATE TABLE HOTELROOM(
	id int auto_increment primary key,
	number int NOT NULL,
	hotelId int NOT NULL,
	roomTypeId int NOT NULL
);

DROP TABLE IF EXISTS hotelroombooking;

CREATE TABLE hotelroombooking(
	id int auto_increment primary key,
	hotelId int NOT NULL,
	hotelRoomId int NOT NULL,
	bookingDate date NOT NULL,
	bookingStatus varchar(20) NOT NULL,
	userId int NOT NULL
);