package models;

import java.io.*;

public class Movie {
	private String movieName;
	private String movieType;
	private String movieStatus; // can convert it to int and specify each int's meaning
	private String movieRating; // rating can be out of 10 or 100
	private String movieSynopsis;
	private String movieDirector;
	private String[] movieCast; // need to have 2 or more cast members of the movie
	private float movieSales;
	private boolean is3D;
	
	public Movie(String name, String type, String status, String synopsis, String director, String[] cast, String rating, boolean x){
		this.movieName = name;
		this.movieType = type;
		this.movieStatus = status;
		this.movieRating = rating;			// If no one rates the movie, it is -1 (NA)
		this.movieSynopsis = synopsis;
		this.movieDirector = director;
		this.movieCast = cast;
		this.movieSales = 0;			// Initially, the movie sales are set to 0 (price how much the movie has made through the system)
		this.is3D = x;
	}
	// MovieName Accessor and Mutator
	public void setMovieName(String S){
		this.movieName = S;
	}
	public String getMovieName(){
		return this.movieName;
	}
	
	// MovieTyoe Accessor and Mutator
	public void setMovieType(String S){
		this.movieType = S;
	}
	public String getMovieType(){
		return this.movieType;
	}
	
	public void setis3D(boolean S){
		this.is3D = S;
	}
	public boolean getis3D(){
		return this.is3D;
	}
	
	// MovieStatus Accessor and Mutator
	public void setMovieStatus(String S){
		this.movieStatus = S;
	}
	public String getMovieStatus(){
		return this.movieStatus;
	}
	
	
	public String getMovieRating(){
		return this.movieRating;
	}
	
	// Movie Synopsis Accessor and Mutator
	public void setMovieSynopsis(String S){
		this.movieSynopsis = S;
	}
	public String getMovieSynopsis(){
		return this.movieSynopsis;
	}
	
	// Movie Director Accessor and Mutator
	public void setMovieDirector(String S){
		this.movieDirector = S;
	}
	public String getMovieDirector(){
		return this.movieDirector;
	}
	
	// Movie Cast Accecssor and Mutator
	public void setMovieCast(String[] S){
		this.movieCast = S;
	}
	public String[] getMovieCast(){
		return this.movieCast;
	}
	
	// Movie sales Accessor and Mutator
	public void setMovieSales(float x){
		this.movieSales += x;  // We are showing the number of tickets sold for the movie
	}
	public float getMovieSales(){
		return this.movieSales;
	}
	
	public void writeMovie() throws IOException{
		String cast= String.join(",", this.getMovieCast());
		String Save = this.getMovieName() + ","+ this.is3D + "," + this.getMovieType() + "," + this.getMovieStatus() + "," + this.getMovieRating() + "," + this.getMovieSynopsis() + "," + this.getMovieDirector() + "," + cast;
		try {
			File file = new File("Movie.txt");
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			PrintWriter pr = new PrintWriter(br);
			pr.println(Save);
			pr.close();
			br.close();
			fr.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/*
	
	public static void main(String[] args) throws IOException{
		String[] cast = new String[]{"firstarg", "secondarg", "thirdarg"};
		Movie movie = new Movie("Batman", "Action", "Coming Soon", "Bruce wayne's life story.", "Arjun Singh", cast);
		movie.writeMovie();
		System.out.println("Terminated....");
	}
	*/

}

