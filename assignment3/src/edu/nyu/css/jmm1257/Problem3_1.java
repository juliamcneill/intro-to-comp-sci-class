/**
 * Julia McNeill
 * Introduction to Computer Science
 * Assignment 3 | 02.19.20
 * Problem 3.1
 */

package edu.nyu.css.jmm1257;

// import necessary packages
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3_1 {
	
	// the main method begins the program and throws an exception if file is not found
	public static void main(String[] args) throws FileNotFoundException {
		 
		// calls readFile method
	    readFile();
		
	 }
	
	// the readFile method throws an exception if file is not found
	public static void readFile() throws FileNotFoundException {
		 
		// opens scanner
		Scanner input = new Scanner(System.in);

		// prompts user for file name
		System.out.print("What file would you like to open? ");
		// assigns file name to variable and makes lowercase 
		String fileName = input.nextLine();
		fileName = fileName.toLowerCase();
		// finds file in src folder and assigns Scanner contents to variable
		Scanner fileContents = new Scanner(new File("src/" + fileName));
		 
		// calls requestTicWords method
		requestTicWords(fileContents);
		
		// closes scanner
		input.close();
	
	 }

	 public static void requestTicWords(Scanner fileContents) {
		
		// opens scanner
		Scanner input = new Scanner(System.in);
		
		// prompts user for tic words
	    System.out.print("What words would you like to search for? ");
	    // assigns tic words raw string to variable and makes lowercase
	    String ticsList = input.nextLine();
	    ticsList = ticsList.toLowerCase();
	    // splits tic words raw string by comma
	    String[] ticNames = ticsList.split(",");
	    
	    // removes any spaces from beginning of tic words, if user has used spaces after commas
	    for (int i = 0; i < ticNames.length; i++) {
	    	if (ticNames[i].startsWith(" ")) {
	    		ticNames[i] = ticNames[i].substring(1);
	    	}
	    }
	    
	    // calls countTics method
	    countTics(fileContents, ticNames);
	    
	    // closes scanner
	    input.close();
	    
	 }

	 public static void countTics(Scanner fileContents, String[] ticNames) {
		 
		// creates integer array that is equal to the number of tics to hold the number of occurrences of each tic
		int[] ticNumberOfOccurrences = new int[ticNames.length];
		// fills that array with 0 values as the default number of occurrences
	    for (int i = 0; i < ticNumberOfOccurrences.length; i++) {
	    	ticNumberOfOccurrences[i] = 0;
	    }
	    
	    // begins counting the total number of words and number of tics at 0
	    double totalNumberOfWords = 0; 
		int totalNumberOfTics = 0;
		
		// reads in each line of the file contents
		while (fileContents.hasNextLine()) {
			// assigns each line to a String variable and makes lowercase
	        String line = fileContents.nextLine();
	        line = line.toLowerCase();
	       
	        // for each tic, checks if tic is in the line
	        for (int i = 0; i < ticNames.length; i++) {
	            if (line.contains(ticNames[i])) {
	            	int index = line.indexOf(ticNames[i]);
	            	// adds to the number of occurrences for specific tic the number of times it appears in that line
	                while (index != -1) {
	                	ticNumberOfOccurrences[i] += 1; 
	                    index = line.indexOf(ticNames[i], index + 1);
	                }      
	            }
	        
	        // splits the words in each line by space to add their count to the word total
	        String[] wordsInLine = line.split(" ");
		    totalNumberOfWords += wordsInLine.length;
		        
	        }            
	    }
		
		// adds the number of tics in total by adding up the total number of occurrences
		for (int i = 0; i < ticNumberOfOccurrences.length; i++) {
			totalNumberOfTics += ticNumberOfOccurrences[i];
		}

		// calls the method densityCalculator
	    densityCalculator(ticNames, ticNumberOfOccurrences, totalNumberOfWords, totalNumberOfTics);
	        
	}
	
	public static void densityCalculator(String[] ticNames, int[] ticNumberOfOccurrences, double totalNumberOfWords, int totalNumberOfTics) {
		
	    // calculates the total density	
		double totalDensity = (totalNumberOfTics/totalNumberOfWords) * 100;
		
		// creates integer array that is equal to the number of tics to hold the density of each tic
		int[] density = new int[ticNames.length];
		
		// if there are no tics, assigns the density of each tic to 0
		if (totalNumberOfTics == 0) {
			for (int i = 0; i < ticNames.length; i++) {
				density[i] = 0;
			}
		}
		// if there are tics, calculates and assigns the density of each existing tic
		else {
			for (int i = 0; i < ticNames.length; i++) {
				density[i] = (ticNumberOfOccurrences[i] * 100/totalNumberOfTics);
			}
		}
		
		// calls the output method
		output(ticNames, ticNumberOfOccurrences, density, totalNumberOfWords, totalNumberOfTics, totalDensity);
		
	}
	
	// the output method prints the results
	public static void output(String[] ticNames, int[] ticNumberOfOccurrences, int[] density, double totalNumberOfWords, int totalNumberOfTics, double totalDensity) {

		System.out.println("");
		System.out.println("...............................Analyzing text.................................");
		System.out.println("");
    
		System.out.println("Total number of tics: " + totalNumberOfTics);
		// uses string formatting for decimal places
		System.out.printf("Density of tics: %.2f \n", totalDensity);

		System.out.println("");
		System.out.println("...............................Tic breakdown..................................");
		System.out.println("");

		// iterates through existing tics
		for (int i = 0; i < ticNames.length; i++) {
			// uses string formatting to create columns
			System.out.printf("%-10s %-1s %3s %-5s %2s %10s%n", ticNames[i], "/ ", ticNumberOfOccurrences[i], " occurrences / ", density[i], "% of all tics");
			
		}
	}

}
