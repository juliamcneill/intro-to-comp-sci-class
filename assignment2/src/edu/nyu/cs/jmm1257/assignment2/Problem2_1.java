/**
 * Julia McNeill
 * Introduction to Computer Science
 * Assignment 2 | 02.10.20
 * Problem 2.1
 */

package edu.nyu.cs.jmm1257.assignment2;
import java.util.Scanner;
import java.util.Random;

public class Problem2_1 {
	
	public static void main(String[] args) {
		
		// Opens scanner and random
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		// Creates empty strings to track each player's cards
		String userCards = "";
		String computerCards = "";
		
		// Records that each player starts out not yet having passed a total of 21 points
		boolean userBust = false;
		boolean computerBust = false;
	
		// Generate, track, total, and display first 2 user's cards
		int user1 = rand.nextInt(11) + 2;
		int user2 = rand.nextInt(11) + 2;
		userCards += user1 + ", " + user2;
		int userTotal = user1 + user2;
		System.out.println("Your cards are: " + user1 + " and " + user2);
	
		// Generate, track, and total first 2 computer's cards
		int computer1 = rand.nextInt(11) + 2;
		int computer2 = rand.nextInt(11) + 2;
		computerCards += computer1 + ", " + computer2;
		int computerTotal = computer1 + computer2;
		
		// Loop for user's turn
		while (userBust == false) {
			
			// Check if user has passed 21 points; if so, break
			if (userTotal > 21) {
				
				System.out.println("You have passed 21.");
				userBust = true;
				break;	
			}
			
			// Offer another card and prompt user for answer
			System.out.print("Would you like another 'card' or to 'stop'? ");
			String playerDecisionUpper = input.nextLine();
			String playerDecision = playerDecisionUpper.toLowerCase();
			
			// If player wants a card, generate, track, total, and display a new card
			if (playerDecision.equals("card")) {
				
				int additionalCard = rand.nextInt(11) + 1;
				userCards += ", " + additionalCard;
				userTotal += additionalCard; 
				
				System.out.println("\nYour next card is: " + additionalCard);
			
			// If player does not want a card, end turn
			} else {
				
				System.out.println("\nYou have stopped drawing cards!");
				break;	
			}
		}
		
		// Loop for computer's turn, only if User has not passed 21
		while (userBust == false & computerBust == false) {
			
			// Check if computer has passed 21 points; if so, break
			if (computerTotal > 21) {
				
				computerBust = true;
				break;
			
			// Check if computer has reached 17 points; if so, break for the sake of strategy
			} else if (computerTotal >= 17) {
				
				break;
			
			// If computer has not reached 17 points, generate, track, and total a new card 
			} else {

				int additionalCard = rand.nextInt(11) + 2;
				computerCards += ", " + additionalCard;
				computerTotal += additionalCard; 
			}	
		}
		
		// Displays both player's final cards
		System.out.println("\nYour cards are: " + userCards);
		System.out.println("Your total is: " + userTotal);
		System.out.println("The computer's cards are: " + computerCards);
		System.out.println("The computer's total is: " + computerTotal);
		
		// Generates and displays the winner of the game
		// If only the user passed 21, the computer won!
		if (userBust == true & computerBust == false) {
			System.out.println("\nThe computer won!");
		// If only the computer passed 21, the user won!
		} else if (userBust == false & computerBust == true) {
			System.out.println("\nYou won!");
		// If the user passed 21, but the computer passed 21 on the first two cards, both players lose!
		// This rule doesn't make sense in actual Blackjack, but fits with how the instructions described the gameplay!
		} else if (userBust == true & computerTotal > 21) {
			System.out.println("\nYou both passed 21 and both lost!");
		// If neither player passed 21, compare their card totals, with the highest total winning the game!
		} else {
			if (userTotal > computerTotal) {
				System.out.println("\nYou won!");
			} else if (computerTotal > userTotal) {
				System.out.println("\nThe computer won!");
			} else {
				System.out.println("\nYou tied!");
			}
		}
		
		// Closes the scanner
		input.close();
			
	}
}

