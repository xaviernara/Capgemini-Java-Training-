package day3_22March_111245;

import java.util.*;

public class SumOfCommonElements {
	
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("Input size of your 1st array");
		int arr1Size = scan.nextInt();
		
		System.out.println("Input size of your 2nd array");
		int arr2Size = scan.nextInt();
		
		int[] arr1 = new int[arr1Size];
		
		
		int[] arr2  = new int[arr2Size];
		
		System.out.println("Input values into the 1st array");
		
		for (int i : arr1){
			
			arr1[i] = scan.nextInt();
			System.out.println(arr1[i]);
		}
		
		
		System.out.println("Input values into the 2nd array");
		
		for (int i : arr2){
			
			arr2[i] = scan.nextInt();
		}
		
		
		System.out.println(UserMainCode.getSumOfIntersection(arr1, arr2, arr1Size, arr2Size));
		
	}
	
	
	public static class UserMainCode{
		
		public static int getSumOfIntersection (int[] arr1, int[] arr2, int arr1Size, int arr2Size){
			
			List<Integer> commonList = new ArrayList<>();
			int sum = 0;
			int count = 0;
			
			for (int i = 0; i<arr1.length; i++){
				
				for (int j = 0 ; j<arr2.length; j++){
					
					if (arr1[i] == arr2[j]){
						
						System.out.println( arr1[j]); 
						commonList.add(arr1[i]);
					}
					
				}
			}
			
			
			for (int i : commonList){
				
				sum += i; 
				
			}
			
			
			return sum;
			
			
		}
		
	}

}



