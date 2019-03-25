/**
 * 
 */
package day2_21March_111245;

import java.util.*;

/**
 * @author xarichar
 *
 */
public class SumOfSquaresOfEvenDigits {

	/**
	 * Assignment 8
	 * 
	 * 
	 * Sum of Squares of Even Digits Write a program to read a number ,
	 * calculate the sum of squares of even digits (values) present in the given
	 * number. Include a class UserMainCode with a static method
	 * sumOfSquaresOfEvenDigits which accepts a positive integer. The return
	 * type (integer) should be the sum of squares of the even digits. Create a
	 * class Main which would get the input as a positive integer and call the
	 * static method sumOfSquaresOfEvenDigits present in the UserMainCode.
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		System.out.println("Please input a number");

		int number = scan.nextInt();

		System.out.println("Sum of evens in your number: " + UserMainCode.sumOfSquaresOfEvenDigits(number));

	}

	public static class UserMainCode {

		public static int sumOfSquaresOfEvenDigits(int input) {

			// string version of input
			String stringInput = Integer.toString(Math.abs(input));

			// char version of input
			char charInput;

			// sum of all even numbers in input
			int sum = 0;

			// the individual numbers of input after conversion from char
			int charToInt = 0;

			for (int i = 0; i < stringInput.length(); i++) {

				charInput = stringInput.charAt(i);

				charToInt = Integer.parseInt(Character.toString(charInput));

				// charToInt =
				// Integer.parseInt(Character.toString(stringInput.charAt(i)));

				if (charToInt % 2 == 0) {

					sum = sum + (charToInt * charToInt);

					// sum = charInput;
				}

			}

			return sum;
		}

	}

}
