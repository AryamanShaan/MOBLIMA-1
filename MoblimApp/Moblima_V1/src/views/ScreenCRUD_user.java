/* Note: 
 * This CRUD has been implemented keeping admin in mind
 * For User a separate CRUD for screen will exist
 * In this CRUD you can add show times
 * I the other user CRUD you will be able to book seats		
 * Also proof of concept of object serialization
 * 			
 * */
package views;
import models.*;


import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;

/**
 * This View Class is used for the User to view available Show Time and Book Seats
 * 
 * @author Anon
 *
 */
public class ScreenCRUD_user extends ScreenCRUD{
	

/**
* The main function of this View
* 
* @param args
* @throws Exception
*/
public static void main(String[] args) throws Exception {
		
		int choice = -1;
		Scanner sc = new Scanner(System.in);
		
		ScreenCRUD_user screencrud = new ScreenCRUD_user();
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("Show Times & Booking Seats");
		System.out.println("------------------------------------");
		System.out.println("1: View All Show Times");
		System.out.println("2: Book Seats");
		System.out.println("3: Go Back");
		System.out.print("Please enter an option: ");
		choice = sc.nextInt();
		
		while(choice > 3 || choice < 1) {
			
			System.out.println();
			System.out.println("------------------------------------");
			System.out.println("Show Times & Booking Seats");
			System.out.println("------------------------------------");
			System.out.println("1: View All Show Times");
			System.out.println("2: Book Seats");
			System.out.println("Enter 0 to Exit");
			System.out.print("Please enter an option: ");
			System.out.println();
			choice = sc.nextInt();
		}
			if (choice == 1) {
				screencrud.readShowTime();
				ScreenCRUD_user.main(null);
			}
			
			if (choice == 2) {
				screencrud.bookSeats();
				ScreenCRUD_user.main(null);
			}
			if(choice == 3) {
				UserFunctions.main(null);
			}
			
		
			
	}

	 /**
          * Reads out all the Show Times of a Screen(Cinema) with its details
          */
	public void readShowTime() {
		readScreen();
		
		int i;
		int j;
		for(i=0; i< no_Screen; i++) {
			
			if(arr_Screen[i].get_no_Show_time()!=0) {
				System.out.println();
				System.out.println("Show Times for Screen ID: "+(i+1)+ " are: ");
				System.out.println("---------------------------------------------------------");
				
				for(j=0; j< arr_Screen[i].get_no_Show_time(); j++) {
					System.out.print("Show Time ID:	"+ arr_Screen[i].arr_Show_time[j].get_ID()+"; ");
					System.out.print("movie: "+ arr_Screen[i].arr_Show_time[j].get_movie()+"; ");
					System.out.print("Date: "+ arr_Screen[i].arr_Show_time[j].get_date()+"; ");
					System.out.print(" Time: "+ arr_Screen[i].arr_Show_time[j].get_time()+"; ");
					System.out.println();
				}
			System.out.println();
			}
		}
		
		writeScreen();
	}
	
	/**
	 * Books Seats for a Show Time and takes details from the User to do the same
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	public void bookSeats() throws ParseException, IOException {
		readScreen();
		
		Scanner sc = new Scanner(System.in);
		int ID, i = 0;
		int row = 0, col = 0;
		int sID;
		boolean flag1 = true;
		boolean flag2 = true;
		System.out.println("Enter Screen id");
		ID = sc.nextInt();
		
		if(ID<=9 && ID>=1) {
			flag1= false;
			System.out.println("Enter Show Time id");
			sID = sc.nextInt();
			for(i=0; i< arr_Screen[ID-1].get_no_Show_time(); i++) {
				if(arr_Screen[ID-1].arr_Show_time[i].get_ID()==sID) {
					flag2= false;
					boolean full= true;
					for (int a = 0; a< arr_Screen[ID-1].arr_Show_time[i].get_numOfRows(); a++) {
						for(int b=0; b< arr_Screen[ID-1].arr_Show_time[i].get_numOfColumns(); b++) {
							if(arr_Screen[ID-1].arr_Show_time[i].seat_layout[a][b].isBooked()==false) {
								full = false;
								break;
							}
							if(!full)
								break;
						}
					}
						
					if(full) {
						System.out.println("This Show Time is all booked, sorry!");
						break;
					}
					
					
					System.out.println("The seat layout is as follows:");
					System.out.println();
					arr_Screen[ID-1].arr_Show_time[i].view_layout_booked();
					System.out.println();
					System.out.println("---------------------------------------");
					System.out.println("Platinum Class : Rows 1 - 3");
					System.out.println("Gold Class     : Rows 4 - 9");
					System.out.println("Silver Class   : Rows 10- 15");
					System.out.println("---------------------------------------");
					System.out.println();
					System.out.println("Enter row");
					row = sc.nextInt();
					System.out.println("Enter column");
					col = sc.nextInt();
					
					if((0<=row&&row<arr_Screen[ID-1].arr_Show_time[i].get_numOfRows())&&(0<=col&&col<arr_Screen[ID-1].arr_Show_time[i].get_numOfColumns())) {   //This part is harcoded for now
						
						if(arr_Screen[ID-1].arr_Show_time[i].view_seat_booked(row,col)) {
							System.out.println("This seat is already booked! Try another seat!");
							i--;
							continue;
						}
						arr_Screen[ID-1].arr_Show_time[i].book_on_click(row, col);
						System.out.println("Now layout is as follows:");
						System.out.println();
						arr_Screen[ID-1].arr_Show_time[i].view_layout_booked();
					}   
					else {
						System.out.println("Sorry seat co-ordinates are out of bounds!");
					}
					
					break;
				}
				
				if(i==arr_Screen[ID-1].get_no_Show_time()) {
					System.out.println("No such show, try again!");
				}
			}
		}
		else {
			System.out.println("Such Screen ID does not exist, try again!");
		}
		
		if(!flag1 && !flag2) {
			Booking book = new Booking(row, col, arr_Screen[ID-1].arr_Show_time[i].get_movie(), arr_Screen[ID-1].get_screenID(), arr_Screen[ID-1].get_screenType(),arr_Screen[ID-1].arr_Show_time[i].get_date(),arr_Screen[ID-1].get_cineplexType());
			book.promptCustomerInformation();
			book.printBookingDetail();
			book.computeTotalPrice();
			writeScreen();
		}
		else {
			System.out.println();
			System.out.println("Such a Screen ID or Show Time ID does not exist, please try again!!");
		}
		
	}

}
