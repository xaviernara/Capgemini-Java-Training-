/**
 * 
 */
package day7_28March_111245;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

/**
 * @author xarichar Assignment 23
 *
 */
public class CTBRequirement3 {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		System.out.println(" 1.Validate Age \n 2.Validate Name \n 3.Lucky Customer \n Enter your choice:");

		Scanner scan = new Scanner(System.in).useDelimiter(System.lineSeparator());
		int choice = scan.nextInt();
		
		if (choice == 1) {
			System.out.println("Enter your birthdate: ");
			String date = scan.nextLine();
			Date birthDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			CTBRequirement3.validateAge(birthDate);
		} else if (choice == 2) {
			System.out.println("Enter your name: ");
			String name = scan.nextLine();
			CTBRequirement3.validateName(name);
		} else {
			System.out.println("Enter your moblie number: ");
			String moblie = scan.nextLine();
			CTBRequirement3.validateLuckyCustomer(moblie);
		}

		scan.close();

	}

	/*
	 * This method accepts java.util.Date as argument and returns a boolean.
	 * Calculate the age and return True if the age of the customer is greater
	 * than or equal to 18, else return False
	 * 
	 * 
	 * The age is considered valid only if it is greater than equal to 18.(Take
	 * the current date as "01-01- 2018")
	 * 
	 */
	public static Boolean validateAge(java.util.Date birth) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(birth);

		String[] stringDateArray = strDate.split("-");

		int enteredYear = Integer.parseInt(stringDateArray[2]);

		if (2018 - enteredYear >= 18) {
			System.out.println("Age is valid");
			return true;
		}

		System.out.println("Age is Invalid");
		return null;

	}

	/*
	 * This method accepts a String as argument and returns a boolean. Validate
	 * the name of the customer and return True if the name is valid, else
	 * return False
	 * 
	 * 
	 * 
	 * The name should contain only alphabets and not numbers or special
	 * characters.
	 */

	public static Boolean validateName(String name) {

		Pattern p = Pattern.compile("[a-zA-Z]");
		Matcher m = p.matcher(name);
		boolean valid = m.matches();

		if (valid) {
			System.out.println("Name is valid");
			return true;
		}

		System.out.println("Name is invalid");
		return false;

	}

	/*
	 * This method accepts a String as argument and returns a boolean.Check
	 * whether the mobile number of the customer is lucky and return True, else
	 * return False
	 * 
	 * A customer is said to be lucky if the repetitive sum of his mobile number
	 * is equal to 1.
	 * 
	 * Ex:- Mobile number 9635285233 is lucky. step 1 - 9+6+3+5+2+8+5+2+3+3 = 46
	 * step 2 - 4+6 = 10 step 3 - 1+0 = 1
	 *
	 */
	public static Boolean validateLuckyCustomer(String mobile) {

		char[] c = mobile.toCharArray(); // step 1
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;

		for (int i = 0; i < c.length; i++) {
			sum1 = sum1 + Integer.parseInt(c.toString());

		}

		// step 2
		String sum1ToString = Integer.toString(sum1);
		char[] c2 = sum1ToString.toCharArray();
		for (int i = 0; i < c2.length; i++) {
			sum2 = sum2 + Integer.parseInt(c2.toString());

		}

		// step 3
		String sum2ToString = Integer.toString(sum2);
		char[] c3 = sum2ToString.toCharArray();
		for (int i = 0; i < c3.length; i++) {
			sum3 = sum3 + Integer.parseInt(c3.toString());

		}

		if (sum3 == 1) {
			System.out.println("Lucky Customer");
			return true;
		}

		System.out.println("Unlucky Customer");
		return false;

	}

}
