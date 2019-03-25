/**
 * 
 */
package day2_21March_111245;

import java.util.Scanner;

import day2_21March_111245.SumOfSquaresOfEvenDigits.UserMainCode;

/**
 * @author xarichar
 *
 */
public class CountDigit {

	/**
	 * Assignment 9
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Please input a number");

		int number = scan.nextInt();

		System.out.println("Count of sevens in your number: " + UserMainCode.countDigit(number));

	}

	public static class UserMainCode {

		public static int countDigit(int input) {

			// string version of input
			String stringInput = Integer.toString(Math.abs(input));

			// char version of input
			char charInput;

			//count of all sevens in input
			int count = 0;

			// the individual numbers of input after conversion from char
			int charToInt = 0;

			for (int i = 0; i < stringInput.length(); i++) {

				charInput = stringInput.charAt(i);

				charToInt = Integer.parseInt(Character.toString(charInput));


				if (charToInt == 7) {
					
					count++;

				}

			}

			return count;

		}

	}

}
