package controllers;
import java.io.*;
import java.util.Scanner;
/**
 * Controller for login
 * @author Anon
 *
 */
public class AdminLogin {
	/**
	 * Function to check authenticity of the staff memeber
	 * @param ID: ID of the admin
	 * @param pass: Password for the account
	 * @return Flag indicating state of login 
	 * @throws IOException Throws IOException
	 */
	public int checkLogin(String ID, String pass) throws IOException {
		
		try {
			String text;
			File file = new File("admin.txt");
			Scanner ab = new Scanner(file);
			while(ab.hasNextLine()) {
				text = ab.nextLine();
				//System.out.println(text);
				String[] values = text.split(",");
				
				if(values[0].equals(ID)) {
					if(values[1].equals(pass)) {
						System.out.println("Login successful!");
						ab.close();
						return 0;
					 }
					else {
						System.out.println("Incorrect password!");
						ab.close();
						return -1;
					}
				 }
			}
			System.out.println("Admin with ID: " + ID + " does not exist!");
			ab.close();
			return -1;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
}
