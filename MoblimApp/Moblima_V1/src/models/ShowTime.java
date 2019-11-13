package models;

public class ShowTime implements java.io.Serializable{

	private int show_time_ID; 
	private String movie;       // will throw up error for now
    private String date;   
    private final int numOfRows = 15;
	private final int numOfColumns = 20;
	private String[] time_arr = {"09:00", "14:00", "21:00"};
	private int time_int;
	
	
	public Seat[][] seat_layout = new Seat[numOfRows][numOfColumns];
	
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

	public int get_ID() {
		return show_time_ID; 
	}
	
	public void set_ID(int n) {
		show_time_ID = n; 
	}
	
	public int get_numOfRows() {
		return numOfRows; 
	}
	
	public int get_numOfColumns() {
		return numOfColumns; 
	}
	
	public String get_movie() {
		return movie; 
	}
	
	public void set_movie(String m) {
		movie= m; 
	}
	
	public String get_date() {
		return date; 
	}
	
	public void set_date(String dt) {
		date = dt; 
	}
	
	public String get_time() {
		return time_arr[time_int];
	}
	
	public  void set_time_int(int t) {
		time_int = t;
	}
	
	public  int get_time_int() {
		return time_int;
	}
	
	public void book_on_click(int i, int j){
		seat_layout[i][j].book();
	}


	public void unbook_on_click(int i, int j){
		seat_layout[i][j].unbook();
	}

	public boolean view_seat_booked(int i, int j){
		return seat_layout[i][j].isBooked();
	}

	public void view_layout_booked(){

		for(int i = 0; i<numOfRows; i++){
			for(int j =0 ; j<numOfColumns; j++){

					if(seat_layout[i][j].isBooked() == false){
						System.out.print("[ ]");
					}
					else{
						System.out.print("[x]");
					}

			}
			System.out.println();
		}
	}
	
	
	
}
