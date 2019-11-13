package models;


public class Seat implements java.io.Serializable{


	 private int row;
	 private int col;
	 private boolean booked;
	 

	 public Seat(int i, int j){
	 	row = i;
	 	col =j;
		booked = false; 
	 }


	public void book(){
		booked = true;
	}

	public void unbook(){
		booked = false;
	}

	public boolean isBooked(){
		return booked;
	}

	public int get_row(){
		return row;
	}

	public int get_col(){
		return col;
	}


}

