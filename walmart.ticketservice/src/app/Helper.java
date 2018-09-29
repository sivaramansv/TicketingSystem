package app;

import java.util.UUID;

/**
 * @author svsivaraman
 * 
 * 
 * Helper class containing all commonly used constants and functions
 */
public class Helper {

	public static final String THEATER_NAME="Cinema Paradise";
	public static final int MAX_ID=100000;
	public static final int TOTAL_SEATS=50;
	public static final String RESERVATION_SUCCESS="Your reservation was successful";
	public static final String RESERVATION_UNSUCCESSFUL="Your reservation was unsuccessful. Please check your id again.";
	public static final String NO_TICKETS="No tickets available. Please try the next show.";
	
	/**
	 * This method generates a GUID
	 * @return randomId
	 */
	public static String generateUUID() {
		
		UUID uuid = UUID.randomUUID();
        String randomId = uuid.toString();
		
        return randomId;
	}
	
	
}