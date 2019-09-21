/*	
 	Daniela Cruz Falquez
	Programming Assignment 2- Problem 1b
	09/18/2019
*/

package cruzfalquez_p1;

import java.util.Scanner;

public class Decrypt {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int input = 0;
		int thousandsPlace = 0;
		int hundredsPlace = 0;
		int tensPlace = 0;
		int onesPlace = 0;
		int decrypted = 0;
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
		
		// Swap the first digit with the third, and swap the second digit with the fourth.
		tempDigit = thousandsPlace;
		thousandsPlace = tensPlace;
		tensPlace = tempDigit;
		tempDigit = hundredsPlace;
		hundredsPlace = onesPlace;
		onesPlace = tempDigit;

		// Decrypts number: adds 10 to each digit and then subtracts 7 if digit < 7, if not it just subtracts 7 from the digit
		if(thousandsPlace < 7) {
			thousandsPlace = (10 + thousandsPlace) - 7;
		}else {
			thousandsPlace -= 7;
		}
		if(hundredsPlace < 7) {
			hundredsPlace = (10 + hundredsPlace) - 7;
		}else {
			hundredsPlace -= 7;
		}
		if(tensPlace < 7) {
			tensPlace = (10 + tensPlace) - 7;
		}else {
			tensPlace -= 7;
		}
		if(onesPlace < 7) {
			onesPlace = (10 + onesPlace) - 7;
		}else {
			onesPlace -= 7;
		}
		
		//Puts all the digits together to form the decrypted 4 digit integer
		decrypted = (1000 * thousandsPlace) + (100 * hundredsPlace) + (10 * tensPlace) + onesPlace;

		// Outputs the decrypted number with leading zeros, if it has any.
		if (decrypted < 1000) {
			if(decrypted == 0){
				System.out.println("Your number decrypted is 0000");
			}else if(decrypted < 10) {
				System.out.println("Your number decrypted is 000" + decrypted);
			}else if(decrypted<100) {
				System.out.println("Your number decrypted is 00" + decrypted);
			}else {
				System.out.println("Your number decrypted is 0" + decrypted);
			}
		} 
		else {
			System.out.println("Your number decrypted is " + decrypted);
		}

	}
}