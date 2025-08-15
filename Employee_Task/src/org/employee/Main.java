package org.employee;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;

	public class Main {
	    public static void main(String[] args) {

	        // Step 3: Store multiple employees in ArrayList
	        ArrayList<Employee> employees = new ArrayList<>();
	        employees.add(new Employee("John", 30, 45000));
	        employees.add(new Employee("Alice", 25, 55000));
	        employees.add(new Employee("Bob", 28, 40000));
	        employees.add(new Employee("David", 35, 60000));

	        System.out.println("Original List:");
	        for (Employee e : employees) {
	            System.out.println(e);
	        }

	        // Step 4: Sort by salary (descending)
	        Collections.sort(employees, new Comparator<Employee>() {
	            @Override
	            public int compare(Employee e1, Employee e2) {
	                return Double.compare(e2.getSalary(), e1.getSalary()); // Descending
	            }
	        });

	        System.out.println("\nSorted by Salary (Descending):");
	        for (Employee e : employees) {
	            System.out.println(e);
	        }

	        // Step 5: Sort by name (ascending)
	        Collections.sort(employees, new Comparator<Employee>() {
	            @Override
	            public int compare(Employee e1, Employee e2) {
	                return e1.getName().compareToIgnoreCase(e2.getName()); // Ascending
	            }
	        });

	        System.out.println("\nSorted by Name (Ascending):");
	        for (Employee e : employees) {
	            System.out.println(e);
	        }
	    }
	}



