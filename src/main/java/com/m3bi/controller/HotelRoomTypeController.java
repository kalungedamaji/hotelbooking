package com.m3bi.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.m3bi.dao.HotelRoomTypeDAO;
import com.m3bi.model.RoomType;

@RestController
public class HotelRoomTypeController {
	@Autowired
	private HotelRoomTypeDAO hotelRoomTypeDAO;
	
	@PostMapping("/hotelRoomType")
	public void saveHotelRoomType(@RequestBody RoomType hotelRoomType) {
		hotelRoomTypeDAO.save(hotelRoomType);
	}
	
	@GetMapping("/hotelRoomTypes")
	public List<RoomType> getHotelRoomTypes() {
		return hotelRoomTypeDAO.findAll();
	}
	
	@GetMapping("/hotelRoomType/{id}")
	public RoomType getHotelRoomTypeById(@PathParam(value = "id") int id) {
		return hotelRoomTypeDAO.findById(id).get();
	}
}
