/**
 * 
 */
package day9_01April_111245;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xarichar
 *
 *         Assignment #29
 */
public class CustomException {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		try {

			double rate;

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			System.out.println("Enter the total runs scored: ");
			double totalRunsScored = Integer.parseInt(br.readLine());

			System.out.println("Enter the total overs faced");
			double totalOversFaced = Integer.parseInt(br.readLine());

			if (totalOversFaced < 0 || totalOversFaced >= 20) {
				throw new OverRangeException("Over is not in the specified range");
			}

			rate = totalRunsScored / totalOversFaced;
			System.out.println("Current Run Rate : " + rate);

		} catch (OverRangeException e) {
			System.out.println("OverRangeException:"+e.getMessage());

		}

	}

}

class OverRangeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OverRangeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OverRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public OverRangeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OverRangeException(String message) {
		super(message);
		// System.out.println("Over is not in the specified range");
		// TODO Auto-generated constructor stub
	}

	public OverRangeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
