/**
 * 
 */
package day1_20March_111245;

/**
 * @author xarichar
 *
 */
public class YourInitials {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] initialsArray = new String[8];
		initialsArray[0] = "							";
		initialsArray[1] = "X       X	RRRRR		    ";
		initialsArray[2] = "X     X		R	 R";
		initialsArray[3] = " X   X 		R	 R";
		initialsArray[4] = "   X   		RRRRR			";
		initialsArray[5] = " X   X		R  R			";
		initialsArray[6] = "X     X		R	R			";
		initialsArray[7] = "X       X	R	 R			";

		for (int i = 1; i < initialsArray.length; i++) {

			System.out.println(initialsArray[i]);

		}
	}

}
