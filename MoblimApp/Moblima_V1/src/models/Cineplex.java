package models;

import java.util.*;

/**
 * Represents the Cineplex
 * @author Anon
 *
 */
public class Cineplex {
	
	/**
	 * Location of the cineplex
	 */
	private String location;
	
	/**
	 * The screen number
	 */
	private int screen;
	
	/**
	 * Level of membership - Gold, Platinum etc.
	 */
	private String memberLevel;
	
	/**
	 * Type of movie - 3D, Blockbuster etc.
	 */
	private String movieType;
	
	/**
	 * Whether it is a holiday or not
	 */
	private boolean holiday;
	
	/**
	 * Category of the movie goer - adult, child etc.
	 */
	private String category;
	
	/**
	 * price for the ticket
	 */
	private int price = 0;
	
	/**
	 * Creates a cineplex with the given specifications
	 * @param location location of the cineplex
	 * @param screen screen number in the cineplex
	 * @param memberLevel level of membership
	 * @param movieType type of movie
	 * @param holiday whether holiday or not
	 * @param category category of movie goer
	 */
	public Cineplex(String location, int screen, String memberLevel, String movieType, boolean holiday, String category) {
		this.location = location;
		this.screen = screen;
		this.memberLevel = memberLevel;
		this.movieType = movieType;
		this.holiday = holiday;
		this.category = category;
	}
	
	/**
	 * Gets location of the cineplex
	 * @return location of the cineplex
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Gets screen number in the cineplex
	 * @return the screen number
	 */
	public int getScreen() {
		return screen;
	}
	
	/**
	 * Get the membership level
	 * @return the membership level
	 */
	public String getMemberLevel() {
		return memberLevel;
	}
	
	/**
	 * Get movie type - 3D, blockbuster etc.
	 * @return the type of the movie
	 */
	public String getMovieType() {
		return movieType;
	}
	
	/**
	 * Get holiday or not
	 * @return whether holiday or not
	 */
	public boolean getHoliday() {
		return holiday;
	}
	
	/**
	 * Get the category of movie goer
	 * @return the category of the movie goer
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Get base price based on membership level
	 * @param memberLevel level of membership
	 * @return base price based on membership level
	 */
	private int getBasePriceMemberLevel(String memberLevel) {
		if(memberLevel.equals("Member")) {
			return 20;
		}else if(memberLevel.equals("Silver")) {
			return 15;
		}else if(memberLevel.equals("Gold")) {
			return 10;
		}
		return 5;
	}
	
	/**
	 * Get base price based on type of movie
	 * @param movieType type of the movie
	 * @return the base price based on movie type
	 */
	private int getBasePriceMovieType(String movieType) {
		if(movieType.equals("Blockbuster")) {
			return 8;
		}else if(movieType.equals("3D")) {
			return 10;
		}
		return 5;
	}
	
	/**
	 * Get base price based on holiday
	 * @param holiday whether holiday or not
	 * @return base price based on whether holiday or not
	 */
	private int getBasePriceHoliday(boolean holiday) {
		if(holiday) {
			return 10;
		}
		return 5;
	}
	
	/**
	 * Get base price based on category of movie goer
	 * @param category category of the movie goer
	 * @return base price based on category of the movie goer
	 */
	private int getBasePriceCategory(String category) {
		if(category.equals("Adult")) {
			return 15;
		}else if(category.equals("Senior Citizen")) {
			return 12;
		}
		return 10;
	}
	/**
	 * calculate total base price
	 * @param memberLevel level of membership
	 * @param movieType type of the movie - 3D, Blockbuster
	 * @param holiday whether holiday or not
	 * @param category category of movie goer - adult, child etc.
	 * @return
	 */
	public int getTicketPrice(String memberLevel, String movieType, boolean holiday, String category) {
		return (getBasePriceMemberLevel(memberLevel) + getBasePriceMovieType(movieType) + getBasePriceHoliday(holiday) + getBasePriceCategory(category)); 
	}
}

