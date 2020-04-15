/**
 * Program to create an instance of the Moped class
 *
 * @author Julia McNeill
 * Introduction to Computer Science
 * Assignment 5 | 04.01.20
 * Problem 5.1
 */

package edu.nyu.cs.jmm1257;

import java.util.Scanner;

public class PlayWithMoped {

	public static void main(String[] args) {
		
		// open Scanner to ask user for commands
		Scanner input = new Scanner(System.in);
		
		// create a new instance of the Moped class
		Moped moped = new Moped();
		
		// print the introduction to your Moped trip
		Moped.introduction();
		
		// while the Moped isn't parked
		while (moped.getParked() == false) {
		
			// prompt the user for a command
			String command = input.nextLine().toLowerCase();
			
			// call the relevant method for each command
			
			if (command.contentEquals("go left")) {
				
				moped.goLeft();
				
			} else if (command.contentEquals("go right")) {
				
				moped.goRight();
				
			} else if (command.contentEquals("straight on")) {
				
				moped.straightOn();
				
			} else if (command.contentEquals("back up")) {
				
				moped.backUp();
				
			} else if (command.contentEquals("go to bluestone lane")) {
				
				moped.goToBluestoneLane();
				
			} else if (command.contentEquals("how we doin'?")) {
				
				moped.howWeDoin();
				
			} else if (command.contentEquals("fill 'er up")) {
				
				moped.fillErUp();
				
			} else if (command.contentEquals("help")) {
				
				Moped.help();
				
			} else if (command.contentEquals("park")) {
				
				moped.setParked();
				
			} else {
				
				Moped.commandNotFound();
				
			}
			
		}
		
		// close your input
		input.close();

	}

}
