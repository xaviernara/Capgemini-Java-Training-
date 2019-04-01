package com.capgemini.pwa.beans;

public class Wallet {

	

	private double balance;
	private Customer customer;
	private String accountType;

	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}


	/*
	public Customer addAccount(String dateOfBirth, long SSD, String fullName, int deposit, int phoneNumber, String email, String password, int accountNumber, String userName) {
		
		customer = new Customer(dateOfBirth,SSD,fullName,deposit,phoneNumber,email,password,accountNumber, userName);
		System.out.println("Account Created!!!");
		return customer;
	}
	*/
	

	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	/*
	 * Given the addition of amount is successful, the new account balance
	 * should be available to the user for utilization at his/her discretion.
	 * 
	 * Given the account holding user, the user is able to see the available
	 * balance in his/her own account.
	 */
	public double getBalance(){
		return balance;
	}

	public Wallet(Customer customer,String accountType) {
		this.customer = customer;
		this.accountType = accountType;
		balance = customer.getDeposit() + balance;
	}
	
	

	@Override
	public String toString() {
		return String.format(String.format("%-15s %-30s %-15s",balance,customer,accountType));
	}


	
}
