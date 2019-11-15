package views;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Review {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------------------------");
		System.out.println("Leave a rating");
		System.out.println("-----------------------------------");
		
		
		int i = 1;
		String line = null;
		HashMap<Integer,String> movies= new HashMap<Integer,String>();
        FileReader fileReader = new FileReader("Movie.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader); 
        while((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);
            String[] x = line.split(",");
            System.out.println(i++ +". " + x[0]);
        	movies.put(i, x[0]);
        }   
        bufferedReader.close();
        System.out.print("Enter the movie you want to write a review for: ");
        int movie_number = sc.nextInt();
        String movie_to_review = movies.get(movie_number);
        
        System.out.println();
        System.out.println("Enter your name:");
        String name = sc.next();
        
        System.out.println();
        System.out.println("Enter the rating for the movie:");
        double rating = sc.nextDouble();
        
        String Save = movie_to_review+","+name+","+rating;
        
		try {
			File file = new File("review.txt");
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			PrintWriter pr = new PrintWriter(br);
			pr.println(Save);
			pr.close();
			br.close();
			fr.close();
			System.out.println();
			System.out.println("Rating entered successfully!");
			System.out.println();
			UserFunctions.main(null);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
