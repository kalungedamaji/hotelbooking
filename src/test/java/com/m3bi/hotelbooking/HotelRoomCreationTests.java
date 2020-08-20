package com.m3bi.hotelbooking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.m3bi.dao.HotelDAO;
import com.m3bi.dao.HotelRoomTypeDAO;
import com.m3bi.model.Hotel;
import com.m3bi.model.HotelRoom;
import com.m3bi.model.RoomType;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HotelRoomCreationTests {
	
	RestTemplate restTemplate = new RestTemplate();
	
	@LocalServerPort
    int randomServerPort;
	
	@Autowired
	public HotelRoomTypeDAO hotelRoomTypeDAO;
	
	@Autowired
	public HotelDAO hotelDAO;
	
	String baseUrl = "http://localhost:"+randomServerPort;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void createFirstHotelRoomInBBQHotel() {
		String url = baseUrl + "/hotelroom";
		HotelRoom hotelRoom = new HotelRoom();
		hotelRoom.setNumber(1);
		
		RoomType roomType = hotelRoomTypeDAO.findByRoomType("DELUXE");
		hotelRoom.setRoomTypeId(roomType.getId());
		
		Hotel hotel = hotelDAO.findByName("BBQ");
		hotelRoom.setHotelId(hotel.getId());
		restTemplate.postForEntity(url, hotelRoom, String.class);
	}
	
	@Test
	public void createSecondHotelRoomBusinessInBBQHotel() {
		String url = baseUrl + "/hotelroom";
		HotelRoom hotelRoom = new HotelRoom();
		hotelRoom.setNumber(1);
		
		RoomType roomType = hotelRoomTypeDAO.findByRoomType("BUSINESS");
		hotelRoom.setRoomTypeId(roomType.getId());
		
		Hotel hotel = hotelDAO.findByName("BBQ");
		hotelRoom.setHotelId(hotel.getId());
		restTemplate.postForEntity(url, hotelRoom, String.class);
	}
	
}
