package models;

import java.util.*;
import java.io.File;

public class Review {
	
	//declaring all the variables for a particular review
	private final Movie MOVIE;
	private final Date REVIEWED_ON;
	private final int RATING;
	private final String REVIEWER;
	private final String DESCRIPTION;
	
	//constructor to initialise the variables
	public Review(Movie movie, int rating, String reviewer, String description) {
		this.MOVIE = movie;
		this.RATING = rating;
		this.REVIEWER = reviewer;
		this.DESCRIPTION = description;
		this.REVIEWED_ON = new Date();
	}
	
	//function to return the movie being reviewed
	public Movie getMovie() {
		return MOVIE;
	}
	
	//function to return the date on which the movie is reviewed
	public Date getReviewedOn() {
		return REVIEWED_ON;
	}
	
	//function to return the reviewer name
	public String getReviewer() {
		return REVIEWER;
	}
	
	//function to return the description of the review by the reviewer
	public String getDescription() {
		return DESCRIPTION;
	}
	
	//function to return the rating of the movie by the reviewer
	public int getRating() {
		return RATING;
	}
}

