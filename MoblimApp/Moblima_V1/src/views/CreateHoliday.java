package views;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import controllers.HolidayCreate;

/**
 * This view creates a Holiday in the specified format
 * @author Anon
 *
 */
public class CreateHoliday {
	
	/**
	 * This function checks if the date entered 
	 * is in a valid format
	 * @param strDate Date whose format needs to be checked
	 * @return boolean value indicating if the date is entered in correct format
	 */
	public static boolean validateJavaDate(String strDate)
	   {		
		if (strDate.trim().equals(""))
		{
		    return true;
		}
		else
		{
		    
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
		    sdfrmt.setLenient(false);
		    
		    try
		    {
		        Date javaDate = sdfrmt.parse(strDate); 		        
		    }		    
		    catch (ParseException e)
		    {		        
		        return false;
		    }		    
		    return true;
		}
	   }
	
	/**
	 * Main function that transfers the control of the 
	 * program to the controller HolidayCreate for writing
	 * into the file Holiday.txt
	 * @param args 
	 * @throws Exception
	 */
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String name, date;
		System.out.println("Enter name of the holiday:");
		name = sc.nextLine();
		System.out.println("Enter date in the following format: MM/dd/yyyy");
		date = sc.nextLine();
		
		while(!validateJavaDate(date)) {
			System.out.println("Enter date in the following format: MM/dd/yyyy");
			date = sc.nextLine();
		}
		HolidayCreate.writeHoliday(name,date);
		AdminFunctions.main(null);
	}

}

