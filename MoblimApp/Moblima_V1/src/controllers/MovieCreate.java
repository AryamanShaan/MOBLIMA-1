package controllers;
import java.io.*;
import models.*;
/**
 * Controller for movie creation
 * @author Anon
 *
 */
public class MovieCreate {
	/**
	 * Function to record a movie into the database.
	 * @param name: Name of the movie
	 * @param type: Type of the movie
	 * @param status: Showing status of the movie
	 * @param rating: Age restriction of the movie
	 * @param synopsis: Synopsis of the movie
	 * @param director: Director of the movie
	 * @param cast: All actors present in the movie
	 * @param x: Value depicting if the movie is 3D or not
	 * @throws IOException: Throws IOException
	 */
	public static void WriteMovie(String name, String type, String status, String rating, String synopsis, String director, String[] cast, boolean x) throws IOException {
		
		Movie movie = new Movie(name, type, status, synopsis, director, cast, rating, x);
		movie.writeMovie();
		System.out.println("Movie: "+ name + " created in the database!");
	}
}
