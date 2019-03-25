/**
 * 
 */
package day1_20March_111245;

/**
 * @author xarichar
 *
 */
public class MoreVariablesAndPrinting {

	/**
	 * What You Should Do on Your Own1.Change all the variables so there isn't
	 * the   in front. Make sure you change the name everywhere, not just where
	 * you used=to set them.2.Try to write some variables that convert the
	 * inches and pounds to centimeters and kilos. Don't just type in the
	 * measurements, but work out the math inside your Java program3.Can I make
	 * a variable like this:1 = "Zed Shaw"?4.How can I round a floating point
	 * number?5.Why does this not make sense to me?
	 * 
	 */
	public static void main(String[] args) {
		String  Name,  Eyes,  Teeth,  Hair;
		int  Age,  Height,  Weight;
		 Name = "Zed A. Shaw";
		 Age = 35; //not a lie
		 Height = 74; // inches
		 Weight = 180; // lbs
		 Eyes = "Blue";
		 Teeth = "White";
		 Hair ="Brown";
		System.out.println( "Let's talk about " +  Name+ "." );
		System.out.println( "He's " +  Height + " inches tall." );
		System.out.println( "He's " +  Weight + " pounds heavy." );
		System.out.println( "Actually, that's not too heavy." );
		System.out.println( "He's got " +  Eyes + " eyes and " +  Hair + " hair.");
		System.out.println( "His teeth are usually " +  Teeth + " depending on the coffee." );// This line is tricky;
		//try to get it exactly right.
		System.out.println( "If I add " +  Age + ", " +  Height + ", and " +  Weight+ " I get " + ( Age +  Height +  Weight) + "." );

		
		//no u cant do 1 = "Zed Shaw"
		//to round floating point numbers use BigDecimal bd = new BigDecimal(Double.toString(value))
		//bd=bd.setScale(places, RoundingMode.HALF_UP);
		//return bd.doubleValue();

}


