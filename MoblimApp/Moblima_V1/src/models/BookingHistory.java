package models;

import java.util.*;

/**
 * Class having objects related to Booking History
 * @author Anon
 *
 */

public class BookingHistory {
	
	/**
	 * Creating an object of Showtime class
	 */
    private ShowTime showTime;
    
    /**
     * This is Transaction Id
     */
    private String transactionId;   
    
    /**
     * This is Ticket Price
     */
    private double ticketPrice;
    
    /**
     * Creating an object of Customer class
     */
    private Customer user;   

    /**
     * Creates a Booking History object with the given parameters
     * @param st This is the showtime of the ticket booked
     * @param tid This is the transaction ID of the ticket booked
     * @param tp This is the ticket price of the ticket booked
     * @param us This is the user who has booked the ticket
     */
    public BookingHistory(ShowTime st, String tid, double tp, Customer us){
        this.showTime = st;
        this.transactionId = tid;
        this.ticketPrice = tp;
        this.user = us;
    }

    /**
     * Gets the showtime for which the ticket is booked
     * @return showtime for the ticket booked
     */
    public ShowTime getShowTime(){
        return this.showTime;
    }

    /**
    Gets the transaction ID for which the ticket is booked
     * @return transaction ID for the ticket booked
     */
    public String getTransactionId(){
        return this.transactionId;
    }

    /**
    Gets the ticket price for which the ticket is booked
     * @return ticket price for the ticket booked
     */
    public double getTicketPrice(){
        return this.ticketPrice;
    }

    /**
    Gets the customer who booked the ticket
     * @return customer who booked the ticket
     */
    public Customer getUser(){
        return this.user;
    }

    /**
     * Sets the showtime of the movie for which the ticket is being booked
     * @param st Showtime of movie for which ticket is being booked
     */
    public void setShowTime(ShowTime st){
        this.showTime = st;
    }
    
    /**
     * Sets the transaction ID for the ticket being booked
     * @param tid Transaction ID for the ticket being booked
     */
    public void setTransactionId(String tid){
        this.transactionId = tid;
    }

    /**
     * Sets the ticket price for the ticket being booked
     * @param tid ticket price for the ticket being booked
     */
    public void setTicketPrice(double tp){
        this.ticketPrice = tp;
    }

    /**
     * Sets the user who is booking the tickets
     * @param tid User who is booking the tickets
     */
    public void setUser(Customer us){
        this.user = us; 
    }

}
