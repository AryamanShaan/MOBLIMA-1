package views;

import java.util.*;
import java.io.*;

public class UserFunctions {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		//variable to keep track of when to exit the user module
		int exit = 0;
		while(exit != 1) {
			
			int choice = -1;
			while(choice > 7 || choice < 0) {
				System.out.println("1. Search for a movie");
				System.out.println("2. View movie details (rating included)");
				System.out.println("3. Check seat availability, book and purchase tickets");
				System.out.println("4. View Booking History");
				System.out.println("5. List top 5 ranking by overall rating");
				System.out.println("6. Go Back");
				System.out.println("7. Exit");
				System.out.println("Please enter your choice: ");
				choice = sc.nextInt();
				System.out.println();
			}
			
			if(choice == 1) {
				SearchMovie.main(null);
			}else if (choice == 2) {
				MovieDetails.main(null);
			}else if(choice == 3) {
				ScreenCRUD_user.main(null);
			}else if(choice == 4) {
				BookingHistory.main(null);
			}else if(choice == 5) {
				Top5List.main(null);
			}else if(choice == 6){
				Main.main(null);
			}else if(choice == 7) {
				exit = 1;
			}
		}
		System.out.println("Thank you for using MOBLIMA!");
		System.out.println();
	}

}
