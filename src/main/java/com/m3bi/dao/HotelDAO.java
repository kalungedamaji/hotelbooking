package com.m3bi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m3bi.model.Hotel;

public interface HotelDAO extends JpaRepository<Hotel, Integer> {
	public Hotel findByName(String name);
}
