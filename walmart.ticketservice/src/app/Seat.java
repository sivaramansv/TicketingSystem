package app;

/**
 * @author svsivaraman
 * 
 * Seat class represents the seats in the theater
 */
public class Seat {

	private int seatID;
	private boolean isReserved;
	private boolean isHold;

	/**
	 * 
	 * This is a constructor for Seat class
	 * 
	 */
	public Seat() {

		this.seatID = 0;
		this.isHold = false;
		this.isReserved = false;

	}

	/**
	 * This method sets the Seat ID
	 * 
	 * @param seatId
	 */
	public void setSeatID(int seatID) {

		this.seatID = seatID;

	}

	/**
	 * This method holds a particular seat ID
	 */
	public void setHold() {

		if (!checkHoldStatus()) {

			this.isHold = true;
		}
	}

	/**
	 * This method reserves a particular seat ID
	 */
	public void setReservation() {

		if (!checkReservation()) {

			this.isReserved = true;
		}
	}

	/**
	 * This method gets the Seat ID
	 * 
	 * @param seatId
	 */
	public int getSeatID() {

		return seatID;

	}

	/**
	 * This method reserves a particular seat ID
	 * 
	 * @return isReserved
	 */
	public boolean checkReservation() {

		return isReserved;

	}

	/**
	 * This method holds a particular seat ID
	 * 
	 * @return isHold
	 */
	public boolean checkHoldStatus() {

		return isHold;

	}

}
