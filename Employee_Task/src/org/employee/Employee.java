package org.employee;

public class Employee {
	    private String name;
	    private int age;
	    private double salary;

	    // Constructor
	    public Employee(String name, int age, double salary) {
	        this.name = name;
	        this.age = age;
	        this.salary = salary;
	    }

	    // Getters (needed for sorting)
	    public String getName() {
	        return name;
	    }
	    public int getAge() {
	        return age;
	    }
	    public double getSalary() {
	        return salary;
	    }

	    // toString() for easy display
	    @Override
	    public String toString() {
	        return "Employee{Name='" + name + "', Age=" + age + ", Salary=" + salary + "}";
	    }
	}


