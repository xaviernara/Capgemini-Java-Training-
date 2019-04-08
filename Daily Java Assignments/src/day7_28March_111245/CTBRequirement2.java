/**
 * 
 */
package day7_28March_111245;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

/**
 * @author xarichar
 * 
 * Assignment #22
 *
 */
public class CTBRequirement2 {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		System.out.println("Enter the number of Customers: ");
		Scanner scan = new Scanner(System.in).useDelimiter(System.lineSeparator());

		int numb = scan.nextInt();
		List<Customer2> cList = new ArrayList <>();
		//ContactBO cbo = new ContactBO(); 
		
		for(int i = 0; i< numb;i++){
			System.out.println("Enter Customer "+(i+1)+" details");
			String cDeatils = scan.nextLine();
			cList.add(ContactBO.createCustomer(cDeatils));		
		}
		
		System.out.println("search type:");
		System.out.println("1.By name");
		System.out.println("2.By birth date");
		System.out.println("3.By rating");
		int menuChoice = scan.nextInt();
		
		switch(menuChoice){
		case 1:
			System.out.println("Enter the name of the customer to be searched: ");
			String name = scan.nextLine();
			ContactBO.findCustomer2(cList, name);
			break;
		case 2:
			System.out.println("Enter the name of the customer to be searched:");
			String date = scan.nextLine();
			Date birth = new SimpleDateFormat("dd-MM-YYYY").parse(date);
			ContactBO.findCustomer2(cList, birth);
			break;
		case 3:
			System.out.println("Enter the rating of the customer to be searched:: ");
			Double rating= scan.nextDouble();
			ContactBO.findCustomer2(cList, rating);
			break;
			
		}
		
		scan.close();
		
	}

}

class Customer2 {

	private Long id;
	private String name;
	private String mobileNumber;
	private Date birthdate;
	private Double averageSpendAmount;
	private Double totalAmount;
	private Date dateEnrolled;
	private Double rating;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Double getAverageSpendAmount() {
		return averageSpendAmount;
	}

	public void setAverageSpendAmount(Double averageSpendAmount) {
		this.averageSpendAmount = averageSpendAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getDateEnrolled() {
		return dateEnrolled;
	}

	public void setDateEnrolled(Date dateEnrolled) {
		this.dateEnrolled = dateEnrolled;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Customer2(Long id, String name, String mobileNumber, Date birthdate, Double averageSpendAmount,
			Double totalAmount, Date dateEnrolled, Double rating) {
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.birthdate = birthdate;
		this.averageSpendAmount = averageSpendAmount;
		this.totalAmount = totalAmount;
		this.dateEnrolled = dateEnrolled;
		this.rating = rating;
	}

	/**
	 * 
	 */
	public Customer2() {
	}

	@Override
	public String toString() {
		return String.format("%-5s %-15s %-15s %-15s %-20s %-15s %-15s %s\n", "Id", "Name", "Mobile Number",
				"Date of Birth", "Average spent amount", "Total amount", "Date Enrolled", "Rating");
	}

	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averageSpendAmount == null) ? 0 : averageSpendAmount.hashCode());
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((dateEnrolled == null) ? 0 : dateEnrolled.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
		return result;
	}

	/*
	 * @Override public boolean equals(Object obj) {
	 * 
	 * Customer2 Customer2 = (Customer2) obj;
	 * 
	 * if (name.equalsIgnoreCase(Customer2.name)) {
	 * 
	 * if (mobileNumber.equals(Customer2.mobileNumber)) {
	 * 
	 * if (birthdate.equals(Customer2.birthdate)) {
	 * 
	 * return true; } }
	 * 
	 * } return false; }
	 */

}

class ContactBO {

	/*
	 * This method accepts a String as argument. Comma separated Customer2 detail
	 * is passed to this method. Split the value then create a Customer2 object
	 * and return the Customer2 object.
	 * 
	 */
	public static Customer2 createCustomer(String line) throws ParseException {
		String[] c1Array = line.split(",");
		Long id = Long.parseLong(c1Array[0]);
		String name = c1Array[1];
		String mobileNumber = c1Array[2];
		Date birthdate = new SimpleDateFormat("dd-MM-YYYY").parse(c1Array[3]);
		Double averageSpendAmount = Double.parseDouble(c1Array[4]);
		Double totalAmount = Double.parseDouble(c1Array[5]);
		Date dateEnrolled = new SimpleDateFormat("dd-MM-YYYY").parse(c1Array[6]);
		Double rating = Double.parseDouble(c1Array[7]);

		Customer2 customer = new Customer2(id, name, mobileNumber, birthdate, averageSpendAmount, totalAmount, dateEnrolled, rating);

		return customer;
	}

	/*
	 * This method accepts Customer2 list and a Customer2 name as arguments. Find
	 * the list of Customer2s with given name and return the list. If no
	 * Customer2s found with the given name return null.
	 */
	public static List<Customer2> findCustomer2(List<Customer2> Customer2List, String name) {

		List<Customer2> list = new ArrayList<>();

		for (Customer2 c : Customer2List) {
			if (c.getName().equalsIgnoreCase(name)) {
				list.add(c);
				c.toString();
			}
		}

		if (list == null) {
			return null;
		}

		return list;

	}

	/*
	 * This method accepts Customer2 list and birth date as arguments. Find the
	 * list of Customer2s with the given birth date and return the list. If no
	 * Customer2s found with the given birth date return null.
	 * 
	 */
	public static List<Customer2> findCustomer2(List<Customer2> Customer2List, Date birth) {

		List<Customer2> list = new ArrayList<>();

		for (Customer2 c : Customer2List) {
			if (c.getBirthdate().equals(birth)) {
				list.add(c);
				c.toString();
			}
		}

		if (list == null) {
			return null;
		}

		return list;

	}

	/*
	 * This method accepts Customer2 list and rating as arguments. Find the list
	 * of Customer2s with the given rating value and return the list. If no
	 * Customer2s found with the given rating return null.
	 * 
	 * 
	 */
	public static List<Customer2> findCustomer2(List<Customer2> Customer2List, Double rating) {

		List<Customer2> list = new ArrayList<>();

		for (Customer2 c : Customer2List) {
			if (c.getRating().equals(rating)) {
				list.add(c);
				c.toString();
			}
		}

		if (list == null) {
			return null;
		}

		return list;
	}

}
