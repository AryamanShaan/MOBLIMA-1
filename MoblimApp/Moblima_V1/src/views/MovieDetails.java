package views;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * The view to get the details of all the available movies
 * @author Anon
 *
 */
public class MovieDetails {
	 
	/**
	 * The main function for this view
	 * @param args for the main function
	 * @throws Exception to throw the exception
	 */
	public static void main(String[] args) throws Exception{
		Scanner sc_input = new Scanner(System.in);
		
		System.out.println("-----------------------------------");
		System.out.println("Movie Details");
		System.out.println("-----------------------------------");
		
		//take query by user
		System.out.println("Enter the movie name to know its details:");
		String movie_query = sc_input.nextLine();
		int flag = 0;
		String fileName = "Movie.txt";
		String line;
		FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader); 
        while((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);
            String[] x = line.split(",");
            if(movie_query.equals(x[0])) {
            	flag = 1;
            	System.out.println("The movie details are as follows:");
				System.out.println("Movie name: "+x[0]);
				if(x[1].equals("true")) {
					System.out.println("3D or no?: Yes");
				}
				else {
					System.out.println("3D or no?: No");
				}
				System.out.println("Genre: "+x[2]);
				System.out.println("Release details: "+x[3]);
				System.out.println("Age restrictions: "+x[4]);
				System.out.println("Synopsis: " +x[5]);
				System.out.println("Movie director: " +x[6]);
				//Array.copyOfRange to take sub-array
				System.out.println("Cast: "+String.join(", ",Arrays.copyOfRange(x, 7, x.length)));
				break;
            }
        }   
        bufferedReader.close();
        if(flag == 0) {
        	System.out.println();
			System.out.println("Movie does not exist in the database!");
			System.out.println();
        }
        UserFunctions.main(null);
	}
	
}
