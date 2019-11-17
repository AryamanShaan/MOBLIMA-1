package views;
import java.io.*;
import java.util.*;

import controllers.*;
/**
 * Login view
 * @author Anon
 *
 */
public class Login {
	/**
	 * Main function driving the view
	 * @param args null argument can be used to drive the function
	 * @throws Exception Throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String id, pass;
		Scanner sc = new Scanner(System.in);
		AdminLogin x = new AdminLogin();
		System.out.println("L O G I N");
		do {
			System.out.print("ID: ");
			id = sc.next();
			System.out.print("Password: ");
			pass = sc.next();
		} while(x.checkLogin(id, pass) == -1);
		System.out.println();
		AdminFunctions.main(null);
		System.out.println();
		sc.close();
	}

}
