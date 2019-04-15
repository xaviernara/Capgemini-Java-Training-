/**
 * 
 */
package com.capgemini.pwa.dao;

import com.capgemini.pwa.beans.Customer;
import com.capgemini.pwa.beans.Wallet;
import java.sql.*; // for standard JDBC programs

public class WalletDAOImp implements WalletDAO {

	public void createAccount(Wallet wallet) {
		
		
		try {
			
			
			String insertQuery = "INSERT INTO walletTable VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = DBconnection.dbConnect().prepareStatement(insertQuery);
			ps.setInt(1, wallet.getCustomer().getAccountNumber());
			ps.setString(2, wallet.getCustomer().getDateOfBirth());
			ps.setString(3, wallet.getCustomer().getEmail());
			ps.setString(4, wallet.getCustomer().getUserName());
			ps.setString(5, wallet.getCustomer().getPassword());
			ps.setInt(6, wallet.getCustomer().getPhoneNumber());
			ps.setString(7, wallet.getCustomer().getFullName());
			ps.setDouble(8, wallet.getBalance());
			ps.setString(9, wallet.getAccountType());

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("\n\t " + i + " records inserted");
				System.out.println("Your account number: " + wallet.getCustomer().getAccountNumber());
			} else {
				System.out.println("\n\t Record not inserted");
			}

			DBconnection.disconnect();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void transfer(int accountID1, int accountID2, double transferAmount) {

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

		try {
			String selectQuery1 = "SELECT balance FROM walletTable WHERE id = ?";
			String selectQuery2 = "SELECT balance FROM walletTable WHERE id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = DBconnection.dbConnect().prepareStatement(selectQuery1);
			PreparedStatement preparedStatement2 = DBconnection.dbConnect().prepareStatement(selectQuery2);
			preparedStatement.setInt(1, accountID1);
			preparedStatement2.setInt(1, accountID2);

			ResultSet rs = preparedStatement.executeQuery();
			ResultSet rs1 = preparedStatement.executeQuery();

			double balance1 = rs.getInt("balance");
			double balance2 = rs1.getInt("balance");

			double deduction = balance1 - transferAmount;
			double transfer = balance2 + deduction;

			String updateQuery1 = "UPDATE walletTable SET balance = ? WHERE id = ?";
			String updateQuery2 = "UPDATE walletTable SET balance = ? WHERE id = ?";
			preparedStatement = DBconnection.dbConnect().prepareStatement(updateQuery1);
			preparedStatement2 = DBconnection.dbConnect().prepareStatement(updateQuery2);

			preparedStatement.setInt(1, accountID1);
			preparedStatement.setDouble(2, deduction);

			preparedStatement2.setInt(1, accountID2);
			preparedStatement.setDouble(2, transfer);

			int i = preparedStatement2.executeUpdate();
			int i2 = preparedStatement2.executeUpdate();

			if (i > 0 & i2 > 0) {
				System.out.println("\n\t " + i + " records inserted");
				System.out.println("Transfer has been made");
				System.out.println("Your new balance: " + deduction);
			} else {
				System.out.println("Transfer could not be made!");
			}

			DBconnection.disconnect();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deposit(int accountNumber, double newMoney) {

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
		try {
			String selectQuery1 = "SELECT balance FROM walletTable WHERE id = ?";

			PreparedStatement preparedStatement = DBconnection.dbConnect().prepareStatement(selectQuery1);

			preparedStatement.setInt(1, accountNumber);

			ResultSet rs = preparedStatement.executeQuery();

			double balance = rs.getDouble("balance");

			// while (rs.next()) {
			// balance = rs.getDouble("balance");
			// }

			double newBalance = balance + newMoney;

			String updateQuery = "UPDATE walletTable SET balance =? WHERE id = ?";
			PreparedStatement preparedStatement2 = DBconnection.dbConnect().prepareStatement(updateQuery);
			preparedStatement2.setInt(2, accountNumber);
			preparedStatement2.setDouble(1, newBalance);

			int i = preparedStatement2.executeUpdate(updateQuery);

			if (i > 0) {
				System.out.println("You founds have been added to your account!");
			} else {
				System.out.println("Funds not added!");
			}

			DBconnection.disconnect();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		try {
			String selectQuery1 = "SELECT balance FROM walletTable WHERE id = ?";

			PreparedStatement preparedStatement = DBconnection.dbConnect().prepareStatement(selectQuery1);

			preparedStatement.setInt(1, accountNumber);

			ResultSet rs = preparedStatement.executeQuery();

			double balance = rs.getDouble("balance");

			String updateQuery = "UPDATE walletTable SET (balance) = ? WHERE id = ?";

			double subtract = balance - withdrawl;

			PreparedStatement preparedStatement2 = DBconnection.dbConnect().prepareStatement(updateQuery);
			preparedStatement2.setInt(2, accountNumber);
			preparedStatement2.setDouble(2, balance);

			int i = preparedStatement2.executeUpdate(updateQuery);

			if (i > 0) {
				System.out.println("You founds have been added to your account!");
			} else {
				System.out.println("Funds not added!");
			}

			DBconnection.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void printAllAccounts() {

		// for (Wallet wallet : accounts) {
		//
		// System.out.println(wallet.toString());
		// }

		try {
			String selectAllQuery = "SELECT * FROM walletTable";
			PreparedStatement preparedStatement = DBconnection.dbConnect().prepareStatement(selectAllQuery);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				System.out.println("Account Number: " + rs.getInt("id"));
				System.out.println("Full Name: " + rs.getString("fullname"));
				System.out.println("SSD:" + rs.getDouble("SSD"));
				System.out.println("BALANCE: " + rs.getDouble("balance"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Username: " + rs.getString("username"));
				System.out.println("Password: " + rs.getDouble("password"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBconnection.disconnect();
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
	
	public boolean validateLogin(String password, String userName) {

		//for (Wallet wallet : accounts) {

			if ((wallet.getCustomer().getPassword().equals(password))
					&& (wallet.getCustomer().getUserName().equals(userName))) {

				return true;
			}
		//}

		return false;
	}
	

	/*
	 * @Override public boolean validateAmmountAdditionRequest(Wallet account) {
	 * return false; }
	 */

	@Override
	public void findAccount(int accountNumber) {

		// for (Wallet wallet : accounts) {
		//
		// if
		// ((wallet.getCustomer().getFullName().equalsIgnoreCase(customerName))
		// && wallet.getAccountType().equalsIgnoreCase(accountType)) {
		// return wallet.getCustomer();
		// }
		// }
		//
		// System.out.println("Your Account can't be found");
		try {
			String selectQuery = "SELECT * FROM walletTable where id = ?";
			PreparedStatement preparedStatement = DBconnection.dbConnect().prepareStatement(selectQuery);
			preparedStatement.setInt(1, accountNumber);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				System.out.println("Account Number: " + rs.getString("id"));
				System.out.println("Full Name: " + rs.getString("fullname"));
				System.out.println("SSD" + rs.getDouble("SSD"));
				System.out.println("BALANCE: " + rs.getDouble("balance"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Username: " + rs.getString("username"));
				System.out.println("Password: " + rs.getDouble("password"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * returns boolean if the customer's account has zero balance or not
	 * 
	 */
	private boolean hasNonZeroBalance(double balance) {

		// if (account1.getBalance() > 0) {
		// return true;
		// }

		if (balance > 0) {
			return true;
		}

		return false;
	}

	private boolean hasAvaliableFunds(double balance, double transferAmount) {

		double subtract = balance - transferAmount;

		if (balance >= subtract) {
			return true;
		}
		System.out.println("You don't have enough funds to transfer money");
		return false;

	}

	/*
	 * returns boolean if both the customer's accounts exist or not
	 * 
	 */
	private boolean hasAccount(String account1, String account2) {

		// if ((account1.getAccountType() != null) && (account2.getAccountType()
		// != null)) {
		// return true;
		// }

		String noAccount = "";
		if ((account1 != "") || (account1 != null)) {
			if ((account2 != "") || (account2 != null)) {
				return true;
			} else {
				noAccount += "account 2";
			}

		} else {
			noAccount += "account 1";
		}

		if ((account1 == null) || (account2 == null)) {
			noAccount = "account1 & account2";
		}

		System.out.println(noAccount + " doesn't exsit");
		return false;
	}

	@Override
	public boolean validateTransfer(double balance1, double transferAmount, String account1, String account2) {

		// for(Wallet wallet: account){

		// if(wallet.getCustomer().getFullName().equalsIgnoreCase(name1) &&
		// wallet.getCustomer().getFullName().equalsIgnoreCase(name2)){

		if (hasAccount(account1, account2)) {
			if (hasNonZeroBalance(balance1)) {

				if (hasAvaliableFunds(balance1, transferAmount)) {
					return true;
				}

			}
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
	public void viewBalance(int accountNumber) {

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
				System.out.println("Account Balance: " + res.getInt("balance"));
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
		String deleteQuery = "DELETE FROM walletTable WHERE password = ? AND username = ?";

		try {
			PreparedStatement preparedStatement = DBconnection.dbConnect().prepareStatement(deleteQuery);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, userName);
			int i = preparedStatement.executeUpdate(deleteQuery);
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
