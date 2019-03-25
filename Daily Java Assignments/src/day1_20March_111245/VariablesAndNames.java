package day1_20March_111245;

public class VariablesAndNames {
	/*
	 * What You Should Do on Your Own
	 * 1.I used 4.0 forspace_in_a_car, but is that necessary? What happens if it's just 4?
	 * 2.Remember that 4.0 is a "floating point" number. Find out what that means.
	 * 3.Write comments above each of the variable assignments.
	 * 4.Make sure you know what=is called (equals) and that it's making names for things.
	 * 5.Remember_is an underscore character.
	 * 6.What is the difference between=(single-equal) and ==(double-equal)?
	 * 		Ans: = means assigning a value to variable (eg int car = 5)
	 * 			 == means that something 'equals' something else  (eg if (x == y){...})
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//creating local int variables 
		int cars, drivers, passengers, cars_not_driven, cars_driven;
		
		//creating local double variables 
		double space_in_a_car, carpool_capacity, average_passengers_per_car;
		
		
		cars = 100;
		
		//IF USE 4 instead of 4.0 there is no change because the 4 == 4.0 are still the same
		space_in_a_car = 4.0;
		
		//assigning(ie intializing) a value to local variable (lines 27,31-36)
		drivers = 30;
		passengers = 90;
		
		//cars_not_driven = 100 -30 = 70
		cars_not_driven = cars - drivers;
		
		//cars_driven = 30
		cars_driven = drivers;
		
		//carpool_capacity = 30 * 4 = 120
		carpool_capacity = cars_driven * space_in_a_car;
		
		//average_passengers_per_car = 90/30
		average_passengers_per_car = passengers / cars_driven;
		
		//printing out the values of the local variables after above calculations
		System.out.println("There are " + cars + " cars available.");
		System.out.println("There are only " + drivers + " drivers available.");
		System.out.println("There will be " + cars_not_driven + " empty cars today.");
		System.out.println("We can transport " + carpool_capacity + " people today.");
		System.out.println("We have " + passengers + " to carpool today.");
		System.out.println("We need to put about " + average_passengers_per_car + " in each car.");
	}

}
