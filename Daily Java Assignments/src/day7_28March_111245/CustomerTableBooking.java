/**
 * 
 */
package day7_28March_111245;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author xarichar
 *
 *  Assignment #21
 */
public class CustomerTableBooking {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the details of Customer 1: ");
		String c1Details = scan.nextLine();
		String[] c1Array = c1Details.split(",");
		System.out.println("Enter the details of Customer 2: ");
		String c2Details = scan.nextLine();
		String[] c2Array = c2Details.split(",");

		Long id = Long.parseLong(c1Array[0]);
		String name = c1Array[1];
		String mobileNumber = c1Array[2];
		Date birthdate = new SimpleDateFormat("dd-MMYYYY").parse(c1Array[3]);
		Double averageSpendAmount = Double.parseDouble(c1Array[4]);
		Double totalAmount = Double.parseDouble(c1Array[5]);
		Date dateEnrolled = new SimpleDateFormat("dd-MM-YYYY").parse(c1Array[6]);
		Double rating = Double.parseDouble(c1Array[7]);

		Customer customer1 = new Customer(id, name, mobileNumber, birthdate, averageSpendAmount, totalAmount,
				dateEnrolled, rating);
		System.out.println("Details of customer 1:");
		System.out.println(customer1.toString());

		// Customer 2 info
		Long id2 = Long.parseLong(c2Array[0]);
		String name2 = c2Array[1];
		String mobileNumber2 = c2Array[2];
		Date birthdate2 = new SimpleDateFormat("dd-MMYYYY").parse(c2Array[3]);
		Double averageSpendAmount2 = Double.parseDouble(c2Array[4]);
		Double totalAmount2 = Double.parseDouble(c2Array[5]);
		Date dateEnrolled2 = new SimpleDateFormat("dd-mm-yyyy").parse(c2Array[6]);
		Double rating2 = Double.parseDouble(c1Array[7]);
		

		Customer customer2 = new Customer(id2, name2, mobileNumber2, birthdate2, averageSpendAmount2, totalAmount2,
				dateEnrolled2, rating2);
		System.out.println("Details of customer 2:");
		System.out.println(customer2.toString());
		
		if(customer1.equals(customer2)){
			System.out.println("Customer 1 is same as Customer 2");
		}
		else{

			System.out.println("Customer 1 and Customer 2 are different");
		}

	}

}

class Customer {

	private Long id;
	private String name;
	private String mobileNumber;
	private Date birthdate;
	private Double averageSpendAmount;
	private Double totalAmount;
	private Date dateEnrolled;
	private Double rating;

	public Customer(Long id, String name, String mobileNumber, Date birthdate, Double averageSpendAmount,
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

	@Override
	public String toString() {
		return "id=" + id + " \n name=" + name + "\n mobileNumber= " + mobileNumber + "\n birthdate= " + birthdate
				+ "\n averageSpendAmount=" + averageSpendAmount + " \n totalAmount=" + totalAmount + "\n dateEnrolled="
				+ dateEnrolled + "\n rating=" + rating;
	}

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
	 * @Override public boolean equals(Object obj) { if (this == obj) return
	 * true; if (obj == null) return false; if (getClass() != obj.getClass())
	 * return false; Customer other = (Customer) obj; if (averageSpendAmount ==
	 * null) { if (other.averageSpendAmount != null) return false; } else if
	 * (!averageSpendAmount.equals(other.averageSpendAmount)) return false; if
	 * (birthdate == null) { if (other.birthdate != null) return false; } else
	 * if (!birthdate.equals(other.birthdate)) return false; if (dateEnrolled ==
	 * null) { if (other.dateEnrolled != null) return false; } else if
	 * (!dateEnrolled.equals(other.dateEnrolled)) return false; if (id == null)
	 * { if (other.id != null) return false; } else if (!id.equals(other.id))
	 * return false; if (mobileNumber == null) { if (other.mobileNumber != null)
	 * return false; } else if (!mobileNumber.equals(other.mobileNumber)) return
	 * false; if (name == null) { if (other.name != null) return false; } else
	 * if (!name.equals(other.name)) return false; if (rating == null) { if
	 * (other.rating != null) return false; } else if
	 * (!rating.equals(other.rating)) return false; if (totalAmount == null) {
	 * if (other.totalAmount != null) return false; } else if
	 * (!totalAmount.equals(other.totalAmount)) return false; return true; }
	 */

	@Override
	public boolean equals(Object obj) {

		Customer customer = (Customer) obj;

		if (name.equalsIgnoreCase(customer.name)) {

			if (mobileNumber.equals(customer.mobileNumber)) {

				if (birthdate.equals(customer.birthdate)) {

					return true;
				}
			}

		}
		return false;
	}

}
