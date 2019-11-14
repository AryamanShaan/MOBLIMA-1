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

public class Booking {
    private String ticketType;
    private double basePrice;
    private String movie;
    private String date;
    private int screen_id;
    private String cineplex;
    private int TID;
    private double GST;
    private double totalPrice;
    private int row;
    private int col;
    private Date date2;
    private Customer customer;
    private int age;
    private boolean is3D;
    private int price3D =0;
    
   
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
    

    public void printBookingDetail() {
    	System.out.println("_____________________________________________________________");
    	System.out.println("RECEIPT");
    	System.out.println();
    	System.out.println("Customer Name     : "+ customer.getName());
    	System.out.println("Customer Mobile No: "+ customer.getAge());
        System.out.println("Movie             : "+movie);
        System.out.println("Cinema            : " + screen_id + " ("      + cineplex + ")");
        System.out.println("Showing on        : " + date);
        System.out.println("Seat              : Row " + row + " Col " +  col);
        System.out.println("Ticket type       : " + ticketType);
        System.out.println("Ticket base price : " + round(basePrice, 2) + " SGD (Excl. GST)");
        System.out.println();
    }
    
    
    
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
        //boolean isSeniorCitizen = Confirm("Are you a senior citizen (Age > 60) ? Enter Y if yes (validation will be done upon entering):");
        //boolean isSeniorCitizen = Confirm("Please enter your age: ");
        //boolean isStudent = Confirm("Are you a student (8 < Age < 25 )? Enter Y if yes (validation will be done upon entering):");
        //boolean isStudent = Confirm1("Please Enter your age");
      
        
    }
    
    
    public void generateTID() {
    	Random r = new Random();
        TID = screen_id + (r.nextInt(10000)+1);
    }
    
    public void computeTotalPrice() {
    
        if (customer.isSeniorCitizen()) basePrice *= 0.5;
        else if (customer.isStudent()) basePrice *= 0.8;
        GST = round((basePrice + 2) * 0.07, 2);
        if(is3D) price3D = 2;
        totalPrice = round(basePrice + 2 + GST + price3D, 2);
        if (customer.isSeniorCitizen()) {
        	System.out.println("50% off for senior citizen");
        }
        if (customer.isStudent()) {
        	System.out.println("20% off for students");
        }
//        if (is3D) {
//        	basePrice = basePrice + 2;
//        	System.out.println("3D Screen Price = 2");
//        }
        
        System.out.println("Payment:-");
        System.out.println();
        System.out.println("Ticket base price : " + basePrice);
        System.out.println("Booking fee       : 2.0");
        if (is3D) 
        {
        	System.out.println("3D Screen price  :2.0");
        }
        System.out.println("GST               : " + GST);
        System.out.println("Grand total       : " + totalPrice);
        System.out.println("Transaction ID    : " + TID);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("PLEASE CARRY A COPY OF THIS RECEIPT AND Ã‹NJOY YOUR MOVIE");
        System.out.println("_____________________________________________________________");
        
    }
    
    public static String readString(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    public static boolean ConfirmSeniorCitizen(int age) {
      
      if(age>60) return true;
      else return false;
     }
    
    public static boolean ConfirmStudent(int age) {
        
        if(age>8 && age<25) return true;
        else return false;
     }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
   
    
    
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









