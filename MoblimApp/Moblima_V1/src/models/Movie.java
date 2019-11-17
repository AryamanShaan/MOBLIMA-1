package models;
import java.io.*;
import java.util.Arrays;
/**
 * Movie model
 * @author Anon
 *
 */
public class Movie {
	/**
	 * Name of the movie
	 * Type of movie
	 * Showing status of the movie
	 * Age restriction of the movie
	 * Synopsis of the movie
	 * Director of the movie
	 * All actors in the movie
	 * Sales of the movie
	 * Value depicting if the movie is 3D or not
	 */
	private String movieName;
	private String movieType;
	private String movieStatus; // can convert it to int and specify each int's meaning
	private String movieRating; // rating can be out of 10 or 100
	private String movieSynopsis;
	private String movieDirector;
	private String[] movieCast; // need to have 2 or more cast members of the movie
	private float movieSales;
	private boolean is3D;
	
	/**
	 * Constructor of Movie Class
	 * @param name Name of the movie
	 * @param type Type of movie
	 * @param status Showing status of the movie
	 * @param synopsis Synopsis of the movie
	 * @param director Director of the movie
	 * @param cast Actors in the movie
	 * @param rating Age rating of the movie
	 * @param x Value depicting if the movie is 3D or not
	 */
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
	/**
	 * Mutator of movieName
	 * @param S Movie name to be set
	 */
	public void setMovieName(String S){
		this.movieName = S;
	}
	/**
	 * Accessor of movieName
	 * @return Returns name of the movie
	 */
	public String getMovieName(){
		return this.movieName;
	}
	
	/**
	 * Mutator of movieType
	 * @param S Type to be assigned to the movie
	 */
	public void setMovieType(String S){
		this.movieType = S;
	}
	/**
	 * Accessor of movieType
	 * @return Returns type of movie as String
	 */
	public String getMovieType(){
		return this.movieType;
	}
	/**
	 * Mutator of is3D
	 * @param S boolean value to be assigned
	 */
	public void setis3D(boolean S){
		this.is3D = S;
	}
	/**
	 * Accessor of is3D
	 * @return Returns boolean value
	 */
	public boolean getis3D(){
		return this.is3D;
	}
	
	/**
	 * Mutator of movieStatus
	 * @param S Status of the movie to be set
	 */
	public void setMovieStatus(String S){
		this.movieStatus = S;
	}
	/**
	 * Accessor of movieStatus
	 * @return Status to be assigned
	 */
	public String getMovieStatus(){
		return this.movieStatus;
	}
	
	/**
	 * Accessor of movieRating
	 * @return Returns the age restriction of the movie
	 */
	public String getMovieRating(){
		return this.movieRating;
	}
	
	
	/**
	 * Mutator of movieSynopsis
	 * @param S Synopsis of the movie to be assigned
	 */
	public void setMovieSynopsis(String S){
		this.movieSynopsis = S;
	}
	/**
	 * Accessor of movieSynopsis
	 * @return Returns movie synopsis as a string
	 */
	public String getMovieSynopsis(){
		return this.movieSynopsis;
	}
	
	/**
	 * Mutator of movieDirector
	 * @param S Director to be set
	 */
	public void setMovieDirector(String S){
		this.movieDirector = S;
	}
	/**
	 * Accessor of movieDirector
	 * @return Name of the movie director 
	 */
	public String getMovieDirector(){
		return this.movieDirector;
	}
	
	/**
	 * Mutator of movieCast[]
	 * @param S All actors to be assigned to the movie
	 */
	public void setMovieCast(String[] S){
		this.movieCast = S;
	}
	/**
	 * Accessor of movieCast[]
	 * @return Returns all actors in the movie as an array of strings
	 */
	public String[] getMovieCast(){
		return this.movieCast;
	}
	
	/**
	 * Function to check if a movie is 3D or not
	 * @param a Name of the movie being checked
	 * @return Returns boolean value depicting 3D attribute
	 * @throws IOException Throws IOEXception if file not found
	 */
	public static boolean check3D(String a) throws IOException {
		String fileName = "Movie.txt";
		String line;
		FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader); 
        while((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);
            String[] x = line.split(",");
            if(x[0].equals(a)) {
            	if(x[1].equals("true"))
            		return true;
            	else
            		return false;
            	}
            }
        bufferedReader.close();
		
		return false;
	}
	
	/**
	 * Function to record movie into the database at the time of movie creation
	 * @throws IOException Throws IOException
	 */
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

