/**
 * 
 */
package day3_22March_111245;
import java.util.*;
/**
 * @author xarichar
 *
 */
public class DifferenceBetweenLargestAndSmallestElementsInAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("input array size");
		
		int [] arr = new int[scan.nextInt()];
		
		System.out.println("input numbers into your array");
		for (int i = 0; i<arr.length; i++){
			
			arr[i] = scan.nextInt();
		}
		
		System.out.println(UserMainCode.getBigDiff(arr));
		
		

	}
	
	
	public static class UserMainCode{
		
		public static int getBigDiff(int[] array){
			Arrays.sort(array);
			
			return array[array.length-1] - array[0];
			
		}
		
	}

}
