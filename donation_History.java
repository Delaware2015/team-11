import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java .io.IOException;
import java.util.Arrays;

public class donation_History{
// Variables related to getting the desired data and parsing a file
public static double yearTotal = 0;
public static double historyTotal = 0;
public static String file;
public static String Year;

/*
* Takes in a string representing the Donor's account
* Takes a string representing the csv file Name
* Takes a string representing the Year that you want the donation records from
*/
public static void parseFile(String csvFile, String Year){
	BufferedReader br = null;
	String line = "";
	String csvSplitBy = ",";
// Parses the csv file to the the data the programmer is asking for.
	try{
	br = new BufferedReader(new FileReader(csvFile));
	while( (line = br.readLine()) != null){

		String[] donation = line.split(csvSplitBy);
//		System.out.println(Arrays.toString(donation));
		if(donation[0].equals(Year)){
			yearTotal += Double.parseDouble(donation[2]);
	}
	historyTotal += Double.parseDouble(donation[2]);

	}
	} catch (FileNotFoundException e){
		e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
	} finally {
		if (br != null){
			try{
				br.close();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}

// The main Function of the File
/*	The first parameter is the csv file, that has the donation history
	The second parameter is the year to compare
*/
	public static void main(String[] args){

	file = args[0];
	Year = args[1];
	parseFile(file,Year);
	System.out.println("The amount donated in the year " + Year + " totaled " + yearTotal);
	System.out.println("The total amount that you have donated to Goodwill is " + historyTotal);
	
}
}
