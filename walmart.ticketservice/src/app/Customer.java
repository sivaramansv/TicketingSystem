package app;

/**
 * 
 * @author svsivaraman
 *
 */
public class Customer implements Runnable {
	
	Theater theater;
	private String customerEmail;
	private int numSeats=0;
	
	/**
	 * Constructor for Customer object
	 * @param theater
	 * @param customerEmail
	 */
	public Customer(Theater theater,String customerEmail,int numSeats) {
		
		this.theater = theater;
		this.customerEmail = customerEmail;
		this.numSeats=numSeats;
	}
	
	/**
	 * This method gets the customer email
	 * @return customerEmail
	 */
	public String getCustomerEmail() {
		
		return customerEmail;
	}
	
	/**
	 * Run method
	 */
	@Override
	public void run() {

		bookTickets();
		
	}
	
	/**
	 * This method is used to book tickets
	 */
	
	public void bookTickets() {
		
		SeatHold seatHold = new SeatHold(theater);
		System.out.println("As of now, number of seats available:"+ seatHold.numSeatsAvailable());
		System.out.println("Requested number of seats by:"+customerEmail+":"+numSeats+" tickets");
		SeatHold tempHold = seatHold.findAndHoldSeats(numSeats, customerEmail);
		
		if(tempHold.getSeatHoldStatus() && numSeats < seatHold.numSeatsAvailable()) {
			
			System.out.println(seatHold.reserveSeats(tempHold.getSeatHoldId(), customerEmail));
			System.out.println("Booking confirmed for:"+customerEmail+" Ticket ConfirmationID:"+tempHold.getSeatHoldId());
			System.out.println("After:"+numSeats+" tickets, total number of seats available:"+seatHold.numSeatsAvailable());
			System.out.println("************************************");
		}
		else {
			System.out.println(Helper.NO_TICKETS);
		}
	}
	
	
}