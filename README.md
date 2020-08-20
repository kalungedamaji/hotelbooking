# hotelbooking
Hotel booking ReST API

Problem Statement :

There is a hotel booking website.

Expose an API to book a room based on user bonus points.

 

Conditions:
If User has 'n' bonus points and Price to book the hotel is 'n’ ,Status of room changes to "BOOKED".

If User has 'n' bonus points and Price to book the hotel is greater than 'n’ , Status of room changes to "PENDING APPROVAL".

Any changes to user bonus is tracked in the system.

 

Devise a solution with proper architecture and documentation.

Note:
You can make necessary assumptions while devising the solution. Use Node JS/JAVA , REST API are must.

Important points to consider:

1) Clean code

2) Design

3) Tests if possible

4) API documentation

Changes suggested by the panel:

User should be able to update his bonus points and if he has any pending approval bookings that should be marked as booked and bonus points should be adjusted accordingly.

Check for vacant rooms before bookings.

If pending approval bookings are there then we need to cancel them and boook for the new user when vacant rooms are not available.

Authorization (Yet to be implemented).


