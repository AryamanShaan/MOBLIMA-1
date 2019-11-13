package models;


public class Screen implements java.io.Serializable{
	
	
	private int screenID;
	private boolean is3D;
	private String cineplex;    // chaneg to objec reference later
	private int no_Show_time;   // keeps a track of how many show_times are there in a screen
								// also helps assigning show_time IDs
								// need to add error handling for no_Show_time > 100
	public ShowTime[] arr_Show_time = new ShowTime[100];
	
	
	
	public Screen(int sID, boolean is3, String cp) {     		//constructor
		
		screenID = sID;
		is3D = is3;
		no_Show_time = 0;
		cineplex = cp;
		
		for(int i=0; i<100; i++) {
			arr_Show_time[i] = null;
		}
		
	}
	
	
	public int get_screenID() {
		return screenID;
	}
	
	public void set_screenID(int n) {				// needed?
		screenID = n;
	}
	
	public boolean get_screenType() {
		return is3D;
	}
	
	
	public void set_screenType(boolean s) {			
		is3D = s;
	}
	
	public String get_cineplexType() {
		return cineplex;
	}
	
	
	public void set_cineplexType(String s) {			
		cineplex = s;
	}
	
	
	
	public int get_no_Show_time() {   				// very important 
		return no_Show_time;
	}
	
	
	public void creatShowtime(int ID, String m, String date, int t){	//new show_time in screen as long as screen is not maxed out
		
		if(no_Show_time < 100){
			no_Show_time++;
			arr_Show_time[no_Show_time-1] = new ShowTime(ID, m, date, t);
		}
		else {
			System.out.println("Cannot add more show times to this Screen!");
		}
		
	}
	
	
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
