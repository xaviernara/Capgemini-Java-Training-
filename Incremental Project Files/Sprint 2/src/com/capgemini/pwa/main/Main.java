/**
 * 
 */
package com.capgemini.pwa.main;

import java.util.*;

import com.capgemini.pwa.beans.Customer;
import com.capgemini.pwa.beans.Wallet;
import com.capgemini.pwa.dao.WalletDAOImp;

/**
 * @author xarichar
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WalletDAOImp walletDAO = new WalletDAOImp();
		Scanner scan = new Scanner(System.in).useDelimiter(System.lineSeparator());

		System.out.println("Welcome would you like to open a Payment Wallet Application?");
		System.out.println("1. Sign Up");
		System.out.println("2  Login");
		System.out.println("3. Exit");
		int wantAccount = scan.nextInt();

		switch (wantAccount) {

		case 1:
			System.out.println("How many accounts do you wanna create: ");

			int numOfAccount = scan.nextInt();
			Wallet[] walletArray = new Wallet[numOfAccount];

			for (int i =0; i< walletArray.length;i++) {

				System.out.println("Enter Full Name: ");
				String fullName = scan.nextLine();

				System.out.println("Enter Data of Birth: ");
				String dateOfBirth = scan.nextLine();

				System.out.println("Enter Phone Number: ");
				int phoneNumber = scan.nextInt();

				System.out.println("Enter Social Secuirty Number: ");
				long SSD = scan.nextLong();

				System.out.println("Enter Email: ");
				String email = scan.nextLine();

				System.out.println("Enter Username: ");
				String userName = scan.nextLine();

				System.out.println("Enter Password: ");
				String password = scan.nextLine();

				System.out.println("Enter amount you would like to depsoit to start your account: ");
				double deposit = scan.nextDouble();

				// creating a customer object
				Customer customer = new Customer(dateOfBirth, SSD, fullName, deposit, phoneNumber, email, password,
						userName);

				System.out.println("Enter the type of account you want (e.g. Financial or Business): ");
				String accountType = scan.nextLine();

				walletArray[i] = new Wallet(customer, accountType);

				if (walletDAO.validateSignUp(walletArray[i])) {
					// System.out.println("Your account number is:
					// "+wallet.getCustomer().getAccountNumber());
					walletDAO.createAccount(walletArray[i]);
					
					System.out.println("Thank you for signing up! \n Login to access your payment wallet");

				} else {
					System.out.println("Account couldn't be created");
					return;
				}
			}

			break;

		case 2:
			System.out.println("Enter Username: ");
			String userName = scan.nextLine();

			System.out.println("Enter Password: ");
			String password = scan.nextLine();

			boolean menuContinue = true;

			if (walletDAO.validateLogin(walletArray, password, userName)) {

				while (menuContinue) {

					System.out.println("Payment Wallet Menu");
					System.out.println("1.Deposit money into your account");
					System.out.println("2.View your avaliable balance");
					System.out.println("3.Transfer funds from one account to another");
					System.out.println("4.Withdraw from your account");
					System.out.println("5.Remove your account");
					System.out.println("6.Log out");

					int menuChoice = scan.nextInt();

					switch (menuChoice) {

					case 1:
						System.out.println("How much would you like to add to your account?");
						double newMoney = scan.nextDouble();
						System.out.println("Enter your account number ");
						int accountNumber = scan.nextInt();
						walletDAO.deposit(accountNumber, newMoney);
						break;

					case 2:
						System.out.println("Enter your account number ");
						accountNumber = scan.nextInt();
						walletDAO.viewBalance(accountNumber);
						break;

					case 3:
						System.out.println("Enter your account number ");
						accountNumber = scan.nextInt();
						//walletDAO.viewBalance(accountNumber);

						System.out.println("Enter the account number of the account you want to transfer funds ");
						int accountNumber2 = scan.nextInt();

						System.out.println("Enter the amount you want to transfer: ");
						double transferAmount = scan.nextDouble();
						
						walletDAO.transfer(accountNumber, accountNumber2, transferAmount);

						/*
						for (Wallet wallet : walletArray) {

							Wallet account1 = new Wallet();
							Wallet account2 = new Wallet();
							if (wallet.getCustomer().getAccountNumber() == accountNumber) {
								account1 = wallet;
							}
							if (wallet.getCustomer().getAccountNumber() == accountNumber2) {
								account2 = wallet;
							}

							walletDAO.transfer(account1, account2, transferAmount);
						}
						*/

						break;
					case 4:
						System.out.println("How much would you like to withdraw from your account?");
						double withdrawl = scan.nextDouble();
						System.out.println("Enter your account number ");
						accountNumber = scan.nextInt();
						walletDAO.withdraw(accountNumber, withdrawl);
						break;
					case 5:
						System.out.println("Enter Username: ");
						userName = scan.nextLine();

						System.out.println("Enter Password: ");
						password = scan.nextLine();
						walletDAO.deleteAccount(userName, password);
						System.out.println("Thank you for you time with us!");
						break;

					case 6:
						System.out.println("Thanks for using your payment wallet");
						menuContinue = false;
						break;
					}

				}
			}

			else {
				System.out.println("Your account was not found please try again.");

			}

		case 3:
			System.out.println("Have a nice day!!!");
			break;

		}

		scan.close();

	}

}
