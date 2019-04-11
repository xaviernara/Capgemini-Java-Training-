/**
 * 
 */
package com.capgemini.pwa.dao;

import com.capgemini.pwa.beans.Customer;
import com.capgemini.pwa.beans.Wallet;
import java.sql.*; // for standard JDBC programs

public class WalletDAOImp implements WalletDAO {

	@Override
	public double transfer(int accountID1, int accountID2, double transferAmount) {

		
		// if (validateTransfer(account1, account2)) {
		//
		// double deduction = account1.getBalance() - transferAmount;
		// double transfer = account2.getBalance() + deduction;
		// account2.setBalance(transfer);
		// account1.setBalance(deduction);
		//
		// System.out.println("Your new balance: ");
		// return account1.getBalance();
		// }

		// if (validateTransfer(account1, account2)) {
		
		String selectQuery1 = "SELECT balance FROM walletTable WHERE id = ?";
		String selectQuery2 = "SELECT balance FROM walletTable WHERE id = ?";
		PreparedStatement preparedStatement = DBconnection.dbConnect().prepareStatement(selectQuery1);
		PreparedStatement preparedStatement2 = DBconnection.dbConnect().prepareStatement(selectQuery2);
		preparedStatement.setInt(1,accountID1);
		preparedStatement2.setInt(1,accountID2);
		
		
		ResultSet rs = preparedStatement.executeQuery();
		ResultSet rs1 = preparedStatement.executeQuery();
		
		
		
		double balance1,balance2;
		while (rs.next() & rs1.next()){
			balance1 = rs.getInt("balance");
			balance2 = rs1.getInt("balance");
		}

		
		double deduction = balance1 - transferAmount;
		double transfer = balance2 + deduction;
		
		String updateQuery1 = "UPDATE walletTable SET balance = ? WHERE id = ?";
		String updateQuery2 = "UPDATE walletTable SET balance = ? WHERE id = ?";
		preparedStatement = DBconnection.dbConnect().prepareStatement(updateQuery1);
		preparedStatement2 = DBconnection.dbConnect().prepareStatement(updateQuery2);
		
		preparedStatement.setInt(1,accountID1);
		preparedStatement.setDouble(3, deduction);
		
		preparedStatement2.setInt(1,accountID2);
		preparedStatement.setDouble(3,transfer);
		
		int i = preparedStatement2.executeUpdate();
		int i2 = preparedStatement2.executeUpdate();
		
		if(i>0 & i2>0){
			System.out.println("\n\t " + i + " records inserted");
			System.out.println("Transfer has been made");
		}else{
			System.out.println("Transfer could not be made!");
		}
		return 0.0;

	}

	@Override
	public void deposit(Wallet[] account, int accountNumber, double newMoney) {

		// for (Wallet wallet : account) {
		//
		// if (validateAccountNumber(account, accountNumber)) {
		// System.out.println("Your balance before deposit: " +
		// wallet.getBalance());
		// double newBalance = wallet.getBalance() + newMoney;
		// wallet.setBalance(newBalance);
		// System.out.println("Your new balance after deposit: " +
		// wallet.getBalance());
		//
		// }
		// }

		String selectQuery1 = "SELECT balance FROM walletTable WHERE id = ?";
		String insertQuery = "INSERT INTO walletTable (balance) VALUES ('?') WHERE id = ?";
		

		PreparedStatement preparedStatement = DBconnection.dbConnect().prepareStatement(selectQuery1);
		preparedStatement.setInt(1,accountNumber);
		
		PreparedStatement preparedStatement2 = DBconnection.dbConnect().prepareStatement(insertQuery);
		preparedStatement.setInt(1,accountID1);
		int i = executeUpdate(insertQuery);

		if (i > 0) {
			System.out.println("You founds have been added to your account!");
		} else {
			System.out.println("Funds not added!");
		}

	}

	private boolean validateAccountNumber(Wallet[] account, int accountNumber) {

		int count = 0;
		for (Wallet wallet : account) {

			if (wallet.getCustomer().getAccountNumber() == accountNumber) {
				count++;

			}
		}

		if (count == 1) {
			return true;

		} else if (count == 0) {

			System.out.println("That account number was not found");
			return false;
		}

		System.out.println("That account number belongs to someone else");
		return false;

	}

