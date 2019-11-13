package views;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class DeleteMovie {

	public static void main(String[] args) throws IOException, Exception {
		Scanner in = new Scanner(System.in);
        String fileName = "Movie.txt";
        String line = null;
        int i = 1;
    
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader); 
            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                String[] x = line.split(",");
                System.out.println(i++ +". " + x[0]);
            }   
            bufferedReader.close();  
            System.out.println(i + ". Go back");
            System.out.print("Enter ID of movie to delete: ");
            
            int choice = in.nextInt();
            while(choice>i || choice<1) {
            	System.out.print("Enter valid option:");
            	choice = in.nextInt();
            }
            
            if(choice == i) {
            	MovieCRUD.main(null);
            }
            else {
            	File file_old = new File(fileName);
    			File file = new File("MovieTemp.txt");
    			FileWriter fr = new FileWriter(file, true);
    			BufferedWriter br = new BufferedWriter(fr);
    			PrintWriter pr = new PrintWriter(br);
    			FileReader fileReader_new = new FileReader(fileName);
                BufferedReader bufferedReader_new = new BufferedReader(fileReader_new);
                i = 1;
                
                while((line = bufferedReader_new.readLine()) != null) {
                    if(i == choice) {
                    	i++;
                    	continue;
                    }
                    String Save = line;
                    pr.println(Save);
                    i++;
                }        
                bufferedReader_new.close();
    			pr.close();
    			br.close();
    			fr.close();
    			
    			if(file_old.delete()){ 
    		           System.out.println("Movie deleted successfully!"); 
   		        } 
    		    else{ 
    	            System.out.println("Error ..."); 
   		        } 
    			Path source = Paths.get("C:\\Users\\arjun\\Desktop\\MoblimApp\\Moblima_V1\\MovieTemp.txt");
    			Files.move(source, source.resolveSibling("Movie.txt"));
    			AdminFunctions.main(null);
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

	}

}
