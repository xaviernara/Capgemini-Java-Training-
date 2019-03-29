package com.capgemini.pwa.dao;

import java.util.*;

import com.capgemini.pwa.beans.Customer;
import com.capgemini.pwa.beans.Wallet;

public interface WalletDAO {

	/*
	 * Given the account holding user, the user is able to transfer some or all
	 * of his/her funds from their own account to any other account registered
	 * on the payment wallet application.
	 * 
	 * return the amount transfered from one customer to another
	 */
	public int transfer(Wallet account1, Wallet account2, int transferAmount);

	/*
	 * deposit will calculate the customer's new balance after money is added to
	 * their account
	 * 
	 */
	void deposit(Customer customer ,int newMoney);

	/*
	 * withdraw() will return the money that a customer wants to transfer to
	 * another user and return the new balance after withdrawal
	 */
	int withdraw(Customer customer);
	
	
	/*
	 * print all the Customers with accounts
	 * 
	 */
	Customer printAllAccounts(Set<Customer> customers);

	/*
	 * Given the user signup / register / create account page, the user is able
	 * to enter the necessary data and create an account on the payment wallet
	 * application.
	 */
	void signUp(Set<Customer> newCustomers);

	/*
	 * Given the user details, the data entered should be validated before
	 * registering the user and creating an account for the same.
	 * 
	 * return boolean if a new customer object is created 
	 */
	boolean validateSignUp();

	/*
	 * return boolean if a customer new balance is updated in the Wallet class
	 * also if the customer has a wallet
	 */
	boolean validateAmmountAdditionRequest();

	/*
	 * Given the account holding user, the user is able to add desired amount to
	 * his/her respective account.
	 * 
	 * returns the new balance of the Customer if validateAmmountAdditionRequest() returns true
	 */
	int addFunds(int newDeposit);

	/*
	 * Given the registered credentials, the user should be able to access the
	 * payment wallet.
	 * 
	 * 
	 */
	Customer findAccount(Set<Wallet> accounts, String accountType, String customerName);
	

	/*
	 * return boolean if both customers have a wallet and customer1 has enough money to transfer to the other
	 */
	boolean validateTransfer(Wallet account1, Wallet account2);
}
