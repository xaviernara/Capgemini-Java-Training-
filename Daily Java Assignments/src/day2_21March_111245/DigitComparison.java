/**
 * 
 */
package day2_21March_111245;

import java.util.Scanner;


/**
 * @author xarichar
 *
 */
public class DigitComparison {

	/**
	 * Assignment 10
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Please input a number");

		int number = scan.nextInt();
		
		System.out.println("Please input another number");

		int number2 = scan.nextInt();

		System.out.println("Does your the last digit in your number match: " + UserMainCode.digitComparison(number, number2));


	}
	
	public static class UserMainCode {

		public static boolean digitComparison(int input, int input2) {

			// string version of input
			String stringInput = Integer.toString(Math.abs(input));
			
			// string version of input
			String stringInput2 = Integer.toString(Math.abs(input2));
			
			char charInputEnd = stringInput.charAt(stringInput.length()-1);
			
			char charInput2End = stringInput2.charAt(stringInput2.length()-1);

			if (charInputEnd == charInput2End){
				return true;
			}
			
			return false;
			
		}

	}

}
