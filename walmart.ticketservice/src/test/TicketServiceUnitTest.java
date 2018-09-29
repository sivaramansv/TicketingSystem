package test;

import static org.junit.Assert.*;
import app.Theater;
import app.Helper;
import app.SeatHold;

import org.junit.Test;

public class TicketServiceUnitTest {

	@Test
	public void testNumOfSeatsAvailable() {
		
		//Initialize theater object with GUID and name
		Theater theater = new Theater(Helper.generateUUID(),Helper.THEATER_NAME);
		SeatHold seatHold = new SeatHold(theater);
		int numOfSeats = seatHold.numSeatsAvailable();
		assertEquals(Helper.TOTAL_SEATS,numOfSeats);
	}
	
	@Test
	public void testFindAndHoldSeats() {
		
		//Initialize theater object with GUID and name
		Theater theater = new Theater(Helper.generateUUID(),Helper.THEATER_NAME);
		SeatHold seatHold = new SeatHold(theater);
		SeatHold tempHold= seatHold.findAndHoldSeats(5, "abc@gmail.com");
		assertEquals(true,tempHold.getSeatHoldStatus());
	}
	
	@Test
	public void testFindAndHoldMaxSeats() {
		
		//Initialize theater object with GUID and name
		Theater theater = new Theater(Helper.generateUUID(),Helper.THEATER_NAME);
		SeatHold seatHold = new SeatHold(theater);
		SeatHold tempHold= seatHold.findAndHoldSeats(100, "abc@gmail.com");
		assertEquals(false,tempHold.getSeatHoldStatus());
	}
	
	@Test
	public void testFindAndHoldNegSeats() {
		
		//Initialize theater object with GUID and name
		Theater theater = new Theater(Helper.generateUUID(),Helper.THEATER_NAME);
		SeatHold seatHold = new SeatHold(theater);
		SeatHold tempHold= seatHold.findAndHoldSeats(-1, "abc@gmail.com");
		assertEquals(false,tempHold.getSeatHoldStatus());
	}

	
	@Test
	public void testReserveSeats() {
		
		//Initialize theater object with GUID and name
		Theater theater = new Theater(Helper.generateUUID(),Helper.THEATER_NAME);
		SeatHold seatHold = new SeatHold(theater);
		SeatHold tempHold= seatHold.findAndHoldSeats(5, "abc@gmail.com");
		String message = seatHold.reserveSeats(tempHold.getSeatHoldId(), "abc@gmail.com");
		System.out.println(message);
		assertEquals(Helper.RESERVATION_SUCCESS,message);
	}
	
	@Test
	public void testNoReservation() {
		
		//Initialize theater object with GUID and name
		Theater theater = new Theater(Helper.generateUUID(),Helper.THEATER_NAME);
		SeatHold seatHold = new SeatHold(theater);
		SeatHold tempHold= seatHold.findAndHoldSeats(51, "abc@gmail.com");
		String message = seatHold.reserveSeats(tempHold.getSeatHoldId(), "abc@gmail.com");
		System.out.println(message);
		assertEquals(Helper.NO_TICKETS,message);
	}




}
