package com.m3bi.controller;

import static com.m3bi.enums.BookingStatusEnum.BOOKED;
import static com.m3bi.enums.BookingStatusEnum.PENDING_APPROVAL;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.m3bi.dao.HotelBookingDAO;
import com.m3bi.dao.HotelRoomTypeDAO;
import com.m3bi.dao.UserDAO;
import com.m3bi.model.HotelRoomBooking;
import com.m3bi.model.RoomType;
import com.m3bi.model.User;

@RestController
public class UserController {
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private HotelBookingDAO hotelBookingDAO;
	
	@Autowired
	private HotelRoomTypeDAO hotelRoomTypeDAO;
	
	@PostMapping("/user")
	public void saveUser(@RequestBody User user) {
		userDAO.save(user);
	}
	
	@PutMapping("/user")
	public void updateUser(@RequestBody User user) {
		User existingUser = userDAO.findByName(user.getName());
		if(existingUser != null && existingUser.getBonusPoints() != user.getBonusPoints()) {
			existingUser.setBonusPoints(existingUser.getBonusPoints() + user.getBonusPoints());
			
			List<HotelRoomBooking> userPendingApprovalHotelRoomBookings = hotelBookingDAO.findByUserIdAndBookingStatus(existingUser.getId(), PENDING_APPROVAL.name());
			List<HotelRoomBooking> bookingsToBeSaved = new ArrayList<>();
			for(HotelRoomBooking booking:userPendingApprovalHotelRoomBookings) {
				RoomType roomType = hotelRoomTypeDAO.findByRoomType(booking.getHotelRoomType());
				int roomCost = roomType.getCost().intValue();
				if(roomType.getCost().intValue() <= existingUser.getBonusPoints()) {
					booking.setBookingStatus(BOOKED.name());
					bookingsToBeSaved.add(booking);
					existingUser.setBonusPoints(existingUser.getBonusPoints() - roomCost);
				} else {
					break;
				}
			}
			if(bookingsToBeSaved.size() > 0) {
				hotelBookingDAO.saveAll(bookingsToBeSaved);
			}
			userDAO.save(existingUser);
		}
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userDAO.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathParam(value = "id") int id) {
		return userDAO.findById(id).get();
	}
}
