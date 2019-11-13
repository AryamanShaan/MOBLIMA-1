package models;

import java.util.*;



public class BookingHistory {

    private ShowTime showTime;
    private String transactionId;   // transaction ID 
    private double ticketPrice;
    private Customer user;   

    public BookingHistory(ShowTime st, String tid, double tp, Customer us){
        this.showTime = st;
        this.transactionId = tid;
        this.ticketPrice = tp;
        this.user = us;
    }

    public ShowTime getShowTime(){
        return this.showTime;
    }

    public String getTransactionId(){
        return this.transactionId;
    }

    public double getTicketPrice(){
        return this.ticketPrice;
    }

    public Customer getUser(){
        return this.user;
    }

    public void setShowTime(ShowTime st){
        this.showTime = st;
    }

    public void setTransactionId(String tid){
        this.transactionId = tid;
    }

    public void setTicketPrice(double tp){
        this.ticketPrice = tp;
    }

    public void setUser(Customer us){
        this.user = us; 
    }

}
