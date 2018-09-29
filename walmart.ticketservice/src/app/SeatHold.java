package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author svsivaraman
 *
 */
public class SeatHold implements TicketService {

	private static Map<Integer, Seat> seatMap;
	private static Map<Integer, List<Seat>> holdSeatMap;
	SeatHold seatHold;
	private int seatHoldId;
	private boolean holdStatus;
	private String customerEmail;

	/**
	 * Empty constructor
	 */
	public SeatHold() {

	}

	/**
	 * Initializes the SeatHold class with pre-determined seating arrangement
	 * 
	 * @param theater
	 */
	public SeatHold(Theater theater) {

		seatMap = theater.getSeatingArrangement();
		holdSeatMap = new ConcurrentHashMap<Integer, List<Seat>>();
		holdStatus = false;
		customerEmail = null;
	}

	/**
	 * This method sets a random seat hold ID 
	 */
	public void setSeatHoldId() {

		Random rand = new Random();
		seatHoldId = rand.nextInt(Helper.MAX_ID);
	}

	/**
	 * This method sets the hold status
	 */
	public void setSeatHoldStatus() {

		holdStatus = true;
	}

	/**
	 * This method sets the customer email
	 * 
	 * @param customerEmail
	 */
	public void setCustomerEmail(String customerEmail) {

		this.customerEmail = customerEmail;

	}

	/**
	 * This method gets the seat hold id
	 * 
	 * @return seatHoldId
	 */
	public int getSeatHoldId() {

		return seatHoldId;
	}

	/**
	 * Gets the hold status
	 * 
	 * @return holdStatus
	 */
	public boolean getSeatHoldStatus() {

		return holdStatus;
	}

	/**
	 * This method gets the number of seats available
	 */
	@Override
	public int numSeatsAvailable() {

		int count = 0;

		try {

			if (seatMap != null) {

				Iterator<Entry<Integer, Seat>> iterator = seatMap.entrySet().iterator();

				while (iterator.hasNext()) {

					Map.Entry<Integer, Seat> pair = (Map.Entry<Integer, Seat>) iterator.next();

					Seat seat = pair.getValue();
					
					//If the seats are not on hold or reserved, mark it as available
					if (!seat.checkHoldStatus() && !seat.checkReservation()) {

						count++;

					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error occurred. Unable to find the number of seats");
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * This method finds and holds seats for a customer
	 * 
	 * @param numSeats
	 * @param customerEmail
	 */
	@Override
	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {

		try {

			int totalSeats = numSeatsAvailable();

			seatHold = new SeatHold();

			if (numSeats <= totalSeats) {

				List<Seat> seatList = new ArrayList<Seat>();

				if (seatMap != null) {

					for (Map.Entry<Integer, Seat> entry : seatMap.entrySet()) {

						if (numSeats > 0) {

							Seat seat = (Seat) entry.getValue();
							
							//If seat is neither reserved nor on hold
							if (!seat.checkHoldStatus() && !seat.checkReservation()) {
								seat.setHold();
								seatMap.put(seat.getSeatID(), seat);
								seatList.add(seat);
								--numSeats;

							}
						}
					}

					if (seatList.size() > 0) {

						seatHold.setSeatHoldId();
						seatHold.setCustomerEmail(customerEmail);
						seatHold.setSeatHoldStatus();
					}

					holdSeatMap.put(seatHold.getSeatHoldId(), seatList);
				}
			}
		} catch (Exception e) {
			System.out.println("Error occurred. Unable to find and hold the number of seats");
			e.printStackTrace();
		}

		return seatHold;
	}

	/**
	 * This method finds and holds seats for a customer
	 * 
	 * @param seatHoldId
	 * @param customerEmail
	 */
	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {

		String result = null;

		try {

			//Reserve the seats for the particular seat hold Id
			if (seatHoldId > 0 && customerEmail != null) {

				if (holdSeatMap.containsKey(seatHoldId)) {

					List<Seat> tempSeatList = holdSeatMap.get(seatHoldId);

					for (Seat tempSeat : tempSeatList) {

						if (seatMap != null && seatMap.containsKey(tempSeat.getSeatID())) {
							Seat seat = seatMap.get(tempSeat.getSeatID());
							seat.setReservation();
							seatMap.put(seat.getSeatID(), seat);

						}

					}

					result = Helper.RESERVATION_SUCCESS;

					holdSeatMap.remove(seatHoldId);

				} else {

					result = Helper.RESERVATION_UNSUCCESSFUL;

				}

			}else {
				
				result = Helper.NO_TICKETS;
			}
		} catch (Exception e) {
			System.out.println("Error occurred. Unable to reserve the seats");
			e.printStackTrace();
		}
		return result;

	}

}