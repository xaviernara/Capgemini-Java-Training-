/**
 * 
 */
package day4_25March_111245;

import java.util.Scanner;

/*
 * Assignment 20
 */
public class HotelRoomAndCost {

	public static void main(String[] args) {
		boolean hasTV = false;
		boolean hasWifi = false;
		Scanner scan = new Scanner(System.in).useDelimiter(System.lineSeparator());
		System.out.println("Hotel Tariff Calculator");
		System.out.println("1. Deluxe Room");
		System.out.println("2. Deluxe AC Room");
		System.out.println("3. Suite AC Room");
		
		System.out.println("Select Room Type:");
		int roomType = scan.nextInt();
		
		System.out.println("Hotel Name:");
		String hotelName = scan.next();
		
		System.out.println("Room Square Feet Area:");
		int roomSquareFeetArea = scan.nextInt();
		
		System.out.println("Room has TV (yes/no): ");
		String tv = scan.nextLine();
		if (tv.equalsIgnoreCase("yes")){
			hasTV = true;
		}
		
		System.out.println("Room has Wifi (yes/no: ");
		String wifi = scan.nextLine();
		if (wifi.equalsIgnoreCase("yes")){
			hasWifi = true;
		}
		int tarrif;
		switch(roomType){
		
		case 1:
			DeluxeRoom deluxeRoom = new DeluxeRoom (hotelName,roomSquareFeetArea,hasTV,hasWifi);
			tarrif = deluxeRoom.calculateTariff(deluxeRoom.getRatePerSqFeet());
			System.out.println("Room Tariff per day is: " + tarrif);
			break;
		case 2:
			DeluxeACRoom deluxeACRoom = new DeluxeACRoom (hotelName,roomSquareFeetArea,hasTV,hasWifi);
			tarrif = deluxeACRoom.calculateTariff(deluxeACRoom.getRatePerSqFeet());
			System.out.println("Room Tariff per day is: " + tarrif);
			break;
		case 3:
			SuiteACRoom suiteACRoom = new SuiteACRoom (hotelName,roomSquareFeetArea,hasTV,hasWifi);
			tarrif = suiteACRoom.calculateTariff(suiteACRoom.getRatePerSqFeet());
			System.out.println("Room Tariff per day is: " + tarrif);
			break;
		}
		
		scan.close();
		
		
	}
 
}

class HotelRoom{
	
	protected String hotelName;
	protected Integer numberOfSqFeet;
	protected Boolean hasTV;
	protected Boolean hasWifi;
	
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Integer getNumberOfSqFeet() {
		return numberOfSqFeet;
	}
	public void setNumberOfSqFeet(Integer numberOfSqFeet) {
		this.numberOfSqFeet = numberOfSqFeet;
	}
	public Boolean getHasTV() {
		return hasTV;
	}
	public void setHasTV(Boolean hasTV) {
		this.hasTV = hasTV;
	}
	public Boolean getHasWifi() {
		return hasWifi;
	}
	public void setHasWifi(Boolean hasWifi) {
		this.hasWifi = hasWifi;
	}

	public Integer calculateTariff(int RatePerSqFeet){
		return numberOfSqFeet * RatePerSqFeet;
		
	}
	
	public Integer getRatePerSqFeet(){
		return 0;
	}
	
	public HotelRoom(String hotelName, Integer numberOfSqFeet, Boolean hasTV, Boolean hasWifi) {
		this.hotelName = hotelName;
		this.numberOfSqFeet = numberOfSqFeet;
		this.hasTV = hasTV;
		this.hasWifi = hasWifi;
	}
	
	
}


class DeluxeRoom extends HotelRoom{
	
	
	protected Integer ratePerSqFeet;
	
	public DeluxeRoom(String hotelName, Integer numberOfSqFeet, Boolean hasTV, Boolean hasWifi) {
		super(hotelName, numberOfSqFeet, hasTV, hasWifi);
		ratePerSqFeet = 10;
	}

	public Integer getRatePerSqFeet() {
		if(super.hasWifi){
			return ratePerSqFeet +2;
		}
		
		return ratePerSqFeet;
		
	}

	/*
	public void setRatePerSqFeet(Integer ratePerSqFeet) {
		this.ratePerSqFeet = ratePerSqFeet;
	}
	*/
	
}


class DeluxeACRoom extends DeluxeRoom{

	public DeluxeACRoom(String hotelName, Integer numberOfSqFeet, Boolean hasTV, Boolean hasWifi) {
		super(hotelName, numberOfSqFeet, hasTV, hasWifi);
		
		super.ratePerSqFeet = 12;
	}
}

class SuiteACRoom extends HotelRoom{
	
	private Integer ratePerSqFeet;

	public SuiteACRoom(String hotelName, Integer numberOfSqFeet, Boolean hasTV, Boolean hasWifi) {
		super(hotelName, numberOfSqFeet, hasTV, hasWifi);
		this.ratePerSqFeet = 15;
	}

	public Integer getRatePerSqFeet() {
		if(super.hasWifi){
			return ratePerSqFeet +2;
		}
		return ratePerSqFeet;
	}
	
}
