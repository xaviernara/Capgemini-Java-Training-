/**
 * 
 */
package com.capgemini.pwa.dao;

import java.sql.*;

/**
 * @author xarichar
 *
 */
public class DBconnection {

	static Connection con = null;

	public static Connection dbConnect() {

		try {
			// Driver myDriver = new oracle.jdbc.driver.OracleDriver();
			// DriverManager.registerDriver(myDriver);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String USER = "system";
			String PASS = "Capgemini@15";
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", USER, PASS);

		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;

	}

	public static void disconnect() {
		try {
			con.close();
			System.out.println("Closed.");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
