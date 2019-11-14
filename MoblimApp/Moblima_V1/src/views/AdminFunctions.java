package views;

import java.io.*;
import java.util.*;
public class AdminFunctions {

	public static void main(String[] args) throws IOException,Exception {
		
		int choice = -1;
		Scanner ab = new Scanner(System.in);
		while(choice > 4 || choice < 0) {
			System.out.println("-----------------------------------");
			System.out.println("Admin Module");
			System.out.println("-----------------------------------");
			System.out.println("1: CRUD Movie Listing");
			System.out.println("2: CRUD Seat Listing");
			System.out.println("3: Configure system settings");
			System.out.println("4: Go Back");
			System.out.print("Please enter your choice: ");
			choice = ab.nextInt();
		}
		System.out.println();
		if (choice == 1) {
			MovieCRUD.main(null);
		}
		else if(choice == 2) {
			ScreenCRUD_admin.main(null);
		}
		else if(choice == 3) {
			SystemSettings.main(null);
		}
		else if(choice == 4) {
			Main.main(null);
		}
			
		
		
		//ab.close();
	}

}
