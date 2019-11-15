package controllers;
import java.io.*;
import models.*;

public class MovieCreate {
	public static void WriteMovie(String name, String type, String status, String rating, String synopsis, String director, String[] cast, boolean x) throws IOException {
		
		Movie movie = new Movie(name, type, status, synopsis, director, cast, rating, x);
		movie.writeMovie();
		System.out.println("Movie: "+ name + " created in the database!");
	}
}
