/**
 * 
 */
package day1_20March_111245;

/**
 * @author xarichar
 *
 */
public class NumbersAndMath {

	/**
	 * What You Should Do on Your Own:
	 * 1.Above each line, use two slashes//to write a comment to yourself explaining what the line does.
	 * 2.Notice the math seems "wrong"? There are no fractions, only whole numbers. Find out why by researching what a "floating point" number is.
	 * 3.RewriteNumbersAndMath.javato use floating point numbers so it's more accurate (hint: 20.0 is floating point).
	 * 4.Why the % character is called "modulus" instead of "percent"?
	 * 5.How does modulus (%) work?
	 * 6.What is the order of operations?
	 * 7.Why does/(divide) round down?
	 * 
	 */
	public static void main(String[] args) {
		
		//PRINTING out the string
		System.out.println("I will now count my chickens:");
		
		//printing out string and calculating 25 + (30/6) = 25 + 5 = 30
		System.out.println("Hens " + (25 + 30 / 6));
		
		//100 - (25*3) % 4 = 100 - (75 % 3) = 100 -3 = 97
		System.out.println("Roosters " + (100 - 25 * 3 % 4));
		
		//PRINTING out the string
		System.out.println("Now I will count the eggs:");
		
		//
		System.out.println(3 + 2 + 1 - 5 + 4 % 2 - 1 / 4 + 6);
		
		////PRINTING out the string
		System.out.println("Is it true that 3 + 2 < 5 -7?");
		
		//comparing if 5 is less than -2
		System.out.println(3 + 2 < 5 - 7);
		
		//3+2 = 5
		System.out.println("What is 3 + 2? " + (3 + 2));
		
		//5-7= -2
		System.out.println("What is 5 -7? " + (5 - 7));
		
		//PRINTING out the string
		System.out.println("Oh, that's why it's false.");
		
		//PRINTING out the string
		System.out.println("How about some more.");
		
		//comparing if 5 is greater than -2 
		System.out.println("Is it greater? " + (5 > -2));
		
		
		//comparing if 5 is greater than or equal to -2 
		System.out.println("Is it greater or equal? " + (5 >= -2));
		
		//comparing if 5 is lesser than or equal to -2 
		System.out.println("Is it less or equal? " + (5 <= -2));

	}

}
