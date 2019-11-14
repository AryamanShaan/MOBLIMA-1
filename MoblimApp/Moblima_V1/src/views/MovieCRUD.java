package views;

import java.io.*;
import java.util.*;
public class MovieCRUD {

	public static void main(String[] args) throws Exception {
		int choice = -1;
		Scanner sc = new Scanner(System.in);
		while(choice > 4 || choice < 0) {
			System.out.println("-----------------------------------");
			System.out.println("C R U D System - Movies");
			System.out.println("-----------------------------------");
			System.out.println("1: Create Movie");
			System.out.println("2: Update Movie");
			System.out.println("3: Delete Movie");
			System.out.println("4: Go Back");
			System.out.print("Please enter a choice: ");
			choice = sc.nextInt();
		}
		System.out.println();
		if(choice == 1) {
			CreateMovie.main(null);
		}
		else if(choice == 2) {
			UpdateMovie.main(null);
		}
		else if(choice == 3){
			DeleteMovie.main(null);
		}
		else if(choice == 4){
			AdminFunctions.main(null);
		}
	}

}
