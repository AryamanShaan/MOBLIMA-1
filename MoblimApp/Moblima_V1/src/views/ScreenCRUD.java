/*
 * List of Functions are as follows:
 * No of Screens fixed to 5
 * public void writeScreen(Screen[] screens)
 * public Screen[] readScreen()
 * 
 * Note: no_Screen.txt and Screen.txt should exist
 * */
package views;
import models.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This Class helps in Object Serialization to store an array of Screens (Cinemas) in 'Screen.txt'
 * @author Anon
 *
 */
public class ScreenCRUD {
	
	/**
	 * This is a constant to fix the number of Screens (Cinemas) to 9 throughout the Sytem
	 */
	protected final int no_Screen=9;        // fixed number of screens system-wide
	
	/**
	 * This is the Array of Screens (Cinemas) on which all CRUD operations are performed. This Array is used to read and write data into 'Screen.txt'
	 */
	protected Screen[] arr_Screen = new Screen[no_Screen];  
	
	

	
	// one function to write in array (return type is array)
	
	/** 
	 * Writes contents of arr_Screen[] into 'Screen.txt' by serialization 
	 */
	public void writeScreen() {
		
		String filename = "Screen.txt";

		
		try
        {    
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            
            for(int i=0; i< no_Screen; i++) {
            	//arr_Screen[i] = screens[i];
            	out.writeObject(arr_Screen[i]);
            }
 
            out.close(); 
            file.close(); 
              
            //System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        }
	}
	
	
	
	// one function to read in array  (return type is array)
	
	/**
	 * Reads contents of 'Screen.txt' into arr_Screen[] by deserialization 
	 */
	public void readScreen() {
		
		int i=0;
        for(; i< no_Screen; i++) {
        	arr_Screen[i] = null;
		}
		
		
		String filename = "Screen.txt";
		try
        {    
            FileInputStream file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            
            i = 0;
            while(i< no_Screen) {
            	
            	arr_Screen[i] = (Screen)in.readObject(); 
            	i++;
            }
            
            in.close(); 
            file.close(); 
              
           // System.out.println("Object has been deserialized "); 
            //System.out.println("a = " + object1.get_row()); 
            //System.out.println("b = " + object1.get_col()); 
          
            
            
            }
  
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
		

	}

}
