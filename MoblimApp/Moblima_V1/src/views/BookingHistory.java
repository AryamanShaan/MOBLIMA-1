package views;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This is the view which writes data to the BookingHistory text file
 * @author Anon
 *
 */
public class BookingHistory {

	/**
	 * Main program controlling the flow of writing parameters to BookingHistory file
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String choice, line;
		String fileName = "BookingHistory.txt";
		System.out.println("Enter your name:");
		choice = sc.nextLine();
		
		try {
			FileReader fileReader = new FileReader(fileName);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        System.out.println("---------------------------");
	        System.out.println();
	        while((line = bufferedReader.readLine()) != null) {
	            //System.out.println(line);
	            String[] x = line.split(",");
	            if(x[1].equals(choice)) {
	            	System.out.println("TID          : " + x[0]);
	            	System.out.println("Age          : " + x[2]);
	            	System.out.println("Date of Movie: " + x[3]);
	            	System.out.println();
	            }
	        }  
	        System.out.println("---------------------------");
	        bufferedReader.close(); 
	        UserFunctions.main(null);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		 

	}

}

