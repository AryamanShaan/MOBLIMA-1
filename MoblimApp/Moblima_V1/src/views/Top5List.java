package views;

import java.io.*;
import java.util.*;

/**
 * Used to display the top 5 movies according to their rating
 * @author Anon
 *
 */
public class Top5List {
	
	/**
	 * The main function for this view
	 * @param args for the main function
	 * @throws IOException to throw the exception
	 */
	public static void main(String[] args) throws IOException {

		Scanner sc_input = new Scanner(System.in);
		
		/**
		 * hashmap to track the sum of the movie ratings
		 */
		HashMap<String,Double> movieRatingsSum = new HashMap<String,Double>();
		
		/**
		 * hashmap to track the number of the review
		 */
		HashMap<String,Integer> reviewNumber = new HashMap<String,Integer>();
		
		/**
		 * hashmap to track the sum of movie ratings
		 */
		HashMap<String,Double> movieRatingsAvg = new HashMap<String,Double>();
		
		
		String fileName = "review.txt";
		String line;
		FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader); 
        while((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);
            String[]  movie= line.split(",");
            if(!movieRatingsSum.containsKey(movie[0])) {
				movieRatingsSum.put(movie[0],Double.parseDouble(movie[2]));
				reviewNumber.put(movie[0],1);
			//else calculate the sum of ratings
			}else {
				double new_sum = (movieRatingsSum.get(movie[0]) + Double.parseDouble(movie[2]));
				movieRatingsSum.put(movie[0],new_sum);
				reviewNumber.put(movie[0], reviewNumber.get(movie[0]) + 1);
			}
        }   
        bufferedReader.close();
		
		//calculate average rating for each movie
		for(String movie : movieRatingsSum.keySet()) {
			movieRatingsAvg.put(movie,movieRatingsSum.get(movie)/reviewNumber.get(movie));
		}
		
		//arrays for top 5 movies and their ratings, stored in separate arrays
		String[] max_rating_movies = new String[5];
		Double[] max_ratings = new Double[5];
		int counter = 0;
		
		//decide the top 5 movies
		for(String movie : movieRatingsAvg.keySet()) {
			if(counter < 5) {
				max_rating_movies[counter] = movie;
				max_ratings[counter] = movieRatingsAvg.get(movie);
				counter++;
			}else {
				
				//decide index of minimum rating in the array
				int min_index = 0;
				double min = max_ratings[min_index];
				for(int i = 0; i < 5; i++) {
					if(max_ratings[i] < min) {
						min_index = i;
						min = max_ratings[i];
					}
				}
				
				//replace if a movie has a higher rating
				if(movieRatingsAvg.get(movie) > min) {
					max_rating_movies[min_index] = movie;
					max_ratings[min_index] = movieRatingsAvg.get(movie);
				}
			}
		}
		
		System.out.println("-----------------------------------");
		System.out.println("Top 5 movies according to rating");
		System.out.println("-----------------------------------");
		
		//remaining printing
		for(int i = 0; i < 5; i++) {
			System.out.print(max_rating_movies[i] + " : ");
			System.out.println(max_ratings[i]); 
		}
		System.out.println();
	}
}

