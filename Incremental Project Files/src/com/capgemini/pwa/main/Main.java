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

		String wantAccount = scan.nextLine();

		if (wantAccount == "yes") {
			System.out.println("How many accounts do you wanna create: ");
		} else {
			System.out.println("Have a nice day!!!");
		}

		int numOfAccount = scan.nextInt();
		Wallet[] walletArray = new Wallet[numOfAccount];

		for (Wallet wallet : walletArray) {

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

			System.out.println("Enter the type account you want (e.g. Financial or Business): ");
			String accountType = scan.nextLine();

			wallet = new Wallet(customer, accountType);

			if (walletDAO.validateSignUp(wallet)) {
				System.out.println("Your account number is: "+wallet.getCustomer().getAccountNumber());
				System.out.println("Thank you for signing up! \n Login to acces your payment wallet");

			}
		}

		boolean menuContinue = true;
		System.out.println("Login");
		System.out.println("Enter Username: ");
		String userName = scan.nextLine();

		System.out.println("Enter Password: ");
		String password = scan.nextLine();

		if (walletDAO.validateLogin(walletArray, password, userName)) {

			while (menuContinue) {

				System.out.println("Payment Wallet Menu");

				System.out.println("1.Deposit money into your account");
				System.out.println("2.View your avaliable balance");
				System.out.println("3.Transfer funds from one account to another");
				System.out.println("4.Withdraw from your account");
				//System.out.println("5.Remove your account");
				System.out.println("5.Log out");
				
				int menuChoice = scan.nextInt();
				
				switch(menuChoice){
				
				case 1:
					System.out.println("How much would you like to add to your account?");
					double newMoney = scan.nextDouble();
					System.out.println("Enter your account number ");
					int accountNumber = scan.nextInt();
					walletDAO.deposit(walletArray,accountNumber ,newMoney);
					
				case 2:
					System.out.println("Enter your account number ");
					accountNumber = scan.nextInt();
					System.out.println("Account Balance: "+ walletDAO.viewBalance(walletArray, accountNumber));
					
				case 3:
					System.out.println("Enter your account number ");
					accountNumber = scan.nextInt();
					System.out.println("Account Balance: "+ walletDAO.viewBalance(walletArray, accountNumber));
					
					System.out.println("Enter the account number of the account you want to transfer funds ");
					int accountNumber2 = scan.nextInt();
					
					System.out.println("Enter the amount you want to transfer: ");
					double transferAmount = scan.nextDouble();
					
					for(Wallet wallet: walletArray){
						
						Wallet account1, account2;
						if(wallet.getCustomer().getAccountNumber() == accountNumber){
							account1 = wallet;
						}
						if(wallet.getCustomer().getAccountNumber() == accountNumber2){
							account2 = wallet;
						}
						
						walletDAO.transfer(account1, account2, transferAmount)
					}
						
				case 4:
					System.out.println("How much would you like to withdraw from your account?");
					double withdrawl = scan.nextDouble();
					System.out.println("Enter your account number ");
					accountNumber = scan.nextInt();
					walletDAO.withdraw(walletArray, accountNumber, withdrawl);
				case 5:
					System.out.println("Thanks for using your payment wallet");
					menuContinue = false;
					
				}
				
			}
		}
		
		else{
			System.out.println("Your account was not found please try again.");
			
		}

	}

}
