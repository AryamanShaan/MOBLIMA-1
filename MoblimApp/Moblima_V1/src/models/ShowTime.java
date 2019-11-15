package models;

/**
 * Represents a particular Show Time
 * 
 * @author Anon
 *
 */
public class ShowTime implements java.io.Serializable{
	
	/**
	 * ID of the Show Time
	 */
	private int show_time_ID; 
	
	/**
	 * Movie to be played at the Show Time
	 */
	private String movie;   
	
	/**
	 * Date of the Show Time
	 */
        private String date;   
	
	/**
         * Number of Rows available at the time of the Show, helps to book seats
         */
	private final int numOfRows = 15;
	
	/**
         * Number of Columns available at the time of the Show, helps to book seats
         */
	private final int numOfColumns = 20;
	
	/**
	 * Array consisting of all possible values of time at which a Show can play
	 */
	private String[] time_arr = {"09:00", "14:00", "21:00"};
	
	
	/**
	 * An Integer value to keep track of which time is the Show playing, indicates index value of time_arr variable
	 */
	private int time_int;
	
	/**
	 * Double Array containing layout of Seats at the time of the Show 
	 */
	public Seat[][] seat_layout = new Seat[numOfRows][numOfColumns];
	
	/**
	 * Constructor for the Show Times
	 * @param ID		ID of the Show Time
	 * @param m         Movie playing at this Show Time
	 * @param date		Date of this Show Time
	 * @param t			Time at which this Show Time is playing
	 */
	public ShowTime(int ID, String m, String date, int t){
		show_time_ID = ID;
		movie = m;
		this.date= date;
		time_int = t;

		for (int i = 0; i< numOfRows; i++) {
			for(int j=0; j< numOfColumns; j++) {
				seat_layout[i][j] = new Seat(i, j);    //invoking constructor of seat
			}

		}

	}  

	/**
	 * Returns the ID of this show time
	 * @return the ID of this Show Time
	 */
	public int get_ID() {
		return show_time_ID; 
	}
	
	/**
	 * Sets the ID of this Show Time
	 * 
	 * @param n
	 */
	public void set_ID(int n) {
		show_time_ID = n; 
	}
	
	/**
	 * Gets the number of the Rows of seats at this Show Time
	 * @return the number of the Rows of seats at this Show Time
	 */
	public int get_numOfRows() {
		return numOfRows; 
	}
	
	/**
	 * Gets the number of the Columns of seats at this Show Time
	 * 
	 * @return the number of the Columns of seats at this Show Time
	 */
	public int get_numOfColumns() {
		return numOfColumns; 
	}
	
	/**
	 * Gets the movie
	 * 
	 * @return movie playing at this Show Time as a string
	 */
	public String get_movie() {
		return movie; 
	}
	
	/**
	 * To set the movie playing at this Show Time
	 * @param m		The movie
	 */
	public void set_movie(String m) {
		movie= m; 
	}
	
	/**
	 * Gets the Date
	 * @return the date of this Show Time
	 */
	public String get_date() {
		return date; 
	}
	
	/**
	 * Sets the date of this Show Time
	 * @param dt 	The date
	 */
	public void set_date(String dt) {
		date = dt; 
	}
	
	/**
	 * Gets the Time
	 * @return Time of this Show Time as a string value
	 */
	public String get_time() {
		return time_arr[time_int];
	}
	
	/**
	 * Sets the time of this Show Time
	 * @param t
	 */
	public  void set_time_int(int t) {
		time_int = t;
	}
	
	/**
	 * Gets the Time
	 * @return the integer counter to help in keeping track of time
	 */
	public  int get_time_int() {
		return time_int;
	}
	
	/**
	 * Books the seat of at this row, column value
	 * @param i	   The row value of the seat
	 * @param j    The column value of the seat
	 */
	public void book_on_click(int i, int j){
		seat_layout[i][j].book();
	}

	/**
	 * Sets the booking status to false of the seat of at this row, column value
	 * @param i		The row value of the seat
	 * @param j		The column value of the seat
	 */
	public void unbook_on_click(int i, int j){
		seat_layout[i][j].unbook();
	}
	
	/**
	 * Return booking status of the specified seat
	 * @param i  	The row value of the seat
	 * @param j		The column value of the seat
	 * @return
	 */
	public boolean view_seat_booked(int i, int j){
		return seat_layout[i][j].isBooked();
	}

	/**
	 * Returns the entire layout of seats (cinema layout) at this Show Time showing which seats are booked 
	 */
	public void view_layout_booked(){

		System.out.print("   ");
		for(int i = 0; i<numOfColumns; i++){
			if(i<9) {
				System.out.print(i+"  ");
			}
				
			if(i==3) {
				System.out.print("  ");
			}
				
			if(i>=9) {
				System.out.print(i+" ");
			}
				
			if(i==15) {
				System.out.print("  ");
			}
				
		}
		System.out.println();
	
		
		
		for(int i = 0; i<numOfRows; i++){
			
			if(i<10) {
				System.out.print(i+" ");
			}
				
			if(i>=10) {
				System.out.print(i);
			}
				
			for(int j =0 ; j<numOfColumns; j++){

					if(seat_layout[i][j].isBooked() == false){
						System.out.print("[ ]");
					}
					else{
						System.out.print("[x]");
					}
						
					if(j==15) {
						System.out.print("  ");
					}
					if(j==3) {
						System.out.print("  ");
					}
						
			}
			System.out.println();
		}
	}
	
	
	
	
	
}
