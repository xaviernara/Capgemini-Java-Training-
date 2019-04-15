/**
 * 
 */
package com.capgemini.services;

import com.capgemini.SpringCoreDemo.EmployeeDAO;

/**
 * @author xarichar
 *
 */
public class EmployeeService {

	private EmployeeDAO empDAO;
	public EmployeeService(EmployeeDAO empDAO) {
		this.empDAO = empDAO;
	}
	
	public EmployeeService() {
		
	}
	

}
