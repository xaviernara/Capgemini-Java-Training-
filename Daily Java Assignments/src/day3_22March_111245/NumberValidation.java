package day3_22March_111245;

import java.util.Scanner;
import java.util.regex.Pattern;

public class NumberValidation {
	
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Input number");
		String s = scan.nextLine();
		

		System.out.println(UserMainCode.validateNumber(s));
		
	}
	
	
	public static class UserMainCode{
		
		public static int validateNumber(String s){
			
			/*
			char[] c = s.toCharArray();
			int count = 0;
			
			for (char ch : c){
				
				if(c[ch] == '-'){
					
					count++;
					
				}
			}
			
			if (count == 3){
				
				System.out.println("Valid number format");
				return 1;
			}
			
			System.out.println("Invalid number format");
			return -1;*/
			
			// "\d{10}"  matches 1234567890
			//"(?:\d{3}-){2}\d{4}"  matches 123-456-7890
			
			
			if (Pattern.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|", s)){
				
				System.out.println("Valid number format");
				return 1;
				
			} 
			
			System.out.println("Invalid number format");
			return -1;
			
			
		}
		
		
	}

}
