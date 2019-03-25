/**
 * 
 */
package day3_22March_111245;

import java.util.Scanner;

public class FindArrayElement {

	/**
	 * Create array of 10 elements and search for the given number
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		int input = scan.nextInt();
		
		System.out.println("Input a number");
		
		
		int [] inputArray = {1,2,3,4,5,6,7,67}; 
		
		for (int i = 0; i<inputArray.length;i++){
			
			
			if (inputArray[i] == input){
				
				System.out.println("Found your number");
			}
			
			else{
				
				System.out.println("Haven't found your number");
			}
		}
		
		

	}

}
