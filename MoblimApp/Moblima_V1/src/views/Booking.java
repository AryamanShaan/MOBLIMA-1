package views;
import models.*;
import views.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This view governs the logic behind pricing of tickets
 * @author Anon
 *
 */
public class Booking {
	/**
	 * This is the object of class Customer who is booking the ticket
	 */
	private Customer customer;
	
	/**
	 * This is a Date object indicating the Date of the show for which movie ticket is being booked 
	 */
	private Date date2;
	
	/**
	 * Ticket type showing Weeekday, Weekend or Public Holiday 
	 */
    private String ticketType;
    
    /**
     * Movie for which the ticket is booked
     */
    private String movie;
    
    /**
     * Date of the show in the form of a string
     */
    private String date;
    
    /**
     * Cineplex to which the screen belongs
     */
    private String cineplex;
    
    /**
     * Transaction ID for each ticket
     */
    private String TID;
    
    /**
     * Baseprice of the ticket
     */
    private double basePrice;
    
    /**
     * GST cost for each ticket
     */
    private double GST;
    
    /**
     * Total price for each ticket
     */
    private double totalPrice;
    
    /**
     * Price for ticket based on its criteria of Platinum, Gold or Silver
     */
    private double seatChoice = 0;
    
    /**
     * Price for movie based on whether it is 3D or not
     */
    private int price3D =0;
    
    /**
     * Unique screen ID for each Screen
     */
    private int screen_id;
    
    /**
     * Row number for which the ticket is booked
     */
    private int row;
    
    /**
     * Column number for which the ticket is booked
     */
    private int col;
    
    /**
     * Age of the customer
     */
    private int age;
    
    /**
     * Variable indicating if the movie is 3D
     */
    private boolean is3D;
	
    /**
     * Creates a Booking object with the following parameters
     * @param row Row of the seat being booked
     * @param col Column of the seat being booked 
     * @param movie Movie for which the ticket is being booked
     * @param screen_id Screen ID for which the ticket is being booked
     * @param isScreen3d1 Variable checking if movie is 3D
     * @param date Date as String for which ticket is being booked 
     * @param cineplex Cineplex at which the movie would be shown
     * @throws ParseException
     * @throws IOException
     */
    
    public Booking(int row, int col, String movie , int screen_id, boolean isScreen3d1, String date, String cineplex) throws ParseException, IOException {
        this.row = row;
        this.col = col;
        basePrice = 10;
        this.movie = movie;
        this.screen_id = screen_id;
        this.date = date;
        this.is3D = isScreen3d1; 
        this.cineplex = cineplex;
        computeBasePrice();
    }
    
     /**
     * This function calculates price based on the date 
     * on which the show would be shown
     * @throws ParseException
     * @throws IOException
     */
	
    public void computeBasePrice() throws ParseException, IOException {
    	
    	
    	Date date2=new SimpleDateFormat("MM-dd-yyyy").parse(date);  
    	 
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); 
 
