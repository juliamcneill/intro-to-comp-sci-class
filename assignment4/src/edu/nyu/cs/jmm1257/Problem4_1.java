/**
 * Program to print queried results of NYC Voting/Poll Sites .csv file
 *
 * @author Julia McNeill
 * Introduction to Computer Science
 * Assignment 4 | 03.25.20
 * Problem 4.1
 */

// This assignment uses Voting/Poll Sites data from the link https://data.cityofnewyork.us/City-Government/Voting-Poll-Sites/mifw-tguq
// The columns used in the program are SITE_NAME, SITE_NUMBER, STREET_NUMBER, STREET_NAME, POSTCODE, CITY, Community Board, and Council District

package edu.nyu.cs.jmm1257;

// imports necessary packages
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class Problem4_1 {

	/**
	 * Explains program to user and prompts them for search option
	 * @exception IOException if there is problem with input or output
	 */
	public static void main(String[] args) throws IOException {

		// creates scanner
		Scanner input = new Scanner(System.in);

		// reads in .csv file stored in src folder
		BufferedReader reader = new BufferedReader(new FileReader("src/votingsites.csv"));

		// adds each line to a new String ArrayList
		String line;
		List<String[]> lines = new ArrayList<String[]>();
    while ((line = reader.readLine()) != null) {
    	// splits each line into an array by the delimiter ","
        lines.add(line.split(","));
    }

    // converts the ArrayList to a multidimentional String array
    String[][] array = lines.toArray(new String[lines.size()][0]);

    // informs user on program
		System.out.println("Welcome to the NYC 2018 Voting Site Finder App.");
		System.out.println("This app mines data from https://data.cityofnewyork.us/City-Government/Voting-Poll-Sites/mifw-tguq");
		System.out.println("We allow you to search by ZIP Code, Community Board, or Council District to find NYC polling sites near you.");

		// prompts user to input preferred search query option
		System.out.print("\rWhich search option would you like to use? ");
		String choice = input.nextLine().toLowerCase();

		// redirects to next method based on user's input, providing an error message if user's input is not one of the given options
		if (choice.contentEquals("zip code")) {
			zipCodeOption(input, array);
		} else if (choice.contentEquals("community board")) {
			communityBoardOption(input, array);
		} else if (choice.contentEquals("council district")) {
			councilDistrictOption(input, array);
		} else {
			System.out.print("\rThat is not an option. Please restart the program to try again.");
		}

		// closes input and reader
		input.close();
		reader.close();

	}

	/**
	 * Searches by user provided ZIP Code and displays location results
	 * @param input Scanner input
	 * @param array Multidimensional String array of .csv file data
	 */
	public static void zipCodeOption(Scanner input, String[][] array) {

		// prompts user for a ZIP Code
		System.out.print("\rPlease enter a ZIP Code: ");
		String zipCode = input.nextLine();

		// prints out custom column headings, setting up string formatting for table
		System.out.printf("%n%-12s %-35s %-50s %-17s %-20s%n", "Site Number", "Site Name", "Site Address", "Community Board", "Council District");

		// sets up variable to keep track of number of printed rows
		int j = 0;
		// sets up empty string to combine columns into full addresses
		String address;

		// iterates through each line of the array
		for (int i = 1; i < array.length; i++) {
			// if the ZIP Code of the line equals the user's ZIP Code
			if(array[i][7].equals(zipCode)) {
				// shortens Site Name if necessary
		    	if (array[i][2].length() > 30) {
		    		array[i][2] = array[i][2].substring(0, 30) + "...";
		    	}
		    	// creates address using relevant columns
		    	address = array[i][4] + " " + array[i][6] + ", " + array[i][8] + " " + array[i][7];
		    	// shortens address if necessary
		    	if (address.length() > 45) {
		    		address = address.substring(0, 40) + "...";
		    	}
		    	// prints relevant columns and program-created address string
		    	System.out.printf("%-12s %-35s %-50s %-17s %-20s%n", array[i][3], array[i][2], address, array[i][14], array[i][15]);
		    	// adds one to count of printed rows
		    	j++;
		    	// if printed row count is a multiple of 10, require user to press key before continuing loop
		    	if (j % 10 == 0) {
					System.out.println("...hit enter to see the next 10...");
					input.nextLine();
				}
			}
		}
	}

	/**
	 * Searches by user provided Community Board number and displays location results
	 * @param input Scanner input
	 * @param array Multidimensional String array of .csv file data
	 */
	public static void communityBoardOption(Scanner input, String[][] array) {

		// prompts user for a Community Board number
		System.out.print("\rPlease enter a Community Board number: ");
		String communityBoard = input.nextLine();

		// prints out custom column headings, setting up string formatting for table
		System.out.printf("%n%-12s %-35s %-50s %-17s %-20s%n", "Site Number", "Site Name", "Site Address", "Community Board", "Council District");

		// sets up variable to keep track of number of printed rows
		int j = 0;
		// sets up empty string to combine columns into full addresses
		String address;

		// iterates through each line of the array
		for (int i = 1; i < array.length; i++) {
			// if the Community Board number of the line equals the user's Community Board number
			if(array[i][14].equals(communityBoard)) {
				// shortens Site Name if necessary
		    	if (array[i][2].length() > 30) {
		    		array[i][2] = array[i][2].substring(0, 30) + "...";
		    	}
		    	// creates address using relevant columns
		    	address = array[i][4] + " " + array[i][6] + ", " + array[i][8] + " " + array[i][7];
		    	// shortens address if necessary
		    	if (address.length() > 45) {
		    		address = address.substring(0, 40) + "...";
		    	}
		    	// prints relevant columns and program-created address string
		    	System.out.printf("%-12s %-35s %-50s %-17s %-20s%n", array[i][3], array[i][2], address, array[i][14], array[i][15]);
		    	// adds one to count of printed rows
		    	j++;
		    	// if printed row count is a multiple of 10, require user to press key before continuing loop
		    	if (j % 10 == 0) {
					System.out.println("...hit enter to see the next 10...");
					input.nextLine();
				}
			}
		}

	}

	/**
	 * Searches by user provided Council District number and displays location results
	 * @param input Scanner input
	 * @param array Multidimensional String array of .csv file data
	 */
	public static void councilDistrictOption(Scanner input, String[][] array) {

		// prompts user for a Council District number
		System.out.print("\rPlease enter a Council District number: ");
		String councilDistrict = input.nextLine();

		// prints out custom column headings, setting up string formatting for table
		System.out.printf("%n%-12s %-35s %-50s %-17s %-20s%n", "Site Number", "Site Name", "Site Address", "Community Board", "Council District");

		// sets up variable to keep track of number of printed rows
		int j = 0;
		// sets up empty string to combine columns into full addresses
		String address;

		// iterates through each line of the array
		for (int i = 1; i < array.length; i++) {
			// if the Council District number of the line equals the user's Council District number
			if(array[i][15].equals(councilDistrict)) {
				// shortens Site Name if necessary
		    	if (array[i][2].length() > 30) {
		    		array[i][2] = array[i][2].substring(0, 30) + "...";
		    	}
		    	// creates address using relevant columns
		    	address = array[i][4] + " " + array[i][6] + ", " + array[i][8] + " " + array[i][7];
		    	// shortens address if necessary
		    	if (address.length() > 45) {
		    		address = address.substring(0, 40) + "...";
		    	}
		    	// prints relevant columns and program-created address string
		    	System.out.printf("%-12s %-35s %-50s %-17s %-20s%n", array[i][3], array[i][2], address, array[i][14], array[i][15]);
		    	// adds one to count of printed rows
		    	j++;
		    	// if printed row count is a multiple of 10, require user to press key before continuing loop
		    	if (j != 0 && j % 10 == 0) {
					System.out.println("...hit enter to see the next 10...");
					input.nextLine();
				}
			}
		}
	}
}
