/**
 * 
 */
package day2_21March_111245;

import java.util.Scanner;

/**
 * @author xarichar
 *
 */
public class BattingKeeping {

	/**
	 * Assignment #6
	 * 
	 * Batting Keeping
	 * 
	 * MS Dhoni, right from his early days preferred batting over
	 * keeping. But his school Coach KR Banerjee was much determined of trying
	 * him out behind the stumps. So every day when his Coach was available in
	 * the ground during the net practice, Dhoni got himself trainedfor
	 * wicket-keeping. But in his absence, Dhoni exercised his batting
	 * skills.Write a program that gets the status of the Coach if he is
	 * available or not available and displays whether Dhoni is batting or
	 * keeping at the nets.Input Format:First line of the input specifies the
	 * status of the Coach. It is “Yes” if Coach is available or “No” if he
	 * isn't available.Output Format:Output should display “Keeping” if Coach is
	 * Available else print “Batting”. If any other input other than Yes or No
	 * is given, print “Invalid Input”.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		boolean coachStatus = true;
		
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		
		if (coachStatus && input == "Yes"){
			
			System.out.println("Keeping");
		}
		else if (!coachStatus && input == "No"){
			
			System.out.println("Batting");
		}
		else {
			System.out.println("invalid input");
			
		}
		
		
		
		

	}

}
