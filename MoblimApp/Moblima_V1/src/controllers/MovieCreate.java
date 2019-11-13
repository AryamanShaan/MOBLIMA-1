package controllers;
import java.io.*;
import models.*;

public class MovieCreate {
	public static void WriteMovie(String name, String type, String status, String rating, String synopsis, String director, String[] cast) throws IOException {
		
		Movie movie = new Movie(name, type, status, synopsis, director, cast, rating);
		movie.writeMovie();
		System.out.println("Movie: "+ name + " created in the database!");
	}
}
