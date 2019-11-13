package controllers;


import java.io.*;



public class HolidayCreate {
	public static void writeHoliday(String name, String date) throws Exception {
		String save = name + "," + date;
		try {
			File file = new File("Holiday.txt");
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			PrintWriter pr = new PrintWriter(br);
			pr.println(save);
			pr.close();
			br.close();
			fr.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
