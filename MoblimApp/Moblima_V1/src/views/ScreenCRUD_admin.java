package views;
import models.*;
/*
 * Note: 
 * This CRUD has been implemented keeping admin in mind
 * For User a separate CRUD for screen will exist
 * In this CRUD you can add show times
 * I the other user CRUD you will be able to book seats		
 * Also proof of concept of object serialization
 * 			
 * */




import java.util.*;
import java.io.*;

public class ScreenCRUD_admin extends ScreenCRUD{
	
	
	
public static void main(String[] args) throws Exception, IOException {
		
		int choice = -1;
		Scanner sc = new Scanner(System.in);
		
		ScreenCRUD_admin screencrud = new ScreenCRUD_admin();
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("CRUD Seat & Show Times Listing");
		System.out.println("------------------------------------");
		System.out.println("1: Create 9 Screen");
		System.out.println("2: List all Screens");
		System.out.println("3: List All Show Times of a Screen");
		System.out.println("4: Add a Show Time to a Screen");
		System.out.println("5: Delete a Show Time of a Screen");
		System.out.println("6: Go Back");
		System.out.print("Please enter an option: ");
		System.out.println();
		choice = sc.nextInt();
		
		while(choice > 6 || choice < 1) {
			
			System.out.println();
			System.out.println("------------------------------------");
			System.out.println("CRUD Seat & Show Times Listing");
			System.out.println("------------------------------------");
			System.out.println("1: Create 9 Screen");
			System.out.println("2: List all Screens");
			System.out.println("3: List All Show Times of a Screen");
			System.out.println("4: Add a Show Time to a Screen");
			System.out.println("5: Delete a Show Time of a Screen");
			System.out.println("6: Go Back");
			System.out.print("Please valid enter an option: ");
			System.out.println();
			choice = sc.nextInt();
		}
			
			if (choice == 1) {
				int choice2=0;
				while(true) {
					System.out.println("-----------------------------------------------------------------------------------------");
					System.out.println("!!! Warning: Are you sure you want to continue !!!");
					System.out.println("If you have any previous saved Data on Screens and Show Times, then it will be deleted");
					System.out.println("1. Back");
					System.out.println("2. Continue");
					System.out.println("-----------------------------------------------------------------------------------------");
					choice2= sc.nextInt();
					if(choice2 == 2) {
						screencrud.createScreen();
						ScreenCRUD_admin.main(null);
					}
					else if(choice2 == 1) {
						ScreenCRUD_admin.main(null);
					}
					else {
						continue;
					}
				}
			}
			
			if (choice == 2) {
				screencrud.readAllScreen();
				ScreenCRUD_admin.main(null);
			}
			
			if (choice == 3) {			
				screencrud.displayShow_Time();
				ScreenCRUD_admin.main(null);
			}
			
			if (choice == 4) {
				screencrud.addShow_Time();
				ScreenCRUD_admin.main(null);
			}
			
			if (choice == 5) {	
				screencrud.deleteShow_Time();
				ScreenCRUD_admin.main(null);
			}
			
			if(choice == 6) {
				AdminFunctions.main(null);
			}
		
		
		
	}


	public void createScreen() {
		
			
			int choice;
			
			int i=0;
	        for(; i< no_Screen; i++) {
	        	arr_Screen[i] = null;
			}
	
			Scanner sc = new Scanner(System.in);

			for(i=0; i< no_Screen; i++) {
				//String st; 
				String cp= " ";
				System.out.println("Information for Screen with ID: "+ (i+1));
				boolean isScreen3D = ask3D("Is the screen 3D. Enter Y for yes: ");
				//System.out.println("Enter Screen type");
				//st = sc.nextLine();
				while(true) {
					System.out.println("Enter Screen cineplex");
					System.out.println("1. Cathay       ");
					System.out.println("2. Shaw Theatres");
					System.out.println("3. J-Cube       ");
					choice = sc.nextInt();
					if(choice>3 || choice<1) {
						System.out.println("Enter valid choice!");
						System.out.println();
					}
					else
					{
						if(choice == 1)
							cp ="Cathay        ";
						if(choice ==2)
							cp = "Shaw Theatres";
						if(choice ==3)
							cp = "J-Cube       ";
						
						arr_Screen[i] = new Screen((i+1), isScreen3D, cp);
						sc.nextLine();
						break;
					}  
				
					
				}
				}
	
			writeScreen();
	
	}
	
	public static boolean ask3D(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        //System.out.println("Arjun");
        if (sc.next().toUpperCase().equals("Y")) {
        	
        	return true;
        }
        else {
        	
        	return false;
        }
    }
	public void readAllScreen() {
		readScreen();
		System.out.println("Information about screen as follows:");
		System.out.println("ID		Type	  Cineplex	No of Show Times");
		System.out.println("_________________________________________________________");
		
			for(int i=0; i<no_Screen; i++) {
				System.out.print(arr_Screen[i].get_screenID()+"		");
				System.out.print(arr_Screen[i].get_screenType()+"		");
				System.out.print(arr_Screen[i].get_cineplexType()+"		");
				System.out.print(arr_Screen[i].get_no_Show_time());
				System.out.println();
			}
		
		writeScreen();
	}
	
	
	
