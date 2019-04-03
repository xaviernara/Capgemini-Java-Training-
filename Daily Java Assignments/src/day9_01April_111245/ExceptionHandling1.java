/**
 * 
 */
package day9_01April_111245;
import java.io.*;

/**
 * @author xarichar
 *
 *	Assignment 27
 */
public class ExceptionHandling1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			double rate;
			
			
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			System.out.println("Enter the total runs scored: ");
			double totalRunsScored = Integer.parseInt(br.readLine());
			
			System.out.println("Enter the total overs faced");
			double totalOversFaced = Integer.parseInt(br.readLine());
			
			rate = totalRunsScored/totalOversFaced;
			System.out.println("Current Run Rate : " +rate);
		}
		catch(NumberFormatException e ){
			System.out.println("Exception: "+e.getMessage());
		}
		catch(ArithmeticException e){
		
			System.out.println("Exception: "+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
