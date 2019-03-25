package day2_21March_111245;

import java.util.*;

public class DhonisBattingPosition {

	/*
	 * Assignment 7:
	 * 
	 * Dhoni's Batting Position
	 * 
	 * Dhoni's normal batting position is at Number 5, but the skipper has often
	 * promoted himself up the order or sometimes coming lower down the order,
	 * based on his team's performance. When team performs well you need power
	 * hitters to accelerate the innings, and that is when Dhoni comes to bat
	 * high up the order. When team doesn't perform well losing early wickets
	 * say he saves himself to the end expecting no more wickets fall.Formally
	 * when his team bats first, Dhoni comes to bat when his upper order batsmen
	 * has already played 75% of Overs in the total Overs of the innings. Write
	 * a program to display Dhoni's likeliness to come to bat based on the
	 * number of Overs played by his team so far, the ball when the last wicket
	 * fell and the Total overs in the innings.
	 * 
	 * 
	 * 
	 * Input Format:
	 * First line of the input contains an integer value that specifies the number of the Over when the last wicket fell.
	 * 
	 * Second line of the input contains an integer value that specifies the ball in the Over when the last wicket fell.
	 * Third line of the input contains an integer value that specifies the Total overs in the innings.
	 * 
	 * Output Format:
	 * 
	 * Output should display “Yes” if his team has already played75% of
	 * Overs and Dhoni is likely to bat else print “No”.
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Input Overs when the last wicket fell ");
		int over = scan.nextInt();

		System.out.println("Input the ball in the Over when the last wicket fell ");
		int balls = scan.nextInt();

		System.out.println("Input total Overs in the innings ");
		int totalOver = scan.nextInt();

		int percentage = ((over * 6) + balls / (totalOver * 6)) * 100;

		if (percentage >= 75) {

			System.out.println("Yes");

		} else {

			System.out.println("No");

		}

	}
}
