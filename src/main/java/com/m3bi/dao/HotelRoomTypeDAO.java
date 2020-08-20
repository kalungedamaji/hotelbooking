package com.m3bi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m3bi.model.RoomType;

public interface HotelRoomTypeDAO extends JpaRepository<RoomType, Integer> {
	public RoomType findByRoomType(String roomType);
}
