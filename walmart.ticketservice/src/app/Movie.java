package app;

/**
 * @author svsivaraman
 *
 * Movie class represents the movie screened in a theater
 */
public class Movie {

	private String movieName = null;
	private String showTime = null;

	/**
	 * This method sets the movie name
	 * 
	 * @param movieName
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;

	}

	/**
	 * This method sets the screening time
	 * 
	 * @param screeningTime
	 */
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	/**
	 * This method gets the movie name
	 * 
	 * @return
	 */
	public String getMovieName() {

		return movieName;
	}

	/**
	 * This method gets the screening time of par
	 * 
	 * @return screeningTime
	 */
	public String getShowTime() {

		return showTime;
	}
}