package views;

import java.io.IOException;
import java.util.*;

public class SystemSettings {

	public static void main(String[] args) throws IOException, Exception {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("1. Create Holiday");
		System.out.println("2. Go Back");
		System.out.println("Enter choice:");
		choice = sc.nextInt();
		
		while(choice < 1 || choice > 2) {
			System.out.println("Enter correct choice:");
			choice = sc.nextInt();
		}
		
		if(choice == 1) {
			CreateHoliday.main(null);
		}
		else if(choice == 2) {
			AdminFunctions.main(null);
		}
		

	}

}
