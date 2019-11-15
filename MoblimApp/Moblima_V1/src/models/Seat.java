package models;

/**
 * Represents a seat
 * @author Anon
 *
 */
public class Seat implements java.io.Serializable{

	 /**
	  * Row number of the seat
	  */
	 private int row;
	
	/**
	  * Column number of the seat
	  */
	 private int col;
	
	/**
	  * Booked status of the seat
	  */
	 private boolean booked;
	 
	 /**
	  * Creates a seat and sets its booked status to false by default
	  * 
	  * @param i: This integer value specifies the row
	  * @param j: This integer value specifies the column
	  */
	 public Seat(int i, int j){
	 	row = i;
	 	col =j;
		booked = false; 
	 }

        /**
	  * Changes the seat's status to booked
	  */
	public void book(){
		booked = true;
	}

	/**
	 * Changes the seat's status to not booked
	 */
	public void unbook(){
		booked = false;
	}

	/**
	 * 
	 * @return this seat's booked/ not booked status as boolean
	 */
	public boolean isBooked(){
		return booked;
	}

	/**
	 * 
	 * @return this seat's row integer value
	 */
	public int get_row(){
		return row;
	}

	/**
	 * 
	 * @return this seat's column integer value
	 */
	public int get_col(){
		return col;
	}


}

