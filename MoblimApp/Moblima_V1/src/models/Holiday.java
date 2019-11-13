package models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Holiday {
    private String name;
    private Date date;
    private double rate;
	
	
	public Holiday(String name, Date date, double rate) {
        this.name = name;
        this.date = date;
        this.rate = rate;
    }
	
	 public String getName() {
        return name;
    }
	
	public Date getDate() {
        return date;
    }
	
	public double getRate() {
        return rate;
    }
	
	public String printDetail() {
        return "Date      : " + formatTimeMMdd(date) + "\n" +
                "Price rate: " + rate;
    }

    //@Override
    public String toString() {
        return name + " (" + formatTimeMMdd(date) + ")";
    }

	
	 public static String formatTimeMMdd(Date time) {
	        return new SimpleDateFormat("MMMM, dd").format(time);
	    }
	 
	 public static boolean checkHoliday(String date) throws IOException{
		 try {
			 	String line;
			 	String fileName = "Holiday.txt";
			 	FileReader fileReader = new FileReader(fileName);
	            BufferedReader bufferedReader = new BufferedReader(fileReader); 
	            while((line = bufferedReader.readLine()) != null) {
	                //System.out.println(line);
	                String[] x = line.split(",");
	                if(x[1].equals(date)) {
	                	return true;
	                }
	            }   
	            bufferedReader.close(); 
	            return false;
	            
		 }
		 catch(IOException ex) {
			 ex.printStackTrace();
		 }
		 return false;
	 }
	 
	
}
