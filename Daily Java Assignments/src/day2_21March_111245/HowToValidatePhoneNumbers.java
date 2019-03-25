package day2_21March_111245;

import java.util.Scanner;

public class HowToValidatePhoneNumbers {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Insert a number: ");
		
		String input = scan.nextLine();
		
		if (input.length() == 10){
			System.out.println(true);
			
		}
		else{
			System.out.println(false);
			
		} 
		
		
		if(input.startsWith("7")|| input.startsWith("8") || input.startsWith("9") ){
			System.out.println("Your phone number starts with 7,8 or 9"+true);
			
		}else{
			System.out.println("Your phone number doesn't starts with 7,8 or 9" +false);
		}
		
		
		
		char[] c = input.toCharArray();
		for (int i = 0; i<c.length;i++){
			
			if (Character.isDigit(c[i])){
				System.out.println("Digits in string: "+ c[i]);

			}
		}
		
		
		
		

	}

}
