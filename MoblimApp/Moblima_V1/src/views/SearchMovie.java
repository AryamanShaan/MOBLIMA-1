package views;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SearchMovie {

	public static void main(String[] args) throws IOException, Exception {
		Scanner in = new Scanner(System.in);
        String fileName = "Movie.txt";
        String line = null;
        int i = 1;
        System.out.println("-----------------------------------");
        System.out.println("Movies present in the database");
        System.out.println("-----------------------------------");
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader); 
            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                String[] x = line.split(",");
                System.out.println(i++ +". " + x[0]);
            }   
            bufferedReader.close();  
            System.out.println();
            UserFunctions.main(null);
            
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