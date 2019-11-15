package views;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class MovieDetails {
	 
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
		/*
		//open the required file
		File file = new File("Movie.txt");
		int flag = 0;
		
		//scanner class for reading the file
		Scanner sc = new Scanner(file);
		Scanner sc_input = new Scanner(System.in);
		
		//take query by user
		System.out.println("Enter the movie name to know its details:");
		String movie_query = sc_input.nextLine();
		
		//loop through the entries in the movie listing, to match query, till end of file
		while(sc.hasNextLine()) {
			
			//split entries based on comma
			String[] movie = sc.next().split(",");
			for(int k = 0; k < movie.length; k++) {
				System.out.println(movie[k]);
			}
			//if query matches with an entry
			if(movie[0].equals(movie_query)) {
				flag = 1;
				//display details
				System.out.println("The movie details are as follows:");
				System.out.println("Movie name: "+movie[0]);
				System.out.println("Genre: "+movie[1]);
				System.out.println("Release details: "+movie[2]);
				System.out.println("Category: "+movie[3]);
				//Array.copyOfRange to take sub-array
				System.out.println("Cast: "+String.join(", ",Arrays.copyOfRange(movie, 4, movie.length)));
				break;
			}
		}
		//close Scanner streams
		if(flag == 0) {
			System.out.println();
			System.out.println("Movie does not exist in the database!");
			System.out.println(); 
		} */
	}
	
}
