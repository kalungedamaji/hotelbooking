package com.m3bi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotelroom")
public class HotelRoom {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private int number;
	@Column(name = "hotelid", nullable = false)
	private int hotelId;
	@Column(name = "roomtypeid", nullable = false)
	private int roomTypeId;
//	@Column(name = "bookingstatus")
//	private String bookingStatus = VACANT.name();
	
//	public String getBookingStatus() {
//		return bookingStatus;
//	}
//	public void setBookingStatus(String bookingStatus) {
//		this.bookingStatus = bookingStatus;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hotelId;
		result = prime * result + id;
		result = prime * result + number;
		result = prime * result + roomTypeId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelRoom other = (HotelRoom) obj;
		if (hotelId != other.hotelId)
			return false;
		if (id != other.id)
			return false;
		if (number != other.number)
			return false;
		if (roomTypeId != other.roomTypeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HotelRoom [id=" + id + ", number=" + number + ", hotelId=" + hotelId + ", roomTypeId=" + roomTypeId
				+ "]";
	}
}
