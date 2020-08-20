package com.m3bi.hotelbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.m3bi.dao.HotelDAO;
import com.m3bi.dao.HotelRoomTypeDAO;
import com.m3bi.dao.UserDAO;
import com.m3bi.model.Hotel;
import com.m3bi.model.HotelBookingRequest;
import com.m3bi.model.HotelRoom;
import com.m3bi.model.RoomType;
import com.m3bi.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
@TestPropertySource(properties = "server.port=8080")
public class HotelRoomBookingTests {
	
	RestTemplate restTemplate = new RestTemplate();
	
	@LocalServerPort
    public int serverPort;
		
	@Autowired
	public UserDAO userDAO;
	
	@Autowired
	public HotelRoomTypeDAO hotelRoomTypeDAO;
	
	@Autowired
	public HotelDAO hotelDAO;
	
//	@BeforeClass
//	public static void createDataBeforeExecution() {
//		new HotelRoomBookingTests().createData();
//	}
	
//	@BeforeEach
	public void createData() {
		String baseUrl = "http://localhost:8080";
		String url = baseUrl + "/hotel";
		Hotel hotel = new Hotel();
		hotel.setName("BBQ");
		hotel.setLocation("Vizag");
		restTemplate.postForEntity(url, hotel, String.class);
		
		hotel.setName("Mariot");
		restTemplate.postForEntity(url, hotel, String.class);
		
		url = baseUrl + "/user";
		User user = new User();
		user.setName("Kiran");
		user.setBonusPoints(100);
		restTemplate.postForEntity(url, user, String.class);
		
		user.setName("Anusha");
		user.setBonusPoints(200);
		restTemplate.postForEntity(url, user, String.class);
		
		url = baseUrl + "/hotelRoomType";
		RoomType roomType = new RoomType();
		roomType.setCost(new Double(12));
		roomType.setRoomType("DELUXE");
		restTemplate.postForEntity(url, roomType, String.class);
		
		roomType.setCost(new Double(15));
		roomType.setRoomType("BUSINESS");
		restTemplate.postForEntity(url, roomType, String.class);
		
		url = baseUrl + "/hotelRoom";
		HotelRoom hotelRoom = new HotelRoom();
		hotelRoom.setNumber(1);
		
		roomType = hotelRoomTypeDAO.findByRoomType("DELUXE");
		hotelRoom.setRoomTypeId(roomType.getId());
		
		hotel = hotelDAO.findByName("BBQ");
		hotelRoom.setHotelId(hotel.getId());
		restTemplate.postForEntity(url, hotelRoom, String.class);
		
		hotelRoom.setNumber(2);
		roomType = hotelRoomTypeDAO.findByRoomType("BUSINESS");
		hotelRoom.setRoomTypeId(roomType.getId());
		
		hotelRoom.setHotelId(hotel.getId());
		restTemplate.postForEntity(url, hotelRoom, String.class);
	}

	@Test
	public void checkPort() {
		System.out.println(serverPort);
		assertNotEquals(serverPort, 0);
		assertEquals(8080, serverPort);
	}
	
	@Test
	public void hotelRoomBookingErrorHotelName() {
		String url = "http://localhost:"+serverPort + "/hotel/booking";
		HotelBookingRequest hotelBookingRequest = new HotelBookingRequest();
		hotelBookingRequest.setHotelName("Undefined");
		hotelBookingRequest.setRoomType("DELUXE");
		hotelBookingRequest.setBookingDate(new Date(System.currentTimeMillis()));
		User user = userDAO.findByName("Kiran");
		hotelBookingRequest.setUserId(user.getId());		
		
		try {
			restTemplate.postForEntity(url, hotelBookingRequest, String.class);
		} catch(Exception e) {
			assertEquals("Hotel "+hotelBookingRequest.getHotelName()+" not found.", e.getMessage());
		}
	}
	
	@Test
	public void hotelRoomBookingErrorRoomType() {
		String url = "http://localhost:"+serverPort + "/hotel/booking";
		HotelBookingRequest hotelBookingRequest = new HotelBookingRequest();
		hotelBookingRequest.setHotelName("BBQ");
		hotelBookingRequest.setRoomType("Undefined");
		hotelBookingRequest.setBookingDate(new Date(System.currentTimeMillis()));
		User user = userDAO.findByName("Kiran");
		hotelBookingRequest.setUserId(user.getId());
		
		try {
			restTemplate.postForEntity(url, hotelBookingRequest, String.class);
		} catch(Exception e) {
			assertEquals("Room type " + hotelBookingRequest.getRoomType() + " not found.", e.getMessage());
		}
	}
	
	@Test
	public void hotelRoomBookingErrorUser() {
		String url = "http://localhost:"+serverPort + "/hotel/booking";
		HotelBookingRequest hotelBookingRequest = new HotelBookingRequest();
		hotelBookingRequest.setHotelName("BBQ");
		hotelBookingRequest.setRoomType("DELUXE");
		hotelBookingRequest.setBookingDate(new Date(System.currentTimeMillis()));
		hotelBookingRequest.setUserId(999);
//		ResponseEntity<String> response = null;
		try {
			restTemplate.postForEntity(url, hotelBookingRequest, String.class);
		} catch(Exception e) {
			assertEquals("User with id "+hotelBookingRequest.getUserId()+" not found.", e.getMessage());
		}
	}
	
	@Test
	public void createHotelRoomBookingInBBQHotel() {
		String url = "http://localhost:"+serverPort + "/hotel/booking";
		HotelBookingRequest hotelBookingRequest = new HotelBookingRequest();
		hotelBookingRequest.setHotelName("BBQ");
		hotelBookingRequest.setRoomType("DELUXE");
		hotelBookingRequest.setBookingDate(new Date(System.currentTimeMillis()));
		User user = userDAO.findByName("Kiran");
		hotelBookingRequest.setUserId(user.getId());		
		
		restTemplate.postForEntity(url, hotelBookingRequest, String.class);
	}
	
}
