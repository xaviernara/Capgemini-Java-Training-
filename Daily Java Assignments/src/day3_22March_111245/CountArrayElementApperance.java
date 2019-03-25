package day3_22March_111245;

import java.util.Scanner;

public class CountArrayElementApperance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner();
		
		int search = scan.nextInt();
		
		int count = 0;
		
		int[] arr = {1,2,3,4,5,2,7,56,2};
		
		for (int i = 0; i<arr.length; i++){
			
			if (search == arr[i]){
				
				count++;
			}
			
		}
		
		System.out.println(count);
		
		
	}

}
