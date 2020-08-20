package com.m3bi.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.m3bi.dao.HotelRoomDAO;
import com.m3bi.model.HotelRoom;

@RestController
public class HotelRoomController {
	@Autowired
	private HotelRoomDAO hotelRoomDAO;
	
	@PostMapping("/hotelRoom")
	public void saveHotelRoomType(@RequestBody HotelRoom hotelRoom) {
		hotelRoomDAO.save(hotelRoom);
	}
	
	@GetMapping("/hotelRooms")
	public List<HotelRoom> getHotelRooms() {
		return hotelRoomDAO.findAll();
	}
	
	@GetMapping("/hotelRoom/{id}")
	public HotelRoom getHotelRoomById(@PathParam(value = "id") int id) {
		return hotelRoomDAO.findById(id).get();
	}
	
	@GetMapping("/hotelRoom/{hotelId}")
	public List<HotelRoom> getHotelRoomsByHotelId(@PathParam(value = "hotelId") int hotelId) {
		return hotelRoomDAO.findByHotelId(hotelId);
	}
}