	@Override
	public void withdraw(int accountNumber, double withdrawl) {

		// for (Wallet wallet : account) {
		//
		// if (validateAccountNumber(account, accountNumber)) {
		// System.out.println("Your new balance before withdrawl: " +
		// wallet.getBalance());
		//
		// double subtract = wallet.getBalance() - withdrawl;
		//
		// wallet.setBalance(subtract);
		//
		// System.out.println("Your new balance after withdrawl: " +
		// wallet.getBalance());
		// }
		// }

		String updateQuery = "UPDATE walletTable SET (balance) = ? WHERE id = ?";

		Statement st = DBconnection.dbConnect().createStatement();

		int i = executeUpdate(updateQuery);

		if (i > 0) {
			System.out.println("You founds have been added to your account!");
		} else {
			System.out.println("Funds not added!");
		}

	}

	@Override
	public void printAllAccounts() {

//		for (Wallet wallet : accounts) {
//
//			System.out.println(wallet.toString());
//		}
		
		String selectAllQuery = "SELECT * FROM walletTable";
		PreparedStatement preparedStatement = DBconnection.dbConnect().prepareStatement(selectAllQuery);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()){
			System.out.println("Account Number: " + rs.getString("id"));
			System.out.println("Full Name: "+rs.getString("fullname"));
			System.out.println("SSD"+rs.getDouble("SSD"));
			System.out.println("BALANCE: "+rs.getDouble("balance"));
			System.out.println("Email: "+rs.getString("email"));
			System.out.println("Username: "+rs.getString("username"));
			System.out.println("Password: "+rs.getDouble("password"));
			
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

//		for (Wallet wallet : accounts) {
//
//			if ((wallet.getCustomer().getFullName().equalsIgnoreCase(customerName))
//					&& wallet.getAccountType().equalsIgnoreCase(accountType)) {
//				return wallet.getCustomer();
//			}
//		}
//
//		System.out.println("Your Account can't be found");
		try{
			String selectQuery = "SELECT * FROM walletTable where id = ?";
		PreparedStatement preparedStatement = DBconnection.dbConnect().prepareStatement(selectQuery);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()){
			System.out.println("Account Number: " + rs.getString("id"));
			System.out.println("Full Name: "+rs.getString("fullname"));
			System.out.println("SSD"+rs.getDouble("SSD"));
			System.out.println("BALANCE: "+rs.getDouble("balance"));
			System.out.println("Email: "+rs.getString("email"));
			System.out.println("Username: "+rs.getString("username"));
			System.out.println("Password: "+rs.getDouble("password"));
			
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
		
		
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

		// for(Wallet wallet: account){

		// if(wallet.getCustomer().getFullName().equalsIgnoreCase(name1) &&
		// wallet.getCustomer().getFullName().equalsIgnoreCase(name2)){

		if (hasNonZeroBalance(account1) && hasAccount(account1, account2)) {

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
	public double viewBalance(int accountNumber) {

		// for (Wallet wallet : account) {
		//
		// if (validateAccountNumber(account, accountNumber)) {
		// return wallet.getBalance();
		// }
		// }
		//
		// System.out.println("Your balance can't be found");
		// return 0;
		// String selectQuery = "SELECT * FROM walletTable WHERE id = '" +
		// accountNumber + "'";
		try {
			String selectQuery = "SELECT * FROM walletTable WHERE id = ?";
			PreparedStatement preparedStatement = DBconnection.dbConnect().prepareStatement(selectQuery);
			preparedStatement.setInt(1, accountNumber);

			ResultSet res = preparedStatement.executeQuery();

			while (res.next()) {
				System.out.println("Account Balance: " + res.getInt(4));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/*
	 * Deletes customer wallet account from database
	 */
	@Override
	public void deleteAccount(String userName, String password) {
		String deleteQuery = "DELETE FROM walletTable WHERE password ='" + password + "' AND username = '" + userName
				+ "'";

		try {
			Statement st = DBconnection.dbConnect().createStatement();
			int i = st.executeUpdate(deleteQuery);
			if (i > 0) {
				System.out.println("Your account has been delete");
			} else {

				System.out.println("Your account hasn't been delete ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
