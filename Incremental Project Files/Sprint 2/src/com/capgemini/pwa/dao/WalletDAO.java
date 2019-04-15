package com.capgemini.pwa.dao;

import com.capgemini.pwa.beans.Customer;
import com.capgemini.pwa.beans.Wallet;

public interface WalletDAO {

	/*
	 * Adds a new customer to the database
	 * and prints the customer new account number
	 * 
	 */
	public void createAccount(Wallet wallet);
	
	/*
	 * Given the account holding user, the user is able to transfer some or all
	 * of his/her funds from their own account to any other account registered
	 * on the payment wallet application.
	 * 
	 * return the amount transfered from one customer to another
	 */
	public void transfer(int accountID1, int accountID2, double transferAmount) ;

	/*
	 * deposit will calculate the customer's new balance after money is added to
	 * their account
	 * 
	 * 
	 * Given the account holding user, the user is able to add desired amount to
	 * his/her respective account.
	 * 
	 * returns the new balance of the Customer if
	 * validateAmmountAdditionRequest() returns true
	 *
	 */
	public void deposit(int accountNumber, double newMoney);

	/*
	 * withdraw() will return the money that a customer wants to transfer to
	 * another user and return the new balance after withdrawal
	 */
	public void withdraw(int accountNumber, double withdrawl) ;

	/*
	 * print all the Customers with wallet accounts from the database
	 * 
	 */
	public void printAllAccounts();

	/*
	 * Given the user signup / register / create account page, the user is able
	 * to enter the necessary data and create an account on the payment wallet
	 * application.
	 * 
	 * void signUp(Set<Customer> newCustomers);
	 */
	

	/*
	 * Given the user details, the data entered should be validated before
	 * registering the user and creating an account for the same.
	 * 
	 * return boolean if a new customer object is created
	 */
	boolean validateSignUp(Wallet account);

	/*
	 * return boolean if a customer new balance is updated in the Wallet class
	 * also if the customer has a wallet
	 * 
	 * boolean validateAmmountAdditionRequest();
	 */
	
	/*
	 * prints the available balance of the customer's wallet account (ie the database)
	 * 
	 */
	public void viewBalance(int accountNumber);
	
	

	/*
	 * Given the registered credentials, the user should be able to access the
	 * payment wallet.
	 */
	public void findAccount(int accountNumber) ;

	/*
	 * return boolean if both customers have a wallet and customer1 has enough
	 * money to transfer to the other
	 */
	public boolean validateTransfer(double balance1, double transferAmount, String account1, String account2);

	/*
	 * returns boolean if the password and user name match the wallet account or not
	 */
	public boolean validateLogin(Wallet[] accounts, String password, String userName);
	
	
	/*
	 * Deletes customer wallet account from database
	 */
	public void deleteAccount(String userName, String password);
	
}
