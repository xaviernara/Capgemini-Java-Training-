/**
 * 
 */
package com.capgemini.SpringCoreDemo;

/**
 * @author xarichar
 *
 */
public class EmployeeDAO {

private String dbURL;
private String dbDriver;
private String username;
private String password;

	/**
 * @param dbURL
 * @param dbDriver
 * @param username
 * @param password
 */
public EmployeeDAO(String dbURL, String dbDriver, String username, String password) {
	this.dbURL = dbURL;
	this.dbDriver = dbDriver;
	this.username = username;
	this.password = password;
}

	public EmployeeDAO() {
		System.out.println("EmployeeDAO object created.....");
	}

}
