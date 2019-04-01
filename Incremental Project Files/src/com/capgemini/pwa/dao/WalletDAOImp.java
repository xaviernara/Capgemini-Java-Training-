/**
 * 
 */
package com.capgemini.pwa.dao;

import com.capgemini.pwa.beans.Customer;
import com.capgemini.pwa.beans.Wallet;

public class WalletDAOImp implements WalletDAO {

	@Override
	public double transfer(Wallet account1, Wallet account2, double transferAmount) {

		if (validateTransfer(account1, account2)) {

			double deduction = account1.getBalance() - transferAmount;
			double transfer = account2.getBalance() + deduction;
			account2.setBalance(transfer);
			account1.setBalance(deduction);

			System.out.println("Your new balance: ");
			return account1.getBalance();
		}

		// if (validateTransfer(account1, account2)) {

		return 0.0;

	}

	@Override
	public void deposit(Wallet[] account, int accountNumber, double newMoney) {

		for (Wallet wallet : account) {

			if (validateAccountNumber(account, accountNumber)) {
				System.out.println("Your balance before deposit: " + wallet.getBalance());
				double newBalance = wallet.getBalance() + newMoney;
				wallet.setBalance(newBalance);
				System.out.println("Your new balance after deposit: " + wallet.getBalance());

			}
		}

	}

	private boolean validateAccountNumber(Wallet[] account, int accountNumber) {
		for (Wallet wallet : account) {

			if (wallet.getCustomer().getAccountNumber() == accountNumber) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void withdraw(Wallet[] account, int accountNumber, double withdrawl) {

		for (Wallet wallet : account) {

			if (validateAccountNumber(account, accountNumber)) {
				System.out.println("Your new balance before withdrawl: " + wallet.getBalance());

				double subtract = wallet.getBalance() - withdrawl;

				wallet.setBalance(subtract);

				System.out.println("Your new balance after withdrawl: " + wallet.getBalance());
			}
		}
	}

	@Override
	public void printAllAccounts(Wallet[] accounts) {

		for (Wallet wallet : accounts) {

			System.out.println(wallet.toString());
		}
	}

	@Override
	public boolean validateLogin(Wallet[] accounts, String password, String userName) {

		for (Wallet wallet : accounts) {

			if ((wallet.getCustomer().getPassword().equals(password))
					&& (wallet.getCustomer().getUserName().equals(userName))) {

				return true;
			}
		}

		return false;
	}

	/*
	 * @Override public boolean validateAmmountAdditionRequest(Wallet account) {
	 * return false; }
	 */

	@Override
	public Customer findAccount(Wallet[] accounts, String accountType, String customerName) {

		for (Wallet wallet : accounts) {

			if ((wallet.getCustomer().getFullName().equalsIgnoreCase(customerName))
					&& wallet.getAccountType().equalsIgnoreCase(accountType)) {
				return wallet.getCustomer();
			}
		}

		System.out.println("Your Account can't be found");
		return null;
	}

	/*
	 * returns boolean if the customer's account has zero balance or not
	 * 
	 */
	private boolean hasNonZeroBalance(Wallet account1) {

		if (account1.getBalance() > 0) {
			return true;
		}

		return false;
	}

	/*
	 * returns boolean if both the customer's accounts exist or not
	 * 
	 */
	private boolean hasAccount(Wallet account1, Wallet account2) {

		if ((account1.getAccountType() != null) && (account2.getAccountType() != null)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean validateTransfer(Wallet account1, Wallet account2) {

		//for(Wallet wallet: account){
			
			//if(wallet.getCustomer().getFullName().equalsIgnoreCase(name1) && wallet.getCustomer().getFullName().equalsIgnoreCase(name2)){
				
				if (hasNonZeroBalance(account1) && hasAccount(account1, account2)){
					
					return true;
				}
		
		return false;
	}

	public boolean validateSignUp(Wallet account) {
		if (account != null) {
			System.out.println(account.getCustomer().getFullName() + " your Account has been created!!!");
			return true;
		}

		System.out.println("Your account could not be created");
		return false;

	}

	@Override
	public double viewBalance(Wallet[] account, int accountNumber) {

		for (Wallet wallet : account) {

			if (validateAccountNumber(account, accountNumber)) {
				return wallet.getBalance();
			}
		}

		System.out.println("Your balance can't be found");
		return 0;
	};

}
