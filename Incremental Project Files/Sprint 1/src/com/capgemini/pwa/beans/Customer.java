/**
 * 
 */
package com.capgemini.pwa.beans;

import java.util.Random;

/**
 * @author xarichar
 *
 */
public class Customer {

	private String dateOfBirth;
	private long SSD;
	private String fullName;
	private double deposit;
	private int phoneNumber;
	private String email;
	private String password;
	private int accountNumber;
	private String userName;
	
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getSSD() {
		return SSD;
	}

	public void setSSD(long sSD) {
		SSD = sSD;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Customer(String dateOfBirth, long SSD, String fullName, double deposit,int phoneNumber, String email, String password, String userName) {
		Random random = new Random();
		this.dateOfBirth = dateOfBirth;
		this.SSD = SSD;
		this.fullName = fullName;
		this.deposit = deposit;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.accountNumber = ((int)(Math.random()*(1000 - 9999))+1000); //generates random account number between 1000 and 9999 
		this.userName = userName;
	}





}
