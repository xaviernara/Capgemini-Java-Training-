package day7_28March_111245;

import java.util.*;

public class EmployeeTreeSet {

	public EmployeeTreeSet() {
		Set<Employee> empTreeSet = new TreeSet<>(new EmployeeComparator());
		empTreeSet.add(new Employee(1000, "john"));
		empTreeSet.add(new Employee(1001, "kyle"));
		empTreeSet.add(new Employee(1002, "mike"));
		empTreeSet.add(new Employee(1003, "ralph"));
		empTreeSet.add(new Employee(1004, "jimmy"));
		empTreeSet.add(new Employee(1005, "xavier"));
		empTreeSet.add(new Employee(1006, "kk"));
		empTreeSet.add(new Employee(1089, "sam"));
		empTreeSet.add(new Employee(1012, "john"));
		empTreeSet.add(new Employee(1042, "john"));
		empTreeSet.add(new Employee(1234, "john"));

		Employee emp = new Employee();

		System.out.println(emp.highestSalary(empTreeSet));
		System.out.println(emp.lowestSalary(empTreeSet));
		System.out.println(emp.findGivenHigherSalary(empTreeSet, 1089));
		System.out.println(emp.findGivenLowerSalary(empTreeSet, 1000));
	}

}

// 1. find employee whose salary is greater than given salary
// 2. find employee whose salary is less than given salary
// 3.Create set of employee object sorted based on salary
// 4.Extract set from x to y
// 5.Find highest salary employee
// 6.Find lowest salary employee

class Employee {

	private int salary;
	private String name;

	public Employee(int salary, String name) {
		this.salary = salary;
		this.name = name;
	}

	public Employee() {
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String lowestSalary(Set<Employee> emp) {

		Iterator<Employee> itr = emp.iterator();
		String high = itr.next().getName(); // first element of the treeset ()
		/*
		 * while (itr.hasNext()){
		 * 
		 * 
		 * high = itr.next().toString();
		 * 
		 * }
		 */
		return high;

	}

	public String highestSalary(Set<Employee> emp) {

		Employee[] empArray = new Employee[emp.size()];
		// Employee[] empArray = emp.toArray() ;

		// converting the set into a array
		int i = 0;
		for (Employee e : emp) {
			empArray[i++] = e;
		}

		// since TreeSet is sorting in descending order the last employee has
		// the lowest salary
		String lowest = empArray[empArray.length - 1].getName();
		return lowest;

	}

	public Employee findGivenHigherSalary(Set<Employee> emp, int salary) {

		for (Employee e : emp) {
			if (e.getSalary() > salary) {

				return e;
			}
		}

		System.out.println("no salary is higher than the given salary");
		return null;

	}

	public Employee findGivenLowerSalary(Set<Employee> emp, int salary) {

		for (Employee e : emp) {
			if (e.getSalary() < salary) {

				return e;
			}
		}

		System.out.println("no salary is lower than the given salary");
		return null;

	}

	public Set<Employee> printSetByRange(int x, int y, Set<Employee> emp) {

		int range = 0;
		Set<Employee> tempEmp = new TreeSet<>(new EmployeeComparator());

		for (Employee e : emp) {

			if (range >= x && range <= y) {

				tempEmp.addAll(emp);
			}
		}

		return tempEmp;

	}

}

class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub

		if (o1.getSalary() > o2.getSalary())
			return 1;

		else if (o1.getSalary() == o2.getSalary())
			return 0;

		else
			return -1;
	}
}
