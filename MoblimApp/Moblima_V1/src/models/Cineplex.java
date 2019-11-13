package models;

import java.util.*;

public class Cineplex {
	
	//declaring variables
	private String location; //location of the cineplex
	private int screen;
	/*
	Screen array or object, needs to be decided by shaan
	*/
	private String memberLevel; //membership level eg: Platinum, Gold etc. is provided as String
	private String movieType; //type pf movie eg: Blockbuster etc. is provided as String
	private boolean holiday;
	private String category; //category of movie-goer eg:adult etc. also provided as a String
	private int price = 0;
	
	//constructor for initialization
	public Cineplex(String location, int screen, String memberLevel, String movieType, boolean holiday, String category) {
		this.location = location;
		this.screen = screen;
		this.memberLevel = memberLevel;
		this.movieType = movieType;
		this.holiday = holiday;
		this.category = category;
	}
	
	//function to return location
	public String getLocation() {
		return location;
	}
	
	//function to return screen number
	public int getScreen() {
		return screen;
	}
	
	//function to return level of membership
	public String getMemberLevel() {
		return memberLevel;
	}
	
	//function to return type of the movie
	public String getMovieType() {
		return movieType;
	}
	
	//function to return whether holiday or not
	public boolean getHoliday() {
		return holiday;
	}
	
	//function to return age category
	public String getCategory() {
		return category;
	}
	
	//function to return base price based on member_level
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
	
	//function to return base price based on movie type
	private int getBasePriceMovieType(String movieType) {
		if(movieType.equals("Blockbuster")) {
			return 8;
		}else if(movieType.equals("3D")) {
			return 10;
		}
		return 5;
	}
	
	//function to return base price based on whether a holiday or not
	private int getBasePriceHoliday(boolean holiday) {
		if(holiday) {
			return 10;
		}
		return 5;
	}
	
	//function to return base price based on age category
	private int getBasePriceCategory(String category) {
		if(category.equals("Adult")) {
			return 15;
		}else if(category.equals("Senior Citizen")) {
			return 12;
		}
		return 10;
	}
	
	//function to return total ticket cost, which makes use of helper functions defined above
	public int getTicketPrice(String memberLevel, String movieType, boolean holiday, String category) {
		return (getBasePriceMemberLevel(memberLevel) + getBasePriceMovieType(movieType) + getBasePriceHoliday(holiday) + getBasePriceCategory(category)); 
	}
}
