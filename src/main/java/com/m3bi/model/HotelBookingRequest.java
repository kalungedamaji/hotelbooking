package com.m3bi.model;

import java.sql.Date;

import org.springframework.lang.NonNull;

public class HotelBookingRequest {
	@NonNull
	private String hotelName;
	@NonNull
	private String roomType;
	@NonNull
	private int userId;
	@NonNull
	private Date bookingDate;
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	@Override
	public String toString() {
		return "HotelBookingRequest [hotelName=" + hotelName + ", roomType=" + roomType + ", userId=" + userId
				+ ", bookingDate=" + bookingDate + "]";
	}
}
