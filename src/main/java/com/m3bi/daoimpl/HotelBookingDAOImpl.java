package com.m3bi.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.m3bi.model.HotelRoomBooking;

@Repository
public class HotelBookingDAOImpl {
	
//	@Autowired
//	private HotelBookingDAO hotelBookingDAO;
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	public List<HotelRoomBooking> getHotelRoomBookings(int hotelId) {
		List<HotelRoomBooking> hotelRoomBookings = new ArrayList<>();
//		List<Map<String, Object>> hotelRoomBookings = jdbcTemplate.queryForList("select * from HOTELROOMBOOKING");
//		hotelBookingDAO.findAll().forEach(hotelRoomBookings::add);
		return hotelRoomBookings;
	}
	
//	public List<Map<String, Object>> getHotelRoomBookings(int hotelId) {
////		List<HotelRoomBooking> hotelRoomBookings = new ArrayList<>();
//		List<Map<String, Object>> hotelRoomBookings = jdbcTemplate.queryForList("select * from HOTELROOMBOOKING");
////		hotelBookingDAO.findAll().forEach(hotelRoomBookings::add);
//		return hotelRoomBookings;
//	}

}
