package models;

import java.util.*;
import java.io.File;

/**
 * Represents the ratings for a movie
 * @author Anon
 *
 */
public class Review {
	
	/**
	 * The movie that is being considered
	 */
	private final Movie MOVIE;
	
	/**
	 * Date on when it is reviewed
	 */
	private final Date REVIEWED_ON;
	
	/**
	 * The rating for the movie
	 */
	private final int RATING;
	
	/**
	 * The name of the reviewer
	 */
	private final String REVIEWER;
	
	/**
	 * The review itself
	 */
	private final String DESCRIPTION;
	
	/**
	 * To create the review for the movie
	 * @param movie the movie being reviewed
	 * @param rating rating for the movie
	 * @param reviewer name of the reviewer
	 * @param description the review itself
	 */
	public Review(Movie movie, int rating, String reviewer, String description) {
		this.MOVIE = movie;
		this.RATING = rating;
		this.REVIEWER = reviewer;
		this.DESCRIPTION = description;
		this.REVIEWED_ON = new Date();
	}
	
	/**
	 * Get the movie being reviewed
	 * @return the movie
	 */
	public Movie getMovie() {
		return MOVIE;
	}
	
	/**
	 * Get the date on which the movie is reviewed
	 * @return the date on which the movie is reviewed
	 */
	public Date getReviewedOn() {
		return REVIEWED_ON;
	}
	
	/**
	 * Get the name of the reviewer
	 * @return the name of the reviewer
	 */
	public String getReviewer() {
		return REVIEWER;
	}
	
	/**
	 * get the review
	 * @return the review for the movie
	 */
	public String getDescription() {
		return DESCRIPTION;
	}
	
	/**
	 * Get the rating for the movie
	 * @return the rating for the movie
	 */
	public int getRating() {
		return RATING;
	}
}



