package app;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author svsivaraman
 *
 *Theater class has seat, movie listings and other attributes.
 */
public class Theater {

	private String theaterID=null;
	private String theaterName=null;
	private List<Movie> movieList;
	private Map<Integer,Seat> seatMap=null;
	Movie movie;
	Seat seat;
	
	/**
	 * This is a constructor for Theater class
	 * @param theaterID
	 */
	public Theater(String theaterId,String theaterName) {
		
		setTheaterID(theaterId);
		setTheaterName(theaterName);
		setMovieListings();
		setSeatMap();
	}
	
	/**
	 * This method sets the ID of the theater
	 * @param theaterID
	 */
	public void setTheaterID(String theaterId) {
		
		this.theaterID= theaterId;
		
	}
	
	/**
	 * This method sets the theater name
	 * @param name
	 */
	public void setTheaterName(String name) {
		
		this.theaterName = name;
		
	}
	
	/**
	 * This method sets the movie listings.
	 * 
	 */
	public void setMovieListings() {
		
		movie = new Movie();
		movie.setMovieName("Rush Hour:"+"part:"+1);
		movie.setShowTime("9PM");
		movieList = new ArrayList<Movie>();
		movieList.add(movie);
		
	}
	
	
	/**
	 * This method sets the seating arrangement for a theater
	 */
	public void setSeatMap() {
		 
		seatMap = new ConcurrentHashMap<Integer,Seat>();
			
		for(int i=1;i<=Helper.TOTAL_SEATS;i++)
		{
			seat = new Seat();
			seat.setSeatID(i);
			seatMap.put(seat.getSeatID(), seat);
		}
		
		
	}
	
	/**
	 * This method gets the theater name
	 * @param name
	 */
	public String getTheaterName() {
		
		return theaterName;
		
	}
	
	/**
	 * This movie gets the theater ID 
	 * @return
	 */
	public String getTheaterID() {
		
		return theaterID;
	}
	
	
	/**
	 * This method gets the movie listings for a particular theater
	 * 
	 * @return
	 */
	public List<Movie> getMovieListings()
	{
		return movieList;
		
	}
	
	
	/**
	 * This method gets the seating arrangements for a particular theater
	 * 
	 * @return Seat[] objects
	 */
	
	public Map<Integer,Seat> getSeatingArrangement() {
		
		return seatMap;
	}
	
}