	public void displayShow_Time() {
		readScreen();
		
		Scanner sc = new Scanner(System.in);
		int ID;
		System.out.println("Enter Screen id");
		ID = sc.nextInt();
		
		if(ID<=9 && ID>=1) {
			System.out.println("Information for Shows Times are:");
			System.out.println("_____________________________________________________________");
			for(int j=0; j< arr_Screen[ID-1].get_no_Show_time(); j++) {
				System.out.print("Show Time ID:	"+ arr_Screen[ID-1].arr_Show_time[j].get_ID()+"  ");
				System.out.print("movie: "+ arr_Screen[ID-1].arr_Show_time[j].get_movie()+"  ");
				System.out.print("Date: "+ arr_Screen[ID-1].arr_Show_time[j].get_date()+"  ");
				System.out.print(" Time: "+ arr_Screen[ID-1].arr_Show_time[j].get_time()+"  ");
				System.out.println();
			}
		}
				
		else {
			System.out.println("Such Screen ID does not exist!");
		}
		
		writeScreen();
	}
	
	
	public void addShow_Time() throws IOException, Exception {
		readScreen();
		int j;
		int sID; 
		boolean flag= false;
		int time_counter;
		
		Scanner sc = new Scanner(System.in);
		int ID;
		System.out.println("Enter Screen id");
		ID = sc.nextInt();
		
		if(ID<=9 && ID>=1) {
			
			String m; String date;
			System.out.println("Enter Show_time id");
	
			sID = sc.nextInt();
			sc.nextLine();
			
			for(j=0; j< arr_Screen[ID-1].get_no_Show_time(); j++) {
				if(arr_Screen[ID-1].arr_Show_time[j].get_ID() == sID) {
					System.out.println("Such a Show time ID already exists, try again!");
					break;
				}
			}
			
			if(j== arr_Screen[ID-1].get_no_Show_time() ) {    //Passes ID clash test
				String fileName = "Movie.txt";
				String line = null;
		        int i = 1;
		        m = "___";
		        
		        try {
		            FileReader fileReader = new FileReader(fileName);
		            BufferedReader bufferedReader = new BufferedReader(fileReader); 
		            while((line = bufferedReader.readLine()) != null) {
		                //System.out.println(line);
		                String[] x = line.split(",");
		                System.out.println(i++ +". " + x[0]);
		            }   
		            bufferedReader.close();  
		            System.out.print("Enter ID of movie: ");
		            
		            int choice = sc.nextInt();
		            while(choice>=i || choice<1) {
		            	System.out.print("Enter valid option:");
		            	choice = sc.nextInt();
		            }
		            
		            FileReader fileReadernew = new FileReader(fileName);
		            BufferedReader bufferedReadernew = new BufferedReader(fileReadernew); 
		            //System.out.println("yo");
		            i = 1;
		            while((line = bufferedReadernew.readLine()) != null) {
		            if(i == choice) {
		            	String[] x1 = line.split(",");
		                m = x1[0];
		                //System.out.println(m);
		                break;
		              }
		                    i++;
		            }        
		                bufferedReadernew.close();

		        }
		        finally {
		        	if(m.equals("___")) {
		        		m = "Not defined!";
		        	}
		        	sc.nextLine();
		        	
		        	
		        	while(!flag) {
		        		System.out.println("Enter date in the format mm-dd-yyyy");
		        		date = sc.nextLine();
		        		if (date.matches("\\d{2}-\\d{2}-\\d{4}")) {
		        			int d = Integer.parseInt(date.substring(3,5));
		        			int  month= Integer.parseInt(date.substring(0,2));
		        			int year = Integer.parseInt(date.substring(6));
		        			
		        			if(d<32 && d>0 && month <13 && month>0) {
		        				flag= true;
		        				boolean flag_time = true;
		        				
		        				System.out.println();
		        				System.out.println("Enter Time of Show as:");
		        				System.out.println("1. 09:00");
		        				System.out.println("2. 14:00");
		        				System.out.println("3. 21:00");
		        				
				        		time_counter = sc.nextInt();
		        				
		        				for(int z=0; z< arr_Screen[ID-1].get_no_Show_time(); z++)
		        				{
		        					if(time_counter>3||time_counter<1) {
		        						flag_time = false;
		        						System.out.println("Not a valid option!");
		        						break;
		        					}
		        					flag_time = true;
		        					if(date.equals(arr_Screen[ID-1].arr_Show_time[z].get_date())) {
		        						if((time_counter-1) == arr_Screen[ID-1].arr_Show_time[z].get_time_int()) {
		        							System.out.println("There is a clash with another Show time on this date, enter a new time!");
		        							flag_time = false;
		        							break;
		        						}	
		        					}
		        				}
		        				
		        				
		        				if(!flag_time) {
		        					flag= false;
		        					break;
		        					
		        				}
		        				else {
		        					arr_Screen[ID-1].creatShowtime(sID, m, date, (time_counter-1));
		        					flag = true;
		        					continue;
		        				}

		        				
		        			}
		        			else {
		        				System.out.println("Not a valid date- check date and month values, try again!");
		        				continue;
		        			}
		        		}
		        		else {
		        			System.out.println("Is not in the correct format, try again!");
		        			continue;
		        		}
		        	}
		        	
					
					
		        }
		        
				
			}
			
		}
		else {
			System.out.println("Such Screen ID does not exist!");
		}
		
		writeScreen();
	}
	
	
	
	public void deleteShow_Time() {
		readScreen();
		
		Scanner sc = new Scanner(System.in);
		int ID, j;
		System.out.println("Enter Screen id");
		ID = sc.nextInt();
		boolean flag= true;
		
		if(ID<=9 && ID>=1) {
			
			int sID;
			System.out.println("Enter Show_time id");
			sID = sc.nextInt();
			
			for(j=0; j< arr_Screen[ID-1].get_no_Show_time(); j++) {
				if(arr_Screen[ID-1].arr_Show_time[j].get_ID() == sID) {
					arr_Screen[ID-1].deleteShowtime(sID);
					writeScreen();
					flag =false;
					break;
				}
			}
			
			if(flag) {    
				System.out.println("No such Show Time ID exists!");
			}
			
			
		}
		else {
			System.out.println("Such Screen ID does not exist!");
		}
		
		
		writeScreen();
	}

}


