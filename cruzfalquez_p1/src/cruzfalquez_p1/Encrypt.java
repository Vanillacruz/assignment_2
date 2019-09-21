/*	
 	Daniela Cruz Falquez
	Programming Assignment 2- Problem 1a
	09/18/2019
*/

package cruzfalquez_p1;

import java.util.Scanner;

public class Encrypt {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int input = 0;
		int thousandsPlace = 0;
		int hundredsPlace = 0;
		int tensPlace = 0;
		int onesPlace = 0;
		int encrypted = 0;
		int tempDigit = 0;

		// Prompts user to enter number
		System.out.println("Enter a four-digit integer:");
		input = scnr.nextInt();
		scnr.close();

		// Gets the individual digits
		thousandsPlace = input / 1000;
		hundredsPlace = (input % 1000) / 100;
		tensPlace = (input % 100) / 10;
		onesPlace = (input % 10);

		// Encrypts number: Replaces each digit with the result of adding 7 to the digit and getting the remainder after dividing the new value by 10.
		thousandsPlace = (7 + thousandsPlace) % 10;
		hundredsPlace = (7 + hundredsPlace) % 10;
		tensPlace = (7 + tensPlace) % 10;
		onesPlace = (7 + onesPlace) % 10;

		// Swap the first digit with the third, and swap the second digit with the fourth.
		tempDigit = thousandsPlace;
		thousandsPlace = tensPlace;
		tensPlace = tempDigit;
		tempDigit = hundredsPlace;
		hundredsPlace = onesPlace;
		onesPlace = tempDigit;

		// Puts all the digits together to form the new encrypted 4 digit integer
		encrypted = (1000 * thousandsPlace) + (100 * hundredsPlace) + (10 * tensPlace) + onesPlace;

		// Outputs the encrypted number with leading zeros, if it has any.
		if (encrypted < 1000) {
			if (encrypted == 0) {
				System.out.println("Your number encrypted is 0000");
			} else if (encrypted < 10) {
				System.out.println("Your number encrypted is 000" + encrypted);
			} else if (encrypted < 100) {
				System.out.println("Your number encrypted is 00" + encrypted);
			} else {
				System.out.println("Your number encrypted is 0" + encrypted);
			}
		} else {
			System.out.println("Your number encrypted is " + encrypted);
		}

	}
}