        simpleDateformat = new SimpleDateFormat("EEEE"); 
        System.out.println("Day of show: "+ simpleDateformat.format(date2));
        String newDate = date.replace('-','/');
        if(Holiday.checkHoliday(newDate)) {
        	System.out.println("This date is a Public Holiday");
        	ticketType = "Public Holiday";
        	basePrice = 1.5 * basePrice;
        }
        else if((simpleDateformat.format(date2)).equals("Saturday") || (simpleDateformat.format(date2)).equals("Sunday"))
        {
        	ticketType = "Weekend";
        	basePrice = 1.3 * basePrice;
        }
        else
        {
        	ticketType = "Weekday";
        	
        }
      }
    
     /**
     * This function prints the Final Ticket Receipt
     */

    public void printBookingDetail() {
    	System.out.println("_____________________________________________________________");
    	System.out.println("RECEIPT");
    	System.out.println();
    	System.out.println("Customer Name     : "+ customer.getName());
    	System.out.println("Customer Age      : "+ customer.getAge());
    	System.out.println("Customer Mobile No: "+ customer.getMobile());
        System.out.println("Movie             : "+movie);
        System.out.println("Cinema            : " + screen_id + " (" + cineplex + ")");
        System.out.println("Showing on        : " + date);
        System.out.println("Seat              : Row " + row + " Col " +  col);
        System.out.println("Ticket type       : " + ticketType);
        System.out.println("Ticket base price : " + round(basePrice, 2) + " SGD (Excl. GST)");
        System.out.println();
    }
    
    /**
     * This function asks the user for its information
     * @throws IOException
     */
    
    public void promptCustomerInformation() throws IOException{
    	Scanner sc = new Scanner(System.in);
    	System.out.println();
        String name = readString("Please enter your Name:");
        String mobile = readString("Please enter your Mobile Number:");
        String email = readString("Please enter your Email address:");
        System.out.println();
        System.out.println("_____________________________________________________________________________________________________________________________________");
        System.out.println("You will be applicable for Senior Citizen Discount if age is greater than 60. Validation would be done while entering the cinema.");
        System.out.println("You will be applicable for Student Discount if age is between than 6 and 25. Validation would be done while entering the cinema.");
        System.out.println("_____________________________________________________________________________________________________________________________________");
        System.out.println();
        System.out.println("Please enter your Age: ");
		age = sc.nextInt();
		boolean isSeniorCitizen = ConfirmSeniorCitizen(age);
		boolean isStudent = ConfirmStudent(age);
        customer = new Customer(name, age, mobile, email, isSeniorCitizen, isStudent);
        generateTID();
        writeBookingHistory(customer);
        
        
    }
    
     /**
     * This function generates the Transaction ID for each ticket
     */
    public void generateTID() {
    	Random r = new Random();
        TID = cineplex.toUpperCase().substring(0,3)+new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
    }
    
     /**
     * This function computes and prints total price of the 
     * ticket based on date of show, age of user,  class 
     * of seat selected, whether the movie is 3D, GST.
     */
    public void computeTotalPrice() throws IOException {
    
        if (customer.isSeniorCitizen()) basePrice *= 0.5;
        else if (customer.isStudent()) basePrice *= 0.8;
        GST = round((basePrice + 2) * 0.07, 2);
        if (customer.isSeniorCitizen()) {
        	System.out.println("50% off for senior citizen");
        }
        if (customer.isStudent()) {
        	System.out.println("20% off for students");
        }

        
        System.out.println("Payment:-");
        System.out.println();
        System.out.println("Ticket base price : " + basePrice);
        System.out.println("Booking fee       : 2.0");
        if (Movie.check3D(movie)) 
        {
        	System.out.println("3D Movie price    : 2.0");
        }
        if(0 < row && row < 4) 
        {
        	seatChoice = 2.5;
        	System.out.println("Platinum Seat Price: 2.5");
        }
        else if(3 < row && row < 10)
        {
        	seatChoice = 1.5;
        	System.out.println("Gold Seat Price   : 1.5");
        }
        else if(9 < row && row < 16)
        {
        	seatChoice = 0.5;
        	System.out.println("Silver Seat Price : 0.5");
        }
        if(Movie.check3D(movie)) price3D = 2;
        totalPrice = round(basePrice + 2 + GST + price3D +seatChoice, 2);
        System.out.println("GST               : " + GST);
        System.out.println("Grand total       : " + totalPrice);
        System.out.println("Transaction ID    : " + TID);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("PLEASE CARRY A COPY OF THIS RECEIPT AND ENJOY YOUR MOVIE");
        System.out.println("_____________________________________________________________");
        
    }
    
    /**
     * This is a function defined to print a message and 
     * read in the corresponding entry by user 
     * @param message Message that is shown on the screen
     * @return Value entered by the user
     */	
    public static String readString(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
	
    
    /**
     * This function calculates if the user is a 
     * senior citizen on the basis of age entered
     * @param age Age of the user
     * @return boolean variable indicating if the user is senior citizen
     */
    public static boolean ConfirmSeniorCitizen(int age) {
      
      if(age>60) return true;
      else return false;
     }
    
    /**
     * This function calculates if the user is a 
     * student on the basis of age entered
     * @param age Age of the user
     * @return boolean variable indicating if the user is senior citizen
     */	
    public static boolean ConfirmStudent(int age) {
        
        if(age>8 && age<25) return true;
        else return false;
     }
    
     /**
     * This is a function used to round up values computed
     * @param value The original value
     * @param places Number of decimal places to which the value should be rounded up to 
     * @return final value after rounding up
     */	
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
   
    
     /**
     * This function writer the data of the user into the BookingHistory.txt File
     * @param cust User who booked the ticket
     * @throws IOException
     */
	public void writeBookingHistory(Customer cust) throws IOException{
		try {
			File file = new File("BookingHistory.txt");
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			PrintWriter pr = new PrintWriter(br);
			String cust_data = TID+","+cust.getName()+","+cust.getAge()+","+date+","+movie+","+cust.getEmail()+","+cust.getMobile();
			pr.println(cust_data);
			pr.close();
			br.close();
			fr.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
    
    
}
