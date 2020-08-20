package com.m3bi.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotelroombooking")
public class HotelRoomBooking {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "hotelid", nullable = false)
	private int hotelId;
	@Column(name = "hotelroomid", nullable = false)
	private int hotelRoomId;
	@Column(name = "hotelroomtype", nullable = false)
	private String hotelRoomType;	
	@Column(name = "bookingdate", nullable = false)
	private Date bookingDate;
	@Column(name = "bookingstatus")
	private String bookingStatus;
	@Column(name = "userid", nullable = false)
	private int userId;
	
	public String getHotelRoomType() {
		return hotelRoomType;
	}
	public void setHotelRoomType(String hotelRoomType) {
		this.hotelRoomType = hotelRoomType;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHotelRoomId() {
		return hotelRoomId;
	}
	public void setHotelRoomId(int hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingDate == null) ? 0 : bookingDate.hashCode());
		result = prime * result + ((bookingStatus == null) ? 0 : bookingStatus.hashCode());
		result = prime * result + hotelId;
		result = prime * result + hotelRoomId;
		result = prime * result + ((hotelRoomType == null) ? 0 : hotelRoomType.hashCode());
		result = prime * result + id;
		result = prime * result + userId;
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
		HotelRoomBooking other = (HotelRoomBooking) obj;
		if (bookingDate == null) {
			if (other.bookingDate != null)
				return false;
		} else if (!bookingDate.equals(other.bookingDate))
			return false;
		if (bookingStatus == null) {
			if (other.bookingStatus != null)
				return false;
		} else if (!bookingStatus.equals(other.bookingStatus))
			return false;
		if (hotelId != other.hotelId)
			return false;
		if (hotelRoomId != other.hotelRoomId)
			return false;
		if (hotelRoomType == null) {
			if (other.hotelRoomType != null)
				return false;
		} else if (!hotelRoomType.equals(other.hotelRoomType))
			return false;
		if (id != other.id)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HotelRoomBooking [id=" + id + ", hotelId=" + hotelId + ", hotelRoomId=" + hotelRoomId
				+ ", hotelRoomType=" + hotelRoomType + ", bookingDate=" + bookingDate + ", bookingStatus="
				+ bookingStatus + ", userId=" + userId + "]";
	}
}
