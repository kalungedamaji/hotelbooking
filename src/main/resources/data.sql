insert into USER(name) values('Kiran');

insert into USER(name) values('Anusha');

insert into HOTEL(name, location) values('Mariot', 'Hyderabad');

insert into HOTEL(name, location) values('BBQ', 'Vizag');

insert into ROOMTYPE(roomType, cost) values('DELUXE', 20);

insert into ROOMTYPE(roomType, cost) values('PLATINUM', 40);

insert into ROOMTYPE(roomType, cost) values('BUSINESS', 50);

insert into HOTELROOM(number, hotelId, roomTypeId) values(1, 1, 1);

insert into HOTELROOM(number, hotelId, roomTypeId) values(2, 1, 2);

insert into HOTELROOM(number, hotelId, roomTypeId) values(1, 2, 2);

insert into HOTELROOM(number, hotelId, roomTypeId) values(2, 2, 1);

insert into hotelroombooking(hotelId, hotelRoomId, bookingDate, bookingStatus, userId) 
values(1, 1, now(), 'BOOKED', 1);