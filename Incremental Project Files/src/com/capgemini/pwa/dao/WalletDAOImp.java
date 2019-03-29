/**
 * 
 */
package com.capgemini.pwa.dao;

import java.util.Set;

import com.capgemini.pwa.beans.Customer;
import com.capgemini.pwa.beans.Wallet;

public class WalletDAOImp implements WalletDAO {

	@Override
	public int transfer(Wallet account1, Wallet account2, int transferAmount) {
		
		if (validateTransfer(account1,account2)) {
			int deduction = account1.viewBalance() - transferAmount;
			int transfer = account2.viewBalance() + deduction;
			account2.setBalance(transfer);
			account1.setBalance(deduction);
			
			System.out.println("Your new balance: " );
			return account1.viewBalance();
		}

		return 0;
	}

	@Override
	public void deposit(Wallet account, int newMoney) {
		System.out.println("Your new balance before deposit: " + account.viewBalance());
		int newBalance = account.viewBalance() + newMoney; 
		account.setBalance(newBalance);
		System.out.println("Your new balance after deposit: " + account.viewBalance());
		
	}

	@Override
	public void withdraw(Wallet account, int withdrawl ) {
		
		System.out.println("Your new balance before withdrawl: " + account.viewBalance());
		
		int subtract = account.viewBalance() - withdrawl;
		
		account.setBalance(subtract);
		
		System.out.println("Your new balance after withdrawl: " + account.viewBalance());
	}

	@Override
	public Customer printAllAccounts(Set<Wallet> account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void signUp(Set<Customer> newCustomers) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validateSignUp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateAmmountAdditionRequest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addFunds(int newDeposit, Wallet account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer findAccount(Set<Wallet> accounts, String accountType, String customerName) {

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

		if (account1.viewBalance() > 0) {
			return true;
		}

		return false;
	}

	/*
	 * returns boolean if both the customer's accounts exist or not 
	 * 
	 */
	private boolean hasAccount(Wallet account1, Wallet account2) {

		if ((account1.getAccountType() != null) && (account2.getAccountType()  != null)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean validateTransfer(Wallet account1, Wallet account2) {

		if (hasNonZeroBalance(account1) && hasAccount(account1,account2)) {
			return true;
		}
		return false;
	}

}
