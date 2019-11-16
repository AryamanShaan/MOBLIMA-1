package views;
import java.io.IOException;
//import java.io.*;
import java.util.*;

/**
 * Main view initiated at the start of the app
 * @author Anon
 *
 */
public class Main {
	/**
	 * main function driving the view
	 * @param args: null argument can be used to call the view
	 * @throws IOException: Throws IOException
	 * @throws Exception: Throws Exception
	 */
	public static void main(String[] args) throws IOException, Exception {
		
		int choice = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------------------------");
		System.out.println("MOBLIMA");
		System.out.println("-----------------------------------");
		
		System.out.println("1: Admin Module");
		System.out.println("2: User Module");
		System.out.println("3: Exit");
		System.out.print("Please enter the module you want to access: ");
		choice = sc.nextInt();
		
		while(choice > 3 || choice < 0) {
			System.out.println("Please enter a valid option.");
			System.out.println("1: Admin Module");
			System.out.println("2: User Module");
			System.out.println("3: Exit");
			System.out.print("Please the module you want to access: ");
			choice = sc.nextInt();
		}
		
		System.out.println();
		
		if (choice == 1) {
			Login.main(null);
		}
		else if(choice == 2){
			UserFunctions.main(null);
		}
		else {
			System.out.println("Thanks for using MOBLIMA!");
			System.exit(0);
		}
	}

}
