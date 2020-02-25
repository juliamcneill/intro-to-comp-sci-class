package edu.nyu.css.fbjmm1257;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3_1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		readFile();
		requestTics();

	}
	
	public static void readFile() throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("src/data.txt"));

		while(in.hasNextLine()) {
			
			String line = in.nextLine();
			System.out.println(line);
			
		}
		
	}
	
	public static void requestTics() {
		
		
	}

}
