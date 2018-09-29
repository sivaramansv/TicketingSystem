package app;

import java.util.List;

/**
 * 
 * @author svsivaraman
 * @version v1.0
 *
 * Main class
 */
public class Main {
		
	public static void main(String[] args)
	{
		//Display the theater details
		Theater theater = displayTheaterDetails();
		
		//In this demonstration, 3 customers are trying to book their seats
		Customer customer1 = new Customer(theater,"abc@gmail.com",2);
		Customer customer2 = new Customer(theater,"def@gmail.com",5);
		Customer customer3 = new Customer(theater,"def@gmail.com",5);
		Customer customer4 = new Customer(theater,"def@gmail.com",45);
		
		customer1.run();
		customer2.run();
		customer3.run();
		customer4.run();
			
	}
	/**
	 * This method displays the theater details
	 * @return Theater
	 */
	public static Theater displayTheaterDetails() {

		//Initialize theater object with GUID and name
		Theater theater = new Theater(Helper.generateUUID(),Helper.THEATER_NAME);
		System.out.println("******************");
		
		System.out.println("Theater ID:"+theater.getTheaterID()+"Theater name: "+theater.getTheaterName());
		System.out.println("Movies screening now on:"+ theater.getTheaterName());
		
		List<Movie> movieList = theater.getMovieListings();
		
		//List the movie screenings to the end user
		for(Movie movie:movieList) {
			
			System.out.println("Movie name:"+movie.getMovieName()+"Time:"+movie.getShowTime());
		}
		System.out.println("******************");
		
		return theater;
	}
}