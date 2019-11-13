package views;

import java.io.*;
import java.util.*;

import controllers.*;

public class Login {

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
		AdminFunctions.main(null);
		sc.close();
	}

}
