/*	
 	Daniela Cruz Falquez
	Programming Assignment 2- Problem 3
	09/18/2019
*/

package cruzfalquez_p3;

import java.util.Scanner;

public class Polling {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String[] topics = { "money", "working out", "love", "academia", "climate change" };
		int[][] responses = new int[5][10];
		double[] average = new double[5];
		int[] pointTotals = new int[5];
		int counter = 0;
		boolean stop = false;
		String response = "";
		int choice = 0, rating = 0, sum = 0;
		boolean[] highTie = new boolean[5];
		boolean[] lowTie = new boolean[5];
		int highestPointTotal, lowestPointTotal;

		// initializes responses array to zero
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				responses[i][j] = 0;
			}
		}

		// Records the poll responses for multiple people
		while (!stop) {
			counter++;
			System.out.println("\t\tPOLLING PROGRAM");
			System.out.println("Please rate the following topics from 1-10.\n(1 being least important to you -> 10 being most important to you)\n");

			for (int i = 0; i < topics.length; i++) {
				System.out.print("Rate how important " + topics[i] + " is to you!\n");
				rating = scnr.nextInt();
				responses[i][rating - 1] += 1;
			}

			System.out.println("\nThank you for rating these topics!\nWould another person like to rate these topics now? (y/n)");
			response = scnr.next();

			choice = 0;
			if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
				choice = 1;
			} else if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")) {
				stop = true;
				choice = 2;
				scnr.close();
			}
			//ensures a valid response
			while ((choice != 1) && (choice != 2)) {
				System.out.println("Sorry, that was not a valid response. \nPlease enter again:");
				System.out.println("Enter y/Y/yes/YES if another person would like to rate these topics.");
				System.out.println("Enter n/N/no/NO if all responses have been logged.");
				response = scnr.next();
				System.out.print("\n");
				if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
					choice = 1;
				} else if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")) {
					stop = true;
					choice = 2;
				}
			}
		}

		// Finds the average points each topic got
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				sum += responses[i][j] * (j + 1);
			}
			pointTotals[i] = sum;
			average[i] = (double) sum / counter;
			sum = 0;
		}

		// Finds the highest and lowest point totals of each topic
		highestPointTotal = pointTotals[0];
		lowestPointTotal = pointTotals[0];

		for (int i = 0; i < 5; i++) {
			if (pointTotals[i] > highestPointTotal) {
				highestPointTotal = pointTotals[i];
			}
			if (pointTotals[i] < lowestPointTotal) {
				lowestPointTotal = pointTotals[i];
			}
		}

		// Output results table
		System.out.println("\t\t\t\t\t\tRESULTS");
		System.out.println("Ratings:\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10");
		for (int i = 0; i < 5; i++) {
			System.out.format("%-15s\t", topics[i]);
			for (int j = 0; j < 10; j++) {
				System.out.print(responses[i][j] + "\t");
			}
			System.out.format("|\tAverage = %.2f point rating of importance", average[i]);
			System.out.print("\n");
		}

		// Checks for ties for highest and lowest points
		for (int i = 0; i < 5; i++) {
			if (highestPointTotal == (pointTotals[i])) {
				highTie[i] = true;
			} else {
				highTie[i] = false;
			}

			if (lowestPointTotal == (pointTotals[i])) {
				lowTie[i] = true;
			} else {
				lowTie[i] = false;
			}
		}

		// Outputs highest and lowest point totals
		System.out.print("\n\nThe issue(s) with the highest point total of " + highestPointTotal + " points is/are ");
		for (int i = 0; i < 5; i++) {
			if (highTie[i]) {
				System.out.print(topics[i] + ", ");
			}

		}
		System.out.print("\nThe issue(s) with the lowest point total of " + lowestPointTotal + " points is/are ");
		for (int i = 0; i < 5; i++) {
			if (lowTie[i]) {
				System.out.print(topics[i] + ", ");
			}
		}

	}
}
