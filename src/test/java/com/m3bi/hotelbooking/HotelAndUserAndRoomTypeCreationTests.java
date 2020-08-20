package com.m3bi.hotelbooking;

import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.m3bi.model.Hotel;
import com.m3bi.model.RoomType;
import com.m3bi.model.User;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class HotelAndUserAndRoomTypeCreationTests {
	
	RestTemplate restTemplate = new RestTemplate();
	
	@LocalServerPort
    int randomServerPort;
	
	String baseUrl = "http://localhost:"+randomServerPort;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void createBBQHotel() {
		String url = baseUrl + "/hotel";
		Hotel hotel = new Hotel();
		hotel.setName("BBQ");
		hotel.setLocation("Vizag");
		restTemplate.postForEntity(url, hotel, String.class);
	}
	
	@Test
	public void createHotelMariot() {
		String url = baseUrl + "/hotel";
		Hotel hotel = new Hotel();
		hotel.setName("Mariot");
		hotel.setLocation("Vizag");
		restTemplate.postForEntity(url, hotel, String.class);
	}
	
	@Test
	public void createKiranUser() {
		String url = baseUrl + "/user";
		User user = new User();
		user.setName("Kiran");
		user.setBonusPoints(100);
		restTemplate.postForEntity(url, user, String.class);
	}
	
	@Test
	public void createUserAVK() {
		String url = baseUrl + "/user";
		User user = new User();
		user.setName("AVK");
		user.setBonusPoints(100);
		restTemplate.postForEntity(url, user, String.class);
	}
	
	@Test
	public void createDeluxeRoomType() {
		String url = baseUrl + "/hotelRoomType";
		RoomType roomType = new RoomType();
		roomType.setCost(new Double(12));
		roomType.setRoomType("DELUXE");
		restTemplate.postForEntity(url, roomType, String.class);
	}

	@Test
	public void createBusinessRoomType() {
		String url = baseUrl + "/hotelRoomType";
		RoomType roomType = new RoomType();
		roomType.setCost(new Double(15));
		roomType.setRoomType("BUSINESS");
		restTemplate.postForEntity(url, roomType, String.class);
	}
}
