package models;

/**
 * Represents a particular Screen (Cinema)
 * 
 * @author Anon
 *
 */
public class Screen implements java.io.Serializable{
	
	/**
	 * This is Screen ID
	 */
	private int screenID;
	
	/**
	 * This indicates whether Screen is 3D or not
	 */
	private boolean is3D;
	
	/**
	 * This indicates cineplex of the Screen
	 */
	private String cineplex;    // chaneg to objec reference later
	
	/**
	 * This indicates Number of Show Times at the Screen at the given point of Time
	 */
	private int no_Show_time;   // keeps a track of how many show_times are there in a screen
								// also helps assigning show_time IDs
								// need to add error handling for no_Show_time > 100
	/**
	 * This is an array that holds all Show Time objects belonging to this Screen
	 */
	public ShowTime[] arr_Show_time = new ShowTime[100];
	
	
		/**
	 * Constructor for Screen
	 * 
	 * @param sID  The ID of the Screen
	 * @param is3  Boolean indicates whether Screen is 3d or not
	 * @param cp   Cineplex of this Screen
	 */
	public Screen(int sID, boolean is3, String cp) {     		//constructor
		
		screenID = sID;
		is3D = is3;
		no_Show_time = 0;
		cineplex = cp;
		
		for(int i=0; i<100; i++) {
			arr_Show_time[i] = null;
		}
		
	}
	
	/**
	 * Gets the screen ID
	 * 
	 * @return  this Screen's ID
	 */
	public int get_screenID() {
		return screenID;
	}
	
	/**
	 * Sets this Screens' ID
	 * 
	 * @param n  Screen ID
	 */
	public void set_screenID(int n) {				// needed?
		screenID = n;
	}
	
	/**
	 * Gets the Screen's type
	 * 
	 * @return the screen's type
	 */
	public boolean get_screenType() {
		return is3D;
	}
	
	/**
	 * Sets this screen's type
	 * @param s the screen type
	 */
	public void set_screenType(boolean s) {			
		is3D = s;
	}
	
	/**
	 * Gets the cineplex of this Screen
	 * 
	 * @return the cineplex 
	 */
	public String get_cineplexType() {
		return cineplex;
	}
	
	/**
	 * Sets the cineplex of this Screen
	 * @param s the cineplex 
	 */
	public void set_cineplexType(String s) {			
		cineplex = s;
	}
	
	
	/**
	 * gets the number of Show Time of the Screen present at that time
	 * 
	 * @return  number of Show Time of the Screen present at that time
	 */
	public int get_no_Show_time() {   				// very important 
		return no_Show_time;
	}
	
	/**
	 * Creates a Show Time for this Screen
	 * 
	 * @param ID      Screen ID
	 * @param m		  Movie playing at this Show Time
	 * @param date    Date of the Show Time
	 * @param t       Time of this Show TIme
	 */
	public void creatShowtime(int ID, String m, String date, int t){	//new show_time in screen as long as screen is not maxed out
		
		if(no_Show_time < 100){
			no_Show_time++;
			arr_Show_time[no_Show_time-1] = new ShowTime(ID, m, date, t);
		}
		else {
			System.out.println("Cannot add more show times to this Screen!");
		}
		
	}
	
	/**
	 * Deletes the Show Time of this ID of this particular screen
	 * 
	 * @param ID   Show Time ID
	 */
	public void deleteShowtime(int ID) {
		int i;
		for(i=0; i< no_Show_time; i++) {
			
			if(arr_Show_time[i].get_ID()== ID) {
				arr_Show_time[i]= null;
				break;
			}
			
		}
		if(i == no_Show_time) {
			System.out.println("A Show Time with the given ID does not exist!");
		}
		else {
			arr_Show_time[i]= null;
			for(; i<no_Show_time-1; i++) {
				arr_Show_time[i] = new ShowTime(arr_Show_time[i+1].get_ID(), arr_Show_time[i+1].get_movie(), arr_Show_time[i+1].get_date(), arr_Show_time[i+1].get_time_int());
				
				for (int j = 0; j< arr_Show_time[i].get_numOfRows(); j++) {
					for(int q=0; q< arr_Show_time[i].get_numOfColumns(); q++) {
						if(arr_Show_time[i+1].seat_layout[j][q].isBooked()) {
							arr_Show_time[i].seat_layout[j][q].book();
						}
					}
						
					}
			}
			
			arr_Show_time[no_Show_time-1]= null;
			no_Show_time--;
		}
		
		
	}
	
	

}
