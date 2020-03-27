package edu.nyu.cs.jmm1257;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;

public class Problem4_1 {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		System.out.print("Please enter a zipcode: ");
		
		String zipcode = input.nextLine();
		
		int column = 7;
		
		String resultRow = "";
		BufferedReader reader = new BufferedReader(new FileReader("src/votingsites.csv"));
	    String line;
	    
		while ( (line = reader.readLine()) != null ) {
			String[] values = line.split(",");
		    if(values[column].equals(zipcode)) {
		        resultRow += line + "\r";
		    }
		}
		
		System.out.print(resultRow);
		
		reader.close();

	}

}
