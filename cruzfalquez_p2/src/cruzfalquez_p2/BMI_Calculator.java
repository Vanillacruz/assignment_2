/*	
 	Daniela Cruz Falquez
	Programming Assignment 2- Problem 2
	09/18/2019
*/

package cruzfalquez_p2;

import java.util.Scanner;
import java.lang.Math;

public class BMI_Calculator {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int choice = 0;
		int feet = 0;
		int inches = 0;
		double height = 0;
		double weight = 0;
		double bmi = 0;

		//Prompts user for calculation mode (lb or kg)
		System.out.println("\t\t\tBMI Calculator");
		System.out.println("Would you like to enter your data in pounds and inches, or kilograms and meters?");
		System.out.println("Enter 1 for measurement in the imperial system (pounds & inches).");
		System.out.println("Enter 2 for measurement in the metric system (kilograms & meters).");
		choice = scnr.nextInt();
		System.out.print("\n");

		//Ensures user picks a valid choice
		while ((choice != 1) && (choice != 2)) {
			System.out.println("Sorry, that was not a valid choice. \nPlease enter again:");
			System.out.println("Enter 1 for measurement in the imperial system (pounds & inches).");
			System.out.println("Enter 2 for measurement in the metric system (kilograms & meters).");
			choice = scnr.nextInt();
			System.out.print("\n");
		}

		//Prompts user for weight and height input based on their calculation mode
		if (choice == 1) {
			System.out.println("Please enter your weight (lbs):");
			weight = scnr.nextDouble();

			System.out.println("Please enter your height in feet and inches separated by a space!:");
			feet = scnr.nextInt();
			inches = scnr.nextInt();
			height = 12 * feet + inches;

			//BMI calculation:
			bmi = (703 * weight) / (Math.pow(height, 2));
		}
		else {
			System.out.println("Please enter your weight (kg):");
			weight = scnr.nextDouble();

			System.out.println("Please enter your height: (cm):");
			height = scnr.nextDouble();
			
			//BMI calculation:
			bmi = (weight) / (Math.pow(height / 100, 2));
		}

		//Displays BMI value and the BMI Categories
		System.out.format("\nYour BMI Calculation is %.2f\n\n", bmi);
		System.out.println("BMI Categories:\nUnderweight = <18.5\nNormal weight = 18.5–24.9\nOverweight = 25–29.9\nObesity = BMI of 30 or greater");

		scnr.close();
	}
}